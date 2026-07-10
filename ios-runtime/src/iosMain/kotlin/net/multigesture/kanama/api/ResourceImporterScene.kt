package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: ResourceImporterScene
 */
class ResourceImporterScene(handle: MemorySegment) : ResourceImporter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): ResourceImporterScene? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): ResourceImporterScene? =
            if (handle.address() == 0L) null else ResourceImporterScene(handle)

        // No MethodBinds emitted yet.
    }
}
