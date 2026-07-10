package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AnimationNodeBlend3
 */
class AnimationNodeBlend3(handle: MemorySegment) : AnimationNodeSync(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AnimationNodeBlend3? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AnimationNodeBlend3? =
            if (handle.address() == 0L) null else AnimationNodeBlend3(handle)

        // No MethodBinds emitted yet.
    }
}
