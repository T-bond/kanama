package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeScreenUVToSDF
 */
class VisualShaderNodeScreenUVToSDF(handle: MemorySegment) : VisualShaderNode(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeScreenUVToSDF? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeScreenUVToSDF? =
            if (handle.address() == 0L) null else VisualShaderNodeScreenUVToSDF(handle)

        // No MethodBinds emitted yet.
    }
}
