# Internal docs — index

What each file in `docs/internals/` is, and whether it's current. (Private handoff notes — device
UDIDs, local-path commands, raw logs — are intentionally kept **outside** this public repo per
AGENTS.md.)

## Active — current work, keep in sync with code
| File | What it is |
|---|---|
| [ios-demo-port-tracker.md](./ios-demo-port-tracker.md) | **Start here for iOS demo work.** Status of each ported demo, resumable task cards (death plane, Racing steering, Bunnymark label, FPS, third-person), key iOS-backend facts + gotchas. |
| [ios-backend-roadmap.md](./ios-backend-roadmap.md) | iOS backend status + the per-demo status table. |
| [wrapper-coverage-roadmap.md](./wrapper-coverage-roadmap.md) | Master ordered plan to take the wrapper generator to full Godot 4 coverage on all targets. |
| [wrapper-coverage-tracker.md](./wrapper-coverage-tracker.md) | Live execution state for the wrapper-coverage roadmap (update in the same commit as the work). |

## Reference — evergreen, read to understand the system
| File | What it is |
|---|---|
| [ios-backend-architecture.md](./ios-backend-architecture.md) | How Kanama runs Kotlin scripts on iOS (C-shim ptrcall, the shared wrapper generator, script model). |
| [ios-backend-handwritten.md](./ios-backend-handwritten.md) | **Generated report** (do not edit; run `scripts/ios_handwritten_report.py`) of hand-written/stub iOS classes. |
| [architecture-review-2026-06.md](./architecture-review-2026-06.md) | Point-in-time architecture/performance review (June 2026). |

## Historical — design records for completed phases (kept for context)
| File | What it is |
|---|---|
| [callable-args-design.md](./callable-args-design.md) | Design record, roadmap task 1.4 (Callable args in generated wrappers). |
| [script-model-unification-design.md](./script-model-unification-design.md) | Design record, roadmap task 3.1 (unified serialized script model). |
| [virtual-method-coverage-design.md](./virtual-method-coverage-design.md) | Design record, roadmap task 5.1 (override any engine virtual). |
