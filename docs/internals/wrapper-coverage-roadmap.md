# Wrapper Generator — Full Godot 4 Coverage Roadmap

Ordered plan to take the shared wrapper generator
(`scripts/generate_api_wrapper.py`) to full Godot 4 API coverage on all
three platforms (desktop, Android, iOS), and to retire the remaining
hand-written iOS surfaces in favor of generated, audit-validated code.

Each task carries a **model tag** for implementation sessions:

- **sonnet** — mechanical: an existing pattern is extended; audits/fixtures
  catch mistakes.
- **opus** — risky: new marshalling/ownership semantics, ABI widths, or
  C-side changes; mistakes corrupt memory or leak.
- **fable** — architectural: cross-cutting design decisions spanning
  generator, KSP, runtime, and multiple platforms.

## Where we are (June 2026)

| Surface | State |
|---|---|
| Desktop/Android generated methods | **15,265 / 16,822** (91%) — `scripts/api_wrapper_generator_report.py` |
| Skips: virtual `_*` callbacks | 1,437 (deliberate — needs the virtual-override feature, Phase 5) |
| Skips: hand-shaped (GodotObject root, RefCounted lifetime) | 51 (deliberate, stays hand-shaped) |
| Skips: unsupported helper shapes | ~60 (Array/Variant/Dictionary/RID/Packed* returns, `String+bitfield+int64` args, …) |
| Skips: Callable args | 6 (ownership-sensitive, needs design) |
| iOS | Same generator, gated by the **audited type set**; unaudited shapes skipped. 12 STUB / 10 HANDWRITTEN / 5 SUGAR marked sites (`ios-backend-handwritten.md`) |
| iOS script registration | Hand-rolled regex parser in `ios-runtime/build.gradle.kts` — a parallel, incomplete reimplementation of the KSP model |

"Full coverage" therefore decomposes into five ordered phases. Phases 1–2
are independent streams (can interleave); 3 depends on 2; 4 on 3; 5 is the
capstone.

---

## Phase 1 — Close the desktop/Android shape gaps (~60 methods)

Desktop is the reference implementation; iOS consumes whatever shapes the
generator learns here. Do this first.

| # | Task | Model | Notes |
|---|---|---|---|
| 1.1 | Add `CALL_SHAPES` for remaining scalar-ish combos (`String+bitfield+int64` args → enum return, void returns with odd arg mixes) | **sonnet** | Pattern fully established in `api_wrapper_candidates.py`; `check_wrapper_generator.py` fixtures + `audit_wrapper_signatures.py` gate it |
| 1.2 | Container-return shapes: `Array`, `Dictionary`, `TypedVector3iArray`, `PackedColorArray` returns | **opus** | New destroy-after-read ownership paths in `BuiltinTypes`; leak-prone |
| 1.3 | `Variant`-return and `RID`-return helper shapes | **opus** | Variant lifetime + RID is opaque-by-value; needs an ABI decision |
| 1.4 | `Callable` argument support (6 methods) | **fable** | Ownership-sensitive by policy (`OWNERSHIP_SENSITIVE_OBJECT_TYPES`); needs a design for Kotlin-lambda→Godot-Callable lifetime that also works on iOS later |

**Done when:** `api_wrapper_generator_report.py` skips contain only
virtual `_*` methods and deliberately hand-shaped entries; coverage page
regenerated via `api_wrapper_coverage.py --markdown --check` in CI.

## Phase 2 — Widen the iOS audited type set

Each task = generator kind (`IOS_ARG_KINDS` / `IOS_RET_KOTLIN`) **+**
self-test matrix row **+** ObjectCalls probe row **+** (value types) an
iOS `types/` struct. Never a kind without a matrix row — the ptrcall
width is the whole correctness story. Ordered by demo unblocking value
(see demo tier table in `ios-backend-roadmap.md`).

| # | Task | Model | Unblocks |
|---|---|---|---|
| 2.1 ✅ | `Vector2i` / `Vector3i` args+returns | **sonnet** | Match3 polish, City-Builder properties/signals |
| 2.2 ✅ | `Color` / `Rect2` returns | **sonnet** | `CanvasItem.modulate` get (removes a STUB) |
| 2.3 ✅ | String-return ptrcall (C-shim String→UTF-8 copy + destroy) | **opus** | `Label.text` get, `AnimationPlayer.getCurrentAnimation` live read — removes 2 STUBs + 2 SUGAR sites |
| 2.4 ✅ | `PT_STRING` / `PT_NODE_PATH` arg construction in `kanama_ios_shim.c` | **opus** | String/NodePath args generally; removes shim STUB |
| 2.5 ✅ | `Transform3D` / `Basis` args+returns | **opus** | FPS, third-person, squash-the-creeps demos; widest structs, `real_t`-sensitive |
| 2.5b ✅ | `RID` / `Quaternion` / `AABB` args+returns | **opus** | Third-person rotation, 3D culling, resource handles |
| 2.6 | `@ScriptProperty` value types (NodePath/Vector/Color delivery) | **sonnet** | Platformer `view: NodePath`; depends on 2.1–2.5 kinds. **Gated on Phase 3** — extends the regex parser Phase 3 retires |
| 2.7 | Variant / typed-array / vararg ptrcall on iOS | **opus** | Long tail; mirror Phase 1.2–1.3 desktop semantics |

**Status (2026-06-13):** 2.1–2.5 + RID/Quaternion/AABB all DONE and
device-validated (iPhone 12, iOS 26.5) — the full POD-passthrough + String/
StringName/NodePath audited set, with a fail-loud self-test matrix (23 C + 22
Kotlin rows, all green). `Plane` deferred: no clean arg+return on an emitted
class to anchor a self-test row. 2.6 is the next numbered item but is a
sequencing fork (regex parser vs Phase 3 KSP first) — see the tracker.

**Done when:** the audited-set skip report for the demo corpus is empty
for non-virtual methods; self-test matrix green on device.

## Phase 3 — Unify iOS script registration on the KSP model

The regex parser is the biggest drift risk and blocks annotation parity.
Do this *before* adding more annotations or bridge kinds — otherwise each
addition is implemented twice.

| # | Task | Model | Notes |
|---|---|---|---|
| 3.1 | Make the KSP processor emit a serialized, platform-neutral script model (classes, callbacks, signals, properties) consumable by the iOS build | **fable** | The architectural keystone: one source of truth for desktop/Android/iOS registration |
| 3.2 | Replace `parseIosScript` regex parser with the KSP model consumer | **opus** | Mechanical-ish once 3.1 lands, but touches codegen + C-shim dispatch wiring |
| 3.3 | Replace enumerated `IosScriptBridgeKind` with generated per-signature trampolines (multi-arg + value-arg signal payloads) | **fable** | Removes the "missing bridge kind" bug class (the platformer coin bug); C-shim `kanama_ios_script_instance_call` becomes generated |
| 3.4 | Wire remaining annotations (`@OnEnterTree`, `@OnInput`, `@OnUnhandledInput`, `@OnShortcutInput`, `@OnUnhandledKeyInput`, `@Rpc` parse-side) | **sonnet** | Trivial once 3.1–3.3 exist; today each is a manual `when` branch + warning |
| 3.5 | Non-object signal payloads through `kanama_ios_callable_trampoline` (per-arg variant type+value) | **sonnet** | Subsumed by 3.3 if trampolines are generated; otherwise standalone |

**Done when:** `IOS_UNWIRED_FUNCTION_ANNOTATIONS` is empty, the regex
parser is deleted, and a new annotation added to the KSP processor shows
up on iOS with zero iOS-specific code.

## Phase 4 — Retire hand-written iOS wrapper surfaces

With types (Phase 2) and registration (Phase 3) unified, eliminate the
remaining bespoke code paths.

| # | Task | Model | Notes |
|---|---|---|---|
| 4.1 | Wire `GodotObject.call` / `setDeferred` / `disconnect` / `connectBound` via the Variant Object dispatch path | **opus** | Removes 6 `IosGodotApi.kt` STUBs; needs Variant call C-shim entry |
| 4.2 | Generator custom-sections (stable insertion blocks in generated files) | **sonnet** | Eliminates the 5 fragile `KANAMA-IOS-SUGAR` re-add-after-regen blocks |
| 4.3 | `commonMain` sharing: `expect/actual ObjectCalls`, move generated wrappers out of `iosMain` copies | **fable** | Ends desktop/iOS wrapper drift permanently; touches the Gradle model of all targets |
| 4.4 | iOS `GodotReal` equivalent (centralize `real_t`; survive double-precision builds) | **sonnet** | Low priority while single-precision templates are the target |
| 4.5 | Shrink `IosGodotApi.kt` HANDWRITTEN to the truly-bespoke (coroutine scope, GD math helpers) and keep the registry honest | **sonnet** | `ios_handwritten_report.py` is the tracker; target: 0 STUB, ~6 HANDWRITTEN, 0 SUGAR |

**Done when:** `ios-backend-handwritten.md` shows **0 STUB / 0 SUGAR**;
remaining HANDWRITTEN entries are platform-inherent (coroutines, main
thread, math), not API coverage.

## Phase 5 — Virtual method coverage (the last 1,437 methods, all platforms)

The single biggest remaining surface: user-overridable engine virtuals
(`_get_render_target_size`, `_estimate_cost`, …) beyond today's fixed
lifecycle set. This is a *feature*, not a generator gap — it needs
extension-class virtual dispatch (`get_virtual_call_data` /
`call_virtual_with_data`) generalized to arbitrary signatures.

| # | Task | Model | Notes |
|---|---|---|---|
| 5.1 | Design: annotation surface (`@OverrideVirtual`?) + KSP emission of virtual dispatch tables keyed by interned StringName, per class | **fable** | Must work on JVM (Panama upcalls) and iOS (C-shim) from day one — design against the Phase 3 unified model |
| 5.2 | JVM implementation: generic virtual marshalling using Phase 1 shapes | **opus** | Hot path; reuse `PtrcallScratch`-style thread-locals, not per-call arenas |
| 5.3 | iOS implementation over the unified trampoline model | **opus** | Bounded by Phase 2 audited types |
| 5.4 | Coverage accounting: teach `api_wrapper_coverage.py` to track virtual coverage separately | **sonnet** | Keeps the "full coverage" claim measurable |

**Done when:** generator skip report is empty except the ~51 deliberately
hand-shaped methods; coverage page reads ≥99% with virtuals counted.

## Standing follow-ups (any time, independent)

| Task | Model | Source |
|---|---|---|
| Extend `PtrcallScratch` thread-local pattern across generated wrappers (replace ~1,478 per-call `Arena.ofConfined()`) | **sonnet** (generator change), **opus** review | Architecture review F3 |
| Single source of truth for the Godot version pin (Gradle property → CI, iOS template path, docs) | **sonnet** | Architecture review F4 |
| R8-minified APK smoke gate (validate `consumer-rules.pro`) | **opus** | Architecture review F2 |
| AVAudioSession category workaround in iOS shim (engine bug mitigation) | **sonnet** | ios-backend-roadmap |

## Sequencing summary

```
Phase 1 (desktop shapes) ──┐
                           ├─→ Phase 3 (KSP model) ─→ Phase 4 (retire handwritten) ─→ Phase 5 (virtuals)
Phase 2 (iOS types) ───────┘
```

Phases 1 and 2 interleave freely (different files, different sessions).
Phase 3 before any further annotation/bridge work — it halves the cost of
everything after it. Phase 5 last: it is the largest feature and benefits
from every unification before it.
