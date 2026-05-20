package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Exposes the internal debugger.
 *
 * Generated from Godot docs: EngineDebugger
 */
object EngineDebugger {

    private const val BOOL_NOARGS_HASH = 36873697L
    private const val STRINGNAME_BOOL_HASH = 2041966384L
    private const val STRINGNAME_OBJECT_HASH = 3651669560L
    private const val STRINGNAME_ARRAY_HASH = 1895267858L
    private const val STRINGNAME_BOOL_ARRAY_HASH = 3192561009L
    private const val STRINGNAME_CALLABLE_HASH = 1874754934L
    private const val STRING_ARRAY_HASH = 1209351045L
    private const val SET_INT_HASH = 1286410249L
    private const val GET_INT_HASH = 3905245786L
    private const val LINE_BREAKPOINT_HASH = 3780747571L
    private const val IS_BREAKPOINT_HASH = 921227809L
    private const val STRINGNAME_VOID_HASH = 3304788590L
    private const val VOID_NOARGS_HASH = 3218959716L

    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("EngineDebugger")
    }

    private val isActiveBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "is_active", 2240911060L)
    }

    private val hasProfilerBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "has_profiler", STRINGNAME_BOOL_HASH)
    }

    private val isProfilingBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "is_profiling", STRINGNAME_BOOL_HASH)
    }

    private val hasCaptureBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "has_capture", STRINGNAME_BOOL_HASH)
    }

    private val setLinesLeftBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "set_lines_left", SET_INT_HASH)
    }

    private val getLinesLeftBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "get_lines_left", GET_INT_HASH)
    }

    private val setDepthBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "set_depth", SET_INT_HASH)
    }

    private val getDepthBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "get_depth", GET_INT_HASH)
    }

    private val isBreakpointBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "is_breakpoint", IS_BREAKPOINT_HASH)
    }

    private val insertBreakpointBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "insert_breakpoint", LINE_BREAKPOINT_HASH)
    }

    private val removeBreakpointBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "remove_breakpoint", LINE_BREAKPOINT_HASH)
    }

    private val unregisterProfilerBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "unregister_profiler", STRINGNAME_VOID_HASH)
    }

    private val registerProfilerBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "register_profiler", STRINGNAME_OBJECT_HASH)
    }

    private val profilerAddFrameDataBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "profiler_add_frame_data", STRINGNAME_ARRAY_HASH)
    }

    private val profilerEnableBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "profiler_enable", STRINGNAME_BOOL_ARRAY_HASH)
    }

    private val registerMessageCaptureBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "register_message_capture", STRINGNAME_CALLABLE_HASH)
    }

    private val unregisterMessageCaptureBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "unregister_message_capture", STRINGNAME_VOID_HASH)
    }

    private val linePollBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "line_poll", VOID_NOARGS_HASH)
    }

    private val sendMessageBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "send_message", STRING_ARRAY_HASH)
    }

    private val clearBreakpointsBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "clear_breakpoints", VOID_NOARGS_HASH)
    }

    private val isSkippingBreakpointsBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "is_skipping_breakpoints", BOOL_NOARGS_HASH)
    }

    private val debugBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "debug", 2751962654L)
    }

    private val scriptDebugBind by lazy {
        ObjectCalls.getMethodBind("EngineDebugger", "script_debug", 2442343672L)
    }

    /**
     * Returns `true` if the debugger is active otherwise `false`.
     *
     * Generated from Godot docs: EngineDebugger.is_active
     */
    @JvmStatic
    fun isActive(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isActiveBind, singleton)

    /**
     * Returns `true` if a profiler with the given name is present otherwise `false`.
     *
     * Generated from Godot docs: EngineDebugger.has_profiler
     */
    @JvmStatic
    fun hasProfiler(name: String): Boolean =
        ObjectCalls.ptrcallWithStringNameArgRetBool(hasProfilerBind, singleton, name)

    /**
     * Returns `true` if a profiler with the given name is present and active otherwise `false`.
     *
     * Generated from Godot docs: EngineDebugger.is_profiling
     */
    @JvmStatic
    fun isProfiling(name: String): Boolean =
        ObjectCalls.ptrcallWithStringNameArgRetBool(isProfilingBind, singleton, name)

    /**
     * Returns `true` if a capture with the given name is present otherwise `false`.
     *
     * Generated from Godot docs: EngineDebugger.has_capture
     */
    @JvmStatic
    fun hasCapture(name: String): Boolean =
        ObjectCalls.ptrcallWithStringNameArgRetBool(hasCaptureBind, singleton, name)

    /**
     * Sets the current debugging lines that remain.
     *
     * Generated from Godot docs: EngineDebugger.set_lines_left
     */
    @JvmStatic
    fun setLinesLeft(value: Long) {
        ObjectCalls.ptrcallWithIntArg(setLinesLeftBind, singleton, value.toInt())
    }

    /**
     * Returns the number of lines that remain.
     *
     * Generated from Godot docs: EngineDebugger.get_lines_left
     */
    @JvmStatic
    fun getLinesLeft(): Long =
        ObjectCalls.ptrcallNoArgsRetInt(getLinesLeftBind, singleton).toLong()

    /**
     * Sets the current debugging depth.
     *
     * Generated from Godot docs: EngineDebugger.set_depth
     */
    @JvmStatic
    fun setDepth(value: Long) {
        ObjectCalls.ptrcallWithIntArg(setDepthBind, singleton, value.toInt())
    }

    /**
     * Returns the current debug depth.
     *
     * Generated from Godot docs: EngineDebugger.get_depth
     */
    @JvmStatic
    fun getDepth(): Long =
        ObjectCalls.ptrcallNoArgsRetInt(getDepthBind, singleton).toLong()

    /**
     * Returns `true` if the given `source` and `line` represent an existing breakpoint.
     *
     * Generated from Godot docs: EngineDebugger.is_breakpoint
     */
    @JvmStatic
    fun isBreakpoint(line: Long, source: String): Boolean =
        ObjectCalls.ptrcallWithIntAndStringNameArgRetBool(isBreakpointBind, singleton, line.toInt(), source)

    /**
     * Inserts a new breakpoint with the given `source` and `line`.
     *
     * Generated from Godot docs: EngineDebugger.insert_breakpoint
     */
    @JvmStatic
    fun insertBreakpoint(line: Long, source: String) {
        ObjectCalls.ptrcallWithIntAndStringNameArg(insertBreakpointBind, singleton, line.toInt(), source)
    }

    /**
     * Removes a breakpoint with the given `source` and `line`.
     *
     * Generated from Godot docs: EngineDebugger.remove_breakpoint
     */
    @JvmStatic
    fun removeBreakpoint(line: Long, source: String) {
        ObjectCalls.ptrcallWithIntAndStringNameArg(removeBreakpointBind, singleton, line.toInt(), source)
    }

    /**
     * Unregisters a profiler with given `name`.
     *
     * Generated from Godot docs: EngineDebugger.unregister_profiler
     */
    @JvmStatic
    fun unregisterProfiler(name: String) {
        ObjectCalls.ptrcallWithStringNameArg(unregisterProfilerBind, singleton, name)
    }

    /**
     * Registers a profiler with the given `name`. See `EngineProfiler` for more information.
     *
     * Generated from Godot docs: EngineDebugger.register_profiler
     */
    @JvmStatic
    fun registerProfiler(name: String, profilerObject: MemorySegment) {
        ObjectCalls.ptrcallWithStringNameAndObjectArg(registerProfilerBind, singleton, name, profilerObject)
    }

    /**
     * Calls the `add` callable of the profiler with given `name` and `data`.
     *
     * Generated from Godot docs: EngineDebugger.profiler_add_frame_data
     */
    @JvmStatic
    fun profilerAddFrameData(name: String, data: List<Map<String, Any>> = emptyList()) {
        ObjectCalls.ptrcallWithStringNameAndArrayOfDictionariesArg(profilerAddFrameDataBind, singleton, name, data)
    }

    /**
     * Calls the `toggle` callable of the profiler with given `name` and `arguments`. Enables/Disables
     * the same profiler depending on `enable` argument.
     *
     * Generated from Godot docs: EngineDebugger.profiler_enable
     */
    @JvmStatic
    fun profilerEnable(name: String, enable: Boolean, arguments: List<Map<String, Any>> = emptyList()) {
        ObjectCalls.ptrcallWithStringNameBoolAndArrayOfDictionariesArgs(
            profilerEnableBind,
            singleton,
            name,
            enable,
            arguments,
        )
    }

    /**
     * Registers a message capture with given `name`. If `name` is "my_message" then messages starting
     * with "my_message:" will be called with the given callable. The callable must accept a message
     * string and a data array as argument. The callable should return `true` if the message is
     * recognized. Note: The callable will receive the message with the prefix stripped, unlike
     * `EditorDebuggerPlugin._capture`. See the `EditorDebuggerPlugin` description for an example.
     *
     * Generated from Godot docs: EngineDebugger.register_message_capture
     */
    @JvmStatic
    fun registerMessageCapture(name: String, callableObject: MemorySegment, callableMethod: String) {
        ObjectCalls.ptrcallWithStringNameAndCallableArg(
            registerMessageCaptureBind,
            singleton,
            name,
            callableObject,
            callableMethod,
        )
    }

    /**
     * Unregisters the message capture with given `name`.
     *
     * Generated from Godot docs: EngineDebugger.unregister_message_capture
     */
    @JvmStatic
    fun unregisterMessageCapture(name: String) {
        ObjectCalls.ptrcallWithStringNameArg(unregisterMessageCaptureBind, singleton, name)
    }

    /**
     * Forces a processing loop of debugger events. The purpose of this method is just processing
     * events every now and then when the script might get too busy, so that bugs like infinite loops
     * can be caught.
     *
     * Generated from Godot docs: EngineDebugger.line_poll
     */
    @JvmStatic
    fun linePoll() {
        ObjectCalls.ptrcallNoArgs(linePollBind, singleton)
    }

    /**
     * Sends a message with given `message` and `data` array.
     *
     * Generated from Godot docs: EngineDebugger.send_message
     */
    @JvmStatic
    fun sendMessage(message: String, data: List<Map<String, Any>> = emptyList()) {
        ObjectCalls.ptrcallWithStringAndArrayOfDictionariesArg(sendMessageBind, singleton, message, data)
    }

    /**
     * Clears all breakpoints.
     *
     * Generated from Godot docs: EngineDebugger.clear_breakpoints
     */
    @JvmStatic
    fun clearBreakpoints() {
        ObjectCalls.ptrcallNoArgs(clearBreakpointsBind, singleton)
    }

    /**
     * Returns `true` if the debugger is skipping breakpoints otherwise `false`.
     *
     * Generated from Godot docs: EngineDebugger.is_skipping_breakpoints
     */
    @JvmStatic
    fun isSkippingBreakpoints(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isSkippingBreakpointsBind, singleton)

    /**
     * Starts a debug break in script execution, optionally specifying whether the program can continue
     * based on `can_continue` and whether the break was due to a breakpoint.
     *
     * Generated from Godot docs: EngineDebugger.debug
     */
    @JvmStatic
    fun debug(canContinue: Boolean, isErrorBreakpoint: Boolean) {
        ObjectCalls.ptrcallWithTwoBoolArgs(debugBind, singleton, canContinue, isErrorBreakpoint)
    }

    /**
     * Starts a debug break in script execution, optionally specifying whether the program can continue
     * based on `can_continue` and whether the break was due to a breakpoint.
     *
     * Generated from Godot docs: EngineDebugger.script_debug
     */
    @JvmStatic
    fun scriptDebug(scriptLanguageObject: MemorySegment, canContinue: Boolean, isErrorBreakpoint: Boolean) {
        ObjectCalls.ptrcallWithObjectAndTwoBoolArgs(
            scriptDebugBind,
            singleton,
            scriptLanguageObject,
            canContinue,
            isErrorBreakpoint,
        )
    }

}
