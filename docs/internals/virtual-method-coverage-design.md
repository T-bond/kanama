# Virtual Method Coverage — Design (Phase 5.1)

Design record for roadmap task 5.1 (`wrapper-coverage-roadmap.md`): let a Kanama
`@ScriptClass` override **any** engine virtual its base class exposes, not just
the fixed lifecycle set. Tagged **fable → Opus 4.8** (Fable unavailable since
2026-06-12). Designed against the Phase 3 unified script model
([script-model-unification-design.md](./script-model-unification-design.md)).

5.1 is **design only** — no behavior change. 5.2 (JVM), 5.3 (iOS), 5.4 (coverage
accounting) implement it.

## What "virtual coverage" means here, and what it does *not*

The roadmap line ("1,437 methods … needs extension-class virtual dispatch
`get_virtual_call_data`/`call_virtual_with_data` generalized") conflates two
mechanisms. The correcting fact, from reading the code:

**Kanama instances are *scripts*, not registered extension classes.** A
`@ScriptClass` attaches to a stock Godot class (e.g. `CharacterBody3D`) via the
`ScriptLanguageExtension`/`ScriptInstanceExtension` surface. The engine reaches a
script's virtuals through the **script-instance callbacks** (`call_func`,
`has_method_func`, the method list, the notification callback), **not** through
`get_virtual_call_data`/`call_virtual_with_data` (those are for classes
registered with `classdb_register_extension_class*`). So 5.1 is *not* about
adopting the extension-class virtual table — it is about widening which methods
the script instance reports and dispatches.

`extension_api.json` defines **1,437 `is_virtual` methods** across classes, each
with a fully typed signature (args + return), e.g.:

```
CanvasItem._draw() -> void
Control._has_point(Vector2) -> bool
Control._get_minimum_size() -> Vector2
Control._get_tooltip(Vector2) -> String
Control._get_drag_data(Vector2) -> Variant
Control._structured_text_parser(Array, String) -> typedarray::Vector3i
```

Not all 1,437 are *script-overridable*: the engine only routes a virtual through
the script instance when its own C++ calls the script path for it (e.g.
`Control::_gui_input`, `CanvasItem` `NOTIFICATION_DRAW` → `_draw`,
`Node::_ready`/`_process`). Extension-class-only virtuals (e.g. servers,
`*Extension` base classes) are never delivered to a script instance. **The real
target set is "virtuals the engine dispatches to script instances on the
attach-to class + ancestors,"** a large subset of the 1,437. Enumerating it
precisely is an explicit task below.

## The mechanism already exists — the gap is *coverage*

A virtual override is mechanically almost identical to a `@RegisterFunction`
method: a name, typed args, a typed return. The registrar **already** generates
the full machinery for that, on both platforms:

- **Desktop** (`src/main/kotlin/binding/KanamaScriptInstance.kt`): the engine
  calls `call_func` → `dispatchCall(name, args, argCount, ret, error)` (Variant
  args in, Variant return written to `ret`), `has_method_func` →
  `dispatchHasMethod(name)`, plus `writeScriptMethodList`
  (`KanamaProcessor.kt:2325`) which reports each method's name **and return type**
  (`:2310`) to the engine. Return marshalling is real today —
  `MethodModel.returnType.writeToScratch(...)` + `variantFromType(...)`
  (`KanamaProcessor.kt:1977-1978`). Per-frame `_process`/`_physics_process` have a
  specialized non-Variant fast path (`dispatchProcess`/`dispatchPhysicsProcess`)
  purely for performance.
- **iOS** (`ios-runtime/.../ios/KanamaIosRuntime.kt`): `callV(methodName, args):
  Boolean` (`:57`, `:406`) is the generic per-signature inbound dispatch from
  3.3. It currently routes args in and reports handled/not; **return-value
  marshalling back to the engine is the one iOS-side gap** (today's iOS virtuals
  are void: `_process`, `_input`, tree notifications).

So the dispatch *capability* for arbitrary typed signatures is already built. The
reason a user can only override 12 virtuals today is purely **model coverage**:
the processor only mints a `VirtualModel` for 12 hard-coded annotations
(`KanamaProcessor.kt:263-277`: `@OnReady`→`_ready`, `@OnProcess`→`_process`
+`_physics_process`, `@OnInput`→`_input`+`_unhandled_input`+`_shortcut_input`, …).
Nothing reports `_draw` to `has_method`/the method list, so the engine never calls
it.

**Phase 5 reframed:** widen the model from 12 named virtuals to the full
script-overridable set, sourced from `extension_api.json`, and reuse the existing
`@Method`-style dispatch/return/method-list machinery — plus close the iOS
return-marshalling gap. This is meaningfully smaller than "the biggest remaining
feature"; the heavy lifting (typed dispatch, returns, method-list, the unified
model, generic per-signature trampolines) already shipped in Phases 2–4.

## Proposed design

### 1. Annotation surface (the load-bearing decision)

Three options; recommend **A**, optionally with **B** ergonomics.

- **A — explicit `@OverrideVirtual("_draw")`.** One new annotation; the argument
  is the engine virtual name. Unambiguous, greppable, and the canonical signature
  is resolved from `extension_api.json` (below) — the user's Kotlin params are
  *validated against* it, not trusted. Keeps the existing `@OnReady`/`@OnProcess`
  etc. as **sugar aliases** that desugar to `@OverrideVirtual("_ready")`… so no
  user-facing churn and the 12 lifecycle ergonomics stay.
- **B — name inference.** A Kotlin method whose name matches a known virtual of
  the attach-to class (`_draw`, or camelCase `draw`) is auto-bound. Lower
  ceremony, but ambiguous (collides with `@RegisterFunction` of the same name;
  silent if the name is slightly wrong). Best as an *optional convenience layer*
  over A, not the primary surface.
- **C — generated per-virtual marker annotations** (`@OnDraw`, `@OnGuiInput`, …
  for all 1,437). Rejected: annotation explosion, and it re-hard-codes the set the
  design is trying to make data-driven.

**Recommendation: A, with the lifecycle annotations retained as aliases.** B can
be layered later behind a flag.

### 2. Canonical signature source — a generated virtual-signature table

The processor today reads annotations, not `extension_api.json`. For arbitrary
virtuals it must know each virtual's canonical arg/return types (to emit correct
marshalling and to validate the user's method). Two ways:

- **(i) Trust the user's Kotlin signature.** Zero new infra, but a typo in a
  param type produces a silently mis-marshalled call (a footgun, and exactly the
  class of bug Phase 3.3 removed).
- **(ii, recommended) Generate a virtual-signature table from `extension_api.json`
  at build time** (the same input the wrapper generator already consumes), keyed
  by `class → {virtualName → (args[neutralType], returnType[neutralType],
  isScriptOverridable)}`, bundled as a processor resource. The processor resolves
  the attach-to class's virtual by name, **validates** the user's Kotlin signature
  against it (arity + neutral-type compatibility, fail-closed like the 3.1
  property-type resolution), and feeds the *canonical* types into the model so the
  emitter marshals exactly what the engine sends/expects.

(ii) makes `extension_api.json` the single source of truth for both wrappers and
virtuals, and is the only option that catches signature mistakes at compile time.

### 3. Model extension (platform-neutral, per Phase 3)

`VirtualModel` already exists in the serialized model
(`schemaVersion` JSON, `"virtuals": [{ "virtualName", "kotlinMethodName", "args"
}]`). Extend it to carry the full neutral signature so both emitters re-derive
marshalling:

```jsonc
"virtuals": [{
  "virtualName": "_get_drag_data",
  "kotlinMethodName": "getDragData",
  "args": [{ "name": "at_position", "type": { "kind": "VECTOR2" } }],
  "returnType": { "kind": "VARIANT" },
  "source": "engine"            // vs the lifecycle aliases
}]
```

This is a 1:1 superset of today's `VirtualModel` (which lacked `returnType` and
arbitrary args because the 12 were known). No schema fork — bump `schemaVersion`,
fail-closed on mismatch (the 3.1 policy).

### 4. Dispatch generalization (both platforms — reuse, don't reinvent)

The emitter treats an overridden virtual as a method whose name is the engine
virtual name:

- **Method list / has_method:** include overridden virtuals in
  `writeScriptMethodList` + `dispatchHasMethod` so the engine actually calls them.
  (For script instances this *is* the registration — there is no classdb step.)
- **Args + return:** reuse the existing `MethodModel` arg-unmarshal and
  `returnType.writeToScratch`/`variantFromType` return path. Desktop gets this for
  free via `dispatchCall`.
- **iOS:** extend `IosScriptCodeEmitter` (`processor/.../IosScriptCodeEmitter.kt`,
  the `VirtualModel.toIosMethod` fixed `when` at `:360`) to emit *all*
  script-overridable virtuals from the model rather than the hard-coded list, and
  **add return-value marshalling to `callV`** (the one new iOS runtime primitive —
  `callV` must write the engine return slot for value-returning virtuals, mirroring
  the desktop `ret` path).
- **Per-frame fast path:** keep `dispatchProcess`/`dispatchPhysicsProcess`. No
  other virtual is hot enough to need a non-Variant path in the first cut; revisit
  if profiling on a real demo shows otherwise (e.g. `_draw` on a heavily
  custom-drawn Control).

### 5. Coverage accounting (5.4)

Teach `scripts/api_wrapper_coverage.py` to track virtual coverage as a separate
axis (overridable-virtuals reported vs total script-overridable virtuals), so the
"full coverage" claim stays measurable and the skip report stops counting the
deliberately-unscripted virtuals as gaps.

## Migration & validation (low-risk landing)

1. **Refactor only:** add the generated virtual-signature table + extend
   `VirtualModel`; desugar the 12 lifecycle annotations to `@OverrideVirtual`. JVM
   registrar output for existing scripts stays byte-identical (guard with
   fixtures) — the 12 produce the same virtuals as today.
2. **5.2 (JVM):** flip the processor to mint `VirtualModel`s for any
   `@OverrideVirtual`; validate against the table; existing dispatch carries it.
   Add a demo that overrides a non-lifecycle virtual (e.g. `Control._gui_input` or
   `CanvasItem._draw`) and assert it fires.
3. **5.3 (iOS):** emit the broader set; implement `callV` return marshalling;
   **device-build check** — `ios_visual_smoke` on the iPhone, self-test matrix
   stays green, and a probe script overriding a value-returning virtual passes.
   (Flag the user before the device launch — the phone auto-locks.)
4. **5.4:** coverage page reads virtual coverage; roadmap "done when" = skip report
   empty except the ~51 deliberately hand-shaped methods.

## Open decisions (need the user)

1. **Annotation surface** — A (`@OverrideVirtual`, lifecycle aliases retained) vs
   A+B (also infer by name). Recommend **A**; B later behind a flag.
2. **Signature source** — generated virtual-signature table + validate
   (recommended) vs trust the user's Kotlin signature. Load-bearing for
   correctness.
3. **First-cut scope** — ship the *whole* script-overridable set at once, or a
   curated high-value subset first (`_draw`, `_gui_input`, `_get_configuration_warnings`,
   `_get_minimum_size`, `_get_drag_data`/`_can_drop_data`/`_drop_data`, `_input_event`)?
   Recommend a curated subset for 5.2/5.3 to validate the path on a demo, then
   widen — the model/dispatch is identical either way.
4. **Overridable-set derivation** — how to compute "script-overridable" from
   `extension_api.json` (it marks `is_virtual` but not "script-routed"). Options:
   start from `is_virtual` on `Node`/`CanvasItem`/`Control`/`Resource` subtrees and
   exclude `*Extension`/server bases; or maintain a small curated allow/deny on top
   of `is_virtual`. Needs a decision before 5.4 coverage accounting is meaningful.

## Scope note

5.1 is design only. The discovery above establishes that Phase 5 is mostly a
**coverage widening over already-built typed dispatch**, plus one new iOS
primitive (`callV` return marshalling) — not a new virtual-dispatch subsystem.
Implementation tags: 5.2 opus, 5.3 opus, 5.4 sonnet.
