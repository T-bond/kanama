package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeSDFRaymarch
 */
class VisualShaderNodeSDFRaymarch(handle: MemorySegment) : VisualShaderNode(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeSDFRaymarch? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeSDFRaymarch? =
            if (handle.address() == 0L) null else VisualShaderNodeSDFRaymarch(handle)

        // No MethodBinds emitted yet.
    }
}
