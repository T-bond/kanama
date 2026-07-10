package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioEffectNotchFilter
 */
class AudioEffectNotchFilter(handle: MemorySegment) : AudioEffectFilter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AudioEffectNotchFilter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioEffectNotchFilter? =
            if (handle.address() == 0L) null else AudioEffectNotchFilter(handle)

        // No MethodBinds emitted yet.
    }
}
