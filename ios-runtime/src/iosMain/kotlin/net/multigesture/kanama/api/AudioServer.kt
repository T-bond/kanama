package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: AudioServer
 */
object AudioServer {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("AudioServer")
    }

    const val SPEAKER_MODE_STEREO: Long = 0L
    const val SPEAKER_SURROUND_31: Long = 1L
    const val SPEAKER_SURROUND_51: Long = 2L
    const val SPEAKER_SURROUND_71: Long = 3L
    const val PLAYBACK_TYPE_DEFAULT: Long = 0L
    const val PLAYBACK_TYPE_STREAM: Long = 1L
    const val PLAYBACK_TYPE_SAMPLE: Long = 2L
    const val PLAYBACK_TYPE_MAX: Long = 3L

    var busCount: Int
        @JvmName("busCountProperty")
        get() = getBusCount()
        @JvmName("setBusCountProperty")
        set(value) = setBusCount(value)

    var outputDevice: String
        @JvmName("outputDeviceProperty")
        get() = getOutputDevice()
        @JvmName("setOutputDeviceProperty")
        set(value) = setOutputDevice(value)

    var inputDevice: String
        @JvmName("inputDeviceProperty")
        get() = getInputDevice()
        @JvmName("setInputDeviceProperty")
        set(value) = setInputDevice(value)

    var playbackSpeedScale: Double
        @JvmName("playbackSpeedScaleProperty")
        get() = getPlaybackSpeedScale()
        @JvmName("setPlaybackSpeedScaleProperty")
        set(value) = setPlaybackSpeedScale(value)

    fun setBusCount(amount: Int) {
        ObjectCalls.ptrcallWithIntArg(setBusCountBind, singleton, amount)
    }

    fun getBusCount(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getBusCountBind, singleton)
    }

    fun removeBus(index: Int) {
        ObjectCalls.ptrcallWithIntArg(removeBusBind, singleton, index)
    }

    fun addBus(atPosition: Int = -1) {
        ObjectCalls.ptrcallWithIntArg(addBusBind, singleton, atPosition)
    }

    fun moveBus(index: Int, toIndex: Int) {
        ObjectCalls.ptrcallWithTwoIntArgs(moveBusBind, singleton, index, toIndex)
    }

    fun setBusName(busIdx: Int, name: String) {
        ObjectCalls.ptrcallWithIntAndStringArg(setBusNameBind, singleton, busIdx, name)
    }

    fun getBusIndex(busName: String): Int {
        return ObjectCalls.ptrcallWithStringNameArgRetInt(getBusIndexBind, singleton, busName)
    }

    fun getBusChannels(busIdx: Int): Int {
        return ObjectCalls.ptrcallWithIntArgRetInt(getBusChannelsBind, singleton, busIdx)
    }

    fun setBusVolumeDb(busIdx: Int, volumeDb: Double) {
        ObjectCalls.ptrcallWithIntAndDoubleArg(setBusVolumeDbBind, singleton, busIdx, volumeDb)
    }

    fun getBusVolumeDb(busIdx: Int): Double {
        return ObjectCalls.ptrcallWithIntArgRetDouble(getBusVolumeDbBind, singleton, busIdx)
    }

    fun setBusVolumeLinear(busIdx: Int, volumeLinear: Double) {
        ObjectCalls.ptrcallWithIntAndDoubleArg(setBusVolumeLinearBind, singleton, busIdx, volumeLinear)
    }

    fun getBusVolumeLinear(busIdx: Int): Double {
        return ObjectCalls.ptrcallWithIntArgRetDouble(getBusVolumeLinearBind, singleton, busIdx)
    }

    fun setBusSend(busIdx: Int, send: String) {
        ObjectCalls.ptrcallWithIntAndStringNameArg(setBusSendBind, singleton, busIdx, send)
    }

    fun setBusSolo(busIdx: Int, enable: Boolean) {
        ObjectCalls.ptrcallWithIntAndBoolArgs(setBusSoloBind, singleton, busIdx, enable)
    }

    fun isBusSolo(busIdx: Int): Boolean {
        return ObjectCalls.ptrcallWithIntArgRetBool(isBusSoloBind, singleton, busIdx)
    }

    fun setBusMute(busIdx: Int, enable: Boolean) {
        ObjectCalls.ptrcallWithIntAndBoolArgs(setBusMuteBind, singleton, busIdx, enable)
    }

    fun isBusMute(busIdx: Int): Boolean {
        return ObjectCalls.ptrcallWithIntArgRetBool(isBusMuteBind, singleton, busIdx)
    }

    fun setBusBypassEffects(busIdx: Int, enable: Boolean) {
        ObjectCalls.ptrcallWithIntAndBoolArgs(setBusBypassEffectsBind, singleton, busIdx, enable)
    }

    fun isBusBypassingEffects(busIdx: Int): Boolean {
        return ObjectCalls.ptrcallWithIntArgRetBool(isBusBypassingEffectsBind, singleton, busIdx)
    }

    fun addBusEffect(busIdx: Int, effect: AudioEffect?, atPosition: Int = -1) {
        ObjectCalls.ptrcallWithIntObjectAndIntArgs(addBusEffectBind, singleton, busIdx, effect?.requireOpenHandle() ?: MemorySegment.NULL, atPosition)
    }

    fun removeBusEffect(busIdx: Int, effectIdx: Int) {
        ObjectCalls.ptrcallWithTwoIntArgs(removeBusEffectBind, singleton, busIdx, effectIdx)
    }

    fun getBusEffectCount(busIdx: Int): Int {
        return ObjectCalls.ptrcallWithIntArgRetInt(getBusEffectCountBind, singleton, busIdx)
    }

    fun getBusEffect(busIdx: Int, effectIdx: Int): AudioEffect? {
        return AudioEffect.wrap(ObjectCalls.ptrcallWithTwoIntArgsRetObject(getBusEffectBind, singleton, busIdx, effectIdx))
    }

    fun getBusEffectInstance(busIdx: Int, effectIdx: Int, channel: Int = 0): AudioEffectInstance? {
        return AudioEffectInstance.wrap(ObjectCalls.ptrcallWithThreeIntArgsRetObject(getBusEffectInstanceBind, singleton, busIdx, effectIdx, channel))
    }

    fun swapBusEffects(busIdx: Int, effectIdx: Int, byEffectIdx: Int) {
        ObjectCalls.ptrcallWithThreeIntArgs(swapBusEffectsBind, singleton, busIdx, effectIdx, byEffectIdx)
    }

    fun setBusEffectEnabled(busIdx: Int, effectIdx: Int, enabled: Boolean) {
        ObjectCalls.ptrcallWithTwoIntAndBoolArgs(setBusEffectEnabledBind, singleton, busIdx, effectIdx, enabled)
    }

    fun isBusEffectEnabled(busIdx: Int, effectIdx: Int): Boolean {
        return ObjectCalls.ptrcallWithTwoIntArgsRetBool(isBusEffectEnabledBind, singleton, busIdx, effectIdx)
    }

    fun getBusPeakVolumeLeftDb(busIdx: Int, channel: Int): Double {
        return ObjectCalls.ptrcallWithTwoIntArgsRetDouble(getBusPeakVolumeLeftDbBind, singleton, busIdx, channel)
    }

    fun getBusPeakVolumeRightDb(busIdx: Int, channel: Int): Double {
        return ObjectCalls.ptrcallWithTwoIntArgsRetDouble(getBusPeakVolumeRightDbBind, singleton, busIdx, channel)
    }

    fun setPlaybackSpeedScale(scale: Double) {
        ObjectCalls.ptrcallWithDoubleArg(setPlaybackSpeedScaleBind, singleton, scale)
    }

    fun getPlaybackSpeedScale(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getPlaybackSpeedScaleBind, singleton)
    }

    fun lock() {
        ObjectCalls.ptrcallNoArgs(lockBind, singleton)
    }

    fun unlock() {
        ObjectCalls.ptrcallNoArgs(unlockBind, singleton)
    }

    fun getSpeakerMode(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getSpeakerModeBind, singleton)
    }

    fun getMixRate(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getMixRateBind, singleton)
    }

    fun getInputMixRate(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getInputMixRateBind, singleton)
    }

    fun getDriverName(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getDriverNameBind, singleton)
    }

    fun getOutputDeviceList(): List<String> {
        return ObjectCalls.ptrcallNoArgsRetPackedStringList(getOutputDeviceListBind, singleton)
    }

    fun getOutputDevice(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getOutputDeviceBind, singleton)
    }

    fun setOutputDevice(name: String) {
        ObjectCalls.ptrcallWithStringArg(setOutputDeviceBind, singleton, name)
    }

    fun getTimeToNextMix(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getTimeToNextMixBind, singleton)
    }

    fun getTimeSinceLastMix(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getTimeSinceLastMixBind, singleton)
    }

    fun getOutputLatency(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getOutputLatencyBind, singleton)
    }

    fun getInputDeviceList(): List<String> {
        return ObjectCalls.ptrcallNoArgsRetPackedStringList(getInputDeviceListBind, singleton)
    }

    fun getInputDevice(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getInputDeviceBind, singleton)
    }

    fun setInputDevice(name: String) {
        ObjectCalls.ptrcallWithStringArg(setInputDeviceBind, singleton, name)
    }

    fun setInputDeviceActive(active: Boolean): Long {
        return ObjectCalls.ptrcallWithBoolArgRetLong(setInputDeviceActiveBind, singleton, active)
    }

    fun getInputFramesAvailable(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getInputFramesAvailableBind, singleton)
    }

    fun getInputBufferLengthFrames(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getInputBufferLengthFramesBind, singleton)
    }

    fun setBusLayout(busLayout: AudioBusLayout?) {
        ObjectCalls.ptrcallWithObjectArgs(setBusLayoutBind, singleton, listOf(busLayout?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    fun generateBusLayout(): AudioBusLayout? {
        return AudioBusLayout.wrap(ObjectCalls.ptrcallNoArgsRetObject(generateBusLayoutBind, singleton))
    }

    fun setEnableTaggingUsedAudioStreams(enable: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setEnableTaggingUsedAudioStreamsBind, singleton, enable)
    }

    fun isStreamRegisteredAsSample(stream: AudioStream?): Boolean {
        return ObjectCalls.ptrcallWithObjectArgRetBool(isStreamRegisteredAsSampleBind, singleton, stream?.requireOpenHandle() ?: MemorySegment.NULL)
    }

    fun registerStreamAsSample(stream: AudioStream?) {
        ObjectCalls.ptrcallWithObjectArgs(registerStreamAsSampleBind, singleton, listOf(stream?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    object Signals {
        const val busLayoutChanged: String = "bus_layout_changed"
        const val busRenamed: String = "bus_renamed"
    }

    fun fromHandle(handle: MemorySegment): AudioServer? =
        wrap(handle)

    internal fun wrap(handle: MemorySegment): AudioServer? =
        if (handle.address() == 0L) null else this

    private const val SET_BUS_COUNT_HASH = 1286410249L
    private val setBusCountBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_bus_count", SET_BUS_COUNT_HASH)
    }

    private const val GET_BUS_COUNT_HASH = 3905245786L
    private val getBusCountBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_bus_count", GET_BUS_COUNT_HASH)
    }

    private const val REMOVE_BUS_HASH = 1286410249L
    private val removeBusBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "remove_bus", REMOVE_BUS_HASH)
    }

    private const val ADD_BUS_HASH = 1025054187L
    private val addBusBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "add_bus", ADD_BUS_HASH)
    }

    private const val MOVE_BUS_HASH = 3937882851L
    private val moveBusBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "move_bus", MOVE_BUS_HASH)
    }

    private const val SET_BUS_NAME_HASH = 501894301L
    private val setBusNameBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_bus_name", SET_BUS_NAME_HASH)
    }

    private const val GET_BUS_INDEX_HASH = 2458036349L
    private val getBusIndexBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_bus_index", GET_BUS_INDEX_HASH)
    }

    private const val GET_BUS_CHANNELS_HASH = 923996154L
    private val getBusChannelsBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_bus_channels", GET_BUS_CHANNELS_HASH)
    }

    private const val SET_BUS_VOLUME_DB_HASH = 1602489585L
    private val setBusVolumeDbBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_bus_volume_db", SET_BUS_VOLUME_DB_HASH)
    }

    private const val GET_BUS_VOLUME_DB_HASH = 2339986948L
    private val getBusVolumeDbBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_bus_volume_db", GET_BUS_VOLUME_DB_HASH)
    }

    private const val SET_BUS_VOLUME_LINEAR_HASH = 1602489585L
    private val setBusVolumeLinearBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_bus_volume_linear", SET_BUS_VOLUME_LINEAR_HASH)
    }

    private const val GET_BUS_VOLUME_LINEAR_HASH = 2339986948L
    private val getBusVolumeLinearBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_bus_volume_linear", GET_BUS_VOLUME_LINEAR_HASH)
    }

    private const val SET_BUS_SEND_HASH = 3780747571L
    private val setBusSendBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_bus_send", SET_BUS_SEND_HASH)
    }

    private const val SET_BUS_SOLO_HASH = 300928843L
    private val setBusSoloBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_bus_solo", SET_BUS_SOLO_HASH)
    }

    private const val IS_BUS_SOLO_HASH = 1116898809L
    private val isBusSoloBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "is_bus_solo", IS_BUS_SOLO_HASH)
    }

    private const val SET_BUS_MUTE_HASH = 300928843L
    private val setBusMuteBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_bus_mute", SET_BUS_MUTE_HASH)
    }

    private const val IS_BUS_MUTE_HASH = 1116898809L
    private val isBusMuteBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "is_bus_mute", IS_BUS_MUTE_HASH)
    }

    private const val SET_BUS_BYPASS_EFFECTS_HASH = 300928843L
    private val setBusBypassEffectsBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_bus_bypass_effects", SET_BUS_BYPASS_EFFECTS_HASH)
    }

    private const val IS_BUS_BYPASSING_EFFECTS_HASH = 1116898809L
    private val isBusBypassingEffectsBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "is_bus_bypassing_effects", IS_BUS_BYPASSING_EFFECTS_HASH)
    }

    private const val ADD_BUS_EFFECT_HASH = 4068819785L
    private val addBusEffectBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "add_bus_effect", ADD_BUS_EFFECT_HASH)
    }

    private const val REMOVE_BUS_EFFECT_HASH = 3937882851L
    private val removeBusEffectBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "remove_bus_effect", REMOVE_BUS_EFFECT_HASH)
    }

    private const val GET_BUS_EFFECT_COUNT_HASH = 3744713108L
    private val getBusEffectCountBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_bus_effect_count", GET_BUS_EFFECT_COUNT_HASH)
    }

    private const val GET_BUS_EFFECT_HASH = 726064442L
    private val getBusEffectBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_bus_effect", GET_BUS_EFFECT_HASH)
    }

    private const val GET_BUS_EFFECT_INSTANCE_HASH = 1829771234L
    private val getBusEffectInstanceBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_bus_effect_instance", GET_BUS_EFFECT_INSTANCE_HASH)
    }

    private const val SWAP_BUS_EFFECTS_HASH = 1649997291L
    private val swapBusEffectsBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "swap_bus_effects", SWAP_BUS_EFFECTS_HASH)
    }

    private const val SET_BUS_EFFECT_ENABLED_HASH = 1383440665L
    private val setBusEffectEnabledBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_bus_effect_enabled", SET_BUS_EFFECT_ENABLED_HASH)
    }

    private const val IS_BUS_EFFECT_ENABLED_HASH = 2522259332L
    private val isBusEffectEnabledBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "is_bus_effect_enabled", IS_BUS_EFFECT_ENABLED_HASH)
    }

    private const val GET_BUS_PEAK_VOLUME_LEFT_DB_HASH = 3085491603L
    private val getBusPeakVolumeLeftDbBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_bus_peak_volume_left_db", GET_BUS_PEAK_VOLUME_LEFT_DB_HASH)
    }

    private const val GET_BUS_PEAK_VOLUME_RIGHT_DB_HASH = 3085491603L
    private val getBusPeakVolumeRightDbBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_bus_peak_volume_right_db", GET_BUS_PEAK_VOLUME_RIGHT_DB_HASH)
    }

    private const val SET_PLAYBACK_SPEED_SCALE_HASH = 373806689L
    private val setPlaybackSpeedScaleBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_playback_speed_scale", SET_PLAYBACK_SPEED_SCALE_HASH)
    }

    private const val GET_PLAYBACK_SPEED_SCALE_HASH = 1740695150L
    private val getPlaybackSpeedScaleBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_playback_speed_scale", GET_PLAYBACK_SPEED_SCALE_HASH)
    }

    private const val LOCK_HASH = 3218959716L
    private val lockBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "lock", LOCK_HASH)
    }

    private const val UNLOCK_HASH = 3218959716L
    private val unlockBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "unlock", UNLOCK_HASH)
    }

    private const val GET_SPEAKER_MODE_HASH = 2549190337L
    private val getSpeakerModeBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_speaker_mode", GET_SPEAKER_MODE_HASH)
    }

    private const val GET_MIX_RATE_HASH = 1740695150L
    private val getMixRateBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_mix_rate", GET_MIX_RATE_HASH)
    }

    private const val GET_INPUT_MIX_RATE_HASH = 1740695150L
    private val getInputMixRateBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_input_mix_rate", GET_INPUT_MIX_RATE_HASH)
    }

    private const val GET_DRIVER_NAME_HASH = 201670096L
    private val getDriverNameBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_driver_name", GET_DRIVER_NAME_HASH)
    }

    private const val GET_OUTPUT_DEVICE_LIST_HASH = 2981934095L
    private val getOutputDeviceListBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_output_device_list", GET_OUTPUT_DEVICE_LIST_HASH)
    }

    private const val GET_OUTPUT_DEVICE_HASH = 2841200299L
    private val getOutputDeviceBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_output_device", GET_OUTPUT_DEVICE_HASH)
    }

    private const val SET_OUTPUT_DEVICE_HASH = 83702148L
    private val setOutputDeviceBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_output_device", SET_OUTPUT_DEVICE_HASH)
    }

    private const val GET_TIME_TO_NEXT_MIX_HASH = 1740695150L
    private val getTimeToNextMixBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_time_to_next_mix", GET_TIME_TO_NEXT_MIX_HASH)
    }

    private const val GET_TIME_SINCE_LAST_MIX_HASH = 1740695150L
    private val getTimeSinceLastMixBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_time_since_last_mix", GET_TIME_SINCE_LAST_MIX_HASH)
    }

    private const val GET_OUTPUT_LATENCY_HASH = 1740695150L
    private val getOutputLatencyBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_output_latency", GET_OUTPUT_LATENCY_HASH)
    }

    private const val GET_INPUT_DEVICE_LIST_HASH = 2981934095L
    private val getInputDeviceListBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_input_device_list", GET_INPUT_DEVICE_LIST_HASH)
    }

    private const val GET_INPUT_DEVICE_HASH = 2841200299L
    private val getInputDeviceBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_input_device", GET_INPUT_DEVICE_HASH)
    }

    private const val SET_INPUT_DEVICE_HASH = 83702148L
    private val setInputDeviceBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_input_device", SET_INPUT_DEVICE_HASH)
    }

    private const val SET_INPUT_DEVICE_ACTIVE_HASH = 1413768114L
    private val setInputDeviceActiveBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_input_device_active", SET_INPUT_DEVICE_ACTIVE_HASH)
    }

    private const val GET_INPUT_FRAMES_AVAILABLE_HASH = 2455072627L
    private val getInputFramesAvailableBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_input_frames_available", GET_INPUT_FRAMES_AVAILABLE_HASH)
    }

    private const val GET_INPUT_BUFFER_LENGTH_FRAMES_HASH = 2455072627L
    private val getInputBufferLengthFramesBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "get_input_buffer_length_frames", GET_INPUT_BUFFER_LENGTH_FRAMES_HASH)
    }

    private const val SET_BUS_LAYOUT_HASH = 3319058824L
    private val setBusLayoutBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_bus_layout", SET_BUS_LAYOUT_HASH)
    }

    private const val GENERATE_BUS_LAYOUT_HASH = 3769973890L
    private val generateBusLayoutBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "generate_bus_layout", GENERATE_BUS_LAYOUT_HASH)
    }

    private const val SET_ENABLE_TAGGING_USED_AUDIO_STREAMS_HASH = 2586408642L
    private val setEnableTaggingUsedAudioStreamsBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "set_enable_tagging_used_audio_streams", SET_ENABLE_TAGGING_USED_AUDIO_STREAMS_HASH)
    }

    private const val IS_STREAM_REGISTERED_AS_SAMPLE_HASH = 500225754L
    private val isStreamRegisteredAsSampleBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "is_stream_registered_as_sample", IS_STREAM_REGISTERED_AS_SAMPLE_HASH)
    }

    private const val REGISTER_STREAM_AS_SAMPLE_HASH = 2210767741L
    private val registerStreamAsSampleBind by lazy {
        ObjectCalls.getMethodBind("AudioServer", "register_stream_as_sample", REGISTER_STREAM_AS_SAMPLE_HASH)
    }
}
