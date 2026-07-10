package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: ResourceImporterWAV
 */
class ResourceImporterWAV(handle: MemorySegment) : ResourceImporter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): ResourceImporterWAV? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): ResourceImporterWAV? =
            if (handle.address() == 0L) null else ResourceImporterWAV(handle)

        // No MethodBinds emitted yet.
    }
}
