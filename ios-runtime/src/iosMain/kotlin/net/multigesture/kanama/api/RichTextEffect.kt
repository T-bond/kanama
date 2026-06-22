package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: RichTextEffect
 */
class RichTextEffect(handle: MemorySegment) : Resource(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): RichTextEffect? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): RichTextEffect? =
            if (handle.address() == 0L) null else RichTextEffect(handle)

        // No MethodBinds emitted yet.
    }
}
