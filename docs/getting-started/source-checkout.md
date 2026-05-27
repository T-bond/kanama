# Use a Source Checkout

Use this path when you want the current Kanama source tree to install into a
Godot project. It is also the right path for testing unreleased Kanama changes.

## 1. Clone Kanama

```sh
git clone https://github.com/falcon4ever/kanama
cd kanama
```

Keep the checkout near your Godot projects so the editor plugin can find
`gradlew`, or set `kanama/tools/repo_dir` in Godot project settings.

## 2. Create or Prepare a Godot Project

For a new starter project:

```sh
./gradlew createStarterProject \
  -PkanamaStarterProjectDir=/absolute/path/to/kanama-starter
```

For an existing project, copy only the safe starter files:

```sh
./gradlew installStarterTemplate \
  -PkanamaStarterProjectDir=/absolute/path/to/godot_project
```

`installStarterTemplate` copies `HelloScript.kt` and
`addons/kanama_tools` without replacing `project.godot` or your main scene.

## 3. Build and Sync Kanama

```sh
./gradlew installAddonJar \
  -PkanamaProjectDir=/absolute/path/to/kanama-starter \
  -PkanamaProjectScriptsDir=/absolute/path/to/kanama-starter
```

This builds `kanama.jar`, builds the host native bootstrap with CMake, compiles
project `.kt` files into `kanama-scripts.jar`, copies addon files into
`<kanamaProjectDir>/addons/kanama`, and registers the extension in
`<kanamaProjectDir>/.godot/extension_list.cfg`.

If your Kotlin scripts live outside the project root, point
`kanamaProjectScriptsDir` at that folder. For multiple roots, use
`-PkanamaProjectScriptsDirs=` with path-separated or comma-separated paths.

## 4. Open and Iterate

1. Open the project in Godot.
2. Confirm **Kanama Tools** is enabled in **Project > Project Settings > Plugins**.
3. Press **Play**.
4. Edit a Kotlin script.
5. Press **Build Scripts** in the Godot toolbar.
6. Press **Play** again.

See [The Editor Loop](editor-workflow.md) for hot reload and debugger setup.

## Source Checkout Notes

Building Kanama from source does not require a Godot source checkout. The
desktop native bootstrap uses the GDExtension headers tracked in this
repository, JDK 25 headers, CMake, and the platform C toolchain.

`syncExampleAddonJar` refreshes the checked-in example project and remains the
local smoke-test path:

```sh
./gradlew syncExampleAddonJar
```
