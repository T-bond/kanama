package net.multigesture.kanama.processor

// The platform-neutral script model: the annotation-derived description of a @ScriptClass
// (and @RegisterClass) — its properties, methods, virtuals, signals — independent of how
// any one platform marshals or emits it. The KanamaProcessor builds these from the KSP
// symbol API; the JVM CodeEmitter/ScriptCodeEmitter consume them to generate registrars.
//
// Phase 3.1 (script-model-unification-design.md) turns this into the single source of
// truth for desktop/Android/iOS: it will be serialized (JSON) and consumed by the iOS
// build instead of the parseIosScript regex parser.
//
// NOTE (Phase 3.1 sub-step 1b, not yet done): ArgModel.readFromScratch/readPtrcallArg
// below still emit JVM (MemorySegment/ptrcall) codegen as strings — they are the one
// platform-specific bleed left in the model. They move to the JVM emitter side as the
// model is fully neutralized for serialization; kept here now so this extraction stays a
// byte-identical relocation.

internal data class ClassModel(
    val simpleName: String,
    val fqName: String,
    val parentClassName: String,
    val isTool: Boolean,
    val methods: List<MethodModel>,
    val properties: List<PropertyModel>,
    val virtuals: List<VirtualModel>,
    val signals: List<SignalModel>,
)

internal data class SignalModel(
    val godotName: String,
    val args: List<ArgModel>,
)

internal enum class MethodKind { REGULAR, PROPERTY_GETTER, PROPERTY_SETTER }

internal data class MethodModel(
    val kotlinName: String,
    val godotName: String,
    val returnType: TypeMapping?,
    val args: List<ArgModel>,
    val kind: MethodKind,
    val rpc: RpcModel? = null,
    /** For property accessors: the property's Kotlin name. */
    val propertyKotlinName: String? = null,
)

internal data class RpcModel(
    val mode: Int,
    val callLocal: Boolean,
    val transferMode: Int,
    val channel: Int,
)

internal data class ArgModel(
    val name: String,
    val type: TypeMapping,
    val objectWrapperFqName: String? = null,
    val nullable: Boolean = false,
    val hasDefault: Boolean = false,
) {
    val kotlinType: String
        get() = (objectWrapperFqName ?: type.kotlinType) + if (nullable) "?" else ""

    fun readFromScratch(s: String): String =
        if (objectWrapperFqName != null) {
            if (objectWrapperFqName in RESOURCE_WRAPPERS_WITH_FROM_HANDLE) {
                val value = "$objectWrapperFqName.fromHandle(${s}.get(ADDRESS, 0))"
                if (nullable) value else "$value ?: error(\"Expected $objectWrapperFqName argument '$name'\")"
            } else {
                val handle = "${s}.get(ADDRESS, 0)"
                if (nullable) "if ($handle.address() == 0L) null else $objectWrapperFqName($handle)" else "$objectWrapperFqName($handle)"
            }
        } else {
            type.readFromScratch(s)
        }

    fun readPtrcallArg(ptr: String): String =
        if (objectWrapperFqName != null) {
            if (objectWrapperFqName in RESOURCE_WRAPPERS_WITH_FROM_HANDLE) {
                val value = "$objectWrapperFqName.fromHandle($ptr.reinterpret(${type.ptrcallSizeBytesExpr}).get(ADDRESS, 0))"
                if (nullable) value else "$value ?: error(\"Expected $objectWrapperFqName argument '$name'\")"
            } else {
                val handle = "$ptr.reinterpret(${type.ptrcallSizeBytesExpr}).get(ADDRESS, 0)"
                if (nullable) "if ($handle.address() == 0L) null else $objectWrapperFqName($handle)" else "$objectWrapperFqName($handle)"
            }
        } else {
            type.readPtrcallArg(ptr)
        }

    fun signalEmitValueExpr(): String =
        if (type == TypeMapping.NODE_PATH) "$name.path" else name
}

internal data class PropertyModel(
    val kotlinName: String,
    val godotName: String,
    val type: TypeMapping,
    val isMutable: Boolean,
    val hint: Int = 0,
    val hintString: String = "",
    val usage: Int = 6,
)

internal data class VirtualModel(
    val virtualName: String,
    /** Name of the generated static upcall function (e.g. `callReady`). */
    val callFunctionName: String,
    /** Kotlin method to invoke on the user instance. */
    val kotlinMethodName: String,
    /** Ptrcall-convention args passed by Godot when invoking the virtual. */
    val args: List<ArgModel> = emptyList(),
)

// ---------- @ScriptClass models ----------

internal data class ScriptModel(
    val simpleName: String,
    val fqName: String,
    val attachTo: String,
    val isTool: Boolean,
    val isGlobalClass: Boolean,
    val properties: List<ScriptPropertyModel>,
    val toolButtons: List<ToolButtonModel>,
    val virtuals: List<VirtualModel>,
    val methods: List<MethodModel>,
    val signals: List<SignalModel>,
)

internal data class ToolButtonModel(
    val propertyName: String,
    val text: String,
    val icon: String,
    val method: MethodModel,
) {
    val hintString: String
        get() = if (icon.isEmpty()) text else "$text,$icon"
}

internal data class ScriptPropertyModel(
    val kotlinName: String,
    val godotName: String,
    val type: TypeMapping,
    val isMutable: Boolean,
    val hint: Int = 0,
    val hintString: String = "",
    val defaultLiteral: String? = null,
    val exportCategory: ScriptPropertyGroupModel? = null,
    val exportGroup: ScriptPropertyGroupModel? = null,
    val exportSubgroup: ScriptPropertyGroupModel? = null,
    val usage: Int = 6,
    val objectWrapperFqName: String? = null,
    val arrayElementWrapperFqName: String? = null,
    val customScriptFqName: String? = null,
    val arrayElementCustomScriptFqName: String? = null,
    val customScriptIsResource: Boolean = false,
    val arrayElementCustomScriptIsResource: Boolean = false,
    val arrayElementString: Boolean = false,
)

internal data class ScriptPropertyGroupModel(
    val name: String,
    val prefix: String,
    val usage: Int,
)

internal data class ScriptPropertyTypeModel(
    val type: TypeMapping,
    val hint: Int = 0,
    val hintString: String = "",
    val objectWrapperFqName: String? = null,
    val arrayElementWrapperFqName: String? = null,
    val customScriptFqName: String? = null,
    val arrayElementCustomScriptFqName: String? = null,
    val customScriptIsResource: Boolean = false,
    val arrayElementCustomScriptIsResource: Boolean = false,
    val arrayElementString: Boolean = false,
)

internal data class ScriptClassTypeInfo(
    val fqName: String,
    val simpleName: String,
    val attachTo: String,
    val isGlobalClass: Boolean,
) {
    val isExportableResource: Boolean
        get() = isGlobalClass && attachTo == "Resource"
    val isExportableGlobal: Boolean
        get() = isGlobalClass
    val propertyHint: Int
        get() = if (isExportableResource) 17 else 34
}
