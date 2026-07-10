package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioEffectBandLimitFilter
 */
class AudioEffectBandLimitFilter(handle: MemorySegment) : AudioEffectFilter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AudioEffectBandLimitFilter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioEffectBandLimitFilter? =
            if (handle.address() == 0L) null else AudioEffectBandLimitFilter(handle)

        // No MethodBinds emitted yet.
    }
}
