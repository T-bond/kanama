package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*
import net.multigesture.kanama.types.Vector3

/**
 * Generated from Godot docs: Geometry3D
 */
object Geometry3D {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("Geometry3D")
    }

    fun getClosestPointToSegment(point: Vector3, s1: Vector3, s2: Vector3): Vector3 {
        return ObjectCalls.ptrcallWithThreeVector3ArgsRetVector3(getClosestPointToSegmentBind, singleton, point, s1, s2)
    }

    fun getClosestPointToSegmentUncapped(point: Vector3, s1: Vector3, s2: Vector3): Vector3 {
        return ObjectCalls.ptrcallWithThreeVector3ArgsRetVector3(getClosestPointToSegmentUncappedBind, singleton, point, s1, s2)
    }

    fun getTriangleBarycentricCoords(point: Vector3, a: Vector3, b: Vector3, c: Vector3): Vector3 {
        return ObjectCalls.ptrcallWithFourVector3ArgsRetVector3(getTriangleBarycentricCoordsBind, singleton, point, a, b, c)
    }

    fun fromHandle(handle: MemorySegment): Geometry3D? =
        wrap(handle)

    internal fun wrap(handle: MemorySegment): Geometry3D? =
        if (handle.address() == 0L) null else this

    private const val GET_CLOSEST_POINT_TO_SEGMENT_HASH = 2168193209L
    private val getClosestPointToSegmentBind by lazy {
        ObjectCalls.getMethodBind("Geometry3D", "get_closest_point_to_segment", GET_CLOSEST_POINT_TO_SEGMENT_HASH)
    }

    private const val GET_CLOSEST_POINT_TO_SEGMENT_UNCAPPED_HASH = 2168193209L
    private val getClosestPointToSegmentUncappedBind by lazy {
        ObjectCalls.getMethodBind("Geometry3D", "get_closest_point_to_segment_uncapped", GET_CLOSEST_POINT_TO_SEGMENT_UNCAPPED_HASH)
    }

    private const val GET_TRIANGLE_BARYCENTRIC_COORDS_HASH = 1362048029L
    private val getTriangleBarycentricCoordsBind by lazy {
        ObjectCalls.getMethodBind("Geometry3D", "get_triangle_barycentric_coords", GET_TRIANGLE_BARYCENTRIC_COORDS_HASH)
    }
}
