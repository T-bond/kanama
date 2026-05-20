package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.RID
import java.lang.foreign.MemorySegment

/**
 * A 3D raycast that dynamically moves its children near the collision point.
 *
 * Generated from Godot docs: SpringArm3D
 */
class SpringArm3D(handle: MemorySegment) : Node3D(handle) {

    var collisionMask: Long
        @JvmName("collisionMaskProperty")
        get() = getCollisionMask()
        @JvmName("setCollisionMaskProperty")
        set(value) = setCollisionMask(value)

    var shape: Shape3D?
        @JvmName("shapeProperty")
        get() = getShape()
        @JvmName("setShapeProperty")
        set(value) = setShape(value)

    var springLength: Double
        @JvmName("springLengthProperty")
        get() = getLength()
        @JvmName("setSpringLengthProperty")
        set(value) = setLength(value)

    var margin: Double
        @JvmName("marginProperty")
        get() = getMargin()
        @JvmName("setMarginProperty")
        set(value) = setMargin(value)

    /**
     * Returns the spring arm's current length.
     *
     * Generated from Godot docs: SpringArm3D.get_hit_length
     */
    fun getHitLength(): Double =
        ObjectCalls.ptrcallNoArgsRetDouble(getHitLengthBind, handle)

    /**
     * The maximum extent of the SpringArm3D. This is used as a length for both the ray and the shape
     * cast used internally to calculate the desired position of the SpringArm3D's child nodes. To know
     * more about how to perform a shape cast or a ray cast, please consult the
     * `PhysicsDirectSpaceState3D` documentation.
     *
     * Generated from Godot docs: SpringArm3D.set_length
     */
    fun setLength(length: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setLengthBind, handle, length)
    }

    /**
     * The maximum extent of the SpringArm3D. This is used as a length for both the ray and the shape
     * cast used internally to calculate the desired position of the SpringArm3D's child nodes. To know
     * more about how to perform a shape cast or a ray cast, please consult the
     * `PhysicsDirectSpaceState3D` documentation.
     *
     * Generated from Godot docs: SpringArm3D.get_length
     */
    fun getLength(): Double =
        ObjectCalls.ptrcallNoArgsRetDouble(getLengthBind, handle)

    /**
     * The `Shape3D` to use for the SpringArm3D. When the shape is set, the SpringArm3D will cast the
     * `Shape3D` on its z axis instead of performing a ray cast.
     *
     * Generated from Godot docs: SpringArm3D.set_shape
     */
    fun setShape(shape: Shape3D?) {
        ObjectCalls.ptrcallWithObjectArgs(
            setShapeBind,
            handle,
            listOf(shape?.requireOpenHandle() ?: MemorySegment.NULL),
        )
    }

    /**
     * The `Shape3D` to use for the SpringArm3D. When the shape is set, the SpringArm3D will cast the
     * `Shape3D` on its z axis instead of performing a ray cast.
     *
     * Generated from Godot docs: SpringArm3D.get_shape
     */
    fun getShape(): Shape3D? =
        Shape3D.wrap(ObjectCalls.ptrcallNoArgsRetObject(getShapeBind, handle))

    /**
     * Adds the `PhysicsBody3D` object with the given `RID` to the list of `PhysicsBody3D` objects
     * excluded from the collision check.
     *
     * Generated from Godot docs: SpringArm3D.add_excluded_object
     */
    fun addExcludedObject(rid: RID) {
        ObjectCalls.ptrcallWithRIDArg(addExcludedObjectBind, handle, rid)
    }

    /**
     * Removes the given `RID` from the list of `PhysicsBody3D` objects excluded from the collision
     * check.
     *
     * Generated from Godot docs: SpringArm3D.remove_excluded_object
     */
    fun removeExcludedObject(rid: RID): Boolean =
        ObjectCalls.ptrcallWithRIDArgRetBool(removeExcludedObjectBind, handle, rid)

    /**
     * Clears the list of `PhysicsBody3D` objects excluded from the collision check.
     *
     * Generated from Godot docs: SpringArm3D.clear_excluded_objects
     */
    fun clearExcludedObjects() {
        ObjectCalls.ptrcallNoArgs(clearExcludedObjectsBind, handle)
    }

    /**
     * The layers against which the collision check will be done. See Collision layers and masks
     * ($DOCS_URL/tutorials/physics/physics_introduction.html#collision-layers-and-masks) in the
     * documentation for more information.
     *
     * Generated from Godot docs: SpringArm3D.set_collision_mask
     */
    fun setCollisionMask(mask: Long) {
        ObjectCalls.ptrcallWithUInt32Arg(setCollisionMaskBind, handle, mask)
    }

    /**
     * The layers against which the collision check will be done. See Collision layers and masks
     * ($DOCS_URL/tutorials/physics/physics_introduction.html#collision-layers-and-masks) in the
     * documentation for more information.
     *
     * Generated from Godot docs: SpringArm3D.get_collision_mask
     */
    fun getCollisionMask(): Long =
        ObjectCalls.ptrcallNoArgsRetUInt32(getCollisionMaskBind, handle)

    /**
     * When the collision check is made, a candidate length for the SpringArm3D is given. The margin is
     * then subtracted to this length and the translation is applied to the child objects of the
     * SpringArm3D. This margin is useful for when the SpringArm3D has a `Camera3D` as a child node:
     * without the margin, the `Camera3D` would be placed on the exact point of collision, while with
     * the margin the `Camera3D` would be placed close to the point of collision.
     *
     * Generated from Godot docs: SpringArm3D.set_margin
     */
    fun setMargin(margin: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setMarginBind, handle, margin)
    }

    /**
     * When the collision check is made, a candidate length for the SpringArm3D is given. The margin is
     * then subtracted to this length and the translation is applied to the child objects of the
     * SpringArm3D. This margin is useful for when the SpringArm3D has a `Camera3D` as a child node:
     * without the margin, the `Camera3D` would be placed on the exact point of collision, while with
     * the margin the `Camera3D` would be placed close to the point of collision.
     *
     * Generated from Godot docs: SpringArm3D.get_margin
     */
    fun getMargin(): Double =
        ObjectCalls.ptrcallNoArgsRetDouble(getMarginBind, handle)

    companion object {
        private const val GET_HIT_LENGTH_HASH = 191475506L
        private const val SET_LENGTH_HASH = 373806689L
        private const val GET_LENGTH_HASH = 1740695150L
        private const val SET_SHAPE_HASH = 1549710052L
        private const val GET_SHAPE_HASH = 3214262478L
        private const val ADD_EXCLUDED_OBJECT_HASH = 2722037293L
        private const val REMOVE_EXCLUDED_OBJECT_HASH = 3521089500L
        private const val CLEAR_EXCLUDED_OBJECTS_HASH = 3218959716L
        private const val SET_COLLISION_MASK_HASH = 1286410249L
        private const val GET_COLLISION_MASK_HASH = 2455072627L
        private const val SET_MARGIN_HASH = 373806689L
        private const val GET_MARGIN_HASH = 191475506L

        private val getHitLengthBind by lazy {
            ObjectCalls.getMethodBind("SpringArm3D", "get_hit_length", GET_HIT_LENGTH_HASH)
        }

        private val setLengthBind by lazy {
            ObjectCalls.getMethodBind("SpringArm3D", "set_length", SET_LENGTH_HASH)
        }

        private val getLengthBind by lazy {
            ObjectCalls.getMethodBind("SpringArm3D", "get_length", GET_LENGTH_HASH)
        }

        private val setShapeBind by lazy {
            ObjectCalls.getMethodBind("SpringArm3D", "set_shape", SET_SHAPE_HASH)
        }

        private val getShapeBind by lazy {
            ObjectCalls.getMethodBind("SpringArm3D", "get_shape", GET_SHAPE_HASH)
        }

        private val addExcludedObjectBind by lazy {
            ObjectCalls.getMethodBind("SpringArm3D", "add_excluded_object", ADD_EXCLUDED_OBJECT_HASH)
        }

        private val removeExcludedObjectBind by lazy {
            ObjectCalls.getMethodBind("SpringArm3D", "remove_excluded_object", REMOVE_EXCLUDED_OBJECT_HASH)
        }

        private val clearExcludedObjectsBind by lazy {
            ObjectCalls.getMethodBind("SpringArm3D", "clear_excluded_objects", CLEAR_EXCLUDED_OBJECTS_HASH)
        }

        private val setCollisionMaskBind by lazy {
            ObjectCalls.getMethodBind("SpringArm3D", "set_collision_mask", SET_COLLISION_MASK_HASH)
        }

        private val getCollisionMaskBind by lazy {
            ObjectCalls.getMethodBind("SpringArm3D", "get_collision_mask", GET_COLLISION_MASK_HASH)
        }

        private val setMarginBind by lazy {
            ObjectCalls.getMethodBind("SpringArm3D", "set_margin", SET_MARGIN_HASH)
        }

        private val getMarginBind by lazy {
            ObjectCalls.getMethodBind("SpringArm3D", "get_margin", GET_MARGIN_HASH)
        }
    }
}
