package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: EditorSyntaxHighlighter
 */
open class EditorSyntaxHighlighter(handle: MemorySegment) : SyntaxHighlighter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): EditorSyntaxHighlighter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorSyntaxHighlighter? =
            if (handle.address() == 0L) null else EditorSyntaxHighlighter(handle)

        // No MethodBinds emitted yet.
    }
}
