package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.RID
import java.lang.foreign.MemorySegment

/**
 * Generated from Godot docs: OpenXRSpatialContextPersistenceConfig
 */
class OpenXRSpatialContextPersistenceConfig(handle: MemorySegment) : OpenXRStructureBase(handle) {
    fun addPersistenceContext(persistenceContext: RID) {
        ObjectCalls.ptrcallWithRIDArg(addPersistenceContextBind, handle, persistenceContext)
    }

    fun removePersistenceContext(persistenceContext: RID) {
        ObjectCalls.ptrcallWithRIDArg(removePersistenceContextBind, handle, persistenceContext)
    }

    companion object {
        private const val ADD_PERSISTENCE_CONTEXT_HASH = 2722037293L
        private val addPersistenceContextBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialContextPersistenceConfig", "add_persistence_context", ADD_PERSISTENCE_CONTEXT_HASH)
        }

        private const val REMOVE_PERSISTENCE_CONTEXT_HASH = 2722037293L
        private val removePersistenceContextBind by lazy {
            ObjectCalls.getMethodBind("OpenXRSpatialContextPersistenceConfig", "remove_persistence_context", REMOVE_PERSISTENCE_CONTEXT_HASH)
        }
    }
}
