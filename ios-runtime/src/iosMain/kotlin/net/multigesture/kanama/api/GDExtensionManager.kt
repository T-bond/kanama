package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: GDExtensionManager
 */
object GDExtensionManager {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("GDExtensionManager")
    }

    const val LOAD_STATUS_OK: Long = 0L
    const val LOAD_STATUS_FAILED: Long = 1L
    const val LOAD_STATUS_ALREADY_LOADED: Long = 2L
    const val LOAD_STATUS_NOT_LOADED: Long = 3L
    const val LOAD_STATUS_NEEDS_RESTART: Long = 4L

    fun loadExtension(path: String): Long {
        return ObjectCalls.ptrcallWithStringArgRetLong(loadExtensionBind, singleton, path)
    }

    fun reloadExtension(path: String): Long {
        return ObjectCalls.ptrcallWithStringArgRetLong(reloadExtensionBind, singleton, path)
    }

    fun unloadExtension(path: String): Long {
        return ObjectCalls.ptrcallWithStringArgRetLong(unloadExtensionBind, singleton, path)
    }

    fun isExtensionLoaded(path: String): Boolean {
        return ObjectCalls.ptrcallWithStringArgRetBool(isExtensionLoadedBind, singleton, path)
    }

    fun getLoadedExtensions(): List<String> {
        return ObjectCalls.ptrcallNoArgsRetPackedStringList(getLoadedExtensionsBind, singleton)
    }

    fun getExtension(path: String): GDExtension? {
        return GDExtension.wrap(ObjectCalls.ptrcallWithStringArgRetObject(getExtensionBind, singleton, path))
    }

    object Signals {
        const val extensionsReloaded: String = "extensions_reloaded"
        const val extensionLoaded: String = "extension_loaded"
        const val extensionUnloading: String = "extension_unloading"
    }

    fun fromHandle(handle: MemorySegment): GDExtensionManager? =
        wrap(handle)

    internal fun wrap(handle: MemorySegment): GDExtensionManager? =
        if (handle.address() == 0L) null else this

    private const val LOAD_EXTENSION_HASH = 4024158731L
    private val loadExtensionBind by lazy {
        ObjectCalls.getMethodBind("GDExtensionManager", "load_extension", LOAD_EXTENSION_HASH)
    }

    private const val RELOAD_EXTENSION_HASH = 4024158731L
    private val reloadExtensionBind by lazy {
        ObjectCalls.getMethodBind("GDExtensionManager", "reload_extension", RELOAD_EXTENSION_HASH)
    }

    private const val UNLOAD_EXTENSION_HASH = 4024158731L
    private val unloadExtensionBind by lazy {
        ObjectCalls.getMethodBind("GDExtensionManager", "unload_extension", UNLOAD_EXTENSION_HASH)
    }

    private const val IS_EXTENSION_LOADED_HASH = 3927539163L
    private val isExtensionLoadedBind by lazy {
        ObjectCalls.getMethodBind("GDExtensionManager", "is_extension_loaded", IS_EXTENSION_LOADED_HASH)
    }

    private const val GET_LOADED_EXTENSIONS_HASH = 1139954409L
    private val getLoadedExtensionsBind by lazy {
        ObjectCalls.getMethodBind("GDExtensionManager", "get_loaded_extensions", GET_LOADED_EXTENSIONS_HASH)
    }

    private const val GET_EXTENSION_HASH = 49743343L
    private val getExtensionBind by lazy {
        ObjectCalls.getMethodBind("GDExtensionManager", "get_extension", GET_EXTENSION_HASH)
    }
}
