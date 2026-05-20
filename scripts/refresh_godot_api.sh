#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
OUT_DIR="$ROOT_DIR/gdextension"
RUN_JEXTRACT=1

usage() {
  cat <<'EOF'
usage: scripts/refresh_godot_api.sh [--skip-jextract] /absolute/path/to/godot_binary

Dumps Godot's GDExtension API files into Kanama's local inputs:
  - extension_api.json
  - gdextension/gdextension_interface.h

Then runs scripts/jextract.sh and scripts/validate_godot_api.py unless
--skip-jextract is provided.
EOF
}

while [[ $# -gt 0 ]]; do
  case "$1" in
    --help|-h)
      usage
      exit 0
      ;;
    --skip-jextract)
      RUN_JEXTRACT=0
      shift
      ;;
    --*)
      echo "[refresh_godot_api] unknown option: $1" >&2
      usage
      exit 2
      ;;
    *)
      GODOT_BIN="$1"
      shift
      ;;
  esac
done

if [[ -z "${GODOT_BIN:-}" ]]; then
  echo "[refresh_godot_api] missing Godot binary" >&2
  usage
  exit 2
fi

if [[ ! -x "$GODOT_BIN" ]]; then
  echo "[refresh_godot_api] Godot binary is not executable: $GODOT_BIN" >&2
  exit 2
fi

TMP_DIR="$(mktemp -d "${TMPDIR:-/tmp}/kanama-godot-api.XXXXXX")"
cleanup() {
  rm -rf "$TMP_DIR"
}
trap cleanup EXIT

echo "[refresh_godot_api] dumping API from: $GODOT_BIN"
(
  cd "$TMP_DIR"
  "$GODOT_BIN" --headless --log-file "$TMP_DIR/godot-extension-api.log" --dump-extension-api
  "$GODOT_BIN" --headless --log-file "$TMP_DIR/godot-gdextension-interface.log" --dump-gdextension-interface
)

mkdir -p "$OUT_DIR"
cp "$TMP_DIR/extension_api.json" "$ROOT_DIR/extension_api.json"
cp "$TMP_DIR/gdextension_interface.h" "$OUT_DIR/gdextension_interface.h"

if [[ $RUN_JEXTRACT -eq 1 ]]; then
  echo "[refresh_godot_api] regenerating Panama bindings"
  "$ROOT_DIR/scripts/jextract.sh"
else
  echo "[refresh_godot_api] skipping jextract"
fi

echo "[refresh_godot_api] validating dumped API"
python3 "$ROOT_DIR/scripts/validate_godot_api.py"

echo "[refresh_godot_api] PASS"
