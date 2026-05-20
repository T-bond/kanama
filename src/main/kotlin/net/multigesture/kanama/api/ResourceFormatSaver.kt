package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/** Reference-counted resource saver extension object. Generated from Godot docs: ResourceFormatSaver */
/**
 * Saves a specific resource type to a file.
 *
 * Generated from Godot docs: ResourceFormatSaver
 */
class ResourceFormatSaver internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic fun fromHandle(handle: MemorySegment): ResourceFormatSaver? = wrap(handle)
        internal fun wrap(handle: MemorySegment): ResourceFormatSaver? =
            if (handle.address() == 0L) null else ResourceFormatSaver(handle)
    }
}
