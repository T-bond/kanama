package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*
import net.multigesture.kanama.types.Transform3D

/**
 * Generated from Godot docs: XRServer
 */
object XRServer {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("XRServer")
    }

    const val TRACKER_HEAD: Long = 1L
    const val TRACKER_CONTROLLER: Long = 2L
    const val TRACKER_BASESTATION: Long = 4L
    const val TRACKER_ANCHOR: Long = 8L
    const val TRACKER_HAND: Long = 16L
    const val TRACKER_BODY: Long = 32L
    const val TRACKER_FACE: Long = 64L
    const val TRACKER_ANY_KNOWN: Long = 127L
    const val TRACKER_UNKNOWN: Long = 128L
    const val TRACKER_ANY: Long = 255L
    const val RESET_FULL_ROTATION: Long = 0L
    const val RESET_BUT_KEEP_TILT: Long = 1L
    const val DONT_RESET_ROTATION: Long = 2L

    var worldScale: Double
        @JvmName("worldScaleProperty")
        get() = getWorldScale()
        @JvmName("setWorldScaleProperty")
        set(value) = setWorldScale(value)

    var worldOrigin: Transform3D
        @JvmName("worldOriginProperty")
        get() = getWorldOrigin()
        @JvmName("setWorldOriginProperty")
        set(value) = setWorldOrigin(value)

    var cameraLockedToOrigin: Boolean
        @JvmName("cameraLockedToOriginProperty")
        get() = isCameraLockedToOrigin()
        @JvmName("setCameraLockedToOriginProperty")
        set(value) = setCameraLockedToOrigin(value)

    var primaryInterface: XRInterface?
        @JvmName("primaryInterfaceProperty")
        get() = getPrimaryInterface()
        @JvmName("setPrimaryInterfaceProperty")
        set(value) = setPrimaryInterface(value)

    fun getWorldScale(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getWorldScaleBind, singleton)
    }

    fun setWorldScale(scale: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setWorldScaleBind, singleton, scale)
    }

    fun getWorldOrigin(): Transform3D {
        return ObjectCalls.ptrcallNoArgsRetTransform3D(getWorldOriginBind, singleton)
    }

    fun setWorldOrigin(worldOrigin: Transform3D) {
        ObjectCalls.ptrcallWithTransform3DArg(setWorldOriginBind, singleton, worldOrigin)
    }

    fun getReferenceFrame(): Transform3D {
        return ObjectCalls.ptrcallNoArgsRetTransform3D(getReferenceFrameBind, singleton)
    }

    fun clearReferenceFrame() {
        ObjectCalls.ptrcallNoArgs(clearReferenceFrameBind, singleton)
    }

    fun centerOnHmd(rotationMode: Long, keepHeight: Boolean) {
        ObjectCalls.ptrcallWithLongAndBoolArgs(centerOnHmdBind, singleton, rotationMode, keepHeight)
    }

    fun getHmdTransform(): Transform3D {
        return ObjectCalls.ptrcallNoArgsRetTransform3D(getHmdTransformBind, singleton)
    }

    fun setCameraLockedToOrigin(enabled: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setCameraLockedToOriginBind, singleton, enabled)
    }

    fun isCameraLockedToOrigin(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isCameraLockedToOriginBind, singleton)
    }

    fun addInterface(interfaceValue: XRInterface?) {
        ObjectCalls.ptrcallWithObjectArgs(addInterfaceBind, singleton, listOf(interfaceValue?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    fun getInterfaceCount(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getInterfaceCountBind, singleton)
    }

    fun removeInterface(interfaceValue: XRInterface?) {
        ObjectCalls.ptrcallWithObjectArgs(removeInterfaceBind, singleton, listOf(interfaceValue?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    fun getInterface(idx: Int): XRInterface? {
        return XRInterface.wrap(ObjectCalls.ptrcallWithIntArgRetObject(getInterfaceBind, singleton, idx))
    }

    fun findInterface(name: String): XRInterface? {
        return XRInterface.wrap(ObjectCalls.ptrcallWithStringArgRetObject(findInterfaceBind, singleton, name))
    }

    fun addTracker(tracker: XRTracker?) {
        ObjectCalls.ptrcallWithObjectArgs(addTrackerBind, singleton, listOf(tracker?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    fun removeTracker(tracker: XRTracker?) {
        ObjectCalls.ptrcallWithObjectArgs(removeTrackerBind, singleton, listOf(tracker?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    fun getTracker(trackerName: String): XRTracker? {
        return XRTracker.wrap(ObjectCalls.ptrcallWithStringNameArgRetObject(getTrackerBind, singleton, trackerName))
    }

    fun getPrimaryInterface(): XRInterface? {
        return XRInterface.wrap(ObjectCalls.ptrcallNoArgsRetObject(getPrimaryInterfaceBind, singleton))
    }

    fun setPrimaryInterface(interfaceValue: XRInterface?) {
        ObjectCalls.ptrcallWithObjectArgs(setPrimaryInterfaceBind, singleton, listOf(interfaceValue?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    object Signals {
        const val referenceFrameChanged: String = "reference_frame_changed"
        const val interfaceAdded: String = "interface_added"
        const val interfaceRemoved: String = "interface_removed"
        const val trackerAdded: String = "tracker_added"
        const val trackerUpdated: String = "tracker_updated"
        const val trackerRemoved: String = "tracker_removed"
        const val worldOriginChanged: String = "world_origin_changed"
    }

    fun fromHandle(handle: MemorySegment): XRServer? =
        wrap(handle)

    internal fun wrap(handle: MemorySegment): XRServer? =
        if (handle.address() == 0L) null else this

    private const val GET_WORLD_SCALE_HASH = 1740695150L
    private val getWorldScaleBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "get_world_scale", GET_WORLD_SCALE_HASH)
    }

    private const val SET_WORLD_SCALE_HASH = 373806689L
    private val setWorldScaleBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "set_world_scale", SET_WORLD_SCALE_HASH)
    }

    private const val GET_WORLD_ORIGIN_HASH = 3229777777L
    private val getWorldOriginBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "get_world_origin", GET_WORLD_ORIGIN_HASH)
    }

    private const val SET_WORLD_ORIGIN_HASH = 2952846383L
    private val setWorldOriginBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "set_world_origin", SET_WORLD_ORIGIN_HASH)
    }

    private const val GET_REFERENCE_FRAME_HASH = 3229777777L
    private val getReferenceFrameBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "get_reference_frame", GET_REFERENCE_FRAME_HASH)
    }

    private const val CLEAR_REFERENCE_FRAME_HASH = 3218959716L
    private val clearReferenceFrameBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "clear_reference_frame", CLEAR_REFERENCE_FRAME_HASH)
    }

    private const val CENTER_ON_HMD_HASH = 1450904707L
    private val centerOnHmdBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "center_on_hmd", CENTER_ON_HMD_HASH)
    }

    private const val GET_HMD_TRANSFORM_HASH = 4183770049L
    private val getHmdTransformBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "get_hmd_transform", GET_HMD_TRANSFORM_HASH)
    }

    private const val SET_CAMERA_LOCKED_TO_ORIGIN_HASH = 2586408642L
    private val setCameraLockedToOriginBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "set_camera_locked_to_origin", SET_CAMERA_LOCKED_TO_ORIGIN_HASH)
    }

    private const val IS_CAMERA_LOCKED_TO_ORIGIN_HASH = 36873697L
    private val isCameraLockedToOriginBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "is_camera_locked_to_origin", IS_CAMERA_LOCKED_TO_ORIGIN_HASH)
    }

    private const val ADD_INTERFACE_HASH = 1898711491L
    private val addInterfaceBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "add_interface", ADD_INTERFACE_HASH)
    }

    private const val GET_INTERFACE_COUNT_HASH = 3905245786L
    private val getInterfaceCountBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "get_interface_count", GET_INTERFACE_COUNT_HASH)
    }

    private const val REMOVE_INTERFACE_HASH = 1898711491L
    private val removeInterfaceBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "remove_interface", REMOVE_INTERFACE_HASH)
    }

    private const val GET_INTERFACE_HASH = 4237347919L
    private val getInterfaceBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "get_interface", GET_INTERFACE_HASH)
    }

    private const val FIND_INTERFACE_HASH = 1395192955L
    private val findInterfaceBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "find_interface", FIND_INTERFACE_HASH)
    }

    private const val ADD_TRACKER_HASH = 684804553L
    private val addTrackerBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "add_tracker", ADD_TRACKER_HASH)
    }

    private const val REMOVE_TRACKER_HASH = 684804553L
    private val removeTrackerBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "remove_tracker", REMOVE_TRACKER_HASH)
    }

    private const val GET_TRACKER_HASH = 147382240L
    private val getTrackerBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "get_tracker", GET_TRACKER_HASH)
    }

    private const val GET_PRIMARY_INTERFACE_HASH = 2143545064L
    private val getPrimaryInterfaceBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "get_primary_interface", GET_PRIMARY_INTERFACE_HASH)
    }

    private const val SET_PRIMARY_INTERFACE_HASH = 1898711491L
    private val setPrimaryInterfaceBind by lazy {
        ObjectCalls.getMethodBind("XRServer", "set_primary_interface", SET_PRIMARY_INTERFACE_HASH)
    }
}
