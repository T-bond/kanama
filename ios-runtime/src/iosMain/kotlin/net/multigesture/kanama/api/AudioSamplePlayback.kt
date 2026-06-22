package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioSamplePlayback
 */
class AudioSamplePlayback(handle: MemorySegment) : RefCounted(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AudioSamplePlayback? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioSamplePlayback? =
            if (handle.address() == 0L) null else AudioSamplePlayback(handle)

        // No MethodBinds emitted yet.
    }
}
