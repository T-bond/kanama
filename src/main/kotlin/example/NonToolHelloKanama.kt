package net.multigesture.kanama.example

import net.multigesture.kanama.annotations.OnReady
import net.multigesture.kanama.annotations.RegisterClass
import java.lang.foreign.MemorySegment

/**
 * Non-`@Tool` sister of [HelloKanama]. Locks in the editor-gating behaviour
 * for `@RegisterClass`: without `@Tool`, the class is registered with
 * `is_runtime=true`, so Godot substitutes a placeholder in editor mode and
 * the real Kotlin class is never instantiated. In game mode it runs
 * normally.
 *
 * Asserted by:
 * - `tool_smoke.sh` — `_ready` must NOT fire.
 * - `runtime_smoke.sh` — `_ready` MUST fire.
 */
@RegisterClass(parentClassName = "Node")
class NonToolHelloKanama(val godotObject: MemorySegment) {

    @OnReady
    fun ready() {
        System.err.println("[kanama:kt] NonToolHelloKanama._ready fired")
    }
}
