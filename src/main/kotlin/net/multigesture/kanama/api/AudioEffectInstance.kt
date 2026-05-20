package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Manipulates the audio it receives for a given effect.
 *
 * Generated from Godot docs: AudioEffectInstance
 */
open class AudioEffectInstance internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): AudioEffectInstance? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioEffectInstance? =
            if (handle.address() == 0L) null else AudioEffectInstance(handle)
    }
}
