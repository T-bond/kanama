package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/** Resource describing a 3D joint limit. Generated from Godot docs: JointLimitation3D */
/**
 * A base class of the limitation that interacts with `ChainIK3D`.
 *
 * Generated from Godot docs: JointLimitation3D
 */
open class JointLimitation3D internal constructor(handle: MemorySegment) : Resource(handle) {
    companion object {
        @JvmStatic fun fromHandle(handle: MemorySegment): JointLimitation3D? = wrap(handle)
        internal fun wrap(handle: MemorySegment): JointLimitation3D? = if (handle.address() == 0L) null else JointLimitation3D(handle)
    }
}
