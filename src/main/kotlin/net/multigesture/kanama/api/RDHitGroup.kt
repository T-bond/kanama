package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Hit group (used by `RenderingDevice`).
 *
 * Generated from Godot docs: RDHitGroup
 */
open class RDHitGroup internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): RDHitGroup? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): RDHitGroup? =
            if (handle.address() == 0L) null else RDHitGroup(handle)
    }
}
