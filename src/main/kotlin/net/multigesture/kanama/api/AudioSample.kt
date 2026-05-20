package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Base class for audio samples.
 *
 * Generated from Godot docs: AudioSample
 */
class AudioSample internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): AudioSample? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioSample? =
            if (handle.address() == 0L) null else AudioSample(handle)
    }
}
