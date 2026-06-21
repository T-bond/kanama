package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: CheckBox
 */
class CheckBox(handle: MemorySegment) : Button(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): CheckBox? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): CheckBox? =
            if (handle.address() == 0L) null else CheckBox(handle)

        // No MethodBinds emitted yet.
    }
}
