package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: TextServerExtension
 */
open class TextServerExtension(handle: MemorySegment) : TextServer(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): TextServerExtension? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): TextServerExtension? =
            if (handle.address() == 0L) null else TextServerExtension(handle)

        // No MethodBinds emitted yet.
    }
}
