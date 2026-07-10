package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: EditorResourcePreview
 */
class EditorResourcePreview(handle: MemorySegment) : Node(handle) {
    fun addPreviewGenerator(generator: EditorResourcePreviewGenerator?) {
        ObjectCalls.ptrcallWithObjectArgs(addPreviewGeneratorBind, handle, listOf(generator?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    fun removePreviewGenerator(generator: EditorResourcePreviewGenerator?) {
        ObjectCalls.ptrcallWithObjectArgs(removePreviewGeneratorBind, handle, listOf(generator?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    fun checkForInvalidation(path: String) {
        ObjectCalls.ptrcallWithStringArg(checkForInvalidationBind, handle, path)
    }

    object Signals {
        const val previewInvalidated: String = "preview_invalidated"
    }

    companion object {
        fun fromHandle(handle: MemorySegment): EditorResourcePreview? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorResourcePreview? =
            if (handle.address() == 0L) null else EditorResourcePreview(handle)

        private const val ADD_PREVIEW_GENERATOR_HASH = 332288124L
        private val addPreviewGeneratorBind by lazy {
            ObjectCalls.getMethodBind("EditorResourcePreview", "add_preview_generator", ADD_PREVIEW_GENERATOR_HASH)
        }

        private const val REMOVE_PREVIEW_GENERATOR_HASH = 332288124L
        private val removePreviewGeneratorBind by lazy {
            ObjectCalls.getMethodBind("EditorResourcePreview", "remove_preview_generator", REMOVE_PREVIEW_GENERATOR_HASH)
        }

        private const val CHECK_FOR_INVALIDATION_HASH = 83702148L
        private val checkForInvalidationBind by lazy {
            ObjectCalls.getMethodBind("EditorResourcePreview", "check_for_invalidation", CHECK_FOR_INVALIDATION_HASH)
        }
    }
}
