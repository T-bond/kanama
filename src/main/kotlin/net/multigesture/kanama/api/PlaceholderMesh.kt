package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.AABB
import java.lang.foreign.MemorySegment

/**
 * Placeholder class for a mesh.
 *
 * Generated from Godot docs: PlaceholderMesh
 */
class PlaceholderMesh(handle: MemorySegment) : Mesh(handle) {
    /**
     * The smallest `AABB` enclosing this mesh in local space.
     *
     * Generated from Godot docs: PlaceholderMesh.set_aabb
     */
    fun setAabb(aabb: AABB) {
        ObjectCalls.ptrcallWithAABBArg(setAabbBind, handle, aabb)
    }

    companion object {
        private const val SET_AABB_HASH = 259215842L
        private val setAabbBind by lazy {
            ObjectCalls.getMethodBind("PlaceholderMesh", "set_aabb", SET_AABB_HASH)
        }
    }
}
