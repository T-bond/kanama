package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: JointLimitation3D
 */
open class JointLimitation3D(handle: MemorySegment) : Resource(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): JointLimitation3D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): JointLimitation3D? =
            if (handle.address() == 0L) null else JointLimitation3D(handle)

        // No MethodBinds emitted yet.
    }
}
