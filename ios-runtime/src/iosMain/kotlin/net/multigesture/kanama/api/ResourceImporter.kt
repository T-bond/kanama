package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: ResourceImporter
 */
open class ResourceImporter(handle: MemorySegment) : RefCounted(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        const val IMPORT_ORDER_DEFAULT: Long = 0L
        const val IMPORT_ORDER_SCENE: Long = 100L

        fun fromHandle(handle: MemorySegment): ResourceImporter? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): ResourceImporter? =
            if (handle.address() == 0L) null else ResourceImporter(handle)

        // No MethodBinds emitted yet.
    }
}
