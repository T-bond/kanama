package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Playback class used for resampled `AudioStream`s.
 *
 * Generated from Godot docs: AudioStreamPlaybackResampled
 */
open class AudioStreamPlaybackResampled(handle: MemorySegment) : AudioStreamPlayback(handle) {
    /**
     * Called when an `AudioStream` is played. Clears the cubic interpolation history and starts mixing
     * by calling `_mix_resampled`.
     *
     * Generated from Godot docs: AudioStreamPlaybackResampled.begin_resample
     */
    fun beginResample() {
        ObjectCalls.ptrcallNoArgs(beginResampleBind, handle)
    }

    companion object {
        private const val BEGIN_RESAMPLE_HASH = 3218959716L
        private val beginResampleBind by lazy {
            ObjectCalls.getMethodBind("AudioStreamPlaybackResampled", "begin_resample", BEGIN_RESAMPLE_HASH)
        }
    }
}
