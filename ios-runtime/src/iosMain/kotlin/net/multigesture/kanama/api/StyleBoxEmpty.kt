package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: StyleBoxEmpty
 */
class StyleBoxEmpty(handle: MemorySegment) : StyleBox(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): StyleBoxEmpty? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): StyleBoxEmpty? =
            if (handle.address() == 0L) null else StyleBoxEmpty(handle)

        // No MethodBinds emitted yet.
    }
}
