package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Generated shell wrapper from Godot API metadata: OpenXRActionBindingModifier.
 */
open class OpenXRActionBindingModifier internal constructor(handle: MemorySegment) : OpenXRBindingModifier(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): OpenXRActionBindingModifier? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): OpenXRActionBindingModifier? =
            if (handle.address() == 0L) null else OpenXRActionBindingModifier(handle)
    }
}
