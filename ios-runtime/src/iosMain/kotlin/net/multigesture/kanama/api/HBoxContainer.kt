package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: HBoxContainer
 */
open class HBoxContainer(handle: MemorySegment) : BoxContainer(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): HBoxContainer? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): HBoxContainer? =
            if (handle.address() == 0L) null else HBoxContainer(handle)

        // No MethodBinds emitted yet.
    }
}
