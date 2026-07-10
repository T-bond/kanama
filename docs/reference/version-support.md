# Version Support

Kanama `0.3.0` is the current public preview line. This page records the
platforms and engine versions validated for the current preview.

## Current Support Claims

| Target | Status | Notes |
| --- | --- | --- |
| Godot 4.7 stable, macOS arm64 | Supported (4.7 stable) | API/header inputs, generated wrappers, KDoc, local CI, and desktop demo smokes target this baseline; `runtime_smoke.sh` passed against the 4.7 stable binary (2026-06-21). Primary supported runtime and package target. |
| Android export, Godot 4.7 stable | Experimental; device-validated on 4.7 stable | Device-validated (4.7 stable): Pixel 7 debug demo matrix + R8-minified Match3 release APK (2026-06-26); OpenGL Compatibility renderer. `scripts/android_smoke.sh` also passes on the API 36 emulator (plugin AAR build, APK export, install/launch, script-language registration `Error=0`, non-blank frame). Android toolchain: SDK API 36, build-tools 36.1.0, NDK 29.0.14206865. The R8/minified claim is tied to the PanamaPort fork `com.github.falcon4ever.PanamaPort:Core:0.1.3-kanama-r8.2`, not upstream. Still experimental. |
| Linux arm64 | Supported pending 4.7 stable revalidation | Last local runtime, editor, and demo smoke validation passed with the 4.7 beta 2 ARM64 binary. Packaged desktop exports remain a separate release-readiness track. |
| Linux x86_64 | Supported pending 4.7 stable revalidation | Last local runtime, editor, and demo smoke validation passed with the 4.7 beta 2 x64 binary. Packaged desktop exports remain a separate release-readiness track. |
| Windows x86_64 | Supported pending 4.7 stable revalidation | Last local runtime/editor smoke validation passed with the 4.7 beta 2 console binary. PowerShell Gradle commands and Git Bash smoke marker checks are the documented path. |
| iOS | Experimental (Kotlin/Native backend); not a supported export | The iOS backend runs full Kanama project scripts via a C shim + Kotlin/Native static `.xcframework`, using the same wrapper generator as desktop/Android. The full device gate (9-demo matrix + fresh-project install path) has passed on **iPhone 12** (iOS 26.5, 2026-06-25; 0 guardrail failures) and on **iPhone 15 Pro** (iOS 26.5, 2026-07-10, on the full-breadth wrapper runtime); both on 4.7 stable iOS templates. One FPS Audio autoload follow-up is tracked as non-blocking. Still experimental — see [exporting/ios.md](../exporting/ios.md) for the export flow and remaining caveats. |
| Web | Not planned | Kanama depends on a JVM/FFM-style runtime path. |

Validated support is only claimed after the matching smoke path passes.
Use the
[Godot 4.7 stable archive](https://godotengine.org/download/archive/4.7-stable/)
for compatible desktop binaries and Android export templates.

## API Baseline

The checked-in wrapper surface is generated from the current
`extension_api.json`, `gdextension_interface.h`, generated Panama bindings, and
Kotlin wrapper sources. For this preview, that API baseline is Godot 4.7
stable.

The 4.7 rc 2 → 4.7 stable bump was a metadata-only change: the dumped
`extension_api.json` (excluding the `version_status` header field) and
`gdextension_interface.h` are **byte-identical** between the two builds, so the
generated wrappers, Panama bindings, name constants, and struct layouts are
unchanged and the rc 2 validation carries over. `scripts/runtime_smoke.sh`
passed against the macOS arm64 4.7 stable binary
(`4.7.stable.official.5b4e0cb0f`) on 2026-06-21. iOS (iPhone 12 self-test) and
Android (`android_smoke.sh` on the API 36 emulator, Starter-Kit-Match3) also
re-passed against 4.7 stable templates the same day. The Pixel 7 hardware
device gate (debug demo matrix + R8-minified Match3 release APK) has passed
(2026-06-26); Linux/Windows remain pending 4.7-stable revalidation (no local
binaries).

## Kanama Version

The current Gradle artifact version is `0.3.0`.

Release version changes should be paired with matching Gradle coordinates, docs
snippets, demo project versions, badges, changelog headings, and a passing
smoke matrix for every claimed target.

## Build Toolchain

The current source build uses Kotlin `2.3.21`, KSP `2.3.9`, and
kotlinx.coroutines `1.11.0`. Gradle build cache is enabled for the main Kanama
build and the experimental Android plugin build.

## Android

Android is tracked separately from the desktop matrix. The current Android path
uses:

- Godot 4.7 stable Android export,
- Android SDK API 36, build-tools 36.1.0, and NDK 29.0.14206865 for the
  matching Godot export templates,
- a Godot Android plugin AAR,
- Android ART,
- [PanamaPort](https://github.com/vova7878/PanamaPort),
- emulator smoke tests, and
- Pixel 7 device smoke and playability checks for the Android-enabled demos.

The Godot 4.7 stable Android emulator smoke path and the Pixel 7 device gate
(debug demo matrix + R8-minified Match3 release APK) have both passed. Android
support stays labeled **experimental, device-validated**: the validated renderer
is OpenGL Compatibility only, and the R8/minified path depends on Kanama's
PanamaPort fork rather than upstream.

See [Android Experimental](../exporting/android.md) for the build/export
workflow and [Android Internals](../contributing/android-internals.md) for
implementation details.

## iOS

iOS runs full Kanama project scripts on the Kotlin/Native backend, but remains
experimental (not a supported export). The backend uses a static `.xcframework`, a C
GDExtension shim, and a Kotlin/Native runtime, with GENERATED Godot API wrappers (the
same generator as desktop/Android) over a C-shim generic ptrcall. The current iOS demo
corpus has playable device runs; per-frame Kanama script+binding overhead is ~0.63 ms
on iPhone 12. Physical-device export and launch are the validation target; simulator
runs are optional compile/link checks and not a frame-rate signal.

Do not describe iOS as supported at desktop level. The support claim stays below desktop
until the export workflow is user-facing, the known FPS Audio follow-up is closed or
documented as a non-blocking limitation, and a broader physical-device matrix has passed.

See the [iOS export workflow](../exporting/ios.md), the
[iOS backend architecture](../internals/reference/ios-backend-architecture.md) (guardrails, how it
stays in sync with desktop/Android), and the
[iOS demo port tracker](../internals/active/ios-demo-port-tracker.md) (per-demo coverage).

## Local Validation

Run the local CI shortcut with one or more Godot binaries:

```sh
scripts/local_ci.sh /absolute/path/to/godot-4.7-stable
```

Before tagging a release, run the isolated source-and-demo gate from a clean
temporary clone:

```sh
scripts/fresh_clone_smoke.sh /absolute/path/to/godot-4.7-stable
```

For package validation, build the packaged artifacts and smoke them without a
sibling Kanama checkout:

```sh
./gradlew packageDistributions
scripts/package_install_smoke.sh \
  --desktop-kit \
  build/distributions/kanama-desktop-kit-v<version>-<platform>.zip \
  /absolute/path/to/godot-4.7-stable
scripts/package_install_smoke.sh \
  --store-addon \
  build/distributions/kanama-store-addon-v<version>.zip \
  /absolute/path/to/godot-4.7-stable
```

```sh
scripts/local_ci.sh \
  /absolute/path/to/godot-4.7-stable \
  /absolute/path/to/godot-4.7-stable
```

The script runs the main local checks:

- API constant validation against `extension_api.json`,
- Gradle jar sync,
- native bootstrap configure/build when CMake is available,
- strict docs build when `mkdocs` is available,
- runtime smoke through `scripts/runtime_smoke.sh`,
- `@Tool` editor execution smoke, and
- hot-reload smoke.

`runtime_smoke.sh` checks the core Kanama runtime path: Godot loads the
GDExtension, starts the JVM, registers the script language/resource loader,
loads Kotlin scripts, and runs the example project far enough to verify the
expected markers.

For Linux desktop validation, use a matching Linux Godot binary from the Godot
4.7 stable archive and set `JAVA_HOME` to JDK 25+:

```sh
cd /path/to/kanama-demos
JAVA_HOME=/path/to/jdk-25 \
XDG_DATA_HOME=/tmp/kanama-godot-state-linux \
KANAMA_DESKTOP_SMOKE_LOG_DIR=/tmp/kanama-desktop-smokes-linux \
scripts/desktop_smoke_all.sh /path/to/Godot_v4.7-stable_linux.arm64
```

Use the Godot binary for the architecture under test, such as
`Godot_v4.7-stable_linux.arm64` or
`Godot_v4.7-stable_linux.x86_64`. The demo smoke script uses Godot's OpenGL
Compatibility renderer on desktop. Before refreshing demo addons, rebuild the
native bootstrap from a clean checkout and preflight `libkanama_bootstrap.so`
with `file`, `ldd`, and `readelf`.

For Windows validation, launch Godot from an environment with `JAVA_HOME` set
to JDK 25+ so Kanama can load `%JAVA_HOME%\bin\server\jvm.dll`. Build the
native bootstrap from a Visual Studio 2022 C++ developer environment, and use
PowerShell/`.\gradlew.bat` for Gradle commands. Existing Bash smoke scripts can
hit CRLF-related false negatives on Windows; use the 4.7 stable console binary,
PowerShell Gradle commands, and Git Bash smoke marker checks for the documented
path.

Install docs dependencies with:

```sh
pip install -r docs/requirements.txt
```

## Godot Upgrade

Kanama re-pins only on stable Godot releases. The single authoritative process
for bumping the baseline — the pin edit, the mechanical
`scripts/upgrade_godot.sh` pipeline, the gates, and the human-judgment steps —
is the [Godot Upgrade Runbook](../contributing/godot-upgrade.md). Support
claims never move before the matching smoke/device gates pass on the new
baseline.

## Compatibility Gates

Treat these as high-risk when moving to a new Godot version:

- GDExtension struct layouts.
- Script language and script instance virtual method surfaces.
- MethodBind and utility-function hashes.
- Builtin method hashes and constructor indexes.
- `VariantType` enum ids.
- Builtin type sizes such as Variant and GDExtensionCallError.
- Generated header function names such as `classdb_register_extension_class6`.
- `.gdextension` compatibility metadata.
- Engine singleton lifetime policy. Godot 4.7 preview builds warn when
  `Engine.register_singleton` receives a `RefCounted`; Kanama rejects this in
  `Engine.registerSingleton` and audits built-in singletons so singleton
  handles remain engine-owned `Object` instances.
