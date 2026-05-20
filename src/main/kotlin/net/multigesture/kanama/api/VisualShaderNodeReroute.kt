package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: VisualShaderNodeReroute
 */
class VisualShaderNodeReroute(handle: MemorySegment) : VisualShaderNode(handle) {
    val portType: Long
        @JvmName("portTypeProperty")
        get() = getPortType()

    fun getPortType(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getPortTypeBind, handle)
    }

    companion object {
        private const val GET_PORT_TYPE_HASH = 1287173294L
        private val getPortTypeBind by lazy {
            ObjectCalls.getMethodBind("VisualShaderNodeReroute", "get_port_type", GET_PORT_TYPE_HASH)
        }
    }
}
