package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Awaits a specified signal.
 *
 * Generated from Godot docs: AwaitTweener
 */
open class AwaitTweener internal constructor(handle: MemorySegment) : Tweener(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): AwaitTweener? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AwaitTweener? =
            if (handle.address() == 0L) null else AwaitTweener(handle)
    }
}
