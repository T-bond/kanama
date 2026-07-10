package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: ResourceImporterSVG
 */
class ResourceImporterSVG(handle: MemorySegment) : ResourceImporter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): ResourceImporterSVG? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): ResourceImporterSVG? =
            if (handle.address() == 0L) null else ResourceImporterSVG(handle)

        // No MethodBinds emitted yet.
    }
}
