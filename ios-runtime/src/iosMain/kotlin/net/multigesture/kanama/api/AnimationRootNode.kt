package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AnimationRootNode
 */
open class AnimationRootNode(handle: MemorySegment) : AnimationNode(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AnimationRootNode? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AnimationRootNode? =
            if (handle.address() == 0L) null else AnimationRootNode(handle)

        // No MethodBinds emitted yet.
    }
}
