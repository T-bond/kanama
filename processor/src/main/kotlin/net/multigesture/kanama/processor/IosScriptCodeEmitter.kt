package net.multigesture.kanama.processor

import java.security.MessageDigest

// Kotlin/Native analogue of [ScriptCodeEmitter]: produces the iOS @ScriptClass registry
// Kotlin from the platform-neutral [ScriptModel], replacing the regex parser + Gradle
// codegen that lived in ios-runtime/build.gradle.kts (parseIosScript /
// generateIosRegistrySource / generateIosGeneratedConstantsSource /
// generateIosCompatibilitySources). Phase 3.2, script-model-unification-design.md.
//
// It is AGGREGATING (takes all scripts at once) because the regex path emits one combined
// `registerKanamaIosProjectScripts()` + per-script bridge file in package
// `net.multigesture.kanama.ios`, plus one constants file in `net.multigesture.kanama.generated`,
// plus per-package compatibility shims. Reproducing that exact shape lets the Phase-3.2
// parallel-run gate compare this output against the regex output for the demo scripts.
//
// The rich ScriptModel is mapped down to the regex path's thin fields here (see
// [toIosMethods]/[toIosProperties]) so the emitted source matches byte-for-byte.

/** One @ScriptClass to emit, paired with the `res://…` path Godot reports for its source. */
internal data class IosScriptInput(
    val model: ScriptModel,
    val resourcePath: String,
) {
    val packageName: String? get() = model.fqName.substringBeforeLast('.', "").ifEmpty { null }
    val className: String get() = model.simpleName
}

// ---------- thin per-script models (mirror the old build.gradle.kts data classes) ----------

internal enum class IosScriptBridgeKind {
    ZERO_ARG,
    DOUBLE_ARG,
    OBJECT_ARG,
    OBJECT_OBJECT_LONG_ARG,
    VECTOR2I_ARG,
    LONG_ARG,
    UNSUPPORTED,
}

internal data class IosMethod(
    val godotName: String,
    val kotlinName: String,
    val argumentCount: Int,
    val bridgeKind: IosScriptBridgeKind,
    val objectArgType: String = "GodotObject",
)

internal data class IosProperty(
    val godotName: String,
    val kotlinName: String,
    val isObjectType: Boolean,
    val godotClassName: String,
    val isList: Boolean,
    val listElementClassName: String,
    val isNullable: Boolean,
)

internal data class IosSignal(
    val godotName: String,
    val kotlinName: String,
)

internal data class IosScript(
    val resourcePath: String,
    val packageName: String?,
    val className: String,
    val baseType: String,
    val methods: List<IosMethod>,
    val properties: List<IosProperty>,
    val signals: List<IosSignal>,
)

internal class IosScriptCodeEmitter(
    inputs: List<IosScriptInput>,
    private val warn: (String) -> Unit = {},
) {
    // Sort by resourcePath to match the old task's `.sortedBy { it.resourcePath }`.
    private val scripts: List<IosScript> =
        inputs.sortedBy { it.resourcePath }.map { it.toIosScript() }

    /** The combined registry file: `registerKanamaIosProjectScripts()` + bridge classes. */
    fun registrySource(): String {
        val imports = scripts
            .mapNotNull { script -> script.packageName?.let { "$it.${script.className}" } }
            .distinct()
            .sorted()
        val builder = StringBuilder()
        builder.appendLine("package net.multigesture.kanama.ios")
        builder.appendLine()
        builder.appendLine("import java.lang.foreign.MemorySegment")
        imports.forEach { builder.appendLine("import $it") }
        builder.appendLine()
        builder.appendLine("@Suppress(\"unused\")")
        builder.appendLine("internal fun registerKanamaIosProjectScripts() {")
        builder.appendLine("    if (KanamaIosGeneratedProjectScripts.registered) return")
        builder.appendLine("    KanamaIosGeneratedProjectScripts.registered = true")
        scripts.forEach { script ->
            val bridgeName = "${script.className}IosBridge_${shortHash(script.resourcePath)}"
            builder.appendLine("    KanamaIosProjectRegistry.register(")
            builder.appendLine("        KanamaIosScriptDescriptor(")
            builder.appendLine("            path = ${kotlinString(script.resourcePath)},")
            builder.appendLine("            baseType = ${kotlinString(script.baseType)},")
            builder.appendLine("            methods = listOf(")
            script.methods.forEach { method ->
                builder.appendLine(
                    "                KanamaIosScriptMethod(${kotlinString(method.godotName)}, ${method.argumentCount}),",
                )
            }
            builder.appendLine("            ),")
            builder.appendLine("            properties = listOf(")
            script.properties.forEach { property ->
                builder.appendLine(
                    "                KanamaIosScriptProperty(${kotlinString(property.godotName)}),",
                )
            }
            builder.appendLine("            ),")
            builder.appendLine("            signals = listOf(")
            script.signals.forEach { signal ->
                builder.appendLine(
                    "                KanamaIosScriptSignal(${kotlinString(signal.godotName)}),",
                )
            }
            builder.appendLine("            ),")
            builder.appendLine("            factory = { ownerObject ->")
            builder.appendLine(
                "                $bridgeName(${script.className}(MemorySegment.ofAddress(ownerObject)))",
            )
            builder.appendLine("            },")
            builder.appendLine("        ),")
            builder.appendLine("    )")
        }
        builder.appendLine("}")
        builder.appendLine()
        builder.appendLine("private object KanamaIosGeneratedProjectScripts {")
        builder.appendLine("    var registered: Boolean = false")
        builder.appendLine("}")
        scripts.forEach { script ->
            val bridgeName = "${script.className}IosBridge_${shortHash(script.resourcePath)}"
            builder.appendLine()
            builder.appendLine("private class $bridgeName(")
            builder.appendLine("    private val script: ${script.className},")
            builder.appendLine(") : KanamaIosScriptBridge {")
            builder.appendLine("    override val scriptInstance: Any get() = script")
            builder.appendLine()
            builder.appendLine("    override fun call(methodName: String, firstArg: Double): Boolean = when (methodName) {")
            script.methods.forEach { method ->
                val invocation = when (method.bridgeKind) {
                    IosScriptBridgeKind.ZERO_ARG -> "script.${method.kotlinName}()"
                    IosScriptBridgeKind.DOUBLE_ARG -> "script.${method.kotlinName}(firstArg)"
                    IosScriptBridgeKind.OBJECT_ARG -> null
                    IosScriptBridgeKind.OBJECT_OBJECT_LONG_ARG -> null
                    IosScriptBridgeKind.VECTOR2I_ARG -> null
                    IosScriptBridgeKind.LONG_ARG -> null
                    IosScriptBridgeKind.UNSUPPORTED -> {
                        warn("[kanama-ios] ${script.className}.${method.kotlinName} (godot: ${method.godotName}) has ${method.argumentCount} args — no iOS bridge kind, will not be dispatched")
                        null
                    }
                }
                if (invocation != null) {
                    builder.appendLine("        ${kotlinString(method.godotName)} -> { $invocation; true }")
                }
            }
            builder.appendLine("        else -> false")
            builder.appendLine("    }")
            builder.appendLine()
            builder.appendLine("    override fun callObject(methodName: String, objectArg: Long): Boolean = when (methodName) {")
            script.methods.forEach { method ->
                if (method.bridgeKind == IosScriptBridgeKind.OBJECT_ARG) {
                    val argExpr = if (method.objectArgType == "GodotObject")
                        "net.multigesture.kanama.api.GodotObject(MemorySegment.ofAddress(objectArg))"
                    else
                        "net.multigesture.kanama.api.${method.objectArgType}(MemorySegment.ofAddress(objectArg))"
                    builder.appendLine(
                        "        ${kotlinString(method.godotName)} -> { script.${method.kotlinName}($argExpr); true }",
                    )
                }
            }
            builder.appendLine("        else -> false")
            builder.appendLine("    }")
            builder.appendLine()
            builder.appendLine("    override fun callArgs(methodName: String, arg1: Long, arg2: Long, arg3: Long): Boolean = when (methodName) {")
            script.methods.forEach { method ->
                if (method.bridgeKind == IosScriptBridgeKind.OBJECT_OBJECT_LONG_ARG) {
                    builder.appendLine(
                        "        ${kotlinString(method.godotName)} -> { script.${method.kotlinName}(net.multigesture.kanama.api.GodotObject(MemorySegment.ofAddress(arg1)), net.multigesture.kanama.api.GodotObject(MemorySegment.ofAddress(arg2)), arg3); true }",
                    )
                }
            }
            builder.appendLine("        else -> false")
            builder.appendLine("    }")
            builder.appendLine()
            builder.appendLine("    override fun callVector2i(methodName: String, x: Long, y: Long): Boolean = when (methodName) {")
            script.methods.forEach { method ->
                if (method.bridgeKind == IosScriptBridgeKind.VECTOR2I_ARG) {
                    builder.appendLine(
                        "        ${kotlinString(method.godotName)} -> { script.${method.kotlinName}(net.multigesture.kanama.types.Vector2i(x.toInt(), y.toInt())); true }",
                    )
                }
            }
            builder.appendLine("        else -> false")
            builder.appendLine("    }")
            builder.appendLine()
            builder.appendLine("    override fun callLong(methodName: String, value: Long): Boolean = when (methodName) {")
            script.methods.forEach { method ->
                if (method.bridgeKind == IosScriptBridgeKind.LONG_ARG) {
                    val arg = if (method.objectArgType == "Int") "value.toInt()" else "value"
                    builder.appendLine("        ${kotlinString(method.godotName)} -> { script.${method.kotlinName}($arg); true }")
                }
            }
            builder.appendLine("        else -> false")
            builder.appendLine("    }")
            builder.appendLine()
            builder.appendLine("    override fun setProperty(propertyIndex: Int, value: Long): Boolean = when (propertyIndex) {")
            script.properties.forEachIndexed { index, property ->
                if (property.isObjectType && property.godotClassName.isNotEmpty()) {
                    if (property.isNullable) {
                        builder.appendLine("        $index -> { script.${property.kotlinName} = if (value != 0L) net.multigesture.kanama.api.${property.godotClassName}(java.lang.foreign.MemorySegment.ofAddress(value)) else null; true }")
                    } else {
                        builder.appendLine("        $index -> { script.${property.kotlinName} = net.multigesture.kanama.api.${property.godotClassName}(java.lang.foreign.MemorySegment.ofAddress(value)); true }")
                    }
                } else if (!property.isObjectType && !property.isList && property.godotClassName.isNotEmpty() && property.godotClassName != "String") {
                    val rhs = when (property.godotClassName) {
                        "Double", "Float" -> "Double.fromBits(value)"
                        "Boolean" -> "value != 0L"
                        "Int" -> "value.toInt()"
                        else -> "value"
                    }
                    builder.appendLine("        $index -> { script.${property.kotlinName} = $rhs; true }")
                }
            }
            builder.appendLine("        else -> false")
            builder.appendLine("    }")
            val stringProperties = script.properties.filter { !it.isObjectType && !it.isList && it.godotClassName == "String" }
            if (stringProperties.isNotEmpty()) {
                builder.appendLine()
                builder.appendLine("    override fun setPropertyString(propertyIndex: Int, value: String): Boolean = when (propertyIndex) {")
                stringProperties.forEach { property ->
                    val index = script.properties.indexOf(property)
                    builder.appendLine("        $index -> { script.${property.kotlinName} = value; true }")
                }
                builder.appendLine("        else -> false")
                builder.appendLine("    }")
            }
            val listProperties = script.properties.filter { it.isList && it.listElementClassName.isNotEmpty() }
            if (listProperties.isNotEmpty()) {
                builder.appendLine()
                builder.appendLine("    override fun setPropertyObjectArray(propertyIndex: Int, values: LongArray): Boolean = when (propertyIndex) {")
                script.properties.forEachIndexed { index, property ->
                    if (property.isList && property.listElementClassName.isNotEmpty()) {
                        builder.appendLine("        $index -> { script.${property.kotlinName} = values.map { net.multigesture.kanama.api.${property.listElementClassName}(java.lang.foreign.MemorySegment.ofAddress(it)) }; true }")
                    }
                }
                builder.appendLine("        else -> false")
                builder.appendLine("    }")
            }
            builder.appendLine("}")
        }
        return builder.toString()
    }

    /** `<Class>Signals` / `<Class>Methods` / `<Class>Names` helper objects. */
    fun constantsSource(): String {
        val builder = StringBuilder()
        builder.appendLine("package net.multigesture.kanama.generated")
        builder.appendLine()
        builder.appendLine("import net.multigesture.kanama.api.kotlinScriptInstance")
        builder.appendLine()
        builder.appendLine("@Suppress(\"unused\")")
        builder.appendLine("private fun emitIosSignal(instance: Any, signalName: String, args: Array<out Any?>) {")
        builder.appendLine("    val script = instance as? net.multigesture.kanama.api.KanamaScript<*> ?: return")
        builder.appendLine("    net.multigesture.kanama.api.GodotObject(script.godotObject).emitSignal(signalName, *args)")
        builder.appendLine("}")
        scripts.forEach { script ->
            if (script.signals.isNotEmpty()) {
                builder.appendLine()
                builder.appendLine("object ${script.className}Signals {")
                script.signals.forEach { signal ->
                    val functionName = constantIdentifier(signal.kotlinName)
                    val signalLiteral = kotlinString(signal.godotName)
                    val fqClassName = "${script.packageName}.${script.className}"
                    builder.appendLine("    fun $functionName(instance: $fqClassName, vararg args: Any?) {")
                    builder.appendLine("        emitIosSignal(instance, $signalLiteral, args)")
                    builder.appendLine("    }")
                }
                builder.appendLine("}")
            }
            val helperMethods = script.methods
                .filter { it.argumentCount == 0 && !it.godotName.startsWith("_") }
            if (helperMethods.isNotEmpty()) {
                val fqClassName = "${script.packageName}.${script.className}"
                builder.appendLine()
                builder.appendLine("object ${script.className}Methods {")
                helperMethods.forEach { method ->
                    val functionName = constantIdentifier(method.kotlinName)
                    builder.appendLine("    fun $functionName(instance: $fqClassName) {")
                    builder.appendLine("        instance.${method.kotlinName}()")
                    builder.appendLine("    }")
                    builder.appendLine()
                    builder.appendLine("    fun $functionName(target: net.multigesture.kanama.api.GodotObject): Boolean {")
                    builder.appendLine("        val instance = target.kotlinScriptInstance<$fqClassName>() ?: return false")
                    builder.appendLine("        $functionName(instance)")
                    builder.appendLine("        return true")
                    builder.appendLine("    }")
                }
                builder.appendLine("}")
            }
            val methods = script.methods
            val properties = script.properties
            val signals = script.signals
            if (methods.isNotEmpty() || properties.isNotEmpty() || signals.isNotEmpty()) {
                builder.appendLine()
                builder.appendLine("object ${script.className}Names {")
                if (methods.isNotEmpty()) {
                    builder.appendLine("    object Methods {")
                    methods.forEach { method ->
                        builder.appendLine(
                            "        const val ${constantIdentifier(method.kotlinName)}: String = ${kotlinString(method.godotName)}",
                        )
                    }
                    builder.appendLine("    }")
                }
                if (properties.isNotEmpty()) {
                    builder.appendLine("    object Properties {")
                    properties.forEach { property ->
                        builder.appendLine(
                            "        const val ${constantIdentifier(property.kotlinName)}: String = ${kotlinString(property.godotName)}",
                        )
                    }
                    builder.appendLine("    }")
                }
                if (signals.isNotEmpty()) {
                    builder.appendLine("    object Signals {")
                    signals.forEach { signal ->
                        builder.appendLine(
                            "        const val ${constantIdentifier(signal.kotlinName)}: String = ${kotlinString(signal.godotName)}",
                        )
                    }
                    builder.appendLine("    }")
                }
                builder.appendLine("}")
            }
        }
        return builder.toString()
    }

    /** Per-package `removeIf` / `System` JVM-shim compatibility sources (relativePath -> source). */
    fun compatibilitySources(): Map<String, String> =
        scripts
            .mapNotNull { it.packageName }
            .distinct()
            .sorted()
            .associate { packageName ->
                val relativePath = "${packageName.replace('.', '/')}/KanamaIosCompatibility.generated.kt"
                val source = buildString {
                    appendLine("package $packageName")
                    appendLine()
                    appendLine("@Suppress(\"unused\")")
                    appendLine("internal fun <T> MutableCollection<T>.removeIf(predicate: (T) -> Boolean): Boolean {")
                    appendLine("    val originalSize = size")
                    appendLine("    removeAll(predicate)")
                    appendLine("    return size != originalSize")
                    appendLine("}")
                    appendLine()
                    appendLine("@Suppress(\"unused\")")
                    appendLine("internal object System {")
                    appendLine("    fun getenv(name: String): String? = null")
                    appendLine("}")
                }
                relativePath to source
            }

    // ---------- rich ScriptModel -> thin iOS model ----------

    private fun IosScriptInput.toIosScript(): IosScript {
        val methods = (model.virtuals.mapNotNull { it.toIosMethod() } + model.methods.map { it.toIosMethod() })
            .distinctBy { it.godotName }
        val properties = model.properties.map { it.toIosProperty(className) }
            .distinctBy { it.godotName }
        val signals = model.signals.map { IosSignal(it.godotName, it.godotName) }
            .distinctBy { it.godotName }
        return IosScript(
            resourcePath = resourcePath,
            packageName = packageName,
            className = className,
            baseType = model.attachTo,
            methods = methods,
            properties = properties,
            signals = signals,
        )
    }

    // Only the lifecycle virtuals the old regex path wired become dispatchable iOS methods.
    // The rest (enter_tree, unhandled_input, shortcut_input, unhandled_key_input) were
    // IOS_UNWIRED_FUNCTION_ANNOTATIONS — a silent no-op that we still warn about.
    private fun VirtualModel.toIosMethod(): IosMethod? = when (virtualName) {
        "_ready", "_exit_tree" ->
            IosMethod(virtualName, kotlinMethodName, 0, IosScriptBridgeKind.ZERO_ARG)
        "_process", "_physics_process" ->
            IosMethod(virtualName, kotlinMethodName, 1, IosScriptBridgeKind.DOUBLE_ARG)
        "_input" ->
            IosMethod(virtualName, kotlinMethodName, 1, IosScriptBridgeKind.OBJECT_ARG, objectArgType(args))
        else -> {
            warn("[kanama-ios] $kotlinMethodName ($virtualName): not wired on iOS (silent no-op)")
            null
        }
    }

    private fun MethodModel.toIosMethod(): IosMethod {
        val kind = bridgeKindFor(godotName, args)
        return IosMethod(
            godotName = godotName,
            kotlinName = kotlinName,
            argumentCount = args.size,
            bridgeKind = kind,
            objectArgType =
                if (kind == IosScriptBridgeKind.OBJECT_ARG || kind == IosScriptBridgeKind.LONG_ARG)
                    objectArgType(args)
                else "GodotObject",
        )
    }

    private fun bridgeKindFor(godotName: String, args: List<ArgModel>): IosScriptBridgeKind {
        if (args.isEmpty()) return IosScriptBridgeKind.ZERO_ARG
        if (args.size == 1) {
            val a = args[0]
            return when {
                a.objectWrapperFqName != null -> IosScriptBridgeKind.OBJECT_ARG
                a.type == TypeMapping.VECTOR2I -> IosScriptBridgeKind.VECTOR2I_ARG
                a.type == TypeMapping.FLOAT -> IosScriptBridgeKind.DOUBLE_ARG
                a.type == TypeMapping.INT -> IosScriptBridgeKind.LONG_ARG
                // Any other value type (String/NodePath/Vector/Color/…) has no typed bridge.
                else -> IosScriptBridgeKind.UNSUPPORTED
            }
        }
        if (args.size == 3 && godotName == "_input_event") return IosScriptBridgeKind.OBJECT_OBJECT_LONG_ARG
        return IosScriptBridgeKind.UNSUPPORTED
    }

    // The simple Kotlin type name of a single-arg method, mirroring objectArgTypeFor.
    private fun objectArgType(args: List<ArgModel>): String {
        if (args.size != 1) return "GodotObject"
        val a = args[0]
        a.objectWrapperFqName?.let { return it.substringAfterLast('.') }
        return when (a.type) {
            TypeMapping.INT -> "Long"
            TypeMapping.FLOAT -> "Double"
            TypeMapping.BOOL -> "Boolean"
            TypeMapping.STRING -> "String"
            else -> a.type.kotlinType.substringAfterLast('.')
        }
    }

    private fun ScriptPropertyModel.toIosProperty(className: String): IosProperty {
        val isList = type == TypeMapping.ARRAY
        val isObject = objectWrapperFqName != null
        val listElementClassName = arrayElementWrapperFqName?.substringAfterLast('.') ?: ""
        val godotClassName = when {
            isObject -> objectWrapperFqName!!.substringAfterLast('.')
            isList -> ""
            else -> when (type) {
                TypeMapping.INT -> "Long"
                TypeMapping.FLOAT -> "Double"
                TypeMapping.BOOL -> "Boolean"
                TypeMapping.STRING -> "String"
                // Value types (NodePath/Vector*/Color/…) have no iOS @ScriptProperty path
                // yet: emit no setProperty case, keep the Kotlin default. (2.6 extends this.)
                else -> {
                    warn("[kanama-ios] $className.$kotlinName ($type) — no iOS @ScriptProperty path for this value type, will keep its Kotlin default")
                    ""
                }
            }
        }
        return IosProperty(
            godotName = godotName,
            kotlinName = kotlinName,
            isObjectType = isObject,
            godotClassName = godotClassName,
            isList = isList,
            listElementClassName = listElementClassName,
            isNullable = nullable,
        )
    }

    // ---------- string helpers (reproduce the build.gradle.kts versions exactly) ----------

    private fun shortHash(value: String): String =
        MessageDigest.getInstance("SHA-256")
            .digest(value.toByteArray(Charsets.UTF_8))
            .take(8)
            .joinToString("") { "%02x".format(it) }

    private fun kotlinString(value: String): String =
        buildString {
            append('"')
            value.forEach { ch ->
                when (ch) {
                    '\\' -> append("\\\\")
                    '"' -> append("\\\"")
                    '\n' -> append("\\n")
                    '\r' -> append("\\r")
                    '\t' -> append("\\t")
                    else -> append(ch)
                }
            }
            append('"')
        }

    private fun constantIdentifier(name: String): String {
        val stripped = name.trim('_')
        if (stripped.isBlank()) return "value"
        val words = stripped
            .split('_', '-', ' ')
            .filter { it.isNotBlank() }
        val candidate = words.drop(1).fold(words.first()) { acc, part ->
            acc + part.replaceFirstChar { it.uppercaseChar() }
        }
        return candidate.replace(Regex("""[^A-Za-z0-9_]"""), "_")
            .let { if (it.firstOrNull()?.isDigit() == true) "_$it" else it }
    }
}
