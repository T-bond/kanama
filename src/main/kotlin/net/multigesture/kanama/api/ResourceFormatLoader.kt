package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/** Reference-counted resource loader extension object. Generated from Godot docs: ResourceFormatLoader */
/**
 * Loads a specific resource type from a file.
 *
 * Generated from Godot docs: ResourceFormatLoader
 */
class ResourceFormatLoader internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic fun fromHandle(handle: MemorySegment): ResourceFormatLoader? = wrap(handle)
        internal fun wrap(handle: MemorySegment): ResourceFormatLoader? =
            if (handle.address() == 0L) null else ResourceFormatLoader(handle)
    }
}
