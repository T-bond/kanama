package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Meta class for playing back audio samples.
 *
 * Generated from Godot docs: AudioSamplePlayback
 */
class AudioSamplePlayback internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): AudioSamplePlayback? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioSamplePlayback? =
            if (handle.address() == 0L) null else AudioSamplePlayback(handle)
    }
}
