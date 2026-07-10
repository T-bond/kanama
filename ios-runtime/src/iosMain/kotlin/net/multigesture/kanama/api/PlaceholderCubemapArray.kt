package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: PlaceholderCubemapArray
 */
class PlaceholderCubemapArray(handle: MemorySegment) : PlaceholderTextureLayered(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): PlaceholderCubemapArray? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): PlaceholderCubemapArray? =
            if (handle.address() == 0L) null else PlaceholderCubemapArray(handle)

        // No MethodBinds emitted yet.
    }
}
