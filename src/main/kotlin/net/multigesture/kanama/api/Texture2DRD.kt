package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.RID
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Texture for 2D that is bound to a texture created on the `RenderingDevice`.
 *
 * Generated from Godot docs: Texture2DRD
 */
class Texture2DRD(handle: MemorySegment) : Texture2D(handle) {
    var textureRdRid: RID
        @JvmName("textureRdRidProperty")
        get() = getTextureRdRid()
        @JvmName("setTextureRdRidProperty")
        set(value) = setTextureRdRid(value)

    /**
     * The RID of the texture object created on the `RenderingDevice`.
     *
     * Generated from Godot docs: Texture2DRD.set_texture_rd_rid
     */
    fun setTextureRdRid(textureRdRid: RID) {
        ObjectCalls.ptrcallWithRIDArg(setTextureRdRidBind, handle, textureRdRid)
    }

    /**
     * The RID of the texture object created on the `RenderingDevice`.
     *
     * Generated from Godot docs: Texture2DRD.get_texture_rd_rid
     */
    fun getTextureRdRid(): RID {
        return ObjectCalls.ptrcallNoArgsRetRID(getTextureRdRidBind, handle)
    }

    companion object {
        private const val SET_TEXTURE_RD_RID_HASH = 2722037293L
        private val setTextureRdRidBind by lazy {
            ObjectCalls.getMethodBind("Texture2DRD", "set_texture_rd_rid", SET_TEXTURE_RD_RID_HASH)
        }

        private const val GET_TEXTURE_RD_RID_HASH = 2944877500L
        private val getTextureRdRidBind by lazy {
            ObjectCalls.getMethodBind("Texture2DRD", "get_texture_rd_rid", GET_TEXTURE_RD_RID_HASH)
        }
    }
}
