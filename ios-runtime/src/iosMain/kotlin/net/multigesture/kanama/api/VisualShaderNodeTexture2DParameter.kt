package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeTexture2DParameter
 */
class VisualShaderNodeTexture2DParameter(handle: MemorySegment) : VisualShaderNodeTextureParameter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeTexture2DParameter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeTexture2DParameter? =
            if (handle.address() == 0L) null else VisualShaderNodeTexture2DParameter(handle)

        // No MethodBinds emitted yet.
    }
}
