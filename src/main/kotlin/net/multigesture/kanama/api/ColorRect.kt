package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.Color
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A control that displays a solid color rectangle.
 *
 * Generated from Godot docs: ColorRect
 */
class ColorRect(handle: MemorySegment) : Control(handle) {
    var color: Color
        @JvmName("colorProperty")
        get() = getColor()
        @JvmName("setColorProperty")
        set(value) = setColor(value)

    /**
     * The fill color of the rectangle.
     *
     * Generated from Godot docs: ColorRect.set_color
     */
    fun setColor(color: Color) {
        ObjectCalls.ptrcallWithColorArg(setColorBind, handle, color)
    }

    /**
     * The fill color of the rectangle.
     *
     * Generated from Godot docs: ColorRect.get_color
     */
    fun getColor(): Color =
        ObjectCalls.ptrcallNoArgsRetColor(getColorBind, handle)

    companion object {
        private const val COLOR_VOID_HASH = 2920490490L
        private const val NOARGS_COLOR_HASH = 3444240500L

        private val setColorBind by lazy {
            ObjectCalls.getMethodBind("ColorRect", "set_color", COLOR_VOID_HASH)
        }

        private val getColorBind by lazy {
            ObjectCalls.getMethodBind("ColorRect", "get_color", NOARGS_COLOR_HASH)
        }
    }
}
