#!/usr/bin/env sh
set -eu

force=0
if [ "${1:-}" = "--force" ]; then
    force=1
elif [ "${1:-}" = "-h" ] || [ "${1:-}" = "--help" ]; then
    cat <<'EOF'
usage: addons/kanama/setup-kanama-project.sh [--force]

Run from a Godot project root after unzipping the Kanama store addon. The
script copies the packaged Gradle template when root Gradle files are missing,
adds the starter Kotlin script when kotlin-src is empty, and registers the
Kanama GDExtension.

Use --force to replace existing template files.
EOF
    exit 0
fi

project_dir=$(pwd)
template_dir="$project_dir/addons/kanama/templates/release-kit"
extension_path="res://addons/kanama/kanama.gdextension"

if [ ! -d "$template_dir" ]; then
    echo "[kanama] missing template directory: $template_dir" >&2
    echo "[kanama] run this script from the root of the Godot project where the addon was unzipped." >&2
    exit 1
fi

copy_file() {
    src="$1"
    dst="$2"
    if [ -e "$dst" ] && [ "$force" -ne 1 ]; then
        echo "[kanama] keeping existing ${dst#$project_dir/}"
        return
    fi
    mkdir -p "$(dirname "$dst")"
    cp "$src" "$dst"
    echo "[kanama] wrote ${dst#$project_dir/}"
}

copy_dir() {
    src="$1"
    dst="$2"
    if [ -e "$dst" ] && [ "$force" -ne 1 ]; then
        echo "[kanama] keeping existing ${dst#$project_dir/}"
        return
    fi
    if [ -e "$dst" ]; then
        rm -rf "$dst"
    fi
    mkdir -p "$(dirname "$dst")"
    cp -R "$src" "$dst"
    echo "[kanama] wrote ${dst#$project_dir/}"
}

copy_file "$template_dir/build.gradle.kts" "$project_dir/build.gradle.kts"
copy_file "$template_dir/settings.gradle.kts" "$project_dir/settings.gradle.kts"
copy_file "$template_dir/gradlew" "$project_dir/gradlew"
copy_file "$template_dir/gradlew.bat" "$project_dir/gradlew.bat"
copy_dir "$template_dir/gradle" "$project_dir/gradle"
mkdir -p "$project_dir/kotlin-src"
copy_file "$template_dir/kotlin-src/HelloScript.kt" "$project_dir/kotlin-src/HelloScript.kt"

if [ -f "$project_dir/gradlew" ]; then
    chmod +x "$project_dir/gradlew"
fi

mkdir -p "$project_dir/.godot"
extension_list="$project_dir/.godot/extension_list.cfg"
if [ -f "$extension_list" ] && grep -Fxq "$extension_path" "$extension_list"; then
    echo "[kanama] extension already registered"
else
    printf '%s\n' "$extension_path" >>"$extension_list"
    echo "[kanama] registered $extension_path"
fi

echo "[kanama] next: ./gradlew buildScripts"
