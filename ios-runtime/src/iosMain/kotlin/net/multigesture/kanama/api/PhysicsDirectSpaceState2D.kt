package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: PhysicsDirectSpaceState2D
 */
open class PhysicsDirectSpaceState2D(handle: MemorySegment) : GodotObject(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): PhysicsDirectSpaceState2D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): PhysicsDirectSpaceState2D? =
            if (handle.address() == 0L) null else PhysicsDirectSpaceState2D(handle)

        // No MethodBinds emitted yet.
    }
}
