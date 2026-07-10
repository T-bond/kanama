package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: Texture2DArrayRD
 */
class Texture2DArrayRD(handle: MemorySegment) : TextureLayeredRD(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): Texture2DArrayRD? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): Texture2DArrayRD? =
            if (handle.address() == 0L) null else Texture2DArrayRD(handle)

        // No MethodBinds emitted yet.
    }
}
