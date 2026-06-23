package net.multigesture.kanama.types

import net.multigesture.kanama.binding.runtime.BuiltinCalls

/**
 * A 3×3 matrix for 3D rotation and scale, as three column axes (x, y, z). Kanama value
 * types are immutable snapshots; assign a new value back to the Godot property after
 * changing components.
 *
 * iOS marshalling note: at ptrcall a Basis is 9 `real_t` (float32 on single-precision
 * iOS) in column-major order — `[x.x, y.x, z.x, x.y, y.y, z.y, x.z, y.z, z.z]` — laid
 * out by the generated ObjectCalls helpers. Engine-computed value methods (e.g.
 * [inverse]) route through the BuiltinCalls value-type call path.
 */
data class Basis(
    val x: Vector3,
    val y: Vector3,
    val z: Vector3,
) {
    /** Returns a copy with the x/y/z axis replaced (matches desktop Basis.withX/withY/withZ). */
    fun withX(value: Vector3): Basis = Basis(value, y, z)
    fun withY(value: Vector3): Basis = Basis(x, value, z)
    fun withZ(value: Vector3): Basis = Basis(x, y, value)

    /** Returns the inverse of this basis. Computed by Godot. */
    fun inverse(): Basis =
        fromFloat32(BuiltinCalls.callNoArgsFloat32(inverseBind, toFloat32()))

    /** Returns the transpose of this basis (rows and columns swapped). */
    fun transposed(): Basis =
        fromFloat32(BuiltinCalls.callNoArgsFloat32(transposedBind, toFloat32()))

    /** Returns this basis with its axes orthogonalized and normalized (Gram-Schmidt). */
    fun orthonormalized(): Basis =
        fromFloat32(BuiltinCalls.callNoArgsFloat32(orthonormalizedBind, toFloat32()))

    /**
     * Returns a copy of this basis scaled by [scale] (each row multiplied by the matching
     * [scale] component). IDENTITY scaled by (sx,sy,sz) is diag(sx,sy,sz).
     */
    fun scaled(scale: Vector3): Basis =
        fromFloat32(BuiltinCalls.call(scaledBind, toFloat32(), 9, listOf(
            BuiltinCalls.BArg.Floats(
                BuiltinCalls.PT_VECTOR3,
                floatArrayOf(scale.x.toFloat(), scale.y.toFloat(), scale.z.toFloat()),
            ),
        )))

    /**
     * Returns the determinant of this basis, computed by Godot (scalar `real_t` return
     * decoded to Double). A negative determinant means the basis flips orientation.
     */
    fun determinant(): Double =
        BuiltinCalls.callScalar(determinantBind, toFloat32())

    // Column-major 9 float32, matching the ObjectCalls Basis ptrcall layout.
    private fun toFloat32(): FloatArray =
        floatArrayOf(
            x.x.toFloat(), y.x.toFloat(), z.x.toFloat(),
            x.y.toFloat(), y.y.toFloat(), z.y.toFloat(),
            x.z.toFloat(), y.z.toFloat(), z.z.toFloat(),
        )

    companion object {
        val IDENTITY = Basis(
            Vector3(1.0, 0.0, 0.0),
            Vector3(0.0, 1.0, 0.0),
            Vector3(0.0, 0.0, 1.0),
        )

        // All no-arg->Self Basis builtin methods share this signature-shape hash; the name
        // selects the method (inverse / transposed / orthonormalized).
        private val inverseBind by lazy {
            BuiltinCalls.getBuiltinMethod(BuiltinCalls.VT_BASIS, "inverse", 594669093L)
        }
        private val transposedBind by lazy {
            BuiltinCalls.getBuiltinMethod(BuiltinCalls.VT_BASIS, "transposed", 594669093L)
        }
        private val orthonormalizedBind by lazy {
            BuiltinCalls.getBuiltinMethod(BuiltinCalls.VT_BASIS, "orthonormalized", 594669093L)
        }
        private val scaledBind by lazy {
            BuiltinCalls.getBuiltinMethod(BuiltinCalls.VT_BASIS, "scaled", 3934786792L)
        }
        private val determinantBind by lazy {
            BuiltinCalls.getBuiltinMethod(BuiltinCalls.VT_BASIS, "determinant", 466405837L)
        }
        private val lookingAtBind by lazy {
            BuiltinCalls.getBuiltinMethod(BuiltinCalls.VT_BASIS, "looking_at", 3728732505L)
        }

        /**
         * Returns a rotation basis that points the -Z axis toward [target] with +Y toward [up]
         * (or the model-front axis when [useModelFront]). `Basis.looking_at` is a *static* builtin,
         * so the call passes an empty base (mirrors the desktop `base = NULL`).
         */
        fun lookingAt(target: Vector3, up: Vector3 = Vector3.UP, useModelFront: Boolean = false): Basis =
            fromFloat32(BuiltinCalls.call(lookingAtBind, floatArrayOf(), 9, listOf(
                BuiltinCalls.BArg.Floats(
                    BuiltinCalls.PT_VECTOR3,
                    floatArrayOf(target.x.toFloat(), target.y.toFloat(), target.z.toFloat()),
                ),
                BuiltinCalls.BArg.Floats(
                    BuiltinCalls.PT_VECTOR3,
                    floatArrayOf(up.x.toFloat(), up.y.toFloat(), up.z.toFloat()),
                ),
                BuiltinCalls.BArg.Bool(useModelFront),
            )))

        private fun fromFloat32(c: FloatArray): Basis =
            Basis(
                Vector3(c[0].toDouble(), c[3].toDouble(), c[6].toDouble()),
                Vector3(c[1].toDouble(), c[4].toDouble(), c[7].toDouble()),
                Vector3(c[2].toDouble(), c[5].toDouble(), c[8].toDouble()),
            )
    }
}
