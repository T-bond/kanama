package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Node that instances a `MultiMesh`.
 *
 * Generated from Godot docs: MultiMeshInstance3D
 */
class MultiMeshInstance3D(handle: MemorySegment) : GeometryInstance3D(handle) {

    var multimesh: MultiMesh?
        @JvmName("multimeshProperty")
        get() = getMultimesh()
        @JvmName("setMultimeshProperty")
        set(value) = setMultimesh(value)

    /**
     * The `MultiMesh` resource that will be used and shared among all instances of the
     * `MultiMeshInstance3D`.
     *
     * Generated from Godot docs: MultiMeshInstance3D.set_multimesh
     */
    fun setMultimesh(multimesh: MultiMesh?) {
        ObjectCalls.ptrcallWithObjectArgs(
            setMultimeshBind,
            handle,
            listOf(multimesh?.requireOpenHandle() ?: MemorySegment.NULL),
        )
    }

    /**
     * The `MultiMesh` resource that will be used and shared among all instances of the
     * `MultiMeshInstance3D`.
     *
     * Generated from Godot docs: MultiMeshInstance3D.get_multimesh
     */
    fun getMultimesh(): MultiMesh? =
        MultiMesh.wrap(ObjectCalls.ptrcallNoArgsRetObject(getMultimeshBind, handle))

    companion object {
        private const val SET_MULTIMESH_HASH = 2246127404L
        private const val GET_MULTIMESH_HASH = 1385450523L

        private val setMultimeshBind by lazy {
            ObjectCalls.getMethodBind("MultiMeshInstance3D", "set_multimesh", SET_MULTIMESH_HASH)
        }

        private val getMultimeshBind by lazy {
            ObjectCalls.getMethodBind("MultiMeshInstance3D", "get_multimesh", GET_MULTIMESH_HASH)
        }
    }
}
