package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*
import net.multigesture.kanama.types.Vector2

/**
 * Generated from Godot docs: StaticBody2D
 */
open class StaticBody2D(handle: MemorySegment) : PhysicsBody2D(handle) {
    var constantLinearVelocity: Vector2
        @JvmName("constantLinearVelocityProperty")
        get() = getConstantLinearVelocity()
        @JvmName("setConstantLinearVelocityProperty")
        set(value) = setConstantLinearVelocity(value)

    var constantAngularVelocity: Double
        @JvmName("constantAngularVelocityProperty")
        get() = getConstantAngularVelocity()
        @JvmName("setConstantAngularVelocityProperty")
        set(value) = setConstantAngularVelocity(value)

    fun setConstantLinearVelocity(vel: Vector2) {
        ObjectCalls.ptrcallWithVector2Arg(setConstantLinearVelocityBind, handle, vel)
    }

    fun setConstantAngularVelocity(vel: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setConstantAngularVelocityBind, handle, vel)
    }

    fun getConstantLinearVelocity(): Vector2 {
        return ObjectCalls.ptrcallNoArgsRetVector2(getConstantLinearVelocityBind, handle)
    }

    fun getConstantAngularVelocity(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getConstantAngularVelocityBind, handle)
    }

    companion object {
        fun fromHandle(handle: MemorySegment): StaticBody2D? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): StaticBody2D? =
            if (handle.address() == 0L) null else StaticBody2D(handle)

        private const val SET_CONSTANT_LINEAR_VELOCITY_HASH = 743155724L
        private val setConstantLinearVelocityBind by lazy {
            ObjectCalls.getMethodBind("StaticBody2D", "set_constant_linear_velocity", SET_CONSTANT_LINEAR_VELOCITY_HASH)
        }

        private const val SET_CONSTANT_ANGULAR_VELOCITY_HASH = 373806689L
        private val setConstantAngularVelocityBind by lazy {
            ObjectCalls.getMethodBind("StaticBody2D", "set_constant_angular_velocity", SET_CONSTANT_ANGULAR_VELOCITY_HASH)
        }

        private const val GET_CONSTANT_LINEAR_VELOCITY_HASH = 3341600327L
        private val getConstantLinearVelocityBind by lazy {
            ObjectCalls.getMethodBind("StaticBody2D", "get_constant_linear_velocity", GET_CONSTANT_LINEAR_VELOCITY_HASH)
        }

        private const val GET_CONSTANT_ANGULAR_VELOCITY_HASH = 1740695150L
        private val getConstantAngularVelocityBind by lazy {
            ObjectCalls.getMethodBind("StaticBody2D", "get_constant_angular_velocity", GET_CONSTANT_ANGULAR_VELOCITY_HASH)
        }
    }
}
