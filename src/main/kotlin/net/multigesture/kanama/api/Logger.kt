package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/** Reference-counted custom logger object. Generated from Godot docs: Logger */
/**
 * Custom logger to receive messages from the internal error/warning stream.
 *
 * Generated from Godot docs: Logger
 */
class Logger internal constructor(handle: MemorySegment) : RefCounted(handle) {
    companion object {
        @JvmStatic fun fromHandle(handle: MemorySegment): Logger? = wrap(handle)
        internal fun wrap(handle: MemorySegment): Logger? = if (handle.address() == 0L) null else Logger(handle)
    }
}
