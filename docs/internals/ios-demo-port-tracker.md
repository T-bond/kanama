# iOS Demo Port Tracker

Public-safe status for the iOS Kotlin/Native demo ports. Keep private device IDs, signing teams,
local-path commands, raw logs, and running handoff notes outside this repo.

## Current Status

The Android-enabled public demo set now builds and runs on iOS, plus Bunnymark. iOS is still
experimental: this is demo parity, not desktop-level support.

| Demo | iOS device status | Notes |
|---|---|---|
| Bunnymark | Playable | FPS/Bunnies readouts are safe-area adjusted. |
| Starter-Kit-Match3 | Playable | Reference 2D port. |
| Starter-Kit-3D-Platformer | Playable | `NodePath` script property delivery validated. |
| godot-demo-2d-dodge-the-creeps | Playable + touch controls | No-arg custom signal emission fixed; PathFollow/Input/AudioStreamPlayer gaps closed. |
| godot-demo-3d-squash-the-creeps | Playable + touch controls | PathFollow3D/RenderingServer/Input/math/value-type gaps closed. |
| godot-4-3d-character-controller | Playable | Flag works; death plane respawns after persistent frame-hook fix. |
| Starter-Kit-Racing | Playable | Steering joystick and camera-follow validated; `VirtualJoystick` is built into Godot 4.7. |
| Starter-Kit-FPS | Playable | F1/F2 complete. `List<Weapon>` delivery, AnimatedSprite3D generation, Tween glue, and SceneTree tween creation fixed. |
| godot-4-3d-third-person-controller | Playable | Attack crash, Mobile/Vulkan visuals, and `List<String>` animation-loop delivery fixed. |
| Starter-Kit-City-Builder | Hold | Not part of the Android-enabled demo set; still useful later for GridMap/custom-list coverage. |
| tps-demo-kanama | Blocked | Needs `@Rpc` config delivery before the multiplayer demo is meaningful. |

## Build / Deploy Pointers

- Build-check a demo's scripts with `installIosAddon` and a full Xcode `DEVELOPER_DIR`.
- Deploy/launch with `kanama-demos/scripts/ios_device_run.sh`.
- Use `xcrun devicectl device process launch --console` for gameplay crashes; the runtime logs script
  resource/instance creation and registered method calls.
- Keep device IDs, signing values, and exact local commands in the private handoff, not here.
- Warn before a device launch when the phone may be locked.

## Generator Gotcha

Regenerate iOS wrappers with the full currently-emitted class union, not a single
`--ios-emit-class X`. A single-class run can drop methods returning other wrapper types because the
generator only emits returns whose classes are in the active iOS wrapper set.

Before copying regenerated files:

1. Build the full emitted-class union from existing generated wrapper files.
2. Regenerate to a temporary directory.
3. Confirm the target file did not lose methods (`removed_funs=0` or equivalent diff check).
4. Copy only intended new/changed wrappers plus generated support files.
5. Run `compileKotlinIosArm64`; device-validate if the change affects runtime behavior.

## Fixed Demo-Port Bugs

- Script registration moved to the shared KSP model; the old iOS regex parser is gone.
- iOS `@ScriptProperty` delivery now covers value types, user-script lists, engine-wrapper lists, and
  `List<String>` / PackedStringArray.
- Script method dispatch supports argument-bearing generated `<Class>Methods` helpers.
- Custom signals, bound/lambda Callables, `SignalConnection.close`, and non-object signal payloads are
  wired.
- The iOS frame hook is persistent; `MainThread.awaitNextFrame` / deferred frame work no longer stops
  after the startup probe.
- `AnimationMixer.getStateMachinePlayback` wraps raw OBJECT handles from the Variant-call path.
- FPS F2: the apparent Audio autoload `_ready` SIGSEGV was actually `Player._ready` calling
  `getTree().createTween()` through inherited `Node.createTween()`. iOS `SceneTree.createTween()` now
  uses the `SceneTree.create_tween` method bind, and `Node.createTween()` is overridable so this
  subclass-specific wrapper can exist until SceneTree is generated normally.

## Next Demo-Relevant Work

- tps-demo-kanama: deliver `@Rpc` multiplayer config to Godot.
- City-Builder: reassess only after the supported-demo/export work, because it is outside the current
  Android-enabled public demo set.
- Re-run the full physical-device demo matrix after the iOS export workflow is documented and after
  any generator/commonMain migration.
