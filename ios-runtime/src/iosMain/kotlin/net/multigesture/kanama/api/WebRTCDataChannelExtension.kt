package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: WebRTCDataChannelExtension
 */
class WebRTCDataChannelExtension(handle: MemorySegment) : WebRTCDataChannel(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): WebRTCDataChannelExtension? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): WebRTCDataChannelExtension? =
            if (handle.address() == 0L) null else WebRTCDataChannelExtension(handle)

        // No MethodBinds emitted yet.
    }
}
