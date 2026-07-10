package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VideoStreamTheora
 */
class VideoStreamTheora(handle: MemorySegment) : VideoStream(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VideoStreamTheora? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VideoStreamTheora? =
            if (handle.address() == 0L) null else VideoStreamTheora(handle)

        // No MethodBinds emitted yet.
    }
}
