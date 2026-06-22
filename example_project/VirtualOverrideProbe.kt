package net.multigesture.kanama.example

import net.multigesture.kanama.annotations.OverrideVirtual
import net.multigesture.kanama.annotations.ScriptClass
import net.multigesture.kanama.api.Control
import net.multigesture.kanama.api.KanamaScript
import net.multigesture.kanama.types.Vector2
import java.lang.foreign.MemorySegment

/**
 * Phase 5.2 probe: exercises `@OverrideVirtual` for arbitrary, value-returning
 * engine virtuals beyond the fixed lifecycle set. Attaches to `Control` and
 * overrides two of its virtuals — one returning a `Vector2`, one taking a
 * `Vector2` and returning a `Bool` — so the generated registrar must validate
 * the signatures against the engine table and emit return marshalling for both.
 */
@ScriptClass(attachTo = "Control")
class VirtualOverrideProbe(godotObject: MemorySegment) : KanamaScript<Control>(godotObject, ::Control) {

    @OverrideVirtual("_get_minimum_size")
    fun minimumSize(): Vector2 = Vector2(64.0f, 32.0f)

    @OverrideVirtual("_has_point")
    fun hasPoint(at: Vector2): Boolean = at.x >= 0.0f && at.y >= 0.0f
}
