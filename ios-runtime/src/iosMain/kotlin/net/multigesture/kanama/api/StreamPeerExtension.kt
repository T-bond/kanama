package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: StreamPeerExtension
 */
class StreamPeerExtension(handle: MemorySegment) : StreamPeer(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): StreamPeerExtension? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): StreamPeerExtension? =
            if (handle.address() == 0L) null else StreamPeerExtension(handle)

        // No MethodBinds emitted yet.
    }
}
