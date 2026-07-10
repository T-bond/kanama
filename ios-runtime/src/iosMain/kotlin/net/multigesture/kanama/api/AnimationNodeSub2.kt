package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AnimationNodeSub2
 */
class AnimationNodeSub2(handle: MemorySegment) : AnimationNodeSync(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AnimationNodeSub2? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AnimationNodeSub2? =
            if (handle.address() == 0L) null else AnimationNodeSub2(handle)

        // No MethodBinds emitted yet.
    }
}
