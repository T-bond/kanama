package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VFlowContainer
 */
class VFlowContainer(handle: MemorySegment) : FlowContainer(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VFlowContainer? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VFlowContainer? =
            if (handle.address() == 0L) null else VFlowContainer(handle)

        // No MethodBinds emitted yet.
    }
}
