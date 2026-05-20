package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls

/**
 * Represents a single manually placed probe for dynamic object lighting with `LightmapGI`.
 *
 * Generated from Godot docs: LightmapProbe
 */
class LightmapProbe(handle: MemorySegment) : Node3D(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): LightmapProbe? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): LightmapProbe? =
            if (handle.address() == 0L) null else LightmapProbe(handle)

        // No MethodBinds emitted yet.
    }
}
