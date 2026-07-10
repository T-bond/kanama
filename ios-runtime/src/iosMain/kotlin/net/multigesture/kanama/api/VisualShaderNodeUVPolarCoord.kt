package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeUVPolarCoord
 */
class VisualShaderNodeUVPolarCoord(handle: MemorySegment) : VisualShaderNode(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeUVPolarCoord? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeUVPolarCoord? =
            if (handle.address() == 0L) null else VisualShaderNodeUVPolarCoord(handle)

        // No MethodBinds emitted yet.
    }
}
