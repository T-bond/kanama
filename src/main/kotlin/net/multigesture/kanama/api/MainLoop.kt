package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Abstract base class for the game's main loop.
 *
 * Generated from Godot docs: MainLoop
 */
open class MainLoop internal constructor(handle: MemorySegment) : GodotObject(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): MainLoop? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): MainLoop? =
            if (handle.address() == 0L) null else MainLoop(handle)
    }
}
