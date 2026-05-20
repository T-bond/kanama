package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * A popup with a panel background.
 *
 * Generated from Godot docs: PopupPanel
 */
class PopupPanel(handle: MemorySegment) : Popup(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): PopupPanel? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): PopupPanel? =
            if (handle.address() == 0L) null else PopupPanel(handle)
    }
}
