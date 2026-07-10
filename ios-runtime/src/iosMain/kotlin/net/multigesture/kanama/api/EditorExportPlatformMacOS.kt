package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: EditorExportPlatformMacOS
 */
class EditorExportPlatformMacOS(handle: MemorySegment) : EditorExportPlatform(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): EditorExportPlatformMacOS? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorExportPlatformMacOS? =
            if (handle.address() == 0L) null else EditorExportPlatformMacOS(handle)

        // No MethodBinds emitted yet.
    }
}
