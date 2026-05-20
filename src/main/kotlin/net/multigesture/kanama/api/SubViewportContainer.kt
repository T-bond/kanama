package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A container used for displaying the contents of a `SubViewport`.
 *
 * Generated from Godot docs: SubViewportContainer
 */
class SubViewportContainer(handle: MemorySegment) : Container(handle) {
    var stretch: Boolean
        @JvmName("stretchProperty")
        get() = isStretchEnabled()
        @JvmName("setStretchProperty")
        set(value) = setStretch(value)

    var stretchShrink: Int
        @JvmName("stretchShrinkProperty")
        get() = getStretchShrink()
        @JvmName("setStretchShrinkProperty")
        set(value) = setStretchShrink(value)

    var mouseTarget: Boolean
        @JvmName("mouseTargetProperty")
        get() = isMouseTargetEnabled()
        @JvmName("setMouseTargetProperty")
        set(value) = setMouseTarget(value)

    /**
     * If `true`, the sub-viewport will be automatically resized to the control's size. Note: If
     * `true`, this will prohibit changing `SubViewport.size` of its children manually.
     *
     * Generated from Godot docs: SubViewportContainer.set_stretch
     */
    fun setStretch(enable: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setStretchBind, handle, enable)
    }

    /**
     * If `true`, the sub-viewport will be automatically resized to the control's size. Note: If
     * `true`, this will prohibit changing `SubViewport.size` of its children manually.
     *
     * Generated from Godot docs: SubViewportContainer.is_stretch_enabled
     */
    fun isStretchEnabled(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isStretchEnabledBind, handle)

    /**
     * Divides the sub-viewport's effective resolution by this value while preserving its scale. This
     * can be used to speed up rendering. For example, a 1280×720 sub-viewport with `stretch_shrink`
     * set to `2` will be rendered at 640×360 while occupying the same size in the container. Note:
     * `stretch` must be `true` for this property to work.
     *
     * Generated from Godot docs: SubViewportContainer.set_stretch_shrink
     */
    fun setStretchShrink(amount: Int) {
        ObjectCalls.ptrcallWithIntArg(setStretchShrinkBind, handle, amount)
    }

    /**
     * Divides the sub-viewport's effective resolution by this value while preserving its scale. This
     * can be used to speed up rendering. For example, a 1280×720 sub-viewport with `stretch_shrink`
     * set to `2` will be rendered at 640×360 while occupying the same size in the container. Note:
     * `stretch` must be `true` for this property to work.
     *
     * Generated from Godot docs: SubViewportContainer.get_stretch_shrink
     */
    fun getStretchShrink(): Int =
        ObjectCalls.ptrcallNoArgsRetInt(getStretchShrinkBind, handle)

    /**
     * Configure, if either the `SubViewportContainer` or alternatively the `Control` nodes of its
     * `SubViewport` children should be available as targets of mouse-related functionalities, like
     * identifying the drop target in drag-and-drop operations or cursor shape of hovered `Control`
     * node. If `false`, the `Control` nodes inside its `SubViewport` children are considered as
     * targets. If `true`, the `SubViewportContainer` itself will be considered as a target.
     *
     * Generated from Godot docs: SubViewportContainer.set_mouse_target
     */
    fun setMouseTarget(amount: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setMouseTargetBind, handle, amount)
    }

    /**
     * Configure, if either the `SubViewportContainer` or alternatively the `Control` nodes of its
     * `SubViewport` children should be available as targets of mouse-related functionalities, like
     * identifying the drop target in drag-and-drop operations or cursor shape of hovered `Control`
     * node. If `false`, the `Control` nodes inside its `SubViewport` children are considered as
     * targets. If `true`, the `SubViewportContainer` itself will be considered as a target.
     *
     * Generated from Godot docs: SubViewportContainer.is_mouse_target_enabled
     */
    fun isMouseTargetEnabled(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isMouseTargetEnabledBind, handle)

    companion object {
        private const val BOOL_VOID_HASH = 2586408642L
        private const val NOARGS_BOOL_A_HASH = 36873697L
        private const val NOARGS_BOOL_B_HASH = 2240911060L
        private const val INT_VOID_HASH = 1286410249L
        private const val NOARGS_INT_HASH = 3905245786L

        private val setStretchBind by lazy { ObjectCalls.getMethodBind("SubViewportContainer", "set_stretch", BOOL_VOID_HASH) }
        private val isStretchEnabledBind by lazy {
            ObjectCalls.getMethodBind("SubViewportContainer", "is_stretch_enabled", NOARGS_BOOL_A_HASH)
        }
        private val setStretchShrinkBind by lazy {
            ObjectCalls.getMethodBind("SubViewportContainer", "set_stretch_shrink", INT_VOID_HASH)
        }
        private val getStretchShrinkBind by lazy {
            ObjectCalls.getMethodBind("SubViewportContainer", "get_stretch_shrink", NOARGS_INT_HASH)
        }
        private val setMouseTargetBind by lazy {
            ObjectCalls.getMethodBind("SubViewportContainer", "set_mouse_target", BOOL_VOID_HASH)
        }
        private val isMouseTargetEnabledBind by lazy {
            ObjectCalls.getMethodBind("SubViewportContainer", "is_mouse_target_enabled", NOARGS_BOOL_B_HASH)
        }
    }
}
