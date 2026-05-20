package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * A 2D texture that supports drawing to itself via Blit calls.
 *
 * Generated from Godot docs: DrawableTexture2D
 */
open class DrawableTexture2D internal constructor(handle: MemorySegment) : Texture2D(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): DrawableTexture2D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): DrawableTexture2D? =
            if (handle.address() == 0L) null else DrawableTexture2D(handle)
    }
}
