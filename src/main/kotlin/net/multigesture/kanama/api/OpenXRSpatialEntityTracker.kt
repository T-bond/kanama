package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.RID
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: OpenXRSpatialEntityTracker
 */
open class OpenXRSpatialEntityTracker(handle: MemorySegment) : XRPositionalTracker(handle) {
    var entity: RID
        @JvmName("entityProperty")
        get() = getEntity()
        @JvmName("setEntityProperty")
        set(value) = setEntity(value)

    var spatialTrackingState: Long
        @JvmName("spatialTrackingStateProperty")
        get() = getSpatialTrackingState()
        @JvmName("setSpatialTrackingStateProperty")
        set(value) = setSpatialTrackingState(value)

    fun setEntity(entity: RID) {
        ObjectCalls.ptrcallWithRIDArg(setEntityBind, handle, entity)
    }

    fun getEntity(): RID {
        return ObjectCalls.ptrcallNoArgsRetRID(getEntityBind, handle)
    }

    fun setSpatialTrackingState(spatialTrackingState: Long) {
        ObjectCalls.ptrcallWithLongArg(setSpatialTrackingStateBind, handle, spatialTrackingState)
    }

    fun getSpatialTrackingState(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getSpatialTrackingStateBind, handle)
    }

    object Signals {
        const val spatialTrackingStateChanged: String = "spatial_tracking_state_changed"
    }

    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): OpenXRSpatialEntityTracker? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): OpenXRSpatialEntityTracker? =
            if (handle.address() == 0L) null else OpenXRSpatialEntityTracker(handle)

        private const val SET_ENTITY_HASH = 2722037293L
        private val setEntityBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialEntityTracker", "set_entity", SET_ENTITY_HASH)
        }

        private const val GET_ENTITY_HASH = 2944877500L
        private val getEntityBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialEntityTracker", "get_entity", GET_ENTITY_HASH)
        }

        private const val SET_SPATIAL_TRACKING_STATE_HASH = 2170234447L
        private val setSpatialTrackingStateBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialEntityTracker", "set_spatial_tracking_state", SET_SPATIAL_TRACKING_STATE_HASH)
        }

        private const val GET_SPATIAL_TRACKING_STATE_HASH = 3351876560L
        private val getSpatialTrackingStateBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialEntityTracker", "get_spatial_tracking_state", GET_SPATIAL_TRACKING_STATE_HASH)
        }
    }
}
