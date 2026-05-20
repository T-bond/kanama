package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A set of `AnimationRootNode`s placed on a virtual axis, crossfading between the two adjacent
 * ones. Used by `AnimationTree`.
 *
 * Generated from Godot docs: AnimationNodeBlendSpace1D
 */
class AnimationNodeBlendSpace1D(handle: MemorySegment) : AnimationRootNode(handle) {
    var minSpace: Double
        @JvmName("minSpaceProperty")
        get() = getMinSpace()
        @JvmName("setMinSpaceProperty")
        set(value) = setMinSpace(value)

    var maxSpace: Double
        @JvmName("maxSpaceProperty")
        get() = getMaxSpace()
        @JvmName("setMaxSpaceProperty")
        set(value) = setMaxSpace(value)

    var snap: Double
        @JvmName("snapProperty")
        get() = getSnap()
        @JvmName("setSnapProperty")
        set(value) = setSnap(value)

    var valueLabel: String
        @JvmName("valueLabelProperty")
        get() = getValueLabel()
        @JvmName("setValueLabelProperty")
        set(value) = setValueLabel(value)

    var blendMode: Long
        @JvmName("blendModeProperty")
        get() = getBlendMode()
        @JvmName("setBlendModeProperty")
        set(value) = setBlendMode(value)

    var sync: Boolean
        @JvmName("syncProperty")
        get() = isUsingSync()
        @JvmName("setSyncProperty")
        set(value) = setUseSync(value)

    /**
     * Adds a new point with `name` that represents a `node` on the virtual axis at a given position
     * set by `pos`. You can insert it at a specific index using the `at_index` argument. If you use
     * the default value for `at_index`, the point is inserted at the end of the blend points array.
     * Note: If no name is provided, safe index is used as reference. In the future, empty names will
     * be deprecated, so explicitly passing a name is recommended.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.add_blend_point
     */
    fun addBlendPoint(node: AnimationRootNode?, pos: Double, atIndex: Int = -1) {
        ObjectCalls.ptrcallWithObjectDoubleAndIntArgs(addBlendPointBind, handle, node?.requireOpenHandle() ?: MemorySegment.NULL, pos, atIndex)
    }

    /**
     * Updates the position of the point at index `point` on the blend axis.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.set_blend_point_position
     */
    fun setBlendPointPosition(point: Int, pos: Double) {
        ObjectCalls.ptrcallWithIntAndDoubleArg(setBlendPointPositionBind, handle, point, pos)
    }

    /**
     * Returns the position of the point at index `point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.get_blend_point_position
     */
    fun getBlendPointPosition(point: Int): Double {
        return ObjectCalls.ptrcallWithIntArgRetDouble(getBlendPointPositionBind, handle, point)
    }

    /**
     * Changes the `AnimationNode` referenced by the point at index `point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.set_blend_point_node
     */
    fun setBlendPointNode(point: Int, node: AnimationRootNode?) {
        ObjectCalls.ptrcallWithIntAndObjectArg(setBlendPointNodeBind, handle, point, node?.requireOpenHandle() ?: MemorySegment.NULL)
    }

    /**
     * Returns the `AnimationNode` referenced by the point at index `point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.get_blend_point_node
     */
    fun getBlendPointNode(point: Int): AnimationRootNode? {
        return AnimationRootNode.wrap(ObjectCalls.ptrcallWithIntArgRetObject(getBlendPointNodeBind, handle, point))
    }

    /**
     * Removes the point at index `point` from the blend axis.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.remove_blend_point
     */
    fun removeBlendPoint(point: Int) {
        ObjectCalls.ptrcallWithIntArg(removeBlendPointBind, handle, point)
    }

    /**
     * Returns the number of points on the blend axis.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.get_blend_point_count
     */
    fun getBlendPointCount(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getBlendPointCountBind, handle)
    }

    /**
     * The blend space's axis's lower limit for the points' position. See `add_blend_point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.set_min_space
     */
    fun setMinSpace(minSpace: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setMinSpaceBind, handle, minSpace)
    }

    /**
     * The blend space's axis's lower limit for the points' position. See `add_blend_point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.get_min_space
     */
    fun getMinSpace(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getMinSpaceBind, handle)
    }

    /**
     * The blend space's axis's upper limit for the points' position. See `add_blend_point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.set_max_space
     */
    fun setMaxSpace(maxSpace: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setMaxSpaceBind, handle, maxSpace)
    }

    /**
     * The blend space's axis's upper limit for the points' position. See `add_blend_point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.get_max_space
     */
    fun getMaxSpace(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getMaxSpaceBind, handle)
    }

    /**
     * Position increment to snap to when moving a point on the axis.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.set_snap
     */
    fun setSnap(snap: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setSnapBind, handle, snap)
    }

    /**
     * Position increment to snap to when moving a point on the axis.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.get_snap
     */
    fun getSnap(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getSnapBind, handle)
    }

    /**
     * Label of the virtual axis of the blend space.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.set_value_label
     */
    fun setValueLabel(text: String) {
        ObjectCalls.ptrcallWithStringArg(setValueLabelBind, handle, text)
    }

    /**
     * Label of the virtual axis of the blend space.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.get_value_label
     */
    fun getValueLabel(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getValueLabelBind, handle)
    }

    /**
     * Controls the interpolation between animations.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.set_blend_mode
     */
    fun setBlendMode(mode: Long) {
        ObjectCalls.ptrcallWithLongArg(setBlendModeBind, handle, mode)
    }

    /**
     * Controls the interpolation between animations.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.get_blend_mode
     */
    fun getBlendMode(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getBlendModeBind, handle)
    }

    /**
     * If `true`, sync mode is enabled (equivalent to `SYNC_MODE_INDEPENDENT`). This property is kept
     * for backward compatibility.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.set_use_sync
     */
    fun setUseSync(enable: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setUseSyncBind, handle, enable)
    }

    /**
     * If `true`, sync mode is enabled (equivalent to `SYNC_MODE_INDEPENDENT`). This property is kept
     * for backward compatibility.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace1D.is_using_sync
     */
    fun isUsingSync(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isUsingSyncBind, handle)
    }

    companion object {
        private const val ADD_BLEND_POINT_HASH = 285050433L
        private val addBlendPointBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "add_blend_point", ADD_BLEND_POINT_HASH)
        }

        private const val SET_BLEND_POINT_POSITION_HASH = 1602489585L
        private val setBlendPointPositionBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "set_blend_point_position", SET_BLEND_POINT_POSITION_HASH)
        }

        private const val GET_BLEND_POINT_POSITION_HASH = 2339986948L
        private val getBlendPointPositionBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "get_blend_point_position", GET_BLEND_POINT_POSITION_HASH)
        }

        private const val SET_BLEND_POINT_NODE_HASH = 4240341528L
        private val setBlendPointNodeBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "set_blend_point_node", SET_BLEND_POINT_NODE_HASH)
        }

        private const val GET_BLEND_POINT_NODE_HASH = 665599029L
        private val getBlendPointNodeBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "get_blend_point_node", GET_BLEND_POINT_NODE_HASH)
        }

        private const val REMOVE_BLEND_POINT_HASH = 1286410249L
        private val removeBlendPointBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "remove_blend_point", REMOVE_BLEND_POINT_HASH)
        }

        private const val GET_BLEND_POINT_COUNT_HASH = 3905245786L
        private val getBlendPointCountBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "get_blend_point_count", GET_BLEND_POINT_COUNT_HASH)
        }

        private const val SET_MIN_SPACE_HASH = 373806689L
        private val setMinSpaceBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "set_min_space", SET_MIN_SPACE_HASH)
        }

        private const val GET_MIN_SPACE_HASH = 1740695150L
        private val getMinSpaceBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "get_min_space", GET_MIN_SPACE_HASH)
        }

        private const val SET_MAX_SPACE_HASH = 373806689L
        private val setMaxSpaceBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "set_max_space", SET_MAX_SPACE_HASH)
        }

        private const val GET_MAX_SPACE_HASH = 1740695150L
        private val getMaxSpaceBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "get_max_space", GET_MAX_SPACE_HASH)
        }

        private const val SET_SNAP_HASH = 373806689L
        private val setSnapBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "set_snap", SET_SNAP_HASH)
        }

        private const val GET_SNAP_HASH = 1740695150L
        private val getSnapBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "get_snap", GET_SNAP_HASH)
        }

        private const val SET_VALUE_LABEL_HASH = 83702148L
        private val setValueLabelBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "set_value_label", SET_VALUE_LABEL_HASH)
        }

        private const val GET_VALUE_LABEL_HASH = 201670096L
        private val getValueLabelBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "get_value_label", GET_VALUE_LABEL_HASH)
        }

        private const val SET_BLEND_MODE_HASH = 2600869457L
        private val setBlendModeBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "set_blend_mode", SET_BLEND_MODE_HASH)
        }

        private const val GET_BLEND_MODE_HASH = 1547667849L
        private val getBlendModeBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "get_blend_mode", GET_BLEND_MODE_HASH)
        }

        private const val SET_USE_SYNC_HASH = 2586408642L
        private val setUseSyncBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "set_use_sync", SET_USE_SYNC_HASH)
        }

        private const val IS_USING_SYNC_HASH = 36873697L
        private val isUsingSyncBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace1D", "is_using_sync", IS_USING_SYNC_HASH)
        }
    }
}
