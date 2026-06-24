package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls

// KANAMA-IOS-HANDWRITTEN: [glue] Time singleton (engine global), mirroring OS.kt's getSingleton pattern.
object Time {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("Time")
    }

    fun getTicksMsec(): Long =
        ObjectCalls.ptrcallNoArgsRetLong(getTicksMsecBind, singleton)

    private val getTicksMsecBind by lazy {
        ObjectCalls.getMethodBind("Time", "get_ticks_msec", 3905245786L)
    }
}
