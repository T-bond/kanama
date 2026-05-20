package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.Color
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A rectangular box for designing UIs.
 *
 * Generated from Godot docs: ReferenceRect
 */
class ReferenceRect(handle: MemorySegment) : Control(handle) {
    var borderColor: Color
        @JvmName("borderColorProperty")
        get() = getBorderColor()
        @JvmName("setBorderColorProperty")
        set(value) = setBorderColor(value)

    var borderWidth: Double
        @JvmName("borderWidthProperty")
        get() = getBorderWidth()
        @JvmName("setBorderWidthProperty")
        set(value) = setBorderWidth(value)

    var editorOnly: Boolean
        @JvmName("editorOnlyProperty")
        get() = getEditorOnly()
        @JvmName("setEditorOnlyProperty")
        set(value) = setEditorOnly(value)

    /**
     * Sets the border color of the `ReferenceRect`.
     *
     * Generated from Godot docs: ReferenceRect.get_border_color
     */
    fun getBorderColor(): Color =
        ObjectCalls.ptrcallNoArgsRetColor(getBorderColorBind, handle)

    /**
     * Sets the border color of the `ReferenceRect`.
     *
     * Generated from Godot docs: ReferenceRect.set_border_color
     */
    fun setBorderColor(color: Color) {
        ObjectCalls.ptrcallWithColorArg(setBorderColorBind, handle, color)
    }

    /**
     * Sets the border width of the `ReferenceRect`. The border grows both inwards and outwards with
     * respect to the rectangle box.
     *
     * Generated from Godot docs: ReferenceRect.get_border_width
     */
    fun getBorderWidth(): Double =
        ObjectCalls.ptrcallNoArgsRetDouble(getBorderWidthBind, handle)

    /**
     * Sets the border width of the `ReferenceRect`. The border grows both inwards and outwards with
     * respect to the rectangle box.
     *
     * Generated from Godot docs: ReferenceRect.set_border_width
     */
    fun setBorderWidth(width: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setBorderWidthBind, handle, width)
    }

    /**
     * If `true`, the `ReferenceRect` will only be visible while in editor. Otherwise, `ReferenceRect`
     * will be visible in the running project.
     *
     * Generated from Godot docs: ReferenceRect.get_editor_only
     */
    fun getEditorOnly(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(getEditorOnlyBind, handle)

    /**
     * If `true`, the `ReferenceRect` will only be visible while in editor. Otherwise, `ReferenceRect`
     * will be visible in the running project.
     *
     * Generated from Godot docs: ReferenceRect.set_editor_only
     */
    fun setEditorOnly(enabled: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setEditorOnlyBind, handle, enabled)
    }

    companion object {
        private const val COLOR_VOID_HASH = 2920490490L
        private const val NOARGS_COLOR_HASH = 3444240500L
        private const val FLOAT_VOID_HASH = 373806689L
        private const val NOARGS_FLOAT_HASH = 1740695150L
        private const val BOOL_VOID_HASH = 2586408642L
        private const val NOARGS_BOOL_HASH = 36873697L

        private val getBorderColorBind by lazy {
            ObjectCalls.getMethodBind("ReferenceRect", "get_border_color", NOARGS_COLOR_HASH)
        }

        private val setBorderColorBind by lazy {
            ObjectCalls.getMethodBind("ReferenceRect", "set_border_color", COLOR_VOID_HASH)
        }

        private val getBorderWidthBind by lazy {
            ObjectCalls.getMethodBind("ReferenceRect", "get_border_width", NOARGS_FLOAT_HASH)
        }

        private val setBorderWidthBind by lazy {
            ObjectCalls.getMethodBind("ReferenceRect", "set_border_width", FLOAT_VOID_HASH)
        }

        private val getEditorOnlyBind by lazy {
            ObjectCalls.getMethodBind("ReferenceRect", "get_editor_only", NOARGS_BOOL_HASH)
        }

        private val setEditorOnlyBind by lazy {
            ObjectCalls.getMethodBind("ReferenceRect", "set_editor_only", BOOL_VOID_HASH)
        }
    }
}
