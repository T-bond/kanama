package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: EditorSceneFormatImporterUFBX
 */
class EditorSceneFormatImporterUFBX(handle: MemorySegment) : EditorSceneFormatImporter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): EditorSceneFormatImporterUFBX? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorSceneFormatImporterUFBX? =
            if (handle.address() == 0L) null else EditorSceneFormatImporterUFBX(handle)

        // No MethodBinds emitted yet.
    }
}
