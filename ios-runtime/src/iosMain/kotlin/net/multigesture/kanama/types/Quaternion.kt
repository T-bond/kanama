package net.multigesture.kanama.types

/**
 * A unit quaternion representing 3D rotation as (x, y, z, w). Kanama value types are
 * immutable snapshots.
 *
 * iOS marshalling note: at ptrcall a Quaternion is 4 `real_t` (float32 on
 * single-precision iOS) in order [x, y, z, w] — POD passthrough.
 */
data class Quaternion(
    val x: Double,
    val y: Double,
    val z: Double,
    val w: Double,
) {
    constructor(x: Number, y: Number, z: Number, w: Number) :
        this(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())

    companion object {
        val IDENTITY = Quaternion(0.0, 0.0, 0.0, 1.0)
    }
}
