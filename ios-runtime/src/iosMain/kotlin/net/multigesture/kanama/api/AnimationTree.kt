package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*
import net.multigesture.kanama.types.NodePath

/**
 * Generated from Godot docs: AnimationTree
 */
class AnimationTree(handle: MemorySegment) : AnimationMixer(handle) {
    var advanceExpressionBaseNode: NodePath
        @JvmName("advanceExpressionBaseNodeProperty")
        get() = getAdvanceExpressionBaseNode()
        @JvmName("setAdvanceExpressionBaseNodeProperty")
        set(value) = setAdvanceExpressionBaseNode(value)

    var animPlayer: NodePath
        @JvmName("animPlayerProperty")
        get() = getAnimationPlayer()
        @JvmName("setAnimPlayerProperty")
        set(value) = setAnimationPlayer(value)

    fun setAdvanceExpressionBaseNode(path: NodePath) {
        ObjectCalls.ptrcallWithNodePathArg(setAdvanceExpressionBaseNodeBind, handle, path)
    }

    fun getAdvanceExpressionBaseNode(): NodePath {
        return ObjectCalls.ptrcallNoArgsRetNodePath(getAdvanceExpressionBaseNodeBind, handle)
    }

    fun setAnimationPlayer(path: NodePath) {
        ObjectCalls.ptrcallWithNodePathArg(setAnimationPlayerBind, handle, path)
    }

    fun getAnimationPlayer(): NodePath {
        return ObjectCalls.ptrcallNoArgsRetNodePath(getAnimationPlayerBind, handle)
    }

    fun setProcessCallback(mode: Long) {
        ObjectCalls.ptrcallWithLongArg(setProcessCallbackBind, handle, mode)
    }

    fun getProcessCallback(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getProcessCallbackBind, handle)
    }

    object Signals {
        const val animationPlayerChanged: String = "animation_player_changed"
    }

    companion object {
        const val ANIMATION_PROCESS_PHYSICS: Long = 0L
        const val ANIMATION_PROCESS_IDLE: Long = 1L
        const val ANIMATION_PROCESS_MANUAL: Long = 2L

        fun fromHandle(handle: MemorySegment): AnimationTree? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): AnimationTree? =
            if (handle.address() == 0L) null else AnimationTree(handle)

        private const val SET_ADVANCE_EXPRESSION_BASE_NODE_HASH = 1348162250L
        private val setAdvanceExpressionBaseNodeBind by lazy {
            ObjectCalls.getMethodBind("AnimationTree", "set_advance_expression_base_node", SET_ADVANCE_EXPRESSION_BASE_NODE_HASH)
        }

        private const val GET_ADVANCE_EXPRESSION_BASE_NODE_HASH = 4075236667L
        private val getAdvanceExpressionBaseNodeBind by lazy {
            ObjectCalls.getMethodBind("AnimationTree", "get_advance_expression_base_node", GET_ADVANCE_EXPRESSION_BASE_NODE_HASH)
        }

        private const val SET_ANIMATION_PLAYER_HASH = 1348162250L
        private val setAnimationPlayerBind by lazy {
            ObjectCalls.getMethodBind("AnimationTree", "set_animation_player", SET_ANIMATION_PLAYER_HASH)
        }

        private const val GET_ANIMATION_PLAYER_HASH = 4075236667L
        private val getAnimationPlayerBind by lazy {
            ObjectCalls.getMethodBind("AnimationTree", "get_animation_player", GET_ANIMATION_PLAYER_HASH)
        }

        private const val SET_PROCESS_CALLBACK_HASH = 1723352826L
        private val setProcessCallbackBind by lazy {
            ObjectCalls.getMethodBind("AnimationTree", "set_process_callback", SET_PROCESS_CALLBACK_HASH)
        }

        private const val GET_PROCESS_CALLBACK_HASH = 891317132L
        private val getProcessCallbackBind by lazy {
            ObjectCalls.getMethodBind("AnimationTree", "get_process_callback", GET_PROCESS_CALLBACK_HASH)
        }
    }
}
