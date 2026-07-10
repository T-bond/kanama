package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: PlaceholderTexture2DArray
 */
class PlaceholderTexture2DArray(handle: MemorySegment) : PlaceholderTextureLayered(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): PlaceholderTexture2DArray? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): PlaceholderTexture2DArray? =
            if (handle.address() == 0L) null else PlaceholderTexture2DArray(handle)

        // No MethodBinds emitted yet.
    }
}
