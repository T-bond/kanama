package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Pipeline shader (used by `RenderingDevice`).
 *
 * Generated from Godot docs: RDPipelineShader
 */
open class RDPipelineShader internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): RDPipelineShader? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): RDPipelineShader? =
            if (handle.address() == 0L) null else RDPipelineShader(handle)
    }
}
