package net.multigesture.kanama.types

/**
 * A 3×3 matrix for 3D rotation and scale, as three column axes (x, y, z). Kanama value
 * types are immutable snapshots; assign a new value back to the Godot property after
 * changing components.
 *
 * iOS marshalling note: at ptrcall a Basis is 9 `real_t` (float32 on single-precision
 * iOS) in column-major order — `[x.x, y.x, z.x, x.y, y.y, z.y, x.z, y.z, z.z]` — laid
 * out by the generated ObjectCalls helpers. This type carries no BuiltinTypes value
 * methods (variant calls are not wired on iOS yet); it is an arg/return snapshot only.
 */
data class Basis(
    val x: Vector3,
    val y: Vector3,
    val z: Vector3,
) {
    companion object {
        val IDENTITY = Basis(
            Vector3(1.0, 0.0, 0.0),
            Vector3(0.0, 1.0, 0.0),
            Vector3(0.0, 0.0, 1.0),
        )
    }
}
