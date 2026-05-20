package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Generated from Godot docs: OpenXRInteractionProfileEditorBase
 */
open class OpenXRInteractionProfileEditorBase(handle: MemorySegment) : HBoxContainer(handle) {
    fun setup(actionMap: OpenXRActionMap?, interactionProfile: OpenXRInteractionProfile?) {
        ObjectCalls.ptrcallWithTwoObjectArgs(setupBind, handle, actionMap?.requireOpenHandle() ?: MemorySegment.NULL, interactionProfile?.requireOpenHandle() ?: MemorySegment.NULL)
    }

    companion object {
        private const val SETUP_HASH = 421962938L
        private val setupBind by lazy {
            ObjectCalls.getMethodBind("OpenXRInteractionProfileEditorBase", "setup", SETUP_HASH)
        }
    }
}
