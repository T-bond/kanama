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
| 1.4 Callable argument design | fable | done | 2026-06-12: design doc + 3 helpers, +6 methods (→15,319); lambda→Callable deferred by design (callable-args-design.md) |

## Phase 2 — iOS audited type widening

| Task | Model | Status | Notes |
|---|---|---|---|
| 2.1 Vector2i / Vector3i | sonnet | done | 2026-06-12: kinds+matrix+probe rows; Sprite2D +3 methods; device self-test PENDING |
| 2.2 Color / Rect2 returns | sonnet | done | 2026-06-12: kinds+tags+matrix+probe rows; CanvasItem +16 methods (incl. real get_modulate + 12 draw*), Control +4, GPUParticles2D +3, Sprite2D +3, Label/Viewport/CollisionShape3D/CollisionObject2D minor; STUB 12→11, SUGAR 5→3; fable-reviewed; device self-test PENDING |
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

## RESUME HERE (handoff 2026-06-12, session switch — resume in Opus)

State at handoff: working tree CLEAN, Phases 1.1–1.4 + 2.1 + 2.2 all
committed to main (2.2 landed after the original handoff note; both
fable-reviewed).

1. **DONE: device validation (iPhone 12, iOS 26.5, 2026-06-12).** All 2.1/2.2
   rows **PASS** on device — `PTRCALL SELFTEST MATRIX: 14 passed, 0 failed`
   (C) + `OBJECTCALLS SELFTEST: 13 passed, 0 failed` (Kotlin), no construct-0
   notes. Per-row PASS (C + Kotlin each): Vector2i (Sprite2D.frame_coords 3,7
   after hframes/vframes widening), Vector3i (PlaceholderTexture3D.size
   5,11,17), Color (CanvasItem.modulate 0.125,0.25,0.5,0.75), Rect2
   (GPUParticles2D visibility_rect 1.5,2.5,3.5,4.5). Captured via
   `devicectl process launch --console` (script's devicectl launch does not
   stream app console; idevicesyslog is a noisy secondary). **2.6 unblocked.**
2. **DONE: 2.3a String-return ptrcall (device-validated 2026-06-12).** No-arg
   String getter wired: dedicated C helper `kanama_ios_godot_ptrcall_no_args_ret_string`
   (ptrcall→`string_to_utf8_chars`→destruct, two-call length protocol) +
   hand-written `ObjectCalls.ptrcallNoArgsRetString`. Generator: `"String"` in
   `IOS_RET_KOTLIN`, gated to the no-arg helper (`shape.function ==
   "ptrcallNoArgsRetString"`) so StringName + arg+String shapes stay out;
   `IOS_PROPERTY_SUPPRESS{("Label","text")}` lets the bespoke writable `var text`
   own the property (set_text String-arg still unbuilt). Label.text getter now
   real (`getText()`); 6 wrappers regenerated (Control/Resource/Node/Viewport/
   AnimationPlayer/Label) — additive String getters (getText/getTooltipText/
   getName/getPath/getSceneFilePath/getTreeString/…), SUGAR re-applied. Self-test
   `get_class==Node2D` PASS on device (C 14→15, Kotlin 13→14, 0 failed, no notes).
   STUB count 11→ (Label.text get cleared). Gates: check_wrapper_generator,
   check_ios_no_silent_stubs, compileKotlinIosArm64, clang -fsyntax-only — all pass.
3. **DONE: 2.3b StringName-return ptrcall (device-validated 2026-06-13).**
   Dedicated C helper `kanama_ios_godot_ptrcall_no_args_ret_string_name`: ptrcall →
   `String(from: StringName)` ctor (`variant_get_ptr_constructor(STRING, 2)`, since
   GDExtension has no StringName→utf8) → `string_to_utf8_chars` → destruct both;
   hand-written `ObjectCalls.ptrcallNoArgsRetStringName`. Generator gate relaxed to
   the two no-arg getters (`shape.function in {ptrcallNoArgsRetString,
   ptrcallNoArgsRetStringName}`). Real `AnimationPlayer.getCurrentAnimation()` now
   generated (SUGAR cache + `currentAnimationName` dropped); 6 wrappers regenerated
   (AnimationPlayer/Area2D/Area3D/Control/Label/Node) — additive StringName getters
   (getName/getCurrentAnimation/getAudioBusName/getThemeTypeVariation/… + `var`
   props). Self-test `Node.get_name==KanamaSN` PASS on device (C 15→16, Kotlin
   14→15, 0 failed, no notes). Gates: check_wrapper_generator,
   check_ios_no_silent_stubs (1 annotated site left), compileKotlinIosArm64,
   clang -fsyntax-only — all pass. Build/deploy gotcha: a clean
   ios_visual_smoke.sh rerun was needed — an earlier run left the prior xcframework
   installed on device (self-test showed stale counts); the new symbol presence in
   the built `.a` is the build-correctness check, device count is the deploy check.
4. **DONE: 2.4 PT_STRING/PT_NODE_PATH args (device-validated 2026-06-13).**
   Generic dispatch now constructs String + NodePath args from the C string (reusing
   the existing `init_string`/`init_node_path`); the arg cell array was generalized
   (`builtin_cells`, `constructed[i]` holds the tag → matching destructor). Generator:
   `String`/`NodePath` in `IOS_ARG_KINDS`, tags `PT_STRING=16`/`PT_NODE_PATH=17`, arg
   layouts (`{a}.cstr.ptr` / `{a}.path.cstr.ptr`), NodePath import. `IOS_PROPERTY_SUPPRESS`
   emptied — `Label.text` now fully generated (`var text`/`setText`/`getText`), SUGAR
   retired. 11 wrappers regenerated (new String/NodePath setters incl. AnimationMixer
   .setRootNode, Area3D.setWindSourcePath, GPUParticles2D/3D.setSubEmitter, Node3D
   .setVisibilityParent, Node.getNode/hasNode/findChild; many read-only `val`→`var`
   upgrades now setters work); Node SUGAR re-applied (`getNodeOrNull(String)` coexists
   with generated `getNodeOrNull(NodePath)`); Node3D fixture refreshed. Self-test rows
   Node.set/get_scene_file_path (String) + Node.get_node_or_null NodePath round-trip:
   device C 16→18, Kotlin 15→17, 0 failed, no notes. **Triage lesson:** first attempt
   crashed SIGSEGV in `construct_object("Label")` — a treeless Control segfaults in its
   post-init Theme lookup (`ThemeContext::get_themes()`), NOT a marshalling bug; fixed
   by exercising String args on `Node` instead. Don't construct bare Controls in the
   self-test. Gates: check_wrapper_generator (Node3D fixture updated),
   check_ios_no_silent_stubs, compileKotlinIosArm64, clang -fsyntax-only — all pass.
5. **DONE: 2.5 Transform3D/Basis kinds (device-validated 2026-06-13).** Both are
   POD passthrough (float32 components, no new C dispatch case, like Color/Rect2);
   enum tags `PT_BASIS=18`/`PT_TRANSFORM3D=19`. New minimal iOS `types/Basis.kt`
   (3 column axes) + `types/Transform3D.kt` (basis + origin), IDENTITY only — no
   BuiltinTypes value methods (variant calls still unwired on iOS). Generator: both
   in `IOS_ARG_KINDS`+`IOS_RET_KOTLIN`, `ios_arg_layout`/`ios_ret_layout` lay out
   Basis as 9 float32 column-major (`[x.x,y.x,z.x,x.y,…,z.z]`) and Transform3D as
   those 9 + 3 origin — matching the desktop Basis/Transform3D writeTo/readFrom
   exactly; Basis/Transform3D imports in the generated header. 5 wrappers regenerated
   (Node3D get/setTransform/Basis/global* + `var transform/basis/global*`, Camera3D
   .getCameraTransform, CollisionObject3D.shapeOwnerGet/SetTransform,
   GPUParticles3D.emitParticle; Node net-unchanged). Self-test: Node3D
   set_transform→get_transform (12 floats) + set_basis→get_basis (9 floats), exact
   float32 diagonal values. Device C 18→20, Kotlin 17→19, 0 failed, no notes. Node3D
   fixture refreshed. Gates: check_wrapper_generator, check_ios_no_silent_stubs,
   compileKotlinIosArm64, clang -fsyntax-only — all pass.
6. **DONE: RID/Quaternion/AABB kinds (device-validated 2026-06-13).** POD
   passthrough additions (no new C dispatch case): RID = uint64 (`PT_RID=14`,
   pre-existing tag), Quaternion = 4 float32 `[x,y,z,w]` (`PT_QUATERNION=20`),
   AABB = 6 float32 (position+size) (`PT_AABB=21`). New iOS `types/RID.kt`
   (`@JvmInline value class`), `types/Quaternion.kt`, `types/AABB.kt`. Generator: all
   three in `IOS_ARG_KINDS`+`IOS_RET_KOTLIN`, tag values, arg/ret layouts, generated-
   header imports. 13 wrappers regenerated (Node3D quaternion, GeometryInstance3D
   customAabb, VisualInstance3D base/instance RID getters/setters, Camera3D rids,
   etc.; Node SUGAR re-applied). Self-test (Node3D set/get_quaternion ε=1e-4 since
   Godot re-derives via basis; GPUParticles3D get/set_base RID round-trip;
   GPUParticles3D set/get_custom_aabb exact): device C 20→23, Kotlin 19→22, 0 failed,
   no notes. Node3D fixture refreshed. Gates all pass. **Plane deferred** — no clean
   arg+return method on an emitted class to anchor a matrix row (the rule: never a
   kind without a self-test row); revisit if a demo needs it.
7. **NEXT:** 2.6 proper (`@ScriptProperty` value-type delivery — NodePath/Vector/
   Color to Kotlin script instances; unblocks platformer `view: NodePath`) requires
   extending the regex annotation parser the roadmap flags for Phase-3 KSP
   replacement first — sequencing decision pending. Other gaps: Variant Object.call
   dispatch, String-arg signal payloads, custom-Callable lambdas, TypedArray ARGS,
   value-type BuiltinTypes on iOS.
- Workflow: impl per roadmap model tag → review diff → commit straight to main.
  (Fable 5 is no longer available as of 2026-06-12 — the review step and
  attribution are Opus 4.8: `Co-Authored-By: Claude Opus 4.8 <noreply@anthropic.com>`.)

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
- **2026-06-12** — Phase 1.4 done (fable design + impl). Design doc:
  [callable-args-design.md](./callable-args-design.md). Decision: generated
  wrappers keep object+method `GodotCallable` (lifetime engine-side via
  ObjectID; destroy cell after ptrcall — engine copy-constructs Callable
  params); Kotlin-lambda→Callable deferred to a future custom-callable task
  (callable_custom_create2, free_func-driven registry lifetime) with the
  iOS C-shim counterpart noted. 3 new ObjectCalls helpers
  (StringCallable→Object, RID+ObjectList+Object[+Object]+Callable→Object) +
  hand-audited candidate_for entries (Callable stays out of CALL_SHAPES per
  shape-policy audit). +6 methods (→15,319, skips 1,503): JavaClassWrapper
  .create_sam_callback, OpenXRSpatialAnchorCapability
  .create_default_persistence_context + .start_entity_discovery,
  OpenXRSpatialMarkerTracking/PlaneTracking .start_entity_discovery,
  OpenXRSpatialEntityExtension.discover_spatial_entities_with_component_data.
  All remaining Callable skips are virtual `_*` or root-Object (deliberate).
  Gates: fixtures, signature/shape/layout/variant-policy audits, exact -6
  delta, compileKotlin — all pass. Phase 1 desktop/Android shape gaps:
  complete except deliberately blocked items below.
  Correction to the 1.3 blocked rationale: TypedObjectArray ARGS *do* have
  an audited init path (`initArrayOfObjects`, reused by the 1.4 OpenXR
  helpers) — only TypedRIDArray/TypedTransform3DArray genuinely lack init
  paths. Follow-up: OpenXR `do_entity_update` ×2 (and possibly
  `merge_importer_meshes`) could be unblocked today via the same path;
  TypedRIDArray/Transform3DArray args, (Dictionary)→Dictionary policy gate,
  and Signal arg (Tween.tween_await) remain blocked.
- **2026-06-12** — Phase 2.1 done (sonnet impl). iOS Vector2i/Vector3i arg +
  return kinds (PT_VECTOR2I=7 2×int32, PT_VECTOR3I=9 3×int32 — POD
  passthrough, no new C switch cases; tags were already reserved in the shim
  enum). New ios-runtime `types/Vector3i.kt`; 4 hand-written iOS helpers
  (no-args-ret + single-arg for both types); 2 C-shim self-test matrix rows
  (Sprite2D.frame_coords, PlaceholderTexture3D.size) + 2 Kotlin ObjectCalls
  probe rows — all marked **PENDING DEVICE VALIDATION** (debug-only,
  fail-loud, cannot pass silently). Sprite2D.kt regenerated: +3 methods
  (set/get frame_coords + property). Gates: check_wrapper_generator,
  check_ios_no_silent_stubs, local CI iOS checks, compileKotlinIosArm64,
  clang -fsyntax-only — all pass. Next device run must confirm the 2 new
  matrix rows before 2.6 builds on these kinds.
  Fable review: FIX-FIRST → fixed: Sprite2D.set_frame_coords(3,7) is rejected
  by ERR_FAIL_INDEX with default hframes/vframes=1 (would have reported a
  false ABI failure on device); both the C matrix row and the Kotlin probe
  now call set_hframes(4)/set_vframes(8) first. Widths/tags/hashes/struct/
  generator gating all verified correct by review.
- **2026-06-12** — Phase 2.2 done (sonnet impl). iOS Color/Rect2 arg + return
  kinds (PT_COLOR=11 4×float32=16B, PT_RECT2=12 4×float32=16B — Color
  components always float32, Rect2 real_t=float32 on single-precision iOS;
  both flow through POD passthrough, no new C switch cases; tags were already
  reserved in the shim enum). 4 hand-written iOS helpers in ObjectCalls.kt
  (ptrcallNoArgsRetColor/Rect2 + ptrcallWithColorArg/Rect2Arg) + PT_COLOR/
  PT_RECT2 constants; ptrcallWithStringNameAndBoolArgRetBool moved from
  generated to hand-written (was dropped by regeneration since Input is
  bespoke, not an IOS_EMIT_CLASS). 2 C-shim self-test matrix rows (color:
  CanvasItem.modulate(0.125,0.25,0.5,0.75) — validation-free, exact float32;
  rect2: GPUParticles2D.visibility_rect(1.5,2.5,3.5,4.5) — validation-free,
  exact float32) + 2 Kotlin ObjectCalls probe rows — all marked **PENDING
  DEVICE VALIDATION**. CanvasItem.get_modulate STUB removed: CanvasItem
  regenerated with 16 new methods (setModulate/getModulate/setSelfModulate/
  getSelfModulate now real; getViewportRect generated; drawLine/drawRect/
  drawCircle/drawArc/drawEllipseArc/drawEllipse + drawTexture*/drawMsdf*/
  drawLcd* variants). CanvasItem+Viewport SUGAR dropped (getViewportRect
  and getVisibleRect now generated). Node SUGAR preserved (getTree/
  getNodeOrNull/getAsOrNull/requireAs/getNodeAsOrNull/createTween remain
  bespoke) but getViewport() dropped from SUGAR (now generated).
  Additional classes regenerated: Control +4, GPUParticles2D +3,
  Sprite2D +3, CollisionObject2D +2, CollisionShape3D +3, Label +1
  (getCharacterBounds). STUB delta: 12→11 (-1 CanvasItem.get_modulate).
  SUGAR delta: 5→3 (-CanvasItem.getViewportRect, -Viewport.getVisibleRect).
  Gates: check_wrapper_generator, check_ios_no_silent_stubs, local CI iOS
  checks, compileKotlinIosArm64, clang -fsyntax-only — all pass.
- **2026-06-12** — Phase 2.1+2.2 device validation DONE (iPhone 12, iOS 26.5).
  Built+deployed debug xcframework via scripts/ios_visual_smoke.sh
  (`--allow-provisioning-updates`, team DVZT29Q4QT); re-launched with
  `devicectl process launch --console` to capture the SCENE-init self-test
  (the script's own devicectl launch does not stream the app console — its
  `>`/`2>` redirects catch devicectl, not the remote app; `--console` is
  required, idevicesyslog is a noisy fallback). Result: C
  `PTRCALL SELFTEST MATRIX: 14 passed, 0 failed` + Kotlin
  `OBJECTCALLS SELFTEST: 13 passed, 0 failed`, no construct-0 notes. All 8
  new rows (Vector2i/Vector3i/Color/Rect2 × C+Kotlin) PASS — check counts
  14/13 match source ST_CHECK/check() totals, so no row silently skipped.
  PENDING DEVICE VALIDATION markers cleared in kanama_ios_shim.c +
  ObjectCalls.kt. **2.6 unblocked; next is 2.3 (String-return ptrcall).**
- **2026-06-12** — Phase 2.3a String-return ptrcall DONE (opus impl, device-
  validated iPhone 12, iOS 26.5). String returns can't ride the generic ptrcall's
  fixed ret_out, so a dedicated C helper `kanama_ios_godot_ptrcall_no_args_ret_string`
  runs the call, UTF-8-encodes via `string_to_utf8_chars` (already resolved C-side),
  and destroys the String; Kotlin `ptrcallNoArgsRetString` uses a two-call length
  protocol (NULL probe → alloc → fill), safe because the wired methods are pure
  getters. Generator: `"String"` added to `IOS_RET_KOTLIN`, gated to the no-arg
  helper via `shape.function == "ptrcallNoArgsRetString"` (StringName no-arg returns
  share the "String" kotlin_return token but route through `ptrcallNoArgsRetStringName`
  — kept out for 2.3b; arg+String shapes likewise out). `IOS_PROPERTY_SUPPRESS`
  added: suppresses Label's `text` property so the bespoke writable `var text`
  (real `getText()` read + `IosGodot.setObjectText` write — set_text takes an
  unbuilt String arg) isn't shadowed by a generated read-only `val text`, which
  would break `label.text = …` in the demos (CoinsContainer.kt, ScoreLabel.kt).
  6 wrappers regenerated: Control/Resource/Node/Viewport/AnimationPlayer/Label —
  purely additive no-arg String getters (getText, getTooltipText, getName, getPath,
  getSceneFilePath, getTreeString[Pretty], getEditorDescription, getLanguage,
  getEllipsisChar, getParagraphSeparator, guiGetDragDescription, getAccessibility*).
  SUGAR re-applied to Label/Node/AnimationPlayer (+re-added `types.NodePath` import
  to Node). New self-test row Object.get_class(Node2D)=="Node2D" in both matrices:
  C 14→15 passed/0 failed, Kotlin 13→14 passed/0 failed, no construct-0 notes.
  no-silent-stubs now 1 annotated site (AnimationPlayer.getCurrentAnimation cache,
  → 2.3b). Gates: check_wrapper_generator, check_ios_no_silent_stubs,
  compileKotlinIosArm64, clang -fsyntax-only — all pass. StringName-return
  (get_current_animation) deferred to 2.3b (needs String-from-StringName ctor hop).
- **2026-06-13** — Phase 2.3b StringName-return ptrcall DONE (opus impl + review,
  device-validated iPhone 12, iOS 26.5). GDExtension has no StringName→utf8, so the
  dedicated C helper `kanama_ios_godot_ptrcall_no_args_ret_string_name` ptrcalls the
  StringName, builds a String via the `String(from: StringName)` constructor
  (`g_variant_get_ptr_constructor(KANAMA_IOS_VARIANT_TYPE_STRING, 2)` — index 2 per
  extension_api.json; mirrors the existing node_path-from-string ctor pattern, added
  to the hard-resolve guard), UTF-8 encodes, and destroys both. Kotlin
  `ptrcallNoArgsRetStringName` reuses the two-call length protocol. Generator gate
  relaxed: `shape.kotlin_return == "String"` now allows both `ptrcallNoArgsRetString`
  and `ptrcallNoArgsRetStringName` (both hand-written). This unblocked the real
  `AnimationPlayer.getCurrentAnimation()` (StringName return) — the SUGAR last-play()
  cache + `currentAnimationName` field were dropped (AnimationPlayer regenerated
  wholesale). 6 wrappers regenerated: AnimationPlayer (real getCurrentAnimation +
  `var currentAnimation`/assignedAnimation/autoplay), Node (getName + `var name`),
  Area2D/Area3D (audio/reverb bus name `var`s), Control (themeTypeVariation,
  translationContext `var`s); Label/Node SUGAR re-applied (+`types.NodePath` import).
  New self-test row Node.set_name("KanamaSN") → get_name() == "KanamaSN" in both
  matrices: device C 15→16 passed/0 failed, Kotlin 14→15 passed/0 failed, no notes.
  Gates: check_wrapper_generator, check_ios_no_silent_stubs (1 annotated site left),
  compileKotlinIosArm64, clang -fsyntax-only — all pass. Deploy note: the device
  briefly ran a stale xcframework after an interrupted run; verified build
  correctness via `nm` of the rebuilt `.a` (symbol present) and re-ran a clean
  ios_visual_smoke.sh to redeploy before trusting the device counts.
- **2026-06-13** — Phase 2.4 PT_STRING/PT_NODE_PATH args DONE (opus impl + review,
  device-validated iPhone 12, iOS 26.5). The generic dispatch builds String and
  NodePath args from the C string the same way it already built StringName (reusing
  `init_string`/`init_node_path` + the matching destructors); the per-arg cell array
  was generalized to `builtin_cells` with `constructed[i]` carrying the tag so the
  right destructor runs. Generator widened: `String`/`NodePath` added to
  `IOS_ARG_KINDS`, tags `PT_STRING=16`/`PT_NODE_PATH=17` in `IOS_PT_TAG_VALUES`,
  `ios_arg_layout` cases (`{a}.cstr.ptr` for String, `{a}.path.cstr.ptr` for
  NodePath), plus the `types.NodePath` import in the generated ObjectCalls header.
  `IOS_PROPERTY_SUPPRESS` emptied: with PT_STRING args real, `set_text` generates, so
  `Label.text` graduated to a fully generated `var text` (+ `setText`/`getText`) and
  its bespoke SUGAR was retired. 11 wrappers regenerated (broad: String/NodePath
  setters across AnimationMixer/AnimationPlayer/Area3D/Control/GPUParticles2D+3D/
  Node/Node3D/Resource/Viewport + read-only→writable property upgrades); Node SUGAR
  re-applied (generated `getNodeOrNull(NodePath)` overloads the bespoke
  `getNodeOrNull(String)`); the Node3D generator fixture was refreshed. Two new
  self-test rows in each matrix — Node.set_scene_file_path→get_scene_file_path
  (String round-trip) and parent.add_child(child)+get_node_or_null(NodePath) (Object
  round-trip). Device: C 16→18 passed/0 failed, Kotlin 15→17 passed/0 failed, no
  construct-0 notes. **Triage:** the first device build crashed SIGSEGV — the crash
  `.ips` (pulled via idevicecrashreport) showed `construct_object("Label")` →
  `Label::_notification` → `ThemeContext::get_themes()` null-deref: a treeless
  Control segfaults in its post-init Theme lookup. Harness bug, not marshalling;
  switched the String row from `Label.set_text` to `Node.set_scene_file_path` (same
  shape/hash). Gates: check_wrapper_generator (Node3D fixture updated),
  check_ios_no_silent_stubs, compileKotlinIosArm64, clang -fsyntax-only — all pass.
- **2026-06-13** — Phase 2.5 Transform3D/Basis DONE (opus impl + review,
  device-validated iPhone 12, iOS 26.5). Both flow through the dispatch's POD
  passthrough (raw real_t bytes, no new C switch case — same as Color/Rect2); enum
  tags `PT_BASIS=18`/`PT_TRANSFORM3D=19` are Kotlin-side sizing only. Added minimal
  iOS `types/Basis.kt` (x/y/z column axes + IDENTITY) and `types/Transform3D.kt`
  (basis + origin + IDENTITY); deliberately no BuiltinTypes value methods (inverse/
  scaled/etc. need the variant-call path, still unwired on iOS — those are a separate
  backlog item). Generator: `Basis`/`Transform3D` added to `IOS_ARG_KINDS` +
  `IOS_RET_KOTLIN`, tag values, `ios_arg_layout` (Basis 9 float32 column-major
  `[x.x,y.x,z.x,x.y,y.y,z.y,x.z,y.z,z.z]`; Transform3D those 9 + origin 3) and the
  mirror `ios_ret_layout`, plus Basis/Transform3D imports in the generated ObjectCalls
  header. Layout verified against the desktop Basis/Transform3D writeTo/readFrom (same
  column-major indexing) — and a set→get round-trip is self-checking regardless. 5
  wrappers regenerated: Node3D (get/setTransform, get/setBasis, global* + `var
  transform/basis/globalTransform/globalBasis`), Camera3D.getCameraTransform,
  CollisionObject3D.shapeOwnerGet/SetTransform, GPUParticles3D.emitParticle; Node
  net-unchanged (SUGAR-only regen churn). New self-test rows: Node3D
  set_transform→get_transform (12 float32) and set_basis→get_basis (9 float32) with
  exact-in-float32 diagonal (pure-scale) values. Device C 18→20 passed/0 failed,
  Kotlin 17→19 passed/0 failed, no construct-0 notes; passed first device run. Node3D
  generator fixture refreshed. Gates: check_wrapper_generator, check_ios_no_silent_stubs,
  compileKotlinIosArm64, clang -fsyntax-only — all pass. (One compile catch fixed
  pre-device: the Basis self-test local `n3b` collided with the existing T3.1
  generated-vector3 `n3b` → renamed `basisNode`.)
- **2026-06-13** — RID/Quaternion/AABB kinds DONE (opus impl + review,
  device-validated iPhone 12, iOS 26.5). Continued the audited-kind widening past the
  numbered 2.x set (user chose this over starting 2.6, which needs the Phase-3 parser
  rework first). All POD passthrough, no new C dispatch case: RID is the pre-existing
  `PT_RID=14` uint64; Quaternion `PT_QUATERNION=20` (4 float32 `[x,y,z,w]`); AABB
  `PT_AABB=21` (6 float32, position then size). New iOS value types RID (`@JvmInline
  value class`, needs explicit `import kotlin.jvm.JvmInline` on Native), Quaternion,
  AABB. Generator widened (arg/ret kinds, tag values, layouts, header imports). 13
  wrappers regenerated; Node SUGAR re-applied; Node3D fixture refreshed. Self-test
  rows: GPUParticles3D get_base→set_base→get_base RID round-trip (auto particles base
  is nonzero); GPUParticles3D set_custom_aabb→get_custom_aabb (exact float32); Node3D
  set_quaternion→get_quaternion with ε=1e-4 (Godot stores rotation as a basis and
  re-derives the quaternion, so the round-trip is float, not bit-exact — the only
  non-exact self-test row, deliberately). Device C 20→23 passed/0 failed, Kotlin
  19→22 passed/0 failed, no construct-0 notes; passed first device run. Plane
  deferred: no clean Plane arg+return on an emitted class to anchor a matrix row.
  Gates: check_wrapper_generator, check_ios_no_silent_stubs, compileKotlinIosArm64,
  clang -fsyntax-only — all pass.
