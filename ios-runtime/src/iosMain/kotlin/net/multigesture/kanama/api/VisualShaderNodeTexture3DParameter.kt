package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeTexture3DParameter
 */
class VisualShaderNodeTexture3DParameter(handle: MemorySegment) : VisualShaderNodeTextureParameter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeTexture3DParameter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeTexture3DParameter? =
            if (handle.address() == 0L) null else VisualShaderNodeTexture3DParameter(handle)

        // No MethodBinds emitted yet.
    }
}
