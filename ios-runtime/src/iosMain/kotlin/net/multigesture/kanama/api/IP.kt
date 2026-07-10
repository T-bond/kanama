package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: IP
 */
object IP {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("IP")
    }

    const val RESOLVER_MAX_QUERIES: Long = 256L
    const val RESOLVER_INVALID_ID: Long = -1L
    const val RESOLVER_STATUS_NONE: Long = 0L
    const val RESOLVER_STATUS_WAITING: Long = 1L
    const val RESOLVER_STATUS_DONE: Long = 2L
    const val RESOLVER_STATUS_ERROR: Long = 3L
    const val TYPE_NONE: Long = 0L
    const val TYPE_IPV4: Long = 1L
    const val TYPE_IPV6: Long = 2L
    const val TYPE_ANY: Long = 3L

    fun resolveHostnameQueueItem(host: String, ipType: Long = 3L): Int {
        return ObjectCalls.ptrcallWithStringAndLongArgRetInt(resolveHostnameQueueItemBind, singleton, host, ipType)
    }

    fun getResolveItemStatus(id: Int): Long {
        return ObjectCalls.ptrcallWithIntArgRetLong(getResolveItemStatusBind, singleton, id)
    }

    fun eraseResolveItem(id: Int) {
        ObjectCalls.ptrcallWithIntArg(eraseResolveItemBind, singleton, id)
    }

    fun getLocalAddresses(): List<String> {
        return ObjectCalls.ptrcallNoArgsRetPackedStringList(getLocalAddressesBind, singleton)
    }

    fun clearCache(hostname: String = "") {
        ObjectCalls.ptrcallWithStringArg(clearCacheBind, singleton, hostname)
    }

    fun fromHandle(handle: MemorySegment): IP? =
        wrap(handle)

    internal fun wrap(handle: MemorySegment): IP? =
        if (handle.address() == 0L) null else this

    private const val RESOLVE_HOSTNAME_QUEUE_ITEM_HASH = 1749894742L
    private val resolveHostnameQueueItemBind by lazy {
        ObjectCalls.getMethodBind("IP", "resolve_hostname_queue_item", RESOLVE_HOSTNAME_QUEUE_ITEM_HASH)
    }

    private const val GET_RESOLVE_ITEM_STATUS_HASH = 3812250196L
    private val getResolveItemStatusBind by lazy {
        ObjectCalls.getMethodBind("IP", "get_resolve_item_status", GET_RESOLVE_ITEM_STATUS_HASH)
    }

    private const val ERASE_RESOLVE_ITEM_HASH = 1286410249L
    private val eraseResolveItemBind by lazy {
        ObjectCalls.getMethodBind("IP", "erase_resolve_item", ERASE_RESOLVE_ITEM_HASH)
    }

    private const val GET_LOCAL_ADDRESSES_HASH = 1139954409L
    private val getLocalAddressesBind by lazy {
        ObjectCalls.getMethodBind("IP", "get_local_addresses", GET_LOCAL_ADDRESSES_HASH)
    }

    private const val CLEAR_CACHE_HASH = 3005725572L
    private val clearCacheBind by lazy {
        ObjectCalls.getMethodBind("IP", "clear_cache", CLEAR_CACHE_HASH)
    }
}
