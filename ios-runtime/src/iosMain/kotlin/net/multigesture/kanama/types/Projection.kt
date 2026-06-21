package net.multigesture.kanama.types

/**
 * A 4×4 matrix (camera/clip-space projection), stored as four [Vector4] columns x/y/z/w —
 * the same column-major layout Godot uses. Kanama value types are immutable snapshots.
 *
 * iOS marshalling note: at ptrcall a Projection is 16 `real_t` (float32 on single-precision
 * iOS), laid out column-major (column x first, then y, z, w), matching the generated decode.
 */
data class Projection(
    val x: Vector4,
    val y: Vector4,
    val z: Vector4,
    val w: Vector4,
) {
    companion object {
        val IDENTITY = Projection(
            Vector4(1.0, 0.0, 0.0, 0.0),
            Vector4(0.0, 1.0, 0.0, 0.0),
            Vector4(0.0, 0.0, 1.0, 0.0),
            Vector4(0.0, 0.0, 0.0, 1.0),
        )
        val ZERO = Projection(Vector4.ZERO, Vector4.ZERO, Vector4.ZERO, Vector4.ZERO)
    }
}
