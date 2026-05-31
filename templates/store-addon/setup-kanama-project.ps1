param(
    [switch]$Force
)

$ErrorActionPreference = "Stop"
$ProjectDir = (Get-Location).Path
$TemplateDir = Join-Path $ProjectDir "addons/kanama/templates/release-kit"
$ExtensionPath = "res://addons/kanama/kanama.gdextension"

if (-not (Test-Path -LiteralPath $TemplateDir -PathType Container)) {
    Write-Error "[kanama] missing template directory: $TemplateDir. Run this script from the Godot project root where the addon was unzipped."
}

function Copy-KanamaFile {
    param(
        [string]$Source,
        [string]$Destination
    )
    if ((Test-Path -LiteralPath $Destination) -and -not $Force) {
        Write-Host "[kanama] keeping existing $($Destination.Substring($ProjectDir.Length + 1))"
        return
    }
    New-Item -ItemType Directory -Force -Path (Split-Path -Parent $Destination) | Out-Null
    Copy-Item -LiteralPath $Source -Destination $Destination -Force
    Write-Host "[kanama] wrote $($Destination.Substring($ProjectDir.Length + 1))"
}

function Copy-KanamaDirectory {
    param(
        [string]$Source,
        [string]$Destination
    )
    if ((Test-Path -LiteralPath $Destination) -and -not $Force) {
        Write-Host "[kanama] keeping existing $($Destination.Substring($ProjectDir.Length + 1))"
        return
    }
    if (Test-Path -LiteralPath $Destination) {
        Remove-Item -LiteralPath $Destination -Recurse -Force
    }
    New-Item -ItemType Directory -Force -Path (Split-Path -Parent $Destination) | Out-Null
    Copy-Item -LiteralPath $Source -Destination $Destination -Recurse -Force
    Write-Host "[kanama] wrote $($Destination.Substring($ProjectDir.Length + 1))"
}

Copy-KanamaFile (Join-Path $TemplateDir "build.gradle.kts") (Join-Path $ProjectDir "build.gradle.kts")
Copy-KanamaFile (Join-Path $TemplateDir "settings.gradle.kts") (Join-Path $ProjectDir "settings.gradle.kts")
Copy-KanamaFile (Join-Path $TemplateDir "gradlew") (Join-Path $ProjectDir "gradlew")
Copy-KanamaFile (Join-Path $TemplateDir "gradlew.bat") (Join-Path $ProjectDir "gradlew.bat")
Copy-KanamaDirectory (Join-Path $TemplateDir "gradle") (Join-Path $ProjectDir "gradle")

$KotlinSrc = Join-Path $ProjectDir "kotlin-src"
New-Item -ItemType Directory -Force -Path $KotlinSrc | Out-Null
Copy-KanamaFile (Join-Path $TemplateDir "kotlin-src/HelloScript.kt") (Join-Path $KotlinSrc "HelloScript.kt")

$GodotDir = Join-Path $ProjectDir ".godot"
New-Item -ItemType Directory -Force -Path $GodotDir | Out-Null
$ExtensionList = Join-Path $GodotDir "extension_list.cfg"
$Existing = if (Test-Path -LiteralPath $ExtensionList) { Get-Content -LiteralPath $ExtensionList } else { @() }
if ($Existing -contains $ExtensionPath) {
    Write-Host "[kanama] extension already registered"
} else {
    Add-Content -LiteralPath $ExtensionList -Value $ExtensionPath
    Write-Host "[kanama] registered $ExtensionPath"
}

Write-Host "[kanama] next: .\gradlew.bat buildScripts"
