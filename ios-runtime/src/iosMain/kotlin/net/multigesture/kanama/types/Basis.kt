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
    /** Returns the inverse of this basis. Computed by Godot. */
    fun inverse(): Basis =
        fromFloat32(BuiltinCalls.callNoArgsFloat32(inverseBind, toFloat32()))

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

        // All no-arg->Self Basis builtin methods share this signature-shape hash.
        private val inverseBind by lazy {
            BuiltinCalls.getBuiltinMethod(BuiltinCalls.VT_BASIS, "inverse", 594669093L)
        }

        private fun fromFloat32(c: FloatArray): Basis =
            Basis(
                Vector3(c[0].toDouble(), c[3].toDouble(), c[6].toDouble()),
                Vector3(c[1].toDouble(), c[4].toDouble(), c[7].toDouble()),
                Vector3(c[2].toDouble(), c[5].toDouble(), c[8].toDouble()),
            )
    }
}
