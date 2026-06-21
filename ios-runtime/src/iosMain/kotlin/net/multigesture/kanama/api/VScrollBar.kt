package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VScrollBar
 */
class VScrollBar(handle: MemorySegment) : ScrollBar(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VScrollBar? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VScrollBar? =
            if (handle.address() == 0L) null else VScrollBar(handle)

        // No MethodBinds emitted yet.
    }
}
