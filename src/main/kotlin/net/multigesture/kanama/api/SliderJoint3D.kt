package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * A physics joint that restricts the movement of a 3D physics body along an axis relative to
 * another physics body.
 *
 * Generated from Godot docs: SliderJoint3D
 */
class SliderJoint3D(handle: MemorySegment) : Joint3D(handle) {
    /**
     * A factor applied to the movement across axes orthogonal to the slider.
     *
     * Generated from Godot docs: SliderJoint3D.set_param
     */
    fun setParam(param: Long, value: Double) {
        ObjectCalls.ptrcallWithLongAndDoubleArg(setParamBind, handle, param, value)
    }

    /**
     * A factor applied to the movement across axes orthogonal to the slider.
     *
     * Generated from Godot docs: SliderJoint3D.get_param
     */
    fun getParam(param: Long): Double {
        return ObjectCalls.ptrcallWithLongArgRetDouble(getParamBind, handle, param)
    }

    companion object {
        private const val SET_PARAM_HASH = 918243683L
        private val setParamBind by lazy {
            ObjectCalls.getMethodBind("SliderJoint3D", "set_param", SET_PARAM_HASH)
        }

        private const val GET_PARAM_HASH = 959925627L
        private val getParamBind by lazy {
            ObjectCalls.getMethodBind("SliderJoint3D", "get_param", GET_PARAM_HASH)
        }
    }
}
