package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: EditorExportPlatformVisionOS
 */
class EditorExportPlatformVisionOS(handle: MemorySegment) : EditorExportPlatformAppleEmbedded(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): EditorExportPlatformVisionOS? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorExportPlatformVisionOS? =
            if (handle.address() == 0L) null else EditorExportPlatformVisionOS(handle)

        // No MethodBinds emitted yet.
    }
}
