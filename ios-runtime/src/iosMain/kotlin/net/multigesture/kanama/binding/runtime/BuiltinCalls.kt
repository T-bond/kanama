@file:OptIn(ExperimentalForeignApi::class)

package net.multigesture.kanama.binding.runtime

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.FloatVar
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.get
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.set
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_builtin_call
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_get_builtin_method

/**
 * iOS implementation of value-type (builtin) method calls — the analogue of [ObjectCalls]
 * for Godot's builtin Variant types (Transform3D, Basis, Vector*, …). Engine-computed
 * methods like `Transform3D.inverse()` route through `variant_get_ptr_builtin_method`
 * (resolved once, cached like a MethodBind) + the generic C `kanama_ios_godot_builtin_call`,
 * which calls `method(base, args, ret, argc)` with raw value byte buffers. Mirrors the
 * desktop `BuiltinTypes.call`.
 *
 * Marshalling note: value components are real_t = 4-byte float32 in single-precision iOS
 * builds, laid out in the same column-major order the [ObjectCalls] ptrcall helpers use.
 */
object BuiltinCalls {
    // Godot Variant type ids (Variant::Type) — must match the engine enum.
    const val VT_BASIS = 17
    const val VT_TRANSFORM3D = 18

    fun getBuiltinMethod(variantType: Int, method: String, hash: Long): Long =
        kanama_ios_godot_get_builtin_method(variantType, method, hash)

    /**
     * No-arg builtin method whose base and return are the same value type laid out as
     * [count] float32 components (inverse / transposed / orthonormalized / …). [base]
     * carries the laid-out components in; the returned array carries the result out.
     */
    fun callNoArgsFloat32(methodPtr: Long, base: FloatArray): FloatArray =
        memScoped {
            val n = base.size
            val baseBuf = allocArray<FloatVar>(n)
            for (i in 0 until n) baseBuf[i] = base[i]
            val ret = allocArray<FloatVar>(n)
            kanama_ios_godot_builtin_call(methodPtr, baseBuf, null, null, 0, ret)
            FloatArray(n) { ret[it] }
        }
}
