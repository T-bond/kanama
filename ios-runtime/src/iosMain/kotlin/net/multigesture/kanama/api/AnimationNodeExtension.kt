package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AnimationNodeExtension
 */
class AnimationNodeExtension(handle: MemorySegment) : AnimationNode(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AnimationNodeExtension? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AnimationNodeExtension? =
            if (handle.address() == 0L) null else AnimationNodeExtension(handle)

        // No MethodBinds emitted yet.
    }
}
