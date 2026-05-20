package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A node that may modify a Skeleton3D's bones.
 *
 * Generated from Godot docs: SkeletonModifier3D
 */
open class SkeletonModifier3D(handle: MemorySegment) : Node3D(handle) {
    var active: Boolean
        @JvmName("activeProperty")
        get() = isActive()
        @JvmName("setActiveProperty")
        set(value) = setActive(value)

    var influence: Double
        @JvmName("influenceProperty")
        get() = getInfluence()
        @JvmName("setInfluenceProperty")
        set(value) = setInfluence(value)

    /**
     * Returns the parent `Skeleton3D` node if it exists. Otherwise, returns `null`.
     *
     * Generated from Godot docs: SkeletonModifier3D.get_skeleton
     */
    fun getSkeleton(): Skeleton3D? {
        return Skeleton3D.wrap(ObjectCalls.ptrcallNoArgsRetObject(getSkeletonBind, handle))
    }

    /**
     * If `true`, the `SkeletonModifier3D` will be processing.
     *
     * Generated from Godot docs: SkeletonModifier3D.set_active
     */
    fun setActive(active: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setActiveBind, handle, active)
    }

    /**
     * If `true`, the `SkeletonModifier3D` will be processing.
     *
     * Generated from Godot docs: SkeletonModifier3D.is_active
     */
    fun isActive(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isActiveBind, handle)
    }

    /**
     * Sets the influence of the modification. Note: This value is used by `Skeleton3D` to blend, so
     * the `SkeletonModifier3D` should always apply only 100% of the result without interpolation.
     *
     * Generated from Godot docs: SkeletonModifier3D.set_influence
     */
    fun setInfluence(influence: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setInfluenceBind, handle, influence)
    }

    /**
     * Sets the influence of the modification. Note: This value is used by `Skeleton3D` to blend, so
     * the `SkeletonModifier3D` should always apply only 100% of the result without interpolation.
     *
     * Generated from Godot docs: SkeletonModifier3D.get_influence
     */
    fun getInfluence(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getInfluenceBind, handle)
    }

    object Signals {
        const val modificationProcessed: String = "modification_processed"
    }

    companion object {
        private const val GET_SKELETON_HASH = 1488626673L
        private val getSkeletonBind by lazy {
            ObjectCalls.getMethodBind("SkeletonModifier3D", "get_skeleton", GET_SKELETON_HASH)
        }

        private const val SET_ACTIVE_HASH = 2586408642L
        private val setActiveBind by lazy {
            ObjectCalls.getMethodBind("SkeletonModifier3D", "set_active", SET_ACTIVE_HASH)
        }

        private const val IS_ACTIVE_HASH = 36873697L
        private val isActiveBind by lazy {
            ObjectCalls.getMethodBind("SkeletonModifier3D", "is_active", IS_ACTIVE_HASH)
        }

        private const val SET_INFLUENCE_HASH = 373806689L
        private val setInfluenceBind by lazy {
            ObjectCalls.getMethodBind("SkeletonModifier3D", "set_influence", SET_INFLUENCE_HASH)
        }

        private const val GET_INFLUENCE_HASH = 1740695150L
        private val getInfluenceBind by lazy {
            ObjectCalls.getMethodBind("SkeletonModifier3D", "get_influence", GET_INFLUENCE_HASH)
        }
    }
}
