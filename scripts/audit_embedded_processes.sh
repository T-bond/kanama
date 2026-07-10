#!/usr/bin/env bash
set -euo pipefail
# Interactive maintainer aid (not wired into CI/local_ci): lists running Godot
# editor/embedded-game processes for debugging editor-loop issues. Keep runnable.

filter="${1:-Starter-Kit}"

echo "[embedded_audit] filter: $filter"
echo "[embedded_audit] time: $(date '+%Y-%m-%d %H:%M:%S %z')"
echo

ps_output="$(ps -axo pid=,ppid=,stat=,command=)"

print_matches() {
  local title="$1"
  local pattern="$2"
  echo "== $title =="
  local matches
  matches="$(printf '%s\n' "$ps_output" | awk -v pattern="$pattern" -v filter="$filter" '
    index($0, "godot") > 0 && index($0, pattern) > 0 && (filter == "" || index($0, filter) > 0) {
      print
    }
  ')"
  if [[ -z "$matches" ]]; then
    echo "(none)"
  else
    printf '%s\n' "$matches"
  fi
  echo
}

print_matches "Embedded game processes" "--embedded"
print_matches "Editor processes" "--editor"

echo "== All Godot processes matching filter =="
all_matches="$(printf '%s\n' "$ps_output" | awk -v filter="$filter" '
  index($0, "godot") > 0 && (filter == "" || index($0, filter) > 0) {
    print
  }
')"
if [[ -z "$all_matches" ]]; then
  echo "(none)"
else
  printf '%s\n' "$all_matches"
fi

