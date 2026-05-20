package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Six square textures representing the faces of a cube. Commonly used as a skybox.
 *
 * Generated from Godot docs: Cubemap
 */
class Cubemap(handle: MemorySegment) : ImageTextureLayered(handle) {
    /**
     * Creates a placeholder version of this resource (`PlaceholderCubemap`).
     *
     * Generated from Godot docs: Cubemap.create_placeholder
     */
    fun createPlaceholder(): Resource? {
        return Resource.wrap(ObjectCalls.ptrcallNoArgsRetObject(createPlaceholderBind, handle))
    }

    companion object {
        private const val CREATE_PLACEHOLDER_HASH = 121922552L
        private val createPlaceholderBind by lazy {
            ObjectCalls.getMethodBind("Cubemap", "create_placeholder", CREATE_PLACEHOLDER_HASH)
        }
    }
}
