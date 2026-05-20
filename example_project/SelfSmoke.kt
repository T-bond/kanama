package net.multigesture.kanama.example

import net.multigesture.kanama.annotations.OnReady
import net.multigesture.kanama.annotations.ScriptClass
import net.multigesture.kanama.api.KanamaScript
import net.multigesture.kanama.api.Node
import net.multigesture.kanama.api.Node3D
import java.lang.foreign.MemorySegment

@ScriptClass(attachTo = "Node3D")
class SelfSmoke(godotObject: MemorySegment) : KanamaScript<Node3D>(godotObject, ::Node3D) {
    private val node = selfAs(::Node)

    @OnReady
    fun ready() {
        val sameObject = self.getInstanceId() == node.getInstanceId()
        System.err.println("[kanama:kt] SelfSmoke self_class=${self.getClassName()} same_object=$sameObject")
    }
}
