package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * A tracked controller.
 *
 * Generated from Godot docs: XRControllerTracker
 */
open class XRControllerTracker internal constructor(handle: MemorySegment) : XRPositionalTracker(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): XRControllerTracker? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): XRControllerTracker? =
            if (handle.address() == 0L) null else XRControllerTracker(handle)
    }
}
