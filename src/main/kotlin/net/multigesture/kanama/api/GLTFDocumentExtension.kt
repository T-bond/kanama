package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/** Resource base for glTF document extensions. Generated from Godot docs: GLTFDocumentExtension */
open class GLTFDocumentExtension internal constructor(handle: MemorySegment) : Resource(handle) {
    companion object {
        @JvmStatic fun fromHandle(handle: MemorySegment): GLTFDocumentExtension? = wrap(handle)
        internal fun wrap(handle: MemorySegment): GLTFDocumentExtension? =
            if (handle.address() == 0L) null else GLTFDocumentExtension(handle)
    }
}
