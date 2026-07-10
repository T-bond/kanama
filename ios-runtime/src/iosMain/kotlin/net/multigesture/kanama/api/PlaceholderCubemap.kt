package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: PlaceholderCubemap
 */
class PlaceholderCubemap(handle: MemorySegment) : PlaceholderTextureLayered(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): PlaceholderCubemap? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): PlaceholderCubemap? =
            if (handle.address() == 0L) null else PlaceholderCubemap(handle)

        // No MethodBinds emitted yet.
    }
}
