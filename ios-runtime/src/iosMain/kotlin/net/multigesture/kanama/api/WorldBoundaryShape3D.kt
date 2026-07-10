package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: WorldBoundaryShape3D
 */
class WorldBoundaryShape3D(handle: MemorySegment) : Shape3D(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): WorldBoundaryShape3D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): WorldBoundaryShape3D? =
            if (handle.address() == 0L) null else WorldBoundaryShape3D(handle)

        // No MethodBinds emitted yet.
    }
}
