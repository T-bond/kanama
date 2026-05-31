#!/usr/bin/env bash
set -euo pipefail

usage() {
  cat <<'EOF'
usage: scripts/package_install_smoke.sh [options] /path/to/kanama-package.zip [/path/to/godot]
       scripts/package_install_smoke.sh [options] /path/to/godot /path/to/kanama-package.zip

Unzips a packaged Kanama desktop kit or store addon into a temporary project,
builds the starter Kotlin script without a sibling Kanama source checkout, and
optionally launches Godot.

Options:
  --desktop-kit                  Require a desktop-kit zip.
  --store-addon                  Require a store-addon zip.
  --require-all-store-platforms  Require all store-addon desktop native libs.
  --work-dir DIR                 Existing empty or non-existing workspace dir.
  --keep-work-dir                Do not delete a generated temporary workspace.
  --help, -h                     Show this help.
EOF
}

work_dir=""
keep_work_dir=0
zip_path=""
godot_bin=""
package_kind="auto"
require_all_store_platforms=0

while [[ $# -gt 0 ]]; do
  case "$1" in
    --desktop-kit)
      package_kind="desktop-kit"
      shift
      ;;
    --store-addon)
      package_kind="store-addon"
      shift
      ;;
    --require-all-store-platforms)
      require_all_store_platforms=1
      shift
      ;;
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
  echo "[package_install_smoke] missing package zip" >&2
  usage
  exit 2
fi
if [[ ! -f "$zip_path" ]]; then
  echo "[package_install_smoke] package zip does not exist: $zip_path" >&2
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
    rm -rf "$work_dir" 2>/dev/null || true
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

case "$(uname -s)" in
  Darwin)
    if command -v xattr >/dev/null 2>&1; then
      xattr -dr com.apple.quarantine "$project_dir" 2>/dev/null || true
    fi
    ;;
esac

check_file() {
  local path="$1"
  if [[ ! -f "$project_dir/$path" ]]; then
    echo "[package_install_smoke] missing packaged file: $path" >&2
    exit 1
  fi
}

write_smoke_project_files() {
  cat >"$project_dir/project.godot" <<'EOF'
; Engine configuration file.
; It's best edited using the editor UI and not directly.

config_version=5

[application]

config/name="Kanama Store Addon Smoke"
run/main_scene="res://main.tscn"
config/features=PackedStringArray("4.7")

[editor_plugins]

enabled=PackedStringArray("res://addons/kanama_tools/plugin.cfg")

[kanama]

tools/kotlin_sources_dir="res://kotlin-src"
tools/auto_build_on_save=false
tools/auto_build_debounce_ms=800
tools/reload_scene_after_sync=true
EOF

  cat >"$project_dir/main.tscn" <<'EOF'
[gd_scene load_steps=2 format=3]

[ext_resource type="Script" path="res://kotlin-src/HelloScript.kt" id="1"]

[node name="Main" type="Node2D"]
script = ExtResource("1")

[node name="Status" type="Label" parent="."]
offset_left = -160.0
offset_top = -32.0
offset_right = 160.0
offset_bottom = 32.0
text = "Build Kanama scripts, then press Play."
horizontal_alignment = 1
vertical_alignment = 1
EOF
}

host_platform_classifier() {
  local os
  local arch
  case "$(uname -s)" in
    Darwin) os="macos" ;;
    Linux) os="linux" ;;
    MINGW*|MSYS*|CYGWIN*) os="windows" ;;
    *)
      echo "[package_install_smoke] unsupported host OS: $(uname -s)" >&2
      exit 2
      ;;
  esac
  case "$(uname -m)" in
    arm64|aarch64) arch="arm64" ;;
    x86_64|amd64) arch="x64" ;;
    *)
      echo "[package_install_smoke] unsupported host architecture: $(uname -m)" >&2
      exit 2
      ;;
  esac
  printf '%s-%s\n' "$os" "$arch"
}

native_library_for_platform() {
  case "$1" in
    windows-*) printf 'kanama_bootstrap.dll\n' ;;
    macos-*) printf 'libkanama_bootstrap.dylib\n' ;;
    *) printf 'libkanama_bootstrap.so\n' ;;
  esac
}

require_native_library() {
  local classifier="$1"
  local library_name
  library_name="$(native_library_for_platform "$classifier")"
  check_file "addons/kanama/bin/$classifier/$library_name"
}

if [[ -f "$project_dir/project.godot" && -f "$project_dir/build.gradle.kts" ]]; then
  detected_kind="desktop-kit"
elif [[ -f "$project_dir/addons/kanama/templates/release-kit/build.gradle.kts" ]]; then
  detected_kind="store-addon"
else
  echo "[package_install_smoke] could not detect package kind for: $zip_path" >&2
  exit 1
fi

if [[ "$package_kind" != "auto" && "$package_kind" != "$detected_kind" ]]; then
  echo "[package_install_smoke] expected $package_kind package, detected $detected_kind" >&2
  exit 1
fi

if [[ "$detected_kind" == "store-addon" ]]; then
  nested_project="$(find "$project_dir/addons" -name project.godot -print -quit)"
  if [[ -n "$nested_project" ]]; then
    echo "[package_install_smoke] store addon contains nested Godot project file: ${nested_project#$project_dir/}" >&2
    exit 1
  fi

  write_smoke_project_files
  (cd "$project_dir" && sh addons/kanama/setup-kanama-project.sh)

  require_native_library "$(host_platform_classifier)"
  if [[ "$require_all_store_platforms" -eq 1 ]]; then
    require_native_library "macos-arm64"
    require_native_library "linux-x64"
    require_native_library "linux-arm64"
    require_native_library "windows-x64"
  fi
fi

echo "[package_install_smoke] package kind: $detected_kind"

check_file "project.godot"
check_file "build.gradle.kts"
check_file "settings.gradle.kts"
check_file "gradlew"
check_file "kotlin-src/HelloScript.kt"
check_file "addons/kanama/kanama.jar"
check_file "addons/kanama/kanama.gdextension"
check_file "addons/kanama/kanama-project.gradle.kts"
check_file ".godot/extension_list.cfg"

if ! grep -Fxq "res://addons/kanama/kanama.gdextension" "$project_dir/.godot/extension_list.cfg"; then
  echo "[package_install_smoke] extension_list.cfg does not register Kanama" >&2
  exit 1
fi

if [[ -x "$project_dir/gradlew" ]]; then
  "$project_dir/gradlew" --no-daemon -p "$project_dir" buildScripts
else
  bash "$project_dir/gradlew" --no-daemon -p "$project_dir" buildScripts
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
