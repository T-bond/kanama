package net.multigesture.kanama.api

/**
 * Marks low-level Godot lifetime operations that are easy to misuse in gameplay code.
 *
 * Most game scripts should release objects through Godot lifecycle APIs such as
 * `queueFree()`, `kill()`, clearing a node property, or dropping Kotlin references.
 * Opt in only when the value is known to be caller-owned and Godot will not keep
 * using it after the call.
 */
@RequiresOptIn(
    message = "Manual Godot lifetime APIs are for low-level interop. Gameplay scripts should use Godot lifecycle APIs unless this value is explicitly caller-owned.",
    level = RequiresOptIn.Level.WARNING,
)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ManualGodotLifetimeApi
