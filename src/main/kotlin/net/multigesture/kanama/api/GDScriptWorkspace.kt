package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Generated shell wrapper from Godot API metadata: GDScriptWorkspace.
 */
open class GDScriptWorkspace internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): GDScriptWorkspace? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): GDScriptWorkspace? =
            if (handle.address() == 0L) null else GDScriptWorkspace(handle)
    }
}
