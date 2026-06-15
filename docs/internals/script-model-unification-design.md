# Unified Script Model — Design (Phase 3.1)

Design record for roadmap task 3.1 (`wrapper-coverage-roadmap.md`): make the
KSP processor emit a **serialized, platform-neutral script model** that the iOS
build consumes, so `@ScriptClass` registration has one source of truth instead
of two parsers that drift. This is the keystone for 3.2 (delete the regex
parser), 3.3 (generated trampolines), 3.4 (wire remaining annotations), and the
gate for 2.6 (`@ScriptProperty` value-type delivery).

## The problem: two parsers, derived independently from the same source

There are two completely separate front-ends that read the user's `@ScriptClass`
Kotlin and build a script model:

- **Desktop / Android — KSP.** `KanamaProcessor`
  (`processor/.../KanamaProcessor.kt`, ~2900 lines) runs during the JVM/Android
  Kotlin compile. It reads annotations via the KSP symbol API and builds a rich
  `ScriptModel` (`KanamaProcessor.kt:1173`): `ScriptPropertyModel` with full type
  info (object wrapper FQN, list element type, custom-script resource flags,
  export category/group/subgroup, hint/hintString, default literal),
  `VirtualModel`, `MethodModel` (+ `RpcModel`), `SignalModel` with typed
  `ArgModel`s. It emits Kotlin registrar source into
  `net.multigesture.kanama.generated` via `env.codeGenerator`.

- **iOS — a Gradle task with a regex parser.** `parseIosScript`
  (`ios-runtime/build.gradle.kts:187`, the file is 711 lines) is invoked by the
  `generateIosScriptRegistry` task (`:633`), which `walkTopDown()`s the user's
  `kotlin-src` and regex-matches `package`, `@ScriptClass(attachTo=…)`, `class`,
  `fun`, `var/val`. It builds a much thinner `IosScriptModel` (`:41`) →
  `IosScriptPropertyModel` (`:26`: just name, isObject, class name, isList,
  element class, nullable) and generates Kotlin bridges + `KanamaIosScript*`
  descriptors consumed by `KanamaIosRuntime`.

Both derive the model from the *same* `.kt` files, independently. Consequences:

1. **Every feature is implemented twice or silently no-ops on iOS.** The iOS
   side keeps a hand-maintained denylist `IOS_UNWIRED_FUNCTION_ANNOTATIONS`
   (`build.gradle.kts:179`: `@OnEnterTree`, `@OnUnhandledInput`,
   `@OnShortcutInput`, `@OnUnhandledKeyInput`, `@Rpc`, …) that only *warns* a
   used annotation is a no-op — it can't actually wire it.
2. **Value-type `@ScriptProperty` delivery is missing on iOS (blocks 2.6).** The
   regex parser warns and keeps the Kotlin default for NodePath/Vector/Color
   props (`build.gradle.kts:~282`) — it has no type fidelity to deliver them.
3. **Enumerated bridge kinds drop signatures (the platformer coin bug).**
   `IosScriptBridgeKind` (`build.gradle.kts:~15`) + `bridgeKindFor` (`:149`)
   enumerate a fixed set of call shapes; anything outside → `UNSUPPORTED` and the
   dispatch is silently skipped. (3.3 fixes this with generated trampolines.)
4. **The regex parser is inherently fragile** (multi-line signatures, default
   values, generics, comments) — a structural mismatch with KSP's real AST.

## What the iOS model lacks vs. the KSP `ScriptModel`

| KSP `ScriptModel` | iOS `IosScriptModel` |
|---|---|
| property type fidelity (TypeMapping, object wrapper FQN, list element, custom-script resource flags, hint/hintString/usage, **default literal**, export category/group/subgroup) | name + isObject + class name + isList + element class + nullable |
| `VirtualModel` (lifecycle + ptrcall arg conventions) | inferred from a fixed `when` over method names |
| `MethodModel` typed args + `RpcModel` | param *strings* + an enumerated `IosScriptBridgeKind` |
| `SignalModel` with typed `ArgModel`s | name only (`IosScriptSignalModel`) |
| tool buttons, `@GlobalClass` | — |

3.1 must produce a serialization rich enough to carry **all** of the KSP model so
the iOS consumer can reach parity (and 2.6/3.3/3.4 become iOS-free).

## Proposed: a serialized, platform-neutral model

Extract the annotation→model logic into a platform-neutral core and serialize
its output to a stable schema (JSON; human-diffable, trivially parsed by the
Gradle task, language-agnostic for any future consumer).

**Platform-neutrality is the key constraint.** Today's `ScriptModel` leaks
JVM/Panama detail: `ArgModel.readFromScratch` emits `MemorySegment`/`ADDRESS`
code, `TypeMapping` carries JVM ptrcall expressions. The serialized model must
describe *what the type is*, not *how the JVM marshals it* — each platform emitter
re-derives marshalling from the neutral type descriptor (iOS already has the
type machinery: the PT_* tags + `BuiltinCalls`/`ObjectCalls` from Phase 2 + items
9–13). Sketch:

```jsonc
{ "schemaVersion": 1,
  "scripts": [{
    "fqName": "com.game.Player", "simpleName": "Player",
    "resourcePath": "res://kotlin-src/Player.kt",
    "attachTo": "CharacterBody3D", "isTool": false, "isGlobalClass": false,
    "properties": [{
      "kotlinName": "view", "godotName": "view",
      "type": { "kind": "NODE_PATH" },            // neutral type descriptor
      "isMutable": true, "defaultLiteral": "NodePath(\"\")",
      "hint": 0, "hintString": "", "usage": 6,
      "export": { "group": null, "subgroup": null, "category": null }
    }],
    "methods": [{ "kotlinName": "onHit", "godotName": "on_hit",
      "kind": "REGULAR",
      "args": [{ "name": "amount", "type": { "kind": "INT" } }],
      "returnType": null, "rpc": null }],
    "virtuals": [{ "virtualName": "_ready", "kotlinMethodName": "ready", "args": [] }],
    "signals": [{ "godotName": "died", "args": [{ "name": "by", "type": { "kind": "OBJECT", "wrapper": "Node3D" } }] }],
    "toolButtons": []
  }]}
```

Type descriptor `kind` is the existing neutral enum (INT/FLOAT/BOOL/STRING/
NODE_PATH/VECTOR3/OBJECT/LIST/…); object/list carry a `wrapper`/`element`
class name; custom-script props carry the script FQN + `isResource`. This is a
1:1 serialization of `ScriptModel`/`ScriptPropertyModel` minus the JVM codegen
helpers.

## The real fork: *where* the model is produced for iOS

The JSON schema is the same regardless; the decision is **what runs the
annotation front-end for the iOS target.**

- **Option A — KSP emits JSON on the JVM/Android compile; the iOS Gradle task
  reads it.** Minimal new Gradle wiring; one KSP run. But the iOS build now
  depends on the JVM/Android script compile having run and on a stable artifact
  path inside the *user's* project, and an iOS-only build must still trigger it.
  Couples two pipelines that are otherwise independent.

- **Option B (recommended) — run the shared processor via KSP on the iOS
  (Kotlin/Native) source set too; it emits the JSON (and later the registrar)
  per-target.** KSP is multiplatform-capable; `generateIosScriptRegistry` is
  replaced by consuming KSP output. This is the only option that makes model
  derivation single-source on *every* platform and lets 3.2 delete the regex
  parser outright (the roadmap's "done when"). Cost: apply KSP to the KMP
  `iosMain`/native compilations and split `KanamaProcessor` into a
  platform-neutral *model builder* (annotation → serializable `ScriptModel`) +
  thin per-platform emitters. Heavier Gradle work up front, correct end state.

- **Option C — a standalone model-builder the Gradle task calls directly (no KSP
  on iOS).** Collapses to the regex problem unless it reuses a real Kotlin
  front-end; not viable without re-inventing KSP. Rejected.

**Recommendation: B.** A is a faster 3.1 but leaves two front-ends (KSP for the
model, regex still latent) and a cross-pipeline coupling; the roadmap explicitly
wants the regex parser *deleted*, which only B achieves cleanly. B also sets up
3.3 (generated trampolines emitted by the same processor) and Phase 5 virtuals
("design against the Phase 3 unified model").

## Migration & validation (low-risk landing)

1. **Refactor (no behavior change):** split `KanamaProcessor` into
   `model/` (annotation → `ScriptModel`, platform-neutral, no MemorySegment) and
   `emit-jvm/` (today's registrar codegen, consumes the model). Existing JVM
   output byte-identical — guard with the existing fixtures.
2. **3.1 deliverable:** add the JSON serializer + `schemaVersion`; emit it from
   the processor. Under Option B, apply KSP to the iOS source set so the model
   is produced there; under A, emit it as a JVM resource.
3. **Parallel-run gate:** for one release, keep `parseIosScript` AND the new
   model; assert the two `IosScriptModel`s are equal for the example/demo
   scripts (a build-time check, like the existing `check_*` gates). This catches
   schema/parse gaps before the regex parser is trusted to be gone.
4. **3.2:** point the iOS registry codegen at the deserialized model; delete
   `parseIosScript`, `IosScriptBridgeKind` heuristics, and
   `IOS_UNWIRED_FUNCTION_ANNOTATIONS`. **2.6 falls out for free** here — value-type
   props now carry full type descriptors, so NodePath/Vector/Color delivery is
   just an emitter case over the Phase-2 type machinery.
5. **3.3:** the emitter generates per-signature trampolines from `args` instead
   of mapping to a fixed `IosScriptBridgeKind`.

## Open decisions (need the user)

1. **Option A vs B** — where the model is produced for iOS (recommend **B**).
   This is the load-bearing call; it sets the Gradle work and whether the regex
   parser truly dies.
2. **Serialization format** — JSON (recommended: human-diffable, zero deps) vs a
   binary/`.proto`. JSON unless build-time parse cost matters (it won't at this
   scale).
3. **Schema-version policy** — fail-closed on mismatch (recommend) vs
   best-effort. With one repo producing and consuming, fail-closed is simplest.

## Scope note

3.1 is **design + the serialized model emission + parallel-run validation** — it
does NOT change iOS runtime behavior (3.2 does). Per roadmap it is tagged
**fable → Opus 4.8** (Fable unavailable since 2026-06-12). Model tags: 3.1/3.3
Opus, 3.2 Opus, 3.4 sonnet.
