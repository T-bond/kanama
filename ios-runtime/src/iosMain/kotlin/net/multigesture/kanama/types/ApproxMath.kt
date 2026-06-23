package net.multigesture.kanama.types

import kotlin.math.abs

/**
 * iOS shadow of the desktop [ApproxMath] — Godot's fuzzy float comparison (`Math::is_equal_approx` /
 * `is_zero_approx`), replicated locally so the value-type helpers match the engine without a
 * per-component engine round-trip. Components are `Double` on iOS (single-precision engine values
 * widened at the C-shim boundary). `CMP_EPSILON` is Godot's `0.00001`.
 */
internal const val CMP_EPSILON: Double = 0.00001

internal fun isEqualApprox(a: Double, b: Double): Boolean {
    if (a == b) return true
    var tolerance = CMP_EPSILON * abs(a)
    if (tolerance < CMP_EPSILON) tolerance = CMP_EPSILON
    return abs(a - b) < tolerance
}

internal fun isZeroApprox(value: Double): Boolean = abs(value) < CMP_EPSILON
