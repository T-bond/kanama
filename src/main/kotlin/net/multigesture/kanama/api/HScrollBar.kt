package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * A horizontal scrollbar that goes from left (min) to right (max).
 *
 * Generated from Godot docs: HScrollBar
 */
class HScrollBar(handle: MemorySegment) : ScrollBar(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): HScrollBar? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): HScrollBar? =
            if (handle.address() == 0L) null else HScrollBar(handle)
    }
}
