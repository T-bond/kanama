package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: EditorImportPlugin
 */
class EditorImportPlugin(handle: MemorySegment) : ResourceImporter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): EditorImportPlugin? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorImportPlugin? =
            if (handle.address() == 0L) null else EditorImportPlugin(handle)

        // No MethodBinds emitted yet.
    }
}
