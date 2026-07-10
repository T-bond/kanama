package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeParticleRingEmitter
 */
class VisualShaderNodeParticleRingEmitter(handle: MemorySegment) : VisualShaderNodeParticleEmitter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeParticleRingEmitter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeParticleRingEmitter? =
            if (handle.address() == 0L) null else VisualShaderNodeParticleRingEmitter(handle)

        // No MethodBinds emitted yet.
    }
}
