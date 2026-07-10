package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: EditorTranslationParserPlugin
 */
class EditorTranslationParserPlugin(handle: MemorySegment) : RefCounted(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): EditorTranslationParserPlugin? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorTranslationParserPlugin? =
            if (handle.address() == 0L) null else EditorTranslationParserPlugin(handle)

        // No MethodBinds emitted yet.
    }
}
