package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: OpenXRHapticBase
 */
open class OpenXRHapticBase(handle: MemorySegment) : Resource(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): OpenXRHapticBase? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): OpenXRHapticBase? =
            if (handle.address() == 0L) null else OpenXRHapticBase(handle)

        // No MethodBinds emitted yet.
    }
}
