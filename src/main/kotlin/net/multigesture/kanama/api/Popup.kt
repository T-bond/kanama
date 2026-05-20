package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Base class for contextual windows and panels with fixed position.
 *
 * Generated from Godot docs: Popup
 */
open class Popup(handle: MemorySegment) : Window(handle) {
    object Signals {
        const val popupHide: String = "popup_hide"
    }

    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): Popup? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): Popup? =
            if (handle.address() == 0L) null else Popup(handle)
    }
}
