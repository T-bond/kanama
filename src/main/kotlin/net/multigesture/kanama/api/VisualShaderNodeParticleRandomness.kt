package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: VisualShaderNodeParticleRandomness
 */
class VisualShaderNodeParticleRandomness(handle: MemorySegment) : VisualShaderNode(handle) {
    var opType: Long
        @JvmName("opTypeProperty")
        get() = getOpType()
        @JvmName("setOpTypeProperty")
        set(value) = setOpType(value)

    fun setOpType(type: Long) {
        ObjectCalls.ptrcallWithLongArg(setOpTypeBind, handle, type)
    }

    fun getOpType(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getOpTypeBind, handle)
    }

    companion object {
        private const val SET_OP_TYPE_HASH = 2060089061L
        private val setOpTypeBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeParticleRandomness", "set_op_type", SET_OP_TYPE_HASH)
        }

        private const val GET_OP_TYPE_HASH = 3597061078L
        private val getOpTypeBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeParticleRandomness", "get_op_type", GET_OP_TYPE_HASH)
        }
    }
}
