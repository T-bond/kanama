package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Base class for audio effect resources.
 *
 * Generated from Godot docs: AudioEffect
 */
open class AudioEffect internal constructor(handle: MemorySegment) : Resource(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): AudioEffect? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioEffect? =
            if (handle.address() == 0L) null else AudioEffect(handle)
    }
}
