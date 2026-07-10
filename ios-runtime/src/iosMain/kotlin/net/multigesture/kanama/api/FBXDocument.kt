package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: FBXDocument
 */
class FBXDocument(handle: MemorySegment) : GLTFDocument(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        fun fromHandle(handle: MemorySegment): FBXDocument? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): FBXDocument? =
            if (handle.address() == 0L) null else FBXDocument(handle)

        // No MethodBinds emitted yet.
    }
}
