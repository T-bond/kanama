package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A snippet of shader code to be included in a `Shader` with `#include`.
 *
 * Generated from Godot docs: ShaderInclude
 */
class ShaderInclude(handle: MemorySegment) : Resource(handle) {
    var code: String
        @JvmName("codeProperty")
        get() = getCode()
        @JvmName("setCodeProperty")
        set(value) = setCode(value)

    /**
     * Returns the code of the shader include file. The returned text is what the user has written, not
     * the full generated code used internally.
     *
     * Generated from Godot docs: ShaderInclude.set_code
     */
    fun setCode(code: String) {
        ObjectCalls.ptrcallWithStringArg(setCodeBind, handle, code)
    }

    /**
     * Returns the code of the shader include file. The returned text is what the user has written, not
     * the full generated code used internally.
     *
     * Generated from Godot docs: ShaderInclude.get_code
     */
    fun getCode(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getCodeBind, handle)
    }

    companion object {
        private const val SET_CODE_HASH = 83702148L
        private val setCodeBind by lazy {
            ObjectCalls.getMethodBind("ShaderInclude", "set_code", SET_CODE_HASH)
        }

        private const val GET_CODE_HASH = 201670096L
        private val getCodeBind by lazy {
            ObjectCalls.getMethodBind("ShaderInclude", "get_code", GET_CODE_HASH)
        }
    }
}
