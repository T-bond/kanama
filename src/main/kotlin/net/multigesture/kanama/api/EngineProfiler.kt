package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Base class for creating custom profilers.
 *
 * Generated from Godot docs: EngineProfiler
 */
open class EngineProfiler internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): EngineProfiler? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EngineProfiler? =
            if (handle.address() == 0L) null else EngineProfiler(handle)
    }
}
