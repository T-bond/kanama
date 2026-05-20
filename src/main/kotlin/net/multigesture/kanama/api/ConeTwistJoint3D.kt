package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * A physics joint that connects two 3D physics bodies in a way that simulates a ball-and-socket
 * joint.
 *
 * Generated from Godot docs: ConeTwistJoint3D
 */
class ConeTwistJoint3D(handle: MemorySegment) : Joint3D(handle) {
    /**
     * Twist is the rotation around the twist axis, this value defined how far the joint can twist.
     * Twist is locked if below 0.05.
     *
     * Generated from Godot docs: ConeTwistJoint3D.set_param
     */
    fun setParam(param: Long, value: Double) {
        ObjectCalls.ptrcallWithLongAndDoubleArg(setParamBind, handle, param, value)
    }

    /**
     * Twist is the rotation around the twist axis, this value defined how far the joint can twist.
     * Twist is locked if below 0.05.
     *
     * Generated from Godot docs: ConeTwistJoint3D.get_param
     */
    fun getParam(param: Long): Double {
        return ObjectCalls.ptrcallWithLongArgRetDouble(getParamBind, handle, param)
    }

    companion object {
        private const val SET_PARAM_HASH = 1062470226L
        private val setParamBind by lazy {
            ObjectCalls.getMethodBind("ConeTwistJoint3D", "set_param", SET_PARAM_HASH)
        }

        private const val GET_PARAM_HASH = 2928790850L
        private val getParamBind by lazy {
            ObjectCalls.getMethodBind("ConeTwistJoint3D", "get_param", GET_PARAM_HASH)
        }
    }
}
