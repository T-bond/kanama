package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioEffectLowPassFilter
 */
class AudioEffectLowPassFilter(handle: MemorySegment) : AudioEffectFilter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AudioEffectLowPassFilter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioEffectLowPassFilter? =
            if (handle.address() == 0L) null else AudioEffectLowPassFilter(handle)

        // No MethodBinds emitted yet.
    }
}
