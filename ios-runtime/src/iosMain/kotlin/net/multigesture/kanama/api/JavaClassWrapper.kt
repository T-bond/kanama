package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: JavaClassWrapper
 */
object JavaClassWrapper {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("JavaClassWrapper")
    }

    fun wrap(name: String): JavaClass? {
        return JavaClass.wrap(ObjectCalls.ptrcallWithStringArgRetObject(wrapBind, singleton, name))
    }

    fun getException(): JavaObject? {
        return JavaObject.wrap(ObjectCalls.ptrcallNoArgsRetObject(getExceptionBind, singleton))
    }

    fun createSamCallback(samInterface: String, callable: GodotCallable): JavaObject? {
        return JavaObject.wrap(ObjectCalls.ptrcallWithStringCallableArgsRetObject(createSamCallbackBind, singleton, samInterface, callable.target.handle, callable.method))
    }

    fun fromHandle(handle: MemorySegment): JavaClassWrapper? =
        wrap(handle)

    internal fun wrap(handle: MemorySegment): JavaClassWrapper? =
        if (handle.address() == 0L) null else this

    private const val WRAP_HASH = 1124367868L
    private val wrapBind by lazy {
        ObjectCalls.getMethodBind("JavaClassWrapper", "wrap", WRAP_HASH)
    }

    private const val GET_EXCEPTION_HASH = 3277089691L
    private val getExceptionBind by lazy {
        ObjectCalls.getMethodBind("JavaClassWrapper", "get_exception", GET_EXCEPTION_HASH)
    }

    private const val CREATE_SAM_CALLBACK_HASH = 2479014754L
    private val createSamCallbackBind by lazy {
        ObjectCalls.getMethodBind("JavaClassWrapper", "create_sam_callback", CREATE_SAM_CALLBACK_HASH)
    }
}
