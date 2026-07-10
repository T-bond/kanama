package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VSplitContainer
 */
class VSplitContainer(handle: MemorySegment) : SplitContainer(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VSplitContainer? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VSplitContainer? =
            if (handle.address() == 0L) null else VSplitContainer(handle)

        // No MethodBinds emitted yet.
    }
}
