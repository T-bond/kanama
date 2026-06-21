package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VSlider
 */
class VSlider(handle: MemorySegment) : Slider(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VSlider? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VSlider? =
            if (handle.address() == 0L) null else VSlider(handle)

        // No MethodBinds emitted yet.
    }
}
