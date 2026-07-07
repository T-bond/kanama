# Post-Release Direction (0.3.0)

> **Status: current.** Written at the 0.3.0 release (2026-07-06) as the
> capstone re-evaluation for tasks 01–23. It records what landed, the versioning
> decision, the next strategic phase, the `DEFERRED.md` triage, and the released
> support matrix. When this diverges from later work, update it or supersede it
> with the next release's direction doc.

This is the companion to
[release-support-decision.md](./release-support-decision.md): that doc decided
*what to claim*; this doc records *what shipped and where the project goes next*.

---

## 1. What landed (tasks 01–23)

The 0.3.0 line closes Kanama's **mobile + convergence** phase. Highlights,
grouped by theme:

### Mobile demo parity

- **iOS Kotlin/Native backend** to demo parity (tasks 01, 02, 04, 08–11, 13). A
  C GDExtension shim + a Kotlin/Native static `.xcframework` run full Kanama
  scripts through the same generated wrappers as desktop/Android, no JVM on
  device. Device-validated: full 9-demo gate on iPhone 12, playable corpus +
  self-tests on iPhone 15 Pro (both iOS 26.5, Godot 4.7 stable).
- **Android hardening** (tasks 05, 20). Pixel 7 debug demo matrix + an
  R8-minified Match3 release APK, the latter enabled by Kanama's PanamaPort fork
  which fixes an upstream sealed-switch miscompile that crashed the FFI bootstrap
  under R8.
- **`@Rpc` config delivery** (task 03) across desktop, Android, and iOS.
- **TPS mobile controls** (task 19): virtual joysticks + on-screen buttons in
  `tps-demo-kanama`, device-validated on Pixel 7.

### Generator convergence + coverage

- **commonMain wrapper unification + `GodotReal` centralization** (tasks 06, 07).
- **Full cross-platform drift gate** (task 21): `check_full_drift_gate` proves
  committed wrappers are byte-identical to a fresh regeneration per platform
  (desktop 985 / iOS 242). Cross-platform wrapper drift is now structurally
  impossible — one generator fix lands identically everywhere.
- **Coverage to ~99%** (tasks 08, 09, 13, 22): classes 1032/1036 = 99.6%,
  callable methods 15274/15385 = 99.3%. Engine virtuals are overridable across
  POD plus `String`/`PackedStringArray`/`Variant` (`Any?`) returns. Residual
  exotic shapes are documented as promote-on-demand.
- **Generator policy cleanup + handwritten-surface reduction** (tasks 10, 11):
  the handwritten surface is down to platform/runtime glue and documented
  permanent exceptions.
- **`isEqualApprox` composites** (task 14): Transform3D, Basis, AABB, Rect2,
  Transform2D, Projection.

### Baseline, docs, and tooling

- **Godot 4.7 stable baseline** with a single-source version pin
  (`kanamaGodotVersion`), a KDoc sync tool, and a drift check wired into local CI
  (task 23) — the groundwork for repeatable Godot upgrades.
- **Docs reorganized** into consumer / maintainer / internal tracks (task 16).
- **Agent guides refreshed** so a fresh session orients quickly (task 17).
- **Release support decision** (task 15): the grounded support-tier matrix this
  release implements.

---

## 2. Versioning decision — `0.2.2` → `0.3.0` (preview)

**Decision: `0.3.0`, staying on the preview line.**

Rationale:

- **Not a patch (`0.2.3`).** 01–23 delivered a phase, not a fix: a new iOS
  backend, a device-validated Android path, ~99% wrapper coverage, a structural
  drift gate, and a docs reorganization. A minor bump is the honest signal.
- **Not stable (`1.0`).** 1.0 would over-claim. Mobile is still **experimental**
  (device-validated, but below the release-grade packaging + broad-device-matrix
  bar). Linux/Windows are **pending 4.7-stable revalidation**. Packaged
  exported-game support remains a separate, unproven track. Semantic versioning
  reserves 1.0 for a stability commitment the project has deliberately not made
  yet.
- **`0.3.0` preview** communicates real forward motion while keeping the "preview
  line, still hardening" contract that the support tiers depend on.

1.0 becomes the right conversation once mobile reaches a supported tier and the
desktop matrix is fully revalidated on stable — i.e. after the Phase 4 work in §3.

---

## 3. Next phase — new strategic cycle (Phase 4)

**Decision: a new strategic cycle, not maintenance mode.**

The maintainer's direction: **drive mobile up to desktop-level coverage, then
resume broad Godot API coverage across all platforms.** Concretely — now that
Android runs the heavy `tps-demo-kanama`, iOS should too; get desktop and mobile
onto similar levels, then the mission (broad coverage) continues with every fix
landing once across all three platforms via the drift gate.

### Phase 4 — Mobile-to-Parity + Sustaining

Two pillars, promoted into task specs in `kanama-tasks/`:

- **B · Mobile promotion (Experimental → Supported).** The strategic headline.
  Sub-tracks:
  - **iOS heavy-3D enablement** — close the `tps-demo-kanama` iOS gap: the
    un-audited wrapper classes, the handful of method gaps, and the demo-side
    JVM-only stdlib usage that isn't Kotlin/Native-portable. This is the concrete
    "iOS runs TPS like Android" goal. *(New task spec.)*
  - **`tps-demo-kanama` mobile UI port** — touch controls + mobile multiplayer UI
    (connect/lobby, safe-area layout) across Android + iOS. Task 19 landed the
    joysticks; this completes the playable mobile port. *(Promotes DEFERRED #9.)*
  - **Android Vulkan/Mobile renderer validation** — a dedicated renderer smoke
    pass across the demo corpus, so the Android claim isn't OpenGL-Compat-only.
    *(Promotes DEFERRED #2.)*
  - **Broader device matrix** — move iOS past a single full-gate device and widen
    the Android device set, so "recent phones" becomes a proven claim rather than
    a per-model one. A prerequisite for a *Supported* mobile tier.
- **C · Godot-version upgrade cadence.** Make a Godot bump a repeatable checklist,
  not a scramble: re-pin `extension_api.json` + `gdextension_interface.h`,
  regen/re-adopt wrappers under the drift gate, refresh KDoc against the new
  `doc/classes`. Task 23 already built the tooling and the version pin; this task
  writes the runbook and hardens the automation. *(Sustaining.)*

### The through-line

Broad Godot API coverage is not shelved — it is **gated on parity**. Once mobile
sits alongside desktop and the drift gate keeps them identical, resuming broad
coverage is cheap: each promoted shape lands once and is enforced everywhere.
Phase 4 buys that leverage; the coverage mission resumes on top of it.

### Not in this cycle

- **Desktop Linux/Windows 4.7-stable revalidation** stays an open release-gate
  item (not a Phase 4 pillar). The maintainer has deprioritized it for now; it is
  low-risk (the 4.7 rc2→stable bump is metadata-only for API/wrapper shape) and
  will be picked up when those OS binaries are available. Until then the docs say
  *Supported pending 4.7-stable revalidation*.

---

## 4. `DEFERRED.md` review

Each item in `kanama-tasks/DEFERRED.md` reviewed at 0.3.0:

| # | Item | Decision | Note |
|---|---|---|---|
| 1 | Hot reload on iOS/Android | **keep deferred** | Large-initiative; K/N AOT (iOS) and ART class-reload (Android) still need a design pass. No demand forcing it. |
| 2 | Vulkan/Mobile renderer on Android | **promote** | Folds into Phase 4 · B (mobile promotion) as the Android renderer-breadth sub-track. |
| 3 | iOS simulator as a real validation target | **keep deferred** | Physical-device gate remains the signal; simulator stays a compile/link check. Revisit only if a device-farm-less CI need emerges. |
| 4 | Web target | **not-planned** | Permanent. No JVM/FFM path on web; no credible backend design. |
| 5 | IDE tooling beyond the Build Scripts button | **keep deferred** | Current IntelliJ workflow suffices; a plugin needs a long-term owner. |
| 6 | KMP sharing beyond commonMain wrappers | **keep deferred** | Sharing user game-script code is a separate design (serialization + platform APIs). Not blocking. |
| 7 | Demo corpus expansion | **keep deferred** | Not selected for Phase 4. Promote-on-demand when a demo adds concrete coverage value. |
| 8 | New annotations / KSP features beyond `@Rpc` | **keep deferred** | The unified KSP model is ready; the demand isn't. Cheap to pick up per-annotation later. |
| 9 | `tps-demo-kanama` mobile UI port | **promote** | Folds into Phase 4 · B as the mobile-UI-port sub-track (touch controls + multiplayer UI). |

Net: **2 promoted** (#2, #9) into Phase 4, **1 permanent not-planned** (#4),
**6 kept deferred** with their preconditions intact.

---

## 5. Released support matrix (confirmation)

Restated from [release-support-decision.md](./release-support-decision.md) as
**released in 0.3.0**, with the wording now live in the public docs
([index](../index.md), [version-support](../reference/version-support.md),
[android](../exporting/android.md), [ios](../exporting/ios.md)):

| Tier | Platforms | Released status |
|---|---|---|
| **Tier 1 — Supported** | macOS arm64 | `Supported (4.7 stable)` — primary supported runtime + package target. |
| **Tier 1 — pending revalidation** | Linux (arm64/x86_64), Windows x86_64 | `Supported pending 4.7-stable revalidation` — last full validation on 4.7 beta 2; metadata-only bump carries API/wrapper shape. Open release-gate item (see §3 "Not in this cycle"). |
| **Tier 2 — Experimental (device-validated)** | iOS **and** Android (co-tiered) | Documented export + passing physical-device gate + demo set on device. Below desktop; per-platform caveats below. |
| **Not planned** | Web | Needs a JVM/FFM runtime path. |

**Adjustments from the release gate:** none to the tiers. The one change from the
task-15 recommendation is the maintainer's adoption of the **"Supported"** label
for macOS (task-15 §4 left "Validated" vs "Supported" as the human's call); the
rest of the §4 wording landed as recommended, including the Android under-claim
fix ("Pixel 7 pending" → "device-validated on Pixel 7").

**Carried caveats** (unchanged, documented as limitations not blockers):

- No hot reload on mobile.
- iOS does not run heavy-3D / mobile-multiplayer (`tps-demo-kanama`) yet — the
  headline Phase 4 target.
- Android's validated renderer is OpenGL Compatibility only; R8-minified releases
  depend on Kanama's PanamaPort fork, not upstream.
- iOS full-gate device breadth is iPhone 12; iPhone 15 Pro is corpus + self-tests.

---

## 6. Rough edges & follow-ups discovered during the release

Recorded here so a Phase 4 session can pick them up; none blocks 0.3.0 (the
first was fixed in the release).

- **int32 return widening vs. exact-ABI audit (fixed in 0.3.0).** The generator
  had a deliberate `get_collision_count` int32→`Long` widening
  (`wrapper_model._INT32_RETURN_WIDEN_TO_LONG`) on the theory that "int32 meta is
  only a storage hint." That is false for the ptrcall **return** ABI (an int32
  return writes 4 bytes; an 8-byte read pulls scratch), and it tripped
  `audit_wrapper_signatures` + `audit_wrapper_abi_policy` and the fresh-clone
  pre-release gate. Reverted to exact `Int`/`ptrcall…RetInt` for the 5 affected
  methods (`ShapeCast2D/3D`, `KinematicCollision3D`, `PhysicsTestMotionResult3D`,
  `SpringBoneSimulator3D`). **Follow-up:** if int-return ergonomics are ever
  revisited, "widen all int32 returns to Long" needs zero-extending ptrcall
  helpers, audited per platform — it is not ABI-safe as a bare cast.
- **`GridMap.INVALID_CELL_ITEM` typed `Long` while `get/setCellItem` are `Int`.**
  The generator emits integer class constants as `Long` by default, so this
  sentinel doesn't match the int32 methods it pairs with (surfaced as a demo
  compile error migrating City-Builder to 0.3.0; worked around demo-side with
  `.toInt()`). A general "int constants that pair with int32 methods → `Int`"
  generator policy would remove the friction, but it is a cascading,
  source-breaking change — a Phase 4 hygiene item, not a release fix.
- **`installAddonJar` (desktop) does not preserve existing iOS gdextension
  entries.** It writes the desktop+Android template and re-adds Android metadata,
  but drops any `ios.*` xcframework entries — the mirror of the
  `installIosAddon`→Android/desktop preservation that already exists. Harmless in
  practice (the iOS adopt flow, `installIosAddon` via `ios_device_run.sh`, re-adds
  iOS entries and preserves desktop/Android), so the committed desktop demo
  baseline is desktop+Android. **Follow-up:** make `installAddonJar` preserve
  `ios.*` entries symmetrically so the two adopt paths are order-independent.
- **Heavy demos hang the headless Android build-template install.** For
  `tps-demo-kanama`, `godot --install-android-build-template` hangs headless;
  workaround is to install the template via the editor GUI once, then run the raw
  `--export-debug`. (Discovered in task 19.)
- **Android export of demos needs the JitPack repo + PanamaPort R8 fork injected**
  into the generated Gradle build. The `android_smoke.sh` /
  `android_export_minified.sh` scripts do this; a raw `--export-debug` does not.
  (Discovered in task 19.)

---

## References

- [Release Support Decision](./release-support-decision.md) — the support-tier matrix this release implements
- [iOS Backend Roadmap](./active/ios-backend-roadmap.md) — iOS sub-track (largely complete)
- [Version Support](../reference/version-support.md) — public support claims (0.3.0)
- `kanama-tasks/README.md` — Phase 4 task table
- `kanama-tasks/DEFERRED.md` — parking lot (post-triage)
