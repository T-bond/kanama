package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Generated from Godot docs: OpenXRSpatialComponentPlaneSemanticLabelList
 */
class OpenXRSpatialComponentPlaneSemanticLabelList(handle: MemorySegment) : OpenXRSpatialComponentData(handle) {
    fun getPlaneSemanticLabel(index: Long): Long {
        return ObjectCalls.ptrcallWithLongArgRetLong(getPlaneSemanticLabelBind, handle, index)
    }

    companion object {
        private const val GET_PLANE_SEMANTIC_LABEL_HASH = 1889332427L
        private val getPlaneSemanticLabelBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialComponentPlaneSemanticLabelList", "get_plane_semantic_label", GET_PLANE_SEMANTIC_LABEL_HASH)
        }
    }
}
