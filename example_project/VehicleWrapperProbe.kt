package net.multigesture.kanama.example

import net.multigesture.kanama.annotations.ScriptClass
import net.multigesture.kanama.annotations.ScriptProperty
import net.multigesture.kanama.api.VehicleBody3D
import net.multigesture.kanama.api.VehicleWheel3D
import java.lang.foreign.MemorySegment

@ScriptClass(attachTo = "Node")
class VehicleWrapperProbe(val godotObject: MemorySegment) {
	@ScriptProperty
	var vehicle: VehicleBody3D? = null

	@ScriptProperty
	var frontLeftWheel: VehicleWheel3D? = null
}
