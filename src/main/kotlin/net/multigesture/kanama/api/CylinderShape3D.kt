package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A 3D cylinder shape used for physics collision.
 *
 * Generated from Godot docs: CylinderShape3D
 */
class CylinderShape3D(handle: MemorySegment) : Shape3D(handle) {
    var height: Double
        @JvmName("heightProperty")
        get() = getHeight()
        @JvmName("setHeightProperty")
        set(value) = setHeight(value)

    var radius: Double
        @JvmName("radiusProperty")
        get() = getRadius()
        @JvmName("setRadiusProperty")
        set(value) = setRadius(value)

    /**
     * The cylinder's radius.
     *
     * Generated from Godot docs: CylinderShape3D.set_radius
     */
    fun setRadius(radius: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setRadiusBind, handle, radius)
    }

    /**
     * The cylinder's radius.
     *
     * Generated from Godot docs: CylinderShape3D.get_radius
     */
    fun getRadius(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getRadiusBind, handle)
    }

    /**
     * The cylinder's height.
     *
     * Generated from Godot docs: CylinderShape3D.set_height
     */
    fun setHeight(height: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setHeightBind, handle, height)
    }

    /**
     * The cylinder's height.
     *
     * Generated from Godot docs: CylinderShape3D.get_height
     */
    fun getHeight(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getHeightBind, handle)
    }

    companion object {
        private const val SET_RADIUS_HASH = 373806689L
        private val setRadiusBind by lazy {
            ObjectCalls.getMethodBind("CylinderShape3D", "set_radius", SET_RADIUS_HASH)
        }

        private const val GET_RADIUS_HASH = 1740695150L
        private val getRadiusBind by lazy {
            ObjectCalls.getMethodBind("CylinderShape3D", "get_radius", GET_RADIUS_HASH)
        }

        private const val SET_HEIGHT_HASH = 373806689L
        private val setHeightBind by lazy {
            ObjectCalls.getMethodBind("CylinderShape3D", "set_height", SET_HEIGHT_HASH)
        }

        private const val GET_HEIGHT_HASH = 1740695150L
        private val getHeightBind by lazy {
            ObjectCalls.getMethodBind("CylinderShape3D", "get_height", GET_HEIGHT_HASH)
        }
    }
}
