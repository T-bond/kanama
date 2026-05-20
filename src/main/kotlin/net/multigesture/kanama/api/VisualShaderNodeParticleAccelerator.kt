package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: VisualShaderNodeParticleAccelerator
 */
class VisualShaderNodeParticleAccelerator(handle: MemorySegment) : VisualShaderNode(handle) {
    var mode: Long
        @JvmName("modeProperty")
        get() = getMode()
        @JvmName("setModeProperty")
        set(value) = setMode(value)

    fun setMode(mode: Long) {
        ObjectCalls.ptrcallWithLongArg(setModeBind, handle, mode)
    }

    fun getMode(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getModeBind, handle)
    }

    companion object {
        private const val SET_MODE_HASH = 3457585749L
        private val setModeBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeParticleAccelerator", "set_mode", SET_MODE_HASH)
        }

        private const val GET_MODE_HASH = 2660365633L
        private val getModeBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeParticleAccelerator", "get_mode", GET_MODE_HASH)
        }
    }
}
