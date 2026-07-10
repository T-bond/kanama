package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: ORMMaterial3D
 */
class ORMMaterial3D(handle: MemorySegment) : BaseMaterial3D(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): ORMMaterial3D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): ORMMaterial3D? =
            if (handle.address() == 0L) null else ORMMaterial3D(handle)

        // No MethodBinds emitted yet.
    }
}
