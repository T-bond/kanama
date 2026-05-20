package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Generated from Godot docs: GDScript
 */
class GDScript(handle: MemorySegment) : Script(handle) {
    fun new(vararg extraArgs: Any?): Any? {
        return ObjectCalls.callWithVariantArgs(newBind, handle, listOf(*extraArgs))
    }

    companion object {
        private const val NEW_HASH = 1545262638L
        private val newBind by lazy {
            ObjectCalls.getMethodBind("GDScript", "new", NEW_HASH)
        }
    }
}
