package net.multigesture.kanama.types

import kotlin.math.sqrt

/**
 * A 4-component float vector. Used as the column type of [Projection] and the element type of
 * PackedVector4Array. Kanama value types are immutable snapshots.
 *
 * iOS marshalling note: at ptrcall a Vector4 is 4 `real_t` (float32 on single-precision iOS).
 */
data class Vector4(
    val x: Double,
    val y: Double,
    val z: Double,
    val w: Double,
) {
    constructor(x: Number, y: Number, z: Number, w: Number) :
        this(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())

    operator fun plus(other: Vector4): Vector4 =
        Vector4(x + other.x, y + other.y, z + other.z, w + other.w)

    operator fun minus(other: Vector4): Vector4 =
        Vector4(x - other.x, y - other.y, z - other.z, w - other.w)

    operator fun times(scale: Number): Vector4 =
        Vector4(x * scale.toDouble(), y * scale.toDouble(), z * scale.toDouble(), w * scale.toDouble())

    operator fun unaryMinus(): Vector4 = Vector4(-x, -y, -z, -w)

    fun lengthSquared(): Double = x * x + y * y + z * z + w * w

    fun length(): Double = sqrt(lengthSquared())

    companion object {
        val ZERO = Vector4(0.0, 0.0, 0.0, 0.0)
        val ONE = Vector4(1.0, 1.0, 1.0, 1.0)
    }
}
