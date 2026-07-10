package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: ResourceImporterDynamicFont
 */
class ResourceImporterDynamicFont(handle: MemorySegment) : ResourceImporter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): ResourceImporterDynamicFont? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): ResourceImporterDynamicFont? =
            if (handle.address() == 0L) null else ResourceImporterDynamicFont(handle)

        // No MethodBinds emitted yet.
    }
}
