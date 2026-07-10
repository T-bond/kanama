package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: EngineProfiler
 */
class EngineProfiler(handle: MemorySegment) : RefCounted(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): EngineProfiler? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EngineProfiler? =
            if (handle.address() == 0L) null else EngineProfiler(handle)

        // No MethodBinds emitted yet.
    }
}
