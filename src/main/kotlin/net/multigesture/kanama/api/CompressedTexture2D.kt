package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Texture with 2 dimensions, optionally compressed.
 *
 * Generated from Godot docs: CompressedTexture2D
 */
class CompressedTexture2D(handle: MemorySegment) : Texture2D(handle) {
    val loadPath: String
        @JvmName("loadPathProperty")
        get() = getLoadPath()

    /**
     * The `CompressedTexture2D`'s file path to a `.ctex` file.
     *
     * Generated from Godot docs: CompressedTexture2D.load
     */
    fun load(path: String): Long {
        return ObjectCalls.ptrcallWithStringArgRetLong(loadBind, handle, path)
    }

    /**
     * The `CompressedTexture2D`'s file path to a `.ctex` file.
     *
     * Generated from Godot docs: CompressedTexture2D.get_load_path
     */
    fun getLoadPath(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getLoadPathBind, handle)
    }

    companion object {
        private const val LOAD_HASH = 166001499L
        private val loadBind by lazy {
            ObjectCalls.getMethodBind("CompressedTexture2D", "load", LOAD_HASH)
        }

        private const val GET_LOAD_PATH_HASH = 201670096L
        private val getLoadPathBind by lazy {
            ObjectCalls.getMethodBind("CompressedTexture2D", "get_load_path", GET_LOAD_PATH_HASH)
        }
    }
}
