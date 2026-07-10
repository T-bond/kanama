package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: OpenXRSpatialCapabilityConfigurationQrCode
 */
class OpenXRSpatialCapabilityConfigurationQrCode(handle: MemorySegment) : OpenXRSpatialCapabilityConfigurationBaseHeader(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): OpenXRSpatialCapabilityConfigurationQrCode? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): OpenXRSpatialCapabilityConfigurationQrCode? =
            if (handle.address() == 0L) null else OpenXRSpatialCapabilityConfigurationQrCode(handle)

        // No MethodBinds emitted yet.
    }
}
