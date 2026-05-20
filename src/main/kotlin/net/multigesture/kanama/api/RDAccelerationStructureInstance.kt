package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Acceleration structure instance (used by `RenderingDevice`).
 *
 * Generated from Godot docs: RDAccelerationStructureInstance
 */
open class RDAccelerationStructureInstance internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): RDAccelerationStructureInstance? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): RDAccelerationStructureInstance? =
            if (handle.address() == 0L) null else RDAccelerationStructureInstance(handle)
    }
}
