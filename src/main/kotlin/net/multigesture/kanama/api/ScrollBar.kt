package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Abstract base class for scrollbars.
 *
 * Generated from Godot docs: ScrollBar
 */
open class ScrollBar(handle: MemorySegment) : Range(handle) {
    var customStep: Double
        @JvmName("customStepProperty")
        get() = getCustomStep()
        @JvmName("setCustomStepProperty")
        set(value) = setCustomStep(value)

    /**
     * Overrides the step used when clicking increment and decrement buttons or when using arrow keys
     * when the `ScrollBar` is focused.
     *
     * Generated from Godot docs: ScrollBar.set_custom_step
     */
    fun setCustomStep(step: Double) { ObjectCalls.ptrcallWithDoubleArg(setCustomStepBind, handle, step) }
    /**
     * Overrides the step used when clicking increment and decrement buttons or when using arrow keys
     * when the `ScrollBar` is focused.
     *
     * Generated from Godot docs: ScrollBar.get_custom_step
     */
    fun getCustomStep(): Double = ObjectCalls.ptrcallNoArgsRetDouble(getCustomStepBind, handle)

    companion object {
        private const val FLOAT_VOID_HASH = 373806689L
        private const val NOARGS_FLOAT_HASH = 1740695150L

        private val setCustomStepBind by lazy { ObjectCalls.getMethodBind("ScrollBar", "set_custom_step", FLOAT_VOID_HASH) }
        private val getCustomStepBind by lazy { ObjectCalls.getMethodBind("ScrollBar", "get_custom_step", NOARGS_FLOAT_HASH) }
    }
}
