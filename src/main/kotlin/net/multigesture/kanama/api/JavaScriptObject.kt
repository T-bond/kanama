package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/** Reference-counted JavaScript object bridge handle. Generated from Godot docs: JavaScriptObject */
/**
 * A wrapper class for web native JavaScript objects.
 *
 * Generated from Godot docs: JavaScriptObject
 */
class JavaScriptObject internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic fun fromHandle(handle: MemorySegment): JavaScriptObject? = wrap(handle)
        internal fun wrap(handle: MemorySegment): JavaScriptObject? = if (handle.address() == 0L) null else JavaScriptObject(handle)
    }
}
