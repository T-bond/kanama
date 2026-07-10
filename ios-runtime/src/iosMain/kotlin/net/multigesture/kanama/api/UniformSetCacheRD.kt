package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: UniformSetCacheRD
 */
class UniformSetCacheRD(handle: MemorySegment) : GodotObject(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): UniformSetCacheRD? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): UniformSetCacheRD? =
            if (handle.address() == 0L) null else UniformSetCacheRD(handle)

        // No MethodBinds emitted yet.
    }
}
