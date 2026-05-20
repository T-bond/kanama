package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Efficiently packs and serializes `Array` or `Dictionary`.
 *
 * Generated from Godot docs: PackedDataContainer
 */
class PackedDataContainer(handle: MemorySegment) : Resource(handle) {
    /**
     * Packs the given container into a binary representation. The `value` must be either `Array` or
     * `Dictionary`, any other type will result in invalid data error. Note: Subsequent calls to this
     * method will overwrite the existing data.
     *
     * Generated from Godot docs: PackedDataContainer.pack
     */
    fun pack(value: Any?): Long {
        return ObjectCalls.ptrcallWithVariantArgRetLong(packBind, handle, value)
    }

    /**
     * Returns the size of the packed container (see `Array.size` and `Dictionary.size`).
     *
     * Generated from Godot docs: PackedDataContainer.size
     */
    fun size(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(sizeBind, handle)
    }

    companion object {
        private const val PACK_HASH = 966674026L
        private val packBind by lazy {
            ObjectCalls.getMethodBind("PackedDataContainer", "pack", PACK_HASH)
        }

        private const val SIZE_HASH = 3905245786L
        private val sizeBind by lazy {
            ObjectCalls.getMethodBind("PackedDataContainer", "size", SIZE_HASH)
        }
    }
}
