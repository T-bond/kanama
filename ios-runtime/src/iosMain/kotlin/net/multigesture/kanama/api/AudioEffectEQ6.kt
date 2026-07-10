package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioEffectEQ6
 */
class AudioEffectEQ6(handle: MemorySegment) : AudioEffectEQ(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AudioEffectEQ6? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioEffectEQ6? =
            if (handle.address() == 0L) null else AudioEffectEQ6(handle)

        // No MethodBinds emitted yet.
    }
}
