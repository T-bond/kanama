package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: VisualShaderNodeOuterProduct
 */
class VisualShaderNodeOuterProduct(handle: MemorySegment) : VisualShaderNode(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): VisualShaderNodeOuterProduct? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): VisualShaderNodeOuterProduct? =
            if (handle.address() == 0L) null else VisualShaderNodeOuterProduct(handle)

        // No MethodBinds emitted yet.
    }
}
