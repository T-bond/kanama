import org.gradle.jvm.tasks.Jar

val kanamaVersion = providers.gradleProperty("kanamaVersion")
    .orElse("@KANAMA_VERSION@")
val kotlinSourcesDir = providers.gradleProperty("kanamaProjectScriptsDir")
    .orElse("kotlin-src")
val defaultGodotBin = file("/Applications/Godot.app/Contents/MacOS/Godot")
    .takeIf { it.exists() }
    ?.absolutePath
    ?: "godot"
val godotBin = providers.gradleProperty("kanama.godot.executable")
    .orElse(providers.gradleProperty("godotBin"))
    .orElse(providers.environmentVariable("KANAMA_GODOT"))
    .getOrElse(defaultGodotBin)

repositories {
    maven {
        url = uri("addons/kanama/maven")
    }
    mavenCentral()
}

dependencies {
    "implementation"("net.multigesture.kanama:kanama:${kanamaVersion.get()}")
    "implementation"("net.multigesture.kanama:annotations:${kanamaVersion.get()}")
    "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
    "ksp"("net.multigesture.kanama:processor:${kanamaVersion.get()}")
}

tasks.named<Jar>("jar") {
    archiveFileName.set("kanama-scripts.jar")
    isPreserveFileTimestamps = false
    isReproducibleFileOrder = true
}

val installScriptJar by tasks.registering(Copy::class) {
    group = "kanama"
    description = "Install compiled Kotlin scripts into addons/kanama."
    dependsOn(tasks.named("jar"))
    from(tasks.named<Jar>("jar").flatMap { it.archiveFile })
    into(layout.projectDirectory.dir("addons/kanama"))
}

tasks.register("buildScripts") {
    group = "kanama"
    description = "Compile kotlin-src and install addons/kanama/kanama-scripts.jar."
    dependsOn(installScriptJar)
}

tasks.register<Exec>("runGodot") {
    group = "kanama"
    description = "Run this project in Godot."
    commandLine(godotBin, "--path", projectDir.absolutePath)
}

tasks.register<Exec>("openGodotEditor") {
    group = "kanama"
    description = "Open this project in the Godot editor."
    commandLine(godotBin, "--path", projectDir.absolutePath, "--editor")
}

tasks.register<Exec>("importGodot") {
    group = "kanama"
    description = "Import this project's assets in Godot."
    commandLine(godotBin, "--headless", "--import", "--path", projectDir.absolutePath)
}

tasks.register("buildAndRunGodot") {
    group = "kanama"
    description = "buildScripts, then runGodot."
    dependsOn("buildScripts", "runGodot")
    tasks.named("runGodot").get().mustRunAfter("buildScripts")
}
