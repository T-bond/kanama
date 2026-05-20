package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.Quaternion
import net.multigesture.kanama.types.Vector3
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: OpenXRInterface
 */
class OpenXRInterface(handle: MemorySegment) : XRInterface(handle) {
    var displayRefreshRate: Double
        @JvmName("displayRefreshRateProperty")
        get() = getDisplayRefreshRate()
        @JvmName("setDisplayRefreshRateProperty")
        set(value) = setDisplayRefreshRate(value)

    var renderTargetSizeMultiplier: Double
        @JvmName("renderTargetSizeMultiplierProperty")
        get() = getRenderTargetSizeMultiplier()
        @JvmName("setRenderTargetSizeMultiplierProperty")
        set(value) = setRenderTargetSizeMultiplier(value)

    var foveationLevel: Int
        @JvmName("foveationLevelProperty")
        get() = getFoveationLevel()
        @JvmName("setFoveationLevelProperty")
        set(value) = setFoveationLevel(value)

    var foveationDynamic: Boolean
        @JvmName("foveationDynamicProperty")
        get() = getFoveationDynamic()
        @JvmName("setFoveationDynamicProperty")
        set(value) = setFoveationDynamic(value)

    var vrsMinRadius: Double
        @JvmName("vrsMinRadiusProperty")
        get() = getVrsMinRadius()
        @JvmName("setVrsMinRadiusProperty")
        set(value) = setVrsMinRadius(value)

    var vrsStrength: Double
        @JvmName("vrsStrengthProperty")
        get() = getVrsStrength()
        @JvmName("setVrsStrengthProperty")
        set(value) = setVrsStrength(value)

    fun getSessionState(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getSessionStateBind, handle)
    }

    fun getDisplayRefreshRate(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getDisplayRefreshRateBind, handle)
    }

    fun setDisplayRefreshRate(refreshRate: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setDisplayRefreshRateBind, handle, refreshRate)
    }

    fun getRenderTargetSizeMultiplier(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getRenderTargetSizeMultiplierBind, handle)
    }

    fun setRenderTargetSizeMultiplier(multiplier: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setRenderTargetSizeMultiplierBind, handle, multiplier)
    }

    fun isFoveationSupported(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isFoveationSupportedBind, handle)
    }

    fun getFoveationLevel(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getFoveationLevelBind, handle)
    }

    fun setFoveationLevel(foveationLevel: Int) {
        ObjectCalls.ptrcallWithIntArg(setFoveationLevelBind, handle, foveationLevel)
    }

    fun getFoveationDynamic(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(getFoveationDynamicBind, handle)
    }

    fun setFoveationDynamic(foveationDynamic: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setFoveationDynamicBind, handle, foveationDynamic)
    }

    fun isActionSetActive(name: String): Boolean {
        return ObjectCalls.ptrcallWithStringArgRetBool(isActionSetActiveBind, handle, name)
    }

    fun setActionSetActive(name: String, active: Boolean) {
        ObjectCalls.ptrcallWithStringAndBoolArg(setActionSetActiveBind, handle, name, active)
    }

    fun getActionSets(): List<Any?> {
        return ObjectCalls.ptrcallNoArgsRetArray(getActionSetsBind, handle)
    }

    fun getAvailableDisplayRefreshRates(): List<Any?> {
        return ObjectCalls.ptrcallNoArgsRetArray(getAvailableDisplayRefreshRatesBind, handle)
    }

    fun setMotionRange(hand: Long, motionRange: Long) {
        ObjectCalls.ptrcallWithTwoLongArgs(setMotionRangeBind, handle, hand, motionRange)
    }

    fun getMotionRange(hand: Long): Long {
        return ObjectCalls.ptrcallWithLongArgRetLong(getMotionRangeBind, handle, hand)
    }

    fun getHandTrackingSource(hand: Long): Long {
        return ObjectCalls.ptrcallWithLongArgRetLong(getHandTrackingSourceBind, handle, hand)
    }

    fun getHandJointFlags(hand: Long, joint: Long): Long {
        return ObjectCalls.ptrcallWithTwoLongArgsRetLong(getHandJointFlagsBind, handle, hand, joint)
    }

    fun getHandJointRotation(hand: Long, joint: Long): Quaternion {
        return ObjectCalls.ptrcallWithTwoLongArgsRetQuaternion(getHandJointRotationBind, handle, hand, joint)
    }

    fun getHandJointPosition(hand: Long, joint: Long): Vector3 {
        return ObjectCalls.ptrcallWithTwoLongArgsRetVector3(getHandJointPositionBind, handle, hand, joint)
    }

    fun getHandJointRadius(hand: Long, joint: Long): Double {
        return ObjectCalls.ptrcallWithTwoLongArgsRetDouble(getHandJointRadiusBind, handle, hand, joint)
    }

    fun getHandJointLinearVelocity(hand: Long, joint: Long): Vector3 {
        return ObjectCalls.ptrcallWithTwoLongArgsRetVector3(getHandJointLinearVelocityBind, handle, hand, joint)
    }

    fun getHandJointAngularVelocity(hand: Long, joint: Long): Vector3 {
        return ObjectCalls.ptrcallWithTwoLongArgsRetVector3(getHandJointAngularVelocityBind, handle, hand, joint)
    }

    fun isHandTrackingSupported(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isHandTrackingSupportedBind, handle)
    }

    fun isHandInteractionSupported(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isHandInteractionSupportedBind, handle)
    }

    fun isEyeGazeInteractionSupported(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isEyeGazeInteractionSupportedBind, handle)
    }

    fun getVrsMinRadius(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getVrsMinRadiusBind, handle)
    }

    fun setVrsMinRadius(radius: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setVrsMinRadiusBind, handle, radius)
    }

    fun getVrsStrength(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getVrsStrengthBind, handle)
    }

    fun setVrsStrength(strength: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setVrsStrengthBind, handle, strength)
    }

    fun setCpuLevel(level: Long) {
        ObjectCalls.ptrcallWithLongArg(setCpuLevelBind, handle, level)
    }

    fun setGpuLevel(level: Long) {
        ObjectCalls.ptrcallWithLongArg(setGpuLevelBind, handle, level)
    }

    object Signals {
        const val sessionBegun: String = "session_begun"
        const val sessionStopping: String = "session_stopping"
        const val sessionSynchronized: String = "session_synchronized"
        const val sessionFocussed: String = "session_focussed"
        const val sessionVisible: String = "session_visible"
        const val sessionLossPending: String = "session_loss_pending"
        const val instanceExiting: String = "instance_exiting"
        const val poseRecentered: String = "pose_recentered"
        const val refreshRateChanged: String = "refresh_rate_changed"
        const val cpuLevelChanged: String = "cpu_level_changed"
        const val gpuLevelChanged: String = "gpu_level_changed"
    }

    companion object {
        private const val GET_SESSION_STATE_HASH = 896364779L
        private val getSessionStateBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_session_state", GET_SESSION_STATE_HASH)
        }

        private const val GET_DISPLAY_REFRESH_RATE_HASH = 1740695150L
        private val getDisplayRefreshRateBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_display_refresh_rate", GET_DISPLAY_REFRESH_RATE_HASH)
        }

        private const val SET_DISPLAY_REFRESH_RATE_HASH = 373806689L
        private val setDisplayRefreshRateBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "set_display_refresh_rate", SET_DISPLAY_REFRESH_RATE_HASH)
        }

        private const val GET_RENDER_TARGET_SIZE_MULTIPLIER_HASH = 1740695150L
        private val getRenderTargetSizeMultiplierBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_render_target_size_multiplier", GET_RENDER_TARGET_SIZE_MULTIPLIER_HASH)
        }

        private const val SET_RENDER_TARGET_SIZE_MULTIPLIER_HASH = 373806689L
        private val setRenderTargetSizeMultiplierBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "set_render_target_size_multiplier", SET_RENDER_TARGET_SIZE_MULTIPLIER_HASH)
        }

        private const val IS_FOVEATION_SUPPORTED_HASH = 36873697L
        private val isFoveationSupportedBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "is_foveation_supported", IS_FOVEATION_SUPPORTED_HASH)
        }

        private const val GET_FOVEATION_LEVEL_HASH = 3905245786L
        private val getFoveationLevelBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_foveation_level", GET_FOVEATION_LEVEL_HASH)
        }

        private const val SET_FOVEATION_LEVEL_HASH = 1286410249L
        private val setFoveationLevelBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "set_foveation_level", SET_FOVEATION_LEVEL_HASH)
        }

        private const val GET_FOVEATION_DYNAMIC_HASH = 36873697L
        private val getFoveationDynamicBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_foveation_dynamic", GET_FOVEATION_DYNAMIC_HASH)
        }

        private const val SET_FOVEATION_DYNAMIC_HASH = 2586408642L
        private val setFoveationDynamicBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "set_foveation_dynamic", SET_FOVEATION_DYNAMIC_HASH)
        }

        private const val IS_ACTION_SET_ACTIVE_HASH = 3927539163L
        private val isActionSetActiveBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "is_action_set_active", IS_ACTION_SET_ACTIVE_HASH)
        }

        private const val SET_ACTION_SET_ACTIVE_HASH = 2678287736L
        private val setActionSetActiveBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "set_action_set_active", SET_ACTION_SET_ACTIVE_HASH)
        }

        private const val GET_ACTION_SETS_HASH = 3995934104L
        private val getActionSetsBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_action_sets", GET_ACTION_SETS_HASH)
        }

        private const val GET_AVAILABLE_DISPLAY_REFRESH_RATES_HASH = 3995934104L
        private val getAvailableDisplayRefreshRatesBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_available_display_refresh_rates", GET_AVAILABLE_DISPLAY_REFRESH_RATES_HASH)
        }

        private const val SET_MOTION_RANGE_HASH = 855158159L
        private val setMotionRangeBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "set_motion_range", SET_MOTION_RANGE_HASH)
        }

        private const val GET_MOTION_RANGE_HASH = 3955838114L
        private val getMotionRangeBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_motion_range", GET_MOTION_RANGE_HASH)
        }

        private const val GET_HAND_TRACKING_SOURCE_HASH = 4092421202L
        private val getHandTrackingSourceBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_hand_tracking_source", GET_HAND_TRACKING_SOURCE_HASH)
        }

        private const val GET_HAND_JOINT_FLAGS_HASH = 720567706L
        private val getHandJointFlagsBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_hand_joint_flags", GET_HAND_JOINT_FLAGS_HASH)
        }

        private const val GET_HAND_JOINT_ROTATION_HASH = 1974618321L
        private val getHandJointRotationBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_hand_joint_rotation", GET_HAND_JOINT_ROTATION_HASH)
        }

        private const val GET_HAND_JOINT_POSITION_HASH = 3529194242L
        private val getHandJointPositionBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_hand_joint_position", GET_HAND_JOINT_POSITION_HASH)
        }

        private const val GET_HAND_JOINT_RADIUS_HASH = 901522724L
        private val getHandJointRadiusBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_hand_joint_radius", GET_HAND_JOINT_RADIUS_HASH)
        }

        private const val GET_HAND_JOINT_LINEAR_VELOCITY_HASH = 3529194242L
        private val getHandJointLinearVelocityBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_hand_joint_linear_velocity", GET_HAND_JOINT_LINEAR_VELOCITY_HASH)
        }

        private const val GET_HAND_JOINT_ANGULAR_VELOCITY_HASH = 3529194242L
        private val getHandJointAngularVelocityBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_hand_joint_angular_velocity", GET_HAND_JOINT_ANGULAR_VELOCITY_HASH)
        }

        private const val IS_HAND_TRACKING_SUPPORTED_HASH = 2240911060L
        private val isHandTrackingSupportedBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "is_hand_tracking_supported", IS_HAND_TRACKING_SUPPORTED_HASH)
        }

        private const val IS_HAND_INTERACTION_SUPPORTED_HASH = 36873697L
        private val isHandInteractionSupportedBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "is_hand_interaction_supported", IS_HAND_INTERACTION_SUPPORTED_HASH)
        }

        private const val IS_EYE_GAZE_INTERACTION_SUPPORTED_HASH = 2240911060L
        private val isEyeGazeInteractionSupportedBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "is_eye_gaze_interaction_supported", IS_EYE_GAZE_INTERACTION_SUPPORTED_HASH)
        }

        private const val GET_VRS_MIN_RADIUS_HASH = 1740695150L
        private val getVrsMinRadiusBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_vrs_min_radius", GET_VRS_MIN_RADIUS_HASH)
        }

        private const val SET_VRS_MIN_RADIUS_HASH = 373806689L
        private val setVrsMinRadiusBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "set_vrs_min_radius", SET_VRS_MIN_RADIUS_HASH)
        }

        private const val GET_VRS_STRENGTH_HASH = 1740695150L
        private val getVrsStrengthBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "get_vrs_strength", GET_VRS_STRENGTH_HASH)
        }

        private const val SET_VRS_STRENGTH_HASH = 373806689L
        private val setVrsStrengthBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "set_vrs_strength", SET_VRS_STRENGTH_HASH)
        }

        private const val SET_CPU_LEVEL_HASH = 2940842095L
        private val setCpuLevelBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "set_cpu_level", SET_CPU_LEVEL_HASH)
        }

        private const val SET_GPU_LEVEL_HASH = 2940842095L
        private val setGpuLevelBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInterface", "set_gpu_level", SET_GPU_LEVEL_HASH)
        }
    }
}
