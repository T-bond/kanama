package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*
import net.multigesture.kanama.types.Rect2i

/**
 * Generated from Godot docs: XRVRS
 */
class XRVRS(handle: MemorySegment) : GodotObject(handle) {
    var vrsMinRadius: Double
        @JvmName("vrsMinRadiusProperty")
        get() = getVrsMinRadius()
        @JvmName("setVrsMinRadiusProperty")
        set(value) = setVrsMinRadius(value)

    var vrsStrength: Double
        @JvmName("vrsStrengthProperty")
        get() = getVrsStrength()
        @JvmName("setVrsStrengthProperty")
        set(value) = setVrsStrength(value)

    val vrsRenderRegion: Rect2i
        @JvmName("vrsRenderRegionProperty")
        get() = getVrsRenderRegion()

    fun getVrsMinRadius(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getVrsMinRadiusBind, handle)
    }

    fun setVrsMinRadius(radius: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setVrsMinRadiusBind, handle, radius)
    }

    fun getVrsStrength(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getVrsStrengthBind, handle)
    }

    fun setVrsStrength(strength: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setVrsStrengthBind, handle, strength)
    }

    fun getVrsRenderRegion(): Rect2i {
        return ObjectCalls.ptrcallNoArgsRetRect2i(getVrsRenderRegionBind, handle)
    }

    companion object {
        fun fromHandle(handle: MemorySegment): XRVRS? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): XRVRS? =
            if (handle.address() == 0L) null else XRVRS(handle)

        private const val GET_VRS_MIN_RADIUS_HASH = 1740695150L
        private val getVrsMinRadiusBind by lazy {
            ObjectCalls.getMethodBind("XRVRS", "get_vrs_min_radius", GET_VRS_MIN_RADIUS_HASH)
        }

        private const val SET_VRS_MIN_RADIUS_HASH = 373806689L
        private val setVrsMinRadiusBind by lazy {
            ObjectCalls.getMethodBind("XRVRS", "set_vrs_min_radius", SET_VRS_MIN_RADIUS_HASH)
        }

        private const val GET_VRS_STRENGTH_HASH = 1740695150L
        private val getVrsStrengthBind by lazy {
            ObjectCalls.getMethodBind("XRVRS", "get_vrs_strength", GET_VRS_STRENGTH_HASH)
        }

        private const val SET_VRS_STRENGTH_HASH = 373806689L
        private val setVrsStrengthBind by lazy {
            ObjectCalls.getMethodBind("XRVRS", "set_vrs_strength", SET_VRS_STRENGTH_HASH)
        }

        private const val GET_VRS_RENDER_REGION_HASH = 410525958L
        private val getVrsRenderRegionBind by lazy {
            ObjectCalls.getMethodBind("XRVRS", "get_vrs_render_region", GET_VRS_RENDER_REGION_HASH)
        }
    }
}
