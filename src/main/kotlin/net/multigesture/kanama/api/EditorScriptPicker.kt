package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Godot editor's control for selecting the `script` property of a `Node`.
 *
 * Generated from Godot docs: EditorScriptPicker
 */
class EditorScriptPicker(handle: MemorySegment) : EditorResourcePicker(handle) {
    val scriptOwner: Node?
        @JvmName("scriptOwnerProperty")
        get() = getScriptOwner()

    /**
     * The owner `Node` of the script property that holds the edited resource.
     *
     * Generated from Godot docs: EditorScriptPicker.set_script_owner
     */
    fun setScriptOwner(ownerNode: Node) {
        ObjectCalls.ptrcallWithObjectArgs(setScriptOwnerBind, handle, listOf(ownerNode.handle))
    }

    /**
     * The owner `Node` of the script property that holds the edited resource.
     *
     * Generated from Godot docs: EditorScriptPicker.get_script_owner
     */
    fun getScriptOwner(): Node? {
        return Node.wrap(ObjectCalls.ptrcallNoArgsRetObject(getScriptOwnerBind, handle))
    }

    companion object {
        private const val SET_SCRIPT_OWNER_HASH = 1078189570L
        private val setScriptOwnerBind by lazy {
            ObjectCalls.getMethodBind("EditorScriptPicker", "set_script_owner", SET_SCRIPT_OWNER_HASH)
        }

        private const val GET_SCRIPT_OWNER_HASH = 3160264692L
        private val getScriptOwnerBind by lazy {
            ObjectCalls.getMethodBind("EditorScriptPicker", "get_script_owner", GET_SCRIPT_OWNER_HASH)
        }
    }
}
