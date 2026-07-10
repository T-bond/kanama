package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: EditorVCSInterface
 */
class EditorVCSInterface(handle: MemorySegment) : GodotObject(handle) {
    fun popupError(msg: String) {
        ObjectCalls.ptrcallWithStringArg(popupErrorBind, handle, msg)
    }

    companion object {
        const val CHANGE_TYPE_NEW: Long = 0L
        const val CHANGE_TYPE_MODIFIED: Long = 1L
        const val CHANGE_TYPE_RENAMED: Long = 2L
        const val CHANGE_TYPE_DELETED: Long = 3L
        const val CHANGE_TYPE_TYPECHANGE: Long = 4L
        const val CHANGE_TYPE_UNMERGED: Long = 5L
        const val TREE_AREA_COMMIT: Long = 0L
        const val TREE_AREA_STAGED: Long = 1L
        const val TREE_AREA_UNSTAGED: Long = 2L

        fun fromHandle(handle: MemorySegment): EditorVCSInterface? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorVCSInterface? =
            if (handle.address() == 0L) null else EditorVCSInterface(handle)

        private const val POPUP_ERROR_HASH = 83702148L
        private val popupErrorBind by lazy {
            ObjectCalls.getMethodBind("EditorVCSInterface", "popup_error", POPUP_ERROR_HASH)
        }
    }
}
