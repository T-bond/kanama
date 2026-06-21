@file:OptIn(ExperimentalForeignApi::class)

package net.multigesture.kanama.binding.runtime

import java.lang.foreign.MemorySegment
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.COpaquePointerVar
import kotlinx.cinterop.DoubleVar
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.FloatVar
import kotlinx.cinterop.IntVar
import kotlinx.cinterop.LongVar
import kotlinx.cinterop.alloc
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.cstr
import kotlinx.cinterop.get
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.set
import kotlinx.cinterop.value
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_ptrcall
import net.multigesture.kanama.types.AABB
import net.multigesture.kanama.types.Basis
import net.multigesture.kanama.types.Color
import net.multigesture.kanama.types.NodePath
import net.multigesture.kanama.types.Projection
import net.multigesture.kanama.types.Quaternion
import net.multigesture.kanama.types.RID
import net.multigesture.kanama.types.Rect2
import net.multigesture.kanama.types.Transform2D
import net.multigesture.kanama.types.Transform3D
import net.multigesture.kanama.types.Vector2
import net.multigesture.kanama.types.Vector2i
import net.multigesture.kanama.types.Vector3
import net.multigesture.kanama.types.Vector3i
import net.multigesture.kanama.types.Vector4

/**
 * GENERATED iOS ObjectCalls helper bodies (scripts/generate_api_wrapper.py --ios-*).
 * DO NOT EDIT BY HAND. Re-run the generator instead.
 *
 * Each helper is an extension on the hand-written `object ObjectCalls`, so the
 * generated Godot API wrappers' `ObjectCalls.<helper>(...)` calls resolve here. Every
 * helper marshals through the single generic C dispatch `kanama_ios_godot_ptrcall`,
 * applying the authoritative ptrcall width table (scalar float->double/8B, scalar
 * int->int64/8B, Vector components->float32, Object->8B handle, StringName built
 * C-side). Helpers already hand-written in ObjectCalls.kt are the override set and
 * are NOT regenerated here.
 */

private const val PT_VOID = 0
private const val PT_BOOL = 1
private const val PT_INT64 = 3
private const val PT_FLOAT64 = 5
private const val PT_VECTOR2 = 6
private const val PT_VECTOR2I = 7
private const val PT_VECTOR3 = 8
private const val PT_COLOR = 11
private const val PT_RECT2 = 12
private const val PT_OBJECT = 13
private const val PT_RID = 14
private const val PT_STRING_NAME = 15
private const val PT_STRING = 16
private const val PT_NODE_PATH = 17
private const val PT_BASIS = 18
private const val PT_TRANSFORM3D = 19
private const val PT_QUATERNION = 20
private const val PT_AABB = 21
private const val PT_TRANSFORM2D = 22
private const val PT_PROJECTION = 25

fun ObjectCalls.ptrcallNoArgsRetAABB(methodBind: MemorySegment, instance: MemorySegment): AABB =
    memScoped {
        val ret = allocArray<FloatVar>(6)
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_AABB, ret)
        AABB(Vector3(ret[0].toDouble(), ret[1].toDouble(), ret[2].toDouble()), Vector3(ret[3].toDouble(), ret[4].toDouble(), ret[5].toDouble()))
    }

fun ObjectCalls.ptrcallNoArgsRetBasis(methodBind: MemorySegment, instance: MemorySegment): Basis =
    memScoped {
        val ret = allocArray<FloatVar>(9)
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_BASIS, ret)
        Basis(Vector3(ret[0].toDouble(), ret[3].toDouble(), ret[6].toDouble()), Vector3(ret[1].toDouble(), ret[4].toDouble(), ret[7].toDouble()), Vector3(ret[2].toDouble(), ret[5].toDouble(), ret[8].toDouble()))
    }

fun ObjectCalls.ptrcallNoArgsRetProjection(methodBind: MemorySegment, instance: MemorySegment): Projection =
    memScoped {
        val ret = allocArray<FloatVar>(16)
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_PROJECTION, ret)
        Projection(Vector4(ret[0].toDouble(), ret[1].toDouble(), ret[2].toDouble(), ret[3].toDouble()), Vector4(ret[4].toDouble(), ret[5].toDouble(), ret[6].toDouble(), ret[7].toDouble()), Vector4(ret[8].toDouble(), ret[9].toDouble(), ret[10].toDouble(), ret[11].toDouble()), Vector4(ret[12].toDouble(), ret[13].toDouble(), ret[14].toDouble(), ret[15].toDouble()))
    }

fun ObjectCalls.ptrcallNoArgsRetQuaternion(methodBind: MemorySegment, instance: MemorySegment): Quaternion =
    memScoped {
        val ret = allocArray<FloatVar>(4)
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_QUATERNION, ret)
        Quaternion(ret[0].toDouble(), ret[1].toDouble(), ret[2].toDouble(), ret[3].toDouble())
    }

fun ObjectCalls.ptrcallNoArgsRetRID(methodBind: MemorySegment, instance: MemorySegment): RID =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_RID, ret.ptr)
        RID(ret.value)
    }

fun ObjectCalls.ptrcallNoArgsRetTransform2D(methodBind: MemorySegment, instance: MemorySegment): Transform2D =
    memScoped {
        val ret = allocArray<FloatVar>(6)
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_TRANSFORM2D, ret)
        Transform2D(Vector2(ret[0].toDouble(), ret[1].toDouble()), Vector2(ret[2].toDouble(), ret[3].toDouble()), Vector2(ret[4].toDouble(), ret[5].toDouble()))
    }

fun ObjectCalls.ptrcallNoArgsRetTransform3D(methodBind: MemorySegment, instance: MemorySegment): Transform3D =
    memScoped {
        val ret = allocArray<FloatVar>(12)
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_TRANSFORM3D, ret)
        Transform3D(Basis(Vector3(ret[0].toDouble(), ret[3].toDouble(), ret[6].toDouble()), Vector3(ret[1].toDouble(), ret[4].toDouble(), ret[7].toDouble()), Vector3(ret[2].toDouble(), ret[5].toDouble(), ret[8].toDouble())), Vector3(ret[9].toDouble(), ret[10].toDouble(), ret[11].toDouble()))
    }

fun ObjectCalls.ptrcallNoArgsRetUInt32(methodBind: MemorySegment, instance: MemorySegment): Long =
    memScoped {
        val ret = alloc<LongVar>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_INT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithAABBArg(methodBind: MemorySegment, instance: MemorySegment, a0: AABB) =
    memScoped {
        val c0 = allocArray<FloatVar>(6); c0[0] = a0.position.x.toFloat(); c0[1] = a0.position.y.toFloat(); c0[2] = a0.position.z.toFloat(); c0[3] = a0.size.x.toFloat(); c0[4] = a0.size.y.toFloat(); c0[5] = a0.size.z.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_AABB
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithBasisArg(methodBind: MemorySegment, instance: MemorySegment, a0: Basis) =
    memScoped {
        val c0 = allocArray<FloatVar>(9); c0[0] = a0.x.x.toFloat(); c0[1] = a0.y.x.toFloat(); c0[2] = a0.z.x.toFloat(); c0[3] = a0.x.y.toFloat(); c0[4] = a0.y.y.toFloat(); c0[5] = a0.z.y.toFloat(); c0[6] = a0.x.z.toFloat(); c0[7] = a0.y.z.toFloat(); c0[8] = a0.z.z.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_BASIS
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithBoolAndIntArgsRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Boolean, a1: Int): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = alloc<ByteVar>(); c0.value = if (a0) 1 else 0
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_BOOL; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithBoolAndLongArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Boolean, a1: Long) =
    memScoped {
        val c0 = alloc<ByteVar>(); c0.value = if (a0) 1 else 0
        val c1 = alloc<LongVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_BOOL; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithBoolArgRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Boolean): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = alloc<ByteVar>(); c0.value = if (a0) 1 else 0
        val types = allocArray<IntVar>(1); types[0] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithBoolArgRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Boolean): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<ByteVar>(); c0.value = if (a0) 1 else 0
        val types = allocArray<IntVar>(1); types[0] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithBoolArgRetLong(methodBind: MemorySegment, instance: MemorySegment, a0: Boolean): Long =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<ByteVar>(); c0.value = if (a0) 1 else 0
        val types = allocArray<IntVar>(1); types[0] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithBoolArgRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: Boolean): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val c0 = alloc<ByteVar>(); c0.value = if (a0) 1 else 0
        val types = allocArray<IntVar>(1); types[0] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithDoubleAndBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Double, a1: Boolean) =
    memScoped {
        val c0 = alloc<DoubleVar>(); c0.value = a0
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val types = allocArray<IntVar>(2); types[0] = PT_FLOAT64; types[1] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithDoubleAndColorArg(methodBind: MemorySegment, instance: MemorySegment, a0: Double, a1: Color) =
    memScoped {
        val c0 = alloc<DoubleVar>(); c0.value = a0
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.r; c1[1] = a1.g; c1[2] = a1.b; c1[3] = a1.a
        val types = allocArray<IntVar>(2); types[0] = PT_FLOAT64; types[1] = PT_COLOR
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithDoubleAndTwoBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Double, a1: Boolean, a2: Boolean) =
    memScoped {
        val c0 = alloc<DoubleVar>(); c0.value = a0
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val types = allocArray<IntVar>(3); types[0] = PT_FLOAT64; types[1] = PT_BOOL; types[2] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithDoubleArgRetColor(methodBind: MemorySegment, instance: MemorySegment, a0: Double): Color =
    memScoped {
        val ret = allocArray<FloatVar>(4)
        val c0 = alloc<DoubleVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_COLOR, ret)
        Color(ret[0], ret[1], ret[2], ret[3])
    }

fun ObjectCalls.ptrcallWithDoubleArgRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: Double): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val c0 = alloc<DoubleVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithDoubleVector2TwoDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Double, a1: Vector2, a2: Double, a3: Double) =
    memScoped {
        val c0 = alloc<DoubleVar>(); c0.value = a0
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val types = allocArray<IntVar>(4); types[0] = PT_FLOAT64; types[1] = PT_VECTOR2; types[2] = PT_FLOAT64; types[3] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithFiveIntArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: Int, a3: Int, a4: Int) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val c3 = alloc<LongVar>(); c3.value = a3.toLong()
        val c4 = alloc<LongVar>(); c4.value = a4.toLong()
        val types = allocArray<IntVar>(5); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_INT64; types[3] = PT_INT64; types[4] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithFloatArgRetFloat(methodBind: MemorySegment, instance: MemorySegment, a0: Double): Double =
    memScoped {
        val ret = alloc<DoubleVar>()
        val c0 = alloc<DoubleVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_FLOAT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithFourDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Double, a1: Double, a2: Double, a3: Double) =
    memScoped {
        val c0 = alloc<DoubleVar>(); c0.value = a0
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val types = allocArray<IntVar>(4); types[0] = PT_FLOAT64; types[1] = PT_FLOAT64; types[2] = PT_FLOAT64; types[3] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithFourIntAndBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: Int, a3: Int, a4: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val c3 = alloc<LongVar>(); c3.value = a3.toLong()
        val c4 = alloc<ByteVar>(); c4.value = if (a4) 1 else 0
        val types = allocArray<IntVar>(5); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_INT64; types[3] = PT_INT64; types[4] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithFourIntArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: Int, a3: Int) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val c3 = alloc<LongVar>(); c3.value = a3.toLong()
        val types = allocArray<IntVar>(4); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_INT64; types[3] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntAndBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntAndBoolArgsRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Boolean): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithIntAndBoolArgsRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Boolean): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithIntAndColorArg(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Color) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.r; c1[1] = a1.g; c1[2] = a1.b; c1[3] = a1.a
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_COLOR
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntAndDoubleArg(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntAndDoubleArgRetDouble(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Double): Double =
    memScoped {
        val ret = alloc<DoubleVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_FLOAT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithIntAndDoubleArgRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Double): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithIntAndLongArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Long) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntAndNodePathArg(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: NodePath) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_NODE_PATH
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = a1.path.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntAndObjectArg(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: MemorySegment) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.address()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_OBJECT
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntAndQuaternionArg(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Quaternion) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat(); c1[2] = a1.z.toFloat(); c1[3] = a1.w.toFloat()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_QUATERNION
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntAndStringArg(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: String) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_STRING
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntAndStringNameArgRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: String): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithIntAndTransform3DArg(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Transform3D) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = allocArray<FloatVar>(12); c1[0] = a1.basis.x.x.toFloat(); c1[1] = a1.basis.y.x.toFloat(); c1[2] = a1.basis.z.x.toFloat(); c1[3] = a1.basis.x.y.toFloat(); c1[4] = a1.basis.y.y.toFloat(); c1[5] = a1.basis.z.y.toFloat(); c1[6] = a1.basis.x.z.toFloat(); c1[7] = a1.basis.y.z.toFloat(); c1[8] = a1.basis.z.z.toFloat(); c1[9] = a1.origin.x.toFloat(); c1[10] = a1.origin.y.toFloat(); c1[11] = a1.origin.z.toFloat()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_TRANSFORM3D
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntAndTwoDoubleArgsRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Double, a2: Double): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_FLOAT64; types[2] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithIntAndVector2Arg(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Vector2) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_VECTOR2
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntAndVector3Arg(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Vector3) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = allocArray<FloatVar>(3); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat(); c1[2] = a1.z.toFloat()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_VECTOR3
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntArgRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Int): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithIntArgRetColor(methodBind: MemorySegment, instance: MemorySegment, a0: Int): Color =
    memScoped {
        val ret = allocArray<FloatVar>(4)
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_COLOR, ret)
        Color(ret[0], ret[1], ret[2], ret[3])
    }

fun ObjectCalls.ptrcallWithIntArgRetDouble(methodBind: MemorySegment, instance: MemorySegment, a0: Int): Double =
    memScoped {
        val ret = alloc<DoubleVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_FLOAT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithIntArgRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Int): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithIntArgRetLong(methodBind: MemorySegment, instance: MemorySegment, a0: Int): Long =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithIntArgRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: Int): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithIntArgRetQuaternion(methodBind: MemorySegment, instance: MemorySegment, a0: Int): Quaternion =
    memScoped {
        val ret = allocArray<FloatVar>(4)
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_QUATERNION, ret)
        Quaternion(ret[0].toDouble(), ret[1].toDouble(), ret[2].toDouble(), ret[3].toDouble())
    }

fun ObjectCalls.ptrcallWithIntArgRetRect2(methodBind: MemorySegment, instance: MemorySegment, a0: Int): Rect2 =
    memScoped {
        val ret = allocArray<FloatVar>(4)
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_RECT2, ret)
        Rect2(Vector2(ret[0].toDouble(), ret[1].toDouble()), Vector2(ret[2].toDouble(), ret[3].toDouble()))
    }

fun ObjectCalls.ptrcallWithIntArgRetTransform3D(methodBind: MemorySegment, instance: MemorySegment, a0: Int): Transform3D =
    memScoped {
        val ret = allocArray<FloatVar>(12)
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_TRANSFORM3D, ret)
        Transform3D(Basis(Vector3(ret[0].toDouble(), ret[3].toDouble(), ret[6].toDouble()), Vector3(ret[1].toDouble(), ret[4].toDouble(), ret[7].toDouble()), Vector3(ret[2].toDouble(), ret[5].toDouble(), ret[8].toDouble())), Vector3(ret[9].toDouble(), ret[10].toDouble(), ret[11].toDouble()))
    }

fun ObjectCalls.ptrcallWithIntArgRetUInt32(methodBind: MemorySegment, instance: MemorySegment, a0: Int): Long =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithIntArgRetVector2(methodBind: MemorySegment, instance: MemorySegment, a0: Int): Vector2 =
    memScoped {
        val ret = allocArray<FloatVar>(2)
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VECTOR2, ret)
        Vector2(ret[0].toDouble(), ret[1].toDouble())
    }

fun ObjectCalls.ptrcallWithIntArgRetVector2i(methodBind: MemorySegment, instance: MemorySegment, a0: Int): Vector2i =
    memScoped {
        val ret = allocArray<IntVar>(2)
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VECTOR2I, ret)
        Vector2i(ret[0], ret[1])
    }

fun ObjectCalls.ptrcallWithIntArgRetVector3(methodBind: MemorySegment, instance: MemorySegment, a0: Int): Vector3 =
    memScoped {
        val ret = allocArray<FloatVar>(3)
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VECTOR3, ret)
        Vector3(ret[0].toDouble(), ret[1].toDouble(), ret[2].toDouble())
    }

fun ObjectCalls.ptrcallWithIntBoolIntArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Boolean, a2: Int) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_BOOL; types[2] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntBoolIntBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Boolean, a2: Int, a3: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val c3 = alloc<ByteVar>(); c3.value = if (a3) 1 else 0
        val types = allocArray<IntVar>(4); types[0] = PT_INT64; types[1] = PT_BOOL; types[2] = PT_INT64; types[3] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntBoolTwoIntArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Boolean, a2: Int, a3: Int) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val c3 = alloc<LongVar>(); c3.value = a3.toLong()
        val types = allocArray<IntVar>(4); types[0] = PT_INT64; types[1] = PT_BOOL; types[2] = PT_INT64; types[3] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntDoubleBoolArgsRetDouble(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Double, a2: Boolean): Double =
    memScoped {
        val ret = alloc<DoubleVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_FLOAT64; types[2] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_FLOAT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithIntDoubleBoolArgsRetQuaternion(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Double, a2: Boolean): Quaternion =
    memScoped {
        val ret = allocArray<FloatVar>(4)
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_FLOAT64; types[2] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_QUATERNION, ret)
        Quaternion(ret[0].toDouble(), ret[1].toDouble(), ret[2].toDouble(), ret[3].toDouble())
    }

fun ObjectCalls.ptrcallWithIntDoubleBoolArgsRetVector3(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Double, a2: Boolean): Vector3 =
    memScoped {
        val ret = allocArray<FloatVar>(3)
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_FLOAT64; types[2] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VECTOR3, ret)
        Vector3(ret[0].toDouble(), ret[1].toDouble(), ret[2].toDouble())
    }

fun ObjectCalls.ptrcallWithIntDoubleLongTwoBoolArgsRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Double, a2: Long, a3: Boolean, a4: Boolean): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<LongVar>(); c2.value = a2
        val c3 = alloc<ByteVar>(); c3.value = if (a3) 1 else 0
        val c4 = alloc<ByteVar>(); c4.value = if (a4) 1 else 0
        val types = allocArray<IntVar>(5); types[0] = PT_INT64; types[1] = PT_FLOAT64; types[2] = PT_INT64; types[3] = PT_BOOL; types[4] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithIntDoubleObjectTwoDoubleArgsRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Double, a2: MemorySegment, a3: Double, a4: Double): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<LongVar>(); c2.value = a2.address()
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val types = allocArray<IntVar>(5); types[0] = PT_INT64; types[1] = PT_FLOAT64; types[2] = PT_OBJECT; types[3] = PT_FLOAT64; types[4] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithIntDoubleQuaternionArgsRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Double, a2: Quaternion): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.x.toFloat(); c2[1] = a2.y.toFloat(); c2[2] = a2.z.toFloat(); c2[3] = a2.w.toFloat()
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_FLOAT64; types[2] = PT_QUATERNION
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithIntDoubleStringNameArgsRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Double, a2: String): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_FLOAT64; types[2] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithIntDoubleVector3ArgsRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Double, a2: Vector3): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = allocArray<FloatVar>(3); c2[0] = a2.x.toFloat(); c2[1] = a2.y.toFloat(); c2[2] = a2.z.toFloat()
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_FLOAT64; types[2] = PT_VECTOR3
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithIntLongBoolStringArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Long, a2: Boolean, a3: String) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val types = allocArray<IntVar>(4); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_BOOL; types[3] = PT_STRING
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = a3.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntLongIntStringArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Long, a2: Int, a3: String) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val types = allocArray<IntVar>(4); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_INT64; types[3] = PT_STRING
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = a3.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntTransform3DDoubleBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Transform3D, a2: Double, a3: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = allocArray<FloatVar>(12); c1[0] = a1.basis.x.x.toFloat(); c1[1] = a1.basis.y.x.toFloat(); c1[2] = a1.basis.z.x.toFloat(); c1[3] = a1.basis.x.y.toFloat(); c1[4] = a1.basis.y.y.toFloat(); c1[5] = a1.basis.z.y.toFloat(); c1[6] = a1.basis.x.z.toFloat(); c1[7] = a1.basis.y.z.toFloat(); c1[8] = a1.basis.z.z.toFloat(); c1[9] = a1.origin.x.toFloat(); c1[10] = a1.origin.y.toFloat(); c1[11] = a1.origin.z.toFloat()
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = alloc<ByteVar>(); c3.value = if (a3) 1 else 0
        val types = allocArray<IntVar>(4); types[0] = PT_INT64; types[1] = PT_TRANSFORM3D; types[2] = PT_FLOAT64; types[3] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntTwoBoolTwoIntArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Boolean, a2: Boolean, a3: Int, a4: Int) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val c3 = alloc<LongVar>(); c3.value = a3.toLong()
        val c4 = alloc<LongVar>(); c4.value = a4.toLong()
        val types = allocArray<IntVar>(5); types[0] = PT_INT64; types[1] = PT_BOOL; types[2] = PT_BOOL; types[3] = PT_INT64; types[4] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithIntTwoDoubleTwoVector2ArgsRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Double, a2: Double, a3: Vector2, a4: Vector2): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = allocArray<FloatVar>(2); c3[0] = a3.x.toFloat(); c3[1] = a3.y.toFloat()
        val c4 = allocArray<FloatVar>(2); c4[0] = a4.x.toFloat(); c4[1] = a4.y.toFloat()
        val types = allocArray<IntVar>(5); types[0] = PT_INT64; types[1] = PT_FLOAT64; types[2] = PT_FLOAT64; types[3] = PT_VECTOR2; types[4] = PT_VECTOR2
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.reinterpret<CPointed>(); ptrs[4] = c4.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithLongAndBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithLongAndDoubleArg(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithLongAndIntArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Int) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithLongAndIntArgsRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Int): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithLongAndNodePathArg(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: NodePath) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_NODE_PATH
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = a1.path.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithLongAndThreeStringNameArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: String, a2: String, a3: String) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(4); types[0] = PT_INT64; types[1] = PT_STRING_NAME; types[2] = PT_STRING_NAME; types[3] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>(); ptrs[3] = a3.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithLongAndTwoStringNameArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: String, a2: String) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_STRING_NAME; types[2] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithLongAndTwoStringNameArgsRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: String, a2: String): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_STRING_NAME; types[2] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithLongArgRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Long): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithLongArgRetDouble(methodBind: MemorySegment, instance: MemorySegment, a0: Long): Double =
    memScoped {
        val ret = alloc<DoubleVar>()
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_FLOAT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithLongArgRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Long): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithLongArgRetLong(methodBind: MemorySegment, instance: MemorySegment, a0: Long): Long =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithLongArgRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: Long): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithLongDoubleTwoBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Double, a2: Boolean, a3: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val c3 = alloc<ByteVar>(); c3.value = if (a3) 1 else 0
        val types = allocArray<IntVar>(4); types[0] = PT_INT64; types[1] = PT_FLOAT64; types[2] = PT_BOOL; types[3] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithLongTwoDoubleAndBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Double, a2: Double, a3: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = alloc<ByteVar>(); c3.value = if (a3) 1 else 0
        val types = allocArray<IntVar>(4); types[0] = PT_INT64; types[1] = PT_FLOAT64; types[2] = PT_FLOAT64; types[3] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithNodePathAndLongArgRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: NodePath, a1: Long): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c1 = alloc<LongVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_NODE_PATH; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.path.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithNodePathArg(methodBind: MemorySegment, instance: MemorySegment, a0: NodePath) =
    memScoped {
        val types = allocArray<IntVar>(1); types[0] = PT_NODE_PATH
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.path.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithNodePathArgRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: NodePath): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val types = allocArray<IntVar>(1); types[0] = PT_NODE_PATH
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.path.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithNodePathArgRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: NodePath): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val types = allocArray<IntVar>(1); types[0] = PT_NODE_PATH
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.path.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithObjectAndBoolArg(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val types = allocArray<IntVar>(2); types[0] = PT_OBJECT; types[1] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectAndDoubleArg(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_OBJECT; types[1] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectAndIntArg(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Int) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_OBJECT; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectAndRect2Arg(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Rect2) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.position.x.toFloat(); c1[1] = a1.position.y.toFloat(); c1[2] = a1.size.x.toFloat(); c1[3] = a1.size.y.toFloat()
        val types = allocArray<IntVar>(2); types[0] = PT_OBJECT; types[1] = PT_RECT2
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectAndVector2iArg(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Vector2i) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = allocArray<IntVar>(2); c1[0] = a1.x; c1[1] = a1.y
        val types = allocArray<IntVar>(2); types[0] = PT_OBJECT; types[1] = PT_VECTOR2I
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectArgRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val types = allocArray<IntVar>(1); types[0] = PT_OBJECT
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithObjectArgRetLong(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment): Long =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val types = allocArray<IntVar>(1); types[0] = PT_OBJECT
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithObjectArgRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val types = allocArray<IntVar>(1); types[0] = PT_OBJECT
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithObjectArgRetTransform2D(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment): Transform2D =
    memScoped {
        val ret = allocArray<FloatVar>(6)
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val types = allocArray<IntVar>(1); types[0] = PT_OBJECT
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_TRANSFORM2D, ret)
        Transform2D(Vector2(ret[0].toDouble(), ret[1].toDouble()), Vector2(ret[2].toDouble(), ret[3].toDouble()), Vector2(ret[4].toDouble(), ret[5].toDouble()))
    }

fun ObjectCalls.ptrcallWithObjectArgRetUInt32(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment): Long =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val types = allocArray<IntVar>(1); types[0] = PT_OBJECT
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithObjectBoolLongArgs(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Boolean, a2: Long) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val c2 = alloc<LongVar>(); c2.value = a2
        val types = allocArray<IntVar>(3); types[0] = PT_OBJECT; types[1] = PT_BOOL; types[2] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectRect2BoolColorBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Rect2, a2: Boolean, a3: Color, a4: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.position.x.toFloat(); c1[1] = a1.position.y.toFloat(); c1[2] = a1.size.x.toFloat(); c1[3] = a1.size.y.toFloat()
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val c3 = allocArray<FloatVar>(4); c3[0] = a3.r; c3[1] = a3.g; c3[2] = a3.b; c3[3] = a3.a
        val c4 = alloc<ByteVar>(); c4.value = if (a4) 1 else 0
        val types = allocArray<IntVar>(5); types[0] = PT_OBJECT; types[1] = PT_RECT2; types[2] = PT_BOOL; types[3] = PT_COLOR; types[4] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectStringAndIntArgs(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: String, a2: Int) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val types = allocArray<IntVar>(3); types[0] = PT_OBJECT; types[1] = PT_STRING; types[2] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectTwoRect2AndColorArgs(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Rect2, a2: Rect2, a3: Color) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.position.x.toFloat(); c1[1] = a1.position.y.toFloat(); c1[2] = a1.size.x.toFloat(); c1[3] = a1.size.y.toFloat()
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.position.x.toFloat(); c2[1] = a2.position.y.toFloat(); c2[2] = a2.size.x.toFloat(); c2[3] = a2.size.y.toFloat()
        val c3 = allocArray<FloatVar>(4); c3[0] = a3.r; c3[1] = a3.g; c3[2] = a3.b; c3[3] = a3.a
        val types = allocArray<IntVar>(4); types[0] = PT_OBJECT; types[1] = PT_RECT2; types[2] = PT_RECT2; types[3] = PT_COLOR
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectTwoRect2ColorThreeDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Rect2, a2: Rect2, a3: Color, a4: Double, a5: Double, a6: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.position.x.toFloat(); c1[1] = a1.position.y.toFloat(); c1[2] = a1.size.x.toFloat(); c1[3] = a1.size.y.toFloat()
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.position.x.toFloat(); c2[1] = a2.position.y.toFloat(); c2[2] = a2.size.x.toFloat(); c2[3] = a2.size.y.toFloat()
        val c3 = allocArray<FloatVar>(4); c3[0] = a3.r; c3[1] = a3.g; c3[2] = a3.b; c3[3] = a3.a
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val c5 = alloc<DoubleVar>(); c5.value = a5
        val c6 = alloc<DoubleVar>(); c6.value = a6
        val types = allocArray<IntVar>(7); types[0] = PT_OBJECT; types[1] = PT_RECT2; types[2] = PT_RECT2; types[3] = PT_COLOR; types[4] = PT_FLOAT64; types[5] = PT_FLOAT64; types[6] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(7); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 7, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectTwoRect2ColorTwoBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Rect2, a2: Rect2, a3: Color, a4: Boolean, a5: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.position.x.toFloat(); c1[1] = a1.position.y.toFloat(); c1[2] = a1.size.x.toFloat(); c1[3] = a1.size.y.toFloat()
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.position.x.toFloat(); c2[1] = a2.position.y.toFloat(); c2[2] = a2.size.x.toFloat(); c2[3] = a2.size.y.toFloat()
        val c3 = allocArray<FloatVar>(4); c3[0] = a3.r; c3[1] = a3.g; c3[2] = a3.b; c3[3] = a3.a
        val c4 = alloc<ByteVar>(); c4.value = if (a4) 1 else 0
        val c5 = alloc<ByteVar>(); c5.value = if (a5) 1 else 0
        val types = allocArray<IntVar>(6); types[0] = PT_OBJECT; types[1] = PT_RECT2; types[2] = PT_RECT2; types[3] = PT_COLOR; types[4] = PT_BOOL; types[5] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(6); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 6, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectVector2AndColorArgs(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Vector2, a2: Color) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.r; c2[1] = a2.g; c2[2] = a2.b; c2[3] = a2.a
        val types = allocArray<IntVar>(3); types[0] = PT_OBJECT; types[1] = PT_VECTOR2; types[2] = PT_COLOR
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectVector2StringIntColorDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Vector2, a2: String, a3: Int, a4: Color, a5: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c3 = alloc<LongVar>(); c3.value = a3.toLong()
        val c4 = allocArray<FloatVar>(4); c4[0] = a4.r; c4[1] = a4.g; c4[2] = a4.b; c4[3] = a4.a
        val c5 = alloc<DoubleVar>(); c5.value = a5
        val types = allocArray<IntVar>(6); types[0] = PT_OBJECT; types[1] = PT_VECTOR2; types[2] = PT_STRING; types[3] = PT_INT64; types[4] = PT_COLOR; types[5] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(6); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 6, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectVector2StringLongDoubleIntColorThreeLongDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Vector2, a2: String, a3: Long, a4: Double, a5: Int, a6: Color, a7: Long, a8: Long, a9: Long, a10: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c3 = alloc<LongVar>(); c3.value = a3
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val c5 = alloc<LongVar>(); c5.value = a5.toLong()
        val c6 = allocArray<FloatVar>(4); c6[0] = a6.r; c6[1] = a6.g; c6[2] = a6.b; c6[3] = a6.a
        val c7 = alloc<LongVar>(); c7.value = a7
        val c8 = alloc<LongVar>(); c8.value = a8
        val c9 = alloc<LongVar>(); c9.value = a9
        val c10 = alloc<DoubleVar>(); c10.value = a10
        val types = allocArray<IntVar>(11); types[0] = PT_OBJECT; types[1] = PT_VECTOR2; types[2] = PT_STRING; types[3] = PT_INT64; types[4] = PT_FLOAT64; types[5] = PT_INT64; types[6] = PT_COLOR; types[7] = PT_INT64; types[8] = PT_INT64; types[9] = PT_INT64; types[10] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(11); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.reinterpret<CPointed>(); ptrs[7] = c7.ptr.reinterpret<CPointed>(); ptrs[8] = c8.ptr.reinterpret<CPointed>(); ptrs[9] = c9.ptr.reinterpret<CPointed>(); ptrs[10] = c10.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 11, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectVector2StringLongDoubleThreeIntColorFourLongDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Vector2, a2: String, a3: Long, a4: Double, a5: Int, a6: Int, a7: Int, a8: Color, a9: Long, a10: Long, a11: Long, a12: Long, a13: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c3 = alloc<LongVar>(); c3.value = a3
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val c5 = alloc<LongVar>(); c5.value = a5.toLong()
        val c6 = alloc<LongVar>(); c6.value = a6.toLong()
        val c7 = alloc<LongVar>(); c7.value = a7.toLong()
        val c8 = allocArray<FloatVar>(4); c8[0] = a8.r; c8[1] = a8.g; c8[2] = a8.b; c8[3] = a8.a
        val c9 = alloc<LongVar>(); c9.value = a9
        val c10 = alloc<LongVar>(); c10.value = a10
        val c11 = alloc<LongVar>(); c11.value = a11
        val c12 = alloc<LongVar>(); c12.value = a12
        val c13 = alloc<DoubleVar>(); c13.value = a13
        val types = allocArray<IntVar>(14); types[0] = PT_OBJECT; types[1] = PT_VECTOR2; types[2] = PT_STRING; types[3] = PT_INT64; types[4] = PT_FLOAT64; types[5] = PT_INT64; types[6] = PT_INT64; types[7] = PT_INT64; types[8] = PT_COLOR; types[9] = PT_INT64; types[10] = PT_INT64; types[11] = PT_INT64; types[12] = PT_INT64; types[13] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(14); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>(); ptrs[7] = c7.ptr.reinterpret<CPointed>(); ptrs[8] = c8.reinterpret<CPointed>(); ptrs[9] = c9.ptr.reinterpret<CPointed>(); ptrs[10] = c10.ptr.reinterpret<CPointed>(); ptrs[11] = c11.ptr.reinterpret<CPointed>(); ptrs[12] = c12.ptr.reinterpret<CPointed>(); ptrs[13] = c13.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 14, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectVector2StringLongDoubleTwoIntColorFourLongDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Vector2, a2: String, a3: Long, a4: Double, a5: Int, a6: Int, a7: Color, a8: Long, a9: Long, a10: Long, a11: Long, a12: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c3 = alloc<LongVar>(); c3.value = a3
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val c5 = alloc<LongVar>(); c5.value = a5.toLong()
        val c6 = alloc<LongVar>(); c6.value = a6.toLong()
        val c7 = allocArray<FloatVar>(4); c7[0] = a7.r; c7[1] = a7.g; c7[2] = a7.b; c7[3] = a7.a
        val c8 = alloc<LongVar>(); c8.value = a8
        val c9 = alloc<LongVar>(); c9.value = a9
        val c10 = alloc<LongVar>(); c10.value = a10
        val c11 = alloc<LongVar>(); c11.value = a11
        val c12 = alloc<DoubleVar>(); c12.value = a12
        val types = allocArray<IntVar>(13); types[0] = PT_OBJECT; types[1] = PT_VECTOR2; types[2] = PT_STRING; types[3] = PT_INT64; types[4] = PT_FLOAT64; types[5] = PT_INT64; types[6] = PT_INT64; types[7] = PT_COLOR; types[8] = PT_INT64; types[9] = PT_INT64; types[10] = PT_INT64; types[11] = PT_INT64; types[12] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(13); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>(); ptrs[7] = c7.reinterpret<CPointed>(); ptrs[8] = c8.ptr.reinterpret<CPointed>(); ptrs[9] = c9.ptr.reinterpret<CPointed>(); ptrs[10] = c10.ptr.reinterpret<CPointed>(); ptrs[11] = c11.ptr.reinterpret<CPointed>(); ptrs[12] = c12.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 13, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectVector2StringLongDoubleTwoIntColorThreeLongDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Vector2, a2: String, a3: Long, a4: Double, a5: Int, a6: Int, a7: Color, a8: Long, a9: Long, a10: Long, a11: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c3 = alloc<LongVar>(); c3.value = a3
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val c5 = alloc<LongVar>(); c5.value = a5.toLong()
        val c6 = alloc<LongVar>(); c6.value = a6.toLong()
        val c7 = allocArray<FloatVar>(4); c7[0] = a7.r; c7[1] = a7.g; c7[2] = a7.b; c7[3] = a7.a
        val c8 = alloc<LongVar>(); c8.value = a8
        val c9 = alloc<LongVar>(); c9.value = a9
        val c10 = alloc<LongVar>(); c10.value = a10
        val c11 = alloc<DoubleVar>(); c11.value = a11
        val types = allocArray<IntVar>(12); types[0] = PT_OBJECT; types[1] = PT_VECTOR2; types[2] = PT_STRING; types[3] = PT_INT64; types[4] = PT_FLOAT64; types[5] = PT_INT64; types[6] = PT_INT64; types[7] = PT_COLOR; types[8] = PT_INT64; types[9] = PT_INT64; types[10] = PT_INT64; types[11] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(12); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>(); ptrs[7] = c7.reinterpret<CPointed>(); ptrs[8] = c8.ptr.reinterpret<CPointed>(); ptrs[9] = c9.ptr.reinterpret<CPointed>(); ptrs[10] = c10.ptr.reinterpret<CPointed>(); ptrs[11] = c11.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 12, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectVector2StringTwoIntColorDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Vector2, a2: String, a3: Int, a4: Int, a5: Color, a6: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c3 = alloc<LongVar>(); c3.value = a3.toLong()
        val c4 = alloc<LongVar>(); c4.value = a4.toLong()
        val c5 = allocArray<FloatVar>(4); c5[0] = a5.r; c5[1] = a5.g; c5[2] = a5.b; c5[3] = a5.a
        val c6 = alloc<DoubleVar>(); c6.value = a6
        val types = allocArray<IntVar>(7); types[0] = PT_OBJECT; types[1] = PT_VECTOR2; types[2] = PT_STRING; types[3] = PT_INT64; types[4] = PT_INT64; types[5] = PT_COLOR; types[6] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(7); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 7, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithObjectVector2iAndDoubleArg(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: Vector2i, a2: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = allocArray<IntVar>(2); c1[0] = a1.x; c1[1] = a1.y
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val types = allocArray<IntVar>(3); types[0] = PT_OBJECT; types[1] = PT_VECTOR2I; types[2] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithQuaternionArg(methodBind: MemorySegment, instance: MemorySegment, a0: Quaternion) =
    memScoped {
        val c0 = allocArray<FloatVar>(4); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat(); c0[2] = a0.z.toFloat(); c0[3] = a0.w.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_QUATERNION
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithRIDAndColorArg(methodBind: MemorySegment, instance: MemorySegment, a0: RID, a1: Color) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.value
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.r; c1[1] = a1.g; c1[2] = a1.b; c1[3] = a1.a
        val types = allocArray<IntVar>(2); types[0] = PT_RID; types[1] = PT_COLOR
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithRIDAndRect2Arg(methodBind: MemorySegment, instance: MemorySegment, a0: RID, a1: Rect2) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.value
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.position.x.toFloat(); c1[1] = a1.position.y.toFloat(); c1[2] = a1.size.x.toFloat(); c1[3] = a1.size.y.toFloat()
        val types = allocArray<IntVar>(2); types[0] = PT_RID; types[1] = PT_RECT2
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithRIDArg(methodBind: MemorySegment, instance: MemorySegment, a0: RID) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.value
        val types = allocArray<IntVar>(1); types[0] = PT_RID
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithRIDArgRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: RID): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.value
        val types = allocArray<IntVar>(1); types[0] = PT_RID
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithRIDArgRetVector2i(methodBind: MemorySegment, instance: MemorySegment, a0: RID): Vector2i =
    memScoped {
        val ret = allocArray<IntVar>(2)
        val c0 = alloc<LongVar>(); c0.value = a0.value
        val types = allocArray<IntVar>(1); types[0] = PT_RID
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VECTOR2I, ret)
        Vector2i(ret[0], ret[1])
    }

fun ObjectCalls.ptrcallWithRIDRect2BoolColorBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: RID, a1: Rect2, a2: Boolean, a3: Color, a4: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.value
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.position.x.toFloat(); c1[1] = a1.position.y.toFloat(); c1[2] = a1.size.x.toFloat(); c1[3] = a1.size.y.toFloat()
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val c3 = allocArray<FloatVar>(4); c3[0] = a3.r; c3[1] = a3.g; c3[2] = a3.b; c3[3] = a3.a
        val c4 = alloc<ByteVar>(); c4.value = if (a4) 1 else 0
        val types = allocArray<IntVar>(5); types[0] = PT_RID; types[1] = PT_RECT2; types[2] = PT_BOOL; types[3] = PT_COLOR; types[4] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithRIDTwoRect2ColorTwoBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: RID, a1: Rect2, a2: Rect2, a3: Color, a4: Boolean, a5: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.value
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.position.x.toFloat(); c1[1] = a1.position.y.toFloat(); c1[2] = a1.size.x.toFloat(); c1[3] = a1.size.y.toFloat()
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.position.x.toFloat(); c2[1] = a2.position.y.toFloat(); c2[2] = a2.size.x.toFloat(); c2[3] = a2.size.y.toFloat()
        val c3 = allocArray<FloatVar>(4); c3[0] = a3.r; c3[1] = a3.g; c3[2] = a3.b; c3[3] = a3.a
        val c4 = alloc<ByteVar>(); c4.value = if (a4) 1 else 0
        val c5 = alloc<ByteVar>(); c5.value = if (a5) 1 else 0
        val types = allocArray<IntVar>(6); types[0] = PT_RID; types[1] = PT_RECT2; types[2] = PT_RECT2; types[3] = PT_COLOR; types[4] = PT_BOOL; types[5] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(6); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 6, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithRIDVector2ColorBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: RID, a1: Vector2, a2: Color, a3: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.value
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.r; c2[1] = a2.g; c2[2] = a2.b; c2[3] = a2.a
        val c3 = alloc<ByteVar>(); c3.value = if (a3) 1 else 0
        val types = allocArray<IntVar>(4); types[0] = PT_RID; types[1] = PT_VECTOR2; types[2] = PT_COLOR; types[3] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithRIDVector2StringLongDoubleIntColorThreeLongDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: RID, a1: Vector2, a2: String, a3: Long, a4: Double, a5: Int, a6: Color, a7: Long, a8: Long, a9: Long, a10: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.value
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c3 = alloc<LongVar>(); c3.value = a3
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val c5 = alloc<LongVar>(); c5.value = a5.toLong()
        val c6 = allocArray<FloatVar>(4); c6[0] = a6.r; c6[1] = a6.g; c6[2] = a6.b; c6[3] = a6.a
        val c7 = alloc<LongVar>(); c7.value = a7
        val c8 = alloc<LongVar>(); c8.value = a8
        val c9 = alloc<LongVar>(); c9.value = a9
        val c10 = alloc<DoubleVar>(); c10.value = a10
        val types = allocArray<IntVar>(11); types[0] = PT_RID; types[1] = PT_VECTOR2; types[2] = PT_STRING; types[3] = PT_INT64; types[4] = PT_FLOAT64; types[5] = PT_INT64; types[6] = PT_COLOR; types[7] = PT_INT64; types[8] = PT_INT64; types[9] = PT_INT64; types[10] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(11); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.reinterpret<CPointed>(); ptrs[7] = c7.ptr.reinterpret<CPointed>(); ptrs[8] = c8.ptr.reinterpret<CPointed>(); ptrs[9] = c9.ptr.reinterpret<CPointed>(); ptrs[10] = c10.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 11, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithRIDVector2StringLongDoubleThreeIntColorFourLongDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: RID, a1: Vector2, a2: String, a3: Long, a4: Double, a5: Int, a6: Int, a7: Int, a8: Color, a9: Long, a10: Long, a11: Long, a12: Long, a13: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.value
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c3 = alloc<LongVar>(); c3.value = a3
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val c5 = alloc<LongVar>(); c5.value = a5.toLong()
        val c6 = alloc<LongVar>(); c6.value = a6.toLong()
        val c7 = alloc<LongVar>(); c7.value = a7.toLong()
        val c8 = allocArray<FloatVar>(4); c8[0] = a8.r; c8[1] = a8.g; c8[2] = a8.b; c8[3] = a8.a
        val c9 = alloc<LongVar>(); c9.value = a9
        val c10 = alloc<LongVar>(); c10.value = a10
        val c11 = alloc<LongVar>(); c11.value = a11
        val c12 = alloc<LongVar>(); c12.value = a12
        val c13 = alloc<DoubleVar>(); c13.value = a13
        val types = allocArray<IntVar>(14); types[0] = PT_RID; types[1] = PT_VECTOR2; types[2] = PT_STRING; types[3] = PT_INT64; types[4] = PT_FLOAT64; types[5] = PT_INT64; types[6] = PT_INT64; types[7] = PT_INT64; types[8] = PT_COLOR; types[9] = PT_INT64; types[10] = PT_INT64; types[11] = PT_INT64; types[12] = PT_INT64; types[13] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(14); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>(); ptrs[7] = c7.ptr.reinterpret<CPointed>(); ptrs[8] = c8.reinterpret<CPointed>(); ptrs[9] = c9.ptr.reinterpret<CPointed>(); ptrs[10] = c10.ptr.reinterpret<CPointed>(); ptrs[11] = c11.ptr.reinterpret<CPointed>(); ptrs[12] = c12.ptr.reinterpret<CPointed>(); ptrs[13] = c13.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 14, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithRIDVector2StringLongDoubleTwoIntColorFourLongDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: RID, a1: Vector2, a2: String, a3: Long, a4: Double, a5: Int, a6: Int, a7: Color, a8: Long, a9: Long, a10: Long, a11: Long, a12: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.value
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c3 = alloc<LongVar>(); c3.value = a3
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val c5 = alloc<LongVar>(); c5.value = a5.toLong()
        val c6 = alloc<LongVar>(); c6.value = a6.toLong()
        val c7 = allocArray<FloatVar>(4); c7[0] = a7.r; c7[1] = a7.g; c7[2] = a7.b; c7[3] = a7.a
        val c8 = alloc<LongVar>(); c8.value = a8
        val c9 = alloc<LongVar>(); c9.value = a9
        val c10 = alloc<LongVar>(); c10.value = a10
        val c11 = alloc<LongVar>(); c11.value = a11
        val c12 = alloc<DoubleVar>(); c12.value = a12
        val types = allocArray<IntVar>(13); types[0] = PT_RID; types[1] = PT_VECTOR2; types[2] = PT_STRING; types[3] = PT_INT64; types[4] = PT_FLOAT64; types[5] = PT_INT64; types[6] = PT_INT64; types[7] = PT_COLOR; types[8] = PT_INT64; types[9] = PT_INT64; types[10] = PT_INT64; types[11] = PT_INT64; types[12] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(13); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>(); ptrs[7] = c7.reinterpret<CPointed>(); ptrs[8] = c8.ptr.reinterpret<CPointed>(); ptrs[9] = c9.ptr.reinterpret<CPointed>(); ptrs[10] = c10.ptr.reinterpret<CPointed>(); ptrs[11] = c11.ptr.reinterpret<CPointed>(); ptrs[12] = c12.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 13, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithRIDVector2StringLongDoubleTwoIntColorThreeLongDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: RID, a1: Vector2, a2: String, a3: Long, a4: Double, a5: Int, a6: Int, a7: Color, a8: Long, a9: Long, a10: Long, a11: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.value
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c3 = alloc<LongVar>(); c3.value = a3
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val c5 = alloc<LongVar>(); c5.value = a5.toLong()
        val c6 = alloc<LongVar>(); c6.value = a6.toLong()
        val c7 = allocArray<FloatVar>(4); c7[0] = a7.r; c7[1] = a7.g; c7[2] = a7.b; c7[3] = a7.a
        val c8 = alloc<LongVar>(); c8.value = a8
        val c9 = alloc<LongVar>(); c9.value = a9
        val c10 = alloc<LongVar>(); c10.value = a10
        val c11 = alloc<DoubleVar>(); c11.value = a11
        val types = allocArray<IntVar>(12); types[0] = PT_RID; types[1] = PT_VECTOR2; types[2] = PT_STRING; types[3] = PT_INT64; types[4] = PT_FLOAT64; types[5] = PT_INT64; types[6] = PT_INT64; types[7] = PT_COLOR; types[8] = PT_INT64; types[9] = PT_INT64; types[10] = PT_INT64; types[11] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(12); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>(); ptrs[7] = c7.reinterpret<CPointed>(); ptrs[8] = c8.ptr.reinterpret<CPointed>(); ptrs[9] = c9.ptr.reinterpret<CPointed>(); ptrs[10] = c10.ptr.reinterpret<CPointed>(); ptrs[11] = c11.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 12, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithRIDVector2ThreeIntColorDoubleArgsRetDouble(methodBind: MemorySegment, instance: MemorySegment, a0: RID, a1: Vector2, a2: Int, a3: Int, a4: Int, a5: Color, a6: Double): Double =
    memScoped {
        val ret = alloc<DoubleVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.value
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val c3 = alloc<LongVar>(); c3.value = a3.toLong()
        val c4 = alloc<LongVar>(); c4.value = a4.toLong()
        val c5 = allocArray<FloatVar>(4); c5[0] = a5.r; c5[1] = a5.g; c5[2] = a5.b; c5[3] = a5.a
        val c6 = alloc<DoubleVar>(); c6.value = a6
        val types = allocArray<IntVar>(7); types[0] = PT_RID; types[1] = PT_VECTOR2; types[2] = PT_INT64; types[3] = PT_INT64; types[4] = PT_INT64; types[5] = PT_COLOR; types[6] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(7); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 7, PT_FLOAT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithRIDVector2TwoIntColorDoubleArgsRetDouble(methodBind: MemorySegment, instance: MemorySegment, a0: RID, a1: Vector2, a2: Int, a3: Int, a4: Color, a5: Double): Double =
    memScoped {
        val ret = alloc<DoubleVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.value
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val c3 = alloc<LongVar>(); c3.value = a3.toLong()
        val c4 = allocArray<FloatVar>(4); c4[0] = a4.r; c4[1] = a4.g; c4[2] = a4.b; c4[3] = a4.a
        val c5 = alloc<DoubleVar>(); c5.value = a5
        val types = allocArray<IntVar>(6); types[0] = PT_RID; types[1] = PT_VECTOR2; types[2] = PT_INT64; types[3] = PT_INT64; types[4] = PT_COLOR; types[5] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(6); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 6, PT_FLOAT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithRect2ColorBoolDoubleBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Rect2, a1: Color, a2: Boolean, a3: Double, a4: Boolean) =
    memScoped {
        val c0 = allocArray<FloatVar>(4); c0[0] = a0.position.x.toFloat(); c0[1] = a0.position.y.toFloat(); c0[2] = a0.size.x.toFloat(); c0[3] = a0.size.y.toFloat()
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.r; c1[1] = a1.g; c1[2] = a1.b; c1[3] = a1.a
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val c4 = alloc<ByteVar>(); c4.value = if (a4) 1 else 0
        val types = allocArray<IntVar>(5); types[0] = PT_RECT2; types[1] = PT_COLOR; types[2] = PT_BOOL; types[3] = PT_FLOAT64; types[4] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringAndDoubleArgRetLong(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Double): Long =
    memScoped {
        val ret = alloc<LongVar>()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_STRING; types[1] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_INT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithStringAndIntArg(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Int) =
    memScoped {
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_STRING; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringAndTwoBoolArgsRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Boolean, a2: Boolean): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val types = allocArray<IntVar>(3); types[0] = PT_STRING; types[1] = PT_BOOL; types[2] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithStringArg(methodBind: MemorySegment, instance: MemorySegment, a0: String) =
    memScoped {
        val types = allocArray<IntVar>(1); types[0] = PT_STRING
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringArgRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: String): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val types = allocArray<IntVar>(1); types[0] = PT_STRING
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithStringArgRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: String): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val types = allocArray<IntVar>(1); types[0] = PT_STRING
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithStringArgRetLong(methodBind: MemorySegment, instance: MemorySegment, a0: String): Long =
    memScoped {
        val ret = alloc<LongVar>()
        val types = allocArray<IntVar>(1); types[0] = PT_STRING
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithStringArgRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: String): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val types = allocArray<IntVar>(1); types[0] = PT_STRING
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithStringBoolDoubleArgsRetLong(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Boolean, a2: Double): Long =
    memScoped {
        val ret = alloc<LongVar>()
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val types = allocArray<IntVar>(3); types[0] = PT_STRING; types[1] = PT_BOOL; types[2] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_INT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithStringLongDoubleIntThreeLongArgsRetVector2(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Long, a2: Double, a3: Int, a4: Long, a5: Long, a6: Long): Vector2 =
    memScoped {
        val ret = allocArray<FloatVar>(2)
        val c1 = alloc<LongVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = alloc<LongVar>(); c3.value = a3.toLong()
        val c4 = alloc<LongVar>(); c4.value = a4
        val c5 = alloc<LongVar>(); c5.value = a5
        val c6 = alloc<LongVar>(); c6.value = a6
        val types = allocArray<IntVar>(7); types[0] = PT_STRING; types[1] = PT_INT64; types[2] = PT_FLOAT64; types[3] = PT_INT64; types[4] = PT_INT64; types[5] = PT_INT64; types[6] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(7); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 7, PT_VECTOR2, ret)
        Vector2(ret[0].toDouble(), ret[1].toDouble())
    }

fun ObjectCalls.ptrcallWithStringLongDoubleTwoIntFourLongArgsRetVector2(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Long, a2: Double, a3: Int, a4: Int, a5: Long, a6: Long, a7: Long, a8: Long): Vector2 =
    memScoped {
        val ret = allocArray<FloatVar>(2)
        val c1 = alloc<LongVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = alloc<LongVar>(); c3.value = a3.toLong()
        val c4 = alloc<LongVar>(); c4.value = a4.toLong()
        val c5 = alloc<LongVar>(); c5.value = a5
        val c6 = alloc<LongVar>(); c6.value = a6
        val c7 = alloc<LongVar>(); c7.value = a7
        val c8 = alloc<LongVar>(); c8.value = a8
        val types = allocArray<IntVar>(9); types[0] = PT_STRING; types[1] = PT_INT64; types[2] = PT_FLOAT64; types[3] = PT_INT64; types[4] = PT_INT64; types[5] = PT_INT64; types[6] = PT_INT64; types[7] = PT_INT64; types[8] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(9); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>(); ptrs[7] = c7.ptr.reinterpret<CPointed>(); ptrs[8] = c8.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 9, PT_VECTOR2, ret)
        Vector2(ret[0].toDouble(), ret[1].toDouble())
    }

fun ObjectCalls.ptrcallWithStringNameAndBoolArg(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Boolean) =
    memScoped {
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val types = allocArray<IntVar>(2); types[0] = PT_STRING_NAME; types[1] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringNameAndColorArg(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Color) =
    memScoped {
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.r; c1[1] = a1.g; c1[2] = a1.b; c1[3] = a1.a
        val types = allocArray<IntVar>(2); types[0] = PT_STRING_NAME; types[1] = PT_COLOR
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringNameAndDoubleArg(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Double) =
    memScoped {
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_STRING_NAME; types[1] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringNameAndIntArg(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Int) =
    memScoped {
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_STRING_NAME; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringNameAndObjectArg(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: MemorySegment) =
    memScoped {
        val c1 = alloc<LongVar>(); c1.value = a1.address()
        val types = allocArray<IntVar>(2); types[0] = PT_STRING_NAME; types[1] = PT_OBJECT
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringNameAndObjectArgRetLong(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: MemorySegment): Long =
    memScoped {
        val ret = alloc<LongVar>()
        val c1 = alloc<LongVar>(); c1.value = a1.address()
        val types = allocArray<IntVar>(2); types[0] = PT_STRING_NAME; types[1] = PT_OBJECT
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_INT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithStringNameAndThreeDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Double, a2: Double, a3: Double) =
    memScoped {
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val types = allocArray<IntVar>(4); types[0] = PT_STRING_NAME; types[1] = PT_FLOAT64; types[2] = PT_FLOAT64; types[3] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringNameArg(methodBind: MemorySegment, instance: MemorySegment, a0: String) =
    memScoped {
        val types = allocArray<IntVar>(1); types[0] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringNameArgRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: String): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val types = allocArray<IntVar>(1); types[0] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithStringNameArgRetColor(methodBind: MemorySegment, instance: MemorySegment, a0: String): Color =
    memScoped {
        val ret = allocArray<FloatVar>(4)
        val types = allocArray<IntVar>(1); types[0] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_COLOR, ret)
        Color(ret[0], ret[1], ret[2], ret[3])
    }

fun ObjectCalls.ptrcallWithStringNameArgRetDouble(methodBind: MemorySegment, instance: MemorySegment, a0: String): Double =
    memScoped {
        val ret = alloc<DoubleVar>()
        val types = allocArray<IntVar>(1); types[0] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_FLOAT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithStringNameArgRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: String): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val types = allocArray<IntVar>(1); types[0] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithStringNameArgRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: String): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val types = allocArray<IntVar>(1); types[0] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithStringNameDoubleBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Double, a2: Boolean) =
    memScoped {
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val types = allocArray<IntVar>(3); types[0] = PT_STRING_NAME; types[1] = PT_FLOAT64; types[2] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringNameDoubleDoubleBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Double, a2: Double, a3: Boolean) =
    memScoped {
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = alloc<ByteVar>(); c3.value = if (a3) 1 else 0
        val types = allocArray<IntVar>(4); types[0] = PT_STRING_NAME; types[1] = PT_FLOAT64; types[2] = PT_FLOAT64; types[3] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringNameDoubleTwoLongArgs(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Double, a2: Long, a3: Long) =
    memScoped {
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<LongVar>(); c2.value = a2
        val c3 = alloc<LongVar>(); c3.value = a3
        val types = allocArray<IntVar>(4); types[0] = PT_STRING_NAME; types[1] = PT_FLOAT64; types[2] = PT_INT64; types[3] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringNameFourDoubleBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Double, a2: Double, a3: Double, a4: Double, a5: Boolean) =
    memScoped {
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val c5 = alloc<ByteVar>(); c5.value = if (a5) 1 else 0
        val types = allocArray<IntVar>(6); types[0] = PT_STRING_NAME; types[1] = PT_FLOAT64; types[2] = PT_FLOAT64; types[3] = PT_FLOAT64; types[4] = PT_FLOAT64; types[5] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(6); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 6, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringNameThreeDoubleBoolTwoLongArgs(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Double, a2: Double, a3: Double, a4: Boolean, a5: Long, a6: Long) =
    memScoped {
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val c4 = alloc<ByteVar>(); c4.value = if (a4) 1 else 0
        val c5 = alloc<LongVar>(); c5.value = a5
        val c6 = alloc<LongVar>(); c6.value = a6
        val types = allocArray<IntVar>(7); types[0] = PT_STRING_NAME; types[1] = PT_FLOAT64; types[2] = PT_FLOAT64; types[3] = PT_FLOAT64; types[4] = PT_BOOL; types[5] = PT_INT64; types[6] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(7); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 7, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringObjectIntRect2ColorIntColorArgs(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: MemorySegment, a2: Int, a3: Rect2, a4: Color, a5: Int, a6: Color) =
    memScoped {
        val c1 = alloc<LongVar>(); c1.value = a1.address()
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val c3 = allocArray<FloatVar>(4); c3[0] = a3.position.x.toFloat(); c3[1] = a3.position.y.toFloat(); c3[2] = a3.size.x.toFloat(); c3[3] = a3.size.y.toFloat()
        val c4 = allocArray<FloatVar>(4); c4[0] = a4.r; c4[1] = a4.g; c4[2] = a4.b; c4[3] = a4.a
        val c5 = alloc<LongVar>(); c5.value = a5.toLong()
        val c6 = allocArray<FloatVar>(4); c6[0] = a6.r; c6[1] = a6.g; c6[2] = a6.b; c6[3] = a6.a
        val types = allocArray<IntVar>(7); types[0] = PT_STRING; types[1] = PT_OBJECT; types[2] = PT_INT64; types[3] = PT_RECT2; types[4] = PT_COLOR; types[5] = PT_INT64; types[6] = PT_COLOR
        val ptrs = allocArray<COpaquePointerVar>(7); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.reinterpret<CPointed>(); ptrs[4] = c4.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 7, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringTwoBoolAndDoubleArgRetLong(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Boolean, a2: Boolean, a3: Double): Long =
    memScoped {
        val ret = alloc<LongVar>()
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val types = allocArray<IntVar>(4); types[0] = PT_STRING; types[1] = PT_BOOL; types[2] = PT_BOOL; types[3] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_INT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithStringTwoIntTwoBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Int, a2: Int, a3: Boolean, a4: Boolean) =
    memScoped {
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val c3 = alloc<ByteVar>(); c3.value = if (a3) 1 else 0
        val c4 = alloc<ByteVar>(); c4.value = if (a4) 1 else 0
        val types = allocArray<IntVar>(5); types[0] = PT_STRING; types[1] = PT_INT64; types[2] = PT_INT64; types[3] = PT_BOOL; types[4] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithStringUInt32TwoIntArgsRetVector2i(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Long, a2: Int, a3: Int): Vector2i =
    memScoped {
        val ret = allocArray<IntVar>(2)
        val c1 = alloc<LongVar>(); c1.value = a1
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val c3 = alloc<LongVar>(); c3.value = a3.toLong()
        val types = allocArray<IntVar>(4); types[0] = PT_STRING; types[1] = PT_INT64; types[2] = PT_INT64; types[3] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VECTOR2I, ret)
        Vector2i(ret[0], ret[1])
    }

fun ObjectCalls.ptrcallWithThreeDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Double, a1: Double, a2: Double) =
    memScoped {
        val c0 = alloc<DoubleVar>(); c0.value = a0
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val types = allocArray<IntVar>(3); types[0] = PT_FLOAT64; types[1] = PT_FLOAT64; types[2] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithThreeIntArgsRetVector2i(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: Int): Vector2i =
    memScoped {
        val ret = allocArray<IntVar>(2)
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VECTOR2I, ret)
        Vector2i(ret[0], ret[1])
    }

fun ObjectCalls.ptrcallWithThreeLongArgsRetLong(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Long, a2: Long): Long =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<LongVar>(); c1.value = a1
        val c2 = alloc<LongVar>(); c2.value = a2
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_INT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithThreeStringNameAndDoubleArg(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: String, a2: String, a3: Double) =
    memScoped {
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val types = allocArray<IntVar>(4); types[0] = PT_STRING_NAME; types[1] = PT_STRING_NAME; types[2] = PT_STRING_NAME; types[3] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithThreeStringNameArgs(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: String, a2: String) =
    memScoped {
        val types = allocArray<IntVar>(3); types[0] = PT_STRING_NAME; types[1] = PT_STRING_NAME; types[2] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithThreeStringNameTwoDoubleBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: String, a2: String, a3: Double, a4: Double, a5: Boolean) =
    memScoped {
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val c5 = alloc<ByteVar>(); c5.value = if (a5) 1 else 0
        val types = allocArray<IntVar>(6); types[0] = PT_STRING_NAME; types[1] = PT_STRING_NAME; types[2] = PT_STRING_NAME; types[3] = PT_FLOAT64; types[4] = PT_FLOAT64; types[5] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(6); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 6, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithThreeVector3AndBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Vector3, a1: Vector3, a2: Vector3, a3: Boolean) =
    memScoped {
        val c0 = allocArray<FloatVar>(3); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat(); c0[2] = a0.z.toFloat()
        val c1 = allocArray<FloatVar>(3); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat(); c1[2] = a1.z.toFloat()
        val c2 = allocArray<FloatVar>(3); c2[0] = a2.x.toFloat(); c2[1] = a2.y.toFloat(); c2[2] = a2.z.toFloat()
        val c3 = alloc<ByteVar>(); c3.value = if (a3) 1 else 0
        val types = allocArray<IntVar>(4); types[0] = PT_VECTOR3; types[1] = PT_VECTOR3; types[2] = PT_VECTOR3; types[3] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTransform2DArg(methodBind: MemorySegment, instance: MemorySegment, a0: Transform2D) =
    memScoped {
        val c0 = allocArray<FloatVar>(6); c0[0] = a0.x.x.toFloat(); c0[1] = a0.x.y.toFloat(); c0[2] = a0.y.x.toFloat(); c0[3] = a0.y.y.toFloat(); c0[4] = a0.origin.x.toFloat(); c0[5] = a0.origin.y.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_TRANSFORM2D
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTransform2DObjectTransform2DArgsRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Transform2D, a1: MemorySegment, a2: Transform2D): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = allocArray<FloatVar>(6); c0[0] = a0.x.x.toFloat(); c0[1] = a0.x.y.toFloat(); c0[2] = a0.y.x.toFloat(); c0[3] = a0.y.y.toFloat(); c0[4] = a0.origin.x.toFloat(); c0[5] = a0.origin.y.toFloat()
        val c1 = alloc<LongVar>(); c1.value = a1.address()
        val c2 = allocArray<FloatVar>(6); c2[0] = a2.x.x.toFloat(); c2[1] = a2.x.y.toFloat(); c2[2] = a2.y.x.toFloat(); c2[3] = a2.y.y.toFloat(); c2[4] = a2.origin.x.toFloat(); c2[5] = a2.origin.y.toFloat()
        val types = allocArray<IntVar>(3); types[0] = PT_TRANSFORM2D; types[1] = PT_OBJECT; types[2] = PT_TRANSFORM2D
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithTransform2DVector2ObjectTransform2DVector2ArgsRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Transform2D, a1: Vector2, a2: MemorySegment, a3: Transform2D, a4: Vector2): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = allocArray<FloatVar>(6); c0[0] = a0.x.x.toFloat(); c0[1] = a0.x.y.toFloat(); c0[2] = a0.y.x.toFloat(); c0[3] = a0.y.y.toFloat(); c0[4] = a0.origin.x.toFloat(); c0[5] = a0.origin.y.toFloat()
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c2 = alloc<LongVar>(); c2.value = a2.address()
        val c3 = allocArray<FloatVar>(6); c3[0] = a3.x.x.toFloat(); c3[1] = a3.x.y.toFloat(); c3[2] = a3.y.x.toFloat(); c3[3] = a3.y.y.toFloat(); c3[4] = a3.origin.x.toFloat(); c3[5] = a3.origin.y.toFloat()
        val c4 = allocArray<FloatVar>(2); c4[0] = a4.x.toFloat(); c4[1] = a4.y.toFloat()
        val types = allocArray<IntVar>(5); types[0] = PT_TRANSFORM2D; types[1] = PT_VECTOR2; types[2] = PT_OBJECT; types[3] = PT_TRANSFORM2D; types[4] = PT_VECTOR2
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.reinterpret<CPointed>(); ptrs[4] = c4.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithTransform2DVector2TwoColorUInt32Args(methodBind: MemorySegment, instance: MemorySegment, a0: Transform2D, a1: Vector2, a2: Color, a3: Color, a4: Long) =
    memScoped {
        val c0 = allocArray<FloatVar>(6); c0[0] = a0.x.x.toFloat(); c0[1] = a0.x.y.toFloat(); c0[2] = a0.y.x.toFloat(); c0[3] = a0.y.y.toFloat(); c0[4] = a0.origin.x.toFloat(); c0[5] = a0.origin.y.toFloat()
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.r; c2[1] = a2.g; c2[2] = a2.b; c2[3] = a2.a
        val c3 = allocArray<FloatVar>(4); c3[0] = a3.r; c3[1] = a3.g; c3[2] = a3.b; c3[3] = a3.a
        val c4 = alloc<LongVar>(); c4.value = a4
        val types = allocArray<IntVar>(5); types[0] = PT_TRANSFORM2D; types[1] = PT_VECTOR2; types[2] = PT_COLOR; types[3] = PT_COLOR; types[4] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTransform3DArg(methodBind: MemorySegment, instance: MemorySegment, a0: Transform3D) =
    memScoped {
        val c0 = allocArray<FloatVar>(12); c0[0] = a0.basis.x.x.toFloat(); c0[1] = a0.basis.y.x.toFloat(); c0[2] = a0.basis.z.x.toFloat(); c0[3] = a0.basis.x.y.toFloat(); c0[4] = a0.basis.y.y.toFloat(); c0[5] = a0.basis.z.y.toFloat(); c0[6] = a0.basis.x.z.toFloat(); c0[7] = a0.basis.y.z.toFloat(); c0[8] = a0.basis.z.z.toFloat(); c0[9] = a0.origin.x.toFloat(); c0[10] = a0.origin.y.toFloat(); c0[11] = a0.origin.z.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_TRANSFORM3D
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTransform3DVector3TwoColorUInt32Args(methodBind: MemorySegment, instance: MemorySegment, a0: Transform3D, a1: Vector3, a2: Color, a3: Color, a4: Long) =
    memScoped {
        val c0 = allocArray<FloatVar>(12); c0[0] = a0.basis.x.x.toFloat(); c0[1] = a0.basis.y.x.toFloat(); c0[2] = a0.basis.z.x.toFloat(); c0[3] = a0.basis.x.y.toFloat(); c0[4] = a0.basis.y.y.toFloat(); c0[5] = a0.basis.z.y.toFloat(); c0[6] = a0.basis.x.z.toFloat(); c0[7] = a0.basis.y.z.toFloat(); c0[8] = a0.basis.z.z.toFloat(); c0[9] = a0.origin.x.toFloat(); c0[10] = a0.origin.y.toFloat(); c0[11] = a0.origin.z.toFloat()
        val c1 = allocArray<FloatVar>(3); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat(); c1[2] = a1.z.toFloat()
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.r; c2[1] = a2.g; c2[2] = a2.b; c2[3] = a2.a
        val c3 = allocArray<FloatVar>(4); c3[0] = a3.r; c3[1] = a3.g; c3[2] = a3.b; c3[3] = a3.a
        val c4 = alloc<LongVar>(); c4.value = a4
        val types = allocArray<IntVar>(5); types[0] = PT_TRANSFORM3D; types[1] = PT_VECTOR3; types[2] = PT_COLOR; types[3] = PT_COLOR; types[4] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Boolean, a1: Boolean) =
    memScoped {
        val c0 = alloc<ByteVar>(); c0.value = if (a0) 1 else 0
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val types = allocArray<IntVar>(2); types[0] = PT_BOOL; types[1] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoColorArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Color, a1: Color) =
    memScoped {
        val c0 = allocArray<FloatVar>(4); c0[0] = a0.r; c0[1] = a0.g; c0[2] = a0.b; c0[3] = a0.a
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.r; c1[1] = a1.g; c1[2] = a1.b; c1[3] = a1.a
        val types = allocArray<IntVar>(2); types[0] = PT_COLOR; types[1] = PT_COLOR
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoDoubleAndIntArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Double, a1: Double, a2: Int) =
    memScoped {
        val c0 = alloc<DoubleVar>(); c0.value = a0
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val types = allocArray<IntVar>(3); types[0] = PT_FLOAT64; types[1] = PT_FLOAT64; types[2] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Double, a1: Double) =
    memScoped {
        val c0 = alloc<DoubleVar>(); c0.value = a0
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_FLOAT64; types[1] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoIntAndBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoIntAndColorArg(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: Color) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.r; c2[1] = a2.g; c2[2] = a2.b; c2[3] = a2.a
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_COLOR
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoIntAndDoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoIntAndLongArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: Long) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = alloc<LongVar>(); c2.value = a2
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoIntAndObjectArg(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: MemorySegment) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = alloc<LongVar>(); c2.value = a2.address()
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_OBJECT
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoIntAndStringArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: String) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_STRING
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoIntAndStringNameArg(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: String) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = a2.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoIntArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoIntArgsRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithTwoIntArgsRetColor(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int): Color =
    memScoped {
        val ret = allocArray<FloatVar>(4)
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_COLOR, ret)
        Color(ret[0], ret[1], ret[2], ret[3])
    }

fun ObjectCalls.ptrcallWithTwoIntArgsRetDouble(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int): Double =
    memScoped {
        val ret = alloc<DoubleVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_FLOAT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithTwoIntArgsRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithTwoIntArgsRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithTwoIntArgsRetVector2(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int): Vector2 =
    memScoped {
        val ret = allocArray<FloatVar>(2)
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VECTOR2, ret)
        Vector2(ret[0].toDouble(), ret[1].toDouble())
    }

fun ObjectCalls.ptrcallWithTwoIntArgsRetVector2i(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int): Vector2i =
    memScoped {
        val ret = allocArray<IntVar>(2)
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VECTOR2I, ret)
        Vector2i(ret[0], ret[1])
    }

fun ObjectCalls.ptrcallWithTwoIntBoolLongArgsRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: Boolean, a3: Long): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val c3 = alloc<LongVar>(); c3.value = a3
        val types = allocArray<IntVar>(4); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_BOOL; types[3] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithTwoIntColorLongTwoBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: Color, a3: Long, a4: Boolean, a5: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.r; c2[1] = a2.g; c2[2] = a2.b; c2[3] = a2.a
        val c3 = alloc<LongVar>(); c3.value = a3
        val c4 = alloc<ByteVar>(); c4.value = if (a4) 1 else 0
        val c5 = alloc<ByteVar>(); c5.value = if (a5) 1 else 0
        val types = allocArray<IntVar>(6); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_COLOR; types[3] = PT_INT64; types[4] = PT_BOOL; types[5] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(6); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 6, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoIntTwoBoolArgsRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: Boolean, a3: Boolean): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val c3 = alloc<ByteVar>(); c3.value = if (a3) 1 else 0
        val types = allocArray<IntVar>(4); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_BOOL; types[3] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithTwoIntVector2DoubleArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Int, a1: Int, a2: Vector2, a3: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.toLong()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = allocArray<FloatVar>(2); c2[0] = a2.x.toFloat(); c2[1] = a2.y.toFloat()
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val types = allocArray<IntVar>(4); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_VECTOR2; types[3] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoLongAndIntArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Long, a2: Int) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<LongVar>(); c1.value = a1
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoLongArgsRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Long): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<LongVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithTwoObjectTransform2DColorArgs(methodBind: MemorySegment, instance: MemorySegment, a0: MemorySegment, a1: MemorySegment, a2: Transform2D, a3: Color) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0.address()
        val c1 = alloc<LongVar>(); c1.value = a1.address()
        val c2 = allocArray<FloatVar>(6); c2[0] = a2.x.x.toFloat(); c2[1] = a2.x.y.toFloat(); c2[2] = a2.y.x.toFloat(); c2[3] = a2.y.y.toFloat(); c2[4] = a2.origin.x.toFloat(); c2[5] = a2.origin.y.toFloat()
        val c3 = allocArray<FloatVar>(4); c3[0] = a3.r; c3[1] = a3.g; c3[2] = a3.b; c3[3] = a3.a
        val types = allocArray<IntVar>(4); types[0] = PT_OBJECT; types[1] = PT_OBJECT; types[2] = PT_TRANSFORM2D; types[3] = PT_COLOR
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoStringArgs(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: String) =
    memScoped {
        val types = allocArray<IntVar>(2); types[0] = PT_STRING; types[1] = PT_STRING
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoStringNameAndColorArg(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: String, a2: Color) =
    memScoped {
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.r; c2[1] = a2.g; c2[2] = a2.b; c2[3] = a2.a
        val types = allocArray<IntVar>(3); types[0] = PT_STRING_NAME; types[1] = PT_STRING_NAME; types[2] = PT_COLOR
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoStringNameAndDoubleArg(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: String, a2: Double) =
    memScoped {
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val types = allocArray<IntVar>(3); types[0] = PT_STRING_NAME; types[1] = PT_STRING_NAME; types[2] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoStringNameAndIntArg(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: String, a2: Int) =
    memScoped {
        val c2 = alloc<LongVar>(); c2.value = a2.toLong()
        val types = allocArray<IntVar>(3); types[0] = PT_STRING_NAME; types[1] = PT_STRING_NAME; types[2] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoStringNameAndObjectArg(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: String, a2: MemorySegment) =
    memScoped {
        val c2 = alloc<LongVar>(); c2.value = a2.address()
        val types = allocArray<IntVar>(3); types[0] = PT_STRING_NAME; types[1] = PT_STRING_NAME; types[2] = PT_OBJECT
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoStringNameArgs(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: String) =
    memScoped {
        val types = allocArray<IntVar>(2); types[0] = PT_STRING_NAME; types[1] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoStringNameArgsRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: String): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val types = allocArray<IntVar>(2); types[0] = PT_STRING_NAME; types[1] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithTwoStringNameArgsRetColor(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: String): Color =
    memScoped {
        val ret = allocArray<FloatVar>(4)
        val types = allocArray<IntVar>(2); types[0] = PT_STRING_NAME; types[1] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_COLOR, ret)
        Color(ret[0], ret[1], ret[2], ret[3])
    }

fun ObjectCalls.ptrcallWithTwoStringNameArgsRetDouble(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: String): Double =
    memScoped {
        val ret = alloc<DoubleVar>()
        val types = allocArray<IntVar>(2); types[0] = PT_STRING_NAME; types[1] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_FLOAT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithTwoStringNameArgsRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: String): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val types = allocArray<IntVar>(2); types[0] = PT_STRING_NAME; types[1] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithTwoStringNameArgsRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: String): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val types = allocArray<IntVar>(2); types[0] = PT_STRING_NAME; types[1] = PT_STRING_NAME
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = a1.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithTwoUInt32AndDoubleArg(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Long, a2: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<LongVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val types = allocArray<IntVar>(3); types[0] = PT_INT64; types[1] = PT_INT64; types[2] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoVector2Args(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2, a1: Vector2) =
    memScoped {
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val types = allocArray<IntVar>(2); types[0] = PT_VECTOR2; types[1] = PT_VECTOR2
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoVector2ColorDoubleBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2, a1: Vector2, a2: Color, a3: Double, a4: Boolean) =
    memScoped {
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.r; c2[1] = a2.g; c2[2] = a2.b; c2[3] = a2.a
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val c4 = alloc<ByteVar>(); c4.value = if (a4) 1 else 0
        val types = allocArray<IntVar>(5); types[0] = PT_VECTOR2; types[1] = PT_VECTOR2; types[2] = PT_COLOR; types[3] = PT_FLOAT64; types[4] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoVector2ColorTwoDoubleTwoBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2, a1: Vector2, a2: Color, a3: Double, a4: Double, a5: Boolean, a6: Boolean) =
    memScoped {
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.r; c2[1] = a2.g; c2[2] = a2.b; c2[3] = a2.a
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val c5 = alloc<ByteVar>(); c5.value = if (a5) 1 else 0
        val c6 = alloc<ByteVar>(); c6.value = if (a6) 1 else 0
        val types = allocArray<IntVar>(7); types[0] = PT_VECTOR2; types[1] = PT_VECTOR2; types[2] = PT_COLOR; types[3] = PT_FLOAT64; types[4] = PT_FLOAT64; types[5] = PT_BOOL; types[6] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(7); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 7, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoVector3AndBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Vector3, a1: Vector3, a2: Boolean) =
    memScoped {
        val c0 = allocArray<FloatVar>(3); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat(); c0[2] = a0.z.toFloat()
        val c1 = allocArray<FloatVar>(3); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat(); c1[2] = a1.z.toFloat()
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val types = allocArray<IntVar>(3); types[0] = PT_VECTOR3; types[1] = PT_VECTOR3; types[2] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithTwoVector3Args(methodBind: MemorySegment, instance: MemorySegment, a0: Vector3, a1: Vector3) =
    memScoped {
        val c0 = allocArray<FloatVar>(3); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat(); c0[2] = a0.z.toFloat()
        val c1 = allocArray<FloatVar>(3); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat(); c1[2] = a1.z.toFloat()
        val types = allocArray<IntVar>(2); types[0] = PT_VECTOR3; types[1] = PT_VECTOR3
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithUInt32AndBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Boolean) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithUInt32AndDoubleArg(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Double) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithUInt32AndIntArg(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Int) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithUInt32AndIntArgRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Int): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithUInt32AndIntArgRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Int): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithUInt32AndObjectArg(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: MemorySegment) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = alloc<LongVar>(); c1.value = a1.address()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_OBJECT
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithUInt32AndTransform2DArg(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Transform2D) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = allocArray<FloatVar>(6); c1[0] = a1.x.x.toFloat(); c1[1] = a1.x.y.toFloat(); c1[2] = a1.y.x.toFloat(); c1[3] = a1.y.y.toFloat(); c1[4] = a1.origin.x.toFloat(); c1[5] = a1.origin.y.toFloat()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_TRANSFORM2D
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithUInt32AndTransform3DArg(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Transform3D) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = allocArray<FloatVar>(12); c1[0] = a1.basis.x.x.toFloat(); c1[1] = a1.basis.y.x.toFloat(); c1[2] = a1.basis.z.x.toFloat(); c1[3] = a1.basis.x.y.toFloat(); c1[4] = a1.basis.y.y.toFloat(); c1[5] = a1.basis.z.y.toFloat(); c1[6] = a1.basis.x.z.toFloat(); c1[7] = a1.basis.y.z.toFloat(); c1[8] = a1.basis.z.z.toFloat(); c1[9] = a1.origin.x.toFloat(); c1[10] = a1.origin.y.toFloat(); c1[11] = a1.origin.z.toFloat()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_TRANSFORM3D
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithUInt32AndVector2Args(methodBind: MemorySegment, instance: MemorySegment, a0: Long, a1: Vector2) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val c1 = allocArray<FloatVar>(2); c1[0] = a1.x.toFloat(); c1[1] = a1.y.toFloat()
        val types = allocArray<IntVar>(2); types[0] = PT_INT64; types[1] = PT_VECTOR2
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.ptr.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithUInt32Arg(methodBind: MemorySegment, instance: MemorySegment, a0: Long) =
    memScoped {
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithUInt32ArgRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Long): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithUInt32ArgRetDouble(methodBind: MemorySegment, instance: MemorySegment, a0: Long): Double =
    memScoped {
        val ret = alloc<DoubleVar>()
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_FLOAT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithUInt32ArgRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Long): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithUInt32ArgRetObject(methodBind: MemorySegment, instance: MemorySegment, a0: Long): MemorySegment =
    memScoped {
        val ret = alloc<LongVar>(); ret.value = 0
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_OBJECT, ret.ptr)
        MemorySegment.ofAddress(ret.value)
    }

fun ObjectCalls.ptrcallWithUInt32ArgRetTransform2D(methodBind: MemorySegment, instance: MemorySegment, a0: Long): Transform2D =
    memScoped {
        val ret = allocArray<FloatVar>(6)
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_TRANSFORM2D, ret)
        Transform2D(Vector2(ret[0].toDouble(), ret[1].toDouble()), Vector2(ret[2].toDouble(), ret[3].toDouble()), Vector2(ret[4].toDouble(), ret[5].toDouble()))
    }

fun ObjectCalls.ptrcallWithUInt32ArgRetTransform3D(methodBind: MemorySegment, instance: MemorySegment, a0: Long): Transform3D =
    memScoped {
        val ret = allocArray<FloatVar>(12)
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_TRANSFORM3D, ret)
        Transform3D(Basis(Vector3(ret[0].toDouble(), ret[3].toDouble(), ret[6].toDouble()), Vector3(ret[1].toDouble(), ret[4].toDouble(), ret[7].toDouble()), Vector3(ret[2].toDouble(), ret[5].toDouble(), ret[8].toDouble())), Vector3(ret[9].toDouble(), ret[10].toDouble(), ret[11].toDouble()))
    }

fun ObjectCalls.ptrcallWithUInt32ArgRetVector2(methodBind: MemorySegment, instance: MemorySegment, a0: Long): Vector2 =
    memScoped {
        val ret = allocArray<FloatVar>(2)
        val c0 = alloc<LongVar>(); c0.value = a0
        val types = allocArray<IntVar>(1); types[0] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VECTOR2, ret)
        Vector2(ret[0].toDouble(), ret[1].toDouble())
    }

fun ObjectCalls.ptrcallWithVector2AndBoolArg(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2, a1: Boolean) =
    memScoped {
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val types = allocArray<IntVar>(2); types[0] = PT_VECTOR2; types[1] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithVector2AndDoubleArgRetVector3(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2, a1: Double): Vector3 =
    memScoped {
        val ret = allocArray<FloatVar>(3)
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_VECTOR2; types[1] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VECTOR3, ret)
        Vector3(ret[0].toDouble(), ret[1].toDouble(), ret[2].toDouble())
    }

fun ObjectCalls.ptrcallWithVector2AndIntArg(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2, a1: Int) =
    memScoped {
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val types = allocArray<IntVar>(2); types[0] = PT_VECTOR2; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithVector2ArgRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR2
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithVector2ArgRetDouble(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2): Double =
    memScoped {
        val ret = alloc<DoubleVar>()
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR2
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_FLOAT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithVector2ArgRetLong(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2): Long =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR2
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithVector2ArgRetVector2(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2): Vector2 =
    memScoped {
        val ret = allocArray<FloatVar>(2)
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR2
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VECTOR2, ret)
        Vector2(ret[0].toDouble(), ret[1].toDouble())
    }

fun ObjectCalls.ptrcallWithVector2ArgRetVector2i(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2): Vector2i =
    memScoped {
        val ret = allocArray<IntVar>(2)
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR2
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VECTOR2I, ret)
        Vector2i(ret[0], ret[1])
    }

fun ObjectCalls.ptrcallWithVector2ArgRetVector3(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2): Vector3 =
    memScoped {
        val ret = allocArray<FloatVar>(3)
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR2
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VECTOR3, ret)
        Vector3(ret[0].toDouble(), ret[1].toDouble(), ret[2].toDouble())
    }

fun ObjectCalls.ptrcallWithVector2DoubleColorBoolDoubleBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2, a1: Double, a2: Color, a3: Boolean, a4: Double, a5: Boolean) =
    memScoped {
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = allocArray<FloatVar>(4); c2[0] = a2.r; c2[1] = a2.g; c2[2] = a2.b; c2[3] = a2.a
        val c3 = alloc<ByteVar>(); c3.value = if (a3) 1 else 0
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val c5 = alloc<ByteVar>(); c5.value = if (a5) 1 else 0
        val types = allocArray<IntVar>(6); types[0] = PT_VECTOR2; types[1] = PT_FLOAT64; types[2] = PT_COLOR; types[3] = PT_BOOL; types[4] = PT_FLOAT64; types[5] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(6); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 6, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithVector2DoubleVector2Args(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2, a1: Double, a2: Vector2) =
    memScoped {
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = allocArray<FloatVar>(2); c2[0] = a2.x.toFloat(); c2[1] = a2.y.toFloat()
        val types = allocArray<IntVar>(3); types[0] = PT_VECTOR2; types[1] = PT_FLOAT64; types[2] = PT_VECTOR2
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithVector2FourDoubleIntColorDoubleBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2, a1: Double, a2: Double, a3: Double, a4: Double, a5: Int, a6: Color, a7: Double, a8: Boolean) =
    memScoped {
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val c4 = alloc<DoubleVar>(); c4.value = a4
        val c5 = alloc<LongVar>(); c5.value = a5.toLong()
        val c6 = allocArray<FloatVar>(4); c6[0] = a6.r; c6[1] = a6.g; c6[2] = a6.b; c6[3] = a6.a
        val c7 = alloc<DoubleVar>(); c7.value = a7
        val c8 = alloc<ByteVar>(); c8.value = if (a8) 1 else 0
        val types = allocArray<IntVar>(9); types[0] = PT_VECTOR2; types[1] = PT_FLOAT64; types[2] = PT_FLOAT64; types[3] = PT_FLOAT64; types[4] = PT_FLOAT64; types[5] = PT_INT64; types[6] = PT_COLOR; types[7] = PT_FLOAT64; types[8] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(9); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.reinterpret<CPointed>(); ptrs[7] = c7.ptr.reinterpret<CPointed>(); ptrs[8] = c8.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 9, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithVector2Rect2ArgsRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2, a1: Rect2): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.position.x.toFloat(); c1[1] = a1.position.y.toFloat(); c1[2] = a1.size.x.toFloat(); c1[3] = a1.size.y.toFloat()
        val types = allocArray<IntVar>(2); types[0] = PT_VECTOR2; types[1] = PT_RECT2
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithVector2ThreeDoubleIntColorDoubleBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2, a1: Double, a2: Double, a3: Double, a4: Int, a5: Color, a6: Double, a7: Boolean) =
    memScoped {
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = alloc<DoubleVar>(); c3.value = a3
        val c4 = alloc<LongVar>(); c4.value = a4.toLong()
        val c5 = allocArray<FloatVar>(4); c5[0] = a5.r; c5[1] = a5.g; c5[2] = a5.b; c5[3] = a5.a
        val c6 = alloc<DoubleVar>(); c6.value = a6
        val c7 = alloc<ByteVar>(); c7.value = if (a7) 1 else 0
        val types = allocArray<IntVar>(8); types[0] = PT_VECTOR2; types[1] = PT_FLOAT64; types[2] = PT_FLOAT64; types[3] = PT_FLOAT64; types[4] = PT_INT64; types[5] = PT_COLOR; types[6] = PT_FLOAT64; types[7] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(8); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>(); ptrs[7] = c7.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 8, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithVector2TwoDoubleColorBoolDoubleBoolArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2, a1: Double, a2: Double, a3: Color, a4: Boolean, a5: Double, a6: Boolean) =
    memScoped {
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = allocArray<FloatVar>(4); c3[0] = a3.r; c3[1] = a3.g; c3[2] = a3.b; c3[3] = a3.a
        val c4 = alloc<ByteVar>(); c4.value = if (a4) 1 else 0
        val c5 = alloc<DoubleVar>(); c5.value = a5
        val c6 = alloc<ByteVar>(); c6.value = if (a6) 1 else 0
        val types = allocArray<IntVar>(7); types[0] = PT_VECTOR2; types[1] = PT_FLOAT64; types[2] = PT_FLOAT64; types[3] = PT_COLOR; types[4] = PT_BOOL; types[5] = PT_FLOAT64; types[6] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(7); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>(); ptrs[5] = c5.ptr.reinterpret<CPointed>(); ptrs[6] = c6.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 7, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithVector2TwoDoubleTwoLongArgsRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2, a1: Double, a2: Double, a3: Long, a4: Long): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = allocArray<FloatVar>(2); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val c2 = alloc<DoubleVar>(); c2.value = a2
        val c3 = alloc<LongVar>(); c3.value = a3
        val c4 = alloc<LongVar>(); c4.value = a4
        val types = allocArray<IntVar>(5); types[0] = PT_VECTOR2; types[1] = PT_FLOAT64; types[2] = PT_FLOAT64; types[3] = PT_INT64; types[4] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(5); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>(); ptrs[4] = c4.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 5, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithVector2iAndColorArg(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2i, a1: Color) =
    memScoped {
        val c0 = allocArray<IntVar>(2); c0[0] = a0.x; c0[1] = a0.y
        val c1 = allocArray<FloatVar>(4); c1[0] = a1.r; c1[1] = a1.g; c1[2] = a1.b; c1[3] = a1.a
        val types = allocArray<IntVar>(2); types[0] = PT_VECTOR2I; types[1] = PT_COLOR
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithVector2iAndDoubleArg(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2i, a1: Double) =
    memScoped {
        val c0 = allocArray<IntVar>(2); c0[0] = a0.x; c0[1] = a0.y
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_VECTOR2I; types[1] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithVector2iAndLongArgRetVector2i(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2i, a1: Long): Vector2i =
    memScoped {
        val ret = allocArray<IntVar>(2)
        val c0 = allocArray<IntVar>(2); c0[0] = a0.x; c0[1] = a0.y
        val c1 = alloc<LongVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_VECTOR2I; types[1] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VECTOR2I, ret)
        Vector2i(ret[0], ret[1])
    }

fun ObjectCalls.ptrcallWithVector2iAndTwoBoolArgsRetVector2i(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2i, a1: Boolean, a2: Boolean): Vector2i =
    memScoped {
        val ret = allocArray<IntVar>(2)
        val c0 = allocArray<IntVar>(2); c0[0] = a0.x; c0[1] = a0.y
        val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
        val c2 = alloc<ByteVar>(); c2.value = if (a2) 1 else 0
        val types = allocArray<IntVar>(3); types[0] = PT_VECTOR2I; types[1] = PT_BOOL; types[2] = PT_BOOL
        val ptrs = allocArray<COpaquePointerVar>(3); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 3, PT_VECTOR2I, ret)
        Vector2i(ret[0], ret[1])
    }

fun ObjectCalls.ptrcallWithVector2iArgRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2i): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = allocArray<IntVar>(2); c0[0] = a0.x; c0[1] = a0.y
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR2I
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithVector2iArgRetColor(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2i): Color =
    memScoped {
        val ret = allocArray<FloatVar>(4)
        val c0 = allocArray<IntVar>(2); c0[0] = a0.x; c0[1] = a0.y
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR2I
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_COLOR, ret)
        Color(ret[0], ret[1], ret[2], ret[3])
    }

fun ObjectCalls.ptrcallWithVector2iArgRetInt(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2i): Int =
    memScoped {
        val ret = alloc<LongVar>()
        val c0 = allocArray<IntVar>(2); c0[0] = a0.x; c0[1] = a0.y
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR2I
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_INT64, ret.ptr)
        ret.value.toInt()
    }

fun ObjectCalls.ptrcallWithVector2iArgRetVector2(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2i): Vector2 =
    memScoped {
        val ret = allocArray<FloatVar>(2)
        val c0 = allocArray<IntVar>(2); c0[0] = a0.x; c0[1] = a0.y
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR2I
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VECTOR2, ret)
        Vector2(ret[0].toDouble(), ret[1].toDouble())
    }

fun ObjectCalls.ptrcallWithVector2iArgRetVector2i(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2i): Vector2i =
    memScoped {
        val ret = allocArray<IntVar>(2)
        val c0 = allocArray<IntVar>(2); c0[0] = a0.x; c0[1] = a0.y
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR2I
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VECTOR2I, ret)
        Vector2i(ret[0], ret[1])
    }

fun ObjectCalls.ptrcallWithVector2iIntVector2iIntArgs(methodBind: MemorySegment, instance: MemorySegment, a0: Vector2i, a1: Int, a2: Vector2i, a3: Int) =
    memScoped {
        val c0 = allocArray<IntVar>(2); c0[0] = a0.x; c0[1] = a0.y
        val c1 = alloc<LongVar>(); c1.value = a1.toLong()
        val c2 = allocArray<IntVar>(2); c2[0] = a2.x; c2[1] = a2.y
        val c3 = alloc<LongVar>(); c3.value = a3.toLong()
        val types = allocArray<IntVar>(4); types[0] = PT_VECTOR2I; types[1] = PT_INT64; types[2] = PT_VECTOR2I; types[3] = PT_INT64
        val ptrs = allocArray<COpaquePointerVar>(4); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>(); ptrs[2] = c2.reinterpret<CPointed>(); ptrs[3] = c3.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 4, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithVector3AndDoubleArg(methodBind: MemorySegment, instance: MemorySegment, a0: Vector3, a1: Double) =
    memScoped {
        val c0 = allocArray<FloatVar>(3); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat(); c0[2] = a0.z.toFloat()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_VECTOR3; types[1] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithVector3ArgRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: Vector3): Boolean =
    memScoped {
        val ret = alloc<ByteVar>()
        val c0 = allocArray<FloatVar>(3); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat(); c0[2] = a0.z.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR3
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_BOOL, ret.ptr)
        ret.value.toInt() != 0
    }

fun ObjectCalls.ptrcallWithVector3ArgRetDouble(methodBind: MemorySegment, instance: MemorySegment, a0: Vector3): Double =
    memScoped {
        val ret = alloc<DoubleVar>()
        val c0 = allocArray<FloatVar>(3); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat(); c0[2] = a0.z.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR3
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_FLOAT64, ret.ptr)
        ret.value
    }

fun ObjectCalls.ptrcallWithVector3ArgRetVector2(methodBind: MemorySegment, instance: MemorySegment, a0: Vector3): Vector2 =
    memScoped {
        val ret = allocArray<FloatVar>(2)
        val c0 = allocArray<FloatVar>(3); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat(); c0[2] = a0.z.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR3
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VECTOR2, ret)
        Vector2(ret[0].toDouble(), ret[1].toDouble())
    }

fun ObjectCalls.ptrcallWithVector3ArgRetVector3(methodBind: MemorySegment, instance: MemorySegment, a0: Vector3): Vector3 =
    memScoped {
        val ret = allocArray<FloatVar>(3)
        val c0 = allocArray<FloatVar>(3); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat(); c0[2] = a0.z.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_VECTOR3
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VECTOR3, ret)
        Vector3(ret[0].toDouble(), ret[1].toDouble(), ret[2].toDouble())
    }
