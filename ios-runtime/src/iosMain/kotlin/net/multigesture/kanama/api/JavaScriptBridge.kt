package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: JavaScriptBridge
 */
object JavaScriptBridge {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("JavaScriptBridge")
    }

    fun getInterface(interfaceValue: String): JavaScriptObject? {
        return JavaScriptObject.wrap(ObjectCalls.ptrcallWithStringArgRetObject(getInterfaceBind, singleton, interfaceValue))
    }

    fun createCallback(callable: GodotCallable): JavaScriptObject? {
        return JavaScriptObject.wrap(ObjectCalls.ptrcallWithCallableArgRetObject(createCallbackBind, singleton, callable.target.handle, callable.method))
    }

    fun isJsBuffer(javascriptObject: JavaScriptObject?): Boolean {
        return ObjectCalls.ptrcallWithObjectArgRetBool(isJsBufferBind, singleton, javascriptObject?.requireOpenHandle() ?: MemorySegment.NULL)
    }

    fun createObject(objectValue: String, vararg extraArgs: Any?): Any? {
        return ObjectCalls.callWithVariantArgs(createObjectBind, singleton, listOf(objectValue, *extraArgs))
    }

    fun pwaNeedsUpdate(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(pwaNeedsUpdateBind, singleton)
    }

    fun pwaUpdate(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(pwaUpdateBind, singleton)
    }

    fun forceFsSync() {
        ObjectCalls.ptrcallNoArgs(forceFsSyncBind, singleton)
    }

    object Signals {
        const val pwaUpdateAvailable: String = "pwa_update_available"
    }

    fun fromHandle(handle: MemorySegment): JavaScriptBridge? =
        wrap(handle)

    internal fun wrap(handle: MemorySegment): JavaScriptBridge? =
        if (handle.address() == 0L) null else this

    private const val GET_INTERFACE_HASH = 1355533281L
    private val getInterfaceBind by lazy {
        ObjectCalls.getMethodBind("JavaScriptBridge", "get_interface", GET_INTERFACE_HASH)
    }

    private const val CREATE_CALLBACK_HASH = 422818440L
    private val createCallbackBind by lazy {
        ObjectCalls.getMethodBind("JavaScriptBridge", "create_callback", CREATE_CALLBACK_HASH)
    }

    private const val IS_JS_BUFFER_HASH = 821968997L
    private val isJsBufferBind by lazy {
        ObjectCalls.getMethodBind("JavaScriptBridge", "is_js_buffer", IS_JS_BUFFER_HASH)
    }

    private const val CREATE_OBJECT_HASH = 3093893586L
    private val createObjectBind by lazy {
        ObjectCalls.getMethodBind("JavaScriptBridge", "create_object", CREATE_OBJECT_HASH)
    }

    private const val PWA_NEEDS_UPDATE_HASH = 36873697L
    private val pwaNeedsUpdateBind by lazy {
        ObjectCalls.getMethodBind("JavaScriptBridge", "pwa_needs_update", PWA_NEEDS_UPDATE_HASH)
    }

    private const val PWA_UPDATE_HASH = 166280745L
    private val pwaUpdateBind by lazy {
        ObjectCalls.getMethodBind("JavaScriptBridge", "pwa_update", PWA_UPDATE_HASH)
    }

    private const val FORCE_FS_SYNC_HASH = 3218959716L
    private val forceFsSyncBind by lazy {
        ObjectCalls.getMethodBind("JavaScriptBridge", "force_fs_sync", FORCE_FS_SYNC_HASH)
    }
}
