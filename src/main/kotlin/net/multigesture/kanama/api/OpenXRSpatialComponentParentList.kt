package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.RID
import java.lang.foreign.MemorySegment

/**
 * Generated from Godot docs: OpenXRSpatialComponentParentList
 */
class OpenXRSpatialComponentParentList(handle: MemorySegment) : OpenXRSpatialComponentData(handle) {
    fun getParent(index: Long): RID {
        return ObjectCalls.ptrcallWithLongArgRetRID(getParentBind, handle, index)
    }

    companion object {
        private const val GET_PARENT_HASH = 495598643L
        private val getParentBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialComponentParentList", "get_parent", GET_PARENT_HASH)
        }
    }
}
