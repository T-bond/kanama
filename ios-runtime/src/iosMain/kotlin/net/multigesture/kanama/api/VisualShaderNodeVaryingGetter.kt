package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeVaryingGetter
 */
class VisualShaderNodeVaryingGetter(handle: MemorySegment) : VisualShaderNodeVarying(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeVaryingGetter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeVaryingGetter? =
            if (handle.address() == 0L) null else VisualShaderNodeVaryingGetter(handle)

        // No MethodBinds emitted yet.
    }
}
