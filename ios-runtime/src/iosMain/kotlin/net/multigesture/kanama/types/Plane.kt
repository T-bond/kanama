package net.multigesture.kanama.types

/**
 * A plane in 3D space: a unit [normal] and the signed distance [d] from the origin along it.
 * Kanama value types are immutable snapshots.
 *
 * iOS marshalling note: at ptrcall a Plane is 4 `real_t` (float32 on single-precision iOS) —
 * normal.x, normal.y, normal.z, d.
 */
data class Plane(
    val normal: Vector3,
    val d: Double,
) {
    constructor(x: Number, y: Number, z: Number, d: Number) :
        this(Vector3(x, y, z), d.toDouble())

    companion object {
        val ZERO = Plane(Vector3.ZERO, 0.0)
    }
}
