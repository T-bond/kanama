package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeTextureSDFNormal
 */
class VisualShaderNodeTextureSDFNormal(handle: MemorySegment) : VisualShaderNode(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeTextureSDFNormal? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeTextureSDFNormal? =
            if (handle.address() == 0L) null else VisualShaderNodeTextureSDFNormal(handle)

        // No MethodBinds emitted yet.
    }
}
