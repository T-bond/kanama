package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: VisualShaderNodeVectorFunc
 */
class VisualShaderNodeVectorFunc(handle: MemorySegment) : VisualShaderNodeVectorBase(handle) {
    var function: Long
        @JvmName("functionProperty")
        get() = getFunction()
        @JvmName("setFunctionProperty")
        set(value) = setFunction(value)

    fun setFunction(func: Long) {
        ObjectCalls.ptrcallWithLongArg(setFunctionBind, handle, func)
    }

    fun getFunction(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getFunctionBind, handle)
    }

    companion object {
        private const val SET_FUNCTION_HASH = 629964457L
        private val setFunctionBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeVectorFunc", "set_function", SET_FUNCTION_HASH)
        }

        private const val GET_FUNCTION_HASH = 4047776843L
        private val getFunctionBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeVectorFunc", "get_function", GET_FUNCTION_HASH)
        }
    }
}
