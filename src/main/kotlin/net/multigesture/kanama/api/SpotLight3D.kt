package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls

/**
 * A spotlight, such as a reflector spotlight or a lantern.
 *
 * Generated from Godot docs: SpotLight3D
 */
class SpotLight3D(handle: MemorySegment) : Light3D(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): SpotLight3D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): SpotLight3D? =
            if (handle.address() == 0L) null else SpotLight3D(handle)

        // No MethodBinds emitted yet.
    }
}
