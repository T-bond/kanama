package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Base class for `SyntaxHighlighter` used by the `ScriptEditor`.
 *
 * Generated from Godot docs: EditorSyntaxHighlighter
 */
open class EditorSyntaxHighlighter internal constructor(handle: MemorySegment) : SyntaxHighlighter(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): EditorSyntaxHighlighter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorSyntaxHighlighter? =
            if (handle.address() == 0L) null else EditorSyntaxHighlighter(handle)
    }
}
