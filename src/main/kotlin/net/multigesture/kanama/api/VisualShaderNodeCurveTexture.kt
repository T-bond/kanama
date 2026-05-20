package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: VisualShaderNodeCurveTexture
 */
class VisualShaderNodeCurveTexture(handle: MemorySegment) : VisualShaderNodeResizableBase(handle) {
    var texture: CurveTexture?
        @JvmName("textureProperty")
        get() = getTexture()
        @JvmName("setTextureProperty")
        set(value) = setTexture(value)

    fun setTexture(texture: CurveTexture?) {
        ObjectCalls.ptrcallWithObjectArgs(setTextureBind, handle, listOf(texture?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    fun getTexture(): CurveTexture? {
        return CurveTexture.wrap(ObjectCalls.ptrcallNoArgsRetObject(getTextureBind, handle))
    }

    companion object {
        private const val SET_TEXTURE_HASH = 181872837L
        private val setTextureBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeCurveTexture", "set_texture", SET_TEXTURE_HASH)
        }

        private const val GET_TEXTURE_HASH = 2800800579L
        private val getTextureBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeCurveTexture", "get_texture", GET_TEXTURE_HASH)
        }
    }
}
