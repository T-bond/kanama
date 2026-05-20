#!/usr/bin/env python3
"""Audit hand-written Kanama value-type wrappers against Godot builtins.

This is a guardrail for the bug class found in Quaternion.slerp and
Transform3D.interpolateWith:

* a Kotlin method has the same semantic name as a Godot builtin method, but
  reimplements math instead of calling BuiltinTypes.call/construct;
* a Godot builtin method argument typed as `float` is marshalled with
  GodotReal storage instead of the builtin-call ABI `JAVA_DOUBLE`.

The script is intentionally report-only for now. It exits non-zero only when
`--strict` is passed.
"""

from __future__ import annotations

import argparse
import json
import re
import sys
from dataclasses import dataclass
from pathlib import Path


ROOT = Path(__file__).resolve().parents[1]
TYPES_DIR = ROOT / "src/main/kotlin/net/multigesture/kanama/types"
API_PATH = ROOT / "extension_api.json"

# Reviewed local implementations whose Godot C++ definitions are direct scalar
# formulas. Keep transform, basis, quaternion interpolation, projection, and
# other orientation/physics-sensitive helpers out of this list unless they have
# focused parity coverage.
REVIEWED_LOCAL_MATH = {
    "AABB.hasPoint",
    "Plane.distanceTo",
    "Plane.intersectsRay",
    "Quaternion.dot",
    "Quaternion.inverse",
    "Quaternion.length",
    "Quaternion.lengthSquared",
    "Quaternion.normalized",
    "Rect2.hasPoint",
    "RID.isValid",
    "Vector2.angle",
    "Vector2.distanceSquaredTo",
    "Vector2.distanceTo",
    "Vector2.dot",
    "Vector2.length",
    "Vector2.lengthSquared",
    "Vector2.normalized",
    "Vector3.cross",
    "Vector3.distanceSquaredTo",
    "Vector3.distanceTo",
    "Vector3.dot",
    "Vector3.length",
    "Vector3.lengthSquared",
    "Vector3.normalized",
    "Vector4.dot",
    "Vector4.length",
    "Vector4.lengthSquared",
}


FUN_RE = re.compile(
    r"(?P<indent>^[ \t]*)"
    r"(?:(?:public|private|internal)\s+)?"
    r"(?P<operator>operator\s+)?fun\s+"
    r"(?P<name>[A-Za-z_][A-Za-z0-9_]*)\s*"
    r"\(",
    re.MULTILINE,
)

BUILTIN_CALL_RE = re.compile(r"\bBuiltinTypes\.(?:call|construct)\s*\(")
ARG_ALLOC_RE = re.compile(
    r"val\s+(?P<name>[A-Za-z_][A-Za-z0-9_]*)Arg\s*=\s*arena\.allocate\((?P<layout>[^)\n]+)\)",
)
ARG_WRITE_RE = re.compile(
    r"(?P<name>[A-Za-z_][A-Za-z0-9_]*)Arg\.set\((?P<layout>JAVA_[A-Z0-9_]+)\s*,"
    r"|GodotReal\.writeIndex\(\s*(?P<real_name>[A-Za-z_][A-Za-z0-9_]*)Arg\s*,",
)


@dataclass(frozen=True)
class KotlinFunction:
    path: Path
    class_name: str
    name: str
    body: str
    line: int


def load_api(path: Path) -> dict:
    with path.open("r", encoding="utf-8") as fp:
        return json.load(fp)


def lower_camel_to_snake(name: str) -> str:
    # getRotationQuaternion -> get_rotation_quaternion, AABB-ish names remain
    # best-effort because this is an audit heuristic, not code generation.
    name = re.sub(r"(?<=[a-z0-9])(?=[A-Z])", "_", name)
    return name.lower()


def find_matching_paren(content: str, open_index: int) -> int | None:
    depth = 0
    in_string = False
    escaped = False
    for i in range(open_index, len(content)):
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
        elif ch == "(":
            depth += 1
        elif ch == ")":
            depth -= 1
            if depth == 0:
                return i
    return None


def find_function_end(content: str, after_signature: int) -> int:
    i = after_signature
    while i < len(content) and content[i].isspace():
        i += 1
    if i < len(content) and content[i] == "=":
        next_fun = FUN_RE.search(content, i + 1)
        return next_fun.start() if next_fun else len(content)
    if i < len(content) and content[i] == "{":
        depth = 0
        in_string = False
        escaped = False
        for j in range(i, len(content)):
            ch = content[j]
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
                    return j + 1
    next_fun = FUN_RE.search(content, i)
    return next_fun.start() if next_fun else len(content)


def kotlin_functions(path: Path) -> list[KotlinFunction]:
    content = path.read_text(encoding="utf-8")
    class_name = path.stem
    result: list[KotlinFunction] = []
    for match in FUN_RE.finditer(content):
        if match.group("operator"):
            continue
        if "private" in content[max(0, match.start() - 32) : match.start()]:
            continue
        paren = content.find("(", match.start())
        close = find_matching_paren(content, paren)
        if close is None:
            continue
        end = find_function_end(content, close + 1)
        line = content.count("\n", 0, match.start()) + 1
        result.append(
            KotlinFunction(
                path=path,
                class_name=class_name,
                name=match.group("name"),
                body=content[match.start() : end],
                line=line,
            ),
        )
    return result


def builtin_calling_helpers(functions: list[KotlinFunction]) -> set[str]:
    return {
        fn.name
        for fn in functions
        if BUILTIN_CALL_RE.search(fn.body)
    }


def uses_builtin_call(fn: KotlinFunction, helpers: set[str]) -> bool:
    if BUILTIN_CALL_RE.search(fn.body):
        return True
    return any(re.search(rf"\b{re.escape(helper)}\s*\(", fn.body) for helper in helpers)


def builtin_methods(api: dict) -> dict[str, dict[str, dict]]:
    result: dict[str, dict[str, dict]] = {}
    for cls in api.get("builtin_classes", []):
        name = cls.get("name")
        if not name:
            continue
        methods = {}
        for method in cls.get("methods", []):
            method_name = method.get("name")
            if method_name:
                methods[method_name] = method
        result[name] = methods
    return result


def method_float_arguments(method: dict) -> set[str]:
    return {
        arg["name"]
        for arg in method.get("arguments", [])
        if arg.get("type") == "float" and arg.get("name")
    }


def audit_float_abi(fn: KotlinFunction, method: dict) -> list[str]:
    float_args = method_float_arguments(method)
    if not float_args or not BUILTIN_CALL_RE.search(fn.body):
        return []

    allocations = {
        match.group("name"): match.group("layout")
        for match in ARG_ALLOC_RE.finditer(fn.body)
    }
    writes: dict[str, str] = {}
    for match in ARG_WRITE_RE.finditer(fn.body):
        if match.group("real_name"):
            writes[match.group("real_name")] = "GodotReal"
        else:
            writes[match.group("name")] = match.group("layout")

    warnings = []
    for arg in sorted(float_args):
        allocation = allocations.get(arg)
        write = writes.get(arg)
        if allocation is None and write is None:
            # Some helpers do allocation in shared routines; skip those until
            # the audit learns to follow helper calls.
            continue
        if allocation != "JAVA_DOUBLE" or write != "JAVA_DOUBLE":
            warnings.append(
                f"{fn.path}:{fn.line}: {fn.class_name}.{fn.name} builtin float arg "
                f"'{arg}' should use JAVA_DOUBLE ABI, saw allocate={allocation}, write={write}",
            )
    return warnings


def main() -> int:
    parser = argparse.ArgumentParser()
    parser.add_argument("--api", type=Path, default=API_PATH)
    parser.add_argument("--strict", action="store_true")
    args = parser.parse_args()

    api = load_api(args.api)
    methods_by_type = builtin_methods(api)

    suspicious = []
    abi_warnings = []
    covered = 0
    reviewed_local = 0

    for path in sorted(TYPES_DIR.glob("*.kt")):
        class_name = path.stem
        methods = methods_by_type.get(class_name, {})
        if not methods:
            continue
        functions = kotlin_functions(path)
        helpers = builtin_calling_helpers(functions)
        for fn in functions:
            builtin_name = lower_camel_to_snake(fn.name)
            method = methods.get(builtin_name)
            if not method:
                continue
            covered += 1
            if not uses_builtin_call(fn, helpers):
                qualified = f"{class_name}.{fn.name}"
                if qualified in REVIEWED_LOCAL_MATH:
                    reviewed_local += 1
                    continue
                suspicious.append(
                    f"{fn.path}:{fn.line}: {class_name}.{fn.name} matches Godot "
                    f"{class_name}.{builtin_name} but does not call BuiltinTypes",
                )
            abi_warnings.extend(audit_float_abi(fn, method))

    print(f"[value_type_audit] checked {covered} Kotlin methods that map to Godot builtins")
    if reviewed_local:
        print(f"[value_type_audit] accepted {reviewed_local} reviewed local math helper(s)")

    if suspicious:
        print("\n[value_type_audit] methods to review for hand-written math:")
        for line in suspicious:
            print(f"  - {line}")

    if abi_warnings:
        print("\n[value_type_audit] builtin float ABI warnings:")
        for line in abi_warnings:
            print(f"  - {line}")

    if not suspicious and not abi_warnings:
        print("[value_type_audit] no suspicious value-type wrapper methods found")

    return 1 if args.strict and (suspicious or abi_warnings) else 0


if __name__ == "__main__":
    sys.exit(main())
