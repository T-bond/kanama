package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: PointMesh
 */
class PointMesh(handle: MemorySegment) : PrimitiveMesh(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): PointMesh? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): PointMesh? =
            if (handle.address() == 0L) null else PointMesh(handle)

        // No MethodBinds emitted yet.
    }
}
