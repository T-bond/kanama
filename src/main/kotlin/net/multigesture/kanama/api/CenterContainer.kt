package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A container that keeps child controls in its center.
 *
 * Generated from Godot docs: CenterContainer
 */
class CenterContainer(handle: MemorySegment) : Container(handle) {

    var useTopLeft: Boolean
        @JvmName("useTopLeftProperty")
        get() = isUsingTopLeft()
        @JvmName("setUseTopLeftProperty")
        set(value) = setUseTopLeft(value)

    /**
     * If `true`, centers children relative to the `CenterContainer`'s top left corner.
     *
     * Generated from Godot docs: CenterContainer.set_use_top_left
     */
    fun setUseTopLeft(enable: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setUseTopLeftBind, handle, enable)
    }

    /**
     * If `true`, centers children relative to the `CenterContainer`'s top left corner.
     *
     * Generated from Godot docs: CenterContainer.is_using_top_left
     */
    fun isUsingTopLeft(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isUsingTopLeftBind, handle)

    companion object {
        private const val BOOL_VOID_HASH = 2586408642L
        private const val NOARGS_BOOL_HASH = 36873697L

        private val setUseTopLeftBind by lazy {
            ObjectCalls.getMethodBind("CenterContainer", "set_use_top_left", BOOL_VOID_HASH)
        }

        private val isUsingTopLeftBind by lazy {
            ObjectCalls.getMethodBind("CenterContainer", "is_using_top_left", NOARGS_BOOL_HASH)
        }
    }
}
