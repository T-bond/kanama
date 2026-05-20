package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: VisualShaderNodeBillboard
 */
class VisualShaderNodeBillboard(handle: MemorySegment) : VisualShaderNode(handle) {
    var billboardType: Long
        @JvmName("billboardTypeProperty")
        get() = getBillboardType()
        @JvmName("setBillboardTypeProperty")
        set(value) = setBillboardType(value)

    var keepScale: Boolean
        @JvmName("keepScaleProperty")
        get() = isKeepScaleEnabled()
        @JvmName("setKeepScaleProperty")
        set(value) = setKeepScaleEnabled(value)

    fun setBillboardType(billboardType: Long) {
        ObjectCalls.ptrcallWithLongArg(setBillboardTypeBind, handle, billboardType)
    }

    fun getBillboardType(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getBillboardTypeBind, handle)
    }

    fun setKeepScaleEnabled(enabled: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setKeepScaleEnabledBind, handle, enabled)
    }

    fun isKeepScaleEnabled(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isKeepScaleEnabledBind, handle)
    }

    companion object {
        private const val SET_BILLBOARD_TYPE_HASH = 1227463289L
        private val setBillboardTypeBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeBillboard", "set_billboard_type", SET_BILLBOARD_TYPE_HASH)
        }

        private const val GET_BILLBOARD_TYPE_HASH = 3724188517L
        private val getBillboardTypeBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeBillboard", "get_billboard_type", GET_BILLBOARD_TYPE_HASH)
        }

        private const val SET_KEEP_SCALE_ENABLED_HASH = 2586408642L
        private val setKeepScaleEnabledBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeBillboard", "set_keep_scale_enabled", SET_KEEP_SCALE_ENABLED_HASH)
        }

        private const val IS_KEEP_SCALE_ENABLED_HASH = 36873697L
        private val isKeepScaleEnabledBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeBillboard", "is_keep_scale_enabled", IS_KEEP_SCALE_ENABLED_HASH)
        }
    }
}
