package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * A countdown timer.
 *
 * Generated from Godot docs: Timer
 */
class Timer(handle: MemorySegment) : Node(handle) {

    /**
     * The time required for the timer to end, in seconds. This property can also be set every time
     * `start` is called. Note: Timers can only process once per physics or process frame (depending on
     * the `process_callback`). An unstable framerate may cause the timer to end inconsistently, which
     * is especially noticeable if the wait time is lower than roughly `0.05` seconds. For very short
     * timers, it is recommended to write your own code instead of using a `Timer` node. Timers are
     * also affected by `Engine.time_scale`.
     *
     * Generated from Godot docs: Timer.set_wait_time
     */
    fun setWaitTime(seconds: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setWaitTimeBind, handle, seconds)
    }

    /**
     * The time required for the timer to end, in seconds. This property can also be set every time
     * `start` is called. Note: Timers can only process once per physics or process frame (depending on
     * the `process_callback`). An unstable framerate may cause the timer to end inconsistently, which
     * is especially noticeable if the wait time is lower than roughly `0.05` seconds. For very short
     * timers, it is recommended to write your own code instead of using a `Timer` node. Timers are
     * also affected by `Engine.time_scale`.
     *
     * Generated from Godot docs: Timer.get_wait_time
     */
    fun getWaitTime(): Double =
        ObjectCalls.ptrcallNoArgsRetDouble(getWaitTimeBind, handle)

    /**
     * If `true`, the timer will stop after reaching the end. Otherwise, as by default, the timer will
     * automatically restart.
     *
     * Generated from Godot docs: Timer.set_one_shot
     */
    fun setOneShot(enable: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setOneShotBind, handle, enable)
    }

    /**
     * If `true`, the timer will stop after reaching the end. Otherwise, as by default, the timer will
     * automatically restart.
     *
     * Generated from Godot docs: Timer.is_one_shot
     */
    fun isOneShot(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isOneShotBind, handle)

    /**
     * If `true`, the timer will start immediately when it enters the scene tree. Note: After the timer
     * enters the tree, this property is automatically set to `false`. Note: This property does nothing
     * when the timer is running in the editor.
     *
     * Generated from Godot docs: Timer.set_autostart
     */
    fun setAutostart(enable: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setAutostartBind, handle, enable)
    }

    /**
     * If `true`, the timer will start immediately when it enters the scene tree. Note: After the timer
     * enters the tree, this property is automatically set to `false`. Note: This property does nothing
     * when the timer is running in the editor.
     *
     * Generated from Godot docs: Timer.has_autostart
     */
    fun hasAutostart(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(hasAutostartBind, handle)

    /**
     * Starts the timer, or resets the timer if it was started already. Fails if the timer is not
     * inside the scene tree. If `time_sec` is greater than `0`, this value is used for the
     * `wait_time`. Note: This method does not resume a paused timer. See `paused`.
     *
     * Generated from Godot docs: Timer.start
     */
    fun start(seconds: Double = -1.0) {
        ObjectCalls.ptrcallWithDoubleArg(startBind, handle, seconds)
    }

    /**
     * Stops the timer. See also `paused`. Unlike `start`, this can safely be called if the timer is
     * not inside the scene tree. Note: Calling `stop` does not emit the `timeout` signal, as the timer
     * is not considered to have timed out. If this is desired, use `$Timer.timeout.emit()` after
     * calling `stop` to manually emit the signal.
     *
     * Generated from Godot docs: Timer.stop
     */
    fun stop() {
        ObjectCalls.ptrcallNoArgs(stopBind, handle)
    }

    /**
     * If `true`, the timer is paused. A paused timer does not process until this property is set back
     * to `false`, even when `start` is called. See also `stop`.
     *
     * Generated from Godot docs: Timer.set_paused
     */
    fun setPaused(paused: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setPausedBind, handle, paused)
    }

    /**
     * If `true`, the timer is paused. A paused timer does not process until this property is set back
     * to `false`, even when `start` is called. See also `stop`.
     *
     * Generated from Godot docs: Timer.is_paused
     */
    fun isPaused(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isPausedBind, handle)

    /**
     * If `true`, the timer will ignore `Engine.time_scale` and update with the real, elapsed time.
     *
     * Generated from Godot docs: Timer.set_ignore_time_scale
     */
    fun setIgnoreTimeScale(ignore: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setIgnoreTimeScaleBind, handle, ignore)
    }

    /**
     * If `true`, the timer will ignore `Engine.time_scale` and update with the real, elapsed time.
     *
     * Generated from Godot docs: Timer.is_ignoring_time_scale
     */
    fun isIgnoringTimeScale(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isIgnoringTimeScaleBind, handle)

    /**
     * Returns `true` if the timer is stopped or has not started.
     *
     * Generated from Godot docs: Timer.is_stopped
     */
    fun isStopped(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isStoppedBind, handle)

    /**
     * The timer's remaining time in seconds. This is always `0` if the timer is stopped. Note: This
     * property is read-only and cannot be modified. It is based on `wait_time`.
     *
     * Generated from Godot docs: Timer.get_time_left
     */
    fun getTimeLeft(): Double =
        ObjectCalls.ptrcallNoArgsRetDouble(getTimeLeftBind, handle)

    /**
     * Specifies when the timer is updated during the main loop.
     *
     * Generated from Godot docs: Timer.set_timer_process_callback
     */
    fun setTimerProcessCallback(callback: Long) {
        ObjectCalls.ptrcallWithLongArg(setTimerProcessCallbackBind, handle, callback)
    }

    /**
     * Specifies when the timer is updated during the main loop.
     *
     * Generated from Godot docs: Timer.get_timer_process_callback
     */
    fun getTimerProcessCallback(): Long =
        ObjectCalls.ptrcallNoArgsRetLong(getTimerProcessCallbackBind, handle)

    object Signals {
        const val timeout: String = "timeout"
    }

    companion object {
        const val TIMER_PROCESS_PHYSICS = 0L
        const val TIMER_PROCESS_IDLE = 1L

        private const val DOUBLE_VOID_HASH = 373806689L
        private const val NOARGS_DOUBLE_HASH = 1740695150L
        private const val BOOL_VOID_HASH = 2586408642L
        private const val NOARGS_BOOL_HASH = 36873697L
        private const val NOARGS_VOID_HASH = 3218959716L
        private const val START_HASH = 1392008558L
        private const val IGNORE_TIME_SCALE_RET_BOOL_HASH = 2240911060L
        private const val SET_PROCESS_CALLBACK_HASH = 3469495063L
        private const val GET_PROCESS_CALLBACK_HASH = 2672570227L

        private val setWaitTimeBind by lazy {
            ObjectCalls.getMethodBind("Timer", "set_wait_time", DOUBLE_VOID_HASH)
        }

        private val getWaitTimeBind by lazy {
            ObjectCalls.getMethodBind("Timer", "get_wait_time", NOARGS_DOUBLE_HASH)
        }

        private val setOneShotBind by lazy {
            ObjectCalls.getMethodBind("Timer", "set_one_shot", BOOL_VOID_HASH)
        }

        private val isOneShotBind by lazy {
            ObjectCalls.getMethodBind("Timer", "is_one_shot", NOARGS_BOOL_HASH)
        }

        private val setAutostartBind by lazy {
            ObjectCalls.getMethodBind("Timer", "set_autostart", BOOL_VOID_HASH)
        }

        private val hasAutostartBind by lazy {
            ObjectCalls.getMethodBind("Timer", "has_autostart", NOARGS_BOOL_HASH)
        }

        private val startBind by lazy {
            ObjectCalls.getMethodBind("Timer", "start", START_HASH)
        }

        private val stopBind by lazy {
            ObjectCalls.getMethodBind("Timer", "stop", NOARGS_VOID_HASH)
        }

        private val setPausedBind by lazy {
            ObjectCalls.getMethodBind("Timer", "set_paused", BOOL_VOID_HASH)
        }

        private val isPausedBind by lazy {
            ObjectCalls.getMethodBind("Timer", "is_paused", NOARGS_BOOL_HASH)
        }

        private val setIgnoreTimeScaleBind by lazy {
            ObjectCalls.getMethodBind("Timer", "set_ignore_time_scale", BOOL_VOID_HASH)
        }

        private val isIgnoringTimeScaleBind by lazy {
            ObjectCalls.getMethodBind("Timer", "is_ignoring_time_scale", IGNORE_TIME_SCALE_RET_BOOL_HASH)
        }

        private val isStoppedBind by lazy {
            ObjectCalls.getMethodBind("Timer", "is_stopped", NOARGS_BOOL_HASH)
        }

        private val getTimeLeftBind by lazy {
            ObjectCalls.getMethodBind("Timer", "get_time_left", NOARGS_DOUBLE_HASH)
        }

        private val setTimerProcessCallbackBind by lazy {
            ObjectCalls.getMethodBind("Timer", "set_timer_process_callback", SET_PROCESS_CALLBACK_HASH)
        }

        private val getTimerProcessCallbackBind by lazy {
            ObjectCalls.getMethodBind("Timer", "get_timer_process_callback", GET_PROCESS_CALLBACK_HASH)
        }
    }
}
