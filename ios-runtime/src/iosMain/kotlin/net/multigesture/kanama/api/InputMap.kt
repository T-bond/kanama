package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

// KANAMA-IOS-HANDWRITTEN: [glue] InputMap singleton (engine global), mirroring OS.kt. Action names are
// StringName args; action_add_event takes the event as an Object handle.
object InputMap {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("InputMap")
    }

    fun hasAction(action: String): Boolean =
        ObjectCalls.ptrcallWithStringNameArgRetBool(hasActionBind, singleton, action)

    fun addAction(action: String, deadzone: Double = 0.5) =
        ObjectCalls.ptrcallWithStringNameAndDoubleArg(addActionBind, singleton, action, deadzone)

    fun actionAddEvent(action: String, event: InputEvent) =
        ObjectCalls.ptrcallWithStringNameAndObjectArg(actionAddEventBind, singleton, action, event.handle)

    private val hasActionBind by lazy {
        ObjectCalls.getMethodBind("InputMap", "has_action", 2619796661L)
    }
    private val addActionBind by lazy {
        ObjectCalls.getMethodBind("InputMap", "add_action", 1195233573L)
    }
    private val actionAddEventBind by lazy {
        ObjectCalls.getMethodBind("InputMap", "action_add_event", 518302593L)
    }
}
