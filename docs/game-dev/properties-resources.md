# Exports and Resources

Kanama exposes inspector-visible properties with annotations and maps common
Godot resources to Kotlin wrapper types.

## Exported Properties

Use `@ScriptProperty` on `@ScriptClass` scripts and `@RegisterProperty` on
registered classes. `@Export` is available as a migration-friendly alias.

```kotlin
@ScriptClass(attachTo = "Node")
class Player(godotObject: MemorySegment) :
    KanamaScript<Node>(godotObject, ::Node) {
    @ExportGroup("Movement")
    @ScriptProperty
    var speed: Double = 5.0

    @ExportSubgroup("Jump")
    @ScriptProperty
    var jumpVelocity: Double = 8.0
}
```

Simple source-literal defaults are preserved in generated script registrars:
numeric, boolean, string, `NodePath("...")`, and `Math.toRadians(<number>)`
initializers show up as inspector defaults.

## Node References

Exported node references should use the target wrapper type when the original
GDScript exported an object reference:

```kotlin
@ScriptProperty
var crosshair: TextureRect? = null
```

Use `NodePath` only when the original script intentionally exposed a path value:

```kotlin
@ScriptProperty
var viewPath: NodePath = NodePath("../View")
```

## Resource Ownership

Godot `Resource` and `RefCounted` wrappers returned by Kanama APIs are
closeable Kotlin handles. When you load a temporary resource and hand it to a
Godot node, release the temporary wrapper with `use` or `close` after the node
has accepted the value:

```kotlin
ResourceLoader.loadAudioStream("res://sounds/jump.ogg")?.use { stream ->
    player.setStream(stream)
}
```

For more detail, see [Calling Godot APIs](godot-api.md#resource-ownership).

## Custom Resources

Declare same-project resource scripts as global classes when another script
needs to export them:

```kotlin
@ScriptClass(attachTo = "Resource")
@GlobalClass
class Weapon(godotObject: MemorySegment)
```

Another script can then export `Weapon?` or `List<Weapon>`, and Kanama resolves
the live Kotlin resource script instances when reading the property.
