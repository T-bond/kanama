package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioEffectInstance
 */
open class AudioEffectInstance(handle: MemorySegment) : RefCounted(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AudioEffectInstance? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AudioEffectInstance? =
            if (handle.address() == 0L) null else AudioEffectInstance(handle)

        // No MethodBinds emitted yet.
    }
}
