#!/usr/bin/env bash
set -euo pipefail

usage() {
  cat <<'EOF'
usage: scripts/fresh_clone_smoke.sh [options] /path/to/godot

Clones Kanama and kanama-demos into an isolated temporary workspace, uses
temporary Gradle and Maven-local state, then runs the source and demo smoke
checks a new contributor would depend on.

Options:
  --kanama-source URL_OR_PATH      Kanama clone source.
                                Default: https://github.com/falcon4ever/kanama.git
  --demos-source URL_OR_PATH       kanama-demos clone source.
                                Default: https://github.com/falcon4ever/kanama-demos.git
  --work-dir DIR                   Existing empty or non-existing workspace dir.
                                Default: mktemp under TMPDIR.
  --keep-work-dir                  Do not delete a generated temporary workspace.
  --skip-docs                      Pass --skip-docs to scripts/local_ci.sh.
  --skip-bootstrap                 Pass --skip-bootstrap to scripts/local_ci.sh.
  --skip-demos                     Skip kanama-demos build and desktop smoke.
  --help, -h                       Show this help.

Environment:
  KANAMA_FRESH_CLONE_WORK_DIR      Same as --work-dir.
  KANAMA_FRESH_CLONE_KEEP          Same as --keep-work-dir when set to 1.
  KANAMA_MAVEN_LOCAL_REPO          Optional isolated Maven-local repository.
EOF
}

kanama_source="https://github.com/falcon4ever/kanama.git"
demos_source="https://github.com/falcon4ever/kanama-demos.git"
work_dir="${KANAMA_FRESH_CLONE_WORK_DIR:-}"
keep_work_dir="${KANAMA_FRESH_CLONE_KEEP:-0}"
skip_docs=0
skip_bootstrap=0
skip_demos=0
godot_bin=""
created_work_dir=0

while [[ $# -gt 0 ]]; do
  case "$1" in
    --kanama-source)
      kanama_source="${2:-}"
      shift 2
      ;;
    --demos-source)
      demos_source="${2:-}"
      shift 2
      ;;
    --work-dir)
      work_dir="${2:-}"
      shift 2
      ;;
    --keep-work-dir)
      keep_work_dir=1
      shift
      ;;
    --skip-docs)
      skip_docs=1
      shift
      ;;
    --skip-bootstrap)
      skip_bootstrap=1
      shift
      ;;
    --skip-demos)
      skip_demos=1
      shift
      ;;
    --help|-h)
      usage
      exit 0
      ;;
    --*)
      echo "[fresh_clone_smoke] unknown option: $1" >&2
      usage
      exit 2
      ;;
    *)
      if [[ -n "$godot_bin" ]]; then
        echo "[fresh_clone_smoke] unexpected extra argument: $1" >&2
        usage
        exit 2
      fi
      godot_bin="$1"
      shift
      ;;
  esac
done

if [[ -z "$godot_bin" ]]; then
  echo "[fresh_clone_smoke] missing Godot binary" >&2
  usage
  exit 2
fi
if [[ ! -x "$godot_bin" ]]; then
  echo "[fresh_clone_smoke] Godot binary is not executable: $godot_bin" >&2
  exit 2
fi
if [[ -z "$kanama_source" || -z "$demos_source" ]]; then
  echo "[fresh_clone_smoke] clone sources must not be empty" >&2
  exit 2
fi

if [[ -z "$work_dir" ]]; then
  work_dir="$(mktemp -d "${TMPDIR:-/tmp}/kanama_fresh_clone.XXXXXX")"
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

fresh_home="$work_dir/home"
gradle_home="$work_dir/gradle-home"
maven_repo="${KANAMA_MAVEN_LOCAL_REPO:-$work_dir/m2-repository}"
kanama_dir="$work_dir/kanama"
demos_dir="$work_dir/kanama-demos"
mkdir -p "$fresh_home" "$gradle_home" "$maven_repo"

run() {
  echo "[fresh_clone_smoke] $*"
  "$@"
}

assert_clean() {
  local repo_dir="$1"
  local name="$2"
  local status
  status="$(git -C "$repo_dir" status --short)"
  if [[ -n "$status" ]]; then
    echo "[fresh_clone_smoke] $name has tracked worktree changes after validation:" >&2
    echo "$status" >&2
    exit 1
  fi
}

echo "[fresh_clone_smoke] workspace: $work_dir"
run git clone "$kanama_source" "$kanama_dir"
if [[ "$skip_demos" -eq 0 ]]; then
  run git clone "$demos_source" "$demos_dir"
fi

export HOME="$fresh_home"
export GRADLE_USER_HOME="$gradle_home"
export KANAMA_MAVEN_LOCAL_REPO="$maven_repo"
export GRADLE_OPTS="-Dmaven.repo.local=$maven_repo ${GRADLE_OPTS:-}"

local_ci_args=()
if [[ "$skip_docs" -eq 1 ]]; then
  local_ci_args+=("--skip-docs")
fi
if [[ "$skip_bootstrap" -eq 1 ]]; then
  local_ci_args+=("--skip-bootstrap")
fi
local_ci_args+=("$godot_bin")

run "$kanama_dir/scripts/local_ci.sh" "${local_ci_args[@]}"
assert_clean "$kanama_dir" "kanama"

if [[ "$skip_demos" -eq 0 ]]; then
  run "$demos_dir/gradlew" -p "$demos_dir" check
  run "$demos_dir/gradlew" -p "$demos_dir" buildAllScripts
  run "$demos_dir/scripts/desktop_smoke_all.sh" "$godot_bin"
  assert_clean "$demos_dir" "kanama-demos"
fi

echo "[fresh_clone_smoke] PASS"
