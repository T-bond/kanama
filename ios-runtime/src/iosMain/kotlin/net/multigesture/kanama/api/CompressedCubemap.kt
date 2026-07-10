package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: CompressedCubemap
 */
class CompressedCubemap(handle: MemorySegment) : CompressedTextureLayered(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): CompressedCubemap? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): CompressedCubemap? =
            if (handle.address() == 0L) null else CompressedCubemap(handle)

        // No MethodBinds emitted yet.
    }
}
