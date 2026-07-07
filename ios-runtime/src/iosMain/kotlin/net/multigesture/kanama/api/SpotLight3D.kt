package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: SpotLight3D
 */
class SpotLight3D(handle: MemorySegment) : Light3D(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): SpotLight3D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): SpotLight3D? =
            if (handle.address() == 0L) null else SpotLight3D(handle)

        // No MethodBinds emitted yet.
    }
}
