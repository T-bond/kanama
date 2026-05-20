package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Base class for `AnimationNode`s that hold one or multiple composite animations. Usually used for
 * `AnimationTree.tree_root`.
 *
 * Generated from Godot docs: AnimationRootNode
 */
open class AnimationRootNode internal constructor(handle: MemorySegment) : AnimationNode(handle) {
    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): AnimationRootNode? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AnimationRootNode? =
            if (handle.address() == 0L) null else AnimationRootNode(handle)
    }
}
