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
private const val PT_FLOAT64 = 5
private const val PT_VECTOR3 = 8
private const val PT_NODE_PATH = 17
private const val PT_BASIS = 18
private const val PT_TRANSFORM3D = 19
private const val PT_QUATERNION = 20

fun ObjectCalls.ptrcallNoArgsRetBasis(methodBind: MemorySegment, instance: MemorySegment): Basis =
    memScoped {
        val ret = allocArray<FloatVar>(9)
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_BASIS, ret)
        Basis(Vector3(ret[0].toDouble(), ret[3].toDouble(), ret[6].toDouble()), Vector3(ret[1].toDouble(), ret[4].toDouble(), ret[7].toDouble()), Vector3(ret[2].toDouble(), ret[5].toDouble(), ret[8].toDouble()))
    }

fun ObjectCalls.ptrcallNoArgsRetQuaternion(methodBind: MemorySegment, instance: MemorySegment): Quaternion =
    memScoped {
        val ret = allocArray<FloatVar>(4)
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_QUATERNION, ret)
        Quaternion(ret[0].toDouble(), ret[1].toDouble(), ret[2].toDouble(), ret[3].toDouble())
    }

fun ObjectCalls.ptrcallNoArgsRetTransform3D(methodBind: MemorySegment, instance: MemorySegment): Transform3D =
    memScoped {
        val ret = allocArray<FloatVar>(12)
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_TRANSFORM3D, ret)
        Transform3D(Basis(Vector3(ret[0].toDouble(), ret[3].toDouble(), ret[6].toDouble()), Vector3(ret[1].toDouble(), ret[4].toDouble(), ret[7].toDouble()), Vector3(ret[2].toDouble(), ret[5].toDouble(), ret[8].toDouble())), Vector3(ret[9].toDouble(), ret[10].toDouble(), ret[11].toDouble()))
    }

fun ObjectCalls.ptrcallWithBasisArg(methodBind: MemorySegment, instance: MemorySegment, a0: Basis) =
    memScoped {
        val c0 = allocArray<FloatVar>(9); c0[0] = a0.x.x.toFloat(); c0[1] = a0.y.x.toFloat(); c0[2] = a0.z.x.toFloat(); c0[3] = a0.x.y.toFloat(); c0[4] = a0.y.y.toFloat(); c0[5] = a0.z.y.toFloat(); c0[6] = a0.x.z.toFloat(); c0[7] = a0.y.z.toFloat(); c0[8] = a0.z.z.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_BASIS
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
        Unit
    }

fun ObjectCalls.ptrcallWithNodePathArg(methodBind: MemorySegment, instance: MemorySegment, a0: NodePath) =
    memScoped {
        val types = allocArray<IntVar>(1); types[0] = PT_NODE_PATH
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = a0.path.cstr.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
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

fun ObjectCalls.ptrcallWithTransform3DArg(methodBind: MemorySegment, instance: MemorySegment, a0: Transform3D) =
    memScoped {
        val c0 = allocArray<FloatVar>(12); c0[0] = a0.basis.x.x.toFloat(); c0[1] = a0.basis.y.x.toFloat(); c0[2] = a0.basis.z.x.toFloat(); c0[3] = a0.basis.x.y.toFloat(); c0[4] = a0.basis.y.y.toFloat(); c0[5] = a0.basis.z.y.toFloat(); c0[6] = a0.basis.x.z.toFloat(); c0[7] = a0.basis.y.z.toFloat(); c0[8] = a0.basis.z.z.toFloat(); c0[9] = a0.origin.x.toFloat(); c0[10] = a0.origin.y.toFloat(); c0[11] = a0.origin.z.toFloat()
        val types = allocArray<IntVar>(1); types[0] = PT_TRANSFORM3D
        val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = c0.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
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

fun ObjectCalls.ptrcallWithVector3AndDoubleArg(methodBind: MemorySegment, instance: MemorySegment, a0: Vector3, a1: Double) =
    memScoped {
        val c0 = allocArray<FloatVar>(3); c0[0] = a0.x.toFloat(); c0[1] = a0.y.toFloat(); c0[2] = a0.z.toFloat()
        val c1 = alloc<DoubleVar>(); c1.value = a1
        val types = allocArray<IntVar>(2); types[0] = PT_VECTOR3; types[1] = PT_FLOAT64
        val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = c0.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_VOID, null)
        Unit
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
