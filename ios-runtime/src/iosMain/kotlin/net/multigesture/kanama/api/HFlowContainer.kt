package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: HFlowContainer
 */
class HFlowContainer(handle: MemorySegment) : FlowContainer(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): HFlowContainer? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): HFlowContainer? =
            if (handle.address() == 0L) null else HFlowContainer(handle)

        // No MethodBinds emitted yet.
    }
}
