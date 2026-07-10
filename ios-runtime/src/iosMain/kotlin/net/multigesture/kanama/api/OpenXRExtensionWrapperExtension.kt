package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: OpenXRExtensionWrapperExtension
 */
class OpenXRExtensionWrapperExtension(handle: MemorySegment) : OpenXRExtensionWrapper(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): OpenXRExtensionWrapperExtension? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): OpenXRExtensionWrapperExtension? =
            if (handle.address() == 0L) null else OpenXRExtensionWrapperExtension(handle)

        // No MethodBinds emitted yet.
    }
}
