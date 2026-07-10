package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: OpenXRSpatialCapabilityConfigurationMicroQrCode
 */
class OpenXRSpatialCapabilityConfigurationMicroQrCode(handle: MemorySegment) : OpenXRSpatialCapabilityConfigurationBaseHeader(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): OpenXRSpatialCapabilityConfigurationMicroQrCode? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): OpenXRSpatialCapabilityConfigurationMicroQrCode? =
            if (handle.address() == 0L) null else OpenXRSpatialCapabilityConfigurationMicroQrCode(handle)

        // No MethodBinds emitted yet.
    }
}
