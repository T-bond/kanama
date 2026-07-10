# Internal docs — index

What each file in `docs/internals/` is, and whether it's current. Private
handoff notes — device UDIDs, local-path commands, raw logs — are intentionally
kept **outside** this public repo per AGENTS.md. Tactical task specs also live
outside this repo; this directory is the public strategic log. Completed-phase
history lives in git history, not here.

## Active — current work, keep in sync with code
| File | What it is |
|---|---|
| [ios-demo-port-tracker.md](./active/ios-demo-port-tracker.md) | Public-safe status of each iOS demo port, validation pointers, generator gotchas, and demo-relevant fixed bugs. |
| [release-support-decision.md](./release-support-decision.md) | **Start here.** Support-tier decision (desktop supported; iOS+Android experimental, device-validated), the required release-gate matrix (§6), and the supported-mobile promotion bar (§7). Signed off at 0.3.0; §7 added 2026-07-10. |

## Reference — evergreen, read to understand the system
| File | What it is |
|---|---|
| [ios-backend-architecture.md](./reference/ios-backend-architecture.md) | How Kanama runs Kotlin scripts on iOS (C-shim ptrcall, the shared wrapper generator, script model). |
| [ios-backend-handwritten.md](./reference/ios-backend-handwritten.md) | **Generated report** (do not edit; run `scripts/ios_handwritten_report.py`) of hand-written/stub iOS classes. |
| [architecture-review-2026-06.md](./reference/architecture-review-2026-06.md) | Point-in-time architecture/performance review (June 2026); cited by AGENTS.md "Looks Wrong But Isn't". |
| [architecture-review-2026-07.md](./reference/architecture-review-2026-07.md) | Post-Phase-5 cohesion + bug audit (July 2026): the `refcount_decremented` immortal-RefCounted fix, per-surface verdicts, remaining audit scope. |
| [commonmain-unification-design.md](./reference/commonmain-unification-design.md) | Design record for moving generated wrappers to shared `commonMain` with `expect/actual ObjectCalls` (physical module move still pending). |
| [callable-args-design.md](./reference/callable-args-design.md) | Callable-argument ownership/lifetime design; cited by `scripts/generate_api_wrapper.py`. |
