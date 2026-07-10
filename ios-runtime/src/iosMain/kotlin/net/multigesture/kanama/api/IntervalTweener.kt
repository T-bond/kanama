package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: IntervalTweener
 */
class IntervalTweener(handle: MemorySegment) : Tweener(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): IntervalTweener? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): IntervalTweener? =
            if (handle.address() == 0L) null else IntervalTweener(handle)

        // No MethodBinds emitted yet.
    }
}
