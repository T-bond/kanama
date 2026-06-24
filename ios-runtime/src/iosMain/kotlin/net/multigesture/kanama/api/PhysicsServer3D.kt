package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*
import net.multigesture.kanama.types.RID

// KANAMA-IOS-HANDWRITTEN: [glue] PhysicsServer3D singleton (engine global), mirroring OS.kt.
object PhysicsServer3D {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("PhysicsServer3D")
    }

    fun bodyAddCollisionException(body: RID, exceptedBody: RID) =
        ObjectCalls.ptrcallWithTwoRIDArgs(bodyAddCollisionExceptionBind, singleton, body, exceptedBody)

    private val bodyAddCollisionExceptionBind by lazy {
        ObjectCalls.getMethodBind("PhysicsServer3D", "body_add_collision_exception", 395945892L)
    }
}
