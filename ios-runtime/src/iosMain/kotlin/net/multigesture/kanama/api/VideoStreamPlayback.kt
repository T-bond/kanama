package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VideoStreamPlayback
 */
class VideoStreamPlayback(handle: MemorySegment) : Resource(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VideoStreamPlayback? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VideoStreamPlayback? =
            if (handle.address() == 0L) null else VideoStreamPlayback(handle)

        // No MethodBinds emitted yet.
    }
}
