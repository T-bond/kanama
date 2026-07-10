package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AnimationNodeAdd3
 */
class AnimationNodeAdd3(handle: MemorySegment) : AnimationNodeSync(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): AnimationNodeAdd3? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AnimationNodeAdd3? =
            if (handle.address() == 0L) null else AnimationNodeAdd3(handle)

        // No MethodBinds emitted yet.
    }
}
