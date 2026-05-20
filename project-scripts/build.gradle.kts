plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp")
}

group = "net.multigesture.kanama"
version = "0.1.0"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(25)
    sourceSets.named("main") {
        val configuredDirs =
            providers.gradleProperty("kanamaProjectScriptsDirs").orNull
                ?: providers.gradleProperty("kanamaProjectScriptsDir").orNull

        if (configuredDirs.isNullOrBlank()) {
            kotlin.srcDir(layout.projectDirectory.dir("../example_project"))
        } else {
            configuredDirs
                .split(File.pathSeparator, ",")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
                .forEach { kotlin.srcDir(file(it)) }
        }
    }
}

dependencies {
    implementation(project(":"))
    implementation(project(":annotations"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    ksp(project(":processor"))
}

tasks.named<Jar>("jar") {
    archiveFileName.set("kanama-scripts.jar")
}
