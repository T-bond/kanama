package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.Rect2
import java.lang.foreign.MemorySegment

/**
 * Base class for all GUI containers.
 *
 * Generated from Godot docs: Container
 */
open class Container(handle: MemorySegment) : Control(handle) {
    /**
     * Queue resort of the contained children. This is called automatically anyway, but can be called
     * upon request.
     *
     * Generated from Godot docs: Container.queue_sort
     */
    fun queueSort() {
        ObjectCalls.ptrcallNoArgs(queueSortBind, handle)
    }

    /**
     * Fit a child control in a given rect. This is mainly a helper for creating custom container
     * classes.
     *
     * Generated from Godot docs: Container.fit_child_in_rect
     */
    fun fitChildInRect(child: Control, rect: Rect2) {
        ObjectCalls.ptrcallWithObjectAndRect2Arg(fitChildInRectBind, handle, child.handle, rect)
    }

    object Signals {
        const val preSortChildren: String = "pre_sort_children"
        const val sortChildren: String = "sort_children"
    }

    companion object {
        const val NOTIFICATION_PRE_SORT_CHILDREN: Long = 50L
        const val NOTIFICATION_SORT_CHILDREN: Long = 51L

        @JvmStatic
        fun fromHandle(handle: MemorySegment): Container? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): Container? =
            if (handle.address() == 0L) null else Container(handle)

        private const val QUEUE_SORT_HASH = 3218959716L
        private val queueSortBind by lazy {
            ObjectCalls.getMethodBind("Container", "queue_sort", QUEUE_SORT_HASH)
        }

        private const val FIT_CHILD_IN_RECT_HASH = 1993438598L
        private val fitChildInRectBind by lazy {
            ObjectCalls.getMethodBind("Container", "fit_child_in_rect", FIT_CHILD_IN_RECT_HASH)
        }
    }
}
