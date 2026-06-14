package net.multigesture.kanama.types

/**
 * An axis-aligned bounding box in 3D space: an origin [position] and a [size]. Kanama
 * value types are immutable snapshots.
 *
 * iOS marshalling note: at ptrcall an AABB is 6 `real_t` (float32 on single-precision
 * iOS) — the 3 position components followed by the 3 size components — POD passthrough.
 */
data class AABB(
    val position: Vector3,
    val size: Vector3,
) {
    companion object {
        val ZERO = AABB(Vector3.ZERO, Vector3.ZERO)
    }
}
