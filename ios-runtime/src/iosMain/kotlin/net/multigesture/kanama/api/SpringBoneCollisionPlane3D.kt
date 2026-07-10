package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: SpringBoneCollisionPlane3D
 */
class SpringBoneCollisionPlane3D(handle: MemorySegment) : SpringBoneCollision3D(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): SpringBoneCollisionPlane3D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): SpringBoneCollisionPlane3D? =
            if (handle.address() == 0L) null else SpringBoneCollisionPlane3D(handle)

        // No MethodBinds emitted yet.
    }
}
