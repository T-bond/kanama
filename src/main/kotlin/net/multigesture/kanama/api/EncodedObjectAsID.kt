package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Holds a reference to an `Object`'s instance ID.
 *
 * Generated from Godot docs: EncodedObjectAsID
 */
class EncodedObjectAsID(handle: MemorySegment) : RefCounted(handle) {
    var objectId: Long
        @JvmName("objectIdProperty")
        get() = getObjectId()
        @JvmName("setObjectIdProperty")
        set(value) = setObjectId(value)

    /**
     * The `Object` identifier stored in this `EncodedObjectAsID` instance. The object instance can be
     * retrieved with `@GlobalScope.instance_from_id`.
     *
     * Generated from Godot docs: EncodedObjectAsID.set_object_id
     */
    fun setObjectId(id: Long) {
        ObjectCalls.ptrcallWithLongArg(setObjectIdBind, handle, id)
    }

    /**
     * The `Object` identifier stored in this `EncodedObjectAsID` instance. The object instance can be
     * retrieved with `@GlobalScope.instance_from_id`.
     *
     * Generated from Godot docs: EncodedObjectAsID.get_object_id
     */
    fun getObjectId(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getObjectIdBind, handle)
    }

    companion object {
        private const val SET_OBJECT_ID_HASH = 1286410249L
        private val setObjectIdBind by lazy {
            ObjectCalls.getMethodBind("EncodedObjectAsID", "set_object_id", SET_OBJECT_ID_HASH)
        }

        private const val GET_OBJECT_ID_HASH = 3905245786L
        private val getObjectIdBind by lazy {
            ObjectCalls.getMethodBind("EncodedObjectAsID", "get_object_id", GET_OBJECT_ID_HASH)
        }
    }
}
