# iOS Demo Port — Tracker

Working tracker for porting the Android-supported demos to the iOS (Kotlin/Native) backend. Each
"Remaining task" is self-contained: read this file + the named code files and you can do it in a fresh
session without replaying prior history.

> **Private bits (device UDIDs, exact local-path commands, raw logs) are kept in the loose private
> handoff outside this public repo** (per AGENTS.md). This file stays public-safe.

- **Repos / branch:** `kanama` and `kanama-demos`, both on `ios-demo-ports`.
- **Devices:** a paired iPhone 15 Pro (primary) + iPhone 12; UDIDs/team in the private handoff.
- **Goal/scope:** parity-first — get the demos building + playable on iOS, fixing the underlying
  iOS-runtime/library bugs they expose (don't hack the demos). Prefer generation over hand-writing
  (same as desktop/Android). Defer the full Godot API.

## Status

| Demo | On device |
|---|---|
| Bunnymark, Match3, 3D-Platformer | playable (pre-existing) |
| **dodge** | playable + touch controls |
| **squash** | playable + touch controls |
| **character-controller** | playable; flag works; **death plane broken** (see V1) |
| **Racing** | playable + camera-follow; **no steering joystick** (see R1) |
| FPS, third-person | not built (see F1, T1) |

## Build / deploy / debug (see private handoff for exact commands + UDIDs)
- **Build-check a demo's scripts** (fast, no device): `./gradlew installIosAddon
  -PkanamaIosProjectDir=<demoDir> -PkanamaIosProjectScriptsDir=<demoDir>/kotlin-src
  -PkanamaXcodeDeveloperDir=<XcodeDeveloperDir>` (set `DEVELOPER_DIR` to the Xcode app, not CLT).
- **Deploy + launch:** `kanama-demos/scripts/ios_device_run.sh <godot> <demoDir> <bundle.id> <AppName>`
  with `KANAMA_IOS_DEVICE` / `KANAMA_IOS_TEAM` / `KANAMA_ROOT` / `DEVELOPER_DIR`. Demo→AppName/bundle
  map: `kanama-demos/scripts/ios_smoke_all.sh`.
- **Device console** (essential for gameplay bugs): `xcrun devicectl device process launch --console
  --device <id> <bundle>` (background); grep for `[kanama]`, `FAILED`, `exception`. The runtime logs
  script-resource/instance creation, `@RegisterFunction` method calls, and connect failures — but NOT
  lambda firing (add temp `println`s for those).
- **Caveats:** free provisioning ≈ 3 installed apps (uninstall between batches); keep device unlocked.

## CRITICAL gotcha — regenerating iOS wrappers
Always regenerate within the **FULL class union** (all currently-emitted classes), not a single
`--ios-emit-class X`. A single-class run sets `wrapper_classes={X}` and **drops methods returning other
wrapper types** (e.g. `Viewport.getCamera3d(): Camera3D?`). Build the union from the generated `.kt`
files' "Generated from Godot docs" headers, regen to a temp dir, verify `removed_funs=0` vs the committed
file before copying. Generator + iOS custom sections: `scripts/generate_api_wrapper.py`
(`IOS_CUSTOM_MEMBER_SECTIONS`, `IOS_CUSTOM_COMPANION_MEMBER_SECTIONS`).

## Key iOS-backend facts (reuse these)
- iOS value-type components are `Double`; Android/desktop are `real_t`(=Float). Kotlin allows `<`/`>`
  across Double/Float (`compareTo`) but NOT `==`/`!=` — shared demo source must `.toDouble()` before
  `==`/`!=`, and use `withX/withY(Number)` instead of `Vector.copy(...toFloat())`.
- The iOS **Variant-call** path (`GodotObject.call`/`get`) decodes a Variant **OBJECT** return as a raw
  `MemorySegment` handle, not a wrapped object — wrap it (`Wrapper(memSeg)` /
  `iosScriptInstanceForOwner(handle.address())` for user scripts).
- Script signals/properties are advertised via the **Script object** (`ScriptExtension`), populated by
  `kanama_ios_script_resource_init_metadata` (C shim). Runtime `Object::connect` to a script `@Signal`
  needs `_has_script_signal` true.

## DONE — iOS runtime/library bugs fixed
- `GodotObject.get/set/setScript` desktop parity (dropped generic `get<T>`). `GodotObject : AutoCloseable`.
- Generated: Input, OS, PathFollow2D/3D, RayCast3D, RenderingServer, AnimationNodeStateMachinePlayback,
  BaseMaterial3D.
- Hand-written: Mathf/GD math, Vector2/3/Basis/Transform3D methods, SceneTree methods,
  MainThread.awaitNextFrame/postAfterFrames (frame-pumped), Light3D.lightEnergy.
- Generator: StringName default emission; `IOS_CUSTOM_COMPANION_MEMBER_SECTIONS` mechanism (KEY_*,
  InputEventMouseMotion.from, BaseMaterial3D.fromMaterial); Viewport/AnimationMixer iOS sections;
  annotations (@GlobalClass, PropertyHint).
- **emitSignal** dropped no-arg custom signals (dodge Start). Fixed via `call("emit_signal", …)`.
- **AnimationMixer.getStateMachinePlayback** wraps the raw `MemorySegment` object return.
- **node_paths object @ScriptProperty** delivery — `IosScriptCodeEmitter` emits a `setProperty(Long)`
  case for `customScriptFqName` props (`iosScriptInstanceForOwner(value) as? <Fq>`). (Racing camera.)
- **Signal registration for method-less scripts** — `init_metadata` early-returned on 0 methods, skipping
  property+signal registration (Events autoload). Guarded with `if (method_count > 0)`.
- Demos: iOS gdextension entries; `mobile_controls.gd` enabled on iOS (`or OS.has_feature("ios")`);
  cross-platform script idioms; character flag reloads the level instead of quitting.

## Remaining tasks (each resumable on its own)

### V1. character DEATH PLANE broken — frame callback stops firing  (ROOT CAUSE FOUND)
Reaching the flag works; **falling off / kill plane does not respawn the player.** Traced on device:
`KillPlane3D` body_entered fires, but the deferred emit never runs. **Root cause:** the per-frame hook
`KanamaIosRuntime.frame()` (C entry `kanama_ios_runtime_frame`) **stops being called after the first
~tens of frames** — so `MainThread.pumpNextFrame()` stops, and EVERYTHING frame-deferred dies:
`awaitNextFrame`, `postNextFrame`, `postAfterFrames`. (Evidence: probe log prints `frame=1`,`frame=30`
then never `frame=120`, and the demo keeps running via `_physics_process` the whole time.) This is a
real runtime bug affecting any frame-deferred logic.
- Fix: make the C `kanama_ios_runtime_frame` callback a persistent per-frame hook. Find where it's
  registered/invoked (`ios/bootstrap/kanama_ios_shim.c`: "registered main loop frame callback") — it's
  likely tied to the startup probe/self-test and not a durable engine `_process`/`_frame` hook.
- Verify: `KillPlane3D` death plane respawns; re-test flag (it currently dodges this by using
  `reloadCurrentScene()` directly, not awaitNextFrame).

### R1. Racing steering — `VirtualJoystick` on iOS
`SteeringJoystick` in `Starter-Kit-Racing/scenes/main.tscn` is `type="VirtualJoystick"` (absent on iOS).
Identify what `VirtualJoystick` is (GDScript addon `class_name` under `Starter-Kit-Racing/addons/`, vs a
Kanama-registered class — `kanama/.../api/VirtualJoystick.kt` is a generated *wrapper*), then make it
available/registered on iOS. Verify: steering joystick appears + turns the car.

### E1. Bunnymark FPS-label safe-area
FPS panel (`Bunnymark/Benchmarker.tscn` `Panel/FPS`, top-left; `Benchmarker.gd:fps_label`) is clipped by
the device rounded corner. Make it safe-area-aware in `Benchmarker.gd._ready`
(`DisplayServer.get_display_safe_area()`) or inset the Panel. Landscape (`orientation=0`). Confirm on
device.

### F1. FPS demo (`Starter-Kit-FPS`)
Build via installIosAddon, fix iteratively. Roadmap-listed gaps: generate `AnimatedSprite3D`; add
`Tween.bindNode`/`tweenCallback`, `Object.hasMethod`/`call`, `Resource.loadPackedScene`,
`Node.isQueuedForDeletion`.

### T1. third-person (`godot-4-3d-third-person-controller`)
Largest. Generate `SpringArm3D`, `ShapeCast3D`, `MeshDataTool`, `SurfaceTool`, `MultiMeshInstance3D`,
`WorldEnvironment`; add `Engine`/`Time`/`ProjectSettings`/`PhysicsServer3D`/`InputMap`,
`Quaternion.fromEuler`, `Object.hasMethod`/`call`/`isInstanceValid`/`getInstanceId`,
`Resource.loadPackedScene`/`loadAudioStream`, `Tween.tweenCallback`/`tweenMethod`/`setPaused`.

### Misc
- Roadmap table: `docs/internals/ios-backend-roadmap.md` (keep in sync).
- After V1 lands, re-test signal-heavy + frame-deferred flows across all demos.
