# Wrapper Coverage Roadmap — Progress Tracker

Live execution state for [wrapper-coverage-roadmap.md](./wrapper-coverage-roadmap.md).
Update this file in the same commit as the work it records, so any fresh
session can resume from here. Decision (2026-06-12): execute Phases 1–4;
Phase 5 starts only after iOS is stabilized and on par with desktop/Android
(Phase 4 exit: 0 STUB / 0 SUGAR).

## Status legend

`todo` · `in-progress` · `done` · `blocked(<reason>)`

## Execution workflow (decided 2026-06-12)

Each task is implemented by a subagent running the model the roadmap tags
(sonnet/opus/fable). **A fable agent reviews every diff before commit.**
Commits go straight to `main`, attributed `Co-Authored-By: Claude Fable 5`.

## Phase 1 — Desktop/Android shape gaps

| Task | Model | Status | Notes |
|---|---|---|---|
| 1.1 Scalar-combo CALL_SHAPES | sonnet | done | 2026-06-12: +19 shapes, +20 methods (15,265→15,285); fable-reviewed |
| 1.2 Container returns (Array/Dictionary/Typed*/Packed*) | opus | done | 2026-06-12: +6 shapes, +14 methods (→15,299); (Dictionary)→Dictionary policy-blocked by design; fable-reviewed |
| 1.3 Variant / RID returns | opus | done | 2026-06-12: +9 shapes, +14 methods (→15,313); typed-array args blocked (no init paths); fable-reviewed |
| 1.4 Callable argument design | fable | todo | |

## Phase 2 — iOS audited type widening

| Task | Model | Status | Notes |
|---|---|---|---|
| 2.1 Vector2i / Vector3i | sonnet | todo | |
| 2.2 Color / Rect2 returns | sonnet | todo | |
| 2.3 String-return ptrcall | opus | todo | |
| 2.4 PT_STRING / PT_NODE_PATH args | opus | todo | |
| 2.5 Transform3D / Basis | opus | todo | |
| 2.6 @ScriptProperty value types | sonnet | todo | after 2.1–2.5 |
| 2.7 Variant / typed-array / vararg | opus | todo | after 1.2–1.3 |

## Phase 3 — KSP model unification

| Task | Model | Status | Notes |
|---|---|---|---|
| 3.1 KSP platform-neutral script model | fable | todo | keystone |
| 3.2 iOS consumes KSP model (delete regex parser) | opus | todo | |
| 3.3 Generated per-signature trampolines | fable | todo | |
| 3.4 Wire remaining annotations | sonnet | todo | after 3.1–3.3 |
| 3.5 Non-object signal payloads | sonnet | todo | likely subsumed by 3.3 |

## Phase 4 — Retire hand-written iOS surfaces

| Task | Model | Status | Notes |
|---|---|---|---|
| 4.1 Variant Object dispatch (call/setDeferred/disconnect) | opus | todo | |
| 4.2 Generator custom-sections (kill SUGAR) | sonnet | todo | |
| 4.3 commonMain + expect/actual ObjectCalls | fable | todo | |
| 4.4 iOS GodotReal centralization | sonnet | todo | low priority |
| 4.5 Shrink IosGodotApi.kt HANDWRITTEN | sonnet | todo | target 0 STUB / 0 SUGAR |

## Phase 5 — Virtual methods (deferred)

Gated on Phase 4 exit. Not started by decision.

## Standing follow-ups

| Task | Model | Status |
|---|---|---|
| PtrcallScratch across generated wrappers (review F3) | sonnet | todo |
| Single Godot version pin (review F4) | sonnet | todo |
| R8-minified APK smoke gate (review F2) | opus | todo |
| AVAudioSession workaround | sonnet | todo |

## Session log

- **2026-06-12** — Roadmap + tracker created. Architecture review landed
  (`56f29aa`, `4449ece`): compatibility_minimum 4.7 fix, R8 consumer-rules
  scaffold. Phase 1.1 started.
- **2026-06-12** — Phase 1.1 done (sonnet impl, fable review: COMMIT with one
  cosmetic doc fix). 19 new CALL_SHAPES, 18 new ObjectCalls helpers, +20
  methods. Remaining "unsupported helper shape" skips are all
  Variant/typedarray/Packed*-arg or container-return → Phases 1.2/1.3.
- **2026-06-12** — Phase 1.2 done (opus impl, fable review: COMMIT, info-nits
  only). 6 container-return shapes, +14 methods (→15,299). Skips now 1,523;
  remaining helper-shape skips all carry Variant/typedarray/Packed*/Signal
  args or Variant returns → Phase 1.3+. (Dictionary)→Dictionary stays
  policy-blocked (non-String-key policy in audit_generator_shape_policy.py).
- **2026-06-12** — Phase 1.3 done (opus impl, fable review: COMMIT). 9 shapes,
  +14 methods (→15,313, skips 1,509): Dictionary→Variant LSP returns,
  Variant args (incl. both RichTextLabel 12-arg image methods — cell order
  verified against extension_api.json), Packed*-array args. BLOCKED for a
  future task: TypedObjectArray/TypedRIDArray/TypedTransform3DArray ARGS
  have no BuiltinTypes init paths (affects ImporterMesh.merge_importer_meshes,
  OpenXR do_entity_update ×2, RenderingDevice tlas_build et al.,
  RenderingServer.texture_drawable_blit_rect, DrawableTexture2D.blit_rect[_multi]).
  Remaining out-of-scope skips: Callable (1.4), Signal arg (Tween.tween_await),
  (Dictionary)→Dictionary policy gate, EditorExportPlatform.export_project,
  Font.find_variation.
