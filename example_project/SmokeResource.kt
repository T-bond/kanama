package net.multigesture.kanama.example

import net.multigesture.kanama.annotations.GlobalClass
import net.multigesture.kanama.annotations.ScriptClass
import net.multigesture.kanama.annotations.ScriptProperty
import java.lang.foreign.MemorySegment

@ScriptClass(attachTo = "Resource")
@GlobalClass
class SmokeResource(val godotObject: MemorySegment) {
	@ScriptProperty
	var payload: String = "default"
}
