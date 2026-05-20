package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls

/**
 * Generated from Godot docs: VisualShaderNodeDeterminant
 */
class VisualShaderNodeDeterminant(handle: MemorySegment) : VisualShaderNode(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): VisualShaderNodeDeterminant? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeDeterminant? =
            if (handle.address() == 0L) null else VisualShaderNodeDeterminant(handle)

        // No MethodBinds emitted yet.
    }
}
