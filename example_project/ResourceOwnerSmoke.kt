package net.multigesture.kanama.example

import net.multigesture.kanama.annotations.OnReady
import net.multigesture.kanama.annotations.ScriptClass
import net.multigesture.kanama.annotations.ScriptProperty
import java.lang.foreign.MemorySegment

@ScriptClass(attachTo = "Node")
class ResourceOwnerSmoke(val godotObject: MemorySegment) {
	@ScriptProperty
	var smokeResource: SmokeResource? = null

	@OnReady
	fun ready() {
		System.err.println("[kanama:kt] ResourceOwnerSmoke payload=${smokeResource?.payload} present=${smokeResource != null}")
	}
}
