package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Generated from Godot docs: OpenXRSpatialComponentPlaneAlignmentList
 */
class OpenXRSpatialComponentPlaneAlignmentList(handle: MemorySegment) : OpenXRSpatialComponentData(handle) {
    fun getPlaneAlignment(index: Long): Long {
        return ObjectCalls.ptrcallWithLongArgRetLong(getPlaneAlignmentBind, handle, index)
    }

    companion object {
        private const val GET_PLANE_ALIGNMENT_HASH = 3340200270L
        private val getPlaneAlignmentBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialComponentPlaneAlignmentList", "get_plane_alignment", GET_PLANE_ALIGNMENT_HASH)
        }
    }
}
