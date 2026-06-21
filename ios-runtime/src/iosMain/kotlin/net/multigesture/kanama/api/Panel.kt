package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: Panel
 */
class Panel(handle: MemorySegment) : Control(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): Panel? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): Panel? =
            if (handle.address() == 0L) null else Panel(handle)

        // No MethodBinds emitted yet.
    }
}
