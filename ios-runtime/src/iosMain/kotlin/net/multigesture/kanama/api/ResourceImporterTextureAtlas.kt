package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: ResourceImporterTextureAtlas
 */
class ResourceImporterTextureAtlas(handle: MemorySegment) : ResourceImporter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): ResourceImporterTextureAtlas? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): ResourceImporterTextureAtlas? =
            if (handle.address() == 0L) null else ResourceImporterTextureAtlas(handle)

        // No MethodBinds emitted yet.
    }
}
