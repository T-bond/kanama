package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioEffectEQ10
 */
class AudioEffectEQ10(handle: MemorySegment) : AudioEffectEQ(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AudioEffectEQ10? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioEffectEQ10? =
            if (handle.address() == 0L) null else AudioEffectEQ10(handle)

        // No MethodBinds emitted yet.
    }
}
