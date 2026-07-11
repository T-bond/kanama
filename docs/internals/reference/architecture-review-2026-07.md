# Architecture Review — 2026-07 (Cohesion + Bug Audit)

> **Status: complete (three rounds, 2026-07-10 → 2026-07-11).** The
> 2026-07 edition of [architecture-review-2026-06.md](./architecture-review-2026-06.md),
> motivated by multi-model development across Phases 4–5: verify the repository
> is still cohesive, and hunt for bugs on the surfaces the automated gates do
> not structurally protect. Each audited surface below carries a verdict.

## Confirmed defects (fixed in this pass)

### F1 — `refcount_decremented` returned false: every scripted RefCounted was immortal

- **Where:** desktop `ScriptBridge` info3 vtable (`refcount_decremented_func` →
  `siReturnFalse1`) and the iOS shim script-instance vtable (same slot →
  `kanama_ios_script_instance_false_1`).
- **Engine contract** (`core/object/script_instance.h`): *"return true if it can
  die"* — the default implementation returns `true`. In
  `RefCounted::unreference()` the result is combined as `die = die && script_ret`,
  so an always-false slot means the last `unreference()` can **never** destroy
  an object carrying a Kanama script. C# returns false only while its managed
  GC handle owns deletion responsibility; Kanama's script instance holds no
  reference on its owner, so `true` is the correct value.
- **Blast radius:** every scripted `RefCounted` — including user-facing custom
  `Resource` scripts — became a zombie at refcount 0, surviving until process
  exit. Visible symptoms: the standing `WARNING: 20 ObjectDB instances were
  leaked at exit` in smoke logs (now 2), and the in-process hot-reload smoke's
  retired-classloader check failing deterministically once task 29's probe
  scripts attached to RefCounted hosts (`Mesh`, `TextServerExtension`,
  `XRInterfaceExtension`) — the immortal hosts pinned the retired loader.
- **Fix:** return true from the slot on both platforms (`siReturnTrue1` /
  `kanama_ios_script_instance_true_1`).
- **Collateral cleanup:** `BuiltinTypes.destroyRefCountedIfUnreferenced` and the
  shutdown resource-owner sweep in `KanamaScript.destroyConstructedScripts` were
  the zombie-sweeper built on top of this bug (manually destroying live objects
  found at `ref_count=0` — a state that is unreachable after the fix); both
  removed. `runtime_smoke`'s cleanup assertion now expects the release path's
  own `destroy=true` (the last `unreference()` destroying the owner directly).
- **Validation:** `runtime_smoke`, `tool_smoke`, `hot_reload_smoke`, and
  `hot_reload_in_process_smoke` all green after the fix; ObjectDB exit-leak
  count dropped 20 → 2 (runtime smoke) and 20 → 14 (reload smoke). The full
  **desktop demo corpus** (all nine `desktop_smoke_all.sh` targets, addons
  refreshed to the fixed runtime) passed 2026-07-11 — no demo relied on zombie
  RefCounted lifetimes. **iOS on-device revalidation (2026-07-11, iPhone 15
  Pro):** squash-the-creeps launched playable on the fixed runtime (Kotlin +
  C-shim vtable change) with `PTRCALL SELFTEST MATRIX: 70/0` and
  `OBJECTCALLS SELFTEST: 111/0`, including the `refcounted-ret-owns-plus1`
  ownership probe and its double-close guard. Nuance: that probe exercises the
  unscripted ownership path; the vtable fix specifically governs *scripted*
  RefCounteds, for which the iOS evidence is zero regressions across the full
  matrix + launch. An explicit scripted-Resource-death self-test row is a
  cheap optional hardening follow-up.
- **How it survived so long:** zombies are invisible to gameplay (leaks, not
  crashes), the exit-leak warning was easy to attribute to test scaffolding,
  and no gate asserted scripted-RefCounted destruction until the reload smoke's
  classloader check accidentally became a proxy for it.

### F2 — `local_ci` KSP guard stale: gate silently red since task 32

- `scripts/local_ci.sh` asserted `propertyCount = 13` for the example
  HelloScript registrar; task 32 (`c9357766`) added the `smoke_difficulty` enum
  export (14th property) without bumping it. Tasks 32/33 ran narrower gates
  (jar + iOS KSP + mkdocs), so full `local_ci` was red for a day without anyone
  noticing. Fixed (now 14, with a comment saying when to bump). **Lesson:** the
  literal-count guard only works if `local_ci` runs after example-project
  changes; prefer running the full gate on any task touching
  `example_project/`.

### F4 — project-scripts source sweep swallowed Android export intermediates

- `project-scripts` adds the whole consumer project directory as a Kotlin
  source root with no excludes. A Godot Android export leaves a full project
  copy (including `kotlin-src/` and previously generated registrars) inside
  `android/build/**` Gradle intermediates, and demos can carry stale KSP output
  in their own top-level `build/` — both got swept up as script sources,
  producing mass `Redeclaration` compile failures on `installAddonJar` for
  **every demo that had ever run an Android export**. Found refreshing the
  demo corpus for the F1 validation; fixed by excluding `android/**`,
  `.godot/**`, and `build/**` from the script source set. All nine demos
  refresh + smoke cleanly after the fix.

### F3 — retired-classloader GC check flaky under machine load

- `KanamaHotReload.checkRetiredLoaders` ran one `System.gc()` (a hint) per
  check; under load the loader often survived the only check that fired before
  the short-lived smoke process exited. Now retries up to 3 bounded GC+sweep
  rounds within a check (the path only runs while a retired loader exists).
  Note: the deterministic failure that led here was F1, not this — this only
  removes the residual timing sensitivity.

### F5 — DirAccess/FileAccess `*At` helpers reported a stale open error on failed opens

- **Where:** the hand-shaped `DirAccess` static facade (`changeDirAt`, `makeDirAt`,
  `makeDirRecursiveAt`, `removeAt`, `copyAt`, `renameAt`, `createLinkAt`) and
  `FileAccess` (`getErrorFor`, `resizeFile`).
- **Mechanism:** the failure fallback was written as
  `withOpenDir(directoryPath, getOpenError()) { … }`. Kotlin evaluates arguments
  left-to-right, so `getOpenError()` ran **before** the open attempt inside the
  helper — the fallback captured the error state of a *previous, unrelated* open.
- **Failure scenario:** any prior successful open leaves the thread-local open
  error at `OK`. `DirAccess.makeDirAt("/nonexistent-parent", "sub")` then fails
  to open, does nothing, and returns `0` (OK) — the caller believes the
  directory was created.
- **Fix:** dedicated `withOpenDirOrOpenError` / `withOpenFileOrOpenError`
  variants that read `getOpenError()` *after* the failed open (same thread, so
  the thread-local error is the correct one). The non-error fallbacks
  (`false`, `""`, `emptyList()`…) stay eager — they are constants.
- **How it survived:** the helpers do the right thing operationally (the op is
  skipped); only the *reported* error is wrong, and no smoke asserted the error
  code of a failed-open path.

## Observations (recorded, not defects)

- **`ScriptBridge.siFree` ignores `unreference()`'s true-return** on the script
  *resource* object (destroy responsibility). Benign while the engine holds its
  own `Ref<Script>`; a shutdown-ordering path where Kanama held the last ref
  would leak one script object. Low severity; revisit if script-resource leak
  warnings ever appear.
- **`bootstrap.c` `is_editor_process()` is macOS-only** (`_NSGetArgv`). On
  Linux/Windows the JDWP editor/game split is inert: with `debug/jdwp_enabled`
  on, the editor process also binds the runtime port, and a second process can
  fail its JDWP bind. Matters only when Linux/Windows revalidation resumes.
- **`bootstrap.c` uses ANSI Win32 APIs** (`GetModuleFileNameA`, `LoadLibraryA`)
  — non-ASCII install paths on Windows would fail. Same revalidation bucket.
- **`siCall` writes only the `error` field** of `GDExtensionCallError` —
  matches engine behavior (Godot pre-initializes the struct; INVALID_METHOD
  messages don't read `argument`/`expected`).
- **Aliasing wrappers share one +1** (round 3): `fromHandle`/`fromResource`/
  `fromObject`/`asObject` downcast helpers create a second wrapper over the
  same handle without adding a reference. Calling `close()` on more than one
  alias releases more references than were taken. `close()` is opt-in
  (`@ManualGodotLifetimeApi`), so this is an API sharpness, not an active
  defect: only close the owning wrapper.
- **`SceneTree.delaySeconds` accepts `processInPhysics` but ignores it**
  (round 3) — the coroutine awaits process frames only. Misleading parameter;
  harmless for current callers.
- **Android `Real.kt` is pinned single-precision** (round 3): the remap pass
  hardcodes the Float variant, so `-PkanamaPrecision=double` does not propagate
  to the AAR. Irrelevant while Android templates are single-precision; becomes
  a divergence only if a double-precision mobile path ever appears.
- **String-default escaping is unhandled in the generator** (round 3):
  a Godot string default containing `$` or `\` would land verbatim in a Kotlin
  string literal (interpolation/escape hazard). No 4.7 API default contains
  either character (verified); a future re-pin that introduces one fails the
  jar compile loudly or, for `$identifier`, could silently interpolate — check
  on re-pins.

## Surfaces audited to conclusion (this pass)

| Surface | Verdict |
|---|---|
| `src/main/kotlin/binding/ScriptBridge.kt` (whole file) | **F1 found + fixed**; otherwise sound — placeholder Variant put-then-close-old is correct, `siGetPropertyState` destroys temporaries, `siCall` contains exceptions at the upcall boundary, `siFree` unwind order is safe |
| `bootstrap/bootstrap.c` (whole file) | OK — bounded buffers, idempotent re-entry, contained JNI failure paths; three observations above |
| iOS C shim marshalling (`build_*_from_blob`, `pt_blob_value_to_variant`, `pt_return_to_variant`, packed-arg build/destroy, `object_destroy`) | OK — consistent build→box→destroy ownership, unaligned-safe `memcpy` reads, clamped lengths, malloc fallbacks with correct cursor advancement, missing converters degrade to nil (fail-visible in self-tests) |
| iOS shim script-instance vtable | **F1 (iOS mirror) found + fixed** |
| `BuiltinTypes` RefCounted ownership helpers (`releaseRefCounted`, retained-array reads) | OK — destroy-on-true handled correctly (the pattern `siFree` should also adopt, see observation) |
| Structure/cohesion pass | Clean — all non-mapped root dirs (`Library/`, `.kotlin/`, `site/`, …) are gitignored with zero tracked files; 2357 tracked files, no junk hits; docs↔nav bijective; `phase6_smoke.sh` (dead alias) removed; `audit_embedded_processes.sh` justified in place as an interactive maintainer aid |

## Audited in round two (2026-07-11)

| Surface | Verdict |
|---|---|
| KSP cleanup/release emission (`emitCleanupHelpers`, `cleanupPropertyExpr`, dispatchSet release-then-reassign) | OK — ordering safe under F1's destroy-at-zero semantics, recursion guard sound, no touch-after-release |
| KSP enum-export model (task 32 path) | OK — fail-loud on empty enums; ordinal INT slot + hint emission as designed |
| Desktop `ObjectCalls` ownership-sensitive helpers (sampled: raw object return, Variant-path object return, StringName return, `destroyObject`) | OK — matches the documented conventions exactly (raw returns untouched, Variant-path borrows with the Variant destroyed, destroy-after-read for owned strings). Sampled, not line-by-line; the mechanical mass stays covered by the layout/ABI audit scripts |

## Audited in round three (2026-07-11)

| Surface | Verdict |
|---|---|
| The 47 `DESKTOP_HANDSHAPED` policy classes | **F5 found + fixed** (DirAccess/FileAccess facades); otherwise sound. Read to conclusion: RefCounted/Resource close() (double-release guarded, unreference→destroy-on-true matches post-F1 semantics), DirAccess/FileAccess handle policy (fresh sole-ref opens destroyed directly — equivalent to release for a ref of 1), Engine.registerSingleton RefCounted-rejection guard intact, Tween/Tweener fluent self-return collapse matches the task-31 measured +1 ABI, SceneTree glue (Engine.get_main_loop borrow is fine — MainLoop is not RefCounted), FileAccessHandle.close() double-guarded (file close + wrapper release). The remaining 38 classes carry only mechanical `create`/`from*` factories and generated-shaped bodies: swept for ownership-sensitive calls (`destroyObject`/`releaseHandle`/eager fallbacks) — zero hits |
| Android PanamaPort remap pass + audits | OK — remap rules fold in the correct order (blanket `.invoke(`→`.invokeWithArguments(` before the targeted Kotlin-callback undos); all nine undo needles verified live against current sources; zero nullable-invoke sites outside the covered set; every silent-failure class is either forbidden by the post-audit (`?.invokeWithArguments(`) or fails the Android compile loudly (non-nullable Kotlin invokes, `Files.readString`…) |
| `generate_api_wrapper.py` policy internals | OK — self-return-collapse conditions match the hand-shaped Tween policy exactly; `close`/`wait` method renames are structurally backed (an uncovered future `close()` fails jar compile as an accidental override); custom member sections carry only benign alias/cast helpers; by-design skips documented. One latent hazard hardened: `kotlin_default_expression` would have rendered a scientific-notation float default (`1e-05`) as invalid Kotlin `1e-05.0` — no current API default triggers it (verified against `extension_api.json`), fixed in the generator with no output change |
| Desktop `ObjectCalls.kt` (family-complete, beyond round-2 samples) | OK — the 1585 helpers are mechanical compositions of shared primitives, each audited to conclusion: String args/returns destroy-after-read on both slots; packed-array and Array returns allocate→read→`destroyTyped`; Variant returns via `readVariantReturn` destroy after decode; Variant *argument* cells destroyed in `finally` (arena zero-init makes the not-yet-initialized destroy path a safe no-op); Callable/Signal args build→call→destroy with the engine keeping its own copy. Slot widths remain covered by `audit_ptrcall_helper_layouts` |

### Optional hardening still open

- An explicit iOS self-test row for scripted-`Resource` death (F1's scripted
  path has only indirect iOS evidence: zero regressions across the 70/0 +
  111/0 matrices and launch). Cheap, needs a device session.

## Looks wrong but isn't (new entries)

| Item | Why it's correct |
|---|---|
| clang/IDE diagnostics on `kanama_ios_shim.c` ("gdextension_interface.h not found") | Editor include-path config noise; the real builds compile with `-I gdextension` (verified via `clang -fsyntax-only -I gdextension -I ios/include`). |
| "Methods generated 91.1%" in the Generator Summary | The denominator includes the 1437 engine virtuals (deliberately not callable wrappers — `@OverrideVirtual` is the correct usage) and the documented by-design skips. Callable coverage is the Promoted Source Summary (99.9%); the coverage page now says this inline. |
| `ObjectCalls`' thread-local `ptrcallScratch` reused across calls that can re-enter script upcalls | Safe by construction: ptrcall decodes all argument slots before executing the method body (so nested calls clobbering the arg cells can't be observed), and return slots are written after the body — including any nested upcalls — completes, so reads/writes nest like a stack. |
| `withOpenDir`/`withOpenFileRead` destroy the fresh `DirAccess`/`FileAccess` with `destroyObject` instead of unreference-then-destroy | The object was just created by a static `open()` and the +1 the return slot transferred is its only reference; direct destroy is equivalent to release-at-1 and cannot race anything. |
