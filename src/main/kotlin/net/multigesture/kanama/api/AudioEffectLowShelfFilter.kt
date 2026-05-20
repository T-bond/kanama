package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls

/**
 * Adds a low-shelf filter to an audio bus.
 *
 * Generated from Godot docs: AudioEffectLowShelfFilter
 */
class AudioEffectLowShelfFilter(handle: MemorySegment) : AudioEffectFilter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): AudioEffectLowShelfFilter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioEffectLowShelfFilter? =
            if (handle.address() == 0L) null else AudioEffectLowShelfFilter(handle)

        // No MethodBinds emitted yet.
    }
}
