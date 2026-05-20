package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Omnidirectional light, such as a light bulb or a candle.
 *
 * Generated from Godot docs: OmniLight3D
 */
class OmniLight3D(handle: MemorySegment) : Light3D(handle) {
    var omniShadowMode: Long
        @JvmName("omniShadowModeProperty")
        get() = getShadowMode()
        @JvmName("setOmniShadowModeProperty")
        set(value) = setShadowMode(value)

    fun setShadowMode(mode: Long) {
        ObjectCalls.ptrcallWithLongArg(setShadowModeBind, handle, mode)
    }

    fun getShadowMode(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getShadowModeBind, handle)
    }

    companion object {
        private const val SET_SHADOW_MODE_HASH = 121862228L
        private val setShadowModeBind by lazy {
            ObjectCalls.getMethodBind("OmniLight3D", "set_shadow_mode", SET_SHADOW_MODE_HASH)
        }

        private const val GET_SHADOW_MODE_HASH = 4181586331L
        private val getShadowModeBind by lazy {
            ObjectCalls.getMethodBind("OmniLight3D", "get_shadow_mode", GET_SHADOW_MODE_HASH)
        }
    }
}
