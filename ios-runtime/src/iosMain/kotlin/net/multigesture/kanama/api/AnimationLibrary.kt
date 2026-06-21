package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AnimationLibrary
 */
class AnimationLibrary(handle: MemorySegment) : Resource(handle) {
    fun removeAnimation(name: String) {
        ObjectCalls.ptrcallWithStringNameArg(removeAnimationBind, handle, name)
    }

    fun renameAnimation(name: String, newname: String) {
        ObjectCalls.ptrcallWithTwoStringNameArgs(renameAnimationBind, handle, name, newname)
    }

    fun hasAnimation(name: String): Boolean {
        return ObjectCalls.ptrcallWithStringNameArgRetBool(hasAnimationBind, handle, name)
    }

    fun getAnimationList(): List<String> {
        return ObjectCalls.ptrcallNoArgsRetStringNameList(getAnimationListBind, handle)
    }

    fun getAnimationListSize(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getAnimationListSizeBind, handle)
    }

    object Signals {
        const val animationAdded: String = "animation_added"
        const val animationRemoved: String = "animation_removed"
        const val animationRenamed: String = "animation_renamed"
        const val animationChanged: String = "animation_changed"
    }

    companion object {
        fun fromHandle(handle: MemorySegment): AnimationLibrary? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AnimationLibrary? =
            if (handle.address() == 0L) null else AnimationLibrary(handle)

        private const val REMOVE_ANIMATION_HASH = 3304788590L
        private val removeAnimationBind by lazy {
            ObjectCalls.getMethodBind("AnimationLibrary", "remove_animation", REMOVE_ANIMATION_HASH)
        }

        private const val RENAME_ANIMATION_HASH = 3740211285L
        private val renameAnimationBind by lazy {
            ObjectCalls.getMethodBind("AnimationLibrary", "rename_animation", RENAME_ANIMATION_HASH)
        }

        private const val HAS_ANIMATION_HASH = 2619796661L
        private val hasAnimationBind by lazy {
            ObjectCalls.getMethodBind("AnimationLibrary", "has_animation", HAS_ANIMATION_HASH)
        }

        private const val GET_ANIMATION_LIST_HASH = 3995934104L
        private val getAnimationListBind by lazy {
            ObjectCalls.getMethodBind("AnimationLibrary", "get_animation_list", GET_ANIMATION_LIST_HASH)
        }

        private const val GET_ANIMATION_LIST_SIZE_HASH = 3905245786L
        private val getAnimationListSizeBind by lazy {
            ObjectCalls.getMethodBind("AnimationLibrary", "get_animation_list_size", GET_ANIMATION_LIST_SIZE_HASH)
        }
    }
}
