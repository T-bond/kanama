package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: QuadMesh
 */
class QuadMesh(handle: MemorySegment) : PlaneMesh(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): QuadMesh? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): QuadMesh? =
            if (handle.address() == 0L) null else QuadMesh(handle)

        // No MethodBinds emitted yet.
    }
}
