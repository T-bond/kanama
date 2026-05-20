package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Generated from Godot docs: OpenXRSpatialPlaneTrackingCapability
 */
class OpenXRSpatialPlaneTrackingCapability(handle: MemorySegment) : OpenXRExtensionWrapper(handle) {
    fun isSupported(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isSupportedBind, handle)
    }

    companion object {
        private const val IS_SUPPORTED_HASH = 2240911060L
        private val isSupportedBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialPlaneTrackingCapability", "is_supported", IS_SUPPORTED_HASH)
        }
    }
}
