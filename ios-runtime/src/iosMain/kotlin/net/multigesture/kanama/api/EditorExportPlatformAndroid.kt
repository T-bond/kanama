package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: EditorExportPlatformAndroid
 */
class EditorExportPlatformAndroid(handle: MemorySegment) : EditorExportPlatform(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): EditorExportPlatformAndroid? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorExportPlatformAndroid? =
            if (handle.address() == 0L) null else EditorExportPlatformAndroid(handle)

        // No MethodBinds emitted yet.
    }
}
