package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeVectorDecompose
 */
class VisualShaderNodeVectorDecompose(handle: MemorySegment) : VisualShaderNodeVectorBase(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeVectorDecompose? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeVectorDecompose? =
            if (handle.address() == 0L) null else VisualShaderNodeVectorDecompose(handle)

        // No MethodBinds emitted yet.
    }
}
