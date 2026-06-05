plugins {
    id("com.android.library")
}

val kanamaRoot = rootProject.layout.projectDirectory.dir("../..")
val demoDir = providers.gradleProperty("kanamaAndroidDemoDir").map { file(it) }
val androidKanamaSources = layout.buildDirectory.dir("generated/kanamaAndroidSources")

data class AndroidSourceRemapRule(
    val name: String,
    val needle: String,
    val replacement: String,
)

val androidSourceRemapRules = listOf(
    AndroidSourceRemapRule(
        name = "foreign-package",
        needle = "java.lang.foreign",
        replacement = "com.v7878.foreign",
    ),
    AndroidSourceRemapRule(
        name = "panama-method-handle-invoke",
        needle = ".invoke(",
        replacement = ".invokeWithArguments(",
    ),
    AndroidSourceRemapRule(
        name = "kotlin-registration-callback-invoke",
        needle = "registerAll.invokeWithArguments",
        replacement = "registerAll.invoke",
    ),
    AndroidSourceRemapRule(
        name = "kotlin-script-factory-invoke",
        needle = "script.factory?.invokeWithArguments",
        replacement = "script.factory?.invoke",
    ),
    AndroidSourceRemapRule(
        name = "kotlin-property-default-callback-invoke",
        needle = "writePropertyDefault?.invokeWithArguments",
        replacement = "writePropertyDefault?.invoke",
    ),
    AndroidSourceRemapRule(
        name = "kotlin-dispatch-has-method-callback-invoke",
        needle = "dispatchHasMethod?.invokeWithArguments",
        replacement = "dispatchHasMethod?.invoke",
    ),
    AndroidSourceRemapRule(
        name = "kotlin-dispatch-call-callback-invoke",
        needle = "dispatchCall?.invokeWithArguments",
        replacement = "dispatchCall?.invoke",
    ),
    AndroidSourceRemapRule(
        name = "kotlin-signal-callback-invoke",
        needle = "callbacks[id]?.invokeWithArguments",
        replacement = "callbacks[id]?.invoke",
    ),
    AndroidSourceRemapRule(
        name = "generated-signal-callback-registry-invoke",
        needle = "SignalCallbackRegistry.invokeWithArguments",
        replacement = "SignalCallbackRegistry.invoke",
    ),
)

val androidForbiddenSourceFragments = listOf(
    "java.lang.foreign",
    "Files.readString",
    "Files.writeString",
    "getClassLoadingLock",
    "registerAll.invokeWithArguments",
    "script.factory?.invokeWithArguments",
    "writePropertyDefault?.invokeWithArguments",
    "dispatchHasMethod?.invokeWithArguments",
    "dispatchCall?.invokeWithArguments",
    "callbacks[id]?.invokeWithArguments",
    "SignalCallbackRegistry.invokeWithArguments",
    "?.invokeWithArguments(",
)

val androidForbiddenDemoSourcePatterns = listOf(
    Regex("""\?\.\s*invoke\s*\(""") to
        "nullable Kotlin callback invoke is unsafe for Android source remap; use explicit state or callback?.let { it() }",
)

fun remapAndroidKanamaSourceLine(line: String): String =
    androidSourceRemapRules.fold(line) { rewritten, rule ->
        rewritten.replace(rule.needle, rule.replacement)
    }

fun auditOriginalAndroidDemoSources(root: File) {
    val failures = mutableListOf<String>()
    if (!root.exists()) return

    root.walkTopDown()
        .filter { it.isFile && it.extension == "kt" }
        .forEach { file ->
            file.readLines().forEachIndexed { index, line ->
                val sourceLine = line.substringBefore("//")
                androidForbiddenDemoSourcePatterns.forEach { (pattern, message) ->
                    if (pattern.containsMatchIn(sourceLine)) {
                        failures += "${file.relativeTo(root)}:${index + 1}: $message"
                    }
                }
            }
        }

    if (failures.isNotEmpty()) {
        throw GradleException(
            buildString {
                appendLine("Android demo source audit failed before remap:")
                failures.take(40).forEach { appendLine("  $it") }
                if (failures.size > 40) {
                    appendLine("  ... ${failures.size - 40} more")
                }
            },
        )
    }
}

fun auditGeneratedAndroidKanamaSources(root: File) {
    val failures = mutableListOf<String>()
    root.walkTopDown()
        .filter { it.isFile && (it.extension == "kt" || it.extension == "java") }
        .forEach { file ->
            file.readLines().forEachIndexed { index, line ->
                val sourceLine = line.substringBefore("//")
                androidForbiddenSourceFragments.forEach { fragment ->
                    if (sourceLine.contains(fragment)) {
                        failures += "${file.relativeTo(root)}:${index + 1}: forbidden Android source fragment '$fragment'"
                    }
                }
            }
        }

    if (failures.isNotEmpty()) {
        throw GradleException(
            buildString {
                appendLine("Android Kanama source remap audit failed:")
                failures.take(40).forEach { appendLine("  $it") }
                if (failures.size > 40) {
                    appendLine("  ... ${failures.size - 40} more")
                }
            },
        )
    }
}

val auditAndroidDemoSources by tasks.registering {
    inputs.dir(demoDir.map { it.resolve("kotlin-src") })

    doLast {
        if (!demoDir.isPresent) {
            throw GradleException(
                "Missing -PkanamaAndroidDemoDir=/absolute/path/to/kanama demo project",
            )
        }
        auditOriginalAndroidDemoSources(demoDir.get().resolve("kotlin-src"))
    }
}

val prepareAndroidKanamaSources by tasks.registering(Sync::class) {
    into(androidKanamaSources)

    fun CopySpec.remapForeignImports() {
        filter { line: String ->
            remapAndroidKanamaSourceLine(line)
        }
    }

    from(kanamaRoot.dir("src/main/kotlin")) {
        exclude("example/**")
        remapForeignImports()
    }
    from(kanamaRoot.dir("annotations/src/main/kotlin")) {
        remapForeignImports()
    }
    from(demoDir.map { it.resolve("kotlin-src") }) {
        remapForeignImports()
    }
    from(demoDir.map { it.resolve("build/generated/ksp/main/kotlin") }) {
        remapForeignImports()
    }

    doFirst {
        if (!demoDir.isPresent) {
            throw GradleException(
                "Missing -PkanamaAndroidDemoDir=/absolute/path/to/kanama demo project",
            )
        }
    }

    doLast {
        val realFile = androidKanamaSources.get().file(
            "net/multigesture/kanama/types/Real.kt",
        ).asFile
        realFile.parentFile.mkdirs()
        realFile.writeText(
            """
            |package net.multigesture.kanama.types
            |
            |import com.v7878.foreign.MemorySegment
            |import com.v7878.foreign.ValueLayout.JAVA_FLOAT
            |
            |typealias real_t = Float
            |
            |object GodotReal {
            |    const val SIZE_BYTES: Long = 4L
            |    const val ALIGN_BYTES: Long = 4L
            |
            |    fun fromNumber(value: Number): real_t = value.toFloat()
            |    fun fromDouble(value: Double): real_t = value.toFloat()
            |    fun fromFloat(value: Float): real_t = value
            |
            |    fun byteOffset(index: Long): Long = index * SIZE_BYTES
            |
            |    fun readIndex(segment: MemorySegment, index: Long): real_t =
            |        segment.get(JAVA_FLOAT, byteOffset(index))
            |
            |    fun writeIndex(segment: MemorySegment, index: Long, value: real_t) {
            |        segment.set(JAVA_FLOAT, byteOffset(index), value)
            |    }
            |}
            |""".trimMargin(),
        )
    }
}

val auditAndroidKanamaSources by tasks.registering {
    dependsOn(auditAndroidDemoSources)
    dependsOn(prepareAndroidKanamaSources)
    inputs.dir(androidKanamaSources)

    doLast {
        auditGeneratedAndroidKanamaSources(androidKanamaSources.get().asFile)
    }
}

android {
    namespace = "net.multigesture.kanama.android"
    compileSdk = 36

    defaultConfig {
        minSdk = 26
        externalNativeBuild {
            cmake {
                abiFilters += listOf("arm64-v8a", "x86_64")
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
        }
    }

    sourceSets {
        named("main") {
            jniLibs.setSrcDirs(emptyList<File>())
        }
    }
}

androidComponents {
    onVariants(selector().all()) { variant ->
        variant.sources.kotlin?.addStaticSourceDirectory("build/generated/kanamaAndroidSources")
    }
}

tasks.named("preBuild") {
    dependsOn(auditAndroidKanamaSources)
}

dependencies {
    compileOnly(project(":godot-stubs"))
    implementation("io.github.vova7878.panama:Core:v0.1.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
}
