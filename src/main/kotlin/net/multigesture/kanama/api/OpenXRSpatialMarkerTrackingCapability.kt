package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Generated from Godot docs: OpenXRSpatialMarkerTrackingCapability
 */
class OpenXRSpatialMarkerTrackingCapability(handle: MemorySegment) : OpenXRExtensionWrapper(handle) {
    fun isQrcodeSupported(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isQrcodeSupportedBind, handle)
    }

    fun isMicroQrcodeSupported(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isMicroQrcodeSupportedBind, handle)
    }

    fun isArucoSupported(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isArucoSupportedBind, handle)
    }

    fun isAprilTagSupported(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isAprilTagSupportedBind, handle)
    }

    companion object {
        private const val IS_QRCODE_SUPPORTED_HASH = 2240911060L
        private val isQrcodeSupportedBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialMarkerTrackingCapability", "is_qrcode_supported", IS_QRCODE_SUPPORTED_HASH)
        }

        private const val IS_MICRO_QRCODE_SUPPORTED_HASH = 2240911060L
        private val isMicroQrcodeSupportedBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialMarkerTrackingCapability", "is_micro_qrcode_supported", IS_MICRO_QRCODE_SUPPORTED_HASH)
        }

        private const val IS_ARUCO_SUPPORTED_HASH = 2240911060L
        private val isArucoSupportedBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialMarkerTrackingCapability", "is_aruco_supported", IS_ARUCO_SUPPORTED_HASH)
        }

        private const val IS_APRIL_TAG_SUPPORTED_HASH = 2240911060L
        private val isAprilTagSupportedBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialMarkerTrackingCapability", "is_april_tag_supported", IS_APRIL_TAG_SUPPORTED_HASH)
        }
    }
}
