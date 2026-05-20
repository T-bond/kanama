package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Generated from Godot docs: OpenXRSpatialQueryResultData
 */
class OpenXRSpatialQueryResultData(handle: MemorySegment) : OpenXRSpatialComponentData(handle) {
    fun getCapacity(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getCapacityBind, handle)
    }

    fun getEntityId(index: Long): Long {
        return ObjectCalls.ptrcallWithLongArgRetLong(getEntityIdBind, handle, index)
    }

    fun getEntityState(index: Long): Long {
        return ObjectCalls.ptrcallWithLongArgRetLong(getEntityStateBind, handle, index)
    }

    companion object {
        private const val GET_CAPACITY_HASH = 3905245786L
        private val getCapacityBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialQueryResultData", "get_capacity", GET_CAPACITY_HASH)
        }

        private const val GET_ENTITY_ID_HASH = 923996154L
        private val getEntityIdBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialQueryResultData", "get_entity_id", GET_ENTITY_ID_HASH)
        }

        private const val GET_ENTITY_STATE_HASH = 1411962015L
        private val getEntityStateBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialQueryResultData", "get_entity_state", GET_ENTITY_STATE_HASH)
        }
    }
}
