# Kanama Desktop Kit

This project is ready to run with the packaged Kanama addon.

## Build Kotlin scripts

```sh
./gradlew buildScripts
```

On Windows, use `gradlew.bat buildScripts`.

## Open in Godot

```sh
./gradlew openGodotEditor
```

You can also open the folder directly in Godot. The Kanama Tools editor plugin
adds a `Build Scripts` button that runs the same Gradle task.

## Requirements

- Godot 4.7 beta 3 or newer matching Kanama's supported Godot version.
- JDK 25 or newer. Set `JAVA_HOME` if Kanama cannot find `libjvm`.
