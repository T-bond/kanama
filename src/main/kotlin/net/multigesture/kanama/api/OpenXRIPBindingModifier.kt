package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Generated shell wrapper from Godot API metadata: OpenXRIPBindingModifier.
 */
open class OpenXRIPBindingModifier internal constructor(handle: MemorySegment) : OpenXRBindingModifier(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): OpenXRIPBindingModifier? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): OpenXRIPBindingModifier? =
            if (handle.address() == 0L) null else OpenXRIPBindingModifier(handle)
    }
}
