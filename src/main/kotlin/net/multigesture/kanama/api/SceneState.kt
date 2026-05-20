package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.NodePath
import java.lang.foreign.MemorySegment

/**
 * Provides access to a scene file's information.
 *
 * Generated from Godot docs: SceneState
 */
class SceneState internal constructor(handle: MemorySegment) : RefCounted(handle) {
    /**
     * Returns the resource path to the represented `PackedScene`.
     *
     * Generated from Godot docs: SceneState.get_path
     */
    fun getPath(): String {
        checkOpen()
        return ObjectCalls.ptrcallNoArgsRetString(getPathBind, handle)
    }

    /**
     * Returns the `SceneState` of the scene that this scene inherits from, or `null` if it doesn't
     * inherit from any scene.
     *
     * Generated from Godot docs: SceneState.get_base_scene_state
     */
    fun getBaseSceneState(): SceneState? {
        checkOpen()
        return wrap(ObjectCalls.ptrcallNoArgsRetObject(getBaseSceneStateBind, handle))
    }

    /**
     * Returns the number of nodes in the scene. The `idx` argument used to query node data in other
     * `get_node_*` methods in the interval `[0, get_node_count() - 1]`.
     *
     * Generated from Godot docs: SceneState.get_node_count
     */
    fun getNodeCount(): Long {
        checkOpen()
        return ObjectCalls.ptrcallNoArgsRetInt(getNodeCountBind, handle).toLong()
    }

    /**
     * Returns the type of the node at `idx`.
     *
     * Generated from Godot docs: SceneState.get_node_type
     */
    fun getNodeType(idx: Long): String {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetStringName(getNodeTypeBind, handle, idx.toInt())
    }

    /**
     * Returns the name of the node at `idx`.
     *
     * Generated from Godot docs: SceneState.get_node_name
     */
    fun getNodeName(idx: Int): String {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetStringName(getNodeNameBind, handle, idx)
    }

    /**
     * Returns the name of the node at `idx`.
     *
     * Generated from Godot docs: SceneState.get_node_name
     */
    fun getNodeName(idx: Long): String =
        getNodeName(idx.toInt())

    /**
     * Returns the path to the node at `idx`. If `for_parent` is `true`, returns the path of the `idx`
     * node's parent instead.
     *
     * Generated from Godot docs: SceneState.get_node_path
     */
    fun getNodePath(idx: Int, forParent: Boolean = false): NodePath {
        checkOpen()
        return ObjectCalls.ptrcallWithIntAndBoolArgRetNodePath(getNodePathBind, handle, idx, forParent)
    }

    /**
     * Returns the path to the node at `idx`. If `for_parent` is `true`, returns the path of the `idx`
     * node's parent instead.
     *
     * Generated from Godot docs: SceneState.get_node_path
     */
    fun getNodePath(idx: Long, forParent: Boolean = false): NodePath =
        getNodePath(idx.toInt(), forParent)

    /**
     * Returns the path to the owner of the node at `idx`, relative to the root node.
     *
     * Generated from Godot docs: SceneState.get_node_owner_path
     */
    fun getNodeOwnerPath(idx: Int): NodePath {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetNodePath(getNodeOwnerPathBind, handle, idx)
    }

    /**
     * Returns the path to the owner of the node at `idx`, relative to the root node.
     *
     * Generated from Godot docs: SceneState.get_node_owner_path
     */
    fun getNodeOwnerPath(idx: Long): NodePath =
        getNodeOwnerPath(idx.toInt())

    /**
     * Returns `true` if the node at `idx` is an `InstancePlaceholder`.
     *
     * Generated from Godot docs: SceneState.is_node_instance_placeholder
     */
    fun isNodeInstancePlaceholder(idx: Int): Boolean {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetBool(isNodeInstancePlaceholderBind, handle, idx)
    }

    /**
     * Returns `true` if the node at `idx` is an `InstancePlaceholder`.
     *
     * Generated from Godot docs: SceneState.is_node_instance_placeholder
     */
    fun isNodeInstancePlaceholder(idx: Long): Boolean =
        isNodeInstancePlaceholder(idx.toInt())

    /**
     * Returns the path to the represented scene file if the node at `idx` is an `InstancePlaceholder`.
     *
     * Generated from Godot docs: SceneState.get_node_instance_placeholder
     */
    fun getNodeInstancePlaceholder(idx: Int): String {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetString(getNodeInstancePlaceholderBind, handle, idx)
    }

    /**
     * Returns the path to the represented scene file if the node at `idx` is an `InstancePlaceholder`.
     *
     * Generated from Godot docs: SceneState.get_node_instance_placeholder
     */
    fun getNodeInstancePlaceholder(idx: Long): String =
        getNodeInstancePlaceholder(idx.toInt())

    /**
     * Returns a `PackedScene` for the node at `idx` (i.e. the whole branch starting at this node, with
     * its child nodes and resources), or `null` if the node is not an instance.
     *
     * Generated from Godot docs: SceneState.get_node_instance
     */
    fun getNodeInstance(idx: Int): PackedScene? {
        checkOpen()
        return PackedScene.wrap(ObjectCalls.ptrcallWithIntArgRetObject(getNodeInstanceBind, handle, idx))
    }

    /**
     * Returns a `PackedScene` for the node at `idx` (i.e. the whole branch starting at this node, with
     * its child nodes and resources), or `null` if the node is not an instance.
     *
     * Generated from Godot docs: SceneState.get_node_instance
     */
    fun getNodeInstance(idx: Long): PackedScene? =
        getNodeInstance(idx.toInt())

    /**
     * Returns the list of group names associated with the node at `idx`.
     *
     * Generated from Godot docs: SceneState.get_node_groups
     */
    fun getNodeGroups(idx: Int): List<String> {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetPackedStringList(getNodeGroupsBind, handle, idx)
    }

    /**
     * Returns the list of group names associated with the node at `idx`.
     *
     * Generated from Godot docs: SceneState.get_node_groups
     */
    fun getNodeGroups(idx: Long): List<String> =
        getNodeGroups(idx.toInt())

    /**
     * Returns the node's index, which is its position relative to its siblings. This is only relevant
     * and saved in scenes for cases where new nodes are added to an instantiated or inherited scene
     * among siblings from the base scene. Despite the name, this index is not related to the `idx`
     * argument used here and in other methods.
     *
     * Generated from Godot docs: SceneState.get_node_index
     */
    fun getNodeIndex(idx: Int): Int {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetInt(getNodeIndexBind, handle, idx)
    }

    /**
     * Returns the node's index, which is its position relative to its siblings. This is only relevant
     * and saved in scenes for cases where new nodes are added to an instantiated or inherited scene
     * among siblings from the base scene. Despite the name, this index is not related to the `idx`
     * argument used here and in other methods.
     *
     * Generated from Godot docs: SceneState.get_node_index
     */
    fun getNodeIndex(idx: Long): Long =
        getNodeIndex(idx.toInt()).toLong()

    /**
     * Returns the number of exported or overridden properties for the node at `idx`. The `prop_idx`
     * argument used to query node property data in other `get_node_property_*` methods in the interval
     * `[0, get_node_property_count() - 1]`.
     *
     * Generated from Godot docs: SceneState.get_node_property_count
     */
    fun getNodePropertyCount(idx: Long): Long {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetInt(getNodePropertyCountBind, handle, idx.toInt()).toLong()
    }

    /**
     * Returns the name of the property at `prop_idx` for the node at `idx`.
     *
     * Generated from Godot docs: SceneState.get_node_property_name
     */
    fun getNodePropertyName(idx: Long, propertyIdx: Long): String {
        checkOpen()
        return ObjectCalls.ptrcallWithTwoIntArgsRetStringName(getNodePropertyNameBind, handle, idx.toInt(), propertyIdx.toInt())
    }

    /**
     * Returns the value of the property at `prop_idx` for the node at `idx`.
     *
     * Generated from Godot docs: SceneState.get_node_property_value
     */
    fun getNodePropertyValue(idx: Long, propertyIdx: Long): Any? {
        checkOpen()
        return ObjectCalls.ptrcallWithTwoLongArgsRetVariantScalar(getNodePropertyValueBind, handle, idx, propertyIdx)
    }

    /**
     * Returns the number of signal connections in the scene. The `idx` argument used to query
     * connection metadata in other `get_connection_*` methods in the interval `[0,
     * get_connection_count() - 1]`.
     *
     * Generated from Godot docs: SceneState.get_connection_count
     */
    fun getConnectionCount(): Int {
        checkOpen()
        return ObjectCalls.ptrcallNoArgsRetInt(getConnectionCountBind, handle)
    }

    /**
     * Returns the path to the node that owns the signal at `idx`, relative to the root node.
     *
     * Generated from Godot docs: SceneState.get_connection_source
     */
    fun getConnectionSource(idx: Int): NodePath {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetNodePath(getConnectionSourceBind, handle, idx)
    }

    /**
     * Returns the name of the signal at `idx`.
     *
     * Generated from Godot docs: SceneState.get_connection_signal
     */
    fun getConnectionSignal(idx: Int): String {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetStringName(getConnectionSignalBind, handle, idx)
    }

    /**
     * Returns the path to the node that owns the method connected to the signal at `idx`, relative to
     * the root node.
     *
     * Generated from Godot docs: SceneState.get_connection_target
     */
    fun getConnectionTarget(idx: Int): NodePath {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetNodePath(getConnectionTargetBind, handle, idx)
    }

    /**
     * Returns the method connected to the signal at `idx`.
     *
     * Generated from Godot docs: SceneState.get_connection_method
     */
    fun getConnectionMethod(idx: Int): String {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetStringName(getConnectionMethodBind, handle, idx)
    }

    /**
     * Returns the connection flags for the signal at `idx`. See `Object.ConnectFlags` constants.
     *
     * Generated from Godot docs: SceneState.get_connection_flags
     */
    fun getConnectionFlags(idx: Int): Int {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetInt(getConnectionFlagsBind, handle, idx)
    }

    /**
     * Returns the list of bound parameters for the signal at `idx`.
     *
     * Generated from Godot docs: SceneState.get_connection_binds
     */
    fun getConnectionBinds(idx: Int): List<Any?> {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetArray(getConnectionBindsBind, handle, idx)
    }

    /**
     * Returns the number of unbound parameters for the signal at `idx`.
     *
     * Generated from Godot docs: SceneState.get_connection_unbinds
     */
    fun getConnectionUnbinds(idx: Int): Int {
        checkOpen()
        return ObjectCalls.ptrcallWithIntArgRetInt(getConnectionUnbindsBind, handle, idx)
    }

    companion object {
        const val GEN_EDIT_STATE_DISABLED = 0L
        const val GEN_EDIT_STATE_INSTANCE = 1L
        const val GEN_EDIT_STATE_MAIN = 2L
        const val GEN_EDIT_STATE_MAIN_INHERITED = 3L

        private const val NOARGS_LONG_HASH = 3905245786L
        private const val NOARGS_STRING_HASH = 201670096L
        private const val NOARGS_OBJECT_HASH = 3479783971L
        private const val LONG_RET_STRING_NAME_HASH = 659327637L
        private const val LONG_RET_LONG_HASH = 923996154L
        private const val TWO_LONG_RET_STRING_NAME_HASH = 351665558L
        private const val TWO_LONG_RET_VARIANT_HASH = 678354945L
        private const val INT_BOOL_RET_NODE_PATH_HASH = 2272487792L
        private const val INT_RET_NODE_PATH_HASH = 408788394L
        private const val INT_RET_BOOL_HASH = 1116898809L
        private const val INT_RET_STRING_HASH = 844755477L
        private const val INT_RET_OBJECT_HASH = 511017218L
        private const val INT_RET_PACKED_STRING_LIST_HASH = 647634434L
        private const val INT_RET_ARRAY_HASH = 663333327L

        private val getPathBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_path", NOARGS_STRING_HASH)
        }

        private val getBaseSceneStateBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_base_scene_state", NOARGS_OBJECT_HASH)
        }

        private val getNodeCountBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_node_count", NOARGS_LONG_HASH)
        }

        private val getNodeTypeBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_node_type", LONG_RET_STRING_NAME_HASH)
        }

        private val getNodeNameBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_node_name", LONG_RET_STRING_NAME_HASH)
        }

        private val getNodePathBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_node_path", INT_BOOL_RET_NODE_PATH_HASH)
        }

        private val getNodeOwnerPathBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_node_owner_path", INT_RET_NODE_PATH_HASH)
        }

        private val isNodeInstancePlaceholderBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "is_node_instance_placeholder", INT_RET_BOOL_HASH)
        }

        private val getNodeInstancePlaceholderBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_node_instance_placeholder", INT_RET_STRING_HASH)
        }

        private val getNodeInstanceBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_node_instance", INT_RET_OBJECT_HASH)
        }

        private val getNodeGroupsBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_node_groups", INT_RET_PACKED_STRING_LIST_HASH)
        }

        private val getNodeIndexBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_node_index", LONG_RET_LONG_HASH)
        }

        private val getNodePropertyCountBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_node_property_count", LONG_RET_LONG_HASH)
        }

        private val getNodePropertyNameBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_node_property_name", TWO_LONG_RET_STRING_NAME_HASH)
        }

        private val getNodePropertyValueBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_node_property_value", TWO_LONG_RET_VARIANT_HASH)
        }

        private val getConnectionCountBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_connection_count", NOARGS_LONG_HASH)
        }

        private val getConnectionSourceBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_connection_source", INT_RET_NODE_PATH_HASH)
        }

        private val getConnectionSignalBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_connection_signal", LONG_RET_STRING_NAME_HASH)
        }

        private val getConnectionTargetBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_connection_target", INT_RET_NODE_PATH_HASH)
        }

        private val getConnectionMethodBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_connection_method", LONG_RET_STRING_NAME_HASH)
        }

        private val getConnectionFlagsBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_connection_flags", LONG_RET_LONG_HASH)
        }

        private val getConnectionBindsBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_connection_binds", INT_RET_ARRAY_HASH)
        }

        private val getConnectionUnbindsBind by lazy {
            ObjectCalls.getMethodBind("SceneState", "get_connection_unbinds", LONG_RET_LONG_HASH)
        }

        internal fun wrap(handle: MemorySegment): SceneState? =
            if (handle.address() == 0L) null else SceneState(handle)
    }
}
