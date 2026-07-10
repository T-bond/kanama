package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: PhysicsServer3DManager
 */
object PhysicsServer3DManager {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("PhysicsServer3DManager")
    }

    fun registerServer(name: String, createCallback: GodotCallable) {
        ObjectCalls.ptrcallWithStringCallableArgs(registerServerBind, singleton, name, createCallback.target.handle, createCallback.method)
    }

    fun setDefaultServer(name: String, priority: Int) {
        ObjectCalls.ptrcallWithStringAndIntArg(setDefaultServerBind, singleton, name, priority)
    }

    fun fromHandle(handle: MemorySegment): PhysicsServer3DManager? =
        wrap(handle)

    internal fun wrap(handle: MemorySegment): PhysicsServer3DManager? =
        if (handle.address() == 0L) null else this

    private const val REGISTER_SERVER_HASH = 2137474292L
    private val registerServerBind by lazy {
        ObjectCalls.getMethodBind("PhysicsServer3DManager", "register_server", REGISTER_SERVER_HASH)
    }

    private const val SET_DEFAULT_SERVER_HASH = 2956805083L
    private val setDefaultServerBind by lazy {
        ObjectCalls.getMethodBind("PhysicsServer3DManager", "set_default_server", SET_DEFAULT_SERVER_HASH)
    }
}
