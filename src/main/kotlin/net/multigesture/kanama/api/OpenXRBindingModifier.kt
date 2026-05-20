package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Generated shell wrapper from Godot API metadata: OpenXRBindingModifier.
 */
open class OpenXRBindingModifier internal constructor(handle: MemorySegment) : Resource(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): OpenXRBindingModifier? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): OpenXRBindingModifier? =
            if (handle.address() == 0L) null else OpenXRBindingModifier(handle)
    }
}
