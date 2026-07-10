package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: StandardMaterial3D
 */
class StandardMaterial3D(handle: MemorySegment) : BaseMaterial3D(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): StandardMaterial3D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): StandardMaterial3D? =
            if (handle.address() == 0L) null else StandardMaterial3D(handle)

        // No MethodBinds emitted yet.
    }
}
