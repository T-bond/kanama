package net.multigesture.kanama.types

import net.multigesture.kanama.binding.runtime.BuiltinCalls

/**
 * A unit quaternion representing 3D rotation as (x, y, z, w). Kanama value types are
 * immutable snapshots.
 *
 * iOS marshalling note: at ptrcall a Quaternion is 4 `real_t` (float32 on
 * single-precision iOS) in order [x, y, z, w] — POD passthrough. Engine-computed value
 * methods (e.g. [inverse]) route through the BuiltinCalls value-type call path.
 */
data class Quaternion(
    val x: Double,
    val y: Double,
    val z: Double,
    val w: Double,
) {
    constructor(x: Number, y: Number, z: Number, w: Number) :
        this(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())

    // Match GDScript/C# `==`: signed zero equal (-0.0 == 0.0), NaN reflexive. See
    // wrapper-coverage-roadmap.md. hashCode canonicalizes signed zero so equal quaternions hash equal.
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Quaternion) return false
        return (x == other.x || (x.isNaN() && other.x.isNaN())) &&
            (y == other.y || (y.isNaN() && other.y.isNaN())) &&
            (z == other.z || (z.isNaN() && other.z.isNaN())) &&
            (w == other.w || (w.isNaN() && other.w.isNaN()))
    }

    override fun hashCode(): Int {
        var result = (x + 0.0).hashCode()
        result = 31 * result + (y + 0.0).hashCode()
        result = 31 * result + (z + 0.0).hashCode()
        result = 31 * result + (w + 0.0).hashCode()
        return result
    }

    /** Godot `Quaternion.is_equal_approx`: per-component fuzzy compare (CMP_EPSILON tolerance). */
    fun isEqualApprox(other: Quaternion): Boolean =
        isEqualApprox(x, other.x) && isEqualApprox(y, other.y) &&
            isEqualApprox(z, other.z) && isEqualApprox(w, other.w)

    /**
     * Returns the inverse of this quaternion, computed by Godot (conjugate / length², so it
     * matches the engine even for non-unit quaternions). For a unit quaternion this is the
     * conjugate (negated x/y/z).
     */
    fun inverse(): Quaternion =
        fromFloat32(BuiltinCalls.callNoArgsFloat32(inverseBind, toFloat32()))

    /**
     * Spherically interpolates toward [to] by [weight] (0..1), computed by Godot so the
     * shortest-arc handling and normalization match the engine exactly. Both quaternions
     * are assumed normalized (matches Godot Quaternion.slerp).
     */
    fun slerp(to: Quaternion, weight: Double): Quaternion =
        fromFloat32(BuiltinCalls.call(slerpBind, toFloat32(), 4, listOf(
            BuiltinCalls.BArg.Floats(BuiltinCalls.PT_QUATERNION, to.toFloat32()),
            BuiltinCalls.BArg.Real(weight),
        )))

    private fun toFloat32(): FloatArray =
        floatArrayOf(x.toFloat(), y.toFloat(), z.toFloat(), w.toFloat())

    companion object {
        val IDENTITY = Quaternion(0.0, 0.0, 0.0, 1.0)

        private val inverseBind by lazy {
            BuiltinCalls.getBuiltinMethod(BuiltinCalls.VT_QUATERNION, "inverse", 4274879941L)
        }
        private val slerpBind by lazy {
            BuiltinCalls.getBuiltinMethod(BuiltinCalls.VT_QUATERNION, "slerp", 1773590316L)
        }
        private val fromEulerBind by lazy {
            BuiltinCalls.getBuiltinMethod(BuiltinCalls.VT_QUATERNION, "from_euler", 4053467903L)
        }

        /**
         * Returns the rotation quaternion for [euler] (radians, Godot's default YXZ order),
         * computed by Godot. `from_euler` is a *static* builtin, so the call passes an empty base.
         */
        fun fromEuler(euler: Vector3): Quaternion =
            fromFloat32(BuiltinCalls.call(fromEulerBind, floatArrayOf(), 4, listOf(
                BuiltinCalls.BArg.Floats(
                    BuiltinCalls.PT_VECTOR3,
                    floatArrayOf(euler.x.toFloat(), euler.y.toFloat(), euler.z.toFloat()),
                ),
            )))

        private fun fromFloat32(c: FloatArray): Quaternion =
            Quaternion(c[0].toDouble(), c[1].toDouble(), c[2].toDouble(), c[3].toDouble())
    }
}
