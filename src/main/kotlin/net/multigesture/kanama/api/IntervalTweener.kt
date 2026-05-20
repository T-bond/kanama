package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Creates an idle interval in a `Tween` animation.
 *
 * Generated from Godot docs: IntervalTweener
 */
class IntervalTweener internal constructor(handle: MemorySegment) : Tweener(handle) {
    companion object {
        internal fun wrap(handle: MemorySegment): IntervalTweener? =
            if (handle.address() == 0L) null else IntervalTweener(handle)
    }
}
