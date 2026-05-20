package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A control that displays a texture.
 *
 * Generated from Godot docs: TextureRect
 */
class TextureRect(handle: MemorySegment) : Control(handle) {

    var texture: Texture2D?
        @JvmName("textureProperty")
        get() = getTexture()
        @JvmName("setTextureProperty")
        set(value) = setTexture(value)

    var expandMode: Long
        @JvmName("expandModeProperty")
        get() = getExpandMode()
        @JvmName("setExpandModeProperty")
        set(value) = setExpandMode(value)

    var stretchMode: Long
        @JvmName("stretchModeProperty")
        get() = getStretchMode()
        @JvmName("setStretchModeProperty")
        set(value) = setStretchMode(value)

    var flipH: Boolean
        @JvmName("flipHProperty")
        get() = isFlippedH()
        @JvmName("setFlipHProperty")
        set(value) = setFlipH(value)

    var flipV: Boolean
        @JvmName("flipVProperty")
        get() = isFlippedV()
        @JvmName("setFlipVProperty")
        set(value) = setFlipV(value)

    /**
     * The node's `Texture2D` resource.
     *
     * Generated from Godot docs: TextureRect.set_texture
     */
    fun setTexture(texture: Texture2D?) {
        ObjectCalls.ptrcallWithObjectArgs(setTextureBind, handle, listOf(texture?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    /**
     * The node's `Texture2D` resource.
     *
     * Generated from Godot docs: TextureRect.get_texture
     */
    fun getTexture(): Texture2D? =
        Texture2D.wrap(ObjectCalls.ptrcallNoArgsRetObject(getTextureBind, handle))

    /**
     * Defines how minimum size is determined based on the texture's size.
     *
     * Generated from Godot docs: TextureRect.set_expand_mode
     */
    fun setExpandMode(expandMode: Long) {
        ObjectCalls.ptrcallWithLongArg(setExpandModeBind, handle, expandMode)
    }

    /**
     * Defines how minimum size is determined based on the texture's size.
     *
     * Generated from Godot docs: TextureRect.get_expand_mode
     */
    fun getExpandMode(): Long =
        ObjectCalls.ptrcallNoArgsRetLong(getExpandModeBind, handle)

    /**
     * If `true`, texture is flipped horizontally.
     *
     * Generated from Godot docs: TextureRect.set_flip_h
     */
    fun setFlipH(enable: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setFlipHBind, handle, enable)
    }

    /**
     * If `true`, texture is flipped horizontally.
     *
     * Generated from Godot docs: TextureRect.is_flipped_h
     */
    fun isFlippedH(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isFlippedHBind, handle)

    /**
     * If `true`, texture is flipped vertically.
     *
     * Generated from Godot docs: TextureRect.set_flip_v
     */
    fun setFlipV(enable: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setFlipVBind, handle, enable)
    }

    /**
     * If `true`, texture is flipped vertically.
     *
     * Generated from Godot docs: TextureRect.is_flipped_v
     */
    fun isFlippedV(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isFlippedVBind, handle)

    /**
     * Controls the texture's behavior when resizing the node's bounding rectangle.
     *
     * Generated from Godot docs: TextureRect.set_stretch_mode
     */
    fun setStretchMode(stretchMode: Long) {
        ObjectCalls.ptrcallWithLongArg(setStretchModeBind, handle, stretchMode)
    }

    /**
     * Controls the texture's behavior when resizing the node's bounding rectangle.
     *
     * Generated from Godot docs: TextureRect.get_stretch_mode
     */
    fun getStretchMode(): Long =
        ObjectCalls.ptrcallNoArgsRetLong(getStretchModeBind, handle)

    companion object {
        private const val SET_TEXTURE_HASH = 4051416890L
        private const val GET_TEXTURE_HASH = 3635182373L
        private const val SET_EXPAND_MODE_HASH = 1870766882L
        private const val GET_EXPAND_MODE_HASH = 3863824733L
        private const val BOOL_VOID_HASH = 2586408642L
        private const val NOARGS_BOOL_HASH = 36873697L
        private const val SET_STRETCH_MODE_HASH = 58788729L
        private const val GET_STRETCH_MODE_HASH = 346396079L

        private val setTextureBind by lazy {
            ObjectCalls.getMethodBind("TextureRect", "set_texture", SET_TEXTURE_HASH)
        }

        private val getTextureBind by lazy {
            ObjectCalls.getMethodBind("TextureRect", "get_texture", GET_TEXTURE_HASH)
        }

        private val setExpandModeBind by lazy {
            ObjectCalls.getMethodBind("TextureRect", "set_expand_mode", SET_EXPAND_MODE_HASH)
        }

        private val getExpandModeBind by lazy {
            ObjectCalls.getMethodBind("TextureRect", "get_expand_mode", GET_EXPAND_MODE_HASH)
        }

        private val setFlipHBind by lazy {
            ObjectCalls.getMethodBind("TextureRect", "set_flip_h", BOOL_VOID_HASH)
        }

        private val isFlippedHBind by lazy {
            ObjectCalls.getMethodBind("TextureRect", "is_flipped_h", NOARGS_BOOL_HASH)
        }

        private val setFlipVBind by lazy {
            ObjectCalls.getMethodBind("TextureRect", "set_flip_v", BOOL_VOID_HASH)
        }

        private val isFlippedVBind by lazy {
            ObjectCalls.getMethodBind("TextureRect", "is_flipped_v", NOARGS_BOOL_HASH)
        }

        private val setStretchModeBind by lazy {
            ObjectCalls.getMethodBind("TextureRect", "set_stretch_mode", SET_STRETCH_MODE_HASH)
        }

        private val getStretchModeBind by lazy {
            ObjectCalls.getMethodBind("TextureRect", "get_stretch_mode", GET_STRETCH_MODE_HASH)
        }
    }
}
