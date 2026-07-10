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
| Starter-Kit-City-Builder | Desktop-only by design | Desktop-focused controls (GridMap/custom-list); not a mobile target and not reassessed for mobile. |
| tps-demo-kanama | **RUNS on iPhone 15 Pro** (device-validated 2026-07-09) — playable, robots fully functional | Compiles + **runs on device**: menu, threaded level load (with loading-bar progress), 3D level, player movement/camera/animation, aim, and robot line-of-sight/laser raycasts all work on Kotlin/Native. Device-enablement: added the iOS export preset; `loadThreadedRequest useSubThreads=false` (iOS K/N⇄Godot bridge deadlocks on multi-worker-thread `.kt` loads); `loadThreadedGet*` fetch via the synchronous C-shim (Variant-path handle failed `PackedScene.instantiate()`). The earlier `intersectRay` stub is **filled**: `intersect_ray`/`set_exclude` C-shim + Vector2/3/Color variant returns landed 2026-07-09. Follow-up scope (touch/multiplayer UI polish) is `kanama-tasks/26-tps-demo-mobile-ui-port.md`. |

### tps-demo-kanama iOS surface (task 24, closed 2026-07-09)

How the TPS surface is hosted today:

- **12 wrapper classes** (`CPUParticles3D`, `DisplayServer`, `ShaderMaterial`,
  `MultiplayerSynchronizer`, `SceneMultiplayer`, `AnimationTree`, `ConfigFile`, `LightmapGI`,
  `OmniLight3D`, `SpotLight3D`, `BoneAttachment3D`, `FastNoiseLite`) are in the generated iOS
  wrapper set (since task 30, the full desktop-equivalent set); their ptrcall marshalling is auto-generated into
  `ObjectCallsGenerated.kt` over the generic C-shim ptrcall — no bespoke C was needed.
- **Companion factories / downcasts** (`create()` / `fromResource` / `fromApi`) are hosted in the
  generator's `IOS_CUSTOM_COMPANION_MEMBER_SECTIONS`, so regeneration is lossless and the
  drift-gate covers them.
- **Documented hand-written policy exceptions** (task-24 hand-written-surface audit): the
  `ptrcallWithDoubleAndThreeBoolArgsRetObject` helper stays hand-written in the `ObjectCalls.kt`
  reference template because its only consumer, `SceneTree.create_timer`, lives on the
  hand-written `SceneTree` collision class — it is registered in `IOS_HANDWRITTEN_HELPERS` (so
  the generator never double-emits it) and covered by `audit_ptrcall_helper_layouts.py`. The iOS
  `GD` print facade and `Mathf` helpers (`IosGodotApi.kt`) sit inside `KANAMA-IOS-HANDWRITTEN`
  marked sections and are listed in the generated registry
  (`docs/internals/reference/ios-backend-handwritten.md`). No unhosted hand-written surface
  remains from the TPS push.
- **`java.io.File`** smoke-marker shim is inert on iOS by design (the marker is
  desktop-smoke-only, never set on device); the demo scripts use Kotlin/Native-portable
  replacements.

Remaining TPS work is mobile-UI polish (touch controls, mobile multiplayer UI) — task 26.

## Build / Deploy Pointers

- Build-check a demo's scripts with `installIosAddon` and a full Xcode `DEVELOPER_DIR`.
- Deploy/launch one demo with `kanama-demos/scripts/ios_device_run.sh`.
- Run the repeatable physical-device gate with `scripts/ios_device_gate.sh`.
- Use `xcrun devicectl device process launch --console` for gameplay crashes; the runtime logs script
  resource/instance creation and registered method calls.
- Keep device IDs, signing values, and exact local commands in the private handoff, not here.
- Warn before a device launch when the phone may be locked.

## Device Gate Procedure

The public physical-device gate covers the current nine-demo matrix and a fresh starter-project install
path. It is intentionally environment-driven so public files never contain device UDIDs, Apple team IDs,
provisioning profile names, or workstation paths.

Prerequisites:

- Godot 4.7 stable and matching iOS export templates installed.
- Full Xcode app selected through `DEVELOPER_DIR` or `--xcode-select`.
- A trusted, unlocked physical iPhone with Developer Mode enabled.
- The Apple Development profile for the signing account trusted on the device
  (`Settings` -> `General` -> `VPN & Device Management`).
- Local signing values exported from private maintainer notes:
  `KANAMA_IOS_DEVICE` and `KANAMA_IOS_TEAM`.
- The companion `kanama-demos` checkout available next to this repo or passed with `--demos-root`.

Run the full gate from the Kanama checkout:

```sh
KANAMA_IOS_DEVICE=<private-device-udid> \
KANAMA_IOS_TEAM=<private-apple-team-id> \
scripts/ios_device_gate.sh \
  --godot /Applications/Godot.app/Contents/MacOS/Godot \
  --device-label "iPhone model, iOS version" \
  --allow-provisioning-updates
```

When the signing account is limited to a small number of installed free-development apps, use a single
already-provisioned bundle ID for copied demo exports:

```sh
KANAMA_IOS_DEVICE=<private-device-udid> \
KANAMA_IOS_TEAM=<private-apple-team-id> \
scripts/ios_device_gate.sh \
  --gate-bundle-id <locally-provisioned-bundle-id>
```

The gate copies demo projects into its output directory before patching the bundle ID, so the companion
demo checkout is not modified.

The gate runs:

1. Fresh starter project: `createStarterProject` -> `installIosAddon` with project scripts -> Godot iOS
   export -> Xcode build -> device install -> launch.
2. Bunnymark.
3. Starter-Kit-Match3.
4. Starter-Kit-3D-Platformer.
5. godot-demo-2d-dodge-the-creeps.
6. godot-demo-3d-squash-the-creeps.
7. godot-4-3d-character-controller.
8. Starter-Kit-Racing.
9. Starter-Kit-FPS.
10. godot-4-3d-third-person-controller.

Record only public-safe baseline data here: device model, iOS version, Godot version, pass/fail, rough
load or gate elapsed time, and observed FPS/readouts where the app exposes them. Keep raw logs, device
UDIDs, signing team IDs, local output paths, and exact private shell commands in maintainer notes.
The gate removes older known Kanama iOS gate apps before installing the next app by default, but leaves
the active app installed. This avoids most free-profile installed-app limit failures without causing the
device to forget the currently trusted app.

## Device Gate Baselines

Last full gate refresh: 2026-07-10 on iPhone 15 Pro, iOS 26.5, with Godot 4.7 stable, on the
**full-breadth iOS runtime** (task 30: 1017 generated wrapper classes + the RefCounted ownership
mirror). All ten steps passed. As `ios_device_gate.sh` runs it, every demo is copied and its export
bundle ID is rewritten to the single reusable gate bundle ID (`--gate-bundle-id`, default
`net.multigesture.kanama.devicegate`) before install/launch, so only one gate app needs to remain
installed on the device throughout the matrix.

This run is a maintainer-run snapshot: the first four rows ran through the stock serial gate
(~385-400s per row, dominated by the per-demo Kotlin/Native addon build + Xcode static link of the
full-breadth runtime); the remaining six ran through a pipelined variant (serial Gradle/export lane,
two parallel Xcode builds, in-order install+launch), so those rows have no meaningful per-row
elapsed time. Treat all timings as rough, device-dependent baselines rather than reproducible
measurements.

| Path | Device / OS | Godot | Result | Load / gate elapsed | FPS / readout | Notes |
|---|---|---|---|---:|---|---|
| Fresh starter project | iPhone 15 Pro, iOS 26.5 | 4.7 stable | Pass | 399s | Probe label ready | Fresh `createStarterProject` + `installIosAddon` path. |
| Bunnymark | iPhone 15 Pro, iOS 26.5 | 4.7 stable | Pass | 390s | Visible on device; not machine-captured | Serial gate row. |
| Starter-Kit-Match3 | iPhone 15 Pro, iOS 26.5 | 4.7 stable | Pass | 383s | Visual launch pass | Serial gate row. |
| Starter-Kit-3D-Platformer | iPhone 15 Pro, iOS 26.5 | 4.7 stable | Pass | 385s | Visual launch pass | Serial gate row. |
| godot-demo-2d-dodge-the-creeps | iPhone 15 Pro, iOS 26.5 | 4.7 stable | Pass | (pipelined) | Visual launch pass | Pipelined batch row. |
| godot-demo-3d-squash-the-creeps | iPhone 15 Pro, iOS 26.5 | 4.7 stable | Pass | (pipelined) | Visual launch pass | Pipelined batch row; earlier same-day debug launch also captured `PTRCALL SELFTEST MATRIX: 70/0` + `OBJECTCALLS SELFTEST: 111/0` (incl. the RefCounted ownership probe) on this runtime. |
| godot-4-3d-character-controller | iPhone 15 Pro, iOS 26.5 | 4.7 stable | Pass | (pipelined) | Visual launch pass | Pipelined batch row. |
| Starter-Kit-Racing | iPhone 15 Pro, iOS 26.5 | 4.7 stable | Pass | (pipelined) | Visual launch pass | Pipelined batch row. |
| Starter-Kit-FPS | iPhone 15 Pro, iOS 26.5 | 4.7 stable | Pass | (pipelined) | Visual launch pass | Pipelined batch row. |
| godot-4-3d-third-person-controller | iPhone 15 Pro, iOS 26.5 | 4.7 stable | Pass | (pipelined) | Visual launch pass | Pipelined batch row. |

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

- tps-demo-kanama: runs on device (see the status row above); run focused multiplayer smoke checks
  after runtime changes. Mobile *playability* polish (touch controls, mobile multiplayer UI) is
  tracked in `kanama-tasks/26-tps-demo-mobile-ui-port.md`.
- City-Builder: desktop-only by design (GridMap/custom-list, desktop-focused controls); not a mobile target and not reassessed for mobile.
- Re-run the full physical-device demo matrix after the iOS export workflow is documented and after
  any generator/commonMain migration.
