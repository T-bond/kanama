package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * One-shot timer.
 *
 * Generated from Godot docs: SceneTreeTimer
 */
class SceneTreeTimer internal constructor(handle: MemorySegment) : RefCounted(handle) {

    /**
     * The time remaining (in seconds).
     *
     * Generated from Godot docs: SceneTreeTimer.set_time_left
     */
    fun setTimeLeft(seconds: Double) {
        checkOpen()
        ObjectCalls.ptrcallWithDoubleArg(setTimeLeftBind, handle, seconds)
    }

    /**
     * The time remaining (in seconds).
     *
     * Generated from Godot docs: SceneTreeTimer.get_time_left
     */
    fun getTimeLeft(): Double {
        checkOpen()
        return ObjectCalls.ptrcallNoArgsRetDouble(getTimeLeftBind, handle)
    }

    object Signals {
        const val timeout: String = "timeout"
    }

    companion object {
        private const val DOUBLE_VOID_HASH = 373806689L
        private const val NOARGS_DOUBLE_HASH = 1740695150L

        private val setTimeLeftBind by lazy {
            ObjectCalls.getMethodBind("SceneTreeTimer", "set_time_left", DOUBLE_VOID_HASH)
        }

        private val getTimeLeftBind by lazy {
            ObjectCalls.getMethodBind("SceneTreeTimer", "get_time_left", NOARGS_DOUBLE_HASH)
        }

        internal fun wrap(handle: MemorySegment): SceneTreeTimer? =
            if (handle.address() == 0L) null else SceneTreeTimer(handle)
    }
}
