# Hot Reload Internals

This document describes the current `@ScriptClass` reload path.

## Scope

Kanama supports reload for attachable script classes:

- `@ScriptClass`: reloadable. These classes register script templates in
  `KanamaScript` and are loaded from `kanama-scripts.jar`.
- `@RegisterClass`: not reloadable. These classes are registered permanently
  in Godot's ClassDB and require an editor restart after changes.

## Runtime Flow

1. `./gradlew syncExampleAddonJar` builds the checked-in example project, or
   `./gradlew installAddonJar -PkanamaProjectDir=/path/to/project -PkanamaProjectScriptsDir=/path/to/project`
   builds an external project:
   - `kanama.jar`: the Kanama runtime and any runtime-bundled registrars.
   - `kanama-scripts.jar`: project `.kt` scripts plus generated project class
     and script registrars.
2. Godot loads `kanama.jar` through `bootstrap.c`.
3. `KanamaBinding.initializeCallback` registers the runtime:
   - `KanamaScript`
   - `KanamaScriptLanguage`
   - `.kt` resource loader/saver
   - optional permanent `KanamaRegistry` entries from the runtime jar
4. `KanamaHotReload.initialize()` loads `kanama-scripts.jar` through a
   child-first classloader.
5. On first load, the generated `KanamaClassRegistry` registers project
   `@RegisterClass` classes with ClassDB. These classes are permanent for the
   Godot process.
6. The generated `KanamaScriptRegistry` registers only reloadable
   `@ScriptClass` templates.
7. `KanamaScriptLanguage.callFrame()` periodically calls
   `KanamaHotReload.frameTick()`, which checks the script jar mtime and reloads
   changed templates.

## Editor Workflow

The optional `res://addons/kanama_tools` plugin provides `Build Scripts`,
debounced build-on-save, scene reload after sync, and JDWP settings. See
[The Editor Loop](../getting-started/editor-workflow.md) for the daily
workflow.

After a sync, existing `KanamaScript` resources are rebound to the newest
template. Scene reload is still recommended for reliable live-node replacement.

For breakpoint debugging, enable `kanama/debug/jdwp_enabled`. Kanama tools
registers `kanama/debug/jdwp_port` with the conventional runtime/game default
`5005`. Restart the game process after changing either setting. Kanama reads
these settings before starting the embedded JVM and enables JDWP at `*:PORT`
for runtime/game processes; attach IntelliJ with a **Remote JVM Debug**
configuration pointed at `localhost:PORT`. Editor processes skip the runtime
port so pressing Play does not create a port conflict.

## Verification

Use:

```sh
./scripts/hot_reload_smoke.sh /absolute/path/to/godot_binary
./scripts/runtime_smoke.sh /absolute/path/to/godot_binary
```

`runtime_smoke.sh` is the main headless runtime smoke. It verifies that Godot
loads Kanama, registers the script language and resource loader, and runs the
example project far enough to observe expected markers.

`hot_reload_smoke.sh` edits `example_project/HelloScript.kt`, rebuilds the
script jar, and verifies the changed marker appears in a new headless editor
run.

`hot_reload_in_process_smoke.sh` keeps one headless Godot process alive, edits
and rebuilds `kanama-scripts.jar`, waits for the runtime hot-reload loop to
rebind scripts, reloads the current scene, and verifies the updated script
marker without restarting Godot. It also checks retired script classloaders via
weak references and asserts that the old loader is collected after the old
script instance is freed.

## Current Behavior

- `@RegisterClass` hot reload is not supported because Godot ClassDB extension
  registrations are permanent for the process. Project `@RegisterClass`
  changes require an editor/game restart.
- Live in-place replacement of already-instanced nodes is partial; scene
  reload remains the reliable editor workflow.
- The child-first package list is fixed in `KanamaHotReload`.
