package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.Transform3D
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A tracked body in XR.
 *
 * Generated from Godot docs: XRBodyTracker
 */
class XRBodyTracker(handle: MemorySegment) : XRPositionalTracker(handle) {
    var hasTrackingData: Boolean
        @JvmName("hasTrackingDataProperty")
        get() = getHasTrackingData()
        @JvmName("setHasTrackingDataProperty")
        set(value) = setHasTrackingData(value)

    var bodyFlags: Long
        @JvmName("bodyFlagsProperty")
        get() = getBodyFlags()
        @JvmName("setBodyFlagsProperty")
        set(value) = setBodyFlags(value)

    /**
     * If `true`, the body tracking data is valid.
     *
     * Generated from Godot docs: XRBodyTracker.set_has_tracking_data
     */
    fun setHasTrackingData(hasData: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setHasTrackingDataBind, handle, hasData)
    }

    /**
     * If `true`, the body tracking data is valid.
     *
     * Generated from Godot docs: XRBodyTracker.get_has_tracking_data
     */
    fun getHasTrackingData(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(getHasTrackingDataBind, handle)
    }

    /**
     * The type of body tracking data captured.
     *
     * Generated from Godot docs: XRBodyTracker.set_body_flags
     */
    fun setBodyFlags(flags: Long) {
        ObjectCalls.ptrcallWithLongArg(setBodyFlagsBind, handle, flags)
    }

    /**
     * The type of body tracking data captured.
     *
     * Generated from Godot docs: XRBodyTracker.get_body_flags
     */
    fun getBodyFlags(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getBodyFlagsBind, handle)
    }

    /**
     * Sets flags about the validity of the tracking data for the given body joint.
     *
     * Generated from Godot docs: XRBodyTracker.set_joint_flags
     */
    fun setJointFlags(joint: Long, flags: Long) {
        ObjectCalls.ptrcallWithTwoLongArgs(setJointFlagsBind, handle, joint, flags)
    }

    /**
     * Returns flags about the validity of the tracking data for the given body joint.
     *
     * Generated from Godot docs: XRBodyTracker.get_joint_flags
     */
    fun getJointFlags(joint: Long): Long {
        return ObjectCalls.ptrcallWithLongArgRetLong(getJointFlagsBind, handle, joint)
    }

    /**
     * Sets the transform for the given body joint.
     *
     * Generated from Godot docs: XRBodyTracker.set_joint_transform
     */
    fun setJointTransform(joint: Long, transform: Transform3D) {
        ObjectCalls.ptrcallWithLongAndTransform3DArg(setJointTransformBind, handle, joint, transform)
    }

    /**
     * Returns the transform for the given body joint.
     *
     * Generated from Godot docs: XRBodyTracker.get_joint_transform
     */
    fun getJointTransform(joint: Long): Transform3D {
        return ObjectCalls.ptrcallWithLongArgRetTransform3D(getJointTransformBind, handle, joint)
    }

    companion object {
        private const val SET_HAS_TRACKING_DATA_HASH = 2586408642L
        private val setHasTrackingDataBind by lazy {
            ObjectCalls.getMethodBind("XRBodyTracker", "set_has_tracking_data", SET_HAS_TRACKING_DATA_HASH)
        }

        private const val GET_HAS_TRACKING_DATA_HASH = 36873697L
        private val getHasTrackingDataBind by lazy {
            ObjectCalls.getMethodBind("XRBodyTracker", "get_has_tracking_data", GET_HAS_TRACKING_DATA_HASH)
        }

        private const val SET_BODY_FLAGS_HASH = 2103235750L
        private val setBodyFlagsBind by lazy {
            ObjectCalls.getMethodBind("XRBodyTracker", "set_body_flags", SET_BODY_FLAGS_HASH)
        }

        private const val GET_BODY_FLAGS_HASH = 3543166366L
        private val getBodyFlagsBind by lazy {
            ObjectCalls.getMethodBind("XRBodyTracker", "get_body_flags", GET_BODY_FLAGS_HASH)
        }

        private const val SET_JOINT_FLAGS_HASH = 592144999L
        private val setJointFlagsBind by lazy {
            ObjectCalls.getMethodBind("XRBodyTracker", "set_joint_flags", SET_JOINT_FLAGS_HASH)
        }

        private const val GET_JOINT_FLAGS_HASH = 1030162609L
        private val getJointFlagsBind by lazy {
            ObjectCalls.getMethodBind("XRBodyTracker", "get_joint_flags", GET_JOINT_FLAGS_HASH)
        }

        private const val SET_JOINT_TRANSFORM_HASH = 2635424328L
        private val setJointTransformBind by lazy {
            ObjectCalls.getMethodBind("XRBodyTracker", "set_joint_transform", SET_JOINT_TRANSFORM_HASH)
        }

        private const val GET_JOINT_TRANSFORM_HASH = 3474811534L
        private val getJointTransformBind by lazy {
            ObjectCalls.getMethodBind("XRBodyTracker", "get_joint_transform", GET_JOINT_TRANSFORM_HASH)
        }
    }
}
