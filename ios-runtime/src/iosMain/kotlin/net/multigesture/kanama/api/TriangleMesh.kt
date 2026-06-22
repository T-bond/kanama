package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: TriangleMesh
 */
class TriangleMesh(handle: MemorySegment) : RefCounted(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): TriangleMesh? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): TriangleMesh? =
            if (handle.address() == 0L) null else TriangleMesh(handle)

        // No MethodBinds emitted yet.
    }
}
