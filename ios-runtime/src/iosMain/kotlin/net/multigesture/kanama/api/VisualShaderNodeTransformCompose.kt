package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeTransformCompose
 */
class VisualShaderNodeTransformCompose(handle: MemorySegment) : VisualShaderNode(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeTransformCompose? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeTransformCompose? =
            if (handle.address() == 0L) null else VisualShaderNodeTransformCompose(handle)

        // No MethodBinds emitted yet.
    }
}
