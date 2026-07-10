package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: PlaceholderMaterial
 */
class PlaceholderMaterial(handle: MemorySegment) : Material(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): PlaceholderMaterial? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): PlaceholderMaterial? =
            if (handle.address() == 0L) null else PlaceholderMaterial(handle)

        // No MethodBinds emitted yet.
    }
}
