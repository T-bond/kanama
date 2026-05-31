# Agent Guide

This file is a short operational map for coding agents and maintainers. Public
user documentation lives in `docs/`; keep this file focused on how to work in
the repository without breaking Kanama's release shape.

## Read First

- `README.md` for the project status, requirements, and quick start.
- `CONTRIBUTING.md` before changing runtime, wrapper, generator, Android, or
  documentation code.
- `docs/contributing/architecture.md` before touching bootstrap, FFI, script
  lifetime, ClassDB registration, or hot reload.
- `docs/contributing/wrapper-maintenance.md` before changing generated
  wrappers, generator policy, ABI helpers, or KDoc sync.
- `docs/contributing/android-internals.md` and `docs/exporting/android.md`
  before changing Android support.

## Repository Rules

- Public package namespace is `net.multigesture.kanama`.
- Do not reintroduce local workstation paths, private maintainer notes, or
  obsolete project names into tracked files.
- Keep running task lists, dev logs, bundles, raw logs, and private handoff
  notes outside the public repo.
- Keep example coordinates synchronized with the active release pass.
- Do not widen ABI-sensitive types to make wrappers generate. Add exact helper
  shapes and audits first.
- Prefer generated wrappers and focused policy fixes over ad hoc hand wrappers.
- Do not claim platform support unless the matching smoke path has passed.

## Common Workflows

- **New Kanama game project:** start from `templates/starter`, follow
  `docs/getting-started/index.md`, and use IntelliJ IDEA for Kotlin editing.
- **Port existing GDScript:** follow `docs/game-dev/porting-gdscript.md` and
  `docs/game-dev/scripts.md`. Preserve scene names,
  exported property names, signal names, and original gameplay semantics.
- **Wrapper work:** use `scripts/generate_api_wrapper.py`,
  `scripts/check_wrapper_generator.py`, wrapper audits, and the coverage pages
  under `docs/reference/`.
- **Godot upgrade:** refresh `extension_api.json`, `gdextension_interface.h`,
  generated Panama bindings, wrapper reports, and KDoc together; then rerun
  local CI and demo smoke checks before changing support claims.
- **Android work:** keep Android experimental, use the Gradle AAR workflow, and
  validate with emulator smoke before updating release wording.

## Validation

Run the narrowest useful check while iterating, then use the broader gate before
publishing or rewriting history:

```sh
mkdocs build --strict
python3 scripts/check_wrapper_generator.py
./gradlew jar
./scripts/local_ci.sh /path/to/godot-4.7-beta4
```

Use demo-repo smoke tasks when a change affects real gameplay ports or Android
exports.
