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
| **character-controller** | playable; flag works; death plane respawns (V1 fixed) |
| **Racing** | playable + camera-follow + steering joystick (R1 validated) |
| **Bunnymark** | playable; FPS + Bunnies readouts safe-area-inset (E1 validated) |
| **FPS** | playable; weapons `List<Weapon>` @ScriptProperty delivered + AnimatedSprite3D generated (F1). KNOWN: intermittent SIGSEGV in Audio autoload `_ready` (pre-existing lambda-connect infra, see F2) |
| third-person | not built (see T1) |

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
- **V1 frame hook stopped firing** — `kanama_ios_frame` (C, `kanama_ios_shim.c`) hard-capped at 30 frames
  then set `g_main_loop_callbacks_active = 0`, permanently killing `MainThread.pumpNextFrame()` and ALL
  frame-deferred logic (`awaitNextFrame`/`postNextFrame`/`postAfterFrames`, incl. `KillPlane3D` deferred
  respawn). Cap was redundant — Kotlin `frame()` already self-terminates its startup probe via
  `probeLabelUpdated`. Removed the cap → persistent per-frame hook. Device-verified: death plane respawns.
- Demos: iOS gdextension entries; `mobile_controls.gd` enabled on iOS (`or OS.has_feature("ios")`);
  cross-platform script idioms; character flag reloads the level instead of quitting.
- **R1 Racing steering — no fix needed.** `VirtualJoystick` is a **built-in Godot 4.7 class** (confirmed
  via `--doctool`: `doc/classes/VirtualJoystick.xml`), so it's already in the iOS export template — it was
  never "absent on iOS". The only thing required was making the `MobileControls` CanvasLayer visible on
  iOS, already done by `mobile_controls.gd` (commit `5c060ab`). Input actions `left`/`right` exist in
  `project.godot`. Device-validated on iPhone 15 Pro: steering joystick turns the car.
- **F1 FPS demo (`Starter-Kit-FPS`)** — builds + plays on device (iPhone 15 Pro). Fixes:
  - **Generated `AnimatedSprite3D` + `SpriteBase3D`** via the full `--ios-emit-class` union (per the
    CRITICAL gotcha). Verified the regen did NOT overwrite 5 existing files that the fresh generator
    would have *shrunk* (`getCollider`/`shapeOwnerGetOwner`/Kinematic `getCollider`/`getColliderShape`
    return bare `Object` — kept the committed versions); all ptrcall shapes the 2 new files use already
    exist. Only the 2 new files were copied in.
  - **iOS API methods:** `GodotObject.hasMethod`/`isQueuedForDeletion`, `AudioStreamPlayer.setStream(null)`,
    `Resource.fromHandle` (now non-null, matching desktop — satisfies `KanamaScript<Resource>` selfFactory),
    `ResourceLoader.loadPackedScene`, `GD.degToRad`/`radToDeg`, and `Tween.bindNode`/`setEase`/`tweenCallback`/
    `EASE_OUT_IN` (+`CallbackTweener`). `tween_callback` needed a new C shim
    (`kanama_ios_godot_tween_tween_callback`, builds the method-Callable via the existing
    `g_callable_object_method_constructor`, boxes it, calls via the Variant path) + `.h` decl + cinterop.
  - **iOS KSP emitter (`IosScriptCodeEmitter`) — two parity gaps:** (a) `<Class>Methods.<m>(target, args…)`
    typed dispatchers were emitted **only for zero-arg** methods; now emitted for arg-bearing methods too
    (unblocked `PlayerMethods.damage(collider, 5.0)`). (b) **THE crash root cause:** a
    `List<UserScript>` `@ScriptProperty` (`Player.weapons: List<Weapon>`, Weapon = user `@ScriptClass`
    Resource) was **silently dropped** — the emitter only generated `setPropertyObjectArray` for arrays of
    *engine* wrapper types (`listElementClassName` was empty for user scripts), so the property advertised
    to the engine had no delivery case → `weapons` stayed `emptyList()` → `Player.ready()` threw
    `IllegalStateException: Player requires at least one Weapon`. Fixed by resolving each delivered owner
    handle via `iosScriptInstanceForOwner(it) as? <Fq>` (mirrors the node_paths single-object case). The
    C array-extraction path already existed (`set_property_array`); only the bridge case was missing. Also
    fixed a latent sibling: the engine-wrapper array case had an un-compiled lambda-inference shape; both
    now route via `.toList()` + explicit-typed lambda param (`LongArray` lacks `mapNotNull`). Device-confirmed:
    `property array set ... index=3 count=2`.
  - **KNOWN-FOLLOWUP (F2):** intermittent **SIGSEGV in the Audio autoload `_ready`** (12× `AudioStreamPlayer.create`
    + lambda `signal("finished").connect{…}` in a loop), hits *before* `Player._ready`. Pre-existing iOS
    lambda-connect/AudioStreamPlayer-lifetime infra — **not** an F1 change. Repros under the
    `KANAMA_FPS_SMOKE=1` harness; intermittent in normal play (works after restart). Suspect loop-captured
    `player` in the lambda or ref-counting under 12 rapid connects.
- **E1 Bunnymark readout safe-area** — `Benchmarker.gd` now insets the top-left readouts on mobile by
  `DisplayServer.get_display_safe_area().position + SAFE_AREA_MARGIN(24,24)` (`_apply_safe_area()`).
  Stretch mode is disabled, so GUI coords == screen px. TWO readouts needed it: the scene `Panel/FPS`
  Label AND the **Kotlin-created "Bunnies" Label** (`BunnymarkV2/V3Kanama.kt`, `position=(0,20)`, not
  safe-area-aware) — the latter is offset from GDScript via `find_children(...,"Label")` after
  `add_child`, so no Kotlin rebuild/dual-target needed. In landscape the safe-area *top* inset is tiny,
  hence the fixed margin. Device-validated on iPhone 15 Pro.

## Remaining tasks (each resumable on its own)

### F2. FPS Audio autoload `_ready` SIGSEGV (intermittent)
FPS demo is otherwise playable (F1 done). The Audio autoload's `_ready` creates 12 `AudioStreamPlayer`s
and lambda-`connect`s each `"finished"` signal in a loop; intermittently SIGSEGVs (signal 11) *before*
`Player._ready`. Pre-existing iOS lambda-connect / AudioStreamPlayer-lifetime infra (not an F1 change).
Repro: launch with `KANAMA_FPS_SMOKE=1` (the smoke harness reliably hit it twice; normal play is
intermittent — works after restart). Suspect the loop-captured `player` lambda capture or RefCounted
lifetime under 12 rapid `connect`s. Pull the `.ips` for the native backtrace (idevicecrashreport could
not see the network-paired device this session; try USB or `xcrun devicectl`).

### T1. third-person (`godot-4-3d-third-person-controller`)
Largest. Generate `SpringArm3D`, `ShapeCast3D`, `MeshDataTool`, `SurfaceTool`, `MultiMeshInstance3D`,
`WorldEnvironment`; add `Engine`/`Time`/`ProjectSettings`/`PhysicsServer3D`/`InputMap`,
`Quaternion.fromEuler`, `Object.hasMethod`/`call`/`isInstanceValid`/`getInstanceId`,
`Resource.loadPackedScene`/`loadAudioStream`, `Tween.tweenCallback`/`tweenMethod`/`setPaused`.

### Misc
- Roadmap table: `docs/internals/ios-backend-roadmap.md` (keep in sync).
- V1 landed (frame hook now persistent). Worth re-testing signal-heavy + frame-deferred flows across all
  demos now that `awaitNextFrame`/`postNextFrame`/`postAfterFrames` work for the whole session.
