package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.Vector2
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Abstract base class for touch gestures.
 *
 * Generated from Godot docs: InputEventGesture
 */
open class InputEventGesture(handle: MemorySegment) : InputEventWithModifiers(handle) {
    var position: Vector2
        @JvmName("positionProperty")
        get() = getPosition()
        @JvmName("setPositionProperty")
        set(value) = setPosition(value)

    /**
     * The local gesture position relative to the `Viewport`. If used in `Control._gui_input`, the
     * position is relative to the current `Control` that received this gesture.
     *
     * Generated from Godot docs: InputEventGesture.set_position
     */
    fun setPosition(position: Vector2) {
        ObjectCalls.ptrcallWithVector2Arg(setPositionBind, handle, position)
    }

    /**
     * The local gesture position relative to the `Viewport`. If used in `Control._gui_input`, the
     * position is relative to the current `Control` that received this gesture.
     *
     * Generated from Godot docs: InputEventGesture.get_position
     */
    fun getPosition(): Vector2 {
        return ObjectCalls.ptrcallNoArgsRetVector2(getPositionBind, handle)
    }

    companion object {
        private const val SET_POSITION_HASH = 743155724L
        private val setPositionBind by lazy {
            ObjectCalls.getMethodBind("InputEventGesture", "set_position", SET_POSITION_HASH)
        }

        private const val GET_POSITION_HASH = 3341600327L
        private val getPositionBind by lazy {
            ObjectCalls.getMethodBind("InputEventGesture", "get_position", GET_POSITION_HASH)
        }
    }
}
