package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: ImageTexture3D
 */
class ImageTexture3D(handle: MemorySegment) : Texture3D(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): ImageTexture3D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): ImageTexture3D? =
            if (handle.address() == 0L) null else ImageTexture3D(handle)

        // No MethodBinds emitted yet.
    }
}
