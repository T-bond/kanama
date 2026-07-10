package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioStreamMicrophone
 */
class AudioStreamMicrophone(handle: MemorySegment) : AudioStream(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AudioStreamMicrophone? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioStreamMicrophone? =
            if (handle.address() == 0L) null else AudioStreamMicrophone(handle)

        // No MethodBinds emitted yet.
    }
}
