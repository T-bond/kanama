package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Generated from Godot docs: OpenXRFutureExtension
 */
class OpenXRFutureExtension(handle: MemorySegment) : OpenXRExtensionWrapper(handle) {
    fun isActive(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isActiveBind, handle)
    }

    fun registerFuture(future: Long, onSuccess: GodotCallable): OpenXRFutureResult? {
        return OpenXRFutureResult.wrap(ObjectCalls.ptrcallWithLongCallableArgsRetObject(registerFutureBind, handle, future, onSuccess.target.handle, onSuccess.method))
    }

    fun cancelFuture(future: Long) {
        ObjectCalls.ptrcallWithLongArg(cancelFutureBind, handle, future)
    }

    companion object {
        private const val IS_ACTIVE_HASH = 36873697L
        private val isActiveBind by lazy {
            ObjectCalls.getMethodBind("OpenXRFutureExtension", "is_active", IS_ACTIVE_HASH)
        }

        private const val REGISTER_FUTURE_HASH = 1038012256L
        private val registerFutureBind by lazy {
            ObjectCalls.getMethodBind("OpenXRFutureExtension", "register_future", REGISTER_FUTURE_HASH)
        }

        private const val CANCEL_FUTURE_HASH = 1286410249L
        private val cancelFutureBind by lazy {
            ObjectCalls.getMethodBind("OpenXRFutureExtension", "cancel_future", CANCEL_FUTURE_HASH)
        }
    }
}
