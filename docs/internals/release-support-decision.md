# Release Support Decision

> **Status: signed off and applied (0.3.0, 2026-07-06).** The maintainer adopted
> this recommendation for the 0.3.0 release: macOS is labeled **Supported (4.7
> stable)**, Linux/Windows **Supported pending 4.7-stable revalidation**, iOS and
> Android **co-tiered Experimental (device-validated)**. The §4 wording is live in
> `docs/index.md`, `docs/reference/version-support.md`, and
> `docs/exporting/{android,ios}.md`. See
> [post-release-direction.md](./post-release-direction.md) for the release outcome
> and next phase.
>
> **Phase 4 · B addendum (2026-07-10, task 25):** §7 defines the written
> Supported-mobile promotion bar and the packaging assessment; the §2/§3/§5
> matrix rows are refreshed for the iPhone 15 Pro full ten-step gate
> (2026-07-10) and the task-24 iOS heavy-demo landing. Tiers unchanged — mobile
> stays Tier 2 until §7 is fully green.

This document answers four questions for the 0.2.x release line:

1. Which platforms are **supported** vs **experimental**, and what does
   "supported" mean?
2. Which device / OS / Godot / JDK matrix must pass before a release tag?
3. Are iOS and Android the **same** support tier or **separate** tiers?
4. What wording should the public docs use?

Every claim below is grounded in a smoke or device gate that actually passed, per
the [AGENTS.md](https://github.com/falcon4ever/kanama/blob/main/AGENTS.md) rule:
*"Do not claim platform support unless the matching smoke path has passed."* Where
a gate only covered one device, the claim names that device — not a device family.

---

## 1. Platform support tiers

### What "supported" means

A platform is **supported** only when all of the following hold:

1. **Smoke path passed** — the matching automated smoke path is green on the
   current Godot baseline (AGENTS.md rule).
2. **Hardware validated** — a physical-device (not emulator/simulator) gate has
   passed. Emulator and simulator runs are compile/link and startup checks, not a
   support signal or a frame-rate signal.
3. **Packaging documented** — the export/packaging flow is user-facing in
   `docs/`, reproducible from a clean checkout without private handoff notes.
4. **Generator honest** — the full drift-gate is green (committed wrappers ==
   fresh regen per platform, `check_full_drift_gate`), there are 0 silent API
   stubs (`check_ios_no_silent_stubs.py`), and the coverage reports are refreshed.
5. **Below-desktop caveats are limitations, not blockers** — any remaining gap is
   documented as a bounded limitation, not an undocumented failure.

**Experimental** means (1)–(4) may hold but the platform is deliberately held
below "supported": packaging is not release-grade, the device matrix is narrow, or
per-platform caveats (renderer, dependency, demo breadth) keep the claim
conservative.

### Recommended tiers (0.2.x line)

| Tier | Platforms | Meaning |
|---|---|---|
| **Tier 1 — Supported** | Desktop (macOS validated; Linux/Windows pending 4.7-stable revalidation) | Primary supported runtime and package target. macOS arm64 meets all "supported" criteria on 4.7 stable. Linux/Windows are Tier 1 targets whose last full validation was on 4.7 **beta 2**; they are "supported pending revalidation" until re-run on 4.7 stable (a release-gate item, §6). |
| **Tier 2 — Experimental (device-validated)** | iOS **and** Android | Documented export path + a passing physical-device smoke gate + the Android-enabled public demo set passing on device. Explicitly **not** desktop-level support. Per-platform caveats in §5. |
| **Not planned** | Web | Kanama depends on a JVM/FFM-style runtime path. |

**Recommendation:** keep Tier 2 labelled **experimental**, not "supported with
caveats". The mobile backends have crossed the *demo-parity* bar but not the
*release-grade packaging + broad device matrix* bar that "supported" implies here.
Promotion to a supported mobile tier is a future decision, gated on the §7
promotion bar (plus the standing §6 checklists).

---

## 2. Required device / OS / Godot / JDK matrix

The matrix below is what a release tag must have green. Device **models** only —
UDIDs, signing team IDs, and provisioning profile names stay in private maintainer
notes per AGENTS.md.

### Engine + toolchain (all platforms)

| Item | Pin | Source |
|---|---|---|
| Godot | **4.7 stable** | `kanamaGodotVersion=4.7.stable` in `gradle.properties` (single-source pin, task 23; checked by `scripts/check_godot_version_pin.py`) |
| Desktop build/runtime JDK | **JDK 25+** | `jvmToolchain(25)` in `build.gradle.kts`; JDK 25 per [Version Support](../reference/version-support.md) |
| Android Gradle/export tooling JDK | **JDK 21** | [exporting/android.md](../exporting/android.md) toolchain table |
| Android game runtime | **ART + PanamaPort** (no JDK embedded) | [exporting/android.md](../exporting/android.md) |
| iOS runtime | **Kotlin/Native** static `.xcframework` (no JVM) | [exporting/ios.md](../exporting/ios.md) |
| Kotlin / KSP | **2.3.21 / 2.3.9** | [Version Support](../reference/version-support.md) |

### Per-platform validation matrix

| Platform | Device / environment | OS | Renderer | Result proven | Evidence |
|---|---|---|---|---|---|
| macOS (desktop) | Apple Silicon arm64 | — | project renderer / OpenGL Compat (demo smokes) | `runtime_smoke.sh` green vs 4.7 stable `4.7.stable.official.5b4e0cb0f` (2026-06-21) | [Version Support](../reference/version-support.md) |
| Linux (desktop) | arm64 + x86_64 | — | project renderer | **Pending 4.7-stable revalidation** (last green on 4.7 beta 2) | [Version Support](../reference/version-support.md) |
| Windows (desktop) | x86_64 | — | project renderer | **Pending 4.7-stable revalidation** (last green on 4.7 beta 2 console binary) | [Version Support](../reference/version-support.md) |
| Android | **Pixel 7** (physical) + API 36 emulator | Android | OpenGL Compatibility (demo default) | Full 4.7-stable debug APK demo matrix + R8-minified Match3 release APK, both on Pixel 7 (2026-06-26) | [exporting/android.md](../exporting/android.md), [architecture-review-2026-06.md](./reference/architecture-review-2026-06.md) |
| Android (Vulkan/Mobile renderer) | **Pixel 7** (physical, Mali-G710) | Android 16 | **Vulkan Forward Mobile** | Nine-demo smoke matrix, all green with a renderer-init assertion (`Vulkan 1.4.305 - Forward Mobile - Using Device #0: ARM - Mali-G710` + Kanama startup markers + non-blank frame per demo), 2026-07-10 via `KANAMA_ANDROID_RENDERER=mobile` | [exporting/android.md](../exporting/android.md) |
| iOS (full gate) | **iPhone 12** (physical) | iOS 26.5 | Godot iOS | Full 9-demo device gate + fresh-project install path, 0 guardrail failures; ~0.63 ms/frame binding overhead | [ios-demo-port-tracker.md](./active/ios-demo-port-tracker.md) (baseline 2026-06-25) |
| iOS (full gate, second model) | **iPhone 15 Pro** (physical) | iOS 26.5 | Godot iOS | Full ten-step device gate (fresh-project install + 9-demo matrix) on the **full-breadth runtime** (task 30, 1017 generated classes), all steps passed 2026-07-10; same-runtime self-tests PTRCALL 70/0, OBJECTCALLS 111/0 | [ios-demo-port-tracker.md](./active/ios-demo-port-tracker.md) (refresh 2026-07-10) |
| iOS (heavy demo) | **iPhone 15 Pro** (physical) | iOS 26.5 | Godot iOS | `tps-demo-kanama` runs playable on device (menu, threaded level load, movement/camera/animation, aim, robot raycasts), 2026-07-09 (task 24) | [ios-demo-port-tracker.md](./active/ios-demo-port-tracker.md) |

**Android SDK/NDK for the matching 4.7-stable export templates:** SDK API 36,
build-tools 36.1.0, NDK 29.0.14206865 ([Version Support](../reference/version-support.md)).

**iOS device note:** the *repeatable full device gate*
(`scripts/ios_device_gate.sh`, fresh-project install + the 9-demo matrix) has
now passed on **two models**: iPhone 12 (iOS 26.5, 2026-06-25 — the elapsed-time
baseline) and iPhone 15 Pro (iOS 26.5, 2026-07-10 — on the full-breadth task-30
runtime). Both run Godot 4.7 stable. This clears the two-model criterion for iOS
in §7 (B1). It is still stated as two named models, not a "recent iPhones"
device-family claim.

### Generator coverage state (for the support claim)

Promoted, checked-in wrapper coverage (`api_wrapper_coverage.py`,
[api-coverage.md](../contributing/api-coverage.md)):

- **Classes: 1036 / 1036 — 100%** (the last four — `AccessibilityServer`,
  `GDScriptLanguageProtocol`, `AreaLight3D`, `BlitMaterial` — promoted 2026-07-10)
- **Methods: 15373 / 15385 — 99.9%** (callable methods; engine virtuals tracked
  separately so they neither dilute callable coverage nor count as gaps)
- **Virtual methods** are dispatched via `@OverrideVirtual` and validated against a
  generated signature table. Marshalling bounds (tasks 13 + 29): desktop/Android
  cover **every Variant-expressible return family** (scalar/POD, String, all
  `Packed*` arrays, Dictionary, generic/typed Array, RID, Rect2, AABB,
  Transform2D, Transform3D, Projection, Variant); the only excluded returns are
  the 6 raw-pointer virtuals (`void*`/`const Glyph*`), by design. iOS
  value-returns cover everything except Rect2/AABB/Transform2D/Transform3D/
  Projection (documented by-design residue — see the wrapper-maintenance
  "Virtual-return coverage" section).

Cross-platform shape identity is enforced by `check_full_drift_gate` (committed ==
fresh regen per platform, task 21). This is what lets a single support claim cover
the generated API across desktop, Android, and iOS.

---

## 3. iOS vs Android — same tier or separate?

**Recommendation: the same tier (Tier 2 — Experimental, device-validated), not
separate tiers.**

The iOS sub-track's "Mobile Parity With Android" bar defines the convergence
criteria: both mobile backends should have a
documented export path, a physical-device smoke gate on the current Godot
baseline, and the Android-enabled public demo set passing on both. Both now meet
that bar:

| Convergence criterion | Android | iOS |
|---|---|---|
| Documented user-facing export path | ✅ [exporting/android.md](../exporting/android.md) | ✅ [exporting/ios.md](../exporting/ios.md) |
| Physical-device smoke gate on 4.7 stable | ✅ Pixel 7 (debug matrix + R8 Match3) | ✅ full ten-step gate on iPhone 12 (2026-06-25) **and** iPhone 15 Pro (2026-07-10) |
| Android-enabled public demo set on device | ✅ 8 demos | ✅ 9 demos (that set + Bunnymark) |
| Same generated wrapper API (drift-gate) | ✅ `check_full_drift_gate` | ✅ `check_full_drift_gate` |

Because they clear the same bar with the same generator, splitting them into
separate tiers would over-fit to their *caveats* rather than their *support level*.
Co-tiering keeps the public story simple: "desktop is supported; mobile (iOS +
Android) is experimental but device-validated."

**What each must keep proving to stay in Tier 2:**

- **Android:** the Pixel 7 (current-device) debug matrix and the R8-minified
  release APK gate stay green on the pinned PanamaPort fork; the OpenGL
  Compatibility path remains the validated renderer.
- **iOS:** the full `ios_device_gate.sh` 9-demo matrix + fresh-project path stay
  green on a recent iPhone; `compileKotlinIosArm64` and the on-device self-test
  matrix stay at 0 failures; 0 silent stubs holds.

**Asymmetries** (documented as §5 caveats, **not** tier splits): Android's
minified-release claim is tied to the PanamaPort fork, not upstream; iOS does not
run the heavy 3D / mobile-multiplayer demo (`tps-demo-kanama`). These are
per-platform limitations within the shared tier.

---

## 4. Wording recommendations for the public docs

These are **proposed** strings. Do not apply them here — application is
post-sign-off (§Out of scope). The theme: the public docs currently **under-claim
Android** (they still say "Pixel 7 pending", which task 05 closed), so the main fix
is to align them with the proven Pixel 7 gate while keeping "experimental".

### `docs/index.md` — Platform Status table

Current rows are stale for Android ("Pixel 7 pending") and thin for iOS. Proposed:

| Platform | Proposed status string |
|---|---|
| macOS | `Supported (4.7 stable)` |
| Linux | `Supported pending 4.7 stable revalidation` |
| Windows | `Supported pending 4.7 stable revalidation` |
| Android | `Experimental; device-validated on 4.7 stable (Pixel 7, OpenGL Compatibility)` |
| iOS | `Experimental (Kotlin/Native); device-validated on 4.7 stable (iPhone 12 / 15 Pro)` |
| Web | `Not planned` |

(Change from today: Android drops "emulator-validated … (Pixel 7 pending)" →
"device-validated … (Pixel 7, OpenGL Compatibility)". macOS "Validated" →
"Supported" only if the human adopts the Tier-1 "Supported" label; otherwise keep
"Validated (4.7 stable)".)

### `docs/reference/version-support.md` — Current Support Claims table

- **Android row** — replace `Emulator-validated (4.7 stable); Pixel 7 pending`
  with:
  `Device-validated (4.7 stable): Pixel 7 debug demo matrix + R8-minified Match3
  release APK (2026-06-26); OpenGL Compatibility renderer. Still experimental.`
  Keep the SDK/NDK detail and the note that the R8 claim is tied to the PanamaPort
  fork `com.github.falcon4ever.PanamaPort:Core:0.1.3-kanama-r8.2`, not upstream.
- **iOS row** — keep "Experimental (Kotlin/Native backend); not a supported
  export", but update the device detail to name both validated devices:
  `Full device gate on iPhone 12 (iOS 26.5); playable demo corpus + self-tests on
  iPhone 15 Pro; both on 4.7 stable iOS templates.`
- Update the "Pixel 7 hardware remains the Android gate" sentence in **API
  Baseline** — that gate has now passed; reword to "Pixel 7 hardware smoke has
  passed; Linux/Windows remain pending 4.7-stable revalidation."

### `docs/exporting/android.md`

Already accurate (it documents the passed Pixel 7 debug matrix and the R8 Match3
gate). Recommended tweak only: make the opening status line say
`experimental, device-validated on Pixel 7` so it reads consistently with the
index/version-support wording. Keep every renderer/dependency caveat.

### `docs/exporting/ios.md`

Already accurate and appropriately conservative ("experimental, not a supported
export"). Recommended tweak: in **Current Status**, distinguish the two devices
explicitly — the *full device gate* is iPhone 12; iPhone 15 Pro has *playable
corpus runs* — so the doc doesn't read as one device covering everything. Keep the
FPS Audio autoload follow-up noted as a non-blocking limitation.

---

## 5. Known limitations to document (not blockers)

These stay documented limitations for the 0.2.x line. None blocks the current
tiering; each is a bounded, disclosed gap.

### Cross-platform

- **No hot reload on mobile.** Hot reload is out of scope for both the iOS backend
  and Android (`Android hot reload is not designed and should be considered
  disabled`).
- **Virtual-return long tail deferred.** Other `Packed*` arrays and Dictionary
  `@OverrideVirtual` returns are not in the audited return set; iOS Variant
  returns are limited to the audited inner-type set (unaudited → `nil`). The
  Kotlin-lambda→Callable custom-callable path and Callable-as-Variant-arg remain
  deferred by design.

### iOS

- **Heavy 3D / mobile multiplayer is device-proven but not gate-tracked on
  iOS.** `tps-demo-kanama` **runs playable on iPhone 15 Pro** (2026-07-09, task
  24): menu, threaded level load with progress bar, movement/camera/animation,
  aim, and robot line-of-sight/laser raycasts all work on Kotlin/Native. What
  remains: mobile *playability* polish (touch controls, mobile multiplayer UI —
  `kanama-tasks/26-tps-demo-mobile-ui-port.md`), and the demo is not yet a row
  in the repeatable `ios_device_gate.sh` matrix (the gate covers the nine-demo
  set + fresh project). See the `tps-demo-kanama` row in
  [ios-demo-port-tracker.md](./active/ios-demo-port-tracker.md).
- **Device matrix breadth.** The repeatable full gate has passed on two models —
  iPhone 12 (2026-06-25) and iPhone 15 Pro (2026-07-10, full-breadth runtime).
  "Recent iPhones" as a device-family claim stays unproven; the matrix names the
  validated models. (Android is still single-model — Pixel 7; tracked as §7 B1.)
- **FPS Audio autoload follow-up.** Starter-Kit-FPS is playable but has an
  intermittent Audio autoload follow-up; documented as non-blocking.
- **Audited type set only.** The iOS type/KSP-registration set covers the current
  demo corpus; APIs outside it are not guaranteed on iOS.
- **`Starter-Kit-City-Builder` is desktop-only by design** (GridMap/custom-list,
  desktop-focused controls); not a mobile target.

### Android

- **Renderer defaults vs. validation.** The demo corpus ships
  `gl_compatibility` as its mobile renderer default. The **Vulkan/Mobile
  renderer smoke matrix passed on Pixel 7 (2026-07-10)** — all nine demos with
  a renderer-init assertion (§7 B2) — so the Android claim is no longer
  renderer-restricted at the smoke level. Gameplay/visual parity under Vulkan
  beyond the smoke bar (startup, Kanama markers, non-blank frame) remains
  per-demo validation.
- **R8/minification depends on the PanamaPort fork.** Minified release APKs are
  validated only with `com.github.falcon4ever.PanamaPort:Core:0.1.3-kanama-r8.2`.
  Upstream PanamaPort `v0.1.3` crashes in the FFI bootstrap under R8 (root-caused
  on Pixel 7, 2026-06-26) and is **not** an R8-supported path.
- **Per-demo mobile polish.** Orientation, screen size, touch controls, and UI
  scaling are per-demo, not a platform guarantee. First-use hitches on physical
  devices are expected without preloading.
- **Emulator rendering differs.** OpenGL Compat can differ from desktop Forward+
  (e.g. darker skybox in the 3D Platformer smoke); some ASTC textures may be
  converted at runtime.

### Desktop

- **Linux/Windows pending 4.7-stable revalidation.** Last full validation was on
  4.7 beta 2; the metadata-only 4.7 rc2→stable bump carries over for API/wrapper
  shape, but the runtime/demo smoke has not been re-run on stable Linux/Windows
  binaries. This is a release-gate item, not a limitation of the design.
- **Packaged desktop exports** are a separate release-readiness track from the
  editor/runtime smoke; package zips are not proof of exported-game support
  (AGENTS.md).

---

## 6. Release-gate checklist

Everything below must be green (or explicitly waived by the human with a
documented reason) before a release tag. This documents what is required; it does
**not** add new gates or run them (task 18 runs the release pass).

### Engine + version pins

- [ ] `python3 scripts/check_godot_version_pin.py` passes; `kanamaGodotVersion`
      is `4.7.stable` and the CI dash form matches.
- [ ] Gradle artifact version, docs snippets, demo project versions, badges, and
      changelog heading all match the tagged version.

### Desktop (Tier 1)

- [ ] `scripts/runtime_smoke.sh` green on macOS arm64 vs the 4.7 stable binary.
- [ ] **Linux + Windows revalidated on 4.7 stable** (currently pending) — desktop
      + demo smoke on matching 4.7-stable binaries.
- [ ] `scripts/fresh_clone_smoke.sh <godot-4.7-stable>` green from a clean temp
      clone.
- [ ] `./gradlew packageDistributions` + `scripts/package_install_smoke.sh`
      (`--desktop-kit` and `--store-addon`) green.

### Android (Tier 2)

- [ ] `scripts/android_smoke.sh` green on the API 36 emulator.
- [ ] **Pixel 7 (current physical device) debug demo matrix** green on 4.7 stable.
- [ ] `scripts/android_export_minified.sh` green — R8-minified Match3 release APK
      on Pixel 7 with the pinned PanamaPort fork (not upstream).

### iOS (Tier 2)

- [ ] `scripts/ios_device_gate.sh` full 9-demo matrix + fresh-project install path
      green on a recent physical iPhone (private device/signing values from
      maintainer notes, never committed).
- [ ] `./gradlew compileKotlinIosArm64` green.
- [ ] On-device self-test matrices at **0 failures** (PTRCALL / OBJECTCALLS).

### Generator + reports

- [ ] `check_full_drift_gate` green (committed == fresh regen for all three
      platform wrapper trees).
- [ ] `scripts/check_ios_no_silent_stubs.py` green (0 STUB / 0 SUGAR).
- [ ] Refreshed and committed:
      `ios_handwritten_report.py`, `api_wrapper_generator_report.py`,
      `api_wrapper_coverage.py`.

### Docs + hygiene

- [ ] `mkdocs build --strict` passes.
- [ ] `scripts/local_ci.sh <godot-4.7-stable> [<second-binary>]` green.
- [ ] **No private values** in public docs or committed scripts — device UDIDs,
      Apple team IDs, provisioning profile names, and workstation paths stay in
      maintainer notes. Verify with:
      `rg -n "KANAMA_IOS_DEVICE=[0-9A-Fa-f]|KANAMA_IOS_TEAM=[A-Z0-9]{10}" docs/ scripts/`

---

## 7. Supported-mobile promotion bar (Phase 4 · B, task 25)

Written 2026-07-10. This is the bar that moves iOS + Android from **Tier 2 —
Experimental (device-validated)** to **Supported**. Promotion is a public
support-claim change and happens **only when every criterion below is green**
(AGENTS.md rule: never claim support a gate did not pass). The task can
legitimately end with mobile still experimental — the deliverable is this
honest bar and the measured results, not a forced promotion.

The five §1 "supported" conditions still apply; this bar makes the
mobile-specific ones measurable:

| # | Criterion | Definition of green | iOS (2026-07-10) | Android (2026-07-10) |
|---|---|---|---|---|
| **B1** | Device matrix breadth | ≥ 2 physical device models per platform pass that platform's full repeatable gate on the current Godot baseline | ✅ **MET** — iPhone 12 (2026-06-25) + iPhone 15 Pro (2026-07-10) full ten-step gates (§2) | ❌ Pixel 7 only. Needs a second model through the debug demo matrix + the R8-minified release gate |
| **B2** | Renderer coverage | Android: Vulkan/Mobile renderer smoke across the demo corpus, green on a physical device (promotes DEFERRED #2). iOS: the Godot iOS renderer exercised by the full gate | ✅ by construction (the full gate runs the Godot iOS renderer) | ✅ **MET (2026-07-10)** — nine-demo Vulkan/Mobile smoke matrix green on Pixel 7 (Mali-G710, Android 16), renderer-asserted per demo (§2 row) |
| **B3** | Release-grade packaging | The platform export path meets the desktop packaging standard: user-facing docs, reproducible from a clean checkout, a **packaged install artifact** (no Kanama source checkout required), and an install-smoke validating that artifact | ❌ source-checkout only (assessment below) | ❌ source-checkout only (assessment below) |
| **B4** | Heavy-demo coverage | `tps-demo-kanama` runs on-device on both platforms | ✅ **MET** — iPhone 15 Pro (2026-07-09, task 24) | ✅ **MET** — Pixel 7 (task 19, mobile controls validated) |

Standing conditions carried from §1: drift-gate green / 0 silent stubs /
refreshed coverage reports (§1.4 — currently green) and every remaining gap
documented as a bounded limitation (§1.5).

**Bookkeeping notes.** B4 is defined as *runs on device*. Two quality
follow-ups are not gating but must be disclosed in the promotion wording if
still open when B1–B3 clear: the mobile playability polish for the heavy demo
(touch + multiplayer UI, task 26), and adding `tps-demo-kanama` as a row in the
repeatable per-platform gate matrices so the heavy-demo claim stays
re-provable. B1-iOS is a two-named-models claim, not a device-family claim.

### Packaging assessment vs the desktop standard (B3)

Measured against what "supported" already means for desktop packaging:
user-facing flow in `docs/` — ✅ both platforms have this
([exporting/ios.md](../exporting/ios.md), [exporting/android.md](../exporting/android.md));
reproducible from a clean checkout — ✅ both (`installIosAddon` /
`installAndroidPluginAar`, validated by the iOS gate's fresh-project path and
`android_smoke.sh`); a packaged artifact installable **without** a Kanama
source checkout — ❌ both; an install-smoke for that artifact — ❌ both.

What's missing, concretely:

- **No mobile packaged artifacts.** `packageDistributions` and the CI package
  workflow produce desktop kits + store add-ons only. There is no shipped iOS
  addon artifact (xcframeworks + `.gdextension` descriptor) or Android addon
  artifact (AAR + `.gdap` + descriptor); both platforms currently require a
  full source checkout and toolchain (full Xcode + Kotlin/Native for iOS;
  Android SDK/NDK for the AAR build).
- **No mobile install-smoke.** `package_install_smoke.sh` validates desktop
  kits and store add-ons only; nothing validates "install a packaged mobile
  addon into a fresh project". (The iOS device gate's fresh-project step
  validates the *source-checkout* install path, not a packaged one.)
- **iOS artifact shape/size decisions unmade.** The full-breadth iOS runtime is
  ~199.5 MB debug / ~87.6 MB release static `.a` (task 30). A packaged iOS kit
  needs a debug/release layout decision and a size disclosure.
- **Android third-party dependency exposure.** The Android path depends on the
  JitPack-hosted PanamaPort fork
  (`com.github.falcon4ever.PanamaPort:Core:0.1.3-kanama-r8.2`). A supported
  claim should either vendor that artifact into the packaged addon or
  explicitly document the JitPack availability dependency.
- **Documented workarounds still hold** for heavy-demo Android exports (the
  headless `--install-android-build-template` hang; repo injection into Godot's
  generated Gradle project — see
  [post-release-direction.md](./post-release-direction.md) §6). Packaging docs
  must carry these as long as they exist.

**Assessment:** B3 is the farthest criterion from green, and it is *design
work* (artifact shape + install-smoke), not device-lab work. B2 cleared
2026-07-10; the only remaining device-lab item is B1-Android (a second Android
model through the debug matrix + R8-minified gate).

### B3 design (written 2026-07-10; implementation pending)

The B3 gap closes with two packaged artifacts, one smoke extension, and two
recorded decisions. A future session can implement this mechanically; B3 flips
MET only after every piece below is green.

**Artifact 1 — `kanama-mobile-addon-ios-v<version>.zip`**

- Contents: `addons/kanama/bin/ios/kanama_ios.debug.xcframework` +
  `kanama_ios.release.xcframework` (device `arm64` slices only — the simulator
  stays a maintainer opt-in, never packaged), the `.gdextension` iOS entries
  (as an install fragment that merges into an existing descriptor the way
  `installIosAddon` does, not a blind overwrite), and an install README.
- Build: a new `packageMobileAddonIos` Gradle task depending on
  `assembleIosDeviceKanamaXcframework`. **Maintainer-built on macOS** — the CI
  package workflow cannot build it (no Xcode on the runner); CI wiring is a
  later, separate decision.
- Size disclosure (required in the user-facing doc): the full-breadth static
  libraries are ~199.5 MB debug / ~87.6 MB release before zip; both variants
  ship because Godot's export reads both descriptor entries.
- Open user-side gap the README must cover: the packaged addon delivers
  *prebuilt* runtime frameworks, so project **Kotlin scripts still need the
  Kanama checkout's `installIosAddon` KSP path today**. Until a script-compile
  story without a checkout exists, the iOS packaged addon honestly targets
  script-less evaluation + prebuilt-runtime updates, and says so. (This is the
  main reason B3-iOS may stay below the desktop bar even after packaging —
  document, don't overclaim.)

**Artifact 2 — `kanama-mobile-addon-android-v<version>.zip`**

- Contents: `android/plugins/KanamaAndroid.debug.aar` + `KanamaAndroid.gdap` +
  the `.gdextension` Android entries fragment + install README.
- **Decision (debug-only for now):** no Kanama release AAR exists today — the
  validated R8 release path patches the *export's* generated Gradle build
  (`android_export_minified.sh`), not the plugin AAR. Ship debug-only with
  that stated, and add a release-AAR build as its own follow-up if promotion
  demands it.
- **Decision (PanamaPort distribution):** keep the JitPack coordinate
  (`com.github.falcon4ever.PanamaPort:Core:0.1.3-kanama-r8.2`) declared via
  `.gdap` and documented as an availability dependency, with the README
  carrying the repo-injection step the smoke scripts perform today. Vendoring
  a fat AAR is the fallback if JitPack availability ever becomes a support
  problem — revisit at promotion time.
- Build: `packageMobileAddonAndroid` depending on the AAR build; CI-capable in
  principle (needs SDK/NDK on the runner) but maintainer-built first.

**Install smoke — extend `scripts/package_install_smoke.sh`:**

- `--ios-addon <zip>`: unzip into a *fresh minimal Godot project* (no Kanama
  checkout), assert descriptor entries merge correctly, assert xcframework
  structure (Info.plist + expected static-library slices), and run the
  template preflight against the pinned Godot iOS templates when installed
  (skip loudly otherwise). Device-free.
- `--android-addon <zip>`: unzip, assert `.gdap`/AAR/descriptor coherence,
  then when `ANDROID_HOME` is present run the headless build-template install
  + `--export-debug` to an APK (skip loudly otherwise). Launch/logcat stays
  `android_smoke.sh`'s job on a device.

**B3 exit criteria:** both artifacts build reproducibly from a clean checkout;
both install-smoke modes green on a machine without a sibling Kanama checkout;
`docs/exporting/{ios,android}.md` gain "Use a packaged mobile addon" sections
with the size and script-compile caveats above; only then flip B3 in the §7
table.

### Promotion procedure (when all green)

1. Re-verify the §6 Tier-2 checklists on the current Godot baseline.
2. Apply the support-wording change to `docs/index.md`,
   `docs/reference/version-support.md`, and `docs/exporting/*` with §4-style
   named-device claims — the tier label moves to Supported with the per-platform
   caveats carried, not dropped.
3. Record the promotion evidence here (dates, devices, gate outputs) and flip
   task 25 in `kanama-tasks/README.md`.

---

## Out of scope

Per the task spec, this document only **recommends**. It does not:

- Apply the §4 wording to `docs/index.md`, `docs/exporting/*`, or
  `docs/reference/version-support.md` (post-sign-off, likely task 18).
- Tag a release or decide the version number (task 18).
- Run or add platform validation gates (tasks 02, 05 own those).

## References

- [iOS Demo Port Tracker](./active/ios-demo-port-tracker.md) — iOS device gate baselines + demo matrix
- [API Coverage](../contributing/api-coverage.md) — generator/coverage state
- [Architecture Review 2026-06](./reference/architecture-review-2026-06.md) — Android R8 root-cause (F-items), F3 perf deferral
- [Version Support](../reference/version-support.md) — current public support claims
- [API Coverage](../contributing/api-coverage.md) — 99.6% class / 99.3% method promoted coverage
- [exporting/android.md](../exporting/android.md) · [exporting/ios.md](../exporting/ios.md) — user-facing export workflows
