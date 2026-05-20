#!/usr/bin/env bash
#
# Regenerate Panama bindings from the GDExtension C header.
#
# Usage:
#   ./scripts/jextract.sh
#
# Reads:   gdextension/gdextension_interface.h
# Writes:  src/generated/godot/jvm/generated/GDExtensionInterface.java
#
# Requires JEXTRACT_HOME to point at a jextract install.

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "$0")/.." && pwd)"
HEADER="$REPO_ROOT/gdextension/gdextension_interface.h"
OUT_DIR="$REPO_ROOT/src/generated"
TARGET_PACKAGE="godot.jvm.generated"
JEXTRACT_BIN="${JEXTRACT_HOME:-}/bin/jextract"

if [[ -z "${JEXTRACT_HOME:-}" ]]; then
    echo "error: JEXTRACT_HOME is not set" >&2
    echo "       set JEXTRACT_HOME to the directory containing bin/jextract" >&2
    exit 1
fi

if [[ ! -x "$JEXTRACT_BIN" ]]; then
    echo "error: jextract not found at $JEXTRACT_BIN" >&2
    echo "       set JEXTRACT_HOME to the directory containing bin/jextract" >&2
    exit 1
fi

if [[ ! -f "$HEADER" ]]; then
    echo "error: $HEADER missing" >&2
    echo "       generate it by building Godot once, then copy from godot/core/extension/" >&2
    exit 1
fi

rm -rf "$OUT_DIR"
mkdir -p "$OUT_DIR"

"$JEXTRACT_BIN" \
    --output "$OUT_DIR" \
    --target-package "$TARGET_PACKAGE" \
    --header-class-name GDExtensionInterface \
    "$HEADER"

echo "jextract: wrote $OUT_DIR/$(echo "$TARGET_PACKAGE" | tr . /)/GDExtensionInterface.java"
