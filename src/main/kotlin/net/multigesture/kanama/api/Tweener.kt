package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Abstract class for all Tweeners used by `Tween`.
 *
 * Tweeners returned by `tweenProperty`, `tweenMethod`, `tweenCallback`, and related APIs are
 * owned by their parent `Tween`. Configure them fluently, but do not call `close()` on them
 * immediately after scheduling animation work.
 *
 * Generated from Godot docs: Tweener
 */
open class Tweener internal constructor(handle: MemorySegment) : RefCounted(handle)
