package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Generated from Godot docs: OpenXRSpatialCapabilityConfigurationAnchor
 */
class OpenXRSpatialCapabilityConfigurationAnchor(handle: MemorySegment) : OpenXRSpatialCapabilityConfigurationBaseHeader(handle) {
    fun getEnabledComponents(): List<Long> {
        return ObjectCalls.ptrcallNoArgsRetPackedInt64List(getEnabledComponentsBind, handle)
    }

    companion object {
        private const val GET_ENABLED_COMPONENTS_HASH = 235988956L
        private val getEnabledComponentsBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialCapabilityConfigurationAnchor", "get_enabled_components", GET_ENABLED_COMPONENTS_HASH)
        }
    }
}
