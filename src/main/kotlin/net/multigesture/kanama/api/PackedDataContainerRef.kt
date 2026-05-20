package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * An internal class used by `PackedDataContainer` to pack nested arrays and dictionaries.
 *
 * Generated from Godot docs: PackedDataContainerRef
 */
class PackedDataContainerRef(handle: MemorySegment) : RefCounted(handle) {
    /**
     * Returns the size of the packed container (see `Array.size` and `Dictionary.size`).
     *
     * Generated from Godot docs: PackedDataContainerRef.size
     */
    fun size(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(sizeBind, handle)
    }

    companion object {
        private const val SIZE_HASH = 3905245786L
        private val sizeBind by lazy {
            ObjectCalls.getMethodBind("PackedDataContainerRef", "size", SIZE_HASH)
        }
    }
}
