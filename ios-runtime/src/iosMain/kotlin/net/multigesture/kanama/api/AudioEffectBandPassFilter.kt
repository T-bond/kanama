package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioEffectBandPassFilter
 */
class AudioEffectBandPassFilter(handle: MemorySegment) : AudioEffectFilter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AudioEffectBandPassFilter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioEffectBandPassFilter? =
            if (handle.address() == 0L) null else AudioEffectBandPassFilter(handle)

        // No MethodBinds emitted yet.
    }
}
