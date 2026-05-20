package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Stores information about the audio buses.
 *
 * Generated from Godot docs: AudioBusLayout
 */
class AudioBusLayout internal constructor(handle: MemorySegment) : Resource(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): AudioBusLayout? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioBusLayout? =
            if (handle.address() == 0L) null else AudioBusLayout(handle)
    }
}
