package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VSeparator
 */
class VSeparator(handle: MemorySegment) : Separator(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VSeparator? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VSeparator? =
            if (handle.address() == 0L) null else VSeparator(handle)

        // No MethodBinds emitted yet.
    }
}
