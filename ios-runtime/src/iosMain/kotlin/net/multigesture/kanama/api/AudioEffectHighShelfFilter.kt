package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioEffectHighShelfFilter
 */
class AudioEffectHighShelfFilter(handle: MemorySegment) : AudioEffectFilter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AudioEffectHighShelfFilter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioEffectHighShelfFilter? =
            if (handle.address() == 0L) null else AudioEffectHighShelfFilter(handle)

        // No MethodBinds emitted yet.
    }
}
