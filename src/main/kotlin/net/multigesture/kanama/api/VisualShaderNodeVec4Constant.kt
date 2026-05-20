package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.Quaternion
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: VisualShaderNodeVec4Constant
 */
class VisualShaderNodeVec4Constant(handle: MemorySegment) : VisualShaderNodeConstant(handle) {
    var constant: Quaternion
        @JvmName("constantProperty")
        get() = getConstant()
        @JvmName("setConstantProperty")
        set(value) = setConstant(value)

    fun setConstant(constant: Quaternion) {
        ObjectCalls.ptrcallWithQuaternionArg(setConstantBind, handle, constant)
    }

    fun getConstant(): Quaternion {
        return ObjectCalls.ptrcallNoArgsRetQuaternion(getConstantBind, handle)
    }

    companion object {
        private const val SET_CONSTANT_HASH = 1727505552L
        private val setConstantBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeVec4Constant", "set_constant", SET_CONSTANT_HASH)
        }

        private const val GET_CONSTANT_HASH = 1222331677L
        private val getConstantBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeVec4Constant", "get_constant", GET_CONSTANT_HASH)
        }
    }
}
