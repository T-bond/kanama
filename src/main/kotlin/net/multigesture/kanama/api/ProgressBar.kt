package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A control used for visual representation of a percentage.
 *
 * Generated from Godot docs: ProgressBar
 */
class ProgressBar(handle: MemorySegment) : Range(handle) {
    var fillMode: Int
        @JvmName("fillModeProperty")
        get() = getFillMode()
        @JvmName("setFillModeProperty")
        set(value) = setFillMode(value)

    var showPercentage: Boolean
        @JvmName("showPercentageProperty")
        get() = isPercentageShown()
        @JvmName("setShowPercentageProperty")
        set(value) = setShowPercentage(value)

    var indeterminate: Boolean
        @JvmName("indeterminateProperty")
        get() = isIndeterminate()
        @JvmName("setIndeterminateProperty")
        set(value) = setIndeterminate(value)

    var editorPreviewIndeterminate: Boolean
        @JvmName("editorPreviewIndeterminateProperty")
        get() = isEditorPreviewIndeterminateEnabled()
        @JvmName("setEditorPreviewIndeterminateProperty")
        set(value) = setEditorPreviewIndeterminate(value)

    /**
     * The fill direction. See `FillMode` for possible values.
     *
     * Generated from Godot docs: ProgressBar.set_fill_mode
     */
    fun setFillMode(mode: Int) {
        ObjectCalls.ptrcallWithIntArg(setFillModeBind, handle, mode)
    }

    /**
     * The fill direction. See `FillMode` for possible values.
     *
     * Generated from Godot docs: ProgressBar.get_fill_mode
     */
    fun getFillMode(): Int =
        ObjectCalls.ptrcallNoArgsRetInt(getFillModeBind, handle)

    /**
     * If `true`, the fill percentage is displayed on the bar.
     *
     * Generated from Godot docs: ProgressBar.set_show_percentage
     */
    fun setShowPercentage(visible: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setShowPercentageBind, handle, visible)
    }

    /**
     * If `true`, the fill percentage is displayed on the bar.
     *
     * Generated from Godot docs: ProgressBar.is_percentage_shown
     */
    fun isPercentageShown(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isPercentageShownBind, handle)

    /**
     * When set to `true`, the progress bar indicates that something is happening with an animation,
     * but does not show the fill percentage or value.
     *
     * Generated from Godot docs: ProgressBar.set_indeterminate
     */
    fun setIndeterminate(indeterminate: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setIndeterminateBind, handle, indeterminate)
    }

    /**
     * When set to `true`, the progress bar indicates that something is happening with an animation,
     * but does not show the fill percentage or value.
     *
     * Generated from Godot docs: ProgressBar.is_indeterminate
     */
    fun isIndeterminate(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isIndeterminateBind, handle)

    /**
     * If `false`, the `indeterminate` animation will be paused in the editor.
     *
     * Generated from Godot docs: ProgressBar.set_editor_preview_indeterminate
     */
    fun setEditorPreviewIndeterminate(previewIndeterminate: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setEditorPreviewIndeterminateBind, handle, previewIndeterminate)
    }

    /**
     * If `false`, the `indeterminate` animation will be paused in the editor.
     *
     * Generated from Godot docs: ProgressBar.is_editor_preview_indeterminate_enabled
     */
    fun isEditorPreviewIndeterminateEnabled(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isEditorPreviewIndeterminateEnabledBind, handle)

    companion object {
        private const val INT_VOID_HASH = 1286410249L
        private const val GET_FILL_MODE_HASH = 2455072627L
        private const val BOOL_VOID_HASH = 2586408642L
        private const val NOARGS_BOOL_HASH = 36873697L

        private val setFillModeBind by lazy { ObjectCalls.getMethodBind("ProgressBar", "set_fill_mode", INT_VOID_HASH) }
        private val getFillModeBind by lazy { ObjectCalls.getMethodBind("ProgressBar", "get_fill_mode", GET_FILL_MODE_HASH) }
        private val setShowPercentageBind by lazy {
            ObjectCalls.getMethodBind("ProgressBar", "set_show_percentage", BOOL_VOID_HASH)
        }
        private val isPercentageShownBind by lazy {
            ObjectCalls.getMethodBind("ProgressBar", "is_percentage_shown", NOARGS_BOOL_HASH)
        }
        private val setIndeterminateBind by lazy {
            ObjectCalls.getMethodBind("ProgressBar", "set_indeterminate", BOOL_VOID_HASH)
        }
        private val isIndeterminateBind by lazy {
            ObjectCalls.getMethodBind("ProgressBar", "is_indeterminate", NOARGS_BOOL_HASH)
        }
        private val setEditorPreviewIndeterminateBind by lazy {
            ObjectCalls.getMethodBind("ProgressBar", "set_editor_preview_indeterminate", BOOL_VOID_HASH)
        }
        private val isEditorPreviewIndeterminateEnabledBind by lazy {
            ObjectCalls.getMethodBind("ProgressBar", "is_editor_preview_indeterminate_enabled", NOARGS_BOOL_HASH)
        }
    }
}
