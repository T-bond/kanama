package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Base class for all texture types.
 *
 * Generated from Godot docs: Texture
 */
open class Texture internal constructor(handle: MemorySegment) : Resource(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): Texture? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): Texture? =
            if (handle.address() == 0L) null else Texture(handle)
    }
}
