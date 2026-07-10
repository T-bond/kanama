package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: ShaderGlobalsOverride
 */
class ShaderGlobalsOverride(handle: MemorySegment) : Node(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): ShaderGlobalsOverride? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): ShaderGlobalsOverride? =
            if (handle.address() == 0L) null else ShaderGlobalsOverride(handle)

        // No MethodBinds emitted yet.
    }
}
