package net.multigesture.kanama.example

import net.multigesture.kanama.annotations.ScriptClass
import net.multigesture.kanama.annotations.ScriptProperty
import net.multigesture.kanama.api.KanamaScript
import net.multigesture.kanama.api.Node
import net.multigesture.kanama.types.NodePath
import java.lang.foreign.MemorySegment

@ScriptClass(attachTo = "Node")
class DefaultProbeScript(godotObject: MemorySegment) : KanamaScript<Node>(godotObject, ::Node) {
	private val node = self

	@ScriptProperty
	var amount: Long = 250

	@ScriptProperty
	var target: NodePath = NodePath("../SceneTarget3D")
}
