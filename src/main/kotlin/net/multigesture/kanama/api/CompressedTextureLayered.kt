package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Base class for texture arrays that can optionally be compressed.
 *
 * Generated from Godot docs: CompressedTextureLayered
 */
open class CompressedTextureLayered(handle: MemorySegment) : TextureLayered(handle) {
    val loadPath: String
        @JvmName("loadPathProperty")
        get() = getLoadPath()

    /**
     * The path the texture should be loaded from.
     *
     * Generated from Godot docs: CompressedTextureLayered.load
     */
    fun load(path: String): Long {
        return ObjectCalls.ptrcallWithStringArgRetLong(loadBind, handle, path)
    }

    /**
     * The path the texture should be loaded from.
     *
     * Generated from Godot docs: CompressedTextureLayered.get_load_path
     */
    fun getLoadPath(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getLoadPathBind, handle)
    }

    companion object {
        private const val LOAD_HASH = 166001499L
        private val loadBind by lazy {
            ObjectCalls.getMethodBind("CompressedTextureLayered", "load", LOAD_HASH)
        }

        private const val GET_LOAD_PATH_HASH = 201670096L
        private val getLoadPathBind by lazy {
            ObjectCalls.getMethodBind("CompressedTextureLayered", "get_load_path", GET_LOAD_PATH_HASH)
        }
    }
}
