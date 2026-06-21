package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: PanelContainer
 */
open class PanelContainer(handle: MemorySegment) : Container(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): PanelContainer? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): PanelContainer? =
            if (handle.address() == 0L) null else PanelContainer(handle)

        // No MethodBinds emitted yet.
    }
}
