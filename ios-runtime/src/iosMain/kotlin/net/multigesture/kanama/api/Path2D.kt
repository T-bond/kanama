package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: Path2D
 */
class Path2D(handle: MemorySegment) : Node2D(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): Path2D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): Path2D? =
            if (handle.address() == 0L) null else Path2D(handle)

        // No MethodBinds emitted yet.
    }
}
