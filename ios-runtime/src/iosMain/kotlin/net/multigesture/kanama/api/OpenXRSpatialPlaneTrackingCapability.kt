package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: OpenXRSpatialPlaneTrackingCapability
 */
class OpenXRSpatialPlaneTrackingCapability(handle: MemorySegment) : OpenXRExtensionWrapper(handle) {
    fun isSupported(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isSupportedBind, handle)
    }

    companion object {
        fun fromHandle(handle: MemorySegment): OpenXRSpatialPlaneTrackingCapability? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): OpenXRSpatialPlaneTrackingCapability? =
            if (handle.address() == 0L) null else OpenXRSpatialPlaneTrackingCapability(handle)

        private const val IS_SUPPORTED_HASH = 2240911060L
        private val isSupportedBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialPlaneTrackingCapability", "is_supported", IS_SUPPORTED_HASH)
        }
    }
}
