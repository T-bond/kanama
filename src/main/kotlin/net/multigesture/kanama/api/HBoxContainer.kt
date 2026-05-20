package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * A container that arranges its child controls horizontally.
 *
 * Generated from Godot docs: HBoxContainer
 */
open class HBoxContainer(handle: MemorySegment) : BoxContainer(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): HBoxContainer? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): HBoxContainer? =
            if (handle.address() == 0L) null else HBoxContainer(handle)
    }
}
