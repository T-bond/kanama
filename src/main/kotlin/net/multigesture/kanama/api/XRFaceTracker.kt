package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A tracked face.
 *
 * Generated from Godot docs: XRFaceTracker
 */
class XRFaceTracker(handle: MemorySegment) : XRTracker(handle) {
    var blendShapes: List<Float>
        @JvmName("blendShapesProperty")
        get() = getBlendShapes()
        @JvmName("setBlendShapesProperty")
        set(value) = setBlendShapes(value)

    /**
     * Returns the requested face blend shape weight.
     *
     * Generated from Godot docs: XRFaceTracker.get_blend_shape
     */
    fun getBlendShape(blendShape: Long): Double {
        return ObjectCalls.ptrcallWithLongArgRetDouble(getBlendShapeBind, handle, blendShape)
    }

    /**
     * Sets a face blend shape weight.
     *
     * Generated from Godot docs: XRFaceTracker.set_blend_shape
     */
    fun setBlendShape(blendShape: Long, weight: Double) {
        ObjectCalls.ptrcallWithLongAndDoubleArg(setBlendShapeBind, handle, blendShape, weight)
    }

    /**
     * The array of face blend shape weights with indices corresponding to the `BlendShapeEntry` enum.
     *
     * Generated from Godot docs: XRFaceTracker.get_blend_shapes
     */
    fun getBlendShapes(): List<Float> {
        return ObjectCalls.ptrcallNoArgsRetPackedFloat32List(getBlendShapesBind, handle)
    }

    /**
     * The array of face blend shape weights with indices corresponding to the `BlendShapeEntry` enum.
     *
     * Generated from Godot docs: XRFaceTracker.set_blend_shapes
     */
    fun setBlendShapes(weights: List<Float>) {
        ObjectCalls.ptrcallWithPackedFloat32ListArg(setBlendShapesBind, handle, weights)
    }

    companion object {
        private const val GET_BLEND_SHAPE_HASH = 330010046L
        private val getBlendShapeBind by lazy {
            ObjectCalls.getMethodBind("XRFaceTracker", "get_blend_shape", GET_BLEND_SHAPE_HASH)
        }

        private const val SET_BLEND_SHAPE_HASH = 2352588791L
        private val setBlendShapeBind by lazy {
            ObjectCalls.getMethodBind("XRFaceTracker", "set_blend_shape", SET_BLEND_SHAPE_HASH)
        }

        private const val GET_BLEND_SHAPES_HASH = 675695659L
        private val getBlendShapesBind by lazy {
            ObjectCalls.getMethodBind("XRFaceTracker", "get_blend_shapes", GET_BLEND_SHAPES_HASH)
        }

        private const val SET_BLEND_SHAPES_HASH = 2899603908L
        private val setBlendShapesBind by lazy {
            ObjectCalls.getMethodBind("XRFaceTracker", "set_blend_shapes", SET_BLEND_SHAPES_HASH)
        }
    }
}
