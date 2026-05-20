#!/usr/bin/env python3
"""Audit ObjectCalls scalar float ptrcall helpers.

Godot's API names scalar method values `float`, but the ptrcall ABI passes
those scalar floats through a 64-bit Variant float slot. Value-type components
are different: `Vector3` uses `real_t`, and `Color` stores fixed 32-bit
components. This audit prevents scalar helpers from accidentally using
JAVA_FLOAT again.
"""

from __future__ import annotations

import re
import sys
from pathlib import Path


ROOT = Path(__file__).resolve().parents[1]
OBJECT_CALLS = ROOT / "src/main/kotlin/binding/runtime/ObjectCalls.kt"

FUN_RE = re.compile(r"fun\s+(?P<name>ptrcall[A-Za-z0-9_]*Float[A-Za-z0-9_]*)\s*\(")


def find_function_end(content: str, start: int) -> int:
    brace = content.find("{", start)
    if brace == -1:
        return len(content)
    depth = 0
    in_string = False
    escaped = False
    for i in range(brace, len(content)):
        ch = content[i]
        if in_string:
            if escaped:
                escaped = False
            elif ch == "\\":
                escaped = True
            elif ch == '"':
                in_string = False
            continue
        if ch == '"':
            in_string = True
        elif ch == "{":
            depth += 1
        elif ch == "}":
            depth -= 1
            if depth == 0:
                return i + 1
    return len(content)


def main() -> int:
    content = OBJECT_CALLS.read_text(encoding="utf-8")
    errors: list[str] = []
    lines = content.splitlines()

    for match in FUN_RE.finditer(content):
        name = match.group("name")
        body = content[match.start() : find_function_end(content, match.end())]
        line = content.count("\n", 0, match.start()) + 1
        doc_start = content.rfind("/**", 0, match.start())
        doc_end = content.rfind("*/", 0, match.start())
        doc = content[doc_start : doc_end + 2] if doc_start != -1 and doc_end > doc_start else ""

        if "JAVA_FLOAT" in body:
            errors.append(
                f"{OBJECT_CALLS.relative_to(ROOT)}:{line}: {name} uses JAVA_FLOAT; "
                "scalar Godot float ptrcalls must use JAVA_DOUBLE",
            )

        if "scalar float" not in doc:
            errors.append(
                f"{OBJECT_CALLS.relative_to(ROOT)}:{line}: {name} doc must say "
                "'scalar float' to avoid confusing it with real_t/component storage",
            )

    # Fixed 32-bit component storage is still expected for Color only.
    import_lines = {
        index
        for index, text in enumerate(lines, start=1)
        if text.startswith("import ")
    }
    for match in re.finditer(r"\bJAVA_FLOAT\b", content):
        line = content.count("\n", 0, match.start()) + 1
        if line in import_lines:
            continue
        window = "\n".join(lines[max(0, line - 10) : min(len(lines), line + 5)])
        if "Color" not in window and "color." not in window:
            errors.append(
                f"{OBJECT_CALLS.relative_to(ROOT)}:{line}: JAVA_FLOAT outside Color component storage",
            )

    if errors:
        print("Scalar float ABI audit failed:", file=sys.stderr)
        for error in errors:
            print(f"  - {error}", file=sys.stderr)
        return 1

    print("Scalar float ABI audit passed")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
