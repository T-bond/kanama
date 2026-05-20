package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Plugin for adding custom converters from one resource format to another in the editor resource
 * picker context menu; for example, converting a `StandardMaterial3D` to a `ShaderMaterial`.
 *
 * Generated from Godot docs: EditorResourceConversionPlugin
 */
open class EditorResourceConversionPlugin internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): EditorResourceConversionPlugin? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorResourceConversionPlugin? =
            if (handle.address() == 0L) null else EditorResourceConversionPlugin(handle)
    }
}
