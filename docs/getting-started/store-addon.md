# Use a Store Addon

Use this path when you want to add Kanama to an existing Godot project without
cloning the Kanama source repository. The store addon is install-safe: it adds
files under `addons/` and keeps project-root Gradle files inside a template
folder until you copy them.

## 1. Download the Addon

Download `kanama-store-addon-v<version>.zip` from a Kanama GitHub release and
unzip it at the root of your Godot project.

The zip adds:

- `addons/kanama` with the Kanama runtime, native libraries, and local Maven
  repository,
- `addons/kanama_tools` with optional editor build tools, and
- `addons/kanama/templates/release-kit` with Gradle starter files.

On macOS, clear quarantine after unzipping a package you trust:

```sh
xattr -dr com.apple.quarantine /absolute/path/to/project
```

## 2. Add the Build Template

If the project does not already have a Gradle build, copy the packaged template
files to the project root:

```sh
cp addons/kanama/templates/release-kit/build.gradle.kts .
cp addons/kanama/templates/release-kit/settings.gradle.kts .
cp addons/kanama/templates/release-kit/gradlew .
cp addons/kanama/templates/release-kit/gradlew.bat .
cp -R addons/kanama/templates/release-kit/gradle .
mkdir -p kotlin-src
cp addons/kanama/templates/release-kit/kotlin-src/HelloScript.kt kotlin-src/
```

If the project already has Gradle files, merge the Kanama repository,
dependency, KSP, and `buildScripts` sections from the template instead of
replacing your build.

## 3. Register the Extension

Kanama must be listed in Godot's extension list:

```sh
mkdir -p .godot
printf 'res://addons/kanama/kanama.gdextension\n' > .godot/extension_list.cfg
```

Then reopen or import the project in Godot.

## 4. Build Scripts

Compile the Kotlin scripts:

```sh
./gradlew buildScripts
```

On Windows:

```powershell
.\gradlew.bat buildScripts
```

This writes `addons/kanama/kanama-scripts.jar`. Attach `.kt` scripts to nodes
the same way you attach other Godot script resources.

## Troubleshooting

| Symptom | Fix |
| --- | --- |
| Godot cannot find `libjvm`. | Install JDK 25+ and set `JAVA_HOME` to the JDK home directory. |
| macOS reports `"libkanama_bootstrap.dylib" Not Opened`. | Clear quarantine on the unzipped project with `xattr -dr com.apple.quarantine /absolute/path/to/project`. |
| Gradle cannot resolve Kanama dependencies. | Confirm `addons/kanama/maven` exists and your build uses `maven { url = uri("addons/kanama/maven") }`. |
| Godot does not recognize `.kt` scripts. | Confirm `.godot/extension_list.cfg` contains `res://addons/kanama/kanama.gdextension`, then reopen/import the project. |
