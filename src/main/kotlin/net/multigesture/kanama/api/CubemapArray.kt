package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * An array of `Cubemap`s, stored together and with a single reference.
 *
 * Generated from Godot docs: CubemapArray
 */
class CubemapArray(handle: MemorySegment) : ImageTextureLayered(handle) {
    /**
     * Creates a placeholder version of this resource (`PlaceholderCubemapArray`).
     *
     * Generated from Godot docs: CubemapArray.create_placeholder
     */
    fun createPlaceholder(): Resource? {
        return Resource.wrap(ObjectCalls.ptrcallNoArgsRetObject(createPlaceholderBind, handle))
    }

    companion object {
        private const val CREATE_PLACEHOLDER_HASH = 121922552L
        private val createPlaceholderBind by lazy {
            ObjectCalls.getMethodBind("CubemapArray", "create_placeholder", CREATE_PLACEHOLDER_HASH)
        }
    }
}
