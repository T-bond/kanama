package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeIf
 */
class VisualShaderNodeIf(handle: MemorySegment) : VisualShaderNode(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeIf? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeIf? =
            if (handle.address() == 0L) null else VisualShaderNodeIf(handle)

        // No MethodBinds emitted yet.
    }
}
