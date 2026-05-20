package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Base resource for OpenXR haptic feedback definitions.
 *
 * Generated from Godot docs: OpenXRHapticBase
 */
open class OpenXRHapticBase internal constructor(handle: MemorySegment) : Resource(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): OpenXRHapticBase? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): OpenXRHapticBase? =
            if (handle.address() == 0L) null else OpenXRHapticBase(handle)
    }
}
