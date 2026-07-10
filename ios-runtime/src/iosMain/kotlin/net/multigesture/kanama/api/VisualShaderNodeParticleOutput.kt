package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeParticleOutput
 */
class VisualShaderNodeParticleOutput(handle: MemorySegment) : VisualShaderNodeOutput(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeParticleOutput? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeParticleOutput? =
            if (handle.address() == 0L) null else VisualShaderNodeParticleOutput(handle)

        // No MethodBinds emitted yet.
    }
}
