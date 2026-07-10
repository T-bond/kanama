# Architecture Review — 2026-07 (Cohesion + Bug Audit)

> **Status: first pass complete (2026-07-10), scope partially audited.** The
> 2026-07 edition of [architecture-review-2026-06.md](./architecture-review-2026-06.md),
> motivated by multi-model development across Phases 4–5: verify the repository
> is still cohesive, and hunt for bugs on the surfaces the automated gates do
> not structurally protect. Each audited surface below carries a verdict;
> surfaces not yet audited are listed honestly at the end (kanama-tasks task 35
> tracks the remainder).

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
  count dropped 20 → 2 (runtime smoke) and 20 → 14 (reload smoke). **Pending:**
  the iOS side needs an on-device self-test run (PTRCALL/OBJECTCALLS matrices,
  including the `refcounted-ret-owns-plus1` probe) next device session.
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

### F3 — retired-classloader GC check flaky under machine load

- `KanamaHotReload.checkRetiredLoaders` ran one `System.gc()` (a hint) per
  check; under load the loader often survived the only check that fired before
  the short-lived smoke process exited. Now retries up to 3 bounded GC+sweep
  rounds within a check (the path only runs while a retired loader exists).
  Note: the deterministic failure that led here was F1, not this — this only
  removes the residual timing sensitivity.

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

## Surfaces audited to conclusion (this pass)

| Surface | Verdict |
|---|---|
| `src/main/kotlin/binding/ScriptBridge.kt` (whole file) | **F1 found + fixed**; otherwise sound — placeholder Variant put-then-close-old is correct, `siGetPropertyState` destroys temporaries, `siCall` contains exceptions at the upcall boundary, `siFree` unwind order is safe |
| `bootstrap/bootstrap.c` (whole file) | OK — bounded buffers, idempotent re-entry, contained JNI failure paths; three observations above |
| iOS C shim marshalling (`build_*_from_blob`, `pt_blob_value_to_variant`, `pt_return_to_variant`, packed-arg build/destroy, `object_destroy`) | OK — consistent build→box→destroy ownership, unaligned-safe `memcpy` reads, clamped lengths, malloc fallbacks with correct cursor advancement, missing converters degrade to nil (fail-visible in self-tests) |
| iOS shim script-instance vtable | **F1 (iOS mirror) found + fixed** |
| `BuiltinTypes` RefCounted ownership helpers (`releaseRefCounted`, retained-array reads) | OK — destroy-on-true handled correctly (the pattern `siFree` should also adopt, see observation) |
| Structure/cohesion pass | Clean — all non-mapped root dirs (`Library/`, `.kotlin/`, `site/`, …) are gitignored with zero tracked files; 2357 tracked files, no junk hits; docs↔nav bijective; `phase6_smoke.sh` (dead alias) removed; `audit_embedded_processes.sh` justified in place as an interactive maintainer aid |

## Not yet audited (remaining task-35 scope)

- Desktop `ObjectCalls.kt` hand-written helpers (40.8k lines; indirectly
  covered by `audit_ptrcall_helper_layouts` / ABI audits, but no fresh manual
  pass).
- KSP processor emitters (desktop + iOS registrars) beyond what `local_ci`'s
  literal assertions pin.
- The 47 `DESKTOP_HANDSHAPED` policy classes.
- The Android PanamaPort remap pass and its pre/post audits.
- `scripts/generate_api_wrapper.py` policy internals.

## Looks wrong but isn't (new entries)

| Item | Why it's correct |
|---|---|
| clang/IDE diagnostics on `kanama_ios_shim.c` ("gdextension_interface.h not found") | Editor include-path config noise; the real builds compile with `-I gdextension` (verified via `clang -fsyntax-only -I gdextension -I ios/include`). |
| "Methods generated 91.1%" in the Generator Summary | The denominator includes the 1437 engine virtuals (deliberately not callable wrappers — `@OverrideVirtual` is the correct usage) and the documented by-design skips. Callable coverage is the Promoted Source Summary (99.9%); the coverage page now says this inline. |
