package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: VisualShaderNodeColorOp
 */
class VisualShaderNodeColorOp(handle: MemorySegment) : VisualShaderNode(handle) {
    var operator: Long
        @JvmName("operatorProperty")
        get() = getOperator()
        @JvmName("setOperatorProperty")
        set(value) = setOperator(value)

    fun setOperator(op: Long) {
        ObjectCalls.ptrcallWithLongArg(setOperatorBind, handle, op)
    }

    fun getOperator(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getOperatorBind, handle)
    }

    companion object {
        private const val SET_OPERATOR_HASH = 4260370673L
        private val setOperatorBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeColorOp", "set_operator", SET_OPERATOR_HASH)
        }

        private const val GET_OPERATOR_HASH = 1950956529L
        private val getOperatorBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeColorOp", "get_operator", GET_OPERATOR_HASH)
        }
    }
}
