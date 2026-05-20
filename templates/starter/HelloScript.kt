package com.example.game

import net.multigesture.kanama.annotations.ClassName
import net.multigesture.kanama.annotations.Export
import net.multigesture.kanama.annotations.OnPhysicsProcess
import net.multigesture.kanama.annotations.OnReady
import net.multigesture.kanama.annotations.RegisterFunction
import net.multigesture.kanama.annotations.ScriptClass
import net.multigesture.kanama.annotations.Tool
import java.lang.foreign.MemorySegment

@ScriptClass(attachTo = "Node2D")
@ClassName
@Tool
class HelloScript(val godotObject: MemorySegment) {
    @Export(hint = 1, hintString = "0,1000,1")
    var speed: Long = 120

    @OnReady
    fun ready() {
        System.err.println("[kanama:starter] HelloScript ready speed=$speed")
    }

    @OnPhysicsProcess
    fun physicsProcess(delta: Double) {
    }

    @RegisterFunction
    fun greet(name: String): String = "Hello $name from Kanama"
}
