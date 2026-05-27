# Kanama Addon

Kanama lets Kotlin scripts attach to Godot nodes through a GDExtension runtime
powered by the JVM and the Foreign Function & Memory API.

This addon package is install-safe for existing Godot projects. It provides:

- `addons/kanama` with the runtime jar, `.gdextension` descriptor, native
  bootstrap libraries, and local Maven artifacts,
- `addons/kanama_tools` with the optional editor build tools, and
- starter Gradle templates under `addons/kanama/templates/release-kit`.

Desktop projects require Godot 4.7 beta 3 or newer matching Kanama's supported
version and JDK 25 or newer. Set `JAVA_HOME` if Kanama cannot find `libjvm`.
