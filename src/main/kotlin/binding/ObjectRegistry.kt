package net.multigesture.kanama.binding

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong

/**
 * Maps GDExtension class-instance pointers to real Kotlin objects.
 *
 * When we register a class with Godot, every engine-owned object
 * carries an opaque `void*` instance token that we chose. Godot hands
 * that token back on every callback (method call, virtual dispatch,
 * set/get, notification, free). The registry is how we get from that
 * token to the actual Kotlin instance.
 *
 * We deliberately do *not* use [System.identityHashCode] or the Kotlin
 * object's JVM address — both can collide and neither survives GC
 * moves. Instead every registered object gets a fresh monotonic
 * [Long] handle from [nextHandle]. The handle is also the `void*` we
 * hand to `object_set_instance`.
 *
 * Starting at 1 (not 0) so the handle is never confused with NULL.
 */
object ObjectRegistry {

    private val nextHandle = AtomicLong(1)
    private val byHandle = ConcurrentHashMap<Long, Any>()

    fun register(instance: Any): Long {
        val handle = nextHandle.getAndIncrement()
        byHandle[handle] = instance
        return handle
    }

    fun get(handle: Long): Any? = byHandle[handle]

    fun unregister(handle: Long): Any? = byHandle.remove(handle)

    fun size(): Int = byHandle.size
}
