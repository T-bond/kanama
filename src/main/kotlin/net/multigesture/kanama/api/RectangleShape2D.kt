package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.Vector2
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A 2D rectangle shape used for physics collision.
 *
 * Generated from Godot docs: RectangleShape2D
 */
class RectangleShape2D(handle: MemorySegment) : Shape2D(handle) {
    var size: Vector2
        @JvmName("sizeProperty")
        get() = getSize()
        @JvmName("setSizeProperty")
        set(value) = setSize(value)

    /**
     * The rectangle's width and height.
     *
     * Generated from Godot docs: RectangleShape2D.set_size
     */
    fun setSize(size: Vector2) {
        ObjectCalls.ptrcallWithVector2Arg(setSizeBind, handle, size)
    }

    /**
     * The rectangle's width and height.
     *
     * Generated from Godot docs: RectangleShape2D.get_size
     */
    fun getSize(): Vector2 {
        return ObjectCalls.ptrcallNoArgsRetVector2(getSizeBind, handle)
    }

    companion object {
        private const val SET_SIZE_HASH = 743155724L
        private val setSizeBind by lazy {
            ObjectCalls.getMethodBind("RectangleShape2D", "set_size", SET_SIZE_HASH)
        }

        private const val GET_SIZE_HASH = 3341600327L
        private val getSizeBind by lazy {
            ObjectCalls.getMethodBind("RectangleShape2D", "get_size", GET_SIZE_HASH)
        }
    }
}
