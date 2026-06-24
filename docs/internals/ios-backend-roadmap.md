# iOS Backend — roadmap & sync guide

How to keep the experimental iOS (Kotlin/Native) backend in sync with desktop/Android, the
guardrails that protect it, and the remaining backlog. Deep design lives in
[ios-backend-architecture.md](./ios-backend-architecture.md); the generated registry of
hand-written sites is [ios-backend-handwritten.md](./ios-backend-handwritten.md). Phase history
is in [wrapper-coverage-tracker.md](./wrapper-coverage-tracker.md).

**Status (refreshed 2026-06-23):** experimental, but the engine-capability gap to desktop/Android
is essentially closed. **222 wrapper classes** emitted — the full reachable Node|Resource runtime
closure plus the networking/crypto subtree and the bare-`Object` utility floor (a BFS over emitted
classes' Object args/returns reaches 0 not-yet-emitted in-scope classes). The audited type set is
complete for runtime use; the KSP script-model is unified across all targets; arbitrary virtual
overrides work. Device-validated on iPhone 12: self-test matrix **PTRCALL 54 / OBJECTCALLS 78, 0
failed**, ~0.63 ms/frame Kanama overhead. **6 demos device-validated/playable** on iPhone 15 Pro
(Bunnymark, Match3, 3D-Platformer, dodge, squash, character-controller — 2026-06-23) + **Racing
runs** (steering joystick + camera-follow gaps, below); FPS + third-person still blocked by residual
iOS wrapper gaps (now narrower — see table); 2 demos on hold (City-Builder, tps). The remaining distance to a *supported* iOS export
is **widening the iOS wrapper surface** for the blocked demos + export-workflow polish.

## Architecture in one paragraph

iOS forbids JIT, so there is no JVM/Panama. Instead: Kotlin/Native AOT + a C shim
(`ios/bootstrap/kanama_ios_shim.c`) over the GDExtension ABI. Godot API wrappers are GENERATED
(the desktop model) and call `ObjectCalls.<helper>(bind, receiver, args)`; on iOS the `ObjectCalls`
backend is the C-shim generic ptrcall `kanama_ios_godot_ptrcall` (vs desktop Panama/FFM). A
conservative **audited type set** gates which method shapes get emitted; everything else is skipped
(never silently wrong). The KSP processor emits a platform-neutral script model consumed on every
target (no iOS-specific parser). See architecture.md for the ptrcall width table and contract.

## What changed (Phases 2–5, this is what the old roadmap predated)

- **Audited types — complete for runtime use.** Vector2i/3i, Transform2D/3D, Basis, Color, Rect2/2i,
  String/StringName/NodePath (args + returns), Variant scalars, typed object/builtin arrays,
  Projection (+Vector4), Plane, AABB, RID, Quaternion. Value-type `@ScriptProperty` delivery
  (NodePath/Vector/Color → script instance) works.
- **KSP model unification (Phase 3).** The hand-rolled `parseIosScript` regex parser and the
  enumerated `IosScriptBridgeKind` are **deleted**. KSP runs over the Kotlin/Native source too and
  emits the same `ScriptModel` desktop uses (`IosScriptCodeEmitter`); dispatch is a generic
  per-signature `callV`. All lifecycle/input annotations are wired (`IOS_UNWIRED` is empty).
- **Phase 4 — 0 STUB / 0 SUGAR.** `GodotObject.call`/`setDeferred`/`disconnect`, bound + lambda
  Callables, and `SignalConnection.close` are real. SUGAR is emitted as generator custom-sections,
  so regeneration is lossless (no manual re-add).
- **Phase 5 — arbitrary virtual overrides.** `@OverrideVirtual` (the Kotlin function name IS the
  virtual name, GDScript-style `fun _draw()`) overrides any engine virtual; device-validated for
  void and value-returning (Bool/Int/Float/Vector2/Vector2i) virtuals.

## Guardrails (what keeps iOS correct + non-regressing)

- **Audited type set** — the generator emits only method shapes whose arg/return kinds are audited;
  unaudited shapes go to the skip report, never a wrong call. Widen deliberately (see below).
- **Self-test matrix + ObjectCalls probe** — on-device ptrcall round-trip matrix (**PTRCALL 54**) +
  a Kotlin ObjectCalls probe (**OBJECTCALLS 78**), 0 guardrail hits
  (`kanama_ios_check_call_error`/`check_variant_arg`). Run on every device validation; must stay
  54/78.
- **No-silent-stubs check** — `scripts/check_ios_no_silent_stubs.py` (in `local_ci.sh`) fails on an
  un-annotated bare-default return. `scripts/ios_handwritten_report.py` regenerates the handwritten
  registry (STUB=0, SUGAR=0, HANDWRITTEN=10, all justified bespoke).
- **Cross-platform non-regression** — `installIosAddon` preserves a project's Android + desktop
  `kanama.gdextension` entries; verify Match3 + 3D-Platformer still build on Android after iOS
  changes.
- **Generator fixture** — `scripts/check_wrapper_generator.py` includes an iOS fixture; iOS
  generator changes are `IOS_AUDIT_ONLY`-gated so desktop fixtures stay green.

## How to stay in sync with desktop / Android

- **Emit more classes (breadth)** — add the class names to the `--ios-emit-class` set and regenerate
  (`scripts/generate_api_wrapper.py … --ios-output-dir … --ios-objectcalls … --ios-skip-report …`);
  copy the NEW + CHANGED `api/*.kt` + `ObjectCallsGenerated.kt`. Verify parent chains resolve to an
  emitted class and the name doesn't collide with a hand-written class in `IosGodotApi.kt`
  (SceneTree, Tween, Input, Mathf, ResourceLoader, GD, AudioStreamPlayer, StaticBody3D,
  InputEventMouseButton, …). Emit-only changes need no C/header change → plain
  `compileKotlinIosArm64`, then a device regression run (matrix stays 54/78).
- **Widen the audited set** (a genuinely new kind) — add the kind to `IOS_ARG_KINDS`/`IOS_RET_KOTLIN`
  in the generator AND a width-sensitive self-test matrix row + an ObjectCalls probe row + (if a
  value type) the iOS `types/` struct. Never widen without a matrix row — the ptrcall width is the
  whole correctness story. (ABI gotchas: Packed*Array return slots are 16 bytes on 64-bit; builtin
  scalar-float returns are 8-byte doubles in the ptr-ABI.)
- **New Kanama annotation** — it flows through the shared KSP model. A FUNCTION annotation cannot
  carry data the iOS path reads (KSP2-over-Native doesn't expose function-annotation args — encode
  it in the function/param name or a class-level arg), and a new annotation must also be declared in
  the iOS shadow `ios-runtime/src/iosMain/kotlin/net/multigesture/kanama/annotations/Annotations.kt`.
- **C-shim ABI change** (new export / changed signature) — keep the Kotlin `@CName`, the C extern
  decl, and the C call sites in agreement; touching `ios/include/kanama_ios.h` (cinterop C→Kotlin)
  needs `DEVELOPER_DIR=…` on the gradle build. Always device-validate ABI changes.

## Remaining backlog (small; none block typical games)

- **iOS value-returning virtual returns beyond POD** — 5.3b covers Bool/Int/Float/Vector2/Vector2i;
  String/Packed/Variant virtual returns are deferred (the C `pt_arg_to_variant` return path + the
  Kotlin encode would extend the same way).
- **`@Rpc` config delivery** — parse-side done; the multiplayer RPC config isn't delivered to the
  engine yet (only matters for networked demos, e.g. tps-demo).
- **Callable / vararg** — deferred on *all* platforms (matches desktop 1.4), not iOS-specific.
- **`commonMain` unification (roadmap 4.3)** — move the iosMain wrapper copies toward `commonMain` +
  `expect/actual ObjectCalls` to cut desktop/iOS drift. Maintainability, not capability; blocked on a
  design decision (large cross-target migration).
- **Supported-export workflow** — make `docs/exporting/ios.md` a real user-facing export path
  (xcframework + Xcode steps), not just the `ios_visual_smoke.sh` harness. This + demo breadth is the
  gap to dropping "experimental".
- **Engine-bug / cosmetic** — AVAudioSession category workaround (Godot iOS audio is Ring/Silent-
  silenced; optional shim fix); `Input.setCustomMouseCursor` (Texture2D arg, cosmetic);
  `_get_script_signal_list` (editor-only introspection, irrelevant on-device); `real_t` centralization
  (irrelevant while single-precision — iOS stores Double + converts at the boundary).

## Demo iOS coverage (per-demo readiness — re-assessed 2026-06-22)

The old per-demo "tiers" were gated on Vector2i/3i, Transform3D, and the input annotations — **all
now closed**, so the tiers are obsolete. Current readiness: most Android-enabled demos should port;
each port is **port + device-validate** (a port can still surface a residual gap at runtime).

| Demo | 2D/3D | iOS status | Notes |
|---|---|---|---|
| Starter-Kit-Match3 | 2D | **Device-validated** | reference port |
| Starter-Kit-3D-Platformer | 3D | **Device-validated** | reference port; `view: NodePath` now delivered |
| Bunnymark | 2D | **Device-validated** | device-validated on iPhone 12 (2026-06-23) |
| godot-demo-2d-dodge-the-creeps | 2D | **Device-validated (playable)** | plays on iPhone 15 Pro: Start + touch controls. Fix: `emitSignal` dropped no-arg custom signals (Start→new_game). Plus `PathFollow2D` (generated), `Input.isActionPressed`, `Mathf.PI`, instance `SceneTree.delaySeconds`/`callGroup`, `AudioStreamPlayer.stop`, `Vector2.normalized`/`clamp` |
| godot-demo-3d-squash-the-creeps | 3D | **Device-validated (playable)** | plays on iPhone 15 Pro + touch controls. Needed: `PathFollow3D`+`RenderingServer` (generated), `Mathf.PI`, `Vector3.FORWARD`, `Input.isActionPressed`, `Basis.lookingAt`, `Light3D.lightEnergy`, `GodotObject` AutoCloseable (getSlideCollision `.use`) |
| Starter-Kit-Racing | 3D | **Runs (2 gaps)** | runs on device. GAPS: no steering — `VirtualJoystick` node type not on iOS; camera doesn't follow — `View.target` is a `node_paths` **object** `@ScriptProperty` (object refs from node_paths not delivered to Kotlin on iOS). Build needed: `RayCast3D` (generated), `GD.signf`/`lerpf`/`clampf`/`lerpAngle`/`remap`, `Vector3.signedAngleTo`/`moveToward`, `Transform3D.withBasis`/`withOrigin`, `Basis.withX`/`withY`/`withZ`+`*Vector3`, `@GlobalClass` |
| Starter-Kit-FPS | 3D | **Blocked (narrowed)** | now available: `RayCast3D`/`OS`, `@GlobalClass`/`PropertyHint`, `GD.lerpf`/`clampf`/`lerpAngle`, `Vector3 * Number`, `Input.setMouseMode`/`getVector`/`isActionPressed`, `Node3D.lookAt`, `Node.queueFree`, `setScript`. Still missing: `AnimatedSprite3D`, `Tween.bindNode`/`tweenCallback`, `Object.hasMethod`/`call`, `Resource.loadPackedScene`, `Node.isQueuedForDeletion` |
| godot-4-3d-character-controller | 3D | **Device-validated (playable)** | plays on iPhone 15 Pro. Crash fix: `AnimationMixer.getStateMachinePlayback` must wrap the raw `MemorySegment` that iOS Variant-call decodes for OBJECT returns (was throwing in `SophiaSkin.ready`). Plus `AnimationNodeStateMachinePlayback`+`BaseMaterial3D` (generated), `@GlobalClass`/`PropertyHint`, `InputEventKey.KEY_*`, `InputEventMouseMotion.from`, `Viewport.getCamera3D`, `AnimationMixer.setParameter`/`getStateMachinePlayback`, `BaseMaterial3D.fromMaterial`, `SceneTree.setPaused`/`unloadCurrentScene`/`getRoot`, `MainThread.postAfterFrames`/`awaitNextFrame`, `Basis*Vector3`, `Mathf.moveToward`/`isEqualApprox`. Death-plane fix: the C per-frame hook (`kanama_ios_frame`) self-disabled after 30 frames, killing `MainThread.pumpNextFrame()` and all frame-deferred logic; made it persistent (`KillPlane3D` deferred respawn now works) |
| godot-4-3d-third-person-controller | 3D | **Blocked (narrowed)** | now available: `RayCast3D`/`OS`, `AnimationNodeStateMachinePlayback`, `@GlobalClass`/`PropertyHint`, `Vector3.FORWARD`/`BACK`/`DOWN`/`RIGHT`/`signedAngleTo`/`moveToward`, `Input` mouse-mode/getVector/isActionPressed + `KEY_*`, `Transform3D.withBasis`/`withOrigin`, `SceneTree.unloadCurrentScene`/`getRoot`/`setPaused`, `MainThread.awaitNextFrame`/`postAfterFrames`, `GD.lerpAngle`. Still missing: `SpringArm3D`, `ShapeCast3D`, `MeshDataTool`, `SurfaceTool`, `MultiMeshInstance3D`, `WorldEnvironment`, `InputMap`, `ProjectSettings`, `Engine`, `PhysicsServer3D`, `Time`, `Quaternion.fromEuler`, `Object.hasMethod`/`call`/`isInstanceValid`/`getInstanceId`, `Resource.loadPackedScene`/`loadAudioStream`, `Tween.tweenCallback`/`tweenMethod`/`setPaused` |
| Starter-Kit-City-Builder | 2D | Hold | GridMap + `List<custom-class>` `@ScriptProperty` (also not an Android demo) |
| tps-demo-kanama | 3D | **Blocked** | `@Rpc` multiplayer config delivery (the one real backlog gate) |

**Porting checklist per demo:** (1) confirm the demo's wrapper classes are emitted (else add to the
`--ios-emit-class` set + regenerate); (2) configure the iOS export; (3) run
`ios_visual_smoke.sh --physical-device … --kanama-<demo>-probe` on the iPhone; (4) confirm the matrix
stays 54/78 and the scene runs (input, signals, scene reload). Flag the user before any device run
(the phone auto-locks). The batch runner `kanama-demos/scripts/ios_smoke_all.sh` runs the probe +
full device export for all 9 iOS-enabled demos in one command.
