package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls

/**
 * Generated from Godot docs: PacketPeerExtension
 */
class PacketPeerExtension(handle: MemorySegment) : PacketPeer(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): PacketPeerExtension? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): PacketPeerExtension? =
            if (handle.address() == 0L) null else PacketPeerExtension(handle)

        // No MethodBinds emitted yet.
    }
}
