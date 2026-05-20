package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A container that arranges its child controls horizontally or vertically.
 *
 * Generated from Godot docs: BoxContainer
 */
open class BoxContainer(handle: MemorySegment) : Container(handle) {

    var alignment: Long
        @JvmName("alignmentProperty")
        get() = getAlignment()
        @JvmName("setAlignmentProperty")
        set(value) = setAlignment(value)

    var vertical: Boolean
        @JvmName("verticalProperty")
        get() = isVertical()
        @JvmName("setVerticalProperty")
        set(value) = setVertical(value)

    /**
     * Adds a `Control` node to the box as a spacer. If `begin` is `true`, it will insert the `Control`
     * node in front of all other children.
     *
     * Generated from Godot docs: BoxContainer.add_spacer
     */
    fun addSpacer(begin: Boolean): Control? =
        ObjectCalls.ptrcallWithBoolArgRetObject(addSpacerBind, handle, begin).let {
            if (it.address() == 0L) null else Control(it)
        }

    /**
     * The alignment of the container's children (must be one of `ALIGNMENT_BEGIN`, `ALIGNMENT_CENTER`,
     * or `ALIGNMENT_END`).
     *
     * Generated from Godot docs: BoxContainer.set_alignment
     */
    fun setAlignment(alignment: Long) {
        ObjectCalls.ptrcallWithLongArg(setAlignmentBind, handle, alignment)
    }

    /**
     * The alignment of the container's children (must be one of `ALIGNMENT_BEGIN`, `ALIGNMENT_CENTER`,
     * or `ALIGNMENT_END`).
     *
     * Generated from Godot docs: BoxContainer.get_alignment
     */
    fun getAlignment(): Long =
        ObjectCalls.ptrcallNoArgsRetLong(getAlignmentBind, handle)

    /**
     * If `true`, the `BoxContainer` will arrange its children vertically, rather than horizontally.
     * Can't be changed when using `HBoxContainer` and `VBoxContainer`.
     *
     * Generated from Godot docs: BoxContainer.set_vertical
     */
    fun setVertical(vertical: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setVerticalBind, handle, vertical)
    }

    /**
     * If `true`, the `BoxContainer` will arrange its children vertically, rather than horizontally.
     * Can't be changed when using `HBoxContainer` and `VBoxContainer`.
     *
     * Generated from Godot docs: BoxContainer.is_vertical
     */
    fun isVertical(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isVerticalBind, handle)

    companion object {
        const val ALIGNMENT_BEGIN = 0L
        const val ALIGNMENT_CENTER = 1L
        const val ALIGNMENT_END = 2L

        private const val ADD_SPACER_HASH = 1326660695L
        private const val SET_ALIGNMENT_HASH = 2456745134L
        private const val GET_ALIGNMENT_HASH = 1915476527L
        private const val SET_VERTICAL_HASH = 2586408642L
        private const val IS_VERTICAL_HASH = 36873697L

        private val addSpacerBind by lazy {
            ObjectCalls.getMethodBind("BoxContainer", "add_spacer", ADD_SPACER_HASH)
        }

        private val setAlignmentBind by lazy {
            ObjectCalls.getMethodBind("BoxContainer", "set_alignment", SET_ALIGNMENT_HASH)
        }

        private val getAlignmentBind by lazy {
            ObjectCalls.getMethodBind("BoxContainer", "get_alignment", GET_ALIGNMENT_HASH)
        }

        private val setVerticalBind by lazy {
            ObjectCalls.getMethodBind("BoxContainer", "set_vertical", SET_VERTICAL_HASH)
        }

        private val isVerticalBind by lazy {
            ObjectCalls.getMethodBind("BoxContainer", "is_vertical", IS_VERTICAL_HASH)
        }
    }
}
