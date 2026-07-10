package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AnimationNodeOutput
 */
class AnimationNodeOutput(handle: MemorySegment) : AnimationNode(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AnimationNodeOutput? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AnimationNodeOutput? =
            if (handle.address() == 0L) null else AnimationNodeOutput(handle)

        // No MethodBinds emitted yet.
    }
}
