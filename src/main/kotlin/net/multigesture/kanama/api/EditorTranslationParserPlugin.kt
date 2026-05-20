package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Plugin for adding custom parsers to extract strings that are to be translated from custom files
 * (.csv, .json etc.).
 *
 * Generated from Godot docs: EditorTranslationParserPlugin
 */
open class EditorTranslationParserPlugin internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): EditorTranslationParserPlugin? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorTranslationParserPlugin? =
            if (handle.address() == 0L) null else EditorTranslationParserPlugin(handle)
    }
}
