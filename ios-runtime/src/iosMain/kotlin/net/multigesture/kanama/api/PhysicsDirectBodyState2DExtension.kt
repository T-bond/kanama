package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: PhysicsDirectBodyState2DExtension
 */
class PhysicsDirectBodyState2DExtension(handle: MemorySegment) : PhysicsDirectBodyState2D(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): PhysicsDirectBodyState2DExtension? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): PhysicsDirectBodyState2DExtension? =
            if (handle.address() == 0L) null else PhysicsDirectBodyState2DExtension(handle)

        // No MethodBinds emitted yet.
    }
}
