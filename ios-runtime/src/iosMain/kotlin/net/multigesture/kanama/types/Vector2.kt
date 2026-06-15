package net.multigesture.kanama.types

import net.multigesture.kanama.binding.runtime.BuiltinCalls
import kotlin.math.atan2
import kotlin.math.sqrt

data class Vector2(
    val x: Double,
    val y: Double,
) {
    constructor(x: Number, y: Number) : this(x.toDouble(), y.toDouble())

    operator fun plus(other: Vector2): Vector2 =
        Vector2(x + other.x, y + other.y)

    operator fun minus(other: Vector2): Vector2 =
        Vector2(x - other.x, y - other.y)

    operator fun times(scale: Number): Vector2 =
        Vector2(x * scale.toDouble(), y * scale.toDouble())

    operator fun div(scale: Number): Vector2 =
        Vector2(x / scale.toDouble(), y / scale.toDouble())

    operator fun unaryMinus(): Vector2 =
        Vector2(-x, -y)

    fun lengthSquared(): Double =
        x * x + y * y

    fun length(): Double =
        sqrt(lengthSquared())

    fun angle(): Double =
        atan2(y, x)

    fun withX(value: Number): Vector2 = Vector2(value, y)

    fun withY(value: Number): Vector2 = Vector2(x, value)

    /**
     * Returns this vector rotated by [angle] radians, computed by Godot via the value-type
     * builtin call path (so the rotation direction matches the engine exactly).
     */
    fun rotated(angle: Double): Vector2 =
        fromFloat32(BuiltinCalls.call(rotatedBind, toFloat32(), 2, listOf(
            BuiltinCalls.BArg.Real(angle),
        )))

    private fun toFloat32(): FloatArray =
        floatArrayOf(x.toFloat(), y.toFloat())

    companion object {
        val ZERO = Vector2(0.0, 0.0)
        val ONE = Vector2(1.0, 1.0)

        private val rotatedBind by lazy {
            BuiltinCalls.getBuiltinMethod(BuiltinCalls.VT_VECTOR2, "rotated", 2544004089L)
        }

        private fun fromFloat32(c: FloatArray): Vector2 =
            Vector2(c[0].toDouble(), c[1].toDouble())
    }
}
