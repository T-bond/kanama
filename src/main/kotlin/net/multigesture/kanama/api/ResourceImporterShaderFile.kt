package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls

/**
 * Imports native GLSL shaders (not Godot shaders) as an `RDShaderFile`.
 *
 * Generated from Godot docs: ResourceImporterShaderFile
 */
class ResourceImporterShaderFile(handle: MemorySegment) : ResourceImporter(handle) {
    // No conservative instance methods emitted yet.

    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): ResourceImporterShaderFile? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): ResourceImporterShaderFile? =
            if (handle.address() == 0L) null else ResourceImporterShaderFile(handle)

        // No MethodBinds emitted yet.
    }
}
