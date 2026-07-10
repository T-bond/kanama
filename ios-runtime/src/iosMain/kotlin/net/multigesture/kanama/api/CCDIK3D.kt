package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: CCDIK3D
 */
class CCDIK3D(handle: MemorySegment) : IterateIK3D(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): CCDIK3D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): CCDIK3D? =
            if (handle.address() == 0L) null else CCDIK3D(handle)

        // No MethodBinds emitted yet.
    }
}
