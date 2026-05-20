package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: CSGPrimitive3D
 */
open class CSGPrimitive3D(handle: MemorySegment) : CSGShape3D(handle) {
    var flipFaces: Boolean
        @JvmName("flipFacesProperty")
        get() = getFlipFaces()
        @JvmName("setFlipFacesProperty")
        set(value) = setFlipFaces(value)

    fun setFlipFaces(flipFaces: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setFlipFacesBind, handle, flipFaces)
    }

    fun getFlipFaces(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(getFlipFacesBind, handle)
    }

    companion object {
        private const val SET_FLIP_FACES_HASH = 2586408642L
        private val setFlipFacesBind by lazy {
            ObjectCalls.getMethodBind("CSGPrimitive3D", "set_flip_faces", SET_FLIP_FACES_HASH)
        }

        private const val GET_FLIP_FACES_HASH = 2240911060L
        private val getFlipFacesBind by lazy {
            ObjectCalls.getMethodBind("CSGPrimitive3D", "get_flip_faces", GET_FLIP_FACES_HASH)
        }
    }
}
