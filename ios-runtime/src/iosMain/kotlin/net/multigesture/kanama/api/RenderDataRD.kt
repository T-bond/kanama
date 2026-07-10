package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: RenderDataRD
 */
class RenderDataRD(handle: MemorySegment) : RenderData(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): RenderDataRD? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): RenderDataRD? =
            if (handle.address() == 0L) null else RenderDataRD(handle)

        // No MethodBinds emitted yet.
    }
}
