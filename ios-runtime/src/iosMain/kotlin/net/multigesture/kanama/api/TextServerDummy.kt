package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: TextServerDummy
 */
class TextServerDummy(handle: MemorySegment) : TextServerExtension(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): TextServerDummy? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): TextServerDummy? =
            if (handle.address() == 0L) null else TextServerDummy(handle)

        // No MethodBinds emitted yet.
    }
}
