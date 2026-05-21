package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Base class for reference-counted objects.
 *
 * Most gameplay code should not call [close] on `RefCounted` wrappers. Values
 * returned by Godot APIs, assigned to scene nodes, scheduled as tweens, connected
 * to signals, or otherwise used after the current statement are usually owned by
 * Godot. Use Godot lifecycle APIs instead, and opt in to manual lifetime only for
 * values whose ownership contract is explicitly caller-owned.
 *
 * Generated from Godot docs: RefCounted
 */
open class RefCounted internal constructor(
    handle: MemorySegment,
) : GodotObject(handle), AutoCloseable {

    private var closed = false
    private var wrapperReferenceReleased = false

    /**
     * Returns the current reference count.
     *
     * Generated from Godot docs: RefCounted.get_reference_count
     */
    fun getReferenceCount(): Long {
        checkOpen()
        return ObjectCalls.ptrcallNoArgsRetInt(getReferenceCountBind, handle).toLong()
    }

    internal fun checkOpen() {
        check(!closed) { "RefCounted handle is closed" }
    }

    internal fun requireOpenHandle(): MemorySegment {
        checkOpen()
        return handle
    }

    /**
     * Releases this Kotlin wrapper's reference to the underlying Godot object.
     *
     * This is a low-level lifetime operation. Do not use it as general gameplay
     * cleanup for live Godot-owned values such as `Tween`, `Tweener`, `Material`,
     * `Mesh`, `PackedScene`, audio streams, or anything assigned to the scene tree
     * or scheduled to run later.
     */
    @ManualGodotLifetimeApi
    override fun close() {
        if (closed || wrapperReferenceReleased) return
        wrapperReferenceReleased = true
        val shouldDestroy = ObjectCalls.ptrcallNoArgsRetBool(unreferenceBind, handle)
        if (shouldDestroy) {
            closed = true
            ObjectCalls.destroyObject(handle)
        }
    }

    companion object {
        private const val NOARGS_LONG_HASH = 3905245786L
        private const val UNREFERENCE_HASH = 2240911060L

        private val getReferenceCountBind by lazy {
            ObjectCalls.getMethodBind("RefCounted", "get_reference_count", NOARGS_LONG_HASH)
        }

        private val unreferenceBind by lazy {
            ObjectCalls.getMethodBind("RefCounted", "unreference", UNREFERENCE_HASH)
        }

        internal fun releaseHandle(handle: MemorySegment) {
            if (handle.address() != 0L) {
                if (ObjectCalls.ptrcallNoArgsRetBool(unreferenceBind, handle)) {
                    ObjectCalls.destroyObject(handle)
                }
            }
        }
    }
}
