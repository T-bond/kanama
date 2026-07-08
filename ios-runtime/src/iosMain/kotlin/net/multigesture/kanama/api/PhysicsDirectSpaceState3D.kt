package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: PhysicsDirectSpaceState3D
 */
open class PhysicsDirectSpaceState3D(handle: MemorySegment) : GodotObject(handle) {
    // No conservative instance methods emitted yet.

    // intersect_ray returns a Godot Dictionary. iOS has no Dictionary-return decode path yet (only
    // scalar/Array — see ObjectCalls.retVariantArrayBlob), so this is an iOS STUB that returns empty
    // until a dictionary-blob C-shim lands. Effect on iOS: the robot laser-clip raycast never
    // registers a hit (laser clips at max range). TODO: kanama_ios_godot_ptrcall_ret_dictionary_blob
    // + wire PhysicsRayQueryParameters3D.exclude (RID-list) at the same time.
    fun intersectRay(parameters: PhysicsRayQueryParameters3D?): Map<String, Any?> = emptyMap()

    companion object {
        fun fromHandle(handle: MemorySegment): PhysicsDirectSpaceState3D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): PhysicsDirectSpaceState3D? =
            if (handle.address() == 0L) null else PhysicsDirectSpaceState3D(handle)

        // No MethodBinds emitted yet.
    }
}
