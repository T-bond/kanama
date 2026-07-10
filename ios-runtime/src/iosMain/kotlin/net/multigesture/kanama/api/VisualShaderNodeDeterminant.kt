package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeDeterminant
 */
class VisualShaderNodeDeterminant(handle: MemorySegment) : VisualShaderNode(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeDeterminant? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeDeterminant? =
            if (handle.address() == 0L) null else VisualShaderNodeDeterminant(handle)

        // No MethodBinds emitted yet.
    }
}
