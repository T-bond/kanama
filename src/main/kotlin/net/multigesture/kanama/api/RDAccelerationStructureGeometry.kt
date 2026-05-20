package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Acceleration structure geometry (used by `RenderingDevice`).
 *
 * Generated from Godot docs: RDAccelerationStructureGeometry
 */
open class RDAccelerationStructureGeometry internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): RDAccelerationStructureGeometry? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): RDAccelerationStructureGeometry? =
            if (handle.address() == 0L) null else RDAccelerationStructureGeometry(handle)
    }
}
