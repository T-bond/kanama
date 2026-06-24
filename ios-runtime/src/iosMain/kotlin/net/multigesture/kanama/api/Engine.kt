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

    /** Engine.get_main_loop() — the active MainLoop (the SceneTree) as a raw object handle. */
    fun getMainLoop(): MemorySegment =
        ObjectCalls.ptrcallNoArgsRetObject(getMainLoopBind, singleton)

    private val isEditorHintBind by lazy {
        ObjectCalls.getMethodBind("Engine", "is_editor_hint", 36873697L)
    }
    private val getMainLoopBind by lazy {
        ObjectCalls.getMethodBind("Engine", "get_main_loop", 1016888095L)
    }
}
