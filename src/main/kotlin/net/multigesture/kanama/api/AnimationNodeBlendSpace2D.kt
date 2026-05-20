package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.Vector2
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A set of `AnimationRootNode`s placed on 2D coordinates, crossfading between the three adjacent
 * ones. Used by `AnimationTree`.
 *
 * Generated from Godot docs: AnimationNodeBlendSpace2D
 */
class AnimationNodeBlendSpace2D(handle: MemorySegment) : AnimationRootNode(handle) {
    var autoTriangles: Boolean
        @JvmName("autoTrianglesProperty")
        get() = getAutoTriangles()
        @JvmName("setAutoTrianglesProperty")
        set(value) = setAutoTriangles(value)

    var minSpace: Vector2
        @JvmName("minSpaceProperty")
        get() = getMinSpace()
        @JvmName("setMinSpaceProperty")
        set(value) = setMinSpace(value)

    var maxSpace: Vector2
        @JvmName("maxSpaceProperty")
        get() = getMaxSpace()
        @JvmName("setMaxSpaceProperty")
        set(value) = setMaxSpace(value)

    var snap: Vector2
        @JvmName("snapProperty")
        get() = getSnap()
        @JvmName("setSnapProperty")
        set(value) = setSnap(value)

    var xLabel: String
        @JvmName("xLabelProperty")
        get() = getXLabel()
        @JvmName("setXLabelProperty")
        set(value) = setXLabel(value)

    var yLabel: String
        @JvmName("yLabelProperty")
        get() = getYLabel()
        @JvmName("setYLabelProperty")
        set(value) = setYLabel(value)

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
     * Adds a new point with `name` that represents a `node` at the position set by `pos`. You can
     * insert it at a specific index using the `at_index` argument. If you use the default value for
     * `at_index`, the point is inserted at the end of the blend points array. Note: If no name is
     * provided, safe index is used as reference. In the future, empty names will be deprecated, so
     * explicitly passing a name is recommended.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.add_blend_point
     */
    fun addBlendPoint(node: AnimationRootNode?, pos: Vector2, atIndex: Int = -1) {
        ObjectCalls.ptrcallWithObjectVector2AndIntArgs(addBlendPointBind, handle, node?.requireOpenHandle() ?: MemorySegment.NULL, pos, atIndex)
    }

    /**
     * Updates the position of the point at index `point` in the blend space.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.set_blend_point_position
     */
    fun setBlendPointPosition(point: Int, pos: Vector2) {
        ObjectCalls.ptrcallWithIntAndVector2Arg(setBlendPointPositionBind, handle, point, pos)
    }

    /**
     * Returns the position of the point at index `point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.get_blend_point_position
     */
    fun getBlendPointPosition(point: Int): Vector2 {
        return ObjectCalls.ptrcallWithIntArgRetVector2(getBlendPointPositionBind, handle, point)
    }

    /**
     * Changes the `AnimationNode` referenced by the point at index `point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.set_blend_point_node
     */
    fun setBlendPointNode(point: Int, node: AnimationRootNode?) {
        ObjectCalls.ptrcallWithIntAndObjectArg(setBlendPointNodeBind, handle, point, node?.requireOpenHandle() ?: MemorySegment.NULL)
    }

    /**
     * Returns the `AnimationRootNode` referenced by the point at index `point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.get_blend_point_node
     */
    fun getBlendPointNode(point: Int): AnimationRootNode? {
        return AnimationRootNode.wrap(ObjectCalls.ptrcallWithIntArgRetObject(getBlendPointNodeBind, handle, point))
    }

    /**
     * Removes the point at index `point` from the blend space.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.remove_blend_point
     */
    fun removeBlendPoint(point: Int) {
        ObjectCalls.ptrcallWithIntArg(removeBlendPointBind, handle, point)
    }

    /**
     * Returns the number of points in the blend space.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.get_blend_point_count
     */
    fun getBlendPointCount(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getBlendPointCountBind, handle)
    }

    /**
     * Creates a new triangle using three points `x`, `y`, and `z`. Triangles can overlap. You can
     * insert the triangle at a specific index using the `at_index` argument. If you use the default
     * value for `at_index`, the point is inserted at the end of the blend points array.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.add_triangle
     */
    fun addTriangle(x: Int, y: Int, z: Int, atIndex: Int = -1) {
        ObjectCalls.ptrcallWithFourIntArgs(addTriangleBind, handle, x, y, z, atIndex)
    }

    /**
     * Returns the position of the point at index `point` in the triangle of index `triangle`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.get_triangle_point
     */
    fun getTrianglePoint(triangle: Int, point: Int): Int {
        return ObjectCalls.ptrcallWithTwoIntArgsRetInt(getTrianglePointBind, handle, triangle, point)
    }

    /**
     * Removes the triangle at index `triangle` from the blend space.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.remove_triangle
     */
    fun removeTriangle(triangle: Int) {
        ObjectCalls.ptrcallWithIntArg(removeTriangleBind, handle, triangle)
    }

    /**
     * Returns the number of triangles in the blend space.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.get_triangle_count
     */
    fun getTriangleCount(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getTriangleCountBind, handle)
    }

    /**
     * The blend space's X and Y axes' lower limit for the points' position. See `add_blend_point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.set_min_space
     */
    fun setMinSpace(minSpace: Vector2) {
        ObjectCalls.ptrcallWithVector2Arg(setMinSpaceBind, handle, minSpace)
    }

    /**
     * The blend space's X and Y axes' lower limit for the points' position. See `add_blend_point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.get_min_space
     */
    fun getMinSpace(): Vector2 {
        return ObjectCalls.ptrcallNoArgsRetVector2(getMinSpaceBind, handle)
    }

    /**
     * The blend space's X and Y axes' upper limit for the points' position. See `add_blend_point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.set_max_space
     */
    fun setMaxSpace(maxSpace: Vector2) {
        ObjectCalls.ptrcallWithVector2Arg(setMaxSpaceBind, handle, maxSpace)
    }

    /**
     * The blend space's X and Y axes' upper limit for the points' position. See `add_blend_point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.get_max_space
     */
    fun getMaxSpace(): Vector2 {
        return ObjectCalls.ptrcallNoArgsRetVector2(getMaxSpaceBind, handle)
    }

    /**
     * Position increment to snap to when moving a point.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.set_snap
     */
    fun setSnap(snap: Vector2) {
        ObjectCalls.ptrcallWithVector2Arg(setSnapBind, handle, snap)
    }

    /**
     * Position increment to snap to when moving a point.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.get_snap
     */
    fun getSnap(): Vector2 {
        return ObjectCalls.ptrcallNoArgsRetVector2(getSnapBind, handle)
    }

    /**
     * Name of the blend space's X axis.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.set_x_label
     */
    fun setXLabel(text: String) {
        ObjectCalls.ptrcallWithStringArg(setXLabelBind, handle, text)
    }

    /**
     * Name of the blend space's X axis.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.get_x_label
     */
    fun getXLabel(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getXLabelBind, handle)
    }

    /**
     * Name of the blend space's Y axis.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.set_y_label
     */
    fun setYLabel(text: String) {
        ObjectCalls.ptrcallWithStringArg(setYLabelBind, handle, text)
    }

    /**
     * Name of the blend space's Y axis.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.get_y_label
     */
    fun getYLabel(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getYLabelBind, handle)
    }

    /**
     * If `true`, the blend space is triangulated automatically. The mesh updates every time you add or
     * remove points with `add_blend_point` and `remove_blend_point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.set_auto_triangles
     */
    fun setAutoTriangles(enable: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setAutoTrianglesBind, handle, enable)
    }

    /**
     * If `true`, the blend space is triangulated automatically. The mesh updates every time you add or
     * remove points with `add_blend_point` and `remove_blend_point`.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.get_auto_triangles
     */
    fun getAutoTriangles(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(getAutoTrianglesBind, handle)
    }

    /**
     * Controls the interpolation between animations.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.set_blend_mode
     */
    fun setBlendMode(mode: Long) {
        ObjectCalls.ptrcallWithLongArg(setBlendModeBind, handle, mode)
    }

    /**
     * Controls the interpolation between animations.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.get_blend_mode
     */
    fun getBlendMode(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getBlendModeBind, handle)
    }

    /**
     * If `true`, sync mode is enabled (equivalent to `SYNC_MODE_INDEPENDENT`). This property is kept
     * for backward compatibility.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.set_use_sync
     */
    fun setUseSync(enable: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setUseSyncBind, handle, enable)
    }

    /**
     * If `true`, sync mode is enabled (equivalent to `SYNC_MODE_INDEPENDENT`). This property is kept
     * for backward compatibility.
     *
     * Generated from Godot docs: AnimationNodeBlendSpace2D.is_using_sync
     */
    fun isUsingSync(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isUsingSyncBind, handle)
    }

    object Signals {
        const val trianglesUpdated: String = "triangles_updated"
    }

    companion object {
        private const val ADD_BLEND_POINT_HASH = 402261981L
        private val addBlendPointBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "add_blend_point", ADD_BLEND_POINT_HASH)
        }

        private const val SET_BLEND_POINT_POSITION_HASH = 163021252L
        private val setBlendPointPositionBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "set_blend_point_position", SET_BLEND_POINT_POSITION_HASH)
        }

        private const val GET_BLEND_POINT_POSITION_HASH = 2299179447L
        private val getBlendPointPositionBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "get_blend_point_position", GET_BLEND_POINT_POSITION_HASH)
        }

        private const val SET_BLEND_POINT_NODE_HASH = 4240341528L
        private val setBlendPointNodeBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "set_blend_point_node", SET_BLEND_POINT_NODE_HASH)
        }

        private const val GET_BLEND_POINT_NODE_HASH = 665599029L
        private val getBlendPointNodeBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "get_blend_point_node", GET_BLEND_POINT_NODE_HASH)
        }

        private const val REMOVE_BLEND_POINT_HASH = 1286410249L
        private val removeBlendPointBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "remove_blend_point", REMOVE_BLEND_POINT_HASH)
        }

        private const val GET_BLEND_POINT_COUNT_HASH = 3905245786L
        private val getBlendPointCountBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "get_blend_point_count", GET_BLEND_POINT_COUNT_HASH)
        }

        private const val ADD_TRIANGLE_HASH = 753017335L
        private val addTriangleBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "add_triangle", ADD_TRIANGLE_HASH)
        }

        private const val GET_TRIANGLE_POINT_HASH = 50157827L
        private val getTrianglePointBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "get_triangle_point", GET_TRIANGLE_POINT_HASH)
        }

        private const val REMOVE_TRIANGLE_HASH = 1286410249L
        private val removeTriangleBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "remove_triangle", REMOVE_TRIANGLE_HASH)
        }

        private const val GET_TRIANGLE_COUNT_HASH = 3905245786L
        private val getTriangleCountBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "get_triangle_count", GET_TRIANGLE_COUNT_HASH)
        }

        private const val SET_MIN_SPACE_HASH = 743155724L
        private val setMinSpaceBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "set_min_space", SET_MIN_SPACE_HASH)
        }

        private const val GET_MIN_SPACE_HASH = 3341600327L
        private val getMinSpaceBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "get_min_space", GET_MIN_SPACE_HASH)
        }

        private const val SET_MAX_SPACE_HASH = 743155724L
        private val setMaxSpaceBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "set_max_space", SET_MAX_SPACE_HASH)
        }

        private const val GET_MAX_SPACE_HASH = 3341600327L
        private val getMaxSpaceBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "get_max_space", GET_MAX_SPACE_HASH)
        }

        private const val SET_SNAP_HASH = 743155724L
        private val setSnapBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "set_snap", SET_SNAP_HASH)
        }

        private const val GET_SNAP_HASH = 3341600327L
        private val getSnapBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "get_snap", GET_SNAP_HASH)
        }

        private const val SET_X_LABEL_HASH = 83702148L
        private val setXLabelBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "set_x_label", SET_X_LABEL_HASH)
        }

        private const val GET_X_LABEL_HASH = 201670096L
        private val getXLabelBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "get_x_label", GET_X_LABEL_HASH)
        }

        private const val SET_Y_LABEL_HASH = 83702148L
        private val setYLabelBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "set_y_label", SET_Y_LABEL_HASH)
        }

        private const val GET_Y_LABEL_HASH = 201670096L
        private val getYLabelBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "get_y_label", GET_Y_LABEL_HASH)
        }

        private const val SET_AUTO_TRIANGLES_HASH = 2586408642L
        private val setAutoTrianglesBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "set_auto_triangles", SET_AUTO_TRIANGLES_HASH)
        }

        private const val GET_AUTO_TRIANGLES_HASH = 36873697L
        private val getAutoTrianglesBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "get_auto_triangles", GET_AUTO_TRIANGLES_HASH)
        }

        private const val SET_BLEND_MODE_HASH = 81193520L
        private val setBlendModeBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "set_blend_mode", SET_BLEND_MODE_HASH)
        }

        private const val GET_BLEND_MODE_HASH = 1398433632L
        private val getBlendModeBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "get_blend_mode", GET_BLEND_MODE_HASH)
        }

        private const val SET_USE_SYNC_HASH = 2586408642L
        private val setUseSyncBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "set_use_sync", SET_USE_SYNC_HASH)
        }

        private const val IS_USING_SYNC_HASH = 36873697L
        private val isUsingSyncBind by lazy {
            ObjectCalls.getMethodBind("AnimationNodeBlendSpace2D", "is_using_sync", IS_USING_SYNC_HASH)
        }
    }
}
