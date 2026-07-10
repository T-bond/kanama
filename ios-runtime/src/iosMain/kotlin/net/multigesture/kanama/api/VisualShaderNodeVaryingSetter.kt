package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeVaryingSetter
 */
class VisualShaderNodeVaryingSetter(handle: MemorySegment) : VisualShaderNodeVarying(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeVaryingSetter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeVaryingSetter? =
            if (handle.address() == 0L) null else VisualShaderNodeVaryingSetter(handle)

        // No MethodBinds emitted yet.
    }
}
