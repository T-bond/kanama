#!/usr/bin/env bash
set -euo pipefail

usage() {
  cat <<'EOF'
usage: scripts/package_install_smoke.sh [options] /path/to/kanama-desktop-kit.zip [/path/to/godot]
       scripts/package_install_smoke.sh [options] /path/to/godot /path/to/kanama-desktop-kit.zip

Unzips a packaged Kanama desktop kit into a temporary project, builds the
starter Kotlin script without a sibling Kanama source checkout, and optionally
launches Godot.

Options:
  --work-dir DIR     Existing empty or non-existing workspace dir.
  --keep-work-dir    Do not delete a generated temporary workspace.
  --help, -h         Show this help.
EOF
}

work_dir=""
keep_work_dir=0
zip_path=""
godot_bin=""

while [[ $# -gt 0 ]]; do
  case "$1" in
    --work-dir)
      work_dir="${2:-}"
      shift 2
      ;;
    --keep-work-dir)
      keep_work_dir=1
      shift
      ;;
    --help|-h)
      usage
      exit 0
      ;;
    --*)
      echo "[package_install_smoke] unknown option: $1" >&2
      usage
      exit 2
      ;;
    *)
      if [[ "$1" == *.zip && -z "$zip_path" ]]; then
        zip_path="$1"
      elif [[ -z "$godot_bin" ]]; then
        godot_bin="$1"
      elif [[ -z "$zip_path" ]]; then
        zip_path="$1"
      else
        echo "[package_install_smoke] unexpected extra argument: $1" >&2
        usage
        exit 2
      fi
      shift
      ;;
  esac
done

if [[ -z "$zip_path" ]]; then
  echo "[package_install_smoke] missing desktop kit zip" >&2
  usage
  exit 2
fi
if [[ ! -f "$zip_path" ]]; then
  echo "[package_install_smoke] desktop kit zip does not exist: $zip_path" >&2
  exit 2
fi
if [[ -n "$godot_bin" && ! -x "$godot_bin" ]]; then
  echo "[package_install_smoke] Godot binary is not executable: $godot_bin" >&2
  exit 2
fi

created_work_dir=0
if [[ -z "$work_dir" ]]; then
  work_dir="$(mktemp -d "${TMPDIR:-/tmp}/kanama_package_install.XXXXXX")"
  created_work_dir=1
else
  mkdir -p "$work_dir"
fi

cleanup() {
  if [[ "$created_work_dir" -eq 1 && "$keep_work_dir" != "1" ]]; then
    rm -rf "$work_dir"
  fi
}
trap cleanup EXIT

project_dir="$work_dir/project"
log_file="$work_dir/godot.log"
import_log_file="$work_dir/godot.import.log"
export GRADLE_USER_HOME="${GRADLE_USER_HOME:-$work_dir/gradle-home}"
mkdir -p "$project_dir" "$GRADLE_USER_HOME"

echo "[package_install_smoke] workspace: $work_dir"
unzip -q "$zip_path" -d "$project_dir"

check_file() {
  local path="$1"
  if [[ ! -f "$project_dir/$path" ]]; then
    echo "[package_install_smoke] missing packaged file: $path" >&2
    exit 1
  fi
}

check_file "project.godot"
check_file "build.gradle.kts"
check_file "settings.gradle.kts"
check_file "gradlew"
check_file "kotlin-src/HelloScript.kt"
check_file "addons/kanama/kanama.jar"
check_file "addons/kanama/kanama.gdextension"
check_file ".godot/extension_list.cfg"

if ! grep -Fxq "res://addons/kanama/kanama.gdextension" "$project_dir/.godot/extension_list.cfg"; then
  echo "[package_install_smoke] extension_list.cfg does not register Kanama" >&2
  exit 1
fi

if [[ -x "$project_dir/gradlew" ]]; then
  "$project_dir/gradlew" -p "$project_dir" buildScripts
else
  bash "$project_dir/gradlew" -p "$project_dir" buildScripts
fi

check_file "addons/kanama/kanama-scripts.jar"
jar tf "$project_dir/addons/kanama/kanama-scripts.jar" | grep -Fq "net/multigesture/kanama/generated/KanamaScriptRegistry"

if [[ -z "$godot_bin" ]]; then
  echo "[package_install_smoke] PASS (Godot launch skipped)"
  exit 0
fi

project_dir_for_godot="$project_dir"
case "$(uname -s)" in
  MINGW*|MSYS*|CYGWIN*)
    if command -v cygpath >/dev/null 2>&1; then
      godot_bin="$(cygpath -u "$godot_bin")"
      project_dir_for_godot="$(cygpath -m "$project_dir")"
    fi
    ;;
esac

"$godot_bin" --headless --editor --quit-after 120 --path "$project_dir_for_godot" >"$import_log_file" 2>&1
"$godot_bin" --headless --path "$project_dir_for_godot" --quit --verbose >"$log_file" 2>&1

if ! grep -Fq "[kanama:starter] Hello from Kanama" "$log_file"; then
  echo "[package_install_smoke] starter script did not run" >&2
  echo "[package_install_smoke] log tail:" >&2
  tail -n 120 "$log_file" >&2
  exit 1
fi

echo "[package_install_smoke] PASS"
