package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A container that arranges its child controls in a grid layout.
 *
 * Generated from Godot docs: GridContainer
 */
class GridContainer(handle: MemorySegment) : Container(handle) {

    var columns: Int
        @JvmName("columnsProperty")
        get() = getColumns()
        @JvmName("setColumnsProperty")
        set(value) = setColumns(value)

    /**
     * The number of columns in the `GridContainer`. If modified, `GridContainer` reorders its
     * Control-derived children to accommodate the new layout.
     *
     * Generated from Godot docs: GridContainer.set_columns
     */
    fun setColumns(columns: Int) {
        ObjectCalls.ptrcallWithIntArg(setColumnsBind, handle, columns)
    }

    /**
     * The number of columns in the `GridContainer`. If modified, `GridContainer` reorders its
     * Control-derived children to accommodate the new layout.
     *
     * Generated from Godot docs: GridContainer.get_columns
     */
    fun getColumns(): Int =
        ObjectCalls.ptrcallNoArgsRetInt(getColumnsBind, handle)

    companion object {
        private const val INT_VOID_HASH = 1286410249L
        private const val NOARGS_INT_HASH = 3905245786L

        private val setColumnsBind by lazy {
            ObjectCalls.getMethodBind("GridContainer", "set_columns", INT_VOID_HASH)
        }

        private val getColumnsBind by lazy {
            ObjectCalls.getMethodBind("GridContainer", "get_columns", NOARGS_INT_HASH)
        }
    }
}
