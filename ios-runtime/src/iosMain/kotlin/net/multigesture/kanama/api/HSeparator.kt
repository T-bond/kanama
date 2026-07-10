package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: HSeparator
 */
class HSeparator(handle: MemorySegment) : Separator(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): HSeparator? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): HSeparator? =
            if (handle.address() == 0L) null else HSeparator(handle)

        // No MethodBinds emitted yet.
    }
}
