package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: OpenXRBindingModifier
 */
open class OpenXRBindingModifier(handle: MemorySegment) : Resource(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): OpenXRBindingModifier? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): OpenXRBindingModifier? =
            if (handle.address() == 0L) null else OpenXRBindingModifier(handle)

        // No MethodBinds emitted yet.
    }
}
