package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * A container that arranges its child controls vertically.
 *
 * Generated from Godot docs: VBoxContainer
 */
open class VBoxContainer(handle: MemorySegment) : BoxContainer(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): VBoxContainer? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VBoxContainer? =
            if (handle.address() == 0L) null else VBoxContainer(handle)
    }
}
