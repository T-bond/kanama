package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A container that preserves the proportions of its child controls.
 *
 * Generated from Godot docs: AspectRatioContainer
 */
class AspectRatioContainer(handle: MemorySegment) : Container(handle) {
    var ratio: Double
        @JvmName("ratioProperty")
        get() = getRatio()
        @JvmName("setRatioProperty")
        set(value) = setRatio(value)

    var stretchMode: Long
        @JvmName("stretchModeProperty")
        get() = getStretchMode()
        @JvmName("setStretchModeProperty")
        set(value) = setStretchMode(value)

    var alignmentHorizontal: Long
        @JvmName("alignmentHorizontalProperty")
        get() = getAlignmentHorizontal()
        @JvmName("setAlignmentHorizontalProperty")
        set(value) = setAlignmentHorizontal(value)

    var alignmentVertical: Long
        @JvmName("alignmentVerticalProperty")
        get() = getAlignmentVertical()
        @JvmName("setAlignmentVerticalProperty")
        set(value) = setAlignmentVertical(value)

    /**
     * The aspect ratio to enforce on child controls. This is the width divided by the height. The
     * ratio depends on the `stretch_mode`.
     *
     * Generated from Godot docs: AspectRatioContainer.set_ratio
     */
    fun setRatio(ratio: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setRatioBind, handle, ratio)
    }

    /**
     * The aspect ratio to enforce on child controls. This is the width divided by the height. The
     * ratio depends on the `stretch_mode`.
     *
     * Generated from Godot docs: AspectRatioContainer.get_ratio
     */
    fun getRatio(): Double =
        ObjectCalls.ptrcallNoArgsRetDouble(getRatioBind, handle)

    /**
     * The stretch mode used to align child controls.
     *
     * Generated from Godot docs: AspectRatioContainer.set_stretch_mode
     */
    fun setStretchMode(stretchMode: Long) {
        ObjectCalls.ptrcallWithLongArg(setStretchModeBind, handle, stretchMode)
    }

    /**
     * The stretch mode used to align child controls.
     *
     * Generated from Godot docs: AspectRatioContainer.get_stretch_mode
     */
    fun getStretchMode(): Long =
        ObjectCalls.ptrcallNoArgsRetLong(getStretchModeBind, handle)

    /**
     * Specifies the horizontal relative position of child controls.
     *
     * Generated from Godot docs: AspectRatioContainer.set_alignment_horizontal
     */
    fun setAlignmentHorizontal(alignmentHorizontal: Long) {
        ObjectCalls.ptrcallWithLongArg(setAlignmentHorizontalBind, handle, alignmentHorizontal)
    }

    /**
     * Specifies the horizontal relative position of child controls.
     *
     * Generated from Godot docs: AspectRatioContainer.get_alignment_horizontal
     */
    fun getAlignmentHorizontal(): Long =
        ObjectCalls.ptrcallNoArgsRetLong(getAlignmentHorizontalBind, handle)

    /**
     * Specifies the vertical relative position of child controls.
     *
     * Generated from Godot docs: AspectRatioContainer.set_alignment_vertical
     */
    fun setAlignmentVertical(alignmentVertical: Long) {
        ObjectCalls.ptrcallWithLongArg(setAlignmentVerticalBind, handle, alignmentVertical)
    }

    /**
     * Specifies the vertical relative position of child controls.
     *
     * Generated from Godot docs: AspectRatioContainer.get_alignment_vertical
     */
    fun getAlignmentVertical(): Long =
        ObjectCalls.ptrcallNoArgsRetLong(getAlignmentVerticalBind, handle)

    companion object {
        private const val FLOAT_VOID_HASH = 373806689L
        private const val NOARGS_FLOAT_HASH = 1740695150L
        private const val SET_STRETCH_MODE_HASH = 1876743467L
        private const val GET_STRETCH_MODE_HASH = 3416449033L
        private const val SET_ALIGNMENT_MODE_HASH = 2147829016L
        private const val GET_ALIGNMENT_MODE_HASH = 3838875429L

        private val setRatioBind by lazy { ObjectCalls.getMethodBind("AspectRatioContainer", "set_ratio", FLOAT_VOID_HASH) }
        private val getRatioBind by lazy { ObjectCalls.getMethodBind("AspectRatioContainer", "get_ratio", NOARGS_FLOAT_HASH) }
        private val setStretchModeBind by lazy {
            ObjectCalls.getMethodBind("AspectRatioContainer", "set_stretch_mode", SET_STRETCH_MODE_HASH)
        }
        private val getStretchModeBind by lazy {
            ObjectCalls.getMethodBind("AspectRatioContainer", "get_stretch_mode", GET_STRETCH_MODE_HASH)
        }
        private val setAlignmentHorizontalBind by lazy {
            ObjectCalls.getMethodBind("AspectRatioContainer", "set_alignment_horizontal", SET_ALIGNMENT_MODE_HASH)
        }
        private val getAlignmentHorizontalBind by lazy {
            ObjectCalls.getMethodBind("AspectRatioContainer", "get_alignment_horizontal", GET_ALIGNMENT_MODE_HASH)
        }
        private val setAlignmentVerticalBind by lazy {
            ObjectCalls.getMethodBind("AspectRatioContainer", "set_alignment_vertical", SET_ALIGNMENT_MODE_HASH)
        }
        private val getAlignmentVerticalBind by lazy {
            ObjectCalls.getMethodBind("AspectRatioContainer", "get_alignment_vertical", GET_ALIGNMENT_MODE_HASH)
        }
    }
}
