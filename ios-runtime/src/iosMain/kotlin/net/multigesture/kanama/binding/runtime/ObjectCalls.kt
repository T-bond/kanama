@file:OptIn(ExperimentalForeignApi::class)

package net.multigesture.kanama.binding.runtime

import java.lang.foreign.MemorySegment
import kotlin.experimental.ExperimentalNativeApi
import kotlin.native.CName
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
import kotlinx.cinterop.plus
import kotlinx.cinterop.ptr
import kotlinx.cinterop.readBytes
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.set
import kotlinx.cinterop.value
import net.multigesture.kanama.api.GodotObject
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_construct_object
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_get_method_bind
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_get_singleton
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_object_call
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_ptrcall
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_ptrcall_no_args_ret_packed_color_array
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_ptrcall_no_args_ret_packed_float32_array
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_ptrcall_no_args_ret_packed_int32_array
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_ptrcall_no_args_ret_packed_vector2_array
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_ptrcall_with_packed_float32_arg
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_ptrcall_no_args_ret_string
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_ptrcall_no_args_ret_node_path
import net.multigesture.kanama.ios.cinterop.kanama_ios_godot_ptrcall_no_args_ret_string_name
import net.multigesture.kanama.ios.decodeIosCallArg
import net.multigesture.kanama.ios.decodeIosPropertyValue
import net.multigesture.kanama.types.AABB
import net.multigesture.kanama.types.Basis
import net.multigesture.kanama.types.Color
import net.multigesture.kanama.types.NodePath
import net.multigesture.kanama.types.Quaternion
import net.multigesture.kanama.types.RID
import net.multigesture.kanama.types.Rect2
import net.multigesture.kanama.types.Transform2D
import net.multigesture.kanama.types.Transform3D
import net.multigesture.kanama.types.Vector2
import net.multigesture.kanama.types.Vector2i
import net.multigesture.kanama.types.Vector3
import net.multigesture.kanama.types.Vector3i

/**
 * iOS implementation of the runtime abstraction the generated Godot API wrappers
 * call (mirrors the desktop `ObjectCalls`). Every helper routes through the single
 * generic C dispatch `kanama_ios_godot_ptrcall`; Kotlin lays out the POD/struct/object
 * arg bytes here, the C side passes them straight to `object_method_bind_ptrcall`.
 *
 * Marshalling rules (see docs/internals/ios-backend-architecture.md):
 * - SCALAR `float` args/returns are 8-byte `double` at ptrcall (PtrToArg<float> =
 *   convert<float,double>) — so a Godot `float` scalar uses the `*Double*` helpers.
 * - Vector/Color COMPONENTS are real_t = 4-byte float32 in single-precision builds —
 *   so Vector2/Vector3 marshal their Double components as float32.
 */
object ObjectCalls {
    // ptrcall type tags — must match the KANAMA_IOS_PT_* enum in kanama_ios_shim.c.
    private const val PT_VOID = 0
    private const val PT_BOOL = 1
    private const val PT_INT32 = 2
    private const val PT_INT64 = 3
    private const val PT_FLOAT64 = 5
    private const val PT_VECTOR2 = 6
    private const val PT_VECTOR2I = 7
    private const val PT_VECTOR3 = 8
    private const val PT_VECTOR3I = 9
    private const val PT_COLOR = 11
    private const val PT_RECT2 = 12
    private const val PT_OBJECT = 13
    private const val PT_STRING_NAME = 15
    private const val PT_STRING = 16

    // Godot Variant type tags (returned by kanama_ios_godot_object_call, for decoding
    // a scalar return). Must match the KANAMA_IOS_VARIANT_TYPE_* enum in the C shim.
    private const val VT_BOOL = 1
    private const val VT_INT = 2
    private const val VT_FLOAT = 3
    private const val VT_STRING = 4
    private const val VT_OBJECT = 24

    fun constructObject(className: String): MemorySegment =
        MemorySegment.ofAddress(kanama_ios_godot_construct_object(className))

    fun getMethodBind(className: String, methodName: String, hash: Long): MemorySegment =
        MemorySegment.ofAddress(kanama_ios_godot_get_method_bind(className, methodName, hash))

    // Resolve a Godot engine singleton (Input, Engine, …). Mirrors desktop ObjectCalls;
    // used by the bespoke Input glue (and generated singleton wrappers, longer term).
    fun getSingleton(className: String): MemorySegment =
        MemorySegment.ofAddress(kanama_ios_godot_get_singleton(className))

    // ---- no-arg ----
    fun ptrcallNoArgs(methodBind: MemorySegment, instance: MemorySegment) {
        kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_VOID, null)
    }

    fun ptrcallNoArgsRetBool(methodBind: MemorySegment, instance: MemorySegment): Boolean =
        memScoped {
            val ret = alloc<ByteVar>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_BOOL, ret.ptr)
            ret.value.toInt() != 0
        }

    // All Godot scalar ints are 8 bytes (int64) at ptrcall (PtrToArg<int32_t> =
    // convert<int32_t,int64_t>), so int returns read 8 bytes then narrow.
    fun ptrcallNoArgsRetInt(methodBind: MemorySegment, instance: MemorySegment): Int =
        memScoped {
            val ret = alloc<LongVar>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_INT64, ret.ptr)
            ret.value.toInt()
        }

    fun ptrcallNoArgsRetLong(methodBind: MemorySegment, instance: MemorySegment): Long =
        memScoped {
            val ret = alloc<LongVar>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_INT64, ret.ptr)
            ret.value
        }

    fun ptrcallNoArgsRetDouble(methodBind: MemorySegment, instance: MemorySegment): Double =
        memScoped {
            val ret = alloc<DoubleVar>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_FLOAT64, ret.ptr)
            ret.value
        }

    fun ptrcallNoArgsRetObject(methodBind: MemorySegment, instance: MemorySegment): MemorySegment =
        memScoped {
            val ret = alloc<LongVar>()
            ret.value = 0
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_OBJECT, ret.ptr)
            MemorySegment.ofAddress(ret.value)
        }

    fun ptrcallNoArgsRetVector2(methodBind: MemorySegment, instance: MemorySegment): Vector2 =
        memScoped {
            val ret = allocArray<FloatVar>(2)
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_VECTOR2, ret)
            Vector2(ret[0].toDouble(), ret[1].toDouble())
        }

    fun ptrcallNoArgsRetVector3(methodBind: MemorySegment, instance: MemorySegment): Vector3 =
        memScoped {
            val ret = allocArray<FloatVar>(3)
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_VECTOR3, ret)
            Vector3(ret[0].toDouble(), ret[1].toDouble(), ret[2].toDouble())
        }

    // Vector2i (2x int32, 8 bytes total): components are int32 NOT widened — struct
    // uses PtrToArgDirect/PtrToArgByReference, not PtrToArgConvert.
    fun ptrcallNoArgsRetVector2i(methodBind: MemorySegment, instance: MemorySegment): Vector2i =
        memScoped {
            val ret = allocArray<IntVar>(2)
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_VECTOR2I, ret)
            Vector2i(ret[0], ret[1])
        }

    // Vector3i (3x int32, 12 bytes total): components are int32 NOT widened.
    fun ptrcallNoArgsRetVector3i(methodBind: MemorySegment, instance: MemorySegment): Vector3i =
        memScoped {
            val ret = allocArray<IntVar>(3)
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_VECTOR3I, ret)
            Vector3i(ret[0], ret[1], ret[2])
        }

    // Color (4x float32, 16 bytes): components are always float32 (not real_t, not double).
    // No widening: PtrToArgDirect<Color> lays 4×float32 raw.
    fun ptrcallNoArgsRetColor(methodBind: MemorySegment, instance: MemorySegment): Color =
        memScoped {
            val ret = allocArray<FloatVar>(4)
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_COLOR, ret)
            Color(ret[0], ret[1], ret[2], ret[3])
        }

    // Rect2 (4x float32, 16 bytes): position.x, position.y, size.x, size.y.
    // Components are real_t = float32 on single-precision iOS (same convention as Vector2).
    fun ptrcallNoArgsRetRect2(methodBind: MemorySegment, instance: MemorySegment): Rect2 =
        memScoped {
            val ret = allocArray<FloatVar>(4)
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), null, null, 0, PT_RECT2, ret)
            Rect2(Vector2(ret[0].toDouble(), ret[1].toDouble()), Vector2(ret[2].toDouble(), ret[3].toDouble()))
        }

    // String return: a Godot String can't ride the fixed ret_out of the generic
    // dispatch, so it routes through the dedicated C helper. Two-call protocol —
    // measure the UTF-8 byte length (NULL buffer), then allocate and fill. Safe to
    // call twice because the wired methods are pure getters. string_to_utf8_chars
    // writes no null terminator, so decode exactly `len` bytes.
    fun ptrcallNoArgsRetString(methodBind: MemorySegment, instance: MemorySegment): String =
        memScoped {
            val len = kanama_ios_godot_ptrcall_no_args_ret_string(
                methodBind.address(), instance.address(), null, 0L)
            if (len <= 0L) {
                ""
            } else {
                val buf = allocArray<ByteVar>(len)
                kanama_ios_godot_ptrcall_no_args_ret_string(
                    methodBind.address(), instance.address(), buf, len)
                buf.readBytes(len.toInt()).decodeToString()
            }
        }

    // StringName return: GDExtension has no StringName->utf8, so the dedicated C helper
    // converts the returned StringName to a String (String(from: StringName) ctor) and
    // UTF-8 encodes it. Same two-call length protocol as ptrcallNoArgsRetString.
    fun ptrcallNoArgsRetStringName(methodBind: MemorySegment, instance: MemorySegment): String =
        memScoped {
            val len = kanama_ios_godot_ptrcall_no_args_ret_string_name(
                methodBind.address(), instance.address(), null, 0L)
            if (len <= 0L) {
                ""
            } else {
                val buf = allocArray<ByteVar>(len)
                kanama_ios_godot_ptrcall_no_args_ret_string_name(
                    methodBind.address(), instance.address(), buf, len)
                buf.readBytes(len.toInt()).decodeToString()
            }
        }

    // NodePath return: GDExtension has no NodePath->utf8, so the dedicated C helper converts
    // the returned NodePath to a String (String(from: NodePath) ctor) and UTF-8 encodes it,
    // then we wrap it back into a NodePath. Same two-call length protocol as the String helper.
    fun ptrcallNoArgsRetNodePath(methodBind: MemorySegment, instance: MemorySegment): NodePath =
        memScoped {
            val len = kanama_ios_godot_ptrcall_no_args_ret_node_path(
                methodBind.address(), instance.address(), null, 0L)
            if (len <= 0L) {
                NodePath("")
            } else {
                val buf = allocArray<ByteVar>(len)
                kanama_ios_godot_ptrcall_no_args_ret_node_path(
                    methodBind.address(), instance.address(), buf, len)
                NodePath(buf.readBytes(len.toInt()).decodeToString())
            }
        }

    // PackedInt32Array return: the C helper reads the array's element count (size builtin)
    // and copies int32 elements out via operator_index_const. Two-call length protocol like
    // the String/NodePath helpers — measure the count first, allocate, then fill. The count
    // is an element count, not a byte size.
    fun ptrcallNoArgsRetPackedInt32List(methodBind: MemorySegment, instance: MemorySegment): List<Int> =
        memScoped {
            val count = kanama_ios_godot_ptrcall_no_args_ret_packed_int32_array(
                methodBind.address(), instance.address(), null, 0L)
            if (count <= 0L) {
                emptyList()
            } else {
                val buf = allocArray<IntVar>(count)
                kanama_ios_godot_ptrcall_no_args_ret_packed_int32_array(
                    methodBind.address(), instance.address(), buf, count)
                List(count.toInt()) { buf[it] }
            }
        }

    // PackedFloat32Array return: float32 element variant of ptrcallNoArgsRetPackedInt32List
    // (same size + operator_index_const + two-call length protocol; 16-byte storage C-side).
    fun ptrcallNoArgsRetPackedFloat32List(methodBind: MemorySegment, instance: MemorySegment): List<Float> =
        memScoped {
            val count = kanama_ios_godot_ptrcall_no_args_ret_packed_float32_array(
                methodBind.address(), instance.address(), null, 0L)
            if (count <= 0L) {
                emptyList()
            } else {
                val buf = allocArray<FloatVar>(count)
                kanama_ios_godot_ptrcall_no_args_ret_packed_float32_array(
                    methodBind.address(), instance.address(), buf, count)
                List(count.toInt()) { buf[it] }
            }
        }

    // PackedFloat32Array arg (build-from-list): copy the List into a flat float buffer; the C
    // helper builds the array (constructor + push_back) and ptrcalls the single-arg void method.
    fun ptrcallWithPackedFloat32ListArg(
        methodBind: MemorySegment,
        instance: MemorySegment,
        values: List<Float>,
    ) = memScoped {
        val n = values.size
        val buf = allocArray<FloatVar>(if (n > 0) n else 1)
        for (i in 0 until n) buf[i] = values[i]
        kanama_ios_godot_ptrcall_with_packed_float32_arg(
            methodBind.address(), instance.address(), buf, n.toLong())
        Unit
    }

    // PackedVector2Array return: each element is 2 float32; the C helper fills count*2 floats.
    fun ptrcallNoArgsRetPackedVector2List(methodBind: MemorySegment, instance: MemorySegment): List<Vector2> =
        memScoped {
            val count = kanama_ios_godot_ptrcall_no_args_ret_packed_vector2_array(
                methodBind.address(), instance.address(), null, 0L)
            if (count <= 0L) {
                emptyList()
            } else {
                val buf = allocArray<FloatVar>(count * 2)
                kanama_ios_godot_ptrcall_no_args_ret_packed_vector2_array(
                    methodBind.address(), instance.address(), buf, count)
                List(count.toInt()) { Vector2(buf[it * 2], buf[it * 2 + 1]) }
            }
        }

    // PackedColorArray return: each element is 4 float32 (RGBA); the C helper fills count*4 floats.
    fun ptrcallNoArgsRetPackedColorList(methodBind: MemorySegment, instance: MemorySegment): List<Color> =
        memScoped {
            val count = kanama_ios_godot_ptrcall_no_args_ret_packed_color_array(
                methodBind.address(), instance.address(), null, 0L)
            if (count <= 0L) {
                emptyList()
            } else {
                val buf = allocArray<FloatVar>(count * 4)
                kanama_ios_godot_ptrcall_no_args_ret_packed_color_array(
                    methodBind.address(), instance.address(), buf, count)
                List(count.toInt()) { Color(buf[it * 4], buf[it * 4 + 1], buf[it * 4 + 2], buf[it * 4 + 3]) }
            }
        }

    // ---- single arg, void return ----
    fun ptrcallWithBoolArg(methodBind: MemorySegment, instance: MemorySegment, value: Boolean) =
        memScoped {
            val cell = alloc<ByteVar>(); cell.value = if (value) 1 else 0
            val types = allocArray<IntVar>(1); types[0] = PT_BOOL
            val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = cell.ptr.reinterpret<CPointed>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
            Unit
        }

    // Scalar int args are 8 bytes (int64) at ptrcall — widen the Kotlin Int.
    fun ptrcallWithIntArg(methodBind: MemorySegment, instance: MemorySegment, value: Int) =
        memScoped {
            val cell = alloc<LongVar>(); cell.value = value.toLong()
            val types = allocArray<IntVar>(1); types[0] = PT_INT64
            val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = cell.ptr.reinterpret<CPointed>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
            Unit
        }

    fun ptrcallWithLongArg(methodBind: MemorySegment, instance: MemorySegment, value: Long) =
        memScoped {
            val cell = alloc<LongVar>(); cell.value = value
            val types = allocArray<IntVar>(1); types[0] = PT_INT64
            val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = cell.ptr.reinterpret<CPointed>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
            Unit
        }

    // Godot scalar `float` args are 8-byte double at ptrcall — this helper covers both.
    fun ptrcallWithDoubleArg(methodBind: MemorySegment, instance: MemorySegment, value: Double) =
        memScoped {
            val cell = alloc<DoubleVar>(); cell.value = value
            val types = allocArray<IntVar>(1); types[0] = PT_FLOAT64
            val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = cell.ptr.reinterpret<CPointed>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
            Unit
        }

    fun ptrcallWithVector2Arg(methodBind: MemorySegment, instance: MemorySegment, value: Vector2) =
        memScoped {
            val cell = allocArray<FloatVar>(2)
            cell[0] = value.x.toFloat(); cell[1] = value.y.toFloat()
            val types = allocArray<IntVar>(1); types[0] = PT_VECTOR2
            val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = cell.reinterpret<CPointed>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
            Unit
        }

    fun ptrcallWithVector3Arg(methodBind: MemorySegment, instance: MemorySegment, value: Vector3) =
        memScoped {
            val cell = allocArray<FloatVar>(3)
            cell[0] = value.x.toFloat(); cell[1] = value.y.toFloat(); cell[2] = value.z.toFloat()
            val types = allocArray<IntVar>(1); types[0] = PT_VECTOR3
            val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = cell.reinterpret<CPointed>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
            Unit
        }

    fun ptrcallWithVector2iArg(methodBind: MemorySegment, instance: MemorySegment, value: Vector2i) =
        memScoped {
            val cell = allocArray<IntVar>(2)
            cell[0] = value.x; cell[1] = value.y
            val types = allocArray<IntVar>(1); types[0] = PT_VECTOR2I
            val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = cell.reinterpret<CPointed>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
            Unit
        }

    fun ptrcallWithVector3iArg(methodBind: MemorySegment, instance: MemorySegment, value: Vector3i) =
        memScoped {
            val cell = allocArray<IntVar>(3)
            cell[0] = value.x; cell[1] = value.y; cell[2] = value.z
            val types = allocArray<IntVar>(1); types[0] = PT_VECTOR3I
            val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = cell.reinterpret<CPointed>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
            Unit
        }

    fun ptrcallWithColorArg(methodBind: MemorySegment, instance: MemorySegment, value: Color) =
        memScoped {
            val cell = allocArray<FloatVar>(4)
            cell[0] = value.r; cell[1] = value.g; cell[2] = value.b; cell[3] = value.a
            val types = allocArray<IntVar>(1); types[0] = PT_COLOR
            val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = cell.reinterpret<CPointed>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
            Unit
        }

    fun ptrcallWithRect2Arg(methodBind: MemorySegment, instance: MemorySegment, value: Rect2) =
        memScoped {
            val cell = allocArray<FloatVar>(4)
            cell[0] = value.position.x.toFloat(); cell[1] = value.position.y.toFloat()
            cell[2] = value.size.x.toFloat(); cell[3] = value.size.y.toFloat()
            val types = allocArray<IntVar>(1); types[0] = PT_RECT2
            val ptrs = allocArray<COpaquePointerVar>(1); ptrs[0] = cell.reinterpret<CPointed>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 1, PT_VOID, null)
            Unit
        }

    // Hand-written: used by the bespoke Input glue (IosGodotApi.kt) for is_action_just_pressed
    // and by the ObjectCalls self-test. Not in IOS_EMIT_CLASSES, so excluded from generation.
    fun ptrcallWithStringNameAndBoolArgRetBool(methodBind: MemorySegment, instance: MemorySegment, a0: String, a1: Boolean): Boolean =
        memScoped {
            val ret = alloc<ByteVar>()
            val c1 = alloc<ByteVar>(); c1.value = if (a1) 1 else 0
            val types = allocArray<IntVar>(2); types[0] = PT_STRING_NAME; types[1] = PT_BOOL
            val ptrs = allocArray<COpaquePointerVar>(2); ptrs[0] = a0.cstr.ptr.reinterpret<CPointed>(); ptrs[1] = c1.ptr.reinterpret<CPointed>()
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, 2, PT_BOOL, ret.ptr)
            ret.value.toInt() != 0
        }

    fun ptrcallWithObjectArgs(methodBind: MemorySegment, instance: MemorySegment, objectArgs: List<MemorySegment>) =
        memScoped {
            val n = objectArgs.size
            val cells = allocArray<LongVar>(if (n > 0) n else 1)
            val types = allocArray<IntVar>(if (n > 0) n else 1)
            val ptrs = allocArray<COpaquePointerVar>(if (n > 0) n else 1)
            for (i in 0 until n) {
                cells[i] = objectArgs[i].address()
                types[i] = PT_OBJECT
                ptrs[i] = (cells + i)!!.reinterpret<CPointed>()
            }
            kanama_ios_godot_ptrcall(methodBind.address(), instance.address(), types, ptrs, n, PT_VOID, null)
            Unit
        }

    // Generic Variant Object.call dispatch (mirrors desktop ObjectCalls.callWithVariantArgs):
    // boxes each arg into a Variant C-side and invokes [methodBind] via the Variant path,
    // for the varargs / dynamic methods ptrcall can't express (Object.call, set_deferred,
    // set_custom_mouse_cursor). Returns the decoded SCALAR result (Boolean/Long/Double/
    // String/object MemorySegment) or null (nil / non-scalar return). String returns over
    // 1 KiB are truncated (the value is captured once — the call is not re-issued).
    fun callWithVariantArgs(
        methodBind: MemorySegment,
        instance: MemorySegment,
        args: List<Any?>,
    ): Any? =
        memScoped {
            val n = args.size
            val tags = allocArray<IntVar>(if (n > 0) n else 1)
            val ptrs = allocArray<COpaquePointerVar>(if (n > 0) n else 1)
            for (i in 0 until n) {
                when (val a = args[i]) {
                    null -> { tags[i] = PT_VOID; ptrs[i] = null }
                    is Boolean -> {
                        val c = alloc<ByteVar>(); c.value = if (a) 1 else 0
                        tags[i] = PT_BOOL; ptrs[i] = c.ptr.reinterpret<CPointed>()
                    }
                    is Int -> {
                        val c = alloc<LongVar>(); c.value = a.toLong()
                        tags[i] = PT_INT64; ptrs[i] = c.ptr.reinterpret<CPointed>()
                    }
                    is Long -> {
                        val c = alloc<LongVar>(); c.value = a
                        tags[i] = PT_INT64; ptrs[i] = c.ptr.reinterpret<CPointed>()
                    }
                    is Float -> {
                        val c = alloc<DoubleVar>(); c.value = a.toDouble()
                        tags[i] = PT_FLOAT64; ptrs[i] = c.ptr.reinterpret<CPointed>()
                    }
                    is Double -> {
                        val c = alloc<DoubleVar>(); c.value = a
                        tags[i] = PT_FLOAT64; ptrs[i] = c.ptr.reinterpret<CPointed>()
                    }
                    is String -> { tags[i] = PT_STRING; ptrs[i] = a.cstr.ptr.reinterpret<CPointed>() }
                    is Vector2 -> {
                        val c = allocArray<FloatVar>(2); c[0] = a.x.toFloat(); c[1] = a.y.toFloat()
                        tags[i] = PT_VECTOR2; ptrs[i] = c.reinterpret<CPointed>()
                    }
                    is Vector2i -> {
                        val c = allocArray<IntVar>(2); c[0] = a.x; c[1] = a.y
                        tags[i] = PT_VECTOR2I; ptrs[i] = c.reinterpret<CPointed>()
                    }
                    is Color -> {
                        val c = allocArray<FloatVar>(4); c[0] = a.r; c[1] = a.g; c[2] = a.b; c[3] = a.a
                        tags[i] = PT_COLOR; ptrs[i] = c.reinterpret<CPointed>()
                    }
                    is GodotObject -> {
                        val c = alloc<LongVar>(); c.value = a.handle.address()
                        tags[i] = PT_OBJECT; ptrs[i] = c.ptr.reinterpret<CPointed>()
                    }
                    is MemorySegment -> {
                        val c = alloc<LongVar>(); c.value = a.address()
                        tags[i] = PT_OBJECT; ptrs[i] = c.ptr.reinterpret<CPointed>()
                    }
                    else -> error("callWithVariantArgs: unsupported arg type ${a::class.simpleName}")
                }
            }
            val outInt = alloc<LongVar>()
            val outDouble = alloc<DoubleVar>()
            val strBufSize = 1024L
            val outStr = allocArray<ByteVar>(strBufSize)
            val outStrLen = alloc<LongVar>()
            val retType = kanama_ios_godot_object_call(
                methodBind.address(),
                instance.address(),
                tags,
                ptrs,
                n,
                outInt.ptr,
                outDouble.ptr,
                outStr,
                strBufSize,
                outStrLen.ptr,
            )
            when (retType) {
                VT_BOOL -> outInt.value != 0L
                VT_INT -> outInt.value
                VT_FLOAT -> outDouble.value
                VT_STRING -> {
                    val len = minOf(outStrLen.value, strBufSize).toInt().coerceAtLeast(0)
                    outStr.readBytes(len).decodeToString()
                }
                VT_OBJECT -> if (outInt.value != 0L) MemorySegment.ofAddress(outInt.value) else null
                else -> null
            }
        }
}

// Debug-gated self-test (called from the C scene-init self-test): validates the full
// Kotlin->C->Godot path through ObjectCalls — Vector3 float32 component layout, bool,
// int64 return, and scalar-float-as-double — against real Godot on device.
@OptIn(ExperimentalNativeApi::class)
@CName("kanama_ios_runtime_objectcalls_selftest")
fun kanamaIosRuntimeObjectCallsSelfTest() {
    var pass = 0
    var fail = 0
    fun check(label: String, cond: Boolean) {
        if (cond) {
            pass++
        } else {
            fail++
            println("[kanama][ios][kn] OBJECTCALLS SELFTEST FAIL: $label")
        }
    }

    val n3 = ObjectCalls.constructObject("Node3D")
    ObjectCalls.ptrcallWithVector3Arg(
        ObjectCalls.getMethodBind("Node3D", "set_position", 3460891852L), n3, Vector3(1.0, 2.0, 3.0))
    val p = ObjectCalls.ptrcallNoArgsRetVector3(
        ObjectCalls.getMethodBind("Node3D", "get_position", 3360562783L), n3)
    check("vector3", p.x == 1.0 && p.y == 2.0 && p.z == 3.0)

    // Generated-helper round-trip (T3.1): ptrcallWithVector3ArgRetVector3 lives in the
    // GENERATED ObjectCallsGenerated.kt (extension on ObjectCalls), not hand-written —
    // it exercises the generator's Vector3 arg-in + Vector3 ret-out codegen against real
    // Godot. Use a FRESH Node3D (identity transform) so to_global is the identity map
    // and the assertion is independent of in-tree global-transform semantics; this
    // isolates the marshalling (arg float32 layout in, ret float32 layout out).
    val n3b = ObjectCalls.constructObject("Node3D")
    val g = ObjectCalls.ptrcallWithVector3ArgRetVector3(
        ObjectCalls.getMethodBind("Node3D", "to_global", 192990374L), n3b, Vector3(10.0, 20.0, 30.0))
    println("[kanama][ios][kn] OBJECTCALLS SELFTEST generated-vector3 g=(${g.x}, ${g.y}, ${g.z})")
    check("generated-vector3-arg-ret", g.x == 10.0 && g.y == 20.0 && g.z == 30.0)

    ObjectCalls.ptrcallWithBoolArg(
        ObjectCalls.getMethodBind("Node3D", "set_visible", 2586408642L), n3, false)
    check("bool", !ObjectCalls.ptrcallNoArgsRetBool(
        ObjectCalls.getMethodBind("Node3D", "is_visible", 36873697L), n3))

    val id = ObjectCalls.ptrcallNoArgsRetLong(
        ObjectCalls.getMethodBind("Object", "get_instance_id", 3905245786L), n3)
    check("int64-ret", id != 0L)

    val n2 = ObjectCalls.constructObject("Node2D")
    ObjectCalls.ptrcallWithDoubleArg(
        ObjectCalls.getMethodBind("Node2D", "set_rotation", 373806689L), n2, 0.5)
    check("scalar-float-as-double", ObjectCalls.ptrcallNoArgsRetDouble(
        ObjectCalls.getMethodBind("Node2D", "get_rotation", 1740695150L), n2) == 0.5)

    val parts = ObjectCalls.constructObject("GPUParticles3D")
    ObjectCalls.ptrcallWithIntArg(
        ObjectCalls.getMethodBind("GPUParticles3D", "set_amount", 1286410249L), parts, 1234567)
    check("scalar-int(8-byte)", ObjectCalls.ptrcallNoArgsRetInt(
        ObjectCalls.getMethodBind("GPUParticles3D", "get_amount", 3905245786L), parts) == 1234567)

    // T3.3: Input singleton + action polling marshalling. With no live input the values
    // are 0.0/false, but this validates getSingleton + the generated StringName-arg
    // helpers (ptrcallWithTwoStringNameArgsRetDouble / ptrcallWithStringNameAndBoolArgRetBool)
    // on device. The gameplay assertion (nonzero under input) is T3.4's full-demo run.
    val inputSingleton = ObjectCalls.getSingleton("Input")
    check("input-singleton", inputSingleton.address() != 0L)
    val axis = ObjectCalls.ptrcallWithTwoStringNameArgsRetDouble(
        ObjectCalls.getMethodBind("Input", "get_axis", 1958752504L), inputSingleton, "ui_left", "ui_right")
    check("input-get_axis(no-input==0)", axis == 0.0)
    val jumped = ObjectCalls.ptrcallWithStringNameAndBoolArgRetBool(
        ObjectCalls.getMethodBind("Input", "is_action_just_pressed", 1558498928L), inputSingleton, "ui_accept", false)
    check("input-is_action_just_pressed(no-input==false)", !jumped)

    // Vector2i (2x int32, 8B): Sprite2D.set_frame_coords(Vector2i(3,7)) -> get_frame_coords()
    // Godot rejects frame_coords outside [0,hframes)x[0,vframes) (defaults 1x1) via
    // ERR_FAIL_INDEX, so widen the frame grid first or (3,7) is a silent no-op.
    // DEVICE-VALIDATED 2026-06-12 (iPhone 12, iOS 26.5) — Phase 2.1
    val sprite2d = ObjectCalls.constructObject("Sprite2D")
    ObjectCalls.ptrcallWithLongArg(
        ObjectCalls.getMethodBind("Sprite2D", "set_hframes", 1286410249L), sprite2d, 4L)
    ObjectCalls.ptrcallWithLongArg(
        ObjectCalls.getMethodBind("Sprite2D", "set_vframes", 1286410249L), sprite2d, 8L)
    ObjectCalls.ptrcallWithVector2iArg(
        ObjectCalls.getMethodBind("Sprite2D", "set_frame_coords", 1130785943L), sprite2d, Vector2i(3, 7))
    val v2i = ObjectCalls.ptrcallNoArgsRetVector2i(
        ObjectCalls.getMethodBind("Sprite2D", "get_frame_coords", 3690982128L), sprite2d)
    check("vector2i", v2i.x == 3 && v2i.y == 7)

    // Vector3i (3x int32, 12B): PlaceholderTexture3D.set_size(Vector3i(5,11,17)) -> get_size()
    // DEVICE-VALIDATED 2026-06-12 (iPhone 12, iOS 26.5) — Phase 2.1
    val tex3d = ObjectCalls.constructObject("PlaceholderTexture3D")
    ObjectCalls.ptrcallWithVector3iArg(
        ObjectCalls.getMethodBind("PlaceholderTexture3D", "set_size", 560364750L), tex3d, Vector3i(5, 11, 17))
    val v3i = ObjectCalls.ptrcallNoArgsRetVector3i(
        ObjectCalls.getMethodBind("PlaceholderTexture3D", "get_size", 2785653706L), tex3d)
    check("vector3i", v3i.x == 5 && v3i.y == 11 && v3i.z == 17)

    // Color (4x float32, 16B): CanvasItem.set_modulate(Color(0.125,0.25,0.5,0.75)) -> get_modulate()
    // Validation-free: modulate is a stored Color with no engine clamping or index checks.
    // Component values 0.125/0.25/0.5/0.75 are exact in float32 (powers of 2), so
    // equality checks are stable without epsilon. Node2D is a CanvasItem.
    // DEVICE-VALIDATED 2026-06-12 (iPhone 12, iOS 26.5) — Phase 2.2
    val n2c = ObjectCalls.constructObject("Node2D")
    ObjectCalls.ptrcallWithColorArg(
        ObjectCalls.getMethodBind("CanvasItem", "set_modulate", 2920490490L), n2c,
        Color(0.125f, 0.25f, 0.5f, 0.75f))
    val col = ObjectCalls.ptrcallNoArgsRetColor(
        ObjectCalls.getMethodBind("CanvasItem", "get_modulate", 3444240500L), n2c)
    check("color", col.r == 0.125f && col.g == 0.25f && col.b == 0.5f && col.a == 0.75f)

    // Rect2 (4x float32, 16B): GPUParticles2D.set_visibility_rect -> get_visibility_rect()
    // Validation-free: visibility_rect is a stored Rect2 with no engine clamping.
    // Component values 1.5/2.5/3.5/4.5 are exact in float32, so equality is stable.
    // DEVICE-VALIDATED 2026-06-12 (iPhone 12, iOS 26.5) — Phase 2.2
    val gp2d = ObjectCalls.constructObject("GPUParticles2D")
    ObjectCalls.ptrcallWithRect2Arg(
        ObjectCalls.getMethodBind("GPUParticles2D", "set_visibility_rect", 2046264180L), gp2d,
        Rect2(Vector2(1.5, 2.5), Vector2(3.5, 4.5)))
    val r2 = ObjectCalls.ptrcallNoArgsRetRect2(
        ObjectCalls.getMethodBind("GPUParticles2D", "get_visibility_rect", 1639390495L), gp2d)
    check("rect2", r2.position.x == 1.5 && r2.position.y == 2.5 && r2.size.x == 3.5 && r2.size.y == 4.5)

    // String-return (Object.get_class -> "Node2D"): exercises ptrcallNoArgsRetString
    // through the full Kotlin -> dedicated C helper -> Godot path (string_to_utf8_chars
    // round-trip). Deterministic, validation-free class name.
    // DEVICE-VALIDATED 2026-06-12 (iPhone 12, iOS 26.5) — Phase 2.3a
    val n2cls = ObjectCalls.constructObject("Node2D")
    val cls = ObjectCalls.ptrcallNoArgsRetString(
        ObjectCalls.getMethodBind("Object", "get_class", 201670096L), n2cls)
    check("string-ret(get_class==Node2D)", cls == "Node2D")

    // StringName-return (Node.get_name): set a known name (StringName arg) then read it
    // back through ptrcallNoArgsRetStringName — exercises the StringName->String ctor
    // hop end to end. Deterministic; node name has no validation.
    // DEVICE-VALIDATED 2026-06-13 (iPhone 12, iOS 26.5) — Phase 2.3b
    val nName = ObjectCalls.constructObject("Node")
    ObjectCalls.ptrcallWithStringNameArg(
        ObjectCalls.getMethodBind("Node", "set_name", 3304788590L), nName, "KanamaSN")
    val nm = ObjectCalls.ptrcallNoArgsRetStringName(
        ObjectCalls.getMethodBind("Node", "get_name", 2002593661L), nName)
    check("string-name-ret(get_name==KanamaSN)", nm == "KanamaSN")

    // String arg (Node.set_scene_file_path -> get_scene_file_path): exercises the
    // generated ptrcallWithStringArg → PT_STRING construction (init_string C-side)
    // round-trip. Node (not a Control) avoids the treeless-Control post-init Theme
    // segfault — unrelated to String marshalling.
    // DEVICE-VALIDATED 2026-06-13 (iPhone 12, iOS 26.5) — Phase 2.4
    val sNode = ObjectCalls.constructObject("Node")
    ObjectCalls.ptrcallWithStringArg(
        ObjectCalls.getMethodBind("Node", "set_scene_file_path", 83702148L), sNode, "HelloKanama")
    val textBack = ObjectCalls.ptrcallNoArgsRetString(
        ObjectCalls.getMethodBind("Node", "get_scene_file_path", 201670096L), sNode)
    check("string-arg(set/get_scene_file_path==HelloKanama)", textBack == "HelloKanama")

    // NodePath arg (Node.get_node_or_null): add a named child, then look it up by
    // NodePath — the path must round-trip through PT_NODE_PATH construction
    // (init_node_path C-side) for the lookup to resolve to the same child handle.
    // DEVICE-VALIDATED 2026-06-13 (iPhone 12, iOS 26.5) — Phase 2.4
    val npParent = ObjectCalls.constructObject("Node")
    val npChild = ObjectCalls.constructObject("Node")
    ObjectCalls.ptrcallWithStringNameArg(
        ObjectCalls.getMethodBind("Node", "set_name", 3304788590L), npChild, "KPChild")
    ObjectCalls.ptrcallWithObjectBoolLongArgs(
        ObjectCalls.getMethodBind("Node", "add_child", 3863233950L), npParent, npChild, false, 0L)
    val gotNode = ObjectCalls.ptrcallWithNodePathArgRetObject(
        ObjectCalls.getMethodBind("Node", "get_node_or_null", 2734337346L), npParent, NodePath("KPChild"))
    check("nodepath-arg(get_node_or_null==child)", gotNode.address() == npChild.address())

    // NodePath-return (GPUParticles2D.set_sub_emitter -> get_sub_emitter): set a known path
    // (NodePath arg) then read it back through ptrcallNoArgsRetNodePath — exercises the
    // NodePath->String ctor hop end to end, wrapped back into a NodePath. Phase 2.7b.
    val gpNp = ObjectCalls.constructObject("GPUParticles2D")
    ObjectCalls.ptrcallWithNodePathArg(
        ObjectCalls.getMethodBind("GPUParticles2D", "set_sub_emitter", 1348162250L), gpNp, NodePath("../Emitter"))
    val subEmitter = ObjectCalls.ptrcallNoArgsRetNodePath(
        ObjectCalls.getMethodBind("GPUParticles2D", "get_sub_emitter", 4075236667L), gpNp)
    check("nodepath-ret(set/get_sub_emitter==../Emitter)", subEmitter == NodePath("../Emitter"))

    // PackedInt32Array-return (MeshLibrary.get_item_list): create two items (via the Variant
    // call path — ids 7 and 11), then read the id list back through ptrcallNoArgsRetPackedInt32List
    // (size + operator_index_const, two-call length protocol). The item-id map is sorted, so the
    // result is [7, 11] — known, distinct, non-zero values. MeshLibrary is a plain Resource, safe
    // to construct at init time — unlike a physics body (the only emitted PackedInt32Array getter,
    // CollisionObject2D/3D.get_shape_owners) which segfaults in its constructor this early. Proves
    // the Kotlin -> C -> ptrcall -> read-back path end to end. Phase 2.7c.
    val meshLib = ObjectCalls.constructObject("MeshLibrary")
    val meshLibCallBind = ObjectCalls.getMethodBind("Object", "call", 3400424181L)
    ObjectCalls.callWithVariantArgs(meshLibCallBind, meshLib, listOf("create_item", 7L))
    ObjectCalls.callWithVariantArgs(meshLibCallBind, meshLib, listOf("create_item", 11L))
    val itemList = ObjectCalls.ptrcallNoArgsRetPackedInt32List(
        ObjectCalls.getMethodBind("MeshLibrary", "get_item_list", 1930428628L), meshLib)
    check("packed-int32-ret(get_item_list==[7,11])", itemList == listOf(7, 11))

    // PackedFloat32Array-return (Gradient.get_offsets): a fresh Gradient seeds two default
    // points at offsets 0.0 and 1.0, so get_offsets() == [0.0, 1.0] — read back through
    // ptrcallNoArgsRetPackedFloat32List (float32 element variant). Gradient is a plain
    // Resource, safe to construct at init. Phase 2.7c-2.
    val gradient = ObjectCalls.constructObject("Gradient")
    val offsets = ObjectCalls.ptrcallNoArgsRetPackedFloat32List(
        ObjectCalls.getMethodBind("Gradient", "get_offsets", 675695659L), gradient)
    check("packed-float32-ret(get_offsets==[0,1])", offsets == listOf(0.0f, 1.0f))

    // PackedFloat32Array-arg (Gradient.set_offsets): build a list C-side and set it, then read
    // it back. Exercises the build-from-list arg path end to end. Phase 2.7c-4.
    val gradientA = ObjectCalls.constructObject("Gradient")
    ObjectCalls.ptrcallWithPackedFloat32ListArg(
        ObjectCalls.getMethodBind("Gradient", "set_offsets", 2899603908L), gradientA,
        listOf(0.25f, 0.5f, 0.75f))
    val offsetsBack = ObjectCalls.ptrcallNoArgsRetPackedFloat32List(
        ObjectCalls.getMethodBind("Gradient", "get_offsets", 675695659L), gradientA)
    check("packed-float32-arg(set/get_offsets==[0.25,0.5,0.75])",
        offsetsBack == listOf(0.25f, 0.5f, 0.75f))

    // PackedVector2Array-return (Line2D.get_points): add two points via the Vector2 arg path,
    // then read them back through ptrcallNoArgsRetPackedVector2List (2 float32 per element).
    // Line2D is a Node2D, safe at init. Phase 2.7c-3.
    val line2d = ObjectCalls.constructObject("Line2D")
    val line2dCallBind = ObjectCalls.getMethodBind("Object", "call", 3400424181L)
    ObjectCalls.callWithVariantArgs(line2dCallBind, line2d, listOf("add_point", Vector2(1.5, 2.5), -1L))
    ObjectCalls.callWithVariantArgs(line2dCallBind, line2d, listOf("add_point", Vector2(3.5, 4.5), -1L))
    val points = ObjectCalls.ptrcallNoArgsRetPackedVector2List(
        ObjectCalls.getMethodBind("Line2D", "get_points", 2961356807L), line2d)
    check("packed-vector2-ret(get_points==[(1.5,2.5),(3.5,4.5)])",
        points == listOf(Vector2(1.5, 2.5), Vector2(3.5, 4.5)))

    // PackedColorArray-return (Gradient.get_colors): a fresh Gradient seeds default colors
    // black and white -> read back through ptrcallNoArgsRetPackedColorList (4 float32 per
    // element). Phase 2.7c-3.
    val gradientC = ObjectCalls.constructObject("Gradient")
    val colors = ObjectCalls.ptrcallNoArgsRetPackedColorList(
        ObjectCalls.getMethodBind("Gradient", "get_colors", 1392750486L), gradientC)
    check("packed-color-ret(get_colors==[black,white])",
        colors == listOf(Color(0.0f, 0.0f, 0.0f, 1.0f), Color(1.0f, 1.0f, 1.0f, 1.0f)))

    // Transform3D arg+return (Node3D.set_transform -> get_transform): 12x float32
    // (9 column-major basis + 3 origin) round-trip through the generated helpers. Pure-
    // scale diagonal basis; all components exact in float32 so data-class == is stable.
    // DEVICE-VALIDATED 2026-06-13 (iPhone 12, iOS 26.5) — Phase 2.5
    val n3t = ObjectCalls.constructObject("Node3D")
    val tIn = Transform3D(
        Basis(Vector3(2.0, 0.0, 0.0), Vector3(0.0, 4.0, 0.0), Vector3(0.0, 0.0, 0.5)),
        Vector3(1.25, 2.5, 4.75))
    ObjectCalls.ptrcallWithTransform3DArg(
        ObjectCalls.getMethodBind("Node3D", "set_transform", 2952846383L), n3t, tIn)
    val tOut = ObjectCalls.ptrcallNoArgsRetTransform3D(
        ObjectCalls.getMethodBind("Node3D", "get_transform", 3229777777L), n3t)
    check("transform3d(set/get_transform)", tOut == tIn)

    // Transform2D arg+return (Node2D.set_transform -> CanvasItem.get_transform): 6x float32
    // (columns x, y, origin — each Vector2). Node2D overrides CanvasItem.get_transform to
    // return the local _transform, so a bare node round-trips. x=(2,0) y=(0,4) origin=(1.25,2.5)
    // — exact in float32; the asymmetric layout also catches a wrong component order. Phase 2.7a.
    val n2t = ObjectCalls.constructObject("Node2D")
    val t2In = Transform2D(Vector2(2.0, 0.0), Vector2(0.0, 4.0), Vector2(1.25, 2.5))
    ObjectCalls.ptrcallWithTransform2DArg(
        ObjectCalls.getMethodBind("Node2D", "set_transform", 2761652528L), n2t, t2In)
    val t2Out = ObjectCalls.ptrcallNoArgsRetTransform2D(
        ObjectCalls.getMethodBind("CanvasItem", "get_transform", 3814499831L), n2t)
    check("transform2d(set/get_transform)", t2Out == t2In)

    // Basis arg+return (Node3D.set_basis -> get_basis): 9x float32 column-major.
    // DEVICE-VALIDATED 2026-06-13 (iPhone 12, iOS 26.5) — Phase 2.5
    val basisNode = ObjectCalls.constructObject("Node3D")
    val bIn = Basis(Vector3(0.5, 0.0, 0.0), Vector3(0.0, 8.0, 0.0), Vector3(0.0, 0.0, 0.25))
    ObjectCalls.ptrcallWithBasisArg(
        ObjectCalls.getMethodBind("Node3D", "set_basis", 1055510324L), basisNode, bIn)
    val bOut = ObjectCalls.ptrcallNoArgsRetBasis(
        ObjectCalls.getMethodBind("Node3D", "get_basis", 2716978435L), basisNode)
    check("basis(set/get_basis)", bOut == bIn)

    // RID arg+return (GPUParticles3D get_base/set_base): the auto-assigned particles
    // base RID is read, set back, and read again — round-trips the uint64.
    // DEVICE-VALIDATED 2026-06-13 (iPhone 12, iOS 26.5) — RID/Quaternion/AABB kinds
    val gpRid = ObjectCalls.constructObject("GPUParticles3D")
    val rid1 = ObjectCalls.ptrcallNoArgsRetRID(
        ObjectCalls.getMethodBind("VisualInstance3D", "get_base", 2944877500L), gpRid)
    ObjectCalls.ptrcallWithRIDArg(
        ObjectCalls.getMethodBind("VisualInstance3D", "set_base", 2722037293L), gpRid, rid1)
    val rid2 = ObjectCalls.ptrcallNoArgsRetRID(
        ObjectCalls.getMethodBind("VisualInstance3D", "get_base", 2944877500L), gpRid)
    check("rid(get/set_base)", rid1.value != 0L && rid2 == rid1)

    // AABB arg+return (GPUParticles3D set/get_custom_aabb): 6x float32, exact round-trip.
    // DEVICE-VALIDATED 2026-06-13 (iPhone 12, iOS 26.5) — RID/Quaternion/AABB kinds
    val gpAabb = ObjectCalls.constructObject("GPUParticles3D")
    val aIn = AABB(Vector3(1.5, 2.5, 3.5), Vector3(4.5, 5.5, 6.5))
    ObjectCalls.ptrcallWithAABBArg(
        ObjectCalls.getMethodBind("GeometryInstance3D", "set_custom_aabb", 259215842L), gpAabb, aIn)
    val aOut = ObjectCalls.ptrcallNoArgsRetAABB(
        ObjectCalls.getMethodBind("GeometryInstance3D", "get_custom_aabb", 1068685055L), gpAabb)
    check("aabb(set/get_custom_aabb)", aOut == aIn)

    // Quaternion arg+return (Node3D set/get_quaternion): 4x float32 [x,y,z,w]. Godot
    // re-derives the quaternion from a basis, so compare with epsilon. Unit (0.5×4).
    // DEVICE-VALIDATED 2026-06-13 (iPhone 12, iOS 26.5) — RID/Quaternion/AABB kinds
    val quatNode = ObjectCalls.constructObject("Node3D")
    val qIn = Quaternion(0.5, 0.5, 0.5, 0.5)
    ObjectCalls.ptrcallWithQuaternionArg(
        ObjectCalls.getMethodBind("Node3D", "set_quaternion", 1727505552L), quatNode, qIn)
    val qOut = ObjectCalls.ptrcallNoArgsRetQuaternion(
        ObjectCalls.getMethodBind("Node3D", "get_quaternion", 1222331677L), quatNode)
    fun nearly(a: Double, b: Double) = (if (a > b) a - b else b - a) < 1e-4
    check("quaternion(set/get_quaternion)",
        nearly(qOut.x, qIn.x) && nearly(qOut.y, qIn.y) && nearly(qOut.z, qIn.z) && nearly(qOut.w, qIn.w))

    // Variant Object.call dispatch (ObjectCalls.callWithVariantArgs): the Kotlin marshalling
    // path — Any? args -> PT-tagged Variants C-side -> object_method_bind_call -> scalar return
    // decode. Node (not a Control) avoids the treeless-Control post-init Theme segfault.
    // (iOS Variant Object.call dispatch — the 5 IosGodotApi STUBs)
    val callBind = ObjectCalls.getMethodBind("Object", "call", 3400424181L)
    val callNode = ObjectCalls.constructObject("Node")
    // String value arg: call("set_name", "KCall") then read it back via ptrcall.
    ObjectCalls.callWithVariantArgs(callBind, callNode, listOf("set_name", "KCall"))
    check("variant-call-arg(set_name)", ObjectCalls.ptrcallNoArgsRetStringName(
        ObjectCalls.getMethodBind("Node", "get_name", 2002593661L), callNode) == "KCall")
    // String return decode: call("get_class") -> "Node".
    check("variant-call-ret-string(get_class==Node)",
        ObjectCalls.callWithVariantArgs(callBind, callNode, listOf("get_class")) == "Node")
    // Int return decode: call("get_child_count") -> 0L on a fresh node.
    check("variant-call-ret-int(get_child_count==0)",
        ObjectCalls.callWithVariantArgs(callBind, callNode, listOf("get_child_count")) == 0L)
    // Bool return decode: call("is_inside_tree") -> false (not in a tree).
    check("variant-call-ret-bool(is_inside_tree==false)",
        ObjectCalls.callWithVariantArgs(callBind, callNode, listOf("is_inside_tree")) == false)
    // Int VALUE arg + int return via set_meta/get_meta (the boxing path set_deferred uses).
    ObjectCalls.callWithVariantArgs(callBind, callNode, listOf("set_meta", "kcall", 4242L))
    check("variant-call-value-int(set_meta/get_meta)",
        ObjectCalls.callWithVariantArgs(callBind, callNode, listOf("get_meta", "kcall")) == 4242L)
    // Object VALUE arg (GodotObject) + Object return via set_meta/get_meta.
    val metaObj = ObjectCalls.constructObject("Node")
    ObjectCalls.callWithVariantArgs(callBind, callNode, listOf("set_meta", "kobj", GodotObject(metaObj)))
    val gotObj = ObjectCalls.callWithVariantArgs(callBind, callNode, listOf("get_meta", "kobj"))
    check("variant-call-value-object(set_meta/get_meta object)",
        gotObj is MemorySegment && gotObj.address() == metaObj.address())

    // Value-type builtin method (BuiltinCalls) via variant_get_ptr_builtin_method + builtin_call.
    // Basis.inverse() is a TRUE inverse: diag(2,4,8) -> diag(0.5,0.25,0.125) (powers of 2, exact
    // float32). Transform3D.inverse() assumes orthonormal — it transposes the basis (diag stays
    // diag) and sets origin = basisᵀ·(-origin); diag(2,4,8) + origin(1,2,3) -> diag(2,4,8) +
    // origin(-2,-8,-24). Both exact in float32 so data-class == is stable; the nonzero origin
    // proves the 12-float layout + that the engine actually transformed it (not a passthrough).
    val bScale = Basis(Vector3(2.0, 0.0, 0.0), Vector3(0.0, 4.0, 0.0), Vector3(0.0, 0.0, 8.0))
    check("builtin-call(Basis.inverse diag)",
        bScale.inverse() == Basis(Vector3(0.5, 0.0, 0.0), Vector3(0.0, 0.25, 0.0), Vector3(0.0, 0.0, 0.125)))
    val tScale = Transform3D(bScale, Vector3(1.0, 2.0, 3.0))
    check("builtin-call(Transform3D.inverse orthonormal-transpose)",
        tScale.inverse() == Transform3D(bScale, Vector3(-2.0, -8.0, -24.0)))

    // affine_inverse() is the TRUE inverse (incl. scale): basis diag(2,4,8)->diag(0.5,0.25,0.125),
    // origin = inv_basis·(-origin) = (0.5·-1, 0.25·-2, 0.125·-3) = (-0.5,-0.5,-0.375). Exact.
    check("builtin-call(Transform3D.affineInverse scale)",
        tScale.affineInverse() == Transform3D(
            Basis(Vector3(0.5, 0.0, 0.0), Vector3(0.0, 0.25, 0.0), Vector3(0.0, 0.0, 0.125)),
            Vector3(-0.5, -0.5, -0.375)))
    // Basis.transposed(): shear x=(1,0,0),y=(2,1,0),z=(0,0,1) -> x=(1,2,0),y=(0,1,0),z=(0,0,1).
    // Asymmetric so a no-op/wrong-layout fails; exact float32.
    val bShear = Basis(Vector3(1.0, 0.0, 0.0), Vector3(2.0, 1.0, 0.0), Vector3(0.0, 0.0, 1.0))
    check("builtin-call(Basis.transposed shear)",
        bShear.transposed() == Basis(Vector3(1.0, 2.0, 0.0), Vector3(0.0, 1.0, 0.0), Vector3(0.0, 0.0, 1.0)))
    // Basis.orthonormalized(): normalizes each axis — diag(2,4,8) -> IDENTITY. Exact.
    check("builtin-call(Basis.orthonormalized scale)", bScale.orthonormalized() == Basis.IDENTITY)
    // Transform3D.looking_at (arg path: Vector3,Vector3,bool): discards rotation, points -Z at
    // target. From origin 0 a 90°-about-Z base, looking at (0,0,-4) up +Y -> IDENTITY (origin 0).
    // Compared component-wise with `==` (not data-class equals): looking_at's cross products
    // yield -0.0 in some zero slots, and Double.equals treats -0.0 != 0.0 (but `==` doesn't).
    val tRot = Transform3D(
        Basis(Vector3(0.0, 1.0, 0.0), Vector3(-1.0, 0.0, 0.0), Vector3(0.0, 0.0, 1.0)), Vector3.ZERO)
    val look = tRot.lookingAt(Vector3(0.0, 0.0, -4.0), Vector3(0.0, 1.0, 0.0), false)
    fun vecEq(a: Vector3, b: Vector3) = a.x == b.x && a.y == b.y && a.z == b.z
    val idT = Transform3D.IDENTITY
    check("builtin-call(Transform3D.lookingAt -Z)",
        vecEq(look.basis.x, idT.basis.x) && vecEq(look.basis.y, idT.basis.y) &&
            vecEq(look.basis.z, idT.basis.z) && vecEq(look.origin, idT.origin))
    // Transform3D.interpolate_with (arg path: Transform3D,double) at weight 0.5: midpoint of
    // origin0 and origin(2,4,8) is (1,2,4); identity bases slerp to identity. Exact.
    check("builtin-call(Transform3D.interpolateWith 0.5)",
        Transform3D.IDENTITY.interpolateWith(Transform3D(Basis.IDENTITY, Vector3(2.0, 4.0, 8.0)), 0.5) ==
            Transform3D(Basis.IDENTITY, Vector3(1.0, 2.0, 4.0)))

    // Vector3.cross (arg path: Vector3 base + Vector3 arg, new VT_VECTOR3): x̂×ŷ = ẑ. The
    // cross product yields -0.0 in the zero slots, so compare component-wise with `==`
    // (numeric, treats -0.0 == 0.0) rather than data-class equals (Double.equals: -0.0 != 0.0).
    val cross = Vector3(1.0, 0.0, 0.0).cross(Vector3(0.0, 1.0, 0.0))
    check("builtin-call(Vector3.cross x*y=z)", cross.x == 0.0 && cross.y == 0.0 && cross.z == 1.0)

    // Vector2.rotated (arg path: Vector2 base + double scalar, new VT_VECTOR2): (1,0) by π/2 ->
    // (~0,1). Float trig, so component-wise tolerance ε (also avoids the -0.0 data-class trap).
    val rot = Vector2(1.0, 0.0).rotated(kotlin.math.PI / 2.0)
    check("builtin-call(Vector2.rotated pi/2)",
        kotlin.math.abs(rot.x) < 1e-4 && kotlin.math.abs(rot.y - 1.0) < 1e-4)

    // Quaternion.inverse (no-arg->Self, new VT_QUATERNION): for the unit quaternion 90° about Z
    // = (0,0,sin45,cos45) the inverse is the conjugate (z flips sign, w kept). Float divide by
    // length² so component-wise tolerance ε.
    val s = 0.7071067811865476
    val qInv = Quaternion(0.0, 0.0, s, s).inverse()
    check("builtin-call(Quaternion.inverse 90z)",
        kotlin.math.abs(qInv.x) < 1e-4 && kotlin.math.abs(qInv.y) < 1e-4 &&
            kotlin.math.abs(qInv.z + s) < 1e-4 && kotlin.math.abs(qInv.w - s) < 1e-4)

    // Basis.scaled (arg path: Basis base + Vector3 arg): IDENTITY scaled by (2,3,4) -> diag(2,3,4).
    // Exact float32, but compare component-wise with `==` to dodge any -0.0 in the off-diagonal.
    val scaled = Basis.IDENTITY.scaled(Vector3(2.0, 3.0, 4.0))
    check("builtin-call(Basis.scaled diag)",
        vecEq(scaled.x, Vector3(2.0, 0.0, 0.0)) && vecEq(scaled.y, Vector3(0.0, 3.0, 0.0)) &&
            vecEq(scaled.z, Vector3(0.0, 0.0, 4.0)))

    // Transform3D.translated (arg path: Transform3D base + Vector3 arg): IDENTITY+origin0
    // translated by (1,2,3) -> IDENTITY+origin(1,2,3). Exact; component-wise `==`.
    val moved = Transform3D.IDENTITY.translated(Vector3(1.0, 2.0, 3.0))
    check("builtin-call(Transform3D.translated offset)",
        vecEq(moved.basis.x, Vector3(1.0, 0.0, 0.0)) &&
            vecEq(moved.basis.y, Vector3(0.0, 1.0, 0.0)) &&
            vecEq(moved.basis.z, Vector3(0.0, 0.0, 1.0)) &&
            vecEq(moved.origin, Vector3(1.0, 2.0, 3.0)))

    // Scalar-return builtin (real_t -> float32 on iOS, decoded to Double via callScalar).
    // Vector3.dot: (1,2,3)·(4,5,6) = 32; exact integer in float32 so `==` is stable.
    check("builtin-call(Vector3.dot scalar)",
        Vector3(1.0, 2.0, 3.0).dot(Vector3(4.0, 5.0, 6.0)) == 32.0)
    // Basis.determinant: diag(2,4,8) -> 64; exact integer.
    check("builtin-call(Basis.determinant scalar)",
        Basis(Vector3(2.0, 0.0, 0.0), Vector3(0.0, 4.0, 0.0), Vector3(0.0, 0.0, 8.0)).determinant() == 64.0)

    // Bool-return builtin (ptr-ABI uint8 -> Boolean via callBool): Vector3.is_normalized().
    // (0,0,1) is normalized -> true; (2,0,0) is not -> false. Both directions guard the decode.
    check("builtin-call(Vector3.is_normalized bool)",
        Vector3(0.0, 0.0, 1.0).isNormalized() && !Vector3(2.0, 0.0, 0.0).isNormalized())
    // Int-return builtin (ptr-ABI int64 -> Int via callInt): Vector3.max_axis_index().
    // (1,5,2) -> Y = 1; (1,2,9) -> Z = 2. Non-zero expectations catch a wrong-width zero-read.
    check("builtin-call(Vector3.max_axis_index int)",
        Vector3(1.0, 5.0, 2.0).maxAxisIndex() == 1 && Vector3(1.0, 2.0, 9.0).maxAxisIndex() == 2)

    // Value-type @ScriptProperty decode (Phase 3.2 Step 5 / 2.6): exercise decodeIosPropertyValue's
    // tag dispatch — the Kotlin side of the set-property value path. The C side ships float32
    // component buffers (Vector2/Vector3) and utf8 path bytes (NodePath) with PT_* tags; this
    // reproduces those exact buffers and asserts the decoded value. Components compared numerically
    // (1.5/-2.5/1/2/3 are exact in float32->double, no -0.0 in play).
    memScoped {
        val v2 = allocArray<FloatVar>(2)
        v2[0] = 1.5f; v2[1] = -2.5f
        val dv2 = decodeIosPropertyValue(6, v2.reinterpret(), 8) as? Vector2
        check("setprop-decode(Vector2)", dv2 != null && dv2.x == 1.5 && dv2.y == -2.5)

        val v3 = allocArray<FloatVar>(3)
        v3[0] = 1.0f; v3[1] = 2.0f; v3[2] = 3.0f
        val dv3 = decodeIosPropertyValue(8, v3.reinterpret(), 12) as? Vector3
        check("setprop-decode(Vector3)", dv3 != null && dv3.x == 1.0 && dv3.y == 2.0 && dv3.z == 3.0)

        val path = "../SceneTarget3D"
        val pathBytes = path.encodeToByteArray()
        val pb = allocArray<ByteVar>(pathBytes.size)
        for (i in pathBytes.indices) pb[i] = pathBytes[i]
        val dnp = decodeIosPropertyValue(17, pb, pathBytes.size) as? NodePath
        check("setprop-decode(NodePath)", dnp != null && dnp.path == path)
    }

    // Inbound call-arg decode (Phase 3.3): decodeIosCallArg over the scalar/vector2i/string/object
    // tags — the Kotlin side of the generic method-call path (the C side ships these exact buffers
    // in kanama_ios_script_instance_call). Tags mirror KANAMA_IOS_PT_* (INT64=3, BOOL=1, FLOAT64=5,
    // VECTOR2I=7, OBJECT=13, STRING=16).
    memScoped {
        val li = alloc<LongVar>(); li.value = 1234567L
        check("callarg-decode(Long)", decodeIosCallArg(3, li.ptr.reinterpret()) == 1234567L)
        val bo = alloc<ByteVar>(); bo.value = 1
        check("callarg-decode(Bool)", decodeIosCallArg(1, bo.ptr.reinterpret()) == true)
        val db = alloc<DoubleVar>(); db.value = 2.5
        check("callarg-decode(Double)", decodeIosCallArg(5, db.ptr.reinterpret()) == 2.5)
        val v2i = allocArray<IntVar>(2); v2i[0] = 3; v2i[1] = 4
        check("callarg-decode(Vector2i)", decodeIosCallArg(7, v2i.reinterpret()) == Vector2i(3, 4))
        val ob = alloc<LongVar>(); ob.value = 99L
        check("callarg-decode(Object handle)", decodeIosCallArg(13, ob.ptr.reinterpret()) == 99L)
        val sb = "hello".encodeToByteArray()
        val sp = allocArray<ByteVar>(sb.size + 1)
        for (i in sb.indices) sp[i] = sb[i]
        sp[sb.size] = 0
        check("callarg-decode(String)", decodeIosCallArg(16, sp) == "hello")
    }

    println("[kanama][ios][kn] OBJECTCALLS SELFTEST: $pass passed, $fail failed")
}
