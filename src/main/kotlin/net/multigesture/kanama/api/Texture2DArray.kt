package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * A single texture resource which consists of multiple, separate images. Each image has the same
 * dimensions and number of mipmap levels.
 *
 * Generated from Godot docs: Texture2DArray
 */
class Texture2DArray(handle: MemorySegment) : ImageTextureLayered(handle) {
    /**
     * Creates a placeholder version of this resource (`PlaceholderTexture2DArray`).
     *
     * Generated from Godot docs: Texture2DArray.create_placeholder
     */
    fun createPlaceholder(): Resource? {
        return Resource.wrap(ObjectCalls.ptrcallNoArgsRetObject(createPlaceholderBind, handle))
    }

    companion object {
        private const val CREATE_PLACEHOLDER_HASH = 121922552L
        private val createPlaceholderBind by lazy {
            ObjectCalls.getMethodBind("Texture2DArray", "create_placeholder", CREATE_PLACEHOLDER_HASH)
        }
    }
}
