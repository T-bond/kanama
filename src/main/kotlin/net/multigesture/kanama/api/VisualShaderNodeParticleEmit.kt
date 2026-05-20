package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: VisualShaderNodeParticleEmit
 */
class VisualShaderNodeParticleEmit(handle: MemorySegment) : VisualShaderNode(handle) {
    var flags: Long
        @JvmName("flagsProperty")
        get() = getFlags()
        @JvmName("setFlagsProperty")
        set(value) = setFlags(value)

    fun setFlags(flags: Long) {
        ObjectCalls.ptrcallWithLongArg(setFlagsBind, handle, flags)
    }

    fun getFlags(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getFlagsBind, handle)
    }

    companion object {
        private const val SET_FLAGS_HASH = 3960756792L
        private val setFlagsBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeParticleEmit", "set_flags", SET_FLAGS_HASH)
        }

        private const val GET_FLAGS_HASH = 171277835L
        private val getFlagsBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeParticleEmit", "get_flags", GET_FLAGS_HASH)
        }
    }
}
