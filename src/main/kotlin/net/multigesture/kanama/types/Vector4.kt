package net.multigesture.kanama.types

import kotlin.math.sqrt

/**
 * A 4D vector using floating-point coordinates. Kanama value types are immutable snapshots; assign
 * a new value back to the Godot property after changing components.
 *
 * Generated from Godot docs: Vector4
 */
data class Vector4(
    /**
     * The vector's X component. Also accessible by using the index position `[0]`.
     *
     * Generated from Godot docs: Vector4.x
     */
    val x: real_t,
    /**
     * The vector's Y component. Also accessible by using the index position `[1]`.
     *
     * Generated from Godot docs: Vector4.y
     */
    val y: real_t,
    /**
     * The vector's Z component. Also accessible by using the index position `[2]`.
     *
     * Generated from Godot docs: Vector4.z
     */
    val z: real_t,
    /**
     * The vector's W component. Also accessible by using the index position `[3]`.
     *
     * Generated from Godot docs: Vector4.w
     */
    val w: real_t,
) {
    constructor(x: Number, y: Number, z: Number, w: Number) :
        this(
            GodotReal.fromNumber(x),
            GodotReal.fromNumber(y),
            GodotReal.fromNumber(z),
            GodotReal.fromNumber(w),
        )

    operator fun plus(other: Vector4): Vector4 = Vector4(x + other.x, y + other.y, z + other.z, w + other.w)
    operator fun minus(other: Vector4): Vector4 = Vector4(x - other.x, y - other.y, z - other.z, w - other.w)
    operator fun times(scale: Number): Vector4 =
        Vector4(
            x.toDouble() * scale.toDouble(),
            y.toDouble() * scale.toDouble(),
            z.toDouble() * scale.toDouble(),
            w.toDouble() * scale.toDouble(),
        )
    operator fun unaryMinus(): Vector4 = Vector4(-x, -y, -z, -w)

    /**
     * Returns the squared length (squared magnitude) of this vector. This method runs faster than
     * `length`, so prefer it if you need to compare vectors or need the squared distance for some
     * formula.
     *
     * Generated from Godot docs: Vector4.length_squared
     */
    fun lengthSquared(): Double = (x * x + y * y + z * z + w * w).toDouble()
    /**
     * Returns the length (magnitude) of this vector.
     *
     * Generated from Godot docs: Vector4.length
     */
    fun length(): Double = sqrt(lengthSquared())
    /**
     * Returns the dot product of this vector and `with`.
     *
     * Generated from Godot docs: Vector4.dot
     */
    fun dot(other: Vector4): Double = (x * other.x + y * other.y + z * other.z + w * other.w).toDouble()

    companion object {
        /**
         * Zero vector, a vector with all components set to `0`.
         *
         * Generated from Godot docs: Vector4.ZERO
         */
        val ZERO = Vector4(0f, 0f, 0f, 0f)
        /**
         * One vector, a vector with all components set to `1`.
         *
         * Generated from Godot docs: Vector4.ONE
         */
        val ONE = Vector4(1f, 1f, 1f, 1f)
    }
}
