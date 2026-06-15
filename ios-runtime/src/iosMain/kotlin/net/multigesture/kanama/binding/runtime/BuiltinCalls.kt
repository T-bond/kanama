@file:OptIn(ExperimentalForeignApi::class)

package net.multigesture.kanama.binding.runtime

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.COpaquePointerVar
import kotlinx.cinterop.DoubleVar
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.FloatVar
import kotlinx.cinterop.IntVar
import kotlinx.cinterop.alloc
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.get
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.set
import kotlinx.cinterop.value
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
    const val VT_VECTOR2 = 5
    const val VT_VECTOR3 = 9
    const val VT_QUATERNION = 15
    const val VT_BASIS = 17
    const val VT_TRANSFORM3D = 18

    // ptrcall/builtin arg tags — must match the KANAMA_IOS_PT_* enum in kanama_ios_shim.c.
    // Used as the [BArg.Floats] tag for value-type args (struct types are passthrough C-side).
    const val PT_BOOL = 1
    const val PT_FLOAT64 = 5
    const val PT_VECTOR2 = 6
    const val PT_VECTOR3 = 8
    const val PT_TRANSFORM3D = 19
    const val PT_QUATERNION = 20

    /** An argument to a builtin method call (the value-type analogue of a ptrcall arg). */
    sealed interface BArg {
        /** A struct value laid out as float32 [values] (Vector3/Basis/Transform3D/…); [tag] is its PT_*. */
        data class Floats(val tag: Int, val values: FloatArray) : BArg
        /** A `bool` arg (1-byte). */
        data class Bool(val value: Boolean) : BArg
        /** A scalar `float`/`double` arg (8-byte double at ptrcall). */
        data class Real(val value: Double) : BArg
    }

    fun getBuiltinMethod(variantType: Int, method: String, hash: Long): Long =
        kanama_ios_godot_get_builtin_method(variantType, method, hash)

    /**
     * Call a builtin method whose base and return are value types laid out as float32
     * components ([base] in, [retCount] floats out), with optional [args]. Marshalling
     * (arg layout + tags) is concentrated here, mirroring the desktop `BuiltinTypes.call`.
     */
    fun call(methodPtr: Long, base: FloatArray, retCount: Int, args: List<BArg> = emptyList()): FloatArray =
        memScoped {
            val baseBuf = allocArray<FloatVar>(if (base.isNotEmpty()) base.size else 1)
            for (i in base.indices) baseBuf[i] = base[i]
            val n = args.size
            val tags = allocArray<IntVar>(if (n > 0) n else 1)
            val ptrs = allocArray<COpaquePointerVar>(if (n > 0) n else 1)
            args.forEachIndexed { i, a ->
                when (a) {
                    is BArg.Floats -> {
                        val b = allocArray<FloatVar>(if (a.values.isNotEmpty()) a.values.size else 1)
                        for (j in a.values.indices) b[j] = a.values[j]
                        tags[i] = a.tag; ptrs[i] = b.reinterpret<CPointed>()
                    }
                    is BArg.Bool -> {
                        val b = alloc<ByteVar>(); b.value = if (a.value) 1 else 0
                        tags[i] = PT_BOOL; ptrs[i] = b.ptr.reinterpret<CPointed>()
                    }
                    is BArg.Real -> {
                        val b = alloc<DoubleVar>(); b.value = a.value
                        tags[i] = PT_FLOAT64; ptrs[i] = b.ptr.reinterpret<CPointed>()
                    }
                }
            }
            val ret = allocArray<FloatVar>(if (retCount > 0) retCount else 1)
            kanama_ios_godot_builtin_call(methodPtr, baseBuf, if (n > 0) tags else null, if (n > 0) ptrs else null, n, ret)
            FloatArray(retCount) { ret[it] }
        }

    /**
     * No-arg builtin method whose base and return are the same value type laid out as
     * float32 components (inverse / transposed / orthonormalized / …).
     */
    fun callNoArgsFloat32(methodPtr: Long, base: FloatArray): FloatArray =
        call(methodPtr, base, base.size, emptyList())
}
