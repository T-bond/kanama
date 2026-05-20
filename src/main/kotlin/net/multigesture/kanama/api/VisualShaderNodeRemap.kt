package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: VisualShaderNodeRemap
 */
class VisualShaderNodeRemap(handle: MemorySegment) : VisualShaderNode(handle) {
    var opType: Long
        @JvmName("opTypeProperty")
        get() = getOpType()
        @JvmName("setOpTypeProperty")
        set(value) = setOpType(value)

    fun setOpType(opType: Long) {
        ObjectCalls.ptrcallWithLongArg(setOpTypeBind, handle, opType)
    }

    fun getOpType(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getOpTypeBind, handle)
    }

    companion object {
        private const val SET_OP_TYPE_HASH = 1703697889L
        private val setOpTypeBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeRemap", "set_op_type", SET_OP_TYPE_HASH)
        }

        private const val GET_OP_TYPE_HASH = 1678380563L
        private val getOpTypeBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeRemap", "get_op_type", GET_OP_TYPE_HASH)
        }
    }
}
