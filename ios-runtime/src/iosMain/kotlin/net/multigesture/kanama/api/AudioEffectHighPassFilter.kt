package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioEffectHighPassFilter
 */
class AudioEffectHighPassFilter(handle: MemorySegment) : AudioEffectFilter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AudioEffectHighPassFilter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioEffectHighPassFilter? =
            if (handle.address() == 0L) null else AudioEffectHighPassFilter(handle)

        // No MethodBinds emitted yet.
    }
}
