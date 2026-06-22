package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: PhysicsDirectSpaceState3D
 */
open class PhysicsDirectSpaceState3D(handle: MemorySegment) : GodotObject(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): PhysicsDirectSpaceState3D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): PhysicsDirectSpaceState3D? =
            if (handle.address() == 0L) null else PhysicsDirectSpaceState3D(handle)

        // No MethodBinds emitted yet.
    }
}
