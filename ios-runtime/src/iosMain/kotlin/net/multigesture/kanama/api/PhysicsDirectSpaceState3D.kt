package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: PhysicsDirectSpaceState3D
 */
open class PhysicsDirectSpaceState3D(handle: MemorySegment) : GodotObject(handle) {
    // No conservative instance methods emitted yet.

    // intersect_ray returns a Godot Dictionary, decoded via the fixed-schema raycast C-shim
    // (kanama_ios_godot_ptrcall_ret_raycast_dict). Empty map = no hit. "collider" is wrapped from the
    // raw handle into a GodotObject so scripts can `hit["collider"] as? GodotObject`.
    fun intersectRay(parameters: PhysicsRayQueryParameters3D?): Map<String, Any?> {
        val query = parameters ?: return emptyMap()
        val raw = ObjectCalls.ptrcallIntersectRay(intersectRayBind, handle, query.handle)
        if (raw.isEmpty()) return emptyMap()
        val result = raw.toMutableMap()
        (raw["collider"] as? MemorySegment)?.let { result["collider"] = GodotObject(it) }
        return result
    }

    companion object {
        fun fromHandle(handle: MemorySegment): PhysicsDirectSpaceState3D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): PhysicsDirectSpaceState3D? =
            if (handle.address() == 0L) null else PhysicsDirectSpaceState3D(handle)

        private const val INTERSECT_RAY_HASH = 3957970750L
        private val intersectRayBind by lazy {
            ObjectCalls.getMethodBind("PhysicsDirectSpaceState3D", "intersect_ray", INTERSECT_RAY_HASH)
        }

        // No MethodBinds emitted yet.
    }
}
