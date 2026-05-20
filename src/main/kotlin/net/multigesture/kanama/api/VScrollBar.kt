package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * A vertical scrollbar that goes from top (min) to bottom (max).
 *
 * Generated from Godot docs: VScrollBar
 */
class VScrollBar(handle: MemorySegment) : ScrollBar(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): VScrollBar? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VScrollBar? =
            if (handle.address() == 0L) null else VScrollBar(handle)
    }
}
