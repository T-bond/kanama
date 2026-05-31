package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * An optimized translation.
 *
 * Generated from Godot docs: OptimizedTranslation
 */
class OptimizedTranslation(handle: MemorySegment) : Translation(handle) {
    /**
     * Generates and sets an optimized translation from the given `Translation` resource. Returns
     * `true` if successful. Note: Messages in `from` should not use context or plural forms. Note:
     * This method is intended to be used in the editor. It does nothing when called from an exported
     * project.
     *
     * Generated from Godot docs: OptimizedTranslation.generate
     */
    fun generate(from: Translation?) {
        ObjectCalls.ptrcallWithObjectArgs(generateBind, handle, listOf(from?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    companion object {
        private const val GENERATE_HASH = 1466479800L
        private val generateBind by lazy {
            ObjectCalls.getMethodBind("OptimizedTranslation", "generate", GENERATE_HASH)
        }
    }
}
