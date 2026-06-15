package net.multigesture.kanama.iosgatefixture

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.annotations.OnInput
import net.multigesture.kanama.annotations.OnProcess
import net.multigesture.kanama.annotations.OnReady
import net.multigesture.kanama.annotations.RegisterFunction
import net.multigesture.kanama.annotations.ScriptClass
import net.multigesture.kanama.annotations.ScriptProperty
import net.multigesture.kanama.annotations.Signal
import net.multigesture.kanama.api.GodotObject
import net.multigesture.kanama.api.KanamaScript
import net.multigesture.kanama.api.Label

// Parallel-run gate fixture (Phase 3.2). Exercises the common iOS bridge shapes so the
// `checkIosScriptRegistryParity` task can prove the KSP processor emits the same registry as
// the legacy regex parser: ZERO/DOUBLE/OBJECT/LONG bridge kinds, a zero-arg helper method, a
// scalar Long + String @ScriptProperty, and a @Signal. Uses only iOS-available wrappers.
@ScriptClass(attachTo = "Label")
class GateFixtureScript(godotObject: MemorySegment) : KanamaScript<Label>(godotObject, ::Label) {
    @ScriptProperty
    var score: Long = 0L

    @ScriptProperty
    var title: String = ""

    @OnReady
    fun ready() {
        self.text = "gate fixture ready"
    }

    @OnProcess
    fun process(delta: Double) {
        score += delta.toLong()
    }

    @OnInput
    fun input(event: GodotObject) {
        score += 1L
    }

    @RegisterFunction("add_points")
    fun addPoints(amount: Long) {
        score += amount
    }

    @RegisterFunction
    fun resetScore() {
        score = 0L
    }

    @Signal
    fun scored() {}
}
