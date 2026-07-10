package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioEffectLowShelfFilter
 */
class AudioEffectLowShelfFilter(handle: MemorySegment) : AudioEffectFilter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AudioEffectLowShelfFilter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioEffectLowShelfFilter? =
            if (handle.address() == 0L) null else AudioEffectLowShelfFilter(handle)

        // No MethodBinds emitted yet.
    }
}
