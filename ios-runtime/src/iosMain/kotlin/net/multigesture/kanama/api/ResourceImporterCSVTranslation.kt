package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: ResourceImporterCSVTranslation
 */
class ResourceImporterCSVTranslation(handle: MemorySegment) : ResourceImporter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): ResourceImporterCSVTranslation? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): ResourceImporterCSVTranslation? =
            if (handle.address() == 0L) null else ResourceImporterCSVTranslation(handle)

        // No MethodBinds emitted yet.
    }
}
