package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * A physics joint that restricts the rotation of a 3D physics body around an axis relative to
 * another physics body.
 *
 * Generated from Godot docs: HingeJoint3D
 */
class HingeJoint3D(handle: MemorySegment) : Joint3D(handle) {
    /**
     * The speed with which the two bodies get pulled together when they move in different directions.
     *
     * Generated from Godot docs: HingeJoint3D.set_param
     */
    fun setParam(param: Long, value: Double) {
        ObjectCalls.ptrcallWithLongAndDoubleArg(setParamBind, handle, param, value)
    }

    /**
     * The speed with which the two bodies get pulled together when they move in different directions.
     *
     * Generated from Godot docs: HingeJoint3D.get_param
     */
    fun getParam(param: Long): Double {
        return ObjectCalls.ptrcallWithLongArgRetDouble(getParamBind, handle, param)
    }

    /**
     * When activated, a motor turns the hinge.
     *
     * Generated from Godot docs: HingeJoint3D.set_flag
     */
    fun setFlag(flag: Long, enabled: Boolean) {
        ObjectCalls.ptrcallWithLongAndBoolArgs(setFlagBind, handle, flag, enabled)
    }

    /**
     * When activated, a motor turns the hinge.
     *
     * Generated from Godot docs: HingeJoint3D.get_flag
     */
    fun getFlag(flag: Long): Boolean {
        return ObjectCalls.ptrcallWithLongArgRetBool(getFlagBind, handle, flag)
    }

    companion object {
        private const val SET_PARAM_HASH = 3082977519L
        private val setParamBind by lazy {
            ObjectCalls.getMethodBind("HingeJoint3D", "set_param", SET_PARAM_HASH)
        }

        private const val GET_PARAM_HASH = 4066002676L
        private val getParamBind by lazy {
            ObjectCalls.getMethodBind("HingeJoint3D", "get_param", GET_PARAM_HASH)
        }

        private const val SET_FLAG_HASH = 1083494620L
        private val setFlagBind by lazy {
            ObjectCalls.getMethodBind("HingeJoint3D", "set_flag", SET_FLAG_HASH)
        }

        private const val GET_FLAG_HASH = 2841369610L
        private val getFlagBind by lazy {
            ObjectCalls.getMethodBind("HingeJoint3D", "get_flag", GET_FLAG_HASH)
        }
    }
}
