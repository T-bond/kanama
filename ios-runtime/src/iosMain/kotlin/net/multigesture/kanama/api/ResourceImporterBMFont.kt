package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: ResourceImporterBMFont
 */
class ResourceImporterBMFont(handle: MemorySegment) : ResourceImporter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): ResourceImporterBMFont? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): ResourceImporterBMFont? =
            if (handle.address() == 0L) null else ResourceImporterBMFont(handle)

        // No MethodBinds emitted yet.
    }
}
