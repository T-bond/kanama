package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * AudioStream that lets the user play custom streams at any time from code, simultaneously using a
 * single player.
 *
 * Generated from Godot docs: AudioStreamPolyphonic
 */
class AudioStreamPolyphonic(handle: MemorySegment) : AudioStream(handle) {
    var polyphony: Int
        @JvmName("polyphonyProperty")
        get() = getPolyphony()
        @JvmName("setPolyphonyProperty")
        set(value) = setPolyphony(value)

    /**
     * Maximum amount of simultaneous streams that can be played.
     *
     * Generated from Godot docs: AudioStreamPolyphonic.set_polyphony
     */
    fun setPolyphony(voices: Int) {
        ObjectCalls.ptrcallWithIntArg(setPolyphonyBind, handle, voices)
    }

    /**
     * Maximum amount of simultaneous streams that can be played.
     *
     * Generated from Godot docs: AudioStreamPolyphonic.get_polyphony
     */
    fun getPolyphony(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getPolyphonyBind, handle)
    }

    companion object {
        private const val SET_POLYPHONY_HASH = 1286410249L
        private val setPolyphonyBind by lazy {
            ObjectCalls.getMethodBind("AudioStreamPolyphonic", "set_polyphony", SET_POLYPHONY_HASH)
        }

        private const val GET_POLYPHONY_HASH = 3905245786L
        private val getPolyphonyBind by lazy {
            ObjectCalls.getMethodBind("AudioStreamPolyphonic", "get_polyphony", GET_POLYPHONY_HASH)
        }
    }
}
