package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: PhysicsDirectBodyState3DExtension
 */
class PhysicsDirectBodyState3DExtension(handle: MemorySegment) : PhysicsDirectBodyState3D(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): PhysicsDirectBodyState3DExtension? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): PhysicsDirectBodyState3DExtension? =
            if (handle.address() == 0L) null else PhysicsDirectBodyState3DExtension(handle)

        // No MethodBinds emitted yet.
    }
}
