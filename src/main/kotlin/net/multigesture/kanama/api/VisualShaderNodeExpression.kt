package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: VisualShaderNodeExpression
 */
open class VisualShaderNodeExpression(handle: MemorySegment) : VisualShaderNodeGroupBase(handle) {
    var expression: String
        @JvmName("expressionProperty")
        get() = getExpression()
        @JvmName("setExpressionProperty")
        set(value) = setExpression(value)

    fun setExpression(expression: String) {
        ObjectCalls.ptrcallWithStringArg(setExpressionBind, handle, expression)
    }

    fun getExpression(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getExpressionBind, handle)
    }

    companion object {
        private const val SET_EXPRESSION_HASH = 83702148L
        private val setExpressionBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeExpression", "set_expression", SET_EXPRESSION_HASH)
        }

        private const val GET_EXPRESSION_HASH = 201670096L
        private val getExpressionBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeExpression", "get_expression", GET_EXPRESSION_HASH)
        }
    }
}
