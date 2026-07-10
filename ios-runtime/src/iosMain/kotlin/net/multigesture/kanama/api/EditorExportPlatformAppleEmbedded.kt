package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: EditorExportPlatformAppleEmbedded
 */
open class EditorExportPlatformAppleEmbedded(handle: MemorySegment) : EditorExportPlatform(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): EditorExportPlatformAppleEmbedded? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorExportPlatformAppleEmbedded? =
            if (handle.address() == 0L) null else EditorExportPlatformAppleEmbedded(handle)

        // No MethodBinds emitted yet.
    }
}
