package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.types.Color
import net.multigesture.kanama.types.Vector2
import net.multigesture.kanama.types.Vector3
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Holds a particle configuration for `GPUParticles2D` or `GPUParticles3D` nodes.
 *
 * Generated from Godot docs: ParticleProcessMaterial
 */
class ParticleProcessMaterial(handle: MemorySegment) : Material(handle) {
    var lifetimeRandomness: Double
        @JvmName("lifetimeRandomnessProperty")
        get() = getLifetimeRandomness()
        @JvmName("setLifetimeRandomnessProperty")
        set(value) = setLifetimeRandomness(value)

    var emissionShapeOffset: Vector3
        @JvmName("emissionShapeOffsetProperty")
        get() = getEmissionShapeOffset()
        @JvmName("setEmissionShapeOffsetProperty")
        set(value) = setEmissionShapeOffset(value)

    var emissionShapeScale: Vector3
        @JvmName("emissionShapeScaleProperty")
        get() = getEmissionShapeScale()
        @JvmName("setEmissionShapeScaleProperty")
        set(value) = setEmissionShapeScale(value)

    var emissionShape: Long
        @JvmName("emissionShapeProperty")
        get() = getEmissionShape()
        @JvmName("setEmissionShapeProperty")
        set(value) = setEmissionShape(value)

    var emissionSphereRadius: Double
        @JvmName("emissionSphereRadiusProperty")
        get() = getEmissionSphereRadius()
        @JvmName("setEmissionSphereRadiusProperty")
        set(value) = setEmissionSphereRadius(value)

    var emissionBoxExtents: Vector3
        @JvmName("emissionBoxExtentsProperty")
        get() = getEmissionBoxExtents()
        @JvmName("setEmissionBoxExtentsProperty")
        set(value) = setEmissionBoxExtents(value)

    var emissionPointTexture: Texture2D?
        @JvmName("emissionPointTextureProperty")
        get() = getEmissionPointTexture()
        @JvmName("setEmissionPointTextureProperty")
        set(value) = setEmissionPointTexture(value)

    var emissionNormalTexture: Texture2D?
        @JvmName("emissionNormalTextureProperty")
        get() = getEmissionNormalTexture()
        @JvmName("setEmissionNormalTextureProperty")
        set(value) = setEmissionNormalTexture(value)

    var emissionColorTexture: Texture2D?
        @JvmName("emissionColorTextureProperty")
        get() = getEmissionColorTexture()
        @JvmName("setEmissionColorTextureProperty")
        set(value) = setEmissionColorTexture(value)

    var emissionPointCount: Int
        @JvmName("emissionPointCountProperty")
        get() = getEmissionPointCount()
        @JvmName("setEmissionPointCountProperty")
        set(value) = setEmissionPointCount(value)

    var emissionRingAxis: Vector3
        @JvmName("emissionRingAxisProperty")
        get() = getEmissionRingAxis()
        @JvmName("setEmissionRingAxisProperty")
        set(value) = setEmissionRingAxis(value)

    var emissionRingHeight: Double
        @JvmName("emissionRingHeightProperty")
        get() = getEmissionRingHeight()
        @JvmName("setEmissionRingHeightProperty")
        set(value) = setEmissionRingHeight(value)

    var emissionRingRadius: Double
        @JvmName("emissionRingRadiusProperty")
        get() = getEmissionRingRadius()
        @JvmName("setEmissionRingRadiusProperty")
        set(value) = setEmissionRingRadius(value)

    var emissionRingInnerRadius: Double
        @JvmName("emissionRingInnerRadiusProperty")
        get() = getEmissionRingInnerRadius()
        @JvmName("setEmissionRingInnerRadiusProperty")
        set(value) = setEmissionRingInnerRadius(value)

    var emissionRingConeAngle: Double
        @JvmName("emissionRingConeAngleProperty")
        get() = getEmissionRingConeAngle()
        @JvmName("setEmissionRingConeAngleProperty")
        set(value) = setEmissionRingConeAngle(value)

    var inheritVelocityRatio: Double
        @JvmName("inheritVelocityRatioProperty")
        get() = getInheritVelocityRatio()
        @JvmName("setInheritVelocityRatioProperty")
        set(value) = setInheritVelocityRatio(value)

    var velocityPivot: Vector3
        @JvmName("velocityPivotProperty")
        get() = getVelocityPivot()
        @JvmName("setVelocityPivotProperty")
        set(value) = setVelocityPivot(value)

    var direction: Vector3
        @JvmName("directionProperty")
        get() = getDirection()
        @JvmName("setDirectionProperty")
        set(value) = setDirection(value)

    var spread: Double
        @JvmName("spreadProperty")
        get() = getSpread()
        @JvmName("setSpreadProperty")
        set(value) = setSpread(value)

    var flatness: Double
        @JvmName("flatnessProperty")
        get() = getFlatness()
        @JvmName("setFlatnessProperty")
        set(value) = setFlatness(value)

    var velocityLimitCurve: Texture2D?
        @JvmName("velocityLimitCurveProperty")
        get() = getVelocityLimitCurve()
        @JvmName("setVelocityLimitCurveProperty")
        set(value) = setVelocityLimitCurve(value)

    var gravity: Vector3
        @JvmName("gravityProperty")
        get() = getGravity()
        @JvmName("setGravityProperty")
        set(value) = setGravity(value)

    var attractorInteractionEnabled: Boolean
        @JvmName("attractorInteractionEnabledProperty")
        get() = isAttractorInteractionEnabled()
        @JvmName("setAttractorInteractionEnabledProperty")
        set(value) = setAttractorInteractionEnabled(value)

    var color: Color
        @JvmName("colorProperty")
        get() = getColor()
        @JvmName("setColorProperty")
        set(value) = setColor(value)

    var colorRamp: Texture2D?
        @JvmName("colorRampProperty")
        get() = getColorRamp()
        @JvmName("setColorRampProperty")
        set(value) = setColorRamp(value)

    var colorInitialRamp: Texture2D?
        @JvmName("colorInitialRampProperty")
        get() = getColorInitialRamp()
        @JvmName("setColorInitialRampProperty")
        set(value) = setColorInitialRamp(value)

    var alphaCurve: Texture2D?
        @JvmName("alphaCurveProperty")
        get() = getAlphaCurve()
        @JvmName("setAlphaCurveProperty")
        set(value) = setAlphaCurve(value)

    var emissionCurve: Texture2D?
        @JvmName("emissionCurveProperty")
        get() = getEmissionCurve()
        @JvmName("setEmissionCurveProperty")
        set(value) = setEmissionCurve(value)

    var turbulenceEnabled: Boolean
        @JvmName("turbulenceEnabledProperty")
        get() = getTurbulenceEnabled()
        @JvmName("setTurbulenceEnabledProperty")
        set(value) = setTurbulenceEnabled(value)

    var turbulenceNoiseStrength: Double
        @JvmName("turbulenceNoiseStrengthProperty")
        get() = getTurbulenceNoiseStrength()
        @JvmName("setTurbulenceNoiseStrengthProperty")
        set(value) = setTurbulenceNoiseStrength(value)

    var turbulenceNoiseScale: Double
        @JvmName("turbulenceNoiseScaleProperty")
        get() = getTurbulenceNoiseScale()
        @JvmName("setTurbulenceNoiseScaleProperty")
        set(value) = setTurbulenceNoiseScale(value)

    var turbulenceNoiseSpeed: Vector3
        @JvmName("turbulenceNoiseSpeedProperty")
        get() = getTurbulenceNoiseSpeed()
        @JvmName("setTurbulenceNoiseSpeedProperty")
        set(value) = setTurbulenceNoiseSpeed(value)

    var turbulenceNoiseSpeedRandom: Double
        @JvmName("turbulenceNoiseSpeedRandomProperty")
        get() = getTurbulenceNoiseSpeedRandom()
        @JvmName("setTurbulenceNoiseSpeedRandomProperty")
        set(value) = setTurbulenceNoiseSpeedRandom(value)

    var collisionMode: Long
        @JvmName("collisionModeProperty")
        get() = getCollisionMode()
        @JvmName("setCollisionModeProperty")
        set(value) = setCollisionMode(value)

    var collisionFriction: Double
        @JvmName("collisionFrictionProperty")
        get() = getCollisionFriction()
        @JvmName("setCollisionFrictionProperty")
        set(value) = setCollisionFriction(value)

    var collisionBounce: Double
        @JvmName("collisionBounceProperty")
        get() = getCollisionBounce()
        @JvmName("setCollisionBounceProperty")
        set(value) = setCollisionBounce(value)

    var collisionUseScale: Boolean
        @JvmName("collisionUseScaleProperty")
        get() = isCollisionUsingScale()
        @JvmName("setCollisionUseScaleProperty")
        set(value) = setCollisionUseScale(value)

    var subEmitterMode: Long
        @JvmName("subEmitterModeProperty")
        get() = getSubEmitterMode()
        @JvmName("setSubEmitterModeProperty")
        set(value) = setSubEmitterMode(value)

    var subEmitterFrequency: Double
        @JvmName("subEmitterFrequencyProperty")
        get() = getSubEmitterFrequency()
        @JvmName("setSubEmitterFrequencyProperty")
        set(value) = setSubEmitterFrequency(value)

    var subEmitterAmountAtEnd: Int
        @JvmName("subEmitterAmountAtEndProperty")
        get() = getSubEmitterAmountAtEnd()
        @JvmName("setSubEmitterAmountAtEndProperty")
        set(value) = setSubEmitterAmountAtEnd(value)

    var subEmitterAmountAtCollision: Int
        @JvmName("subEmitterAmountAtCollisionProperty")
        get() = getSubEmitterAmountAtCollision()
        @JvmName("setSubEmitterAmountAtCollisionProperty")
        set(value) = setSubEmitterAmountAtCollision(value)

    var subEmitterAmountAtStart: Int
        @JvmName("subEmitterAmountAtStartProperty")
        get() = getSubEmitterAmountAtStart()
        @JvmName("setSubEmitterAmountAtStartProperty")
        set(value) = setSubEmitterAmountAtStart(value)

    var subEmitterKeepVelocity: Boolean
        @JvmName("subEmitterKeepVelocityProperty")
        get() = getSubEmitterKeepVelocity()
        @JvmName("setSubEmitterKeepVelocityProperty")
        set(value) = setSubEmitterKeepVelocity(value)

    /**
     * Unit vector specifying the particles' emission direction.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_direction
     */
    fun setDirection(degrees: Vector3) {
        ObjectCalls.ptrcallWithVector3Arg(setDirectionBind, handle, degrees)
    }

    /**
     * Unit vector specifying the particles' emission direction.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_direction
     */
    fun getDirection(): Vector3 {
        return ObjectCalls.ptrcallNoArgsRetVector3(getDirectionBind, handle)
    }

    /**
     * Percentage of the velocity of the respective `GPUParticles2D` or `GPUParticles3D` inherited by
     * each particle when spawning.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_inherit_velocity_ratio
     */
    fun setInheritVelocityRatio(ratio: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setInheritVelocityRatioBind, handle, ratio)
    }

    /**
     * Percentage of the velocity of the respective `GPUParticles2D` or `GPUParticles3D` inherited by
     * each particle when spawning.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_inherit_velocity_ratio
     */
    fun getInheritVelocityRatio(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getInheritVelocityRatioBind, handle)
    }

    /**
     * Each particle's initial direction range from `+spread` to `-spread` degrees.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_spread
     */
    fun setSpread(degrees: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setSpreadBind, handle, degrees)
    }

    /**
     * Each particle's initial direction range from `+spread` to `-spread` degrees.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_spread
     */
    fun getSpread(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getSpreadBind, handle)
    }

    /**
     * Amount of `spread` along the Y axis.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_flatness
     */
    fun setFlatness(amount: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setFlatnessBind, handle, amount)
    }

    /**
     * Amount of `spread` along the Y axis.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_flatness
     */
    fun getFlatness(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getFlatnessBind, handle)
    }

    /**
     * Sets the minimum and maximum values of the given `param`. The `x` component of the argument
     * vector corresponds to minimum and the `y` component corresponds to maximum.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_param
     */
    fun setParam(param: Long, value: Vector2) {
        ObjectCalls.ptrcallWithLongAndVector2Arg(setParamBind, handle, param, value)
    }

    /**
     * Returns the minimum and maximum values of the given `param` as a vector. The `x` component of
     * the returned vector corresponds to minimum and the `y` component corresponds to maximum.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_param
     */
    fun getParam(param: Long): Vector2 {
        return ObjectCalls.ptrcallWithLongArgRetVector2(getParamBind, handle, param)
    }

    /**
     * Minimum displacement of each particle's spawn position by the turbulence. The actual amount of
     * displacement will be a factor of the underlying turbulence multiplied by a random value between
     * `turbulence_initial_displacement_min` and `turbulence_initial_displacement_max`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_param_min
     */
    fun setParamMin(param: Long, value: Double) {
        ObjectCalls.ptrcallWithLongAndDoubleArg(setParamMinBind, handle, param, value)
    }

    /**
     * Minimum displacement of each particle's spawn position by the turbulence. The actual amount of
     * displacement will be a factor of the underlying turbulence multiplied by a random value between
     * `turbulence_initial_displacement_min` and `turbulence_initial_displacement_max`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_param_min
     */
    fun getParamMin(param: Long): Double {
        return ObjectCalls.ptrcallWithLongArgRetDouble(getParamMinBind, handle, param)
    }

    /**
     * Maximum displacement of each particle's spawn position by the turbulence. The actual amount of
     * displacement will be a factor of the underlying turbulence multiplied by a random value between
     * `turbulence_initial_displacement_min` and `turbulence_initial_displacement_max`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_param_max
     */
    fun setParamMax(param: Long, value: Double) {
        ObjectCalls.ptrcallWithLongAndDoubleArg(setParamMaxBind, handle, param, value)
    }

    /**
     * Maximum displacement of each particle's spawn position by the turbulence. The actual amount of
     * displacement will be a factor of the underlying turbulence multiplied by a random value between
     * `turbulence_initial_displacement_min` and `turbulence_initial_displacement_max`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_param_max
     */
    fun getParamMax(param: Long): Double {
        return ObjectCalls.ptrcallWithLongArgRetDouble(getParamMaxBind, handle, param)
    }

    /**
     * Each particle's amount of turbulence will be influenced along this `CurveTexture` over its life
     * time.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_param_texture
     */
    fun setParamTexture(param: Long, texture: Texture2D?) {
        ObjectCalls.ptrcallWithLongAndObjectArg(setParamTextureBind, handle, param, texture?.requireOpenHandle() ?: MemorySegment.NULL)
    }

    /**
     * Each particle's amount of turbulence will be influenced along this `CurveTexture` over its life
     * time.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_param_texture
     */
    fun getParamTexture(param: Long): Texture2D? {
        return Texture2D.wrap(ObjectCalls.ptrcallWithLongArgRetObject(getParamTextureBind, handle, param))
    }

    /**
     * Each particle's initial color. If the `GPUParticles2D`'s `texture` is defined, it will be
     * multiplied by this color. Note: `color` multiplies the particle mesh's vertex colors. To have a
     * visible effect on a `BaseMaterial3D`, `BaseMaterial3D.vertex_color_use_as_albedo` must be
     * `true`. For a `ShaderMaterial`, `ALBEDO *= COLOR.rgb;` must be inserted in the shader's
     * `fragment()` function. Otherwise, `color` will have no visible effect.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_color
     */
    fun setColor(color: Color) {
        ObjectCalls.ptrcallWithColorArg(setColorBind, handle, color)
    }

    /**
     * Each particle's initial color. If the `GPUParticles2D`'s `texture` is defined, it will be
     * multiplied by this color. Note: `color` multiplies the particle mesh's vertex colors. To have a
     * visible effect on a `BaseMaterial3D`, `BaseMaterial3D.vertex_color_use_as_albedo` must be
     * `true`. For a `ShaderMaterial`, `ALBEDO *= COLOR.rgb;` must be inserted in the shader's
     * `fragment()` function. Otherwise, `color` will have no visible effect.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_color
     */
    fun getColor(): Color {
        return ObjectCalls.ptrcallNoArgsRetColor(getColorBind, handle)
    }

    /**
     * Each particle's color will vary along this `GradientTexture1D` over its lifetime (multiplied
     * with `color`). Note: `color_ramp` multiplies the particle mesh's vertex colors. To have a
     * visible effect on a `BaseMaterial3D`, `BaseMaterial3D.vertex_color_use_as_albedo` must be
     * `true`. For a `ShaderMaterial`, `ALBEDO *= COLOR.rgb;` must be inserted in the shader's
     * `fragment()` function. Otherwise, `color_ramp` will have no visible effect.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_color_ramp
     */
    fun setColorRamp(ramp: Texture2D?) {
        ObjectCalls.ptrcallWithObjectArgs(setColorRampBind, handle, listOf(ramp?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    /**
     * Each particle's color will vary along this `GradientTexture1D` over its lifetime (multiplied
     * with `color`). Note: `color_ramp` multiplies the particle mesh's vertex colors. To have a
     * visible effect on a `BaseMaterial3D`, `BaseMaterial3D.vertex_color_use_as_albedo` must be
     * `true`. For a `ShaderMaterial`, `ALBEDO *= COLOR.rgb;` must be inserted in the shader's
     * `fragment()` function. Otherwise, `color_ramp` will have no visible effect.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_color_ramp
     */
    fun getColorRamp(): Texture2D? {
        return Texture2D.wrap(ObjectCalls.ptrcallNoArgsRetObject(getColorRampBind, handle))
    }

    /**
     * The alpha value of each particle's color will be multiplied by this `CurveTexture` over its
     * lifetime. Note: `alpha_curve` multiplies the particle mesh's vertex colors. To have a visible
     * effect on a `BaseMaterial3D`, `BaseMaterial3D.vertex_color_use_as_albedo` must be `true`. For a
     * `ShaderMaterial`, `ALPHA *= COLOR.a;` must be inserted in the shader's `fragment()` function.
     * Otherwise, `alpha_curve` will have no visible effect.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_alpha_curve
     */
    fun setAlphaCurve(curve: Texture2D?) {
        ObjectCalls.ptrcallWithObjectArgs(setAlphaCurveBind, handle, listOf(curve?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    /**
     * The alpha value of each particle's color will be multiplied by this `CurveTexture` over its
     * lifetime. Note: `alpha_curve` multiplies the particle mesh's vertex colors. To have a visible
     * effect on a `BaseMaterial3D`, `BaseMaterial3D.vertex_color_use_as_albedo` must be `true`. For a
     * `ShaderMaterial`, `ALPHA *= COLOR.a;` must be inserted in the shader's `fragment()` function.
     * Otherwise, `alpha_curve` will have no visible effect.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_alpha_curve
     */
    fun getAlphaCurve(): Texture2D? {
        return Texture2D.wrap(ObjectCalls.ptrcallNoArgsRetObject(getAlphaCurveBind, handle))
    }

    /**
     * Each particle's color will be multiplied by this `CurveTexture` over its lifetime. Note:
     * `emission_curve` multiplies the particle mesh's vertex colors. To have a visible effect on a
     * `BaseMaterial3D`, `BaseMaterial3D.vertex_color_use_as_albedo` must be `true`. For a
     * `ShaderMaterial`, `ALBEDO *= COLOR.rgb;` must be inserted in the shader's `fragment()` function.
     * Otherwise, `emission_curve` will have no visible effect.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_curve
     */
    fun setEmissionCurve(curve: Texture2D?) {
        ObjectCalls.ptrcallWithObjectArgs(setEmissionCurveBind, handle, listOf(curve?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    /**
     * Each particle's color will be multiplied by this `CurveTexture` over its lifetime. Note:
     * `emission_curve` multiplies the particle mesh's vertex colors. To have a visible effect on a
     * `BaseMaterial3D`, `BaseMaterial3D.vertex_color_use_as_albedo` must be `true`. For a
     * `ShaderMaterial`, `ALBEDO *= COLOR.rgb;` must be inserted in the shader's `fragment()` function.
     * Otherwise, `emission_curve` will have no visible effect.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_curve
     */
    fun getEmissionCurve(): Texture2D? {
        return Texture2D.wrap(ObjectCalls.ptrcallNoArgsRetObject(getEmissionCurveBind, handle))
    }

    /**
     * Each particle's initial color will vary along this `GradientTexture1D` (multiplied with
     * `color`). Note: `color_initial_ramp` multiplies the particle mesh's vertex colors. To have a
     * visible effect on a `BaseMaterial3D`, `BaseMaterial3D.vertex_color_use_as_albedo` must be
     * `true`. For a `ShaderMaterial`, `ALBEDO *= COLOR.rgb;` must be inserted in the shader's
     * `fragment()` function. Otherwise, `color_initial_ramp` will have no visible effect.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_color_initial_ramp
     */
    fun setColorInitialRamp(ramp: Texture2D?) {
        ObjectCalls.ptrcallWithObjectArgs(setColorInitialRampBind, handle, listOf(ramp?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    /**
     * Each particle's initial color will vary along this `GradientTexture1D` (multiplied with
     * `color`). Note: `color_initial_ramp` multiplies the particle mesh's vertex colors. To have a
     * visible effect on a `BaseMaterial3D`, `BaseMaterial3D.vertex_color_use_as_albedo` must be
     * `true`. For a `ShaderMaterial`, `ALBEDO *= COLOR.rgb;` must be inserted in the shader's
     * `fragment()` function. Otherwise, `color_initial_ramp` will have no visible effect.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_color_initial_ramp
     */
    fun getColorInitialRamp(): Texture2D? {
        return Texture2D.wrap(ObjectCalls.ptrcallNoArgsRetObject(getColorInitialRampBind, handle))
    }

    /**
     * A `CurveTexture` that defines the maximum velocity of a particle during its lifetime.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_velocity_limit_curve
     */
    fun setVelocityLimitCurve(curve: Texture2D?) {
        ObjectCalls.ptrcallWithObjectArgs(setVelocityLimitCurveBind, handle, listOf(curve?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    /**
     * A `CurveTexture` that defines the maximum velocity of a particle during its lifetime.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_velocity_limit_curve
     */
    fun getVelocityLimitCurve(): Texture2D? {
        return Texture2D.wrap(ObjectCalls.ptrcallNoArgsRetObject(getVelocityLimitCurveBind, handle))
    }

    /**
     * If `true`, particles rotate around Y axis by `angle_min`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_particle_flag
     */
    fun setParticleFlag(particleFlag: Long, enable: Boolean) {
        ObjectCalls.ptrcallWithLongAndBoolArgs(setParticleFlagBind, handle, particleFlag, enable)
    }

    /**
     * If `true`, particles rotate around Y axis by `angle_min`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_particle_flag
     */
    fun getParticleFlag(particleFlag: Long): Boolean {
        return ObjectCalls.ptrcallWithLongArgRetBool(getParticleFlagBind, handle, particleFlag)
    }

    /**
     * A pivot point used to calculate radial and orbital velocity of particles.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_velocity_pivot
     */
    fun setVelocityPivot(pivot: Vector3) {
        ObjectCalls.ptrcallWithVector3Arg(setVelocityPivotBind, handle, pivot)
    }

    /**
     * A pivot point used to calculate radial and orbital velocity of particles.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_velocity_pivot
     */
    fun getVelocityPivot(): Vector3 {
        return ObjectCalls.ptrcallNoArgsRetVector3(getVelocityPivotBind, handle)
    }

    /**
     * Particles will be emitted inside this region.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_shape
     */
    fun setEmissionShape(shape: Long) {
        ObjectCalls.ptrcallWithLongArg(setEmissionShapeBind, handle, shape)
    }

    /**
     * Particles will be emitted inside this region.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_shape
     */
    fun getEmissionShape(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getEmissionShapeBind, handle)
    }

    /**
     * The sphere's radius if `emission_shape` is set to `EMISSION_SHAPE_SPHERE`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_sphere_radius
     */
    fun setEmissionSphereRadius(radius: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setEmissionSphereRadiusBind, handle, radius)
    }

    /**
     * The sphere's radius if `emission_shape` is set to `EMISSION_SHAPE_SPHERE`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_sphere_radius
     */
    fun getEmissionSphereRadius(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getEmissionSphereRadiusBind, handle)
    }

    /**
     * The box's extents if `emission_shape` is set to `EMISSION_SHAPE_BOX`. Note:
     * `emission_box_extents` starts from the center point and applies the X, Y, and Z values in both
     * directions. The size is twice the area of the extents.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_box_extents
     */
    fun setEmissionBoxExtents(extents: Vector3) {
        ObjectCalls.ptrcallWithVector3Arg(setEmissionBoxExtentsBind, handle, extents)
    }

    /**
     * The box's extents if `emission_shape` is set to `EMISSION_SHAPE_BOX`. Note:
     * `emission_box_extents` starts from the center point and applies the X, Y, and Z values in both
     * directions. The size is twice the area of the extents.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_box_extents
     */
    fun getEmissionBoxExtents(): Vector3 {
        return ObjectCalls.ptrcallNoArgsRetVector3(getEmissionBoxExtentsBind, handle)
    }

    /**
     * Particles will be emitted at positions determined by sampling this texture at a random position.
     * Used with `EMISSION_SHAPE_POINTS` and `EMISSION_SHAPE_DIRECTED_POINTS`. Can be created
     * automatically from mesh or node by selecting "Create Emission Points from Mesh/Node" under the
     * "Particles" tool in the toolbar.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_point_texture
     */
    fun setEmissionPointTexture(texture: Texture2D?) {
        ObjectCalls.ptrcallWithObjectArgs(setEmissionPointTextureBind, handle, listOf(texture?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    /**
     * Particles will be emitted at positions determined by sampling this texture at a random position.
     * Used with `EMISSION_SHAPE_POINTS` and `EMISSION_SHAPE_DIRECTED_POINTS`. Can be created
     * automatically from mesh or node by selecting "Create Emission Points from Mesh/Node" under the
     * "Particles" tool in the toolbar.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_point_texture
     */
    fun getEmissionPointTexture(): Texture2D? {
        return Texture2D.wrap(ObjectCalls.ptrcallNoArgsRetObject(getEmissionPointTextureBind, handle))
    }

    /**
     * Particle velocity and rotation will be set by sampling this texture at the same point as the
     * `emission_point_texture`. Used only in `EMISSION_SHAPE_DIRECTED_POINTS`. Can be created
     * automatically from mesh or node by selecting "Create Emission Points from Mesh/Node" under the
     * "Particles" tool in the toolbar.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_normal_texture
     */
    fun setEmissionNormalTexture(texture: Texture2D?) {
        ObjectCalls.ptrcallWithObjectArgs(setEmissionNormalTextureBind, handle, listOf(texture?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    /**
     * Particle velocity and rotation will be set by sampling this texture at the same point as the
     * `emission_point_texture`. Used only in `EMISSION_SHAPE_DIRECTED_POINTS`. Can be created
     * automatically from mesh or node by selecting "Create Emission Points from Mesh/Node" under the
     * "Particles" tool in the toolbar.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_normal_texture
     */
    fun getEmissionNormalTexture(): Texture2D? {
        return Texture2D.wrap(ObjectCalls.ptrcallNoArgsRetObject(getEmissionNormalTextureBind, handle))
    }

    /**
     * Particle color will be modulated by color determined by sampling this texture at the same point
     * as the `emission_point_texture`. Note: `emission_color_texture` multiplies the particle mesh's
     * vertex colors. To have a visible effect on a `BaseMaterial3D`,
     * `BaseMaterial3D.vertex_color_use_as_albedo` must be `true`. For a `ShaderMaterial`, `ALBEDO *=
     * COLOR.rgb;` must be inserted in the shader's `fragment()` function. Otherwise,
     * `emission_color_texture` will have no visible effect.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_color_texture
     */
    fun setEmissionColorTexture(texture: Texture2D?) {
        ObjectCalls.ptrcallWithObjectArgs(setEmissionColorTextureBind, handle, listOf(texture?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    /**
     * Particle color will be modulated by color determined by sampling this texture at the same point
     * as the `emission_point_texture`. Note: `emission_color_texture` multiplies the particle mesh's
     * vertex colors. To have a visible effect on a `BaseMaterial3D`,
     * `BaseMaterial3D.vertex_color_use_as_albedo` must be `true`. For a `ShaderMaterial`, `ALBEDO *=
     * COLOR.rgb;` must be inserted in the shader's `fragment()` function. Otherwise,
     * `emission_color_texture` will have no visible effect.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_color_texture
     */
    fun getEmissionColorTexture(): Texture2D? {
        return Texture2D.wrap(ObjectCalls.ptrcallNoArgsRetObject(getEmissionColorTextureBind, handle))
    }

    /**
     * The number of emission points if `emission_shape` is set to `EMISSION_SHAPE_POINTS` or
     * `EMISSION_SHAPE_DIRECTED_POINTS`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_point_count
     */
    fun setEmissionPointCount(pointCount: Int) {
        ObjectCalls.ptrcallWithIntArg(setEmissionPointCountBind, handle, pointCount)
    }

    /**
     * The number of emission points if `emission_shape` is set to `EMISSION_SHAPE_POINTS` or
     * `EMISSION_SHAPE_DIRECTED_POINTS`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_point_count
     */
    fun getEmissionPointCount(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getEmissionPointCountBind, handle)
    }

    /**
     * The axis of the ring when using the emitter `EMISSION_SHAPE_RING`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_ring_axis
     */
    fun setEmissionRingAxis(axis: Vector3) {
        ObjectCalls.ptrcallWithVector3Arg(setEmissionRingAxisBind, handle, axis)
    }

    /**
     * The axis of the ring when using the emitter `EMISSION_SHAPE_RING`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_ring_axis
     */
    fun getEmissionRingAxis(): Vector3 {
        return ObjectCalls.ptrcallNoArgsRetVector3(getEmissionRingAxisBind, handle)
    }

    /**
     * The height of the ring when using the emitter `EMISSION_SHAPE_RING`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_ring_height
     */
    fun setEmissionRingHeight(height: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setEmissionRingHeightBind, handle, height)
    }

    /**
     * The height of the ring when using the emitter `EMISSION_SHAPE_RING`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_ring_height
     */
    fun getEmissionRingHeight(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getEmissionRingHeightBind, handle)
    }

    /**
     * The radius of the ring when using the emitter `EMISSION_SHAPE_RING`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_ring_radius
     */
    fun setEmissionRingRadius(radius: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setEmissionRingRadiusBind, handle, radius)
    }

    /**
     * The radius of the ring when using the emitter `EMISSION_SHAPE_RING`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_ring_radius
     */
    fun getEmissionRingRadius(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getEmissionRingRadiusBind, handle)
    }

    /**
     * The inner radius of the ring when using the emitter `EMISSION_SHAPE_RING`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_ring_inner_radius
     */
    fun setEmissionRingInnerRadius(innerRadius: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setEmissionRingInnerRadiusBind, handle, innerRadius)
    }

    /**
     * The inner radius of the ring when using the emitter `EMISSION_SHAPE_RING`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_ring_inner_radius
     */
    fun getEmissionRingInnerRadius(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getEmissionRingInnerRadiusBind, handle)
    }

    /**
     * The angle of the cone when using the emitter `EMISSION_SHAPE_RING`. The default angle of 90
     * degrees results in a ring, while an angle of 0 degrees results in a cone. Intermediate values
     * will result in a ring where one end is larger than the other. Note: Depending on
     * `emission_ring_height`, the angle may be clamped if the ring's end is reached to form a perfect
     * cone.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_ring_cone_angle
     */
    fun setEmissionRingConeAngle(coneAngle: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setEmissionRingConeAngleBind, handle, coneAngle)
    }

    /**
     * The angle of the cone when using the emitter `EMISSION_SHAPE_RING`. The default angle of 90
     * degrees results in a ring, while an angle of 0 degrees results in a cone. Intermediate values
     * will result in a ring where one end is larger than the other. Note: Depending on
     * `emission_ring_height`, the angle may be clamped if the ring's end is reached to form a perfect
     * cone.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_ring_cone_angle
     */
    fun getEmissionRingConeAngle(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getEmissionRingConeAngleBind, handle)
    }

    /**
     * The offset for the `emission_shape`, in local space.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_shape_offset
     */
    fun setEmissionShapeOffset(emissionShapeOffset: Vector3) {
        ObjectCalls.ptrcallWithVector3Arg(setEmissionShapeOffsetBind, handle, emissionShapeOffset)
    }

    /**
     * The offset for the `emission_shape`, in local space.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_shape_offset
     */
    fun getEmissionShapeOffset(): Vector3 {
        return ObjectCalls.ptrcallNoArgsRetVector3(getEmissionShapeOffsetBind, handle)
    }

    /**
     * The scale of the `emission_shape`, in local space.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_emission_shape_scale
     */
    fun setEmissionShapeScale(emissionShapeScale: Vector3) {
        ObjectCalls.ptrcallWithVector3Arg(setEmissionShapeScaleBind, handle, emissionShapeScale)
    }

    /**
     * The scale of the `emission_shape`, in local space.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_emission_shape_scale
     */
    fun getEmissionShapeScale(): Vector3 {
        return ObjectCalls.ptrcallNoArgsRetVector3(getEmissionShapeScaleBind, handle)
    }

    /**
     * If `true`, enables turbulence for the particle system. Turbulence can be used to vary particle
     * movement according to its position (based on a 3D noise pattern). In 3D,
     * `GPUParticlesAttractorVectorField3D` with `NoiseTexture3D` can be used as an alternative to
     * turbulence that works in world space and with multiple particle systems reacting in the same
     * way. Note: Enabling turbulence has a high performance cost on the GPU. Only enable turbulence on
     * a few particle systems at once at most, and consider disabling it when targeting mobile/web
     * platforms.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_turbulence_enabled
     */
    fun getTurbulenceEnabled(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(getTurbulenceEnabledBind, handle)
    }

    /**
     * If `true`, enables turbulence for the particle system. Turbulence can be used to vary particle
     * movement according to its position (based on a 3D noise pattern). In 3D,
     * `GPUParticlesAttractorVectorField3D` with `NoiseTexture3D` can be used as an alternative to
     * turbulence that works in world space and with multiple particle systems reacting in the same
     * way. Note: Enabling turbulence has a high performance cost on the GPU. Only enable turbulence on
     * a few particle systems at once at most, and consider disabling it when targeting mobile/web
     * platforms.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_turbulence_enabled
     */
    fun setTurbulenceEnabled(turbulenceEnabled: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setTurbulenceEnabledBind, handle, turbulenceEnabled)
    }

    /**
     * The turbulence noise strength. Increasing this will result in a stronger, more contrasting, flow
     * pattern.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_turbulence_noise_strength
     */
    fun getTurbulenceNoiseStrength(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getTurbulenceNoiseStrengthBind, handle)
    }

    /**
     * The turbulence noise strength. Increasing this will result in a stronger, more contrasting, flow
     * pattern.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_turbulence_noise_strength
     */
    fun setTurbulenceNoiseStrength(turbulenceNoiseStrength: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setTurbulenceNoiseStrengthBind, handle, turbulenceNoiseStrength)
    }

    /**
     * This value controls the overall scale/frequency of the turbulence noise pattern. A small scale
     * will result in smaller features with more detail while a high scale will result in smoother
     * noise with larger features.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_turbulence_noise_scale
     */
    fun getTurbulenceNoiseScale(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getTurbulenceNoiseScaleBind, handle)
    }

    /**
     * This value controls the overall scale/frequency of the turbulence noise pattern. A small scale
     * will result in smaller features with more detail while a high scale will result in smoother
     * noise with larger features.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_turbulence_noise_scale
     */
    fun setTurbulenceNoiseScale(turbulenceNoiseScale: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setTurbulenceNoiseScaleBind, handle, turbulenceNoiseScale)
    }

    /**
     * The in-place rate of change of the turbulence field. This defines how quickly the noise pattern
     * varies over time. A value of 0.0 will result in a fixed pattern.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_turbulence_noise_speed_random
     */
    fun getTurbulenceNoiseSpeedRandom(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getTurbulenceNoiseSpeedRandomBind, handle)
    }

    /**
     * The in-place rate of change of the turbulence field. This defines how quickly the noise pattern
     * varies over time. A value of 0.0 will result in a fixed pattern.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_turbulence_noise_speed_random
     */
    fun setTurbulenceNoiseSpeedRandom(turbulenceNoiseSpeedRandom: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setTurbulenceNoiseSpeedRandomBind, handle, turbulenceNoiseSpeedRandom)
    }

    /**
     * A scrolling velocity for the turbulence field. This sets a directional trend for the pattern to
     * move in over time. The default value of `Vector3(0, 0, 0)` turns off the scrolling.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_turbulence_noise_speed
     */
    fun getTurbulenceNoiseSpeed(): Vector3 {
        return ObjectCalls.ptrcallNoArgsRetVector3(getTurbulenceNoiseSpeedBind, handle)
    }

    /**
     * A scrolling velocity for the turbulence field. This sets a directional trend for the pattern to
     * move in over time. The default value of `Vector3(0, 0, 0)` turns off the scrolling.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_turbulence_noise_speed
     */
    fun setTurbulenceNoiseSpeed(turbulenceNoiseSpeed: Vector3) {
        ObjectCalls.ptrcallWithVector3Arg(setTurbulenceNoiseSpeedBind, handle, turbulenceNoiseSpeed)
    }

    /**
     * Gravity applied to every particle.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_gravity
     */
    fun getGravity(): Vector3 {
        return ObjectCalls.ptrcallNoArgsRetVector3(getGravityBind, handle)
    }

    /**
     * Gravity applied to every particle.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_gravity
     */
    fun setGravity(accelVec: Vector3) {
        ObjectCalls.ptrcallWithVector3Arg(setGravityBind, handle, accelVec)
    }

    /**
     * Particle lifetime randomness ratio. The equation for the lifetime of a particle is `lifetime *
     * (1.0 - randf() * lifetime_randomness)`. For example, a `lifetime_randomness` of `0.4` scales the
     * lifetime between `0.6` to `1.0` of its original value.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_lifetime_randomness
     */
    fun setLifetimeRandomness(randomness: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setLifetimeRandomnessBind, handle, randomness)
    }

    /**
     * Particle lifetime randomness ratio. The equation for the lifetime of a particle is `lifetime *
     * (1.0 - randf() * lifetime_randomness)`. For example, a `lifetime_randomness` of `0.4` scales the
     * lifetime between `0.6` to `1.0` of its original value.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_lifetime_randomness
     */
    fun getLifetimeRandomness(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getLifetimeRandomnessBind, handle)
    }

    /**
     * The particle subemitter mode (see `GPUParticles2D.sub_emitter` and
     * `GPUParticles3D.sub_emitter`).
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_sub_emitter_mode
     */
    fun getSubEmitterMode(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getSubEmitterModeBind, handle)
    }

    /**
     * The particle subemitter mode (see `GPUParticles2D.sub_emitter` and
     * `GPUParticles3D.sub_emitter`).
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_sub_emitter_mode
     */
    fun setSubEmitterMode(mode: Long) {
        ObjectCalls.ptrcallWithLongArg(setSubEmitterModeBind, handle, mode)
    }

    /**
     * The frequency at which particles should be emitted from the subemitter node. One particle will
     * be spawned every `sub_emitter_frequency` seconds. Note: This value shouldn't exceed
     * `GPUParticles2D.amount` or `GPUParticles3D.amount` defined on the subemitter node (not the main
     * node), relative to the subemitter's particle lifetime. If the number of particles is exceeded,
     * no new particles will spawn from the subemitter until enough particles have expired.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_sub_emitter_frequency
     */
    fun getSubEmitterFrequency(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getSubEmitterFrequencyBind, handle)
    }

    /**
     * The frequency at which particles should be emitted from the subemitter node. One particle will
     * be spawned every `sub_emitter_frequency` seconds. Note: This value shouldn't exceed
     * `GPUParticles2D.amount` or `GPUParticles3D.amount` defined on the subemitter node (not the main
     * node), relative to the subemitter's particle lifetime. If the number of particles is exceeded,
     * no new particles will spawn from the subemitter until enough particles have expired.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_sub_emitter_frequency
     */
    fun setSubEmitterFrequency(hz: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setSubEmitterFrequencyBind, handle, hz)
    }

    /**
     * The amount of particles to spawn from the subemitter node when the particle expires. Note: This
     * value shouldn't exceed `GPUParticles2D.amount` or `GPUParticles3D.amount` defined on the
     * subemitter node (not the main node), relative to the subemitter's particle lifetime. If the
     * number of particles is exceeded, no new particles will spawn from the subemitter until enough
     * particles have expired.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_sub_emitter_amount_at_end
     */
    fun getSubEmitterAmountAtEnd(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getSubEmitterAmountAtEndBind, handle)
    }

    /**
     * The amount of particles to spawn from the subemitter node when the particle expires. Note: This
     * value shouldn't exceed `GPUParticles2D.amount` or `GPUParticles3D.amount` defined on the
     * subemitter node (not the main node), relative to the subemitter's particle lifetime. If the
     * number of particles is exceeded, no new particles will spawn from the subemitter until enough
     * particles have expired.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_sub_emitter_amount_at_end
     */
    fun setSubEmitterAmountAtEnd(amount: Int) {
        ObjectCalls.ptrcallWithIntArg(setSubEmitterAmountAtEndBind, handle, amount)
    }

    /**
     * The amount of particles to spawn from the subemitter node when a collision occurs. When combined
     * with `COLLISION_HIDE_ON_CONTACT` on the main particles material, this can be used to achieve
     * effects such as raindrops hitting the ground. Note: This value shouldn't exceed
     * `GPUParticles2D.amount` or `GPUParticles3D.amount` defined on the subemitter node (not the main
     * node), relative to the subemitter's particle lifetime. If the number of particles is exceeded,
     * no new particles will spawn from the subemitter until enough particles have expired.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_sub_emitter_amount_at_collision
     */
    fun getSubEmitterAmountAtCollision(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getSubEmitterAmountAtCollisionBind, handle)
    }

    /**
     * The amount of particles to spawn from the subemitter node when a collision occurs. When combined
     * with `COLLISION_HIDE_ON_CONTACT` on the main particles material, this can be used to achieve
     * effects such as raindrops hitting the ground. Note: This value shouldn't exceed
     * `GPUParticles2D.amount` or `GPUParticles3D.amount` defined on the subemitter node (not the main
     * node), relative to the subemitter's particle lifetime. If the number of particles is exceeded,
     * no new particles will spawn from the subemitter until enough particles have expired.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_sub_emitter_amount_at_collision
     */
    fun setSubEmitterAmountAtCollision(amount: Int) {
        ObjectCalls.ptrcallWithIntArg(setSubEmitterAmountAtCollisionBind, handle, amount)
    }

    /**
     * The amount of particles to spawn from the subemitter node when the particle spawns. Note: This
     * value shouldn't exceed `GPUParticles2D.amount` or `GPUParticles3D.amount` defined on the
     * subemitter node (not the main node), relative to the subemitter's particle lifetime. If the
     * number of particles is exceeded, no new particles will spawn from the subemitter until enough
     * particles have expired.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_sub_emitter_amount_at_start
     */
    fun getSubEmitterAmountAtStart(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getSubEmitterAmountAtStartBind, handle)
    }

    /**
     * The amount of particles to spawn from the subemitter node when the particle spawns. Note: This
     * value shouldn't exceed `GPUParticles2D.amount` or `GPUParticles3D.amount` defined on the
     * subemitter node (not the main node), relative to the subemitter's particle lifetime. If the
     * number of particles is exceeded, no new particles will spawn from the subemitter until enough
     * particles have expired.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_sub_emitter_amount_at_start
     */
    fun setSubEmitterAmountAtStart(amount: Int) {
        ObjectCalls.ptrcallWithIntArg(setSubEmitterAmountAtStartBind, handle, amount)
    }

    /**
     * If `true`, the subemitter inherits the parent particle's velocity when it spawns.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_sub_emitter_keep_velocity
     */
    fun getSubEmitterKeepVelocity(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(getSubEmitterKeepVelocityBind, handle)
    }

    /**
     * If `true`, the subemitter inherits the parent particle's velocity when it spawns.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_sub_emitter_keep_velocity
     */
    fun setSubEmitterKeepVelocity(enable: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setSubEmitterKeepVelocityBind, handle, enable)
    }

    /**
     * If `true`, interaction with particle attractors is enabled. In 3D, attraction only occurs within
     * the area defined by the `GPUParticles3D` node's `GPUParticles3D.visibility_aabb`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_attractor_interaction_enabled
     */
    fun setAttractorInteractionEnabled(enabled: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setAttractorInteractionEnabledBind, handle, enabled)
    }

    /**
     * If `true`, interaction with particle attractors is enabled. In 3D, attraction only occurs within
     * the area defined by the `GPUParticles3D` node's `GPUParticles3D.visibility_aabb`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.is_attractor_interaction_enabled
     */
    fun isAttractorInteractionEnabled(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isAttractorInteractionEnabledBind, handle)
    }

    /**
     * The particles' collision mode. Note: 3D Particles can only collide with
     * `GPUParticlesCollision3D` nodes, not `PhysicsBody3D` nodes. To make particles collide with
     * various objects, you can add `GPUParticlesCollision3D` nodes as children of `PhysicsBody3D`
     * nodes. In 3D, collisions only occur within the area defined by the `GPUParticles3D` node's
     * `GPUParticles3D.visibility_aabb`. Note: 2D Particles can only collide with `LightOccluder2D`
     * nodes, not `PhysicsBody2D` nodes.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_collision_mode
     */
    fun setCollisionMode(mode: Long) {
        ObjectCalls.ptrcallWithLongArg(setCollisionModeBind, handle, mode)
    }

    /**
     * The particles' collision mode. Note: 3D Particles can only collide with
     * `GPUParticlesCollision3D` nodes, not `PhysicsBody3D` nodes. To make particles collide with
     * various objects, you can add `GPUParticlesCollision3D` nodes as children of `PhysicsBody3D`
     * nodes. In 3D, collisions only occur within the area defined by the `GPUParticles3D` node's
     * `GPUParticles3D.visibility_aabb`. Note: 2D Particles can only collide with `LightOccluder2D`
     * nodes, not `PhysicsBody2D` nodes.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_collision_mode
     */
    fun getCollisionMode(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getCollisionModeBind, handle)
    }

    /**
     * If `true`, `GPUParticles3D.collision_base_size` is multiplied by the particle's effective scale
     * (see `scale_min`, `scale_max`, `scale_curve`, and `scale_over_velocity_curve`).
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_collision_use_scale
     */
    fun setCollisionUseScale(radius: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setCollisionUseScaleBind, handle, radius)
    }

    /**
     * If `true`, `GPUParticles3D.collision_base_size` is multiplied by the particle's effective scale
     * (see `scale_min`, `scale_max`, `scale_curve`, and `scale_over_velocity_curve`).
     *
     * Generated from Godot docs: ParticleProcessMaterial.is_collision_using_scale
     */
    fun isCollisionUsingScale(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isCollisionUsingScaleBind, handle)
    }

    /**
     * The particles' friction. Values range from `0` (frictionless) to `1` (maximum friction). Only
     * effective if `collision_mode` is `COLLISION_RIGID`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_collision_friction
     */
    fun setCollisionFriction(friction: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setCollisionFrictionBind, handle, friction)
    }

    /**
     * The particles' friction. Values range from `0` (frictionless) to `1` (maximum friction). Only
     * effective if `collision_mode` is `COLLISION_RIGID`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_collision_friction
     */
    fun getCollisionFriction(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getCollisionFrictionBind, handle)
    }

    /**
     * The particles' bounciness. Values range from `0` (no bounce) to `1` (full bounciness). Only
     * effective if `collision_mode` is `COLLISION_RIGID`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.set_collision_bounce
     */
    fun setCollisionBounce(bounce: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setCollisionBounceBind, handle, bounce)
    }

    /**
     * The particles' bounciness. Values range from `0` (no bounce) to `1` (full bounciness). Only
     * effective if `collision_mode` is `COLLISION_RIGID`.
     *
     * Generated from Godot docs: ParticleProcessMaterial.get_collision_bounce
     */
    fun getCollisionBounce(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getCollisionBounceBind, handle)
    }

    object Signals {
        const val emissionShapeChanged: String = "emission_shape_changed"
    }

    companion object {
        private const val SET_DIRECTION_HASH = 3460891852L
        private val setDirectionBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_direction", SET_DIRECTION_HASH)
        }

        private const val GET_DIRECTION_HASH = 3360562783L
        private val getDirectionBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_direction", GET_DIRECTION_HASH)
        }

        private const val SET_INHERIT_VELOCITY_RATIO_HASH = 373806689L
        private val setInheritVelocityRatioBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_inherit_velocity_ratio", SET_INHERIT_VELOCITY_RATIO_HASH)
        }

        private const val GET_INHERIT_VELOCITY_RATIO_HASH = 191475506L
        private val getInheritVelocityRatioBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_inherit_velocity_ratio", GET_INHERIT_VELOCITY_RATIO_HASH)
        }

        private const val SET_SPREAD_HASH = 373806689L
        private val setSpreadBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_spread", SET_SPREAD_HASH)
        }

        private const val GET_SPREAD_HASH = 1740695150L
        private val getSpreadBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_spread", GET_SPREAD_HASH)
        }

        private const val SET_FLATNESS_HASH = 373806689L
        private val setFlatnessBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_flatness", SET_FLATNESS_HASH)
        }

        private const val GET_FLATNESS_HASH = 1740695150L
        private val getFlatnessBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_flatness", GET_FLATNESS_HASH)
        }

        private const val SET_PARAM_HASH = 676779352L
        private val setParamBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_param", SET_PARAM_HASH)
        }

        private const val GET_PARAM_HASH = 2623708480L
        private val getParamBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_param", GET_PARAM_HASH)
        }

        private const val SET_PARAM_MIN_HASH = 2295964248L
        private val setParamMinBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_param_min", SET_PARAM_MIN_HASH)
        }

        private const val GET_PARAM_MIN_HASH = 3903786503L
        private val getParamMinBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_param_min", GET_PARAM_MIN_HASH)
        }

        private const val SET_PARAM_MAX_HASH = 2295964248L
        private val setParamMaxBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_param_max", SET_PARAM_MAX_HASH)
        }

        private const val GET_PARAM_MAX_HASH = 3903786503L
        private val getParamMaxBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_param_max", GET_PARAM_MAX_HASH)
        }

        private const val SET_PARAM_TEXTURE_HASH = 526976089L
        private val setParamTextureBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_param_texture", SET_PARAM_TEXTURE_HASH)
        }

        private const val GET_PARAM_TEXTURE_HASH = 3489372978L
        private val getParamTextureBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_param_texture", GET_PARAM_TEXTURE_HASH)
        }

        private const val SET_COLOR_HASH = 2920490490L
        private val setColorBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_color", SET_COLOR_HASH)
        }

        private const val GET_COLOR_HASH = 3444240500L
        private val getColorBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_color", GET_COLOR_HASH)
        }

        private const val SET_COLOR_RAMP_HASH = 4051416890L
        private val setColorRampBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_color_ramp", SET_COLOR_RAMP_HASH)
        }

        private const val GET_COLOR_RAMP_HASH = 3635182373L
        private val getColorRampBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_color_ramp", GET_COLOR_RAMP_HASH)
        }

        private const val SET_ALPHA_CURVE_HASH = 4051416890L
        private val setAlphaCurveBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_alpha_curve", SET_ALPHA_CURVE_HASH)
        }

        private const val GET_ALPHA_CURVE_HASH = 3635182373L
        private val getAlphaCurveBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_alpha_curve", GET_ALPHA_CURVE_HASH)
        }

        private const val SET_EMISSION_CURVE_HASH = 4051416890L
        private val setEmissionCurveBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_curve", SET_EMISSION_CURVE_HASH)
        }

        private const val GET_EMISSION_CURVE_HASH = 3635182373L
        private val getEmissionCurveBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_curve", GET_EMISSION_CURVE_HASH)
        }

        private const val SET_COLOR_INITIAL_RAMP_HASH = 4051416890L
        private val setColorInitialRampBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_color_initial_ramp", SET_COLOR_INITIAL_RAMP_HASH)
        }

        private const val GET_COLOR_INITIAL_RAMP_HASH = 3635182373L
        private val getColorInitialRampBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_color_initial_ramp", GET_COLOR_INITIAL_RAMP_HASH)
        }

        private const val SET_VELOCITY_LIMIT_CURVE_HASH = 4051416890L
        private val setVelocityLimitCurveBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_velocity_limit_curve", SET_VELOCITY_LIMIT_CURVE_HASH)
        }

        private const val GET_VELOCITY_LIMIT_CURVE_HASH = 3635182373L
        private val getVelocityLimitCurveBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_velocity_limit_curve", GET_VELOCITY_LIMIT_CURVE_HASH)
        }

        private const val SET_PARTICLE_FLAG_HASH = 1711815571L
        private val setParticleFlagBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_particle_flag", SET_PARTICLE_FLAG_HASH)
        }

        private const val GET_PARTICLE_FLAG_HASH = 3895316907L
        private val getParticleFlagBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_particle_flag", GET_PARTICLE_FLAG_HASH)
        }

        private const val SET_VELOCITY_PIVOT_HASH = 3460891852L
        private val setVelocityPivotBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_velocity_pivot", SET_VELOCITY_PIVOT_HASH)
        }

        private const val GET_VELOCITY_PIVOT_HASH = 3783033775L
        private val getVelocityPivotBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_velocity_pivot", GET_VELOCITY_PIVOT_HASH)
        }

        private const val SET_EMISSION_SHAPE_HASH = 461501442L
        private val setEmissionShapeBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_shape", SET_EMISSION_SHAPE_HASH)
        }

        private const val GET_EMISSION_SHAPE_HASH = 3719733018L
        private val getEmissionShapeBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_shape", GET_EMISSION_SHAPE_HASH)
        }

        private const val SET_EMISSION_SPHERE_RADIUS_HASH = 373806689L
        private val setEmissionSphereRadiusBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_sphere_radius", SET_EMISSION_SPHERE_RADIUS_HASH)
        }

        private const val GET_EMISSION_SPHERE_RADIUS_HASH = 1740695150L
        private val getEmissionSphereRadiusBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_sphere_radius", GET_EMISSION_SPHERE_RADIUS_HASH)
        }

        private const val SET_EMISSION_BOX_EXTENTS_HASH = 3460891852L
        private val setEmissionBoxExtentsBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_box_extents", SET_EMISSION_BOX_EXTENTS_HASH)
        }

        private const val GET_EMISSION_BOX_EXTENTS_HASH = 3360562783L
        private val getEmissionBoxExtentsBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_box_extents", GET_EMISSION_BOX_EXTENTS_HASH)
        }

        private const val SET_EMISSION_POINT_TEXTURE_HASH = 4051416890L
        private val setEmissionPointTextureBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_point_texture", SET_EMISSION_POINT_TEXTURE_HASH)
        }

        private const val GET_EMISSION_POINT_TEXTURE_HASH = 3635182373L
        private val getEmissionPointTextureBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_point_texture", GET_EMISSION_POINT_TEXTURE_HASH)
        }

        private const val SET_EMISSION_NORMAL_TEXTURE_HASH = 4051416890L
        private val setEmissionNormalTextureBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_normal_texture", SET_EMISSION_NORMAL_TEXTURE_HASH)
        }

        private const val GET_EMISSION_NORMAL_TEXTURE_HASH = 3635182373L
        private val getEmissionNormalTextureBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_normal_texture", GET_EMISSION_NORMAL_TEXTURE_HASH)
        }

        private const val SET_EMISSION_COLOR_TEXTURE_HASH = 4051416890L
        private val setEmissionColorTextureBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_color_texture", SET_EMISSION_COLOR_TEXTURE_HASH)
        }

        private const val GET_EMISSION_COLOR_TEXTURE_HASH = 3635182373L
        private val getEmissionColorTextureBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_color_texture", GET_EMISSION_COLOR_TEXTURE_HASH)
        }

        private const val SET_EMISSION_POINT_COUNT_HASH = 1286410249L
        private val setEmissionPointCountBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_point_count", SET_EMISSION_POINT_COUNT_HASH)
        }

        private const val GET_EMISSION_POINT_COUNT_HASH = 3905245786L
        private val getEmissionPointCountBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_point_count", GET_EMISSION_POINT_COUNT_HASH)
        }

        private const val SET_EMISSION_RING_AXIS_HASH = 3460891852L
        private val setEmissionRingAxisBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_ring_axis", SET_EMISSION_RING_AXIS_HASH)
        }

        private const val GET_EMISSION_RING_AXIS_HASH = 3360562783L
        private val getEmissionRingAxisBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_ring_axis", GET_EMISSION_RING_AXIS_HASH)
        }

        private const val SET_EMISSION_RING_HEIGHT_HASH = 373806689L
        private val setEmissionRingHeightBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_ring_height", SET_EMISSION_RING_HEIGHT_HASH)
        }

        private const val GET_EMISSION_RING_HEIGHT_HASH = 1740695150L
        private val getEmissionRingHeightBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_ring_height", GET_EMISSION_RING_HEIGHT_HASH)
        }

        private const val SET_EMISSION_RING_RADIUS_HASH = 373806689L
        private val setEmissionRingRadiusBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_ring_radius", SET_EMISSION_RING_RADIUS_HASH)
        }

        private const val GET_EMISSION_RING_RADIUS_HASH = 1740695150L
        private val getEmissionRingRadiusBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_ring_radius", GET_EMISSION_RING_RADIUS_HASH)
        }

        private const val SET_EMISSION_RING_INNER_RADIUS_HASH = 373806689L
        private val setEmissionRingInnerRadiusBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_ring_inner_radius", SET_EMISSION_RING_INNER_RADIUS_HASH)
        }

        private const val GET_EMISSION_RING_INNER_RADIUS_HASH = 1740695150L
        private val getEmissionRingInnerRadiusBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_ring_inner_radius", GET_EMISSION_RING_INNER_RADIUS_HASH)
        }

        private const val SET_EMISSION_RING_CONE_ANGLE_HASH = 373806689L
        private val setEmissionRingConeAngleBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_ring_cone_angle", SET_EMISSION_RING_CONE_ANGLE_HASH)
        }

        private const val GET_EMISSION_RING_CONE_ANGLE_HASH = 1740695150L
        private val getEmissionRingConeAngleBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_ring_cone_angle", GET_EMISSION_RING_CONE_ANGLE_HASH)
        }

        private const val SET_EMISSION_SHAPE_OFFSET_HASH = 3460891852L
        private val setEmissionShapeOffsetBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_shape_offset", SET_EMISSION_SHAPE_OFFSET_HASH)
        }

        private const val GET_EMISSION_SHAPE_OFFSET_HASH = 3360562783L
        private val getEmissionShapeOffsetBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_shape_offset", GET_EMISSION_SHAPE_OFFSET_HASH)
        }

        private const val SET_EMISSION_SHAPE_SCALE_HASH = 3460891852L
        private val setEmissionShapeScaleBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_emission_shape_scale", SET_EMISSION_SHAPE_SCALE_HASH)
        }

        private const val GET_EMISSION_SHAPE_SCALE_HASH = 3360562783L
        private val getEmissionShapeScaleBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_emission_shape_scale", GET_EMISSION_SHAPE_SCALE_HASH)
        }

        private const val GET_TURBULENCE_ENABLED_HASH = 36873697L
        private val getTurbulenceEnabledBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_turbulence_enabled", GET_TURBULENCE_ENABLED_HASH)
        }

        private const val SET_TURBULENCE_ENABLED_HASH = 2586408642L
        private val setTurbulenceEnabledBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_turbulence_enabled", SET_TURBULENCE_ENABLED_HASH)
        }

        private const val GET_TURBULENCE_NOISE_STRENGTH_HASH = 1740695150L
        private val getTurbulenceNoiseStrengthBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_turbulence_noise_strength", GET_TURBULENCE_NOISE_STRENGTH_HASH)
        }

        private const val SET_TURBULENCE_NOISE_STRENGTH_HASH = 373806689L
        private val setTurbulenceNoiseStrengthBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_turbulence_noise_strength", SET_TURBULENCE_NOISE_STRENGTH_HASH)
        }

        private const val GET_TURBULENCE_NOISE_SCALE_HASH = 1740695150L
        private val getTurbulenceNoiseScaleBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_turbulence_noise_scale", GET_TURBULENCE_NOISE_SCALE_HASH)
        }

        private const val SET_TURBULENCE_NOISE_SCALE_HASH = 373806689L
        private val setTurbulenceNoiseScaleBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_turbulence_noise_scale", SET_TURBULENCE_NOISE_SCALE_HASH)
        }

        private const val GET_TURBULENCE_NOISE_SPEED_RANDOM_HASH = 1740695150L
        private val getTurbulenceNoiseSpeedRandomBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_turbulence_noise_speed_random", GET_TURBULENCE_NOISE_SPEED_RANDOM_HASH)
        }

        private const val SET_TURBULENCE_NOISE_SPEED_RANDOM_HASH = 373806689L
        private val setTurbulenceNoiseSpeedRandomBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_turbulence_noise_speed_random", SET_TURBULENCE_NOISE_SPEED_RANDOM_HASH)
        }

        private const val GET_TURBULENCE_NOISE_SPEED_HASH = 3360562783L
        private val getTurbulenceNoiseSpeedBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_turbulence_noise_speed", GET_TURBULENCE_NOISE_SPEED_HASH)
        }

        private const val SET_TURBULENCE_NOISE_SPEED_HASH = 3460891852L
        private val setTurbulenceNoiseSpeedBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_turbulence_noise_speed", SET_TURBULENCE_NOISE_SPEED_HASH)
        }

        private const val GET_GRAVITY_HASH = 3360562783L
        private val getGravityBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_gravity", GET_GRAVITY_HASH)
        }

        private const val SET_GRAVITY_HASH = 3460891852L
        private val setGravityBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_gravity", SET_GRAVITY_HASH)
        }

        private const val SET_LIFETIME_RANDOMNESS_HASH = 373806689L
        private val setLifetimeRandomnessBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_lifetime_randomness", SET_LIFETIME_RANDOMNESS_HASH)
        }

        private const val GET_LIFETIME_RANDOMNESS_HASH = 1740695150L
        private val getLifetimeRandomnessBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_lifetime_randomness", GET_LIFETIME_RANDOMNESS_HASH)
        }

        private const val GET_SUB_EMITTER_MODE_HASH = 2399052877L
        private val getSubEmitterModeBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_sub_emitter_mode", GET_SUB_EMITTER_MODE_HASH)
        }

        private const val SET_SUB_EMITTER_MODE_HASH = 2161806672L
        private val setSubEmitterModeBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_sub_emitter_mode", SET_SUB_EMITTER_MODE_HASH)
        }

        private const val GET_SUB_EMITTER_FREQUENCY_HASH = 1740695150L
        private val getSubEmitterFrequencyBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_sub_emitter_frequency", GET_SUB_EMITTER_FREQUENCY_HASH)
        }

        private const val SET_SUB_EMITTER_FREQUENCY_HASH = 373806689L
        private val setSubEmitterFrequencyBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_sub_emitter_frequency", SET_SUB_EMITTER_FREQUENCY_HASH)
        }

        private const val GET_SUB_EMITTER_AMOUNT_AT_END_HASH = 3905245786L
        private val getSubEmitterAmountAtEndBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_sub_emitter_amount_at_end", GET_SUB_EMITTER_AMOUNT_AT_END_HASH)
        }

        private const val SET_SUB_EMITTER_AMOUNT_AT_END_HASH = 1286410249L
        private val setSubEmitterAmountAtEndBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_sub_emitter_amount_at_end", SET_SUB_EMITTER_AMOUNT_AT_END_HASH)
        }

        private const val GET_SUB_EMITTER_AMOUNT_AT_COLLISION_HASH = 3905245786L
        private val getSubEmitterAmountAtCollisionBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_sub_emitter_amount_at_collision", GET_SUB_EMITTER_AMOUNT_AT_COLLISION_HASH)
        }

        private const val SET_SUB_EMITTER_AMOUNT_AT_COLLISION_HASH = 1286410249L
        private val setSubEmitterAmountAtCollisionBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_sub_emitter_amount_at_collision", SET_SUB_EMITTER_AMOUNT_AT_COLLISION_HASH)
        }

        private const val GET_SUB_EMITTER_AMOUNT_AT_START_HASH = 3905245786L
        private val getSubEmitterAmountAtStartBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_sub_emitter_amount_at_start", GET_SUB_EMITTER_AMOUNT_AT_START_HASH)
        }

        private const val SET_SUB_EMITTER_AMOUNT_AT_START_HASH = 1286410249L
        private val setSubEmitterAmountAtStartBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_sub_emitter_amount_at_start", SET_SUB_EMITTER_AMOUNT_AT_START_HASH)
        }

        private const val GET_SUB_EMITTER_KEEP_VELOCITY_HASH = 36873697L
        private val getSubEmitterKeepVelocityBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_sub_emitter_keep_velocity", GET_SUB_EMITTER_KEEP_VELOCITY_HASH)
        }

        private const val SET_SUB_EMITTER_KEEP_VELOCITY_HASH = 2586408642L
        private val setSubEmitterKeepVelocityBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_sub_emitter_keep_velocity", SET_SUB_EMITTER_KEEP_VELOCITY_HASH)
        }

        private const val SET_ATTRACTOR_INTERACTION_ENABLED_HASH = 2586408642L
        private val setAttractorInteractionEnabledBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_attractor_interaction_enabled", SET_ATTRACTOR_INTERACTION_ENABLED_HASH)
        }

        private const val IS_ATTRACTOR_INTERACTION_ENABLED_HASH = 36873697L
        private val isAttractorInteractionEnabledBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "is_attractor_interaction_enabled", IS_ATTRACTOR_INTERACTION_ENABLED_HASH)
        }

        private const val SET_COLLISION_MODE_HASH = 653804659L
        private val setCollisionModeBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_collision_mode", SET_COLLISION_MODE_HASH)
        }

        private const val GET_COLLISION_MODE_HASH = 139371864L
        private val getCollisionModeBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_collision_mode", GET_COLLISION_MODE_HASH)
        }

        private const val SET_COLLISION_USE_SCALE_HASH = 2586408642L
        private val setCollisionUseScaleBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_collision_use_scale", SET_COLLISION_USE_SCALE_HASH)
        }

        private const val IS_COLLISION_USING_SCALE_HASH = 36873697L
        private val isCollisionUsingScaleBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "is_collision_using_scale", IS_COLLISION_USING_SCALE_HASH)
        }

        private const val SET_COLLISION_FRICTION_HASH = 373806689L
        private val setCollisionFrictionBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_collision_friction", SET_COLLISION_FRICTION_HASH)
        }

        private const val GET_COLLISION_FRICTION_HASH = 1740695150L
        private val getCollisionFrictionBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_collision_friction", GET_COLLISION_FRICTION_HASH)
        }

        private const val SET_COLLISION_BOUNCE_HASH = 373806689L
        private val setCollisionBounceBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "set_collision_bounce", SET_COLLISION_BOUNCE_HASH)
        }

        private const val GET_COLLISION_BOUNCE_HASH = 1740695150L
        private val getCollisionBounceBind by lazy {
            ObjectCalls.getMethodBind("ParticleProcessMaterial", "get_collision_bounce", GET_COLLISION_BOUNCE_HASH)
        }
    }
}
