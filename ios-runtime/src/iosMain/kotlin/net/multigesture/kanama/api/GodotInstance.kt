package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: GodotInstance
 */
class GodotInstance(handle: MemorySegment) : GodotObject(handle) {
    fun start(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(startBind, handle)
    }

    fun isStarted(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isStartedBind, handle)
    }

    fun iteration(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(iterationBind, handle)
    }

    fun focusIn() {
        ObjectCalls.ptrcallNoArgs(focusInBind, handle)
    }

    fun focusOut() {
        ObjectCalls.ptrcallNoArgs(focusOutBind, handle)
    }

    fun pause() {
        ObjectCalls.ptrcallNoArgs(pauseBind, handle)
    }

    fun resume() {
        ObjectCalls.ptrcallNoArgs(resumeBind, handle)
    }

    companion object {
        fun fromHandle(handle: MemorySegment): GodotInstance? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): GodotInstance? =
            if (handle.address() == 0L) null else GodotInstance(handle)

        private const val START_HASH = 2240911060L
        private val startBind by lazy {
            ObjectCalls.getMethodBind("GodotInstance", "start", START_HASH)
        }

        private const val IS_STARTED_HASH = 2240911060L
        private val isStartedBind by lazy {
            ObjectCalls.getMethodBind("GodotInstance", "is_started", IS_STARTED_HASH)
        }

        private const val ITERATION_HASH = 2240911060L
        private val iterationBind by lazy {
            ObjectCalls.getMethodBind("GodotInstance", "iteration", ITERATION_HASH)
        }

        private const val FOCUS_IN_HASH = 3218959716L
        private val focusInBind by lazy {
            ObjectCalls.getMethodBind("GodotInstance", "focus_in", FOCUS_IN_HASH)
        }

        private const val FOCUS_OUT_HASH = 3218959716L
        private val focusOutBind by lazy {
            ObjectCalls.getMethodBind("GodotInstance", "focus_out", FOCUS_OUT_HASH)
        }

        private const val PAUSE_HASH = 3218959716L
        private val pauseBind by lazy {
            ObjectCalls.getMethodBind("GodotInstance", "pause", PAUSE_HASH)
        }

        private const val RESUME_HASH = 3218959716L
        private val resumeBind by lazy {
            ObjectCalls.getMethodBind("GodotInstance", "resume", RESUME_HASH)
        }
    }
}
