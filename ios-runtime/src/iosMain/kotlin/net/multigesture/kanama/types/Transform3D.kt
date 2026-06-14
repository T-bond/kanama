package net.multigesture.kanama.types

/**
 * A 3×4 matrix representing a 3D transformation: a [Basis] (rotation/scale/shear) plus
 * an origin (translation). Kanama value types are immutable snapshots; assign a new
 * value back to the Godot property after changing components.
 *
 * iOS marshalling note: at ptrcall a Transform3D is 12 `real_t` (float32 on
 * single-precision iOS) — the 9 column-major basis components followed by the 3 origin
 * components — laid out by the generated ObjectCalls helpers. No BuiltinTypes value
 * methods (variant calls are not wired on iOS yet); arg/return snapshot only.
 */
data class Transform3D(
    val basis: Basis,
    val origin: Vector3,
) {
    companion object {
        val IDENTITY = Transform3D(Basis.IDENTITY, Vector3.ZERO)
    }
}
