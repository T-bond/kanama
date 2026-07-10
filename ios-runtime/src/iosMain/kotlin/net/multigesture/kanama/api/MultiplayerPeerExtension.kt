package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: MultiplayerPeerExtension
 */
class MultiplayerPeerExtension(handle: MemorySegment) : MultiplayerPeer(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): MultiplayerPeerExtension? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): MultiplayerPeerExtension? =
            if (handle.address() == 0L) null else MultiplayerPeerExtension(handle)

        // No MethodBinds emitted yet.
    }
}
