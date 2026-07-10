package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioEffectEQ21
 */
class AudioEffectEQ21(handle: MemorySegment) : AudioEffectEQ(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AudioEffectEQ21? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioEffectEQ21? =
            if (handle.address() == 0L) null else AudioEffectEQ21(handle)

        // No MethodBinds emitted yet.
    }
}
