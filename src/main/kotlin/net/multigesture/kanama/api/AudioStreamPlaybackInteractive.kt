package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Generated from Godot docs: AudioStreamPlaybackInteractive
 */
class AudioStreamPlaybackInteractive(handle: MemorySegment) : AudioStreamPlayback(handle) {
    fun switchToClipByName(clipName: String) {
        ObjectCalls.ptrcallWithStringNameArg(switchToClipByNameBind, handle, clipName)
    }

    fun switchToClip(clipIndex: Int) {
        ObjectCalls.ptrcallWithIntArg(switchToClipBind, handle, clipIndex)
    }

    fun getCurrentClipIndex(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getCurrentClipIndexBind, handle)
    }

    companion object {
        private const val SWITCH_TO_CLIP_BY_NAME_HASH = 3304788590L
        private val switchToClipByNameBind by lazy {
            ObjectCalls.getMethodBind("AudioStreamPlaybackInteractive", "switch_to_clip_by_name", SWITCH_TO_CLIP_BY_NAME_HASH)
        }

        private const val SWITCH_TO_CLIP_HASH = 1286410249L
        private val switchToClipBind by lazy {
            ObjectCalls.getMethodBind("AudioStreamPlaybackInteractive", "switch_to_clip", SWITCH_TO_CLIP_HASH)
        }

        private const val GET_CURRENT_CLIP_INDEX_HASH = 3905245786L
        private val getCurrentClipIndexBind by lazy {
            ObjectCalls.getMethodBind("AudioStreamPlaybackInteractive", "get_current_clip_index", GET_CURRENT_CLIP_INDEX_HASH)
        }
    }
}
