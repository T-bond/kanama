package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Base class for script language integrations.
 *
 * Generated from Godot docs: ScriptLanguage
 */
open class ScriptLanguage internal constructor(handle: MemorySegment) : GodotObject(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): ScriptLanguage? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): ScriptLanguage? =
            if (handle.address() == 0L) null else ScriptLanguage(handle)
    }
}
