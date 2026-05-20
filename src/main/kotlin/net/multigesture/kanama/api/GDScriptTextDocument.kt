package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Generated shell wrapper from Godot API metadata: GDScriptTextDocument.
 */
open class GDScriptTextDocument internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): GDScriptTextDocument? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): GDScriptTextDocument? =
            if (handle.address() == 0L) null else GDScriptTextDocument(handle)
    }
}
