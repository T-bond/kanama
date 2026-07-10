package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: ResourceImporterTexture
 */
class ResourceImporterTexture(handle: MemorySegment) : ResourceImporter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): ResourceImporterTexture? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): ResourceImporterTexture? =
            if (handle.address() == 0L) null else ResourceImporterTexture(handle)

        // No MethodBinds emitted yet.
    }
}
