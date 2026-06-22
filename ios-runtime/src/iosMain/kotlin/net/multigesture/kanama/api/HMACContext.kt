package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: HMACContext
 */
class HMACContext(handle: MemorySegment) : RefCounted(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): HMACContext? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): HMACContext? =
            if (handle.address() == 0L) null else HMACContext(handle)

        // No MethodBinds emitted yet.
    }
}
