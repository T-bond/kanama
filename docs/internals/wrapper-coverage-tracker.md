# Wrapper Coverage Roadmap — Progress Tracker

Live execution state for [wrapper-coverage-roadmap.md](./wrapper-coverage-roadmap.md).
Update this file in the same commit as the work it records, so any fresh
session can resume from here. Decision (2026-06-12): execute Phases 1–4;
Phase 5 starts only after iOS is stabilized and on par with desktop/Android
(Phase 4 exit: 0 STUB / 0 SUGAR).

## Status legend

`todo` · `in-progress` · `done` · `blocked(<reason>)`

## Execution workflow (decided 2026-06-12)

Each task is implemented by a subagent running the model the roadmap tags
(sonnet/opus/fable). **A fable agent reviews every diff before commit.**
Commits go straight to `main`, attributed `Co-Authored-By: Claude Fable 5`.

## Phase 1 — Desktop/Android shape gaps

| Task | Model | Status | Notes |
|---|---|---|---|
| 1.1 Scalar-combo CALL_SHAPES | sonnet | done | 2026-06-12: +19 shapes, +20 methods (15,265→15,285); fable-reviewed |
| 1.2 Container returns (Array/Dictionary/Typed*/Packed*) | opus | done | 2026-06-12: +6 shapes, +14 methods (→15,299); (Dictionary)→Dictionary policy-blocked by design; fable-reviewed |
| 1.3 Variant / RID returns | opus | done | 2026-06-12: +9 shapes, +14 methods (→15,313); typed-array args blocked (no init paths); fable-reviewed |
| 1.4 Callable argument design | fable | done | 2026-06-12: design doc + 3 helpers, +6 methods (→15,319); lambda→Callable deferred by design (callable-args-design.md) |

## Phase 2 — iOS audited type widening

| Task | Model | Status | Notes |
|---|---|---|---|
| 2.1 Vector2i / Vector3i | sonnet | done | 2026-06-12: kinds+matrix+probe rows; Sprite2D +3 methods; DEVICE-VALIDATED (item 1) |
| 2.2 Color / Rect2 returns | sonnet | done | 2026-06-12: kinds+tags+matrix+probe rows; CanvasItem +16 methods (incl. real get_modulate + 12 draw*), Control +4, GPUParticles2D +3, Sprite2D +3, Label/Viewport/CollisionShape3D/CollisionObject2D minor; STUB 12→11, SUGAR 5→3; fable-reviewed; DEVICE-VALIDATED (item 1) |
| 2.3 String-return ptrcall | opus | done | 2026-06-12/13: 2.3a String + 2.3b StringName no-arg getters; device-validated (items 2–3) |
| 2.4 PT_STRING / PT_NODE_PATH args | opus | done | 2026-06-13: String/NodePath args; Label.text full; device-validated (item 4) |
| 2.5 Transform3D / Basis | opus | done | 2026-06-13: POD float32 kinds (+RID/Quaternion/AABB, item 6); device-validated (item 5) |
| 2.6 @ScriptProperty value types | opus | done | 2026-06-15: value-type set-property DONE + device-validated end-to-end — scene `view: NodePath` reaches the Kotlin field on iPhone 12 (NodePath/Vector2/Vector3 C extraction + Kotlin decode + emitter; matrix C42/K47). Earlier "blocked on subsystem" was an export-drop confound (iOS-only probe not desktop-registered), not an iOS bug — see RESUME HERE |
| 2.7 Variant / typed-array / vararg | opus | done | 2026-06-20: **PHASE 2 COMPLETE** — all closeable emitted-class skips done + device-validated (OBJECTCALLS 78 / PTRCALL 54). Remaining ~151 skips are Phase-4 breadth (Object arg/return concrete classes not emitted) + Callable/vararg (deferred cross-platform). 2026-06-17: full value order. **2.7a Transform2D + 2.7b NodePath + 2.7c Packed* COMPLETE (returns Int32/Float32/Vector2/Color/String + Float32/Vector2/Color ARGS + all 7 CanvasItem.draw_*) DONE + device-validated** (PTRCALL 52 / OBJECTCALLS 63, +42 wrapper methods). 2.7c ABI gotchas (static gates / memories): Packed*Array slots 16 bytes on 64-bit; builtin scalar-float push_back arg is 8-byte double. **2.7d-1 Typed-object-array return (bool arg → Node.getChildren:List<Node>) DONE + device-validated (PTRCALL 53 / OBJECTCALLS 64).** Generator subsystem: typed-object-array detection now element-keyed (`typed_object_array_element_any` covers the dedicated `TypedNodeArray`-family kinds, not just `TypedObjectArray::X`); iOS remaps DIRECT List<Node> helpers → generic fromHandle helpers in `candidate_for`. **2.7d-2 No-arg shape DONE (emit-only/compile-validated, device regression-clean 53/64): +5 wrappers (Area2D/Area3D.get_overlapping_bodies/areas, PhysicsBody3D.get_collision_exceptions) via the one-line `ptrcallNoArgsRetTypedObjectList`→IOS_WIRED gate; get_gizmos/get_embedded_subwindows correctly stay skipped (elem wrappers not emitted).** **2.7d-3 find_children(String,String,bool,bool)→List<Node> DONE + device-validated (PTRCALL 54 / OBJECTCALLS 65) — first arg-bearing mixed-type typed-object-array return, self-tested; new generic `ptrcallWithTwoStringAndTwoBoolArgsRetTypedObjectList` (PT_STRING×2+PT_BOOL×2), no C/header change.** **2.7e Variant (scalar) returns DONE + device-validated (OBJECTCALLS 67, PTRCALL 54): +4 wrappers (CanvasItem/GeometryInstance3D.getInstanceShaderParameter, Node.getNodeRpcConfig, Viewport.guiGetDragData) routed through the proven Object-call decode (callWithVariantArgs) — `ptrcallNoArgsRetVariantScalar`/`ptrcallWithStringNameArgRetVariantScalar`, NO new C/header.** **2.7f-1+2.7f-2 arg-bearing string-family returns DONE + device-validated (OBJECTCALLS 70, PTRCALL 54): +7 wrappers (Control.getTooltip/getFocusNeighbor, Resource.getIdForPath, Node.atr/atrN/getPathTo, AnimationPlayer.animationGetNext) — String via callWithVariantArgs (no C), StringName/NodePath via a small object_call decode extension (no header).** **Named 2.7 sub-features (a–f) COMPLETE. 2.7g typed-builtin-array returns DONE + device-validated (OBJECTCALLS 75 / PTRCALL 54): +8 wrappers (List<String> get_groups/get_queue/get_animation_library_list, List<NodePath> Control.getAccessibility*Nodes ×4, List<Long> get_orphan_node_ids) via a new `ptrcall_no_args_ret_typed_array_blob` C helper.** **Residual: ~87 skips Phase-4 breadth (Object arg/return concrete classes not emitted); ~5 deferred long-tail (Projection needs Vector4, TypedPlaneArray needs Plane, generic Array→List<Any?> ×2, 2 Object-arg-blocked oddments).** Callable+vararg deferred. See RESUME HERE |

## Phase 3 — KSP model unification

| Task | Model | Status | Notes |
|---|---|---|---|
| 3.1 KSP platform-neutral script model | opus | done | 2026-06-15: KSP emits the serialized ScriptModel; iOS consumes it (keystone) |
| 3.2 iOS consumes KSP model (delete regex parser) | opus | done | 2026-06-15: regex parser deleted; KSP-on-iOS registry; device-validated |
| 3.3 Generated per-signature trampolines | opus | done | 2026-06-15: enumerated IosScriptBridgeKind replaced by generic PT-tagged callV; arg-bearing dispatch device-validated (matrix C42/K53); platformer coin bug class gone — see RESUME HERE |
| 3.4 Wire remaining annotations | opus | done | 2026-06-16: @OnEnterTree/@OnExitTree + @OnUnhandled/@OnShortcut/@OnUnhandledKeyInput wired (generic callV); @Rpc parse-side (config-delivery deferred); IOS_UNWIRED set now empty. **DEVICE-VALIDATED iPhone 12**: _enter_tree (notification path) + _unhandled_input (124 taps) dispatch, matrix 42/53 unchanged — see RESUME HERE |
| 3.5 Non-object signal payloads | sonnet | done | 2026-06-15: subsumed by 3.3 — value-arg signal payloads arrive as inbound callV, marshalled by type |

## Phase 4 — Retire hand-written iOS surfaces

| Task | Model | Status | Notes |
|---|---|---|---|
| 4.1 Variant Object dispatch (call/setDeferred/disconnect) | opus | done | 2026-06-18/19: **all 3 remaining STUBs cleared → STUB 3→0.** connectBound/disconnectBound (device-validated OBJECTCALLS 72) via the C bound-Callable path (`object_connect_bound`/`_disconnect_bound` → `Callable.bindv(Array)`; new `g_array_push_back`/`g_callable_bindv`; shared `kanama_ios_pt_arg_to_variant` + `encodeVariantArgs`). **SignalConnection.close DONE (device-validated OBJECTCALLS 73 / PTRCALL 54)**: `kanama_ios_godot_object_disconnect_callable` recreates the identity-equal custom Callable (no hash/equal funcs needed — Godot uses call_func+userdata as identity) + Object.disconnect; SignalConnection now carries owner/signal/callbackId. The earlier 5 STUBs were done pre-Phase-4. **STUB=0 / SUGAR=0 → Phase 4 exit condition met** |
| 4.2 Generator custom-sections (kill SUGAR) | sonnet | done | 2026-06-18: `IOS_CUSTOM_MEMBER_SECTIONS` registry (mirrors desktop `CUSTOM_MEMBER_SECTIONS`, gated to IOS_AUDIT_ONLY) emits the Node sugar (getTree/getNodeOrNull/getAsOrNull/requireAs/createTween) as a stable body custom-section. Node.kt now byte-identical to generator output → **regen is lossless, no more hand-re-apply**. `ios_handwritten_report`: **SUGAR 1→0** (STUB=3, HANDWRITTEN=10). Generator-only/structural (sugar source unchanged) → compile-validated, no device run needed |
| 4.3 commonMain + expect/actual ObjectCalls | fable | blocked(needs-decision) | 2026-06-19: ASSESSED — NOT a safe autonomous task. Desktop wrappers (1047 files) live in the **root** Gradle module; iOS (29) in the separate `:ios-runtime` KMP module. True commonMain unification = merge 1000+ desktop wrappers into a KMP jvm()+iosArm64() module and reconcile `java.lang.foreign` (desktop) vs `cinterop` (iOS) `ObjectCalls` via expect/actual — a multi-day cross-target migration. Needs a design + explicit user go-ahead |
| 4.4 iOS GodotReal centralization | sonnet | todo | low priority — pure double-precision future-proofing; single-precision is the target, so no current benefit |
| 4.5 Shrink IosGodotApi.kt HANDWRITTEN | sonnet | done | 2026-06-19: REVIEWED all 10 HANDWRITTEN — **every one is justified bespoke; 0 are API-coverage gaps** (the roadmap exit intent). Tagged each marker by category in `ios_handwritten_report`: **[platform]×5** (KanamaScope/MainThread/AutoCloseable.close/math/GD helpers), **[runtime]×2** (custom-Callable signal glue, Variant Tween path), **[glue]×3** (Input/ResourceLoader singletons + the IosGodot cinterop facade — each mixes real ptrcalls with bespoke ergonomics like nullable-Texture2D cursor / typed loadTexture2D, so not cleanly generatable). The numeric "~6" target was aspirational; the real exit (0 coverage-gap HANDWRITTEN, 0 STUB, 0 SUGAR) is met |

## Phase 5 — Virtual methods (deferred)

Gated on Phase 4 exit. Not started by decision.

## Standing follow-ups

| Task | Model | Status |
|---|---|---|
| PtrcallScratch across generated wrappers (review F3) | sonnet | todo |
| Single Godot version pin (review F4) | sonnet | todo |
| R8-minified APK smoke gate (review F2) | opus | todo |
| AVAudioSession workaround | sonnet | todo |
| Desktop wrapper drift: `src/main/.../Node.kt:145` `findChildren` calls `ptrcallWithTwoStringAndTwoBoolArgsRetObjectList` but `CALL_SHAPES` now names `...RetTypedNodeList` — pre-existing desktop staleness (noticed during 2.7d-3). Regenerate/reconcile desktop wrappers + sweep for other drifted typed-object-array shapes. **Sequenced after Phase 4** | sonnet | todo |

## RESUME HERE (updated 2026-06-15 — resume in Opus)

State: working tree CLEAN. Phase 1 (desktop/Android wrapper gaps) + Phase 2
iOS audited-kind widening BOTH complete and committed to main — 2.1 Vector2i/3i,
2.2 Color/Rect2, 2.3a/b String+StringName return, 2.4 String/NodePath args, 2.5
Transform3D/Basis, plus RID/Quaternion/AABB. PLUS the iOS Variant `Object.call`
dispatch (5 of the 8 IosGodotApi STUBs — call/set_deferred/disconnect/
set_custom_mouse_cursor/SignalConnection.error) PLUS the iOS value-type (builtin)
method call path (items 9–11 — Transform3D `inverse/affine_inverse/orthonormalized/
looking_at/interpolate_with/translated`, Basis `inverse/transposed/orthonormalized/
scaled/determinant`, Vector3 `cross/dot/is_normalized/max_axis_index`, Vector2
`rotated`, Quaternion `inverse` — incl. scalar `float`/`bool`/`int` returns). All
device-validated on iPhone 12 (iOS 26.5); self-test matrix is now 39 C + 44 Kotlin
rows, all green.
`Plane` deferred (no emitted-class test method to anchor a row). 3 STUBs remain
(deferred, see item 8): connectBound/disconnectBound (need `Callable.bindv`) and
SignalConnection.close (needs custom-Callable hash/equal + disconnect-callable).

**The clean POD-widening seam is exhausted.** The remaining work is bigger /
needs a decision (see the numbered items below + the roadmap backlog):
- **2.6** (`@ScriptProperty` value delivery — platformer `view: NodePath`) is
  **sequenced AFTER Phase 3 KSP unification** (USER DECISION 2026-06-15): it would
  extend the 711-line regex parser `parseIosScript` in `ios-runtime/build.gradle.kts`
  (today warns + keeps the Kotlin default for value-type props, ~line 282) that
  Phase 3.2 deletes. Marshalling primitives are ready; do Phase 3.1 (KSP emits a
  serialized platform-neutral script model) → 3.2, then 2.6 once, clean.
- **NEXT: Phase 3.1** — make the KSP processor emit the serialized script model the
  iOS build consumes (the architectural keystone). Then 3.2 retires the regex parser.
  **Design doc landed:** [script-model-unification-design.md](./script-model-unification-design.md).
  **USER DECISION 2026-06-15: Option B** (run the shared processor via KSP on the iOS
  native target — the path that deletes parseIosScript). 2.6 falls out of 3.2 for free.
  **In progress — DONE so far:** step 1a (model extracted into `ScriptModel.kt`,
  `bdee65f`); step 1b (ArgModel JVM codegen moved to emitter-side extensions, model is
  pure data, `357b2a8`); **JSON serializer + per-script emission** (`fb081b5`,
  `ScriptModelJson.kt` — zero-dep, SCHEMA_VERSION=1, emits `<Script>ScriptModel.script-model.json`
  next to each registrar). All byte-identical (registrar content sha unchanged across
  all three). Validated the JSON carries value-type fidelity the regex parser can't:
  DefaultProbeScript's `target: NodePath` → `"type":"NODE_PATH"` +
  `defaultLiteral "NodePath(\"../SceneTarget3D\")"`. **Processor now platform-aware**
  (`0735e99`): `emitJvmCode` gates the JVM registrars/aggregators; Native emits JSON only
  (JVM byte-identical). **Option B VALIDATED end-to-end (2026-06-15, wiring held for 3.2):**
  KSP applied to `ios-runtime` native targets ran the shared processor over example_project
  @ScriptClass sources → emitted JSON to `build/generated/ksp/iosArm64/…`; **zero `.kt`
  registrars on iOS** (gating correct) and the **iOS JSON byte-identical to the JVM JSON**
  (one source of truth). Caveat: 2 example scripts with object-typed ScriptProperties fail
  KSP on iOS (`unsupported type 'null'` — desktop wrappers don't resolve on K/N; a Phase
  2/4 type-unification concern). Wiring reverted from main (it gates every iOS build incl.
  the device path on KSP for no gain until 3.2). **REMAINING (3.2):** re-apply the KSP-on-iOS
  wiring + the JSON-consuming iOS registry codegen (replacing parseIosScript) + a device-build
  check + the parallel-run gate; then delete the regex parser (2.6 falls out free).
- **Phase 3.2 IN PROGRESS (2026-06-15, Opus).** Approach (b): processor's Native emitter
  generates the iOS registrar Kotlin directly. **Step 1 DONE (this commit):**
  `IosScriptCodeEmitter.kt` added to `:processor` — AGGREGATING emitter over `List<ScriptModel>`
  reproducing all three old `ios-runtime/build.gradle.kts` generators (`generateIosRegistrySource`
  + `generateIosGeneratedConstantsSource` + `generateIosCompatibilitySources`) byte-for-byte,
  with the rich→thin mapping: virtuals filtered to the wired set {_ready,_exit_tree,_process,
  _physics_process,_input} (others warn like IOS_UNWIRED), `bridgeKindFor` re-expressed over
  `ArgModel` types (objectWrapperFqName→OBJECT, VECTOR2I/FLOAT/INT→typed, else UNSUPPORTED),
  property classification from `objectWrapperFqName`/`type`/`arrayElementWrapperFqName`, `shortHash`
  /`kotlinString`/`constantIdentifier` copied verbatim for byte-match. Added `nullable: Boolean`
  to `ScriptPropertyModel` (populated from `resolvedType.nullability`; JVM emitter ignores it;
  serializer bumped to **SCHEMA_VERSION=2**, adds `"nullable"`) — needed so object-typed iOS
  `@ScriptProperty`s deliver `null` for a 0 handle only when the field is nullable. Emitter is
  compiled but NOT yet wired into the processor (no call site) — that lands in Step 2 with the
  KSP-on-iOS wiring + parallel-run gate. JVM registrar `.kt` output unchanged (ScriptCodeEmitter
  doesn't read `nullable`); `:processor:compileKotlin` + `:project-scripts:kspKotlin` green.
  Defaults taken (per design-doc open items): unresolved object-prop wrapper on K/N → skip+warn;
  gate comparison form → normalized text diff (emit iOS registry as `.kt.txt` resource so it
  doesn't compile/collide, diff vs regex output). **NEXT Step 2:** wire emitter into processor
  `finish()` on Native (needs script-roots as a KSP option to derive `res://…` resourcePath),
  re-apply KSP-on-iOS, add the parallel-run gate task. Then Step 3 cutover, Step 4 device
  (FLAG USER — phone auto-locks), Step 5 = 2.6.
- **Step 2 DONE — parallel-run gate GREEN (2026-06-15).** Wired the emitter into the processor
  `finish()` on Native: accumulates `IosScriptInput` per `@ScriptClass`, derives each `res://…`
  path from a new `kanamaScriptRoots` KSP option (relative to the configured script roots, with
  the `kotlin-src` rule), and emits the 3 aggregated iOS sources via `IosScriptCodeEmitter`. Gate
  phase emits them as `.kt.txt` RESOURCES (not compiled → no collision with the still-active
  regex registry). Added skip+warn degradation: on Native an unresolved `@ScriptProperty` type
  (desktop-only wrapper absent from the curated iosMain `api/` subset) is skipped with a warning
  instead of hard-failing the script (JVM still throws — real user error). Re-applied KSP-on-iOS
  in `ios-runtime/build.gradle.kts` (`id("com.google.devtools.ksp")` + `kspIosArm64`/
  `kspIosSimulatorArm64` → `:processor`, `ksp { arg("kanamaScriptRoots", …) }`, `kspKotlinIos*`
  dependsOn the regex codegen task). New `checkIosScriptRegistryParity` task normalized-diffs the
  KSP `.kt.txt` vs the regex `.kt`. New iOS-safe fixture
  `ios-runtime/src/iosScriptFixtures/kotlin-src/GateFixtureScript.kt` (ZERO/DOUBLE/OBJECT/LONG
  bridge kinds + zero-arg helper + scalar Long/String `@ScriptProperty` + `@Signal`). **Result:
  `parity OK (regex == KSP) for 2 files`** — both registries 78 lines, byte-identical after
  normalize; `res://kotlin-src/GateFixtureScript.kt` path + `shortHash` reproduced exactly. konan
  2.3.21 present; `kspKotlinIosArm64` runs host-side. `local_ci` does NOT build iOS native (only
  ios_visual_smoke does, with iOS-safe probes), so KSP-on-iOS adds no CI regression and the device
  path is unchanged until cutover. Run the gate with `-PkanamaIosProjectScriptsDirs=<repo>/
  ios-runtime/src/iosScriptFixtures/kotlin-src`. **NEXT Step 3 cutover:** flip the processor to
  emit real `.kt` (`kanamaIosRegistryAsResource=false`), delete `parseIosScript` +
  `generateIosScriptRegistry` + `IosScriptBridgeKind` + `IOS_UNWIRED_FUNCTION_ANNOTATIONS`, point
  iosMain srcDir at the KSP output. Then Step 4 device (FLAG USER), Step 5 = 2.6.
- **Step 3 DONE — cutover (2026-06-15), regex parser DELETED.** `ios-runtime/build.gradle.kts`
  rewritten to KSP-only: removed `parseIosScript`, `generateIosRegistrySource`/
  `generateIosGeneratedConstantsSource`/`generateIosCompatibilitySources`, all the `IosScript*`
  data classes + `IosScriptBridgeKind` + `bridgeKindFor` + `IOS_UNWIRED_FUNCTION_ANNOTATIONS`, the
  `generateIosProjectScriptRegistry` task, the `iosMain` regex srcDir, and the transitional
  `checkIosScriptRegistryParity` gate. Processor now emits real `.kt` (`kanamaIosRegistryAsResource
  =false`). **KMP structural fix (the one non-obvious thing):** KSP emits the registry into the
  per-target LEAF source sets (iosArm64Main/iosSimulatorArm64Main), which the shared iosMain
  `KanamaIosRuntime` cannot reference — so `registerKanamaIosProjectScripts()` is now an
  `expect` (hand-written in iosMain) / `actual` (generated per leaf) pair. The emitter emits
  `internal actual fun …`; the processor ALWAYS emits the registry (empty body when no
  @ScriptClass) so the expect is always satisfied. **Validated:** `:ios-runtime:compileKotlinIosArm64`
  (device target) GREEN with the gate fixture — the generated `.kt` registry links into the native
  lib. (Simulator target only fails on `cinteropKanama_iosIosSimulatorArm64` = `xcrun: unable to
  find xcodebuild` — environmental, command-line-tools dir vs full Xcode; ios_visual_smoke sets
  DEVELOPER_DIR. Unrelated to the change.) JVM path + processor still clean, no warnings.
  Constants/compat helpers stay leaf-only (probe scripts don't reference generated `*Names`/
  `*Signals`, so the shared-script→leaf-helper visibility gap doesn't bite the device path).
  **NEXT Step 4: device validation — FLAG USER FIRST (phone auto-locks).** Run ios_visual_smoke
  probes; confirm KSP-on-iOS registry drives the probe scripts + self-test matrix stays green
  (39 C / 44 Kotlin). **Device run attempted 2026-06-15 (iPhone 12, UDID 48DF9662…): cutover
  BUILD-VALIDATED end-to-end** — `kspKotlinIosArm64` emitted the registry as real `.kt`
  (`generated iOS @ScriptClass registry for 1 script(s) (asResource=false)`), Kotlin/Native +
  device xcframework + Godot export all succeeded, zero Kotlin/KSP/compile errors. **BLOCKED on
  Xcode signing only:** the app build failed with `No Accounts: Add a new account in Accounts
  settings` + `No profiles for net.multigesture.kanama.iosvisualsmoke` — no Apple ID registered in
  Xcode Accounts for automatic provisioning (environmental, not a Kanama regression; team
  BMB2Z6C76G personal). FIX: sign into Xcode → Settings → Accounts (laurence.muller@gmail.com),
  then re-run `scripts/ios_visual_smoke.sh --physical-device --device 48DF9662-42F3-541F-9F88-
  7FA2AB870F86 --development-team DVZT29Q4QT --allow-provisioning-updates --kanama-user-script-probe`
  to capture the on-device self-test matrix + the "Kanama iOS project script ready" line. The
  iOS-safe gate fixture is at `ios-runtime/src/iosScriptFixtures/kotlin-src/`.
- **Step 4 DONE — DEVICE-VALIDATED on iPhone 12 (2026-06-15).** `--kanama-user-script-probe` ran:
  `PTRCALL SELFTEST MATRIX: 39 passed, 0 failed` (C) + `OBJECTCALLS SELFTEST: 44 passed, 0 failed`
  (Kotlin) — matrix unchanged by the cutover. **The KSP-on-iOS registry drove the user script:**
  console shows `created script resource handle=1 path=res://kotlin-src/IosSmokeScript.kt
  base=Label methods=[_ready]` → `created script instance` → `project script method call …
  method=_ready` — i.e. the descriptor (path + baseType + methods) emitted by the processor's
  `registerKanamaIosProjectScripts()` registered correctly and `_ready` dispatched through the
  generated bridge. Two signing gotchas resolved: (1) Apple ID was logged out of Xcode (`No
  Accounts` → user signed in); (2) the correct Team ID is **`DVZT29Q4QT`** (the cert's **OU**
  field), NOT the CN parenthetical `BMB2Z6C76G` (a per-cert identifier) — `--development-team
  DVZT29Q4QT --allow-provisioning-updates` → `BUILD SUCCEEDED` → installed + launched. Console
  isn't streamed by the script's plain `devicectl process launch`; recapture with `xcrun devicectl
  device process launch --console --terminate-existing --device 48DF9662… <bundleid>`. **Phase 3.2
  steps 1–4 COMPLETE; regex parser dead, iOS registry unified on KSP, device-green.** Remaining:
  Step 5 = 2.6 value-type set-property path (scope corrected below — not free).
- **Step 5 (2.6) SCOPE CORRECTED — NOT "free", it's a value-type set-property path.** The design
  doc's "2.6 falls out for free as an emitter case" was optimistic: the model now carries full
  value-type fidelity (NODE_PATH/VECTOR3/COLOR…), and the emitter *could* generate the Kotlin-side
  construction, BUT the iOS C set-property callback `kanama_ios_script_instance_set_property`
  (`ios/bootstrap/kanama_ios_shim.c:4277`) only marshals OBJECT/INT/BOOL/FLOAT/STRING/ARRAY —
  value types fall through to `else → return 0` (undelivered). Delivering them needs the SAME kind
  of work as the value-type method machinery (items 9–13): (1) C cases that marshal the Variant
  value into a PT-tagged byte buffer + a new export `…set_property_value(handle, index, tag,
  bytes, len)`; (2) a Kotlin `setScriptInstancePropertyValue` + a new `KanamaIosScriptBridge.
  setPropertyValue(index, …)` default; (3) emitter `setPropertyValue` cases for value-type props
  (currently classified godotClassName="" → skip+warn); (4) self-test rows + device run. So 2.6 is
  a distinct ~multi-part feature to do AFTER the device confirms the Step 1–3 cutover (it also
  needs its own device validation). The emitter is already structured for it — the
  `toIosProperty` value-type branch is where the `setPropertyValue` classification slots in.
- **Step 5 (2.6) — value-type marshalling DONE + DEVICE-VALIDATED (2026-06-15); scene-driven
  delivery is a SEPARATE iOS subsystem, deferred.** Built + device-green on iPhone 12:
  (1) C `kanama_ios_script_instance_set_property` now marshals NODE_PATH/VECTOR2/VECTOR3/COLOR
  Variants → PT-tagged byte buffers via new variant_to converters + `String(from NodePath)` ctor
  → new export `kanama_ios_runtime_script_instance_set_property_value(handle,index,pt_tag,bytes,
  len)` (`kanama_ios.h`-style extern in the shim). (2) Kotlin `setScriptInstancePropertyValue`
  @CName + `decodeIosPropertyValue` (PT_NODE_PATH utf8→NodePath; PT_VECTOR2/3 float32→Vector2/3;
  PT_COLOR→Color) + `KanamaIosScriptBridge.setPropertyValue(index, value: Any)` default-false.
  (3) Emitter: `toIosProperty` classifies NODE_PATH/VECTOR2/VECTOR3 as value types
  (`valueTypeClassName`), generates a `setPropertyValue` override (`script.x = value as <T>`); JVM
  emitter untouched. (Color is not a `fqToTypeMapping` property type, so the C Color case is
  defensive-only.) Self-test rows: +3 C (`setprop-nodepath/vector2/vector3` round-trip the
  extraction primitives) +3 Kotlin (`setprop-decode(Vector2/Vector3/NodePath)`). **Device: matrix
  C 39→42, Kotlin 44→47, 0 failed** (commits `feat: iOS value-type @ScriptProperty set-property
  C path` / `… Kotlin runtime value-type … decode` / `… emitter setPropertyValue case`).
- **SCENE-DRIVEN DELIVERY WORKS — 2.6 DONE end-to-end + DEVICE-VALIDATED (2026-06-15).** The
  earlier "blocked on a subsystem" finding was a **test-harness confound, NOT an iOS bug.** The
  `--kanama-user-script-probe` `IosSmokeScript` was registered only for iOS (KSP); scene **export
  runs on desktop**, which therefore didn't know `view` was a property and **dropped
  `view = NodePath("../Background")` from the packed `.pck`** (verified: the NodePath value was
  absent from the binary scene). So there was never a value to deliver — `set_property` had nothing
  to fire on, which masqueraded as "the callback never works." Fix is purely test-side: also pass
  `-PkanamaProjectScriptsDir=<probe kotlin-src>` so `project-scripts` (the **desktop** jar)
  registers the probe — mirroring a real dual-target script (commit `test: dual-register iOS
  user-script probe …`). **Re-run on iPhone 12: `DIAG set_property called (index=0)` →
  `project script value-type property view=../Background`** — the NodePath flows scene → C
  marshalling → Kotlin decode → field. Matrix stays 42/47. **No `_get_script_property_list`
  Array<Dictionary> and no pending-set replay were needed** — Godot calls the instance
  `set_property` for scene-stored props directly (the instance `get_property_list` was not even
  consulted during scene load; it's still a correct GDExtension-contract improvement for the
  inspector and stays committed). **Net: scene-authored value-type `@ScriptProperty` (and by the
  same path OBJECT/INT/BOOL/FLOAT/STRING/ARRAY) deliver on iOS for any dual-target script.**
  **Lesson:** a script must be registered wherever it's USED — desktop for editor/export +
  scene-packing, iOS for runtime; an iOS-only `@ScriptClass` silently loses scene-authored
  property values at export. (A real `_get_script_property_list` Array<Dictionary> is still worth
  building eventually for the on-device inspector / `Object.get_property_list`, but it is NOT
  required for gameplay scene delivery — demote from blocker to nice-to-have.)
- **3.3 DONE + DEVICE-VALIDATED (2026-06-15) — generated per-signature inbound call; the
  "platformer coin bug" class is gone.** Replaced the enumerated `IosScriptBridgeKind` (ZERO/
  DOUBLE/OBJECT/OBJECT_OBJECT_LONG/VECTOR2I/LONG + UNSUPPORTED) with one generic PT-tagged path:
  (1) C `kanama_ios_script_instance_call` marshals every Variant arg into `arg_tags[]/arg_ptrs[]`
  (the inverse of `kanama_ios_godot_object_call`; INT/BOOL/FLOAT/STRING/NODE_PATH/VECTOR2/VECTOR2I/
  VECTOR3/COLOR/OBJECT, unaudited→PT_VOID) → new export `…_call_v(handle,index,tags,ptrs,argc)`.
  (2) Kotlin `decodeIosCallArg(tag,ptr)` + `…call_v` @CName + `KanamaIosScriptBridge.callV(name,
  args)`. (3) Emitter emits ONE `callV` override, one branch per method, each arg cast/wrapped by
  its declared type (`callArgExpr` over `ArgModel`); a method with an unaudited arg type is
  skip+warned (boundary is now "audited type", not "enumerated call shape"). Deleted
  `IosScriptBridgeKind`/`bridgeKindFor`/`objectArgType` + the five typed exports/bridge methods/C
  externs/runtime wrappers; `_input_event` is now a normal multi-arg method; `_ready` routes through
  `callV`. **Previously-UNSUPPORTED shapes now dispatch** — `GateFixtureScript` compile-covers
  `(Long,Double)`/`String`/`Vector3`/`NodePath`/`(Object,Object)`; the generated `callV` casts each
  correctly. **Device (iPhone 12): matrix C 42 / Kotlin 53** (+6 `callarg-decode` rows: Long/Bool/
  Double/Vector2i/Object/String) **0 failed**, `view=../Background` still delivered (2.6 no
  regression), and **`_process dispatched argc=1 delta>0=true`** — an arg-bearing FLOAT virtual
  dispatched end-to-end through the generic path (Godot → C PT-marshal → decode → `process(args[0]
  as Double)`). Returns stay nil (out of scope; the emitter knows `returnType` for a later phase).
  Commits: `feat: iOS generic per-signature inbound script call` (C) / `… Kotlin runtime generic
  callV + arg decode` / `… emitter generates per-signature callV; delete IosScriptBridgeKind` /
  `test: add arg-bearing _process probe`. **3.5 (non-object signal payloads) is subsumed** — a
  value-arg signal payload arrives as an inbound `callV` and now marshals by type.
- **3.4 DONE + DEVICE-VALIDATED on iPhone 12 (2026-06-16) — remaining lifecycle/input virtuals
  wired; the old IOS_UNWIRED_FUNCTION_ANNOTATIONS set is now empty.** Device run
  (`ios_visual_smoke --kanama-user-script-probe`, team DVZT29Q4QT): descriptor
  `methods=[_enter_tree,_ready,_process,_unhandled_input,_shortcut_input,_unhandled_key_input,
  _exit_tree]`; **`_enter_tree` dispatched via the notification path** (new); **`_unhandled_input`
  dispatched on screen tap** (124 calls — required `mouse_filter=2` on the probe scene Controls so
  the touch passes through to the Viewport unhandled-input path instead of being absorbed as GUI
  input); `view=../Background` (2.6) + arg-bearing `_process` intact; **PTRCALL 42/0 + OBJECTCALLS
  53/0, no regression**. The three new `set_process_*_input` binds configured without crashing
  (correct signature hash). `_shortcut_input`/`_unhandled_key_input` are key-event virtuals (need a
  paired hardware keyboard to fire) — register + enable proven; dispatch is the same generic path
  as the now-proven `_unhandled_input`. Probe commit `test: ios_visual_smoke probe exercises Phase
  3.4 virtuals on device`. Wired @OnEnterTree/@OnExitTree,
  @OnUnhandledInput/@OnShortcutInput/@OnUnhandledKeyInput, + @Rpc parse-side. The split that
  matters: **per-frame/input virtuals arrive via the script-instance `call` callback** (need the
  Node processing flag enabled), **tree virtuals arrive via the `notification` callback** (like
  `_ready`). (1) Emitter `VirtualModel.toIosMethod` wired set now lists all 9 virtuals — the
  generic callV dispatches each signature, so each is just a method-list + callV branch (verified
  in the generated registry: descriptor lists `_enter_tree/_exit_tree/_unhandled_input/
  _shortcut_input/_unhandled_key_input` + callV branches). (2) C shim:
  `configure_lifecycle_processing` now also enables `set_process_{unhandled,shortcut,
  unhandled_key}_input` (all share the `void(bool)` bind hash `2586408642` = `SET_PROCESS_INPUT_HASH`,
  the GDExtension method-bind hash is signature-derived not name-derived — verified vs
  extension_api.json); new `kanama_ios_script_instance_dispatch_tree_virtual` routes `_enter_tree`/
  `_exit_tree` through `call_v` (argc 0) on the ENTER_TREE/EXIT_TREE notifications (added
  `NOTIFICATION_EXIT_TREE=11`); **deleted the stale `_unhandled_input`→`_input` aliasing hack** in
  the call path (unhandled_input is now a real wired method). (3) iosMain annotations subset gained
  the missing OnUnhandled*/Shortcut*/Rpc/RpcMode/RpcTransferMode decls (the curated subset lacked
  them). (4) Gate fixture compile-covers the 5 new virtuals + an `@Rpc(@RegisterFunction)` method
  (`net_score`). @Rpc note: model captures RpcModel and the method stays dispatchable via callV, but
  **on-device `_get_rpc_config` delivery to Godot multiplayer is still NIL** (a later phase — the C
  virtual returns VARIANT_NIL); "parse-side" only. Gates green: clang -fsyntax-only,
  :processor:compileKotlin + JVM KSP, :ios-runtime:compileKotlinIosArm64 (device target) with the
  gate fixture, check_ios_no_silent_stubs, :processor:test. Commit `feat: iOS wire remaining
  lifecycle/input virtuals + @Rpc parse-side (Phase 3.4)`. **Device-validated 2026-06-16 (above).
  Phase 3 is essentially complete** (remaining iOS odds-and-ends: @Rpc `_get_rpc_config` delivery
  to Godot multiplayer; method RETURN values still nil; `_get_script_property_list` for the
  on-device inspector — all nice-to-haves, none blocking gameplay parity). **NEXT (parity-first
  goal 2): assess Android parity vs desktop.** *(Updated: user chose to finish Phase 2 (2.7) +
  Phase 4 + Phase 5 FIRST, then the Android parity assessment — see 2.7 below.)*
- **2.7 IN PROGRESS (2026-06-16) — finishing Phase 2 in value order before Phase 4/5 (user
  decision).** Measured the real gap with a per-emitted-class iOS skip report: 165 "un-audited
  shape" skips, but 75 are *peer-class* gaps (audited Object shape, concrete class not emitted —
  a Phase-4 breadth axis, NOT 2.7) and ~86 are true shape-gaps. Sub-features in value order:
  **(a) Transform2D** [DONE], (b) NodePath/StringName/String returns (~22) [2.7b NodePath DONE],
  (c) Packed*Array COMPLETE [returns + Float32/Vector2/Color ARGS + all 7 CanvasItem.draw_*],
  (d) Typed object arrays (~24, NEXT), (e) Variant (~10), (f) arg-bearing string-family returns (~23). **Callable (3) + vararg (4) stay
  DEFERRED to match desktop 1.4** (cross-platform policy, not an iOS gap). Method to add a value
  type: Kotlin `types/X.kt` + `IOS_ARG_KINDS`/`IOS_RET_KOTLIN` + `IOS_PT_TAG_VALUES` + a
  `ios_arg/ret_layout` case (POD passthrough → no per-type C code; the ptrcall `default` ships
  the buffer) + a C `KANAMA_IOS_PT_*` enum + a C self-test row + a Kotlin self-test row + regen
  the affected wrappers (skip SUGAR files — only Node has SUGAR now) + the Node3D fixture +
  device-validate. Reusable scratch report: `/tmp/ios27/skips.txt` (regen via the per-class
  `--ios-emit-class` loop; RTK rewrites `diff` so use python/`difflib` for additive checks).
  - **2.7a Transform2D DONE + DEVICE-VALIDATED (iPhone 12, 2026-06-16).** 6×float32 (columns x,
    y, origin — each Vector2; no column-major reshuffle, the columns ARE the axes). +20 wrapper
    methods (CanvasItem/CollisionObject2D/GPUParticles2D/Node2D/Viewport). Self-test rows:
    Node2D.set_transform → CanvasItem.get_transform round-trip (Node2D overrides get_transform to
    the local one). **PTRCALL 43/0 + OBJECTCALLS 54/0** on device. Commit `feat: iOS Transform2D
    arg+return audited type (Phase 2.7a)`.
  - **2.7b NodePath no-arg returns DONE + DEVICE-VALIDATED (iPhone 12, 2026-06-16).** Mirrors
    2.3a/2.3b: a dedicated C helper `kanama_ios_godot_ptrcall_no_args_ret_node_path` does the
    two-call length protocol (ptrcall → `String(from: NodePath)` ctor → `string_to_utf8_chars` →
    destruct; no GDExtension NodePath→utf8 exists), Kotlin `ptrcallNoArgsRetNodePath` wraps it back
    to NodePath. Generator: NodePath in IOS_RET_KOTLIN + IOS_HANDWRITTEN_HELPERS, gated to the
    no-arg getter only. +10 getters (AnimationMixer×2/AnimationPlayer/Area3D/Control×2/
    GPUParticles2D/3D/Node/Node3D; Node SUGAR re-applied). Self-test: GPUParticles2D.set_sub_emitter
    → get_sub_emitter. **PTRCALL 44/0 + OBJECTCALLS 55/0** on device. Commit `feat: iOS NodePath
    no-arg return audited type (Phase 2.7b)`. **Build gotcha:** changing `kanama_ios.h` invalidates
    the cinterop cache → `:ios-runtime:cinteropKanama_iosIosArm64` needs full Xcode; run gradle with
    `DEVELOPER_DIR=/Applications/Xcode.app/Contents/Developer` (command-line-tools alone fails).
  - **2.7c-1 PackedInt32Array no-arg return DONE + DEVICE-VALIDATED (iPhone 12, 2026-06-16).** First
    Packed*Array marshalling (a new variable-length read-back subsystem). Dedicated C helper
    `kanama_ios_godot_ptrcall_no_args_ret_packed_int32_array`: ptrcall → `size` builtin method →
    `operator_index_const` per element → destructor (two-call length protocol, count not bytes);
    Kotlin `ptrcallNoArgsRetPackedInt32List` (alloc IntArray + `List(count){buf[it]}`). Resolved a
    new globals trio lazily (`kanama_ios_cache_packed_int32_methods`): destructor via
    `variant_get_ptr_destructor(PACKED_INT32_ARRAY=30)`, size via `variant_get_ptr_builtin_method`
    (hash 3173160232 = same shape as Array.size), operator_index_const via
    `get_proc_address("packed_int32_array_operator_index_const")`. Generator: `List<Int>` in
    IOS_RET_KOTLIN + helper in IOS_HANDWRITTEN_HELPERS, gated to `ptrcallNoArgsRetPackedInt32List`
    only (the token is shared by arg-bearing PackedInt32 returns). +1 getter each on
    CollisionObject2D/3D (get_shape_owners; no SUGAR). Self-test (C + Kotlin):
    MeshLibrary.create_item(7)/create_item(11) → get_item_list()==[7,11]. **PTRCALL 45/0 +
    OBJECTCALLS 56/0** on device. Commit `feat: iOS PackedInt32Array no-arg return audited type
    (Phase 2.7c-1)`.
    **★ ABI GOTCHA (cost 5 device runs to find): a Packed\*Array return slot is NOT 8 bytes.**
    PackedInt32Array's opaque size is **16 bytes** in the 64-bit GDExtension ABI (per
    `extension_api.json` `builtin_class_sizes`, both `float_64` AND `double_64` — pointer-width-
    dependent, NOT the `precision=double` real_t option; PackedInt32Array holds no real_t). A
    `uint64_t` (8-byte) return slot — which worked for String/NodePath (genuinely 8 bytes on 64-bit)
    — overflows the stack and leaves a malformed CowData → SIGSEGV reading metadata at `ptr-16`
    INSIDE the ptrcall trampoline (`call_with_ptr_args_retc_helper<…,Vector<int>>`), not in your
    read-back. Fix: size the return slot from `builtin_class_sizes` (`uint64_t array_storage[2]`).
    **For the rest of 2.7c, look up each packed type's size first** — most Packed\*Array are 16 on
    64-bit; the real_t-bearing ones (PackedVector2/3/ColorArray) are also `precision`-sensitive.
    Triage lesson: a valid object whose String getter (get_class) works but whose Vector<int> getter
    crashes ⇒ a RETURN-marshalling/size bug, not a bad instance; physics/Control/Skeleton getters
    can't anchor the self-test (constructor/lazy-update segfault at init), but a plain Resource
    (MeshLibrary) can.
  - **★ GUARDRAIL ADDED (commit `guard: audit iOS shim Packed*Array ptrcall storage size`).** The
    16-byte mistake is now a static gate, not a device crash. `scripts/audit_builtin_storage_sizes.py`
    (already in `local_ci`) was extended to the iOS C shim: it asserts `KANAMA_IOS_PACKED_ARRAY_OPAQUE_SIZE`
    (16, from float_64 `builtin_class_sizes`) and requires every packed-named helper that invokes
    `g_object_method_bind_ptrcall` to size its slot via the `KANAMA_IOS_PACKED_ARRAY_STORAGE(name)` macro
    (comments stripped so a mention can't satisfy it; pass-by-pointer `out`/`ret` builders excluded).
    Verified it catches an injected 8-byte regression. Use the macro for every new packed helper.
  - **2.7c-2 PackedFloat32Array no-arg return DONE + DEVICE-VALIDATED (iPhone 12, 2026-06-17).**
    Exact mirror of 2.7c-1, float32 elements (`packed_float32_array_operator_index_const` → `const
    float*`, variant type 32). `ptrcallNoArgsRetPackedFloat32List` → `List<Float>`, gated to the
    no-arg getter. +1 getter on Label (get_tab_stops; read-only `val`, set_tab_stops arg path not yet
    wired). Self-test (C + Kotlin): fresh Gradient seeds default points → get_offsets()==[0.0,1.0].
    16-byte slot correct by construction (audit + macro — no 8-byte slip). **PTRCALL 46/0 + OBJECTCALLS
    57/0** on device. Commit `feat: iOS PackedFloat32Array no-arg return audited type (Phase 2.7c-2)`.
  - **2.7c-3 PackedVector2Array + PackedColorArray RETURNS DONE + DEVICE-VALIDATED (iPhone 12,
    2026-06-17).** Multi-float-element read-back: `ptrcallNoArgsRetPackedVector2List` (List<Vector2>,
    2 float32/elem) + `ptrcallNoArgsRetPackedColorList` (List<Color>, 4 float32/elem). Per-element
    floats via `packed_{vector2,color}_array_operator_index_const` (returns `GDExtensionTypePtr` →
    cast `const float*`); variant types 35/37; 16-byte storage via the macro. Elements are float32
    (iOS real_t single precision). **No wrapper files changed** — no emitted iOS class has a no-arg
    PackedVector2/Color getter (the emitted-class need for these is the ARG side, CanvasItem.draw_*);
    this lands the validated read-back capability + self-tests as a foundation. Self-test: Line2D.
    add_point×2 → get_points; fresh Gradient default colors → get_colors()==[black,white]. **PTRCALL
    46→48 + OBJECTCALLS 57→59** on device. Commit `feat: iOS PackedVector2Array + PackedColorArray
    returns (Phase 2.7c-3)`.
  - **2.7c-4 PackedFloat32Array ARG (build-from-list) DONE + DEVICE-VALIDATED (iPhone 12,
    2026-06-17).** First Packed*Array ARG path — the inverse of the read-back. C helper
    `kanama_ios_godot_ptrcall_with_packed_float32_arg` builds the array from a flat float buffer
    (default constructor index 0 + push_back per element), single-arg void ptrcall, destruct;
    Kotlin `ptrcallWithPackedFloat32ListArg` copies List<Float>→buffer. Generator: PackedFloat32Array
    in IOS_ARG_KINDS, gated to the single-arg void shape (`ptrcallWithPackedFloat32ListArg`; multi-arg
    draw_* share the kind, route through unbuilt helpers). **First emitted-class coverage gain in
    2.7c: Label.tabStops now read-write (setTabStops).** Self-test: Gradient.set_offsets([0.25,0.5,
    0.75])→get_offsets round-trip on a safe Resource (Label can't anchor — treeless Control segfault).
    **★ ABI quirk (cost 1 device run):** `push_back(value: float)` takes the scalar as an **8-byte
    double** in the ptr-ABI (Godot script float = double), though the array stores float32 — same as
    scalar-float ptrcall returns ([[ios_builtin_scalar_float_return_is_double]]). A 4-byte float
    pushed garbage (count right, values 0). Marshal the element as double. Guardrail broadened: the
    storage-size audit regex now matches any packed-named helper (was `…array`-only) so arg helpers
    (`…_packed_*_arg`) are covered; verified it catches an injected 8-byte regression in the arg
    helper. **PTRCALL 48→49 + OBJECTCALLS 59→60** on device. Commit `feat: iOS PackedFloat32Array arg
    build-from-list path (Phase 2.7c-4)`.
  - **2.7c-5 PackedStringArray RETURN DONE + DEVICE-VALIDATED (iPhone 12, 2026-06-17).** The
    variable-length packed read-back — each element is a Godot String, not fixed-width. C helper
    serializes into a length-prefixed blob `[count:int32][len:int32][utf8]...` (per element:
    `packed_string_array_operator_index_const` → String ptr → `string_to_utf8_chars`); two-call on
    total byte size. Kotlin `ptrcallNoArgsRetPackedStringList` decodes the blob (LE int32s) →
    List<String>. **Closes emitted AnimationMixer.getAnimationList. Packed RETURN family now COMPLETE**
    (Int32/Float32/Vector2/Color/String). Self-test: Translation.add_message×2 → get_message_list
    (order-independent set check). **PTRCALL 49→50 + OBJECTCALLS 60→61.** Commit `feat: iOS
    PackedStringArray no-arg return (Phase 2.7c-5)`.
    Scan finding: single-arg packed *setters* (Line2D.set_points, Gradient.set_colors, …) are all on
    NON-emitted classes, so single-arg arg helpers for Int32/Vector2/Color emit 0 wrappers — SKIP them.
    The emitted-class packed gaps are all CanvasItem.draw_polyline/draw_polyline_colors/draw_multiline/
    draw_multiline_colors/draw_polygon/draw_colored_polygon/draw_primitive (PackedVector2Array +
    PackedColorArray + Color/float/bool/Texture2D args).
  - **2.7c-6a generic-dispatch Packed*Array ARG BUILDING DONE + DEVICE-VALIDATED (iPhone 12,
    2026-06-17).** Extended the central `kanama_ios_godot_ptrcall` to build PackedVector2Array /
    PackedColorArray args inline: new `PT_PACKED_VECTOR2_ARRAY`/`PT_PACKED_COLOR_ARRAY` tags whose arg
    ptr is a `KanamaIosPackedArgDesc {count, data}` (flat float32 buffer, 2/elem Vector2, 4/elem Color
    — value types, NOT scalar-widened); dispatch constructs into a 16-byte `packed_cells[i]` (asserted)
    + destroys after. Resolved ctor+push_back for both. Kotlin `ptrcallWithPacked{Vector2,Color}ListArg`
    pack List→descriptor→generic dispatch. **draw_* can't be self-tested (no _draw context / no getter)**,
    so validated the BUILDING via single-arg setter round-trips: Line2D.set_points / Gradient.set_colors.
    **PTRCALL 50→52 + OBJECTCALLS 61→63.** Commit `feat: iOS generic dispatcher builds Packed*Array args
    (Phase 2.7c-6a)`.
  - **2.7c-6b CanvasItem.draw_* no-Object shapes DONE (iPhone 12 regression-clean, 2026-06-17).**
    Wired shapes A (Vec2,Color,float,bool → draw_polyline/draw_multiline) and B (Vec2,ColorArr,float,bool
    → draw_polyline_colors/draw_multiline_colors) onto 6a's building. Hand-written ObjectCalls helpers
    `ptrcallWithPackedVector2ListColor{,PackedColorList}DoubleAndBoolArgs` lay out arg_types/arg_ptrs
    (PT_PACKED_* {count,data} descriptors + PT_COLOR cell + PT_FLOAT64 width + PT_BOOL) → generic dispatch;
    shared `packVector2Desc`/`packColorDesc`/`colorCell`. Class-method `float` arg = PT_FLOAT64 (Double),
    confirmed vs existing ptrcallWithDoubleArg. Generator: PackedVector2Array/PackedColorArray in
    IOS_ARG_KINDS, gated to the 2 shapes. **+4 emitted CanvasItem wrappers.** draw_* can't be self-tested
    (no _draw context / no return) → compile+link-validated, ride on 6a's device-proven building. Matrix
    unchanged 52/63, 0 failed (regression check). Commit `feat: iOS CanvasItem.draw_* (no-Object shapes)
    via packed-arg dispatch (Phase 2.7c-6b)`.
  - **2.7c-6c Texture2D-arg draw_* shapes DONE — 2.7c COMPLETE (iPhone 12 regression-clean, 2026-06-17).**
    Wired C (Vec2,ColorArr,Vec2,Texture2D → draw_polygon/draw_primitive) + D (Vec2,Color,Vec2,Texture2D →
    draw_colored_polygon); the Object arg arrives as a MemorySegment handle (0 for null Texture2D), laid in
    a LongVar cell under PT_OBJECT. +3 emitted wrappers. **Only remaining emitted-class Packed skip is
    PackedScene.get_state()→SceneState (an OBJECT return, Phase-4 gap, not packed).** Matrix unchanged
    52/63. Commit `feat: iOS CanvasItem.draw_* Texture2D-arg shapes (Phase 2.7c-6c) — 2.7c COMPLETE`.
  - **2.7d-1 Typed-object-array return (bool arg) DONE + DEVICE-VALIDATED (iPhone 12, 2026-06-17).**
    **PTRCALL 52→53 + OBJECTCALLS 63→64, 0 failed.** nm confirms `T kanama_ios_godot_ptrcall_ret_object_array`
    defined in the deployed device xcframework `.a` + the cinterop wrapper bound. First typed-object-array return:
    the GENERATOR subsystem the rest of 2.7d builds on. Flagship emitted-class gain: **Node.getChildren(bool)
    → List<Node>**. C helper `kanama_ios_godot_ptrcall_ret_object_array(bind,inst,arg_types,arg_ptrs,argc,
    int64_t* out_handles,cap)` drives the call through the generic `kanama_ios_godot_ptrcall` with ret_out =
    an **8-byte** Array opaque slot (`uint64_t`, NOT the 16-byte Packed*Array storage — Array is an
    OPAQUE_8_BYTE_TYPE), then reads each element via the existing `g_array_size_method`/`g_array_get_method`
    + new `g_array_destructor` (= `variant_get_ptr_destructor(ARRAY=28)`, resolved in
    `kanama_ios_cache_array_methods`) + `g_variant_to_object`/`g_variant_get_type`/`g_variant_destroy` —
    the read-back pattern mirrors `kanama_ios_script_instance_set_property`'s ARRAY case (~line 5194, NOT
    4565). Two-call length protocol (re-ptrcall each call); non-Object elements → 0 handle. Kotlin GENERIC
    helper `fun <T> ptrcallWithBoolArgRetTypedObjectList(bind,inst,value,fromHandle:(MemorySegment)->T?)
    :List<T>` (+ a no-arg variant, dead until the no-arg gate opens) via a private `retTypedObjectList`
    core: lay out the bool arg, call C twice, `MemorySegment.ofAddress(handle)` → `fromHandle`, filter nulls.
    Both in IOS_HANDWRITTEN_HELPERS. Self-tests (C + Kotlin): parent Node + add_child×2 → get_children(false)
    == [c0,c1] (plain Node safe at init; identity fromHandle in the Kotlin one to compare addresses without
    importing api). **★ GENERATOR GOTCHA (the crux, cost the most time): typed-object-array returns come in
    TWO logical-kind families.** Node-family elements (Node/Node2D/Node3D/Material/Area2D/Area3D/BaseButton/
    PhysicsBody3D) get DEDICATED logical kinds (`TypedNodeArray`, …) whose CALL_SHAPES entry already has a
    CONCRETE `kotlin_return="List<Node>"` + a DIRECT helper (`ptrcallWithBoolArgRetTypedNodeList`); only OTHER
    object elements use the generic `TypedObjectArray::X` form with `kotlin_return="List"`. So `typed_object_
    array_element` (prefix-only) MISSES Node — added `typed_object_array_element_any` (NAMED_TYPED_OBJECT_
    ARRAY_KINDS map ∪ the prefix form) and key the gate/remap/fromHandle-append on the ELEMENT, not a "List"
    token. The remap lives in `candidate_for` (a thin wrapper over `_candidate_for_impl`) under IOS_AUDIT_ONLY
    — a SINGLE seam so the gate (`ios_method_supported`) and emission (line ~1521) stay consistent; it swaps
    the DIRECT helper → generic via `IOS_DIRECT_TO_GENERIC_TYPED_OBJECT_LIST`. Gate admits a typed-object-array
    return only when (remapped) `shape.function ∈ IOS_WIRED_TYPED_OBJECT_LIST_HELPERS` (currently just the
    bool-arg one) AND the element wrapper ∈ IOS_EMIT_CLASSES. `render_method` (~1100) appends `{wrapper}::
    fromHandle` for any non-DIRECT shape (now via `_any`) — so the remapped generic shape gets `Node::fromHandle`
    free; desktop/Android keep the direct List<Node> helpers (IOS_AUDIT_ONLY guards the remap). Regen touched
    ONLY Node.kt (+getChildren, additive; SUGAR re-applied by hand-editing the 2 hunks, never overwriting).
    ObjectCallsGenerated unchanged (helpers hand-written). Gates GREEN: clang -fsyntax-only, audit_builtin_
    storage_sizes (helper is non-packed → uses an 8-byte slot, audit not tripped), check_ios_no_silent_stubs,
    check_wrapper_generator, compileKotlinIosArm64 (cinterop regen — header changed → DEVELOPER_DIR=full Xcode).
    Build-shell gotcha: the env shell is zsh → `for c in $CLASSES` does NOT word-split; run the per-class regen
    loop via `bash -c '…'` (a single unsplit arg becomes one bogus `--ios-emit-class` and dies "not found").
  - **2.7d-2 No-arg typed-object-array return DONE (emit-only/compile-validated; device regression-clean iPhone 12, 2026-06-17).**
    One-line wiring: add `ptrcallNoArgsRetTypedObjectList` to `IOS_WIRED_TYPED_OBJECT_LIST_HELPERS` (both the C helper
    `kanama_ios_godot_ptrcall_ret_object_array` AND the Kotlin generic `ptrcallNoArgsRetTypedObjectList` already existed
    from 2.7d-1 — the no-arg Kotlin variant was written-but-dead until this gate opened). NO header/C change → cinterop
    UP-TO-DATE, plain compile. **+5 emitted wrappers / 3 classes**: `Area2D.getOverlappingBodies():List<Node2D>` +
    `getOverlappingAreas():List<Area2D>`, `Area3D.getOverlappingBodies():List<Node3D>` + `getOverlappingAreas():List<Area3D>`,
    `PhysicsBody3D.getCollisionExceptions():List<PhysicsBody3D>` — each via `ptrcallNoArgsRetTypedObjectList(…, {Elem}::fromHandle)`.
    Skip report 180→175 (exactly these 5). **`Node3D.get_gizmos()` (elem Node3DGizmo) + `Viewport.get_embedded_subwindows()`
    (elem Window) STAY SKIPPED — element wrappers NOT in IOS_EMIT_CLASSES; the gate (`if typed_array_element not in
    IOS_EMIT_CLASSES`) correctly blocks them.** Emit-only: physics bodies segfault if constructed at init + these getters
    return empty in a bare self-test, so they can't anchor a row; they ride on 2.7d-1's device-proven C read-back. Regen
    touched ONLY Area2D/Area3D/PhysicsBody3D (additive, +45 lines; Node.kt unchanged); ObjectCallsGenerated byte-identical.
    Gates GREEN (clang -fsyntax-only, audit_builtin_storage_sizes, check_ios_no_silent_stubs, check_wrapper_generator,
    compileKotlinIosArm64). **Device: PTRCALL 53 / OBJECTCALLS 64, 0 failed — regression-clean (matrix unchanged, as expected).**
    **NEXT: 2.7d-3 find_children (below).**
  - **2.7d-3 find_children (String,String,bool,bool)→Array[Node] DONE + DEVICE-VALIDATED (iPhone 12, 2026-06-17).**
    **PTRCALL 53→54 + OBJECTCALLS 64→65, 0 failed.** First ARG-BEARING-with-mixed-arg-types typed-object-array return on iOS
    (self-testable, unlike 2.7d-2). **No new CallShape needed** — `CALL_SHAPES[(("String","String","bool","bool"),"TypedNodeArray")]`
    already existed (direct `ptrcallWithTwoStringAndTwoBoolArgsRetTypedNodeList`→List<Node>); `_candidate_for_impl` falls through
    to `CALL_SHAPES.get(...)` for it. iOS wiring (followed the established direct→generic naming, NOT the prompt's tentative
    `StringStringTwoBool` name): added the DIRECT name to `DIRECT_TYPED_OBJECT_LIST_HELPERS` (desktop keeps the direct List<Node>
    helper, no fromHandle) + `IOS_DIRECT_TO_GENERIC_TYPED_OBJECT_LIST` (DIRECT→`ptrcallWithTwoStringAndTwoBoolArgsRetTypedObjectList`)
    + the GENERIC name to `IOS_WIRED_TYPED_OBJECT_LIST_HELPERS` + `IOS_HANDWRITTEN_HELPERS`. New hand-written Kotlin generic helper
    `ptrcallWithTwoStringAndTwoBoolArgsRetTypedObjectList<T>(bind,inst,first,second,firstBool,secondBool,fromHandle):List<T>` —
    lays PT_STRING×2 (pass `.cstr.ptr`; the C generic dispatcher builds+destroys the Godot String) + PT_BOOL×2 (uint8 cells)
    through the SAME `retTypedObjectList` core + existing C `kanama_ios_godot_ptrcall_ret_object_array` (**NO C function/header
    change** → cinterop UP-TO-DATE, plain compile; the `.c` self-test edit rebuilds with the xcframework). Gate path: candidate_for
    remaps DIRECT→generic under IOS_AUDIT_ONLY, element=Node ∈ IOS_EMIT_CLASSES, generic ∈ IOS_WIRED → emits; `render_method`
    appends `Node::fromHandle` (generic ∉ DIRECT set). Regen touched ONLY Node.kt (+findChildren, additive; SUGAR block re-applied
    by hand — 2 hunks: method after findChild + bind after findChildBind; NEVER overwrote Node.kt). ObjectCallsGenerated byte-identical.
    Self-tests (C + Kotlin, +1 row each): parent Node + 2 "Coin*" + 1 "Door" child (set_name StringName arg) → find_children("Coin*",
    "",recursive=true,owned=false) == [coin0,coin1] (owned=false so the unowned children match; "Door" filtered by name pattern).
    Gates GREEN (clang -fsyntax-only, audit_builtin_storage_sizes, check_ios_no_silent_stubs, check_wrapper_generator,
    compileKotlinIosArm64). Skip report 175→174. **NEXT: 2.7e Variant (below).**
  - **2.7e Variant (scalar) returns DONE + DEVICE-VALIDATED (iPhone 12, 2026-06-18).** **OBJECTCALLS 65→67 (PTRCALL stays
    54 — Kotlin-only, no new C), 0 failed.** Key insight: a Variant-returning method can be invoked through the ALREADY
    device-proven Object-call decode (`kanama_ios_godot_object_call` / Kotlin `callWithVariantArgs`) using the method's OWN
    method bind — it Variant-encodes the typed args, calls, and decodes the return Variant by type (bool/int/float/String/Object
    scalars; complex types → null, matching desktop `ptrcall*RetVariantScalar`). So iOS `ptrcallNoArgsRetVariantScalar(bind,inst)`
    + `ptrcallWithStringNameArgRetVariantScalar(bind,inst,name)` are thin Kotlin delegations to `callWithVariantArgs` — **NO new
    C function, NO header change** (cinterop UP-TO-DATE, plain compile). The generated wrapper call sites are byte-identical to
    desktop (same helper names); only the iOS *implementation* differs (routes through Object-call instead of a real ptrcall+decode).
    Generator: `"Any?"` added to IOS_RET_KOTLIN + a per-helper gate (admit only the two wired Variant helpers; other Variant
    arg-shapes share the "Any?" token but stay skipped) + both in IOS_HANDWRITTEN_HELPERS. **+4 emitted wrappers**:
    `CanvasItem`/`GeometryInstance3D.getInstanceShaderParameter(name):Any?` (StringName-arg), `Node.getNodeRpcConfig():Any?` +
    `Viewport.guiGetDragData():Any?` (no-arg). Regen touched CanvasItem/GeometryInstance3D/Viewport (additive) + Node.kt
    (+getNodeRpcConfig, SUGAR re-applied by hand). ObjectCallsGenerated byte-identical. Skip report 174→170. Self-test (Kotlin,
    +2 rows): Object.set_meta("kparam",1234) → get_meta("kparam") via the StringName-arg helper == 1234L (metadata stored on the
    Object — no tree/RS dependency; the Variant call honours get_meta's default 2nd arg so a 1-arg call round-trips; String→StringName
    coercion is what the Variant call path provides); plain Node.get_node_rpc_config() == null (empty Dictionary → scalar decode →
    null) for the no-arg helper. Gates GREEN. **NEXT: 2.7f arg-bearing string-family returns (below).**
  - **2.7f-1 + 2.7f-2 arg-bearing string-family returns DONE + DEVICE-VALIDATED (iPhone 12, 2026-06-18).**
    **OBJECTCALLS 67→70 (PTRCALL stays 54), 0 failed.** Same Object-call-decode insight as 2.7e, extended to String/
    StringName/NodePath returns. **2.7f-1 (String returns, NO C change):** the Object-call decode already returns a Kotlin String
    for a STRING Variant return, so arg-bearing String-returning methods route through `callWithVariantArgs` — helpers
    `ptrcallWithVector2ArgRetString`, `ptrcallWithStringArgRetString`, `ptrcallWithStringAndStringNameArgRetString`,
    `ptrcallWithStringStringNameIntStringNameArgsRetString` (each `callWithVariantArgs(...) as? String ?: ""`). +4 wrappers:
    `Control.getTooltip(Vector2)`, `Resource.getIdForPath(String)`, `Node.atr(String,StringName)` + `Node.atrN(...)`. Self-test:
    Node.atr("KanamaAtr","")=="KanamaAtr" (no TranslationServer → message unchanged). **2.7f-2 (StringName + NodePath returns, small
    C decode extension — NO header change):** extended `kanama_ios_godot_object_call`'s return decode with STRING_NAME (21) +
    NODE_PATH (22) cases (build String(from: StringName|NodePath) → utf8 into out_str; resolved a new `g_variant_to_string_name`),
    and `callWithVariantArgs` maps VT_STRING_NAME/VT_NODE_PATH → String (NodePath callers re-wrap). Helpers
    `ptrcallWithStringNameArgRetStringName`, `ptrcallWithLongArgRetNodePath`, `ptrcallWithObjectAndBoolArgRetNodePath`. +3 wrappers:
    `AnimationPlayer.animationGetNext(StringName)`, `Control.getFocusNeighbor(enum)`, `Node.getPathTo(Node,bool)`. Self-tests:
    parent.get_path_to(named child,false)==NodePath("KPathTarget") (NODE_PATH decode); animation_get_next("none")=="" (STRING_NAME
    decode). `ptrcallWithObjectArgRetStringName` (find_animation(Animation)) DEFERRED — Animation not an emitted wrapper, the Object-arg
    gate (concrete arg class ∈ IOS_EMIT_CLASSES) blocks it; wire when Animation lands. cinterop UP-TO-DATE (no header change; the
    .c decode rebuilds with the xcframework). Regen touched Control/Resource/AnimationPlayer (additive) + Node.kt (+atr/atrN/getPathTo,
    SUGAR re-applied by hand). ObjectCallsGenerated byte-identical. Skip report 170→163. Gates GREEN. **DONE + device-validated
    (PTRCALL 54 / OBJECTCALLS 70, 0 failed), committed + pushed.**
- **★ PHASE 2.7 NAMED SUB-FEATURES (a–f) COMPLETE (2026-06-18).** Session delivered 2.7d-2, 2.7d-3, 2.7e, 2.7f-1, 2.7f-2 — all
  device-validated on iPhone 12 (matrix grew PTRCALL 53→54, OBJECTCALLS 64→70). **Remaining iOS skips = 163, two buckets:**
  (1) **~87 Phase-4 breadth** — Object args/returns whose concrete class (Environment, CameraAttributes, Animation,
  AnimationLibrary, Window, Node3DGizmo, …) is NOT one of the 27 emitted iOS classes; the *marshalling* (Object arg/return) is
  already audited, so these light up by EMITTING MORE CLASSES (Phase 4 / breadth), not by new 2.7 marshalling. (2) **~15 true-2.7
  tail (a potential "2.7g")** — typed-builtin-array returns (`TypedNodePathArray`→List<NodePath>, `TypedStringNameArray`→List<String>,
  `TypedIntArray`→List<Long>, `TypedPlaneArray`→List<Plane>, `Array`→List<Any?> ×2), `Projection` (a POD audited-type addition like
  2.5 Transform3D/Basis), and a couple of misc arg-shape oddments (one `enum`-return, one `bool`-return). Typed-builtin-array returns
  would need a new variable-length C read-back subsystem (like 2.7c Packed*, header change); Projection is a clean POD add.
- **★ 2.7g typed-builtin-array returns DONE + DEVICE-VALIDATED (iPhone 12, 2026-06-19).**
  **OBJECTCALLS 73→75 / PTRCALL 54, 0 failed.** New C `kanama_ios_godot_ptrcall_no_args_ret_typed_array_blob(bind,inst,elem_kind,buf,cap)`:
  ptrcall → generic Array → for each element decode by `elem_kind` (INT→8-byte int64; STRING_NAME/NODE_PATH/STRING→utf8 via
  String(from: …)) into a `[int32 count]([int32 len][bytes])*` blob (two-call length protocol, like the Packed* helpers). Kotlin
  `retTypedArrayBlob` core (NOT inline — K/N forbids local funcs in inline) + 3 helpers `ptrcallNoArgsRetStringNameList`→List<String>,
  `ptrcallNoArgsRetNodePathList`→List<NodePath>, `ptrcallNoArgsRetLongList`→List<Long>. Generator: +`List<NodePath>`/`List<Long>` to
  IOS_RET_KOTLIN, 3 helpers to IOS_HANDWRITTEN, gates extended (List<String> now admits the StringName-array getter too; new
  List<NodePath>/List<Long> gates). **+8 wrappers**: AnimationMixer.getAnimationLibraryList, AnimationPlayer.getQueue, Node.getGroups
  (List<String>); Control.getAccessibility{Controls,DescribedBy,LabeledBy,FlowTo}Nodes (List<NodePath>); Node.getOrphanNodeIds
  (List<Long>). Skip 163→155. **Node.kt now regenerates LOSSLESS (4.2 custom-section) — copied wholesale, no hand-re-apply.** Header
  changed → cinterop regen. Self-tests (Kotlin, +2): add_to_group("kgrp")→get_groups()==["kgrp"]; orphan node's instance id ∈
  get_orphan_node_ids(). NodePath-array emit-only (Control treeless), rides on the shared blob (NodePath decode == StringName decode +
  wrap). Skip 163→155. **DEFERRED from 2.7g (need new value types / mixed decode): Projection (needs Vector4), TypedPlaneArray (needs
  Plane), generic Array→List<Any?> (×2, mixed-type), + 2 Object-arg-blocked scalar oddments (Phase-4 breadth).** These are the residual
  Phase-2 long tail; the high-value typed-array coverage is now closed.
- **★ 2.7h Projection + 2.7i Plane-array DONE + DEVICE-VALIDATED (iPhone 12, 2026-06-20).**
  **OBJECTCALLS 75→77 / PTRCALL 54, 0 failed.** New value types `Vector4` + `Projection` (4 Vector4 columns) + `Plane` (Vector3 normal + d).
  **2.7h Projection:** POD float32 return (16 floats, column-major) — the same generated POD-return path as Transform3D; new
  `KANAMA_IOS_PT_PROJECTION` tag appended at 25 (no Packed-tag renumbering), `ios_ret_layout` case, IOS_RET_KOTLIN += Projection,
  generated `ptrcallNoArgsRetProjection` (ObjectCallsGenerated + the Node3D fixture regenerated). **NO cinterop header change** (uses
  the existing generic ptrcall). +1 wrapper: `Camera3D.getCameraProjection()`. Self-test: smoke (16 finite floats — treeless camera
  values aren't deterministic, rides on Transform3D POD proof). **2.7i Plane-array:** extends the 2.7g typed-array blob with a
  `KANAMA_IOS_PT_PLANE` element branch (Plane = 4 float32 fixed 16-byte record; new `g_variant_to_plane` + `VARIANT_TYPE_PLANE=14`).
  Kotlin `ptrcallNoArgsRetPlaneList` (floatLE decode). +1 wrapper: `Camera3D.getFrustum():List<Plane>`. Self-test: smoke (treeless
  frustum is empty → exercises the size-0 path + record layout; Plane decode rides on the proven homogeneous-blob pattern). Skip
  155→153.
- **★ 2.7j generic Array→List<Any?> DONE + DEVICE-VALIDATED (iPhone 12, 2026-06-20).**
  **OBJECTCALLS 77→78 / PTRCALL 54, 0 failed.** New C `kanama_ios_godot_ptrcall_ret_variant_array_blob(bind,inst, arg_types,arg_ptrs,argc, buf,cap)`
  (args-passthrough via the generic ptrcall): ptrcall → Array → each element serialized SELF-DESCRIBING `[int32 variant_type][int32
  len][bytes]`; scalar elements decode (bool/int/float/object-handle/String|StringName|NodePath utf8), non-scalar (Dictionary, nested
  Array, …) keep their tag with len 0 → Kotlin null. Kotlin `retVariantArrayBlob` core + `ptrcallNoArgsRetArray` +
  `ptrcallWithNodePathArgRetArray` → List<Any?>. Generator: List<Any?> in IOS_RET_KOTLIN + 2 helpers in IOS_HANDWRITTEN + gate. **+2
  wrappers**: `Node.getNodeAndResource(NodePath)`, `Label.getStructuredTextBidiOverrideOptions()`. Header changed → cinterop regen.
  Skip 153→151. Self-test: parent.get_node_and_resource("Kid") == [childHandle, null, NodePath("")] (mixed Object/null/NodePath decode).
  Known limit: Dictionary/Array elements (e.g. get_structured_text's options) surface as null (scalar-decode philosophy, matches desktop).
  **★ THIS COMPLETES THE PHASE-2 TAIL.** Remaining iOS skips (~151) are all Phase-4 breadth (Object arg/return concrete classes not
  emitted) + Callable/vararg (deferred cross-platform). **NEXT: device-validate 2.7j → Phase 2 DONE → Phase 4.**
- **★ PHASE 4 BREADTH — BATCH 1 DONE + DEVICE-VALIDATED (iPhone 12, 2026-06-20, regression-clean 54/78).** Emitting more concrete
  classes (the ~151 skips are mostly Object args/returns whose concrete class wasn't emitted; the marshalling is already audited, so
  these light up by EMITTING the class — no new C). Batch 1 = 8 leaf `Resource` subclasses: **Material, Shape3D, Shape2D, Mesh,
  CameraAttributes, AnimationLibrary, StyleBox, Font** (all parent=Resource, emitted). Method: add to the `--ios-emit-class` set, regen,
  copy new wrappers + the newly-lit additive methods on existing classes (CanvasItem +96, GeometryInstance3D +48, Control +45, Camera3D/
  CollisionShape3D/GPUParticles2D +24, GPUParticles3D +42, AnimationMixer/CollisionObject2D/3D +18) + ObjectCallsGenerated (new generated
  helpers for the newly-lit shapes). +8 wrappers (~84 own methods) + the cross-ref methods. Emit-only (proven marshalling, no new C →
  cinterop UP-TO-DATE); device run is a REGRESSION check (matrix stays 54/78). Gates GREEN (audit, no_silent_stubs, check_wrapper_generator,
  compileKotlinIosArm64). **NEXT: device-validate batch 1; then larger breadth batches (Environment/Window/Animation/Theme/Image/CanvasLayer).**
- **★ PHASE 4 STARTED (2026-06-18). 4.2 DONE: SUGAR 1→0.** `IOS_CUSTOM_MEMBER_SECTIONS` registry emits the Node sugar as a stable
  generator body custom-section (mirrors desktop `CUSTOM_MEMBER_SECTIONS`, gated IOS_AUDIT_ONLY); Node.kt is now byte-identical to
  generator output (**regen lossless — the recurring hand-re-apply is gone**). Generator-only/structural, compile-validated, no device
  run. `ios_handwritten_report`: **STUB=3 · HANDWRITTEN=10 · SUGAR=0**. **Phase 4 remaining (all larger/riskier):** **4.1** the 3 STUBs
  (`IosGodotApi.connectBound`/`disconnectBound` need a `Callable.bindv(Array)` C helper over the bound args + Object.connect/disconnect
  with the bound Callable — header change, device-testable via a bound-signal round-trip; `SignalConnection.close` needs a custom
  GDExtension Callable with hash/equal to disconnect a lambda — the hardest). **4.3** commonMain `expect/actual ObjectCalls` (ends
  desktop/iOS wrapper drift but touches the Gradle model of all targets — high risk). **4.4** GodotReal centralization (low priority).
  **4.5** shrink IosGodotApi HANDWRITTEN toward ~6 (most of the 10 are platform-inherent: coroutines/main-thread/math/singletons).
  Phase-4 "done" = 0 STUB / 0 SUGAR → SUGAR done, 4.1's 3 STUBs remain.
- **★ 4.1 PARTIAL (2026-06-18): connectBound + disconnectBound DONE (STUB 3→1) + DEVICE-VALIDATED (iPhone 12, OBJECTCALLS 72 / PTRCALL 54, 0 failed).** New C bound-Callable
  path: `kanama_ios_godot_object_connect_bound`/`_disconnect_bound(object,signal,target,method, arg_tags,arg_ptrs,argc, [flags])`
  build `Callable(target,method)` then `.bindv(Array)` where the Array is the PT-tagged bound args pushed via `Array.push_back`, then
  Object.connect/disconnect with the bound Callable Variant. New globals `g_array_push_back` (Array.push_back hash 3316032543) +
  `g_callable_bindv` (Callable.bindv hash 3564560322), lazily resolved in `kanama_ios_cache_bound_callable_methods`. Refactor: the
  arg→Variant boxing in object_call extracted into shared `kanama_ios_pt_arg_to_variant`; the Kotlin List<Any?>→PT-tag layout in
  callWithVariantArgs extracted into shared `ObjectCalls.encodeVariantArgs` — both reused by the bound path. disconnect rebuilds the
  identical bound Callable (CallableCustomBound hashes base+args, so it matches). **Header changed → cinterop regen (full Xcode).**
  Self-test (Kotlin, +2 rows, EXPECT OBJECTCALLS 70→72 / PTRCALL 54): emitter.add_user_signal → connectBound to receiver.set_name
  bound "BoundName" → emit_signal → receiver.get_name()=="BoundName" (proves bound-arg delivery); then disconnectBound → rename
  receiver "Sentinel" → re-emit is a no-op → name stays "Sentinel". **Remaining STUB: `SignalConnection.close`** (4.1b — needs a custom
  GDExtension Callable with hash/equal to disconnect a lambda; the hardest, separate). **NEXT: device-validate 4.1a, then 4.1b or stop.**
- **★ 4.1b SignalConnection.close DONE → STUB 3→0 / SUGAR 0 = PHASE 4 "DONE" CONDITION MET (2026-06-19, DEVICE-VALIDATED OBJECTCALLS 73 / PTRCALL 54).**
  Turned out simpler than feared: GDExtension says when a custom Callable has NO hash/equal funcs, Godot uses (call_func,
  callable_userdata) as its identity. So `kanama_ios_godot_object_disconnect_callable(object,signal,callback_id)` just recreates a
  custom Callable with the SAME `kanama_ios_callable_trampoline` + callback_id userdata (identical to connect_callable) and calls
  Object.disconnect — it compares equal to the connected one, so Godot removes it. No custom hash/equal needed. free_func fires
  idempotently for both the removed original and the temp (IosCallableRegistry.release = HashMap.remove). `SignalConnection` now
  carries owner/signalName/callbackId; `close()` is guarded (no-op if connect failed or already closed). Header changed → cinterop
  regen. Self-test (Kotlin, +1 row, EXPECT OBJECTCALLS 72→73 / PTRCALL 54): register a lambda → connectCallable to a user signal →
  emit fires it once → objectDisconnectCallable → re-emit does NOT fire (counter stays 1). **`ios_handwritten_report`: STUB=0,
  HANDWRITTEN=10 (all platform-inherent: coroutines/main-thread/math/singletons), SUGAR=0 → Phase 4 exit condition (0 STUB / 0 SUGAR)
  MET.** Remaining Phase 4 tasks are quality/structure, not coverage: 4.3 commonMain expect/actual (high risk), 4.4 GodotReal (low
  priority), 4.5 trim HANDWRITTEN toward ~6.
- **★ PHASE 4 EFFECTIVELY COMPLETE (2026-06-19): 0 STUB / 0 SUGAR / 0 coverage-gap HANDWRITTEN.** 4.1 (all 3 STUBs) + 4.2 (SUGAR) +
  4.5 (HANDWRITTEN review — all 10 justified bespoke, category-tagged) DONE + validated. **4.3 BLOCKED(needs-decision)** — it's a
  multi-day cross-target module merge (desktop's 1047 root-module wrappers + iOS's `:ios-runtime` KMP module → one jvm()+iosArm64()
  commonMain with expect/actual ObjectCalls reconciling java.lang.foreign vs cinterop); too large/risky to do autonomously, needs a
  design + user go-ahead. **4.4 GodotReal centralization** is the only remaining safe code task but is pure double-precision
  future-proofing (no benefit while single-precision is the target). **NEXT (user decision): greenlight the 4.3 migration (with a
  design pass), do the deferred Phase-2 type-widening (Vector4/Plane → Projection + Plane arrays), Phase-4 breadth (emit more
  concrete classes → drains the ~87 skips), or Phase 5 virtuals.**
- Cleanly self-test-validatable items: ~~Variant `Object.call` dispatch~~ DONE
  (item 8); ~~value-type BuiltinTypes on iOS~~ DONE (items 9–11): no-arg + args
  shapes across Transform3D/Basis/Vector2/Vector3/Quaternion + scalar float/bool/int
  returns (items 12–13). The BuiltinCalls value-type seam is now broadly covered (add
  a hash + a `types/` method + 2 self-test rows for any further method). The four
  return widths are settled: value-type components = float32; scalar float = 8-byte
  double; bool = uint8; int = int64. **NEXT (per user 2026-06-15): Phase 3.1.**
- Each new audited kind = 1 iOS `types/` file + `ios_arg_layout`/`ios_ret_layout`
  case + 2 self-test rows (C+Kotlin) + regenerate + Node3D fixture refresh + a
  device run. ~30–60 min each. Two gotchas the hard way: do NOT `construct_object`
  a bare Control in the self-test (treeless Control segfaults in its post-init
  Theme lookup — use Node-family classes); and after a rebuild verify the new
  symbol is in the built `.a` (`nm`) separately from the device self-test count,
  since a stale install can pass with old counts.

1. **DONE: device validation (iPhone 12, iOS 26.5, 2026-06-12).** All 2.1/2.2
   rows **PASS** on device — `PTRCALL SELFTEST MATRIX: 14 passed, 0 failed`
   (C) + `OBJECTCALLS SELFTEST: 13 passed, 0 failed` (Kotlin), no construct-0
   notes. Per-row PASS (C + Kotlin each): Vector2i (Sprite2D.frame_coords 3,7
   after hframes/vframes widening), Vector3i (PlaceholderTexture3D.size
   5,11,17), Color (CanvasItem.modulate 0.125,0.25,0.5,0.75), Rect2
   (GPUParticles2D visibility_rect 1.5,2.5,3.5,4.5). Captured via
   `devicectl process launch --console` (script's devicectl launch does not
   stream app console; idevicesyslog is a noisy secondary). **2.6 unblocked.**
2. **DONE: 2.3a String-return ptrcall (device-validated 2026-06-12).** No-arg
   String getter wired: dedicated C helper `kanama_ios_godot_ptrcall_no_args_ret_string`
   (ptrcall→`string_to_utf8_chars`→destruct, two-call length protocol) +
   hand-written `ObjectCalls.ptrcallNoArgsRetString`. Generator: `"String"` in
   `IOS_RET_KOTLIN`, gated to the no-arg helper (`shape.function ==
   "ptrcallNoArgsRetString"`) so StringName + arg+String shapes stay out;
   `IOS_PROPERTY_SUPPRESS{("Label","text")}` lets the bespoke writable `var text`
   own the property (set_text String-arg still unbuilt). Label.text getter now
   real (`getText()`); 6 wrappers regenerated (Control/Resource/Node/Viewport/
   AnimationPlayer/Label) — additive String getters (getText/getTooltipText/
   getName/getPath/getSceneFilePath/getTreeString/…), SUGAR re-applied. Self-test
   `get_class==Node2D` PASS on device (C 14→15, Kotlin 13→14, 0 failed, no notes).
   STUB count 11→ (Label.text get cleared). Gates: check_wrapper_generator,
   check_ios_no_silent_stubs, compileKotlinIosArm64, clang -fsyntax-only — all pass.
3. **DONE: 2.3b StringName-return ptrcall (device-validated 2026-06-13).**
   Dedicated C helper `kanama_ios_godot_ptrcall_no_args_ret_string_name`: ptrcall →
   `String(from: StringName)` ctor (`variant_get_ptr_constructor(STRING, 2)`, since
   GDExtension has no StringName→utf8) → `string_to_utf8_chars` → destruct both;
   hand-written `ObjectCalls.ptrcallNoArgsRetStringName`. Generator gate relaxed to
   the two no-arg getters (`shape.function in {ptrcallNoArgsRetString,
   ptrcallNoArgsRetStringName}`). Real `AnimationPlayer.getCurrentAnimation()` now
   generated (SUGAR cache + `currentAnimationName` dropped); 6 wrappers regenerated
   (AnimationPlayer/Area2D/Area3D/Control/Label/Node) — additive StringName getters
   (getName/getCurrentAnimation/getAudioBusName/getThemeTypeVariation/… + `var`
   props). Self-test `Node.get_name==KanamaSN` PASS on device (C 15→16, Kotlin
   14→15, 0 failed, no notes). Gates: check_wrapper_generator,
   check_ios_no_silent_stubs (1 annotated site left), compileKotlinIosArm64,
   clang -fsyntax-only — all pass. Build/deploy gotcha: a clean
   ios_visual_smoke.sh rerun was needed — an earlier run left the prior xcframework
   installed on device (self-test showed stale counts); the new symbol presence in
   the built `.a` is the build-correctness check, device count is the deploy check.
4. **DONE: 2.4 PT_STRING/PT_NODE_PATH args (device-validated 2026-06-13).**
   Generic dispatch now constructs String + NodePath args from the C string (reusing
   the existing `init_string`/`init_node_path`); the arg cell array was generalized
   (`builtin_cells`, `constructed[i]` holds the tag → matching destructor). Generator:
   `String`/`NodePath` in `IOS_ARG_KINDS`, tags `PT_STRING=16`/`PT_NODE_PATH=17`, arg
   layouts (`{a}.cstr.ptr` / `{a}.path.cstr.ptr`), NodePath import. `IOS_PROPERTY_SUPPRESS`
   emptied — `Label.text` now fully generated (`var text`/`setText`/`getText`), SUGAR
   retired. 11 wrappers regenerated (new String/NodePath setters incl. AnimationMixer
   .setRootNode, Area3D.setWindSourcePath, GPUParticles2D/3D.setSubEmitter, Node3D
   .setVisibilityParent, Node.getNode/hasNode/findChild; many read-only `val`→`var`
   upgrades now setters work); Node SUGAR re-applied (`getNodeOrNull(String)` coexists
   with generated `getNodeOrNull(NodePath)`); Node3D fixture refreshed. Self-test rows
   Node.set/get_scene_file_path (String) + Node.get_node_or_null NodePath round-trip:
   device C 16→18, Kotlin 15→17, 0 failed, no notes. **Triage lesson:** first attempt
   crashed SIGSEGV in `construct_object("Label")` — a treeless Control segfaults in its
   post-init Theme lookup (`ThemeContext::get_themes()`), NOT a marshalling bug; fixed
   by exercising String args on `Node` instead. Don't construct bare Controls in the
   self-test. Gates: check_wrapper_generator (Node3D fixture updated),
   check_ios_no_silent_stubs, compileKotlinIosArm64, clang -fsyntax-only — all pass.
5. **DONE: 2.5 Transform3D/Basis kinds (device-validated 2026-06-13).** Both are
   POD passthrough (float32 components, no new C dispatch case, like Color/Rect2);
   enum tags `PT_BASIS=18`/`PT_TRANSFORM3D=19`. New minimal iOS `types/Basis.kt`
   (3 column axes) + `types/Transform3D.kt` (basis + origin), IDENTITY only — no
   BuiltinTypes value methods (variant calls still unwired on iOS). Generator: both
   in `IOS_ARG_KINDS`+`IOS_RET_KOTLIN`, `ios_arg_layout`/`ios_ret_layout` lay out
   Basis as 9 float32 column-major (`[x.x,y.x,z.x,x.y,…,z.z]`) and Transform3D as
   those 9 + 3 origin — matching the desktop Basis/Transform3D writeTo/readFrom
   exactly; Basis/Transform3D imports in the generated header. 5 wrappers regenerated
   (Node3D get/setTransform/Basis/global* + `var transform/basis/global*`, Camera3D
   .getCameraTransform, CollisionObject3D.shapeOwnerGet/SetTransform,
   GPUParticles3D.emitParticle; Node net-unchanged). Self-test: Node3D
   set_transform→get_transform (12 floats) + set_basis→get_basis (9 floats), exact
   float32 diagonal values. Device C 18→20, Kotlin 17→19, 0 failed, no notes. Node3D
   fixture refreshed. Gates: check_wrapper_generator, check_ios_no_silent_stubs,
   compileKotlinIosArm64, clang -fsyntax-only — all pass.
6. **DONE: RID/Quaternion/AABB kinds (device-validated 2026-06-13).** POD
   passthrough additions (no new C dispatch case): RID = uint64 (`PT_RID=14`,
   pre-existing tag), Quaternion = 4 float32 `[x,y,z,w]` (`PT_QUATERNION=20`),
   AABB = 6 float32 (position+size) (`PT_AABB=21`). New iOS `types/RID.kt`
   (`@JvmInline value class`), `types/Quaternion.kt`, `types/AABB.kt`. Generator: all
   three in `IOS_ARG_KINDS`+`IOS_RET_KOTLIN`, tag values, arg/ret layouts, generated-
   header imports. 13 wrappers regenerated (Node3D quaternion, GeometryInstance3D
   customAabb, VisualInstance3D base/instance RID getters/setters, Camera3D rids,
   etc.; Node SUGAR re-applied). Self-test (Node3D set/get_quaternion ε=1e-4 since
   Godot re-derives via basis; GPUParticles3D get/set_base RID round-trip;
   GPUParticles3D set/get_custom_aabb exact): device C 20→23, Kotlin 19→22, 0 failed,
   no notes. Node3D fixture refreshed. Gates all pass. **Plane deferred** — no clean
   arg+return method on an emitted class to anchor a matrix row (the rule: never a
   kind without a self-test row); revisit if a demo needs it.
7. **NEXT:** 2.6 proper (`@ScriptProperty` value-type delivery — NodePath/Vector/
   Color to Kotlin script instances; unblocks platformer `view: NodePath`) requires
   extending the regex annotation parser the roadmap flags for Phase-3 KSP
   replacement first — sequencing decision pending. Other gaps: String-arg signal
   payloads, custom-Callable lambdas, TypedArray ARGS, value-type BuiltinTypes on iOS.
8. **DONE: Variant `Object.call` dispatch (device-validated 2026-06-14).** New generic
   C entry `kanama_ios_godot_object_call(method_bind, instance, arg_tags[], arg_ptrs[],
   argc, out_int, out_double, out_str/size/len)` boxes PT-tagged args into Variants via
   `object_method_bind_call` (the varargs/dynamic path ptrcall can't express) and decodes
   a SCALAR return (nil/bool/int/float/String/Object); resolves `g_variant_from_bool`/
   `g_variant_from_string`. Plus `kanama_ios_godot_object_disconnect` (object+method
   Callable, symmetric to the existing `object_connect`) + a static `is_connected`
   self-test helper. Kotlin: hand-written `ObjectCalls.callWithVariantArgs(bind, instance,
   List<Any?>)` (mirrors desktop) marshals Any?→PT tag+payload and decodes the return.
   Cleared **5 of the 8 IosGodotApi STUBs**: `GodotObject.call` (Object.call),
   `setDeferred` (Object.set_deferred), `disconnect` (Object.disconnect),
   `Input.setCustomMouseCursor` (Input.set_custom_mouse_cursor — Object/int/Vector2 args),
   `SignalConnection.error` (plumbed the real connect-callable result). Self-test: +3 C
   rows (Object.call get_class→String, set_meta/get_meta int value+return, connect→
   disconnect via is_connected) +6 Kotlin rows (callWithVariantArgs string-arg, string/int/
   bool returns, set_meta/get_meta int + object value+return). Device C 23→26, Kotlin
   22→28, 0 failed, no notes. **3 STUBs deferred** (a distinct feature — bound/custom
   Callables, beyond Object.call): `connectBound`/`disconnectBound` need
   `Callable.bindv(Array)`; `SignalConnection.close` needs custom-Callable hash/equal +
   a disconnect-callable C path (the custom callable is created with no identity today, so
   it can't be matched for disconnect). Gates: check_wrapper_generator,
   check_ios_no_silent_stubs (3 annotated STUBs left), compileKotlinIosArm64,
   clang -fsyntax-only — all pass.
9. **DONE: iOS value-type (builtin) method call path (device-validated 2026-06-14).**
   The value-type analogue of ObjectCalls/ptrcall — engine-computed builtin methods on
   Variant value types. New C `kanama_ios_godot_get_builtin_method(variant_type, method,
   hash)` (wraps `variant_get_ptr_builtin_method`; the hash keys the signature SHAPE — all
   no-arg→Self methods on a type share one — and the StringName selects the method) +
   `kanama_ios_godot_builtin_call(method_ptr, base, arg_tags[], arg_ptrs[], argc, ret_out)`
   (calls `method(base, args, ret, argc)` with raw value byte buffers; args raw-typed like
   ptrcall). Kotlin: new `BuiltinCalls` object (`getBuiltinMethod` + `callNoArgsFloat32`,
   mirrors desktop `BuiltinTypes`). Wired `Transform3D.inverse()` + `Basis.inverse()` into
   the iOS `types/` files (column-major float32 layout, same as the ObjectCalls ptrcall
   helpers). Self-test: +2 C rows, +2 Kotlin rows — `Basis.inverse()` diag(2,4,8)→
   diag(0.5,0.25,0.125) (true inverse) and `Transform3D.inverse()` diag(2,4,8)+origin(1,2,3)
   →diag(2,4,8)+origin(-2,-8,-24) (Godot's inverse assumes orthonormal: transposes the basis
   + re-derives origin — `affine_inverse` is the full inverse, not yet wired). Device C 26→28,
   Kotlin 28→30, 0 failed. Gates: check_wrapper_generator, check_ios_no_silent_stubs,
   compileKotlinIosArm64, clang -fsyntax-only — all pass. Extend the same way for more value
   methods (affine_inverse/looking_at/interpolate_with/Vector ops).
10. **DONE: value-type builtin methods widened — args path (device-validated 2026-06-15).**
   Generalized `BuiltinCalls` with a `call(methodPtr, base, retCount, args)` that takes a
   `BArg` list (`Floats(tag, FloatArray)` / `Bool` / `Real`) so builtin methods can take
   args (the C `kanama_ios_godot_builtin_call` already handled tagged args). Wired
   `Transform3D.affineInverse/orthonormalized/lookingAt(Vector3,Vector3,bool)/
   interpolateWith(Transform3D,double)` + `Basis.transposed/orthonormalized`. Self-test:
   +2 C rows (looking_at arg path PT_VECTOR3×2+PT_BOOL; interpolate_with PT_TRANSFORM3D+
   PT_FLOAT64) +5 Kotlin rows. Device C 28→30, Kotlin 30→35, 0 failed. **Gotcha:** the
   Kotlin `lookingAt` row first FAILED while the C row PASSED — `looking_at`'s cross
   products return `-0.0` in some zero slots; C `==0` is true (IEEE) but Kotlin data-class
   equality uses `Double.equals` where `-0.0 != 0.0`. The marshalling was correct; fixed by
   comparing components with `==` (numeric) instead of data-class `==`. Gates all pass.
11. **DONE: value-type builtin methods widened — Vector ops + new variant types
   (device-validated 2026-06-15).** Added `KANAMA_IOS_VARIANT_TYPE_VECTOR3=9`/
   `QUATERNION=15` to the C shim + `BuiltinCalls` VT_VECTOR2/VECTOR3/QUATERNION +
   PT_VECTOR2/QUATERNION constants. Wired 5 engine-computed methods via the existing
   generic `get_builtin_method`/`builtin_call` path: `Vector3.cross(Vector3)`,
   `Vector2.rotated(double)`, `Quaternion.inverse()` (no-arg→Self),
   `Basis.scaled(Vector3)`, `Transform3D.translated(Vector3)` — 3 NEW variant types
   (Vector2/Vector3/Quaternion get their first `toFloat32`/`fromFloat32` + bind
   lazies) plus 2 new Vector3-arg shapes on existing Basis/Transform3D. Self-test:
   +5 C rows, +5 Kotlin rows (cross x̂×ŷ=ẑ exact; rotated π/2 and Quaternion.inverse
   90°-about-Z with ε=1e-4 since trig/length²-divide; scaled diag and translated
   offset exact). Compared component-wise with numeric `==` (and ε), NOT data-class
   `==` — the -0.0 trap (item 10). Device C 30→35, Kotlin 35→40, 0 failed, no notes.
   Gates: check_wrapper_generator, check_ios_no_silent_stubs, compileKotlinIosArm64,
   clang -fsyntax-only — all pass. **Next NEW capability on this seam:** a
   scalar-return shape (`dot`/`length`/`determinant` → float, not a value type) — the
   path currently decodes only float32-component value-type returns.
12. **DONE: value-type builtin scalar-`float` returns (device-validated 2026-06-15).**
   `BuiltinCalls.callScalar` (returns Double) + refactored a shared private
   `MemScope.invokeBuiltin` so the value-type `call` and the scalar path share arg/base
   marshalling. Wired `Vector3.dot(Vector3)` (hash 1047977935) + `Basis.determinant()`
   (hash 466405837). **GOTCHA caught on device (first run: C 35/2-fail, Kotlin 40/2-fail):**
   a builtin method's scalar `float` (Variant FLOAT) return is encoded as an **8-byte
   double** in the GDExtension ptr-ABI regardless of real_t precision — NOT a real_t/
   float32 like value-type *components*. Decoding it as float32 reads the low half of the
   double → 0. Fixed by allocating a `DoubleVar`/`double` return (C row used `double out`
   too); this matches desktop `BuiltinTypes` (allocates a `JAVA_DOUBLE` ret). Self-test:
   dot (1,2,3)·(4,5,6)=32, det diag(2,4,8)=64, both exact. Re-run: device C 35→37,
   Kotlin 40→42, 0 failed. Gates: check_wrapper_generator, check_ios_no_silent_stubs,
   compileKotlinIosArm64, clang -fsyntax-only — all pass. **Next NEW capabilities on this
   seam:** an `int`/`bool` scalar return (different decode width) — float-component value
   returns AND scalar float returns are now both done.
13. **DONE: value-type builtin `bool` + `int` returns (device-validated 2026-06-15).**
   `BuiltinCalls.callBool` (decodes a uint8) + `callInt` (decodes an int64), both via the
   shared `invokeBuiltin`. Wired `Vector3.isNormalized()` (hash 3918633141, bool) +
   `Vector3.maxAxisIndex()` (hash 3173160232, int). Return widths taken from the Godot
   4.6.2 source (`core/variant/method_ptrcall.h`): `PtrToArg<bool>` = uint8 (1 byte),
   `PtrToArg<int64_t>` = direct 8 bytes — so a bool return is ONE byte, an int return is
   int64, NOT real_t. Self-test (both directions per row to guard the decode):
   is_normalized (0,0,1)=true / (2,0,0)=false; max_axis_index (1,5,2)=1 / (1,2,9)=2 —
   non-zero expectations catch a wrong-width zero-read. Validated first try (widths were
   right): device C 37→39, Kotlin 42→44, 0 failed. Gates: check_wrapper_generator,
   check_ios_no_silent_stubs, compileKotlinIosArm64, clang -fsyntax-only — all pass. The
   four value-type return widths are now all settled (float32 components / double scalar /
   uint8 bool / int64 int). **The BuiltinCalls value-type seam is broadly covered; NEXT is
   Phase 3.1** (KSP-emitted script model) per the user decision.
- Workflow: impl per roadmap model tag → review diff → commit straight to main.
  (Fable 5 is no longer available as of 2026-06-12 — the review step and
  attribution are Opus 4.8: `Co-Authored-By: Claude Opus 4.8 <noreply@anthropic.com>`.)

## Session log

- **2026-06-15** — Phase 3.1 processor platform-awareness + Option B validation
  (opus impl). emitJvmCode gates JVM registrars (0735e99). Proved KSP-on-iOS
  (Option B): ran the shared processor on ios-runtime's native target →
  JSON-only emission, zero .kt registrars, iOS JSON byte-identical to JVM JSON.
  Caveat: object-typed ScriptProperties using desktop wrappers don't resolve on
  K/N (Phase 2/4). Held the Gradle wiring out of main (gates every iOS build for
  no gain until the 3.2 consumer); documented in the design doc. Remaining = 3.2.
- **2026-06-15** — Phase 3.1 steps 1b + JSON serializer (opus impl). Moved
  ArgModel JVM codegen to emitter-side extensions (357b2a8); added
  ScriptModelJson.kt (zero-dep serializer, SCHEMA_VERSION=1) + per-script
  `.script-model.json` emission (fb081b5). All byte-identical (registrar sha
  unchanged). JSON validated to carry NODE_PATH value-type fidelity +
  defaultLiteral that the regex parser can't. Remaining: Option-B KSP-on-iOS
  Gradle wiring + parallel-run gate, then 3.2.
- **2026-06-15** — Phase 3.1 step 1a (opus impl). User chose Option B (KSP on the
  iOS native target). Extracted the platform-neutral model into ScriptModel.kt
  (byte-identical generated registrars, verified by content sha of
  :project-scripts:kspKotlin output). Next: 1b (neutralize ArgModel/TypeMapping
  JVM codegen off the model) → JSON serializer → Option-B Gradle wiring +
  parallel-run gate. Committed bdee65f.
- **2026-06-15** — Phase 3.1 framing (opus design). Design doc
  [script-model-unification-design.md] landed: two front-ends (KSP ScriptModel
  vs iOS parseIosScript regex) → one serialized platform-neutral JSON model;
  schema sketch, what the iOS model lacks, the A-vs-B fork (where the model is
  produced for iOS; recommend B = KSP on the native target), parallel-run
  validation, migration mapping to 3.2–3.4. Decision A/B pending.
- **2026-06-15** — value-type builtin `bool`+`int` returns (opus impl).
  BuiltinCalls.callBool (uint8) + callInt (int64); wired Vector3.is_normalized +
  max_axis_index. Return widths read from Godot source (PtrToArg<bool>=uint8,
  <int64_t>=8B). Device C 37→39, Kotlin 42→44, 0 failed, first try. All four
  value-type return widths now settled. NEXT: Phase 3.1. See item 13.
- **2026-06-15** — value-type builtin scalar-`float` returns (opus impl).
  BuiltinCalls.callScalar (+ shared MemScope.invokeBuiltin); wired Vector3.dot +
  Basis.determinant. Caught a device-only bug: scalar float returns are 8-byte
  doubles in the GDExtension ptr-ABI (not real_t/float32 like components) — decode
  as double, matching desktop BuiltinTypes. Device C 35→37, Kotlin 40→42, 0 failed.
  See item 12.
- **2026-06-15** — value-type builtin methods widened to Vector ops + new variant
  types (opus impl). VT_VECTOR3/QUATERNION C constants + BuiltinCalls VT/PT consts;
  wired Vector3.cross / Vector2.rotated / Quaternion.inverse / Basis.scaled /
  Transform3D.translated. Device C 30→35, Kotlin 35→40, 0 failed. **USER DECISION:**
  2.6 @ScriptProperty value delivery sequenced AFTER Phase 3 KSP unification (don't
  extend the 711-line regex parser now); NEXT is Phase 3.1. See item 11.
- **2026-06-15** — value-type builtin methods widened to the args path (opus impl).
  BuiltinCalls.call(BArg list); wired Transform3D affine_inverse/orthonormalized/
  looking_at/interpolate_with + Basis transposed/orthonormalized. Device C 28→30,
  Kotlin 30→35, 0 failed. Caught a -0.0/Double.equals self-test gotcha (see item 10).
- **2026-06-14** — iOS value-type (builtin) method call path (opus impl). New C
  `get_builtin_method`/`builtin_call` + Kotlin `BuiltinCalls`; wired
  `Transform3D.inverse()`/`Basis.inverse()`. Device-validated iPhone 12: C 26→28,
  Kotlin 28→30, 0 failed. (Caught a self-test bug — Godot's `Transform3D.inverse`
  transposes the basis assuming orthonormal, not a true inverse; fixed the
  expectation.) See item 9.
- **2026-06-14** — iOS Variant `Object.call` dispatch (opus impl). New generic C
  `kanama_ios_godot_object_call` + `object_disconnect` + Kotlin
  `ObjectCalls.callWithVariantArgs`; cleared 5 of the 8 IosGodotApi STUBs
  (call/set_deferred/disconnect/set_custom_mouse_cursor/SignalConnection.error).
  Device-validated iPhone 12: C 23→26, Kotlin 22→28, 0 failed. 3 Callable STUBs
  deferred (connectBound/disconnectBound bindv, SignalConnection.close). See item 8.
- **2026-06-12** — Roadmap + tracker created. Architecture review landed
  (`56f29aa`, `4449ece`): compatibility_minimum 4.7 fix, R8 consumer-rules
  scaffold. Phase 1.1 started.
- **2026-06-12** — Phase 1.1 done (sonnet impl, fable review: COMMIT with one
  cosmetic doc fix). 19 new CALL_SHAPES, 18 new ObjectCalls helpers, +20
  methods. Remaining "unsupported helper shape" skips are all
  Variant/typedarray/Packed*-arg or container-return → Phases 1.2/1.3.
- **2026-06-12** — Phase 1.2 done (opus impl, fable review: COMMIT, info-nits
  only). 6 container-return shapes, +14 methods (→15,299). Skips now 1,523;
  remaining helper-shape skips all carry Variant/typedarray/Packed*/Signal
  args or Variant returns → Phase 1.3+. (Dictionary)→Dictionary stays
  policy-blocked (non-String-key policy in audit_generator_shape_policy.py).
- **2026-06-12** — Phase 1.3 done (opus impl, fable review: COMMIT). 9 shapes,
  +14 methods (→15,313, skips 1,509): Dictionary→Variant LSP returns,
  Variant args (incl. both RichTextLabel 12-arg image methods — cell order
  verified against extension_api.json), Packed*-array args. BLOCKED for a
  future task: TypedObjectArray/TypedRIDArray/TypedTransform3DArray ARGS
  have no BuiltinTypes init paths (affects ImporterMesh.merge_importer_meshes,
  OpenXR do_entity_update ×2, RenderingDevice tlas_build et al.,
  RenderingServer.texture_drawable_blit_rect, DrawableTexture2D.blit_rect[_multi]).
  Remaining out-of-scope skips: Callable (1.4), Signal arg (Tween.tween_await),
  (Dictionary)→Dictionary policy gate, EditorExportPlatform.export_project,
  Font.find_variation.
- **2026-06-12** — Phase 1.4 done (fable design + impl). Design doc:
  [callable-args-design.md](./callable-args-design.md). Decision: generated
  wrappers keep object+method `GodotCallable` (lifetime engine-side via
  ObjectID; destroy cell after ptrcall — engine copy-constructs Callable
  params); Kotlin-lambda→Callable deferred to a future custom-callable task
  (callable_custom_create2, free_func-driven registry lifetime) with the
  iOS C-shim counterpart noted. 3 new ObjectCalls helpers
  (StringCallable→Object, RID+ObjectList+Object[+Object]+Callable→Object) +
  hand-audited candidate_for entries (Callable stays out of CALL_SHAPES per
  shape-policy audit). +6 methods (→15,319, skips 1,503): JavaClassWrapper
  .create_sam_callback, OpenXRSpatialAnchorCapability
  .create_default_persistence_context + .start_entity_discovery,
  OpenXRSpatialMarkerTracking/PlaneTracking .start_entity_discovery,
  OpenXRSpatialEntityExtension.discover_spatial_entities_with_component_data.
  All remaining Callable skips are virtual `_*` or root-Object (deliberate).
  Gates: fixtures, signature/shape/layout/variant-policy audits, exact -6
  delta, compileKotlin — all pass. Phase 1 desktop/Android shape gaps:
  complete except deliberately blocked items below.
  Correction to the 1.3 blocked rationale: TypedObjectArray ARGS *do* have
  an audited init path (`initArrayOfObjects`, reused by the 1.4 OpenXR
  helpers) — only TypedRIDArray/TypedTransform3DArray genuinely lack init
  paths. Follow-up: OpenXR `do_entity_update` ×2 (and possibly
  `merge_importer_meshes`) could be unblocked today via the same path;
  TypedRIDArray/Transform3DArray args, (Dictionary)→Dictionary policy gate,
  and Signal arg (Tween.tween_await) remain blocked.
- **2026-06-12** — Phase 2.1 done (sonnet impl). iOS Vector2i/Vector3i arg +
  return kinds (PT_VECTOR2I=7 2×int32, PT_VECTOR3I=9 3×int32 — POD
  passthrough, no new C switch cases; tags were already reserved in the shim
  enum). New ios-runtime `types/Vector3i.kt`; 4 hand-written iOS helpers
  (no-args-ret + single-arg for both types); 2 C-shim self-test matrix rows
  (Sprite2D.frame_coords, PlaceholderTexture3D.size) + 2 Kotlin ObjectCalls
  probe rows — all marked **PENDING DEVICE VALIDATION** (debug-only,
  fail-loud, cannot pass silently). Sprite2D.kt regenerated: +3 methods
  (set/get frame_coords + property). Gates: check_wrapper_generator,
  check_ios_no_silent_stubs, local CI iOS checks, compileKotlinIosArm64,
  clang -fsyntax-only — all pass. Next device run must confirm the 2 new
  matrix rows before 2.6 builds on these kinds.
  Fable review: FIX-FIRST → fixed: Sprite2D.set_frame_coords(3,7) is rejected
  by ERR_FAIL_INDEX with default hframes/vframes=1 (would have reported a
  false ABI failure on device); both the C matrix row and the Kotlin probe
  now call set_hframes(4)/set_vframes(8) first. Widths/tags/hashes/struct/
  generator gating all verified correct by review.
- **2026-06-12** — Phase 2.2 done (sonnet impl). iOS Color/Rect2 arg + return
  kinds (PT_COLOR=11 4×float32=16B, PT_RECT2=12 4×float32=16B — Color
  components always float32, Rect2 real_t=float32 on single-precision iOS;
  both flow through POD passthrough, no new C switch cases; tags were already
  reserved in the shim enum). 4 hand-written iOS helpers in ObjectCalls.kt
  (ptrcallNoArgsRetColor/Rect2 + ptrcallWithColorArg/Rect2Arg) + PT_COLOR/
  PT_RECT2 constants; ptrcallWithStringNameAndBoolArgRetBool moved from
  generated to hand-written (was dropped by regeneration since Input is
  bespoke, not an IOS_EMIT_CLASS). 2 C-shim self-test matrix rows (color:
  CanvasItem.modulate(0.125,0.25,0.5,0.75) — validation-free, exact float32;
  rect2: GPUParticles2D.visibility_rect(1.5,2.5,3.5,4.5) — validation-free,
  exact float32) + 2 Kotlin ObjectCalls probe rows — all marked **PENDING
  DEVICE VALIDATION**. CanvasItem.get_modulate STUB removed: CanvasItem
  regenerated with 16 new methods (setModulate/getModulate/setSelfModulate/
  getSelfModulate now real; getViewportRect generated; drawLine/drawRect/
  drawCircle/drawArc/drawEllipseArc/drawEllipse + drawTexture*/drawMsdf*/
  drawLcd* variants). CanvasItem+Viewport SUGAR dropped (getViewportRect
  and getVisibleRect now generated). Node SUGAR preserved (getTree/
  getNodeOrNull/getAsOrNull/requireAs/getNodeAsOrNull/createTween remain
  bespoke) but getViewport() dropped from SUGAR (now generated).
  Additional classes regenerated: Control +4, GPUParticles2D +3,
  Sprite2D +3, CollisionObject2D +2, CollisionShape3D +3, Label +1
  (getCharacterBounds). STUB delta: 12→11 (-1 CanvasItem.get_modulate).
  SUGAR delta: 5→3 (-CanvasItem.getViewportRect, -Viewport.getVisibleRect).
  Gates: check_wrapper_generator, check_ios_no_silent_stubs, local CI iOS
  checks, compileKotlinIosArm64, clang -fsyntax-only — all pass.
- **2026-06-12** — Phase 2.1+2.2 device validation DONE (iPhone 12, iOS 26.5).
  Built+deployed debug xcframework via scripts/ios_visual_smoke.sh
  (`--allow-provisioning-updates`, team DVZT29Q4QT); re-launched with
  `devicectl process launch --console` to capture the SCENE-init self-test
  (the script's own devicectl launch does not stream the app console — its
  `>`/`2>` redirects catch devicectl, not the remote app; `--console` is
  required, idevicesyslog is a noisy fallback). Result: C
  `PTRCALL SELFTEST MATRIX: 14 passed, 0 failed` + Kotlin
  `OBJECTCALLS SELFTEST: 13 passed, 0 failed`, no construct-0 notes. All 8
  new rows (Vector2i/Vector3i/Color/Rect2 × C+Kotlin) PASS — check counts
  14/13 match source ST_CHECK/check() totals, so no row silently skipped.
  PENDING DEVICE VALIDATION markers cleared in kanama_ios_shim.c +
  ObjectCalls.kt. **2.6 unblocked; next is 2.3 (String-return ptrcall).**
- **2026-06-12** — Phase 2.3a String-return ptrcall DONE (opus impl, device-
  validated iPhone 12, iOS 26.5). String returns can't ride the generic ptrcall's
  fixed ret_out, so a dedicated C helper `kanama_ios_godot_ptrcall_no_args_ret_string`
  runs the call, UTF-8-encodes via `string_to_utf8_chars` (already resolved C-side),
  and destroys the String; Kotlin `ptrcallNoArgsRetString` uses a two-call length
  protocol (NULL probe → alloc → fill), safe because the wired methods are pure
  getters. Generator: `"String"` added to `IOS_RET_KOTLIN`, gated to the no-arg
  helper via `shape.function == "ptrcallNoArgsRetString"` (StringName no-arg returns
  share the "String" kotlin_return token but route through `ptrcallNoArgsRetStringName`
  — kept out for 2.3b; arg+String shapes likewise out). `IOS_PROPERTY_SUPPRESS`
  added: suppresses Label's `text` property so the bespoke writable `var text`
  (real `getText()` read + `IosGodot.setObjectText` write — set_text takes an
  unbuilt String arg) isn't shadowed by a generated read-only `val text`, which
  would break `label.text = …` in the demos (CoinsContainer.kt, ScoreLabel.kt).
  6 wrappers regenerated: Control/Resource/Node/Viewport/AnimationPlayer/Label —
  purely additive no-arg String getters (getText, getTooltipText, getName, getPath,
  getSceneFilePath, getTreeString[Pretty], getEditorDescription, getLanguage,
  getEllipsisChar, getParagraphSeparator, guiGetDragDescription, getAccessibility*).
  SUGAR re-applied to Label/Node/AnimationPlayer (+re-added `types.NodePath` import
  to Node). New self-test row Object.get_class(Node2D)=="Node2D" in both matrices:
  C 14→15 passed/0 failed, Kotlin 13→14 passed/0 failed, no construct-0 notes.
  no-silent-stubs now 1 annotated site (AnimationPlayer.getCurrentAnimation cache,
  → 2.3b). Gates: check_wrapper_generator, check_ios_no_silent_stubs,
  compileKotlinIosArm64, clang -fsyntax-only — all pass. StringName-return
  (get_current_animation) deferred to 2.3b (needs String-from-StringName ctor hop).
- **2026-06-13** — Phase 2.3b StringName-return ptrcall DONE (opus impl + review,
  device-validated iPhone 12, iOS 26.5). GDExtension has no StringName→utf8, so the
  dedicated C helper `kanama_ios_godot_ptrcall_no_args_ret_string_name` ptrcalls the
  StringName, builds a String via the `String(from: StringName)` constructor
  (`g_variant_get_ptr_constructor(KANAMA_IOS_VARIANT_TYPE_STRING, 2)` — index 2 per
  extension_api.json; mirrors the existing node_path-from-string ctor pattern, added
  to the hard-resolve guard), UTF-8 encodes, and destroys both. Kotlin
  `ptrcallNoArgsRetStringName` reuses the two-call length protocol. Generator gate
  relaxed: `shape.kotlin_return == "String"` now allows both `ptrcallNoArgsRetString`
  and `ptrcallNoArgsRetStringName` (both hand-written). This unblocked the real
  `AnimationPlayer.getCurrentAnimation()` (StringName return) — the SUGAR last-play()
  cache + `currentAnimationName` field were dropped (AnimationPlayer regenerated
  wholesale). 6 wrappers regenerated: AnimationPlayer (real getCurrentAnimation +
  `var currentAnimation`/assignedAnimation/autoplay), Node (getName + `var name`),
  Area2D/Area3D (audio/reverb bus name `var`s), Control (themeTypeVariation,
  translationContext `var`s); Label/Node SUGAR re-applied (+`types.NodePath` import).
  New self-test row Node.set_name("KanamaSN") → get_name() == "KanamaSN" in both
  matrices: device C 15→16 passed/0 failed, Kotlin 14→15 passed/0 failed, no notes.
  Gates: check_wrapper_generator, check_ios_no_silent_stubs (1 annotated site left),
  compileKotlinIosArm64, clang -fsyntax-only — all pass. Deploy note: the device
  briefly ran a stale xcframework after an interrupted run; verified build
  correctness via `nm` of the rebuilt `.a` (symbol present) and re-ran a clean
  ios_visual_smoke.sh to redeploy before trusting the device counts.
- **2026-06-13** — Phase 2.4 PT_STRING/PT_NODE_PATH args DONE (opus impl + review,
  device-validated iPhone 12, iOS 26.5). The generic dispatch builds String and
  NodePath args from the C string the same way it already built StringName (reusing
  `init_string`/`init_node_path` + the matching destructors); the per-arg cell array
  was generalized to `builtin_cells` with `constructed[i]` carrying the tag so the
  right destructor runs. Generator widened: `String`/`NodePath` added to
  `IOS_ARG_KINDS`, tags `PT_STRING=16`/`PT_NODE_PATH=17` in `IOS_PT_TAG_VALUES`,
  `ios_arg_layout` cases (`{a}.cstr.ptr` for String, `{a}.path.cstr.ptr` for
  NodePath), plus the `types.NodePath` import in the generated ObjectCalls header.
  `IOS_PROPERTY_SUPPRESS` emptied: with PT_STRING args real, `set_text` generates, so
  `Label.text` graduated to a fully generated `var text` (+ `setText`/`getText`) and
  its bespoke SUGAR was retired. 11 wrappers regenerated (broad: String/NodePath
  setters across AnimationMixer/AnimationPlayer/Area3D/Control/GPUParticles2D+3D/
  Node/Node3D/Resource/Viewport + read-only→writable property upgrades); Node SUGAR
  re-applied (generated `getNodeOrNull(NodePath)` overloads the bespoke
  `getNodeOrNull(String)`); the Node3D generator fixture was refreshed. Two new
  self-test rows in each matrix — Node.set_scene_file_path→get_scene_file_path
  (String round-trip) and parent.add_child(child)+get_node_or_null(NodePath) (Object
  round-trip). Device: C 16→18 passed/0 failed, Kotlin 15→17 passed/0 failed, no
  construct-0 notes. **Triage:** the first device build crashed SIGSEGV — the crash
  `.ips` (pulled via idevicecrashreport) showed `construct_object("Label")` →
  `Label::_notification` → `ThemeContext::get_themes()` null-deref: a treeless
  Control segfaults in its post-init Theme lookup. Harness bug, not marshalling;
  switched the String row from `Label.set_text` to `Node.set_scene_file_path` (same
  shape/hash). Gates: check_wrapper_generator (Node3D fixture updated),
  check_ios_no_silent_stubs, compileKotlinIosArm64, clang -fsyntax-only — all pass.
- **2026-06-13** — Phase 2.5 Transform3D/Basis DONE (opus impl + review,
  device-validated iPhone 12, iOS 26.5). Both flow through the dispatch's POD
  passthrough (raw real_t bytes, no new C switch case — same as Color/Rect2); enum
  tags `PT_BASIS=18`/`PT_TRANSFORM3D=19` are Kotlin-side sizing only. Added minimal
  iOS `types/Basis.kt` (x/y/z column axes + IDENTITY) and `types/Transform3D.kt`
  (basis + origin + IDENTITY); deliberately no BuiltinTypes value methods (inverse/
  scaled/etc. need the variant-call path, still unwired on iOS — those are a separate
  backlog item). Generator: `Basis`/`Transform3D` added to `IOS_ARG_KINDS` +
  `IOS_RET_KOTLIN`, tag values, `ios_arg_layout` (Basis 9 float32 column-major
  `[x.x,y.x,z.x,x.y,y.y,z.y,x.z,y.z,z.z]`; Transform3D those 9 + origin 3) and the
  mirror `ios_ret_layout`, plus Basis/Transform3D imports in the generated ObjectCalls
  header. Layout verified against the desktop Basis/Transform3D writeTo/readFrom (same
  column-major indexing) — and a set→get round-trip is self-checking regardless. 5
  wrappers regenerated: Node3D (get/setTransform, get/setBasis, global* + `var
  transform/basis/globalTransform/globalBasis`), Camera3D.getCameraTransform,
  CollisionObject3D.shapeOwnerGet/SetTransform, GPUParticles3D.emitParticle; Node
  net-unchanged (SUGAR-only regen churn). New self-test rows: Node3D
  set_transform→get_transform (12 float32) and set_basis→get_basis (9 float32) with
  exact-in-float32 diagonal (pure-scale) values. Device C 18→20 passed/0 failed,
  Kotlin 17→19 passed/0 failed, no construct-0 notes; passed first device run. Node3D
  generator fixture refreshed. Gates: check_wrapper_generator, check_ios_no_silent_stubs,
  compileKotlinIosArm64, clang -fsyntax-only — all pass. (One compile catch fixed
  pre-device: the Basis self-test local `n3b` collided with the existing T3.1
  generated-vector3 `n3b` → renamed `basisNode`.)
- **2026-06-13** — RID/Quaternion/AABB kinds DONE (opus impl + review,
  device-validated iPhone 12, iOS 26.5). Continued the audited-kind widening past the
  numbered 2.x set (user chose this over starting 2.6, which needs the Phase-3 parser
  rework first). All POD passthrough, no new C dispatch case: RID is the pre-existing
  `PT_RID=14` uint64; Quaternion `PT_QUATERNION=20` (4 float32 `[x,y,z,w]`); AABB
  `PT_AABB=21` (6 float32, position then size). New iOS value types RID (`@JvmInline
  value class`, needs explicit `import kotlin.jvm.JvmInline` on Native), Quaternion,
  AABB. Generator widened (arg/ret kinds, tag values, layouts, header imports). 13
  wrappers regenerated; Node SUGAR re-applied; Node3D fixture refreshed. Self-test
  rows: GPUParticles3D get_base→set_base→get_base RID round-trip (auto particles base
  is nonzero); GPUParticles3D set_custom_aabb→get_custom_aabb (exact float32); Node3D
  set_quaternion→get_quaternion with ε=1e-4 (Godot stores rotation as a basis and
  re-derives the quaternion, so the round-trip is float, not bit-exact — the only
  non-exact self-test row, deliberately). Device C 20→23 passed/0 failed, Kotlin
  19→22 passed/0 failed, no construct-0 notes; passed first device run. Plane
  deferred: no clean Plane arg+return on an emitted class to anchor a matrix row.
  Gates: check_wrapper_generator, check_ios_no_silent_stubs, compileKotlinIosArm64,
  clang -fsyntax-only — all pass.
