package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: OpenXRSpatialCapabilityConfigurationAnchor
 */
class OpenXRSpatialCapabilityConfigurationAnchor(handle: MemorySegment) : OpenXRSpatialCapabilityConfigurationBaseHeader(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): OpenXRSpatialCapabilityConfigurationAnchor? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): OpenXRSpatialCapabilityConfigurationAnchor? =
            if (handle.address() == 0L) null else OpenXRSpatialCapabilityConfigurationAnchor(handle)

        // No MethodBinds emitted yet.
    }
}
