package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Manages toast notifications within the editor.
 *
 * Generated from Godot docs: EditorToaster
 */
class EditorToaster(handle: MemorySegment) : HBoxContainer(handle) {
    /**
     * Pushes a toast notification to the editor for display.
     *
     * Generated from Godot docs: EditorToaster.push_toast
     */
    fun pushToast(message: String, severity: Long = 0L, tooltip: String = "") {
        ObjectCalls.ptrcallWithStringLongStringArgs(pushToastBind, handle, message, severity, tooltip)
    }

    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): EditorToaster? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorToaster? =
            if (handle.address() == 0L) null else EditorToaster(handle)

        private const val PUSH_TOAST_HASH = 1813923476L
        private val pushToastBind by lazy {
            ObjectCalls.getMethodBind("EditorToaster", "push_toast", PUSH_TOAST_HASH)
        }
    }
}
