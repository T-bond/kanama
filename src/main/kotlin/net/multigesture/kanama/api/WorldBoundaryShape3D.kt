package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.Plane
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A 3D world boundary (half-space) shape used for physics collision.
 *
 * Generated from Godot docs: WorldBoundaryShape3D
 */
class WorldBoundaryShape3D(handle: MemorySegment) : Shape3D(handle) {
    var plane: Plane
        @JvmName("planeProperty")
        get() = getPlane()
        @JvmName("setPlaneProperty")
        set(value) = setPlane(value)

    /**
     * The `Plane` used by the `WorldBoundaryShape3D` for collision.
     *
     * Generated from Godot docs: WorldBoundaryShape3D.set_plane
     */
    fun setPlane(plane: Plane) {
        ObjectCalls.ptrcallWithPlaneArg(setPlaneBind, handle, plane)
    }

    /**
     * The `Plane` used by the `WorldBoundaryShape3D` for collision.
     *
     * Generated from Godot docs: WorldBoundaryShape3D.get_plane
     */
    fun getPlane(): Plane {
        return ObjectCalls.ptrcallNoArgsRetPlane(getPlaneBind, handle)
    }

    companion object {
        private const val SET_PLANE_HASH = 3505987427L
        private val setPlaneBind by lazy {
            ObjectCalls.getMethodBind("WorldBoundaryShape3D", "set_plane", SET_PLANE_HASH)
        }

        private const val GET_PLANE_HASH = 2753500971L
        private val getPlaneBind by lazy {
            ObjectCalls.getMethodBind("WorldBoundaryShape3D", "get_plane", GET_PLANE_HASH)
        }
    }
}
