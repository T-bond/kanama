package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioStreamPlayback
 */
open class AudioStreamPlayback(handle: MemorySegment) : RefCounted(handle) {
    fun start(fromPos: Double = 0.0) {
        ObjectCalls.ptrcallWithDoubleArg(startBind, handle, fromPos)
    }

    fun seek(time: Double = 0.0) {
        ObjectCalls.ptrcallWithDoubleArg(seekBind, handle, time)
    }

    fun stop() {
        ObjectCalls.ptrcallNoArgs(stopBind, handle)
    }

    fun getLoopCount(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getLoopCountBind, handle)
    }

    fun getPlaybackPosition(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getPlaybackPositionBind, handle)
    }

    fun isPlaying(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isPlayingBind, handle)
    }

    companion object {
        fun fromHandle(handle: MemorySegment): AudioStreamPlayback? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioStreamPlayback? =
            if (handle.address() == 0L) null else AudioStreamPlayback(handle)

        private const val START_HASH = 1958160172L
        private val startBind by lazy {
            ObjectCalls.getMethodBind("AudioStreamPlayback", "start", START_HASH)
        }

        private const val SEEK_HASH = 1958160172L
        private val seekBind by lazy {
            ObjectCalls.getMethodBind("AudioStreamPlayback", "seek", SEEK_HASH)
        }

        private const val STOP_HASH = 3218959716L
        private val stopBind by lazy {
            ObjectCalls.getMethodBind("AudioStreamPlayback", "stop", STOP_HASH)
        }

        private const val GET_LOOP_COUNT_HASH = 3905245786L
        private val getLoopCountBind by lazy {
            ObjectCalls.getMethodBind("AudioStreamPlayback", "get_loop_count", GET_LOOP_COUNT_HASH)
        }

        private const val GET_PLAYBACK_POSITION_HASH = 1740695150L
        private val getPlaybackPositionBind by lazy {
            ObjectCalls.getMethodBind("AudioStreamPlayback", "get_playback_position", GET_PLAYBACK_POSITION_HASH)
        }

        private const val IS_PLAYING_HASH = 36873697L
        private val isPlayingBind by lazy {
            ObjectCalls.getMethodBind("AudioStreamPlayback", "is_playing", IS_PLAYING_HASH)
        }
    }
}
