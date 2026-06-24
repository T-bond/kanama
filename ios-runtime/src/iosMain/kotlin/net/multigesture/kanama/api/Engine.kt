package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls

// KANAMA-IOS-HANDWRITTEN: [glue] Engine singleton (engine global), mirroring OS.kt's getSingleton pattern.
object Engine {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("Engine")
    }

    fun isEditorHint(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isEditorHintBind, singleton)

    private val isEditorHintBind by lazy {
        ObjectCalls.getMethodBind("Engine", "is_editor_hint", 36873697L)
    }
}
