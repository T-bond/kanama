package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: HSplitContainer
 */
class HSplitContainer(handle: MemorySegment) : SplitContainer(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): HSplitContainer? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): HSplitContainer? =
            if (handle.address() == 0L) null else HSplitContainer(handle)

        // No MethodBinds emitted yet.
    }
}
