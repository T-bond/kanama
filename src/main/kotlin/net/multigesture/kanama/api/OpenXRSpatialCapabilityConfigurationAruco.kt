package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: OpenXRSpatialCapabilityConfigurationAruco
 */
class OpenXRSpatialCapabilityConfigurationAruco(handle: MemorySegment) : OpenXRSpatialCapabilityConfigurationBaseHeader(handle) {
    var arucoDict: Long
        @JvmName("arucoDictProperty")
        get() = getArucoDict()
        @JvmName("setArucoDictProperty")
        set(value) = setArucoDict(value)

    fun getEnabledComponents(): List<Long> {
        return ObjectCalls.ptrcallNoArgsRetPackedInt64List(getEnabledComponentsBind, handle)
    }

    fun setArucoDict(arucoDict: Long) {
        ObjectCalls.ptrcallWithLongArg(setArucoDictBind, handle, arucoDict)
    }

    fun getArucoDict(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getArucoDictBind, handle)
    }

    companion object {
        private const val GET_ENABLED_COMPONENTS_HASH = 235988956L
        private val getEnabledComponentsBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialCapabilityConfigurationAruco", "get_enabled_components", GET_ENABLED_COMPONENTS_HASH)
        }

        private const val SET_ARUCO_DICT_HASH = 2268055963L
        private val setArucoDictBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialCapabilityConfigurationAruco", "set_aruco_dict", SET_ARUCO_DICT_HASH)
        }

        private const val GET_ARUCO_DICT_HASH = 1080386209L
        private val getArucoDictBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialCapabilityConfigurationAruco", "get_aruco_dict", GET_ARUCO_DICT_HASH)
        }
    }
}
