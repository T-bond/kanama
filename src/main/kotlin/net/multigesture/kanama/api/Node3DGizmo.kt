package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Abstract class to expose editor gizmos for `Node3D`.
 *
 * Generated from Godot docs: Node3DGizmo
 */
open class Node3DGizmo internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): Node3DGizmo? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): Node3DGizmo? =
            if (handle.address() == 0L) null else Node3DGizmo(handle)
    }
}
