package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Generated from Godot docs: OpenXRAndroidThreadSettingsExtension
 */
class OpenXRAndroidThreadSettingsExtension(handle: MemorySegment) : OpenXRExtensionWrapper(handle) {
    fun setApplicationThreadType(threadType: Long, threadId: Long = 0L): Boolean {
        return ObjectCalls.ptrcallWithLongAndUInt32ArgRetBool(setApplicationThreadTypeBind, handle, threadType, threadId)
    }

    companion object {
        private const val SET_APPLICATION_THREAD_TYPE_HASH = 1558751158L
        private val setApplicationThreadTypeBind by lazy {
            ObjectCalls.getMethodBind("OpenXRAndroidThreadSettingsExtension", "set_application_thread_type", SET_APPLICATION_THREAD_TYPE_HASH)
        }
    }
}
