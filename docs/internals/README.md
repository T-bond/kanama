# Internal docs — index

What each file in `docs/internals/` is. Private handoff notes — device UDIDs,
local-path commands, raw logs — are intentionally kept **outside** this public
repo per AGENTS.md. Tactical task specs, strategic decision records, and
done-phase design/audit docs also live outside this repo (the internal task
repo). This directory keeps only the evergreen reference needed to understand
the system today; completed-phase history lives in git history and the task
repo, not here.

## Reference — evergreen, read to understand the system

| File | What it is |
|---|---|
| [ios-backend-architecture.md](./reference/ios-backend-architecture.md) | How Kanama runs Kotlin scripts on iOS (C-shim ptrcall, the shared wrapper generator, script model). |
| [ios-backend-handwritten.md](./reference/ios-backend-handwritten.md) | **Generated report** (do not edit; run `scripts/ios_handwritten_report.py`) of hand-written/stub iOS classes. |

## Moved out (2026-07-14)

The support-tier decision record (release-support-decision, incl. the §7 mobile
promotion bar — now fully applied), the dated architecture/bug-audit reviews,
the iOS demo-port tracker (ports complete), and the callable-args / commonMain
design records were moved to the internal task repo. They are done-phase
records, not getting-started material; the decisions they describe are now live
in `reference/version-support.md`, `index.md`, the root `README.md`, and
`exporting/{android,ios}.md`.
