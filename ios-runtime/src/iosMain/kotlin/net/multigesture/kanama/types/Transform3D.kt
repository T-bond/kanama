package net.multigesture.kanama.types

import net.multigesture.kanama.binding.runtime.BuiltinCalls

/**
 * A 3×4 matrix representing a 3D transformation: a [Basis] (rotation/scale/shear) plus
 * an origin (translation). Kanama value types are immutable snapshots; assign a new
 * value back to the Godot property after changing components.
 *
 * iOS marshalling note: at ptrcall a Transform3D is 12 `real_t` (float32 on
 * single-precision iOS) — the 9 column-major basis components followed by the 3 origin
 * components — laid out by the generated ObjectCalls helpers. Engine-computed value
 * methods (e.g. [inverse]) route through the BuiltinCalls value-type call path.
 */
data class Transform3D(
    val basis: Basis,
    val origin: Vector3,
) {
    /**
     * Returns the inverse of this transform, assuming its [basis] is orthonormal (a pure
     * rotation, no scale/shear). Godot computes this the fast way — transposing the basis
     * and re-deriving the origin — so for a scaled/sheared transform use the full matrix
     * inverse (`affine_inverse`, not yet wired on iOS) instead.
     */
    fun inverse(): Transform3D =
        fromFloat32(BuiltinCalls.callNoArgsFloat32(inverseBind, toFloat32()))

    // Column-major 12 float32, matching the ObjectCalls Transform3D ptrcall layout.
    private fun toFloat32(): FloatArray =
        floatArrayOf(
            basis.x.x.toFloat(), basis.y.x.toFloat(), basis.z.x.toFloat(),
            basis.x.y.toFloat(), basis.y.y.toFloat(), basis.z.y.toFloat(),
            basis.x.z.toFloat(), basis.y.z.toFloat(), basis.z.z.toFloat(),
            origin.x.toFloat(), origin.y.toFloat(), origin.z.toFloat(),
        )

    companion object {
        val IDENTITY = Transform3D(Basis.IDENTITY, Vector3.ZERO)

        // All no-arg->Self Transform3D builtin methods share this signature-shape hash.
        private val inverseBind by lazy {
            BuiltinCalls.getBuiltinMethod(BuiltinCalls.VT_TRANSFORM3D, "inverse", 3816817146L)
        }

        private fun fromFloat32(c: FloatArray): Transform3D =
            Transform3D(
                basis = Basis(
                    Vector3(c[0].toDouble(), c[3].toDouble(), c[6].toDouble()),
                    Vector3(c[1].toDouble(), c[4].toDouble(), c[7].toDouble()),
                    Vector3(c[2].toDouble(), c[5].toDouble(), c[8].toDouble()),
                ),
                origin = Vector3(c[9].toDouble(), c[10].toDouble(), c[11].toDouble()),
            )
    }
}
