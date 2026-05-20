package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * A custom effect for a `RichTextLabel`.
 *
 * Generated from Godot docs: RichTextEffect
 */
open class RichTextEffect internal constructor(handle: MemorySegment) : Resource(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): RichTextEffect? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): RichTextEffect? =
            if (handle.address() == 0L) null else RichTextEffect(handle)
    }
}
