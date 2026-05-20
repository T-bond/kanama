package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Exposes performance-related data.
 *
 * Generated from Godot docs: Performance
 */
object Performance {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("Performance")
    }

    /**
     * Returns the value of one of the available built-in monitors. You should provide one of the
     * `Monitor` constants as the argument, like this:
     *
     * Generated from Godot docs: Performance.get_monitor
     */
    @JvmStatic
    fun getMonitor(monitor: Long): Double {
        return ObjectCalls.ptrcallWithLongArgRetDouble(getMonitorBind, singleton, monitor)
    }

    /**
     * Adds a custom monitor with the name `id`. You can specify the category of the monitor using
     * slash delimiters in `id` (for example: `"Game/NumberOfNPCs"`). If there is more than one slash
     * delimiter, then the default category is used. The default category is `"Custom"`. Prints an
     * error if given `id` is already present.
     *
     * Generated from Godot docs: Performance.add_custom_monitor
     */
    @JvmStatic
    fun addCustomMonitor(id: String, callable: GodotCallable, arguments: List<Any?> = emptyList(), type: Long = 0L) {
        ObjectCalls.ptrcallWithStringNameCallableArrayLongArgs(addCustomMonitorBind, singleton, id, callable.target.handle, callable.method, arguments, type)
    }

    /**
     * Removes the custom monitor with given `id`. Prints an error if the given `id` is already absent.
     *
     * Generated from Godot docs: Performance.remove_custom_monitor
     */
    @JvmStatic
    fun removeCustomMonitor(id: String) {
        ObjectCalls.ptrcallWithStringNameArg(removeCustomMonitorBind, singleton, id)
    }

    /**
     * Returns `true` if custom monitor with the given `id` is present, `false` otherwise.
     *
     * Generated from Godot docs: Performance.has_custom_monitor
     */
    @JvmStatic
    fun hasCustomMonitor(id: String): Boolean {
        return ObjectCalls.ptrcallWithStringNameArgRetBool(hasCustomMonitorBind, singleton, id)
    }

    /**
     * Returns the value of custom monitor with given `id`. The callable is called to get the value of
     * custom monitor. See also `has_custom_monitor`. Prints an error if the given `id` is absent.
     *
     * Generated from Godot docs: Performance.get_custom_monitor
     */
    @JvmStatic
    fun getCustomMonitor(id: String): Any? {
        return ObjectCalls.ptrcallWithStringNameArgRetVariantScalar(getCustomMonitorBind, singleton, id)
    }

    /**
     * Returns the last tick in which custom monitor was added/removed (in microseconds since the
     * engine started). This is set to `Time.get_ticks_usec` when the monitor is updated.
     *
     * Generated from Godot docs: Performance.get_monitor_modification_time
     */
    @JvmStatic
    fun getMonitorModificationTime(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getMonitorModificationTimeBind, singleton)
    }

    /**
     * Returns the names of active custom monitors in an `Array`.
     *
     * Generated from Godot docs: Performance.get_custom_monitor_names
     */
    @JvmStatic
    fun getCustomMonitorNames(): List<String> {
        return ObjectCalls.ptrcallNoArgsRetStringNameList(getCustomMonitorNamesBind, singleton)
    }

    /**
     * Returns the `MonitorType` values of active custom monitors in an `Array`.
     *
     * Generated from Godot docs: Performance.get_custom_monitor_types
     */
    @JvmStatic
    fun getCustomMonitorTypes(): List<Int> {
        return ObjectCalls.ptrcallNoArgsRetPackedInt32List(getCustomMonitorTypesBind, singleton)
    }

    private const val GET_MONITOR_HASH = 1943275655L
    private val getMonitorBind by lazy {
        ObjectCalls.getMethodBind("Performance", "get_monitor", GET_MONITOR_HASH)
    }

    private const val ADD_CUSTOM_MONITOR_HASH = 3655788610L
    private val addCustomMonitorBind by lazy {
        ObjectCalls.getMethodBind("Performance", "add_custom_monitor", ADD_CUSTOM_MONITOR_HASH)
    }

    private const val REMOVE_CUSTOM_MONITOR_HASH = 3304788590L
    private val removeCustomMonitorBind by lazy {
        ObjectCalls.getMethodBind("Performance", "remove_custom_monitor", REMOVE_CUSTOM_MONITOR_HASH)
    }

    private const val HAS_CUSTOM_MONITOR_HASH = 2041966384L
    private val hasCustomMonitorBind by lazy {
        ObjectCalls.getMethodBind("Performance", "has_custom_monitor", HAS_CUSTOM_MONITOR_HASH)
    }

    private const val GET_CUSTOM_MONITOR_HASH = 2138907829L
    private val getCustomMonitorBind by lazy {
        ObjectCalls.getMethodBind("Performance", "get_custom_monitor", GET_CUSTOM_MONITOR_HASH)
    }

    private const val GET_MONITOR_MODIFICATION_TIME_HASH = 2455072627L
    private val getMonitorModificationTimeBind by lazy {
        ObjectCalls.getMethodBind("Performance", "get_monitor_modification_time", GET_MONITOR_MODIFICATION_TIME_HASH)
    }

    private const val GET_CUSTOM_MONITOR_NAMES_HASH = 2915620761L
    private val getCustomMonitorNamesBind by lazy {
        ObjectCalls.getMethodBind("Performance", "get_custom_monitor_names", GET_CUSTOM_MONITOR_NAMES_HASH)
    }

    private const val GET_CUSTOM_MONITOR_TYPES_HASH = 969006518L
    private val getCustomMonitorTypesBind by lazy {
        ObjectCalls.getMethodBind("Performance", "get_custom_monitor_types", GET_CUSTOM_MONITOR_TYPES_HASH)
    }
}
