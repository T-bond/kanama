package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: FABRIK3D
 */
class FABRIK3D(handle: MemorySegment) : IterateIK3D(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): FABRIK3D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): FABRIK3D? =
            if (handle.address() == 0L) null else FABRIK3D(handle)

        // No MethodBinds emitted yet.
    }
}
