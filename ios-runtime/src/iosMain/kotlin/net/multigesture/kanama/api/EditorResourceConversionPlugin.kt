package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: EditorResourceConversionPlugin
 */
class EditorResourceConversionPlugin(handle: MemorySegment) : RefCounted(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): EditorResourceConversionPlugin? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorResourceConversionPlugin? =
            if (handle.address() == 0L) null else EditorResourceConversionPlugin(handle)

        // No MethodBinds emitted yet.
    }
}
