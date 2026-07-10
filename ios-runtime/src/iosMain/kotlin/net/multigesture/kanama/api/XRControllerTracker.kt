package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: XRControllerTracker
 */
class XRControllerTracker(handle: MemorySegment) : XRPositionalTracker(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): XRControllerTracker? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): XRControllerTracker? =
            if (handle.address() == 0L) null else XRControllerTracker(handle)

        // No MethodBinds emitted yet.
    }
}
