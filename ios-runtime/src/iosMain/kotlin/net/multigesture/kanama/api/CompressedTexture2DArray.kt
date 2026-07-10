package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: CompressedTexture2DArray
 */
class CompressedTexture2DArray(handle: MemorySegment) : CompressedTextureLayered(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): CompressedTexture2DArray? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): CompressedTexture2DArray? =
            if (handle.address() == 0L) null else CompressedTexture2DArray(handle)

        // No MethodBinds emitted yet.
    }
}
