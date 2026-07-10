package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*
import net.multigesture.kanama.types.Vector2i

/**
 * Generated from Godot docs: EditorInterface
 */
object EditorInterface {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("EditorInterface")
    }

    var distractionFreeMode: Boolean
        @JvmName("distractionFreeModeProperty")
        get() = isDistractionFreeModeEnabled()
        @JvmName("setDistractionFreeModeProperty")
        set(value) = setDistractionFreeMode(value)

    var movieMakerEnabled: Boolean
        @JvmName("movieMakerEnabledProperty")
        get() = isMovieMakerEnabled()
        @JvmName("setMovieMakerEnabledProperty")
        set(value) = setMovieMakerEnabled(value)

    fun restartEditor(save: Boolean = true) {
        ObjectCalls.ptrcallWithBoolArg(restartEditorBind, singleton, save)
    }

    fun getCommandPalette(): EditorCommandPalette? {
        return EditorCommandPalette.wrap(ObjectCalls.ptrcallNoArgsRetObject(getCommandPaletteBind, singleton))
    }

    fun getResourceFilesystem(): EditorFileSystem? {
        return EditorFileSystem.wrap(ObjectCalls.ptrcallNoArgsRetObject(getResourceFilesystemBind, singleton))
    }

    fun getEditorPaths(): EditorPaths? {
        return EditorPaths.wrap(ObjectCalls.ptrcallNoArgsRetObject(getEditorPathsBind, singleton))
    }

    fun getResourcePreviewer(): EditorResourcePreview? {
        return EditorResourcePreview.wrap(ObjectCalls.ptrcallNoArgsRetObject(getResourcePreviewerBind, singleton))
    }

    fun getSelection(): EditorSelection? {
        return EditorSelection.wrap(ObjectCalls.ptrcallNoArgsRetObject(getSelectionBind, singleton))
    }

    fun getEditorSettings(): EditorSettings? {
        return EditorSettings.wrap(ObjectCalls.ptrcallNoArgsRetObject(getEditorSettingsBind, singleton))
    }

    fun getEditorToaster(): EditorToaster? {
        return EditorToaster.wrap(ObjectCalls.ptrcallNoArgsRetObject(getEditorToasterBind, singleton))
    }

    fun getEditorUndoRedo(): EditorUndoRedoManager? {
        return EditorUndoRedoManager.wrap(ObjectCalls.ptrcallNoArgsRetObject(getEditorUndoRedoBind, singleton))
    }

    fun setPluginEnabled(plugin: String, enabled: Boolean) {
        ObjectCalls.ptrcallWithStringAndBoolArg(setPluginEnabledBind, singleton, plugin, enabled)
    }

    fun isPluginEnabled(plugin: String): Boolean {
        return ObjectCalls.ptrcallWithStringArgRetBool(isPluginEnabledBind, singleton, plugin)
    }

    fun getEditorTheme(): Theme? {
        return Theme.wrap(ObjectCalls.ptrcallNoArgsRetObject(getEditorThemeBind, singleton))
    }

    fun getBaseControl(): Control? {
        return Control.wrap(ObjectCalls.ptrcallNoArgsRetObject(getBaseControlBind, singleton))
    }

    fun getEditorMainScreen(): VBoxContainer? {
        return VBoxContainer.wrap(ObjectCalls.ptrcallNoArgsRetObject(getEditorMainScreenBind, singleton))
    }

    fun getScriptEditor(): ScriptEditor? {
        return ScriptEditor.wrap(ObjectCalls.ptrcallNoArgsRetObject(getScriptEditorBind, singleton))
    }

    fun getEditorViewport2d(): SubViewport? {
        return SubViewport.wrap(ObjectCalls.ptrcallNoArgsRetObject(getEditorViewport2dBind, singleton))
    }

    fun getEditorViewport3d(idx: Int = 0): SubViewport? {
        return SubViewport.wrap(ObjectCalls.ptrcallWithIntArgRetObject(getEditorViewport3dBind, singleton, idx))
    }

    fun setMainScreenEditor(name: String) {
        ObjectCalls.ptrcallWithStringArg(setMainScreenEditorBind, singleton, name)
    }

    fun setDistractionFreeMode(enter: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setDistractionFreeModeBind, singleton, enter)
    }

    fun isDistractionFreeModeEnabled(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isDistractionFreeModeEnabledBind, singleton)
    }

    fun isMultiWindowEnabled(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isMultiWindowEnabledBind, singleton)
    }

    fun getEditorScale(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getEditorScaleBind, singleton)
    }

    fun getEditorLanguage(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getEditorLanguageBind, singleton)
    }

    fun isNode3dSnapEnabled(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isNode3dSnapEnabledBind, singleton)
    }

    fun getNode3dTranslateSnap(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getNode3dTranslateSnapBind, singleton)
    }

    fun getNode3dRotateSnap(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getNode3dRotateSnapBind, singleton)
    }

    fun getNode3dScaleSnap(): Double {
        return ObjectCalls.ptrcallNoArgsRetDouble(getNode3dScaleSnapBind, singleton)
    }

    fun popupDialogCentered(dialog: Window, minsize: Vector2i) {
        ObjectCalls.ptrcallWithObjectAndVector2iArg(popupDialogCenteredBind, singleton, dialog.handle, minsize)
    }

    fun popupDialogCenteredRatio(dialog: Window, ratio: Double = 0.8) {
        ObjectCalls.ptrcallWithObjectAndDoubleArg(popupDialogCenteredRatioBind, singleton, dialog.handle, ratio)
    }

    fun popupDialogCenteredClamped(dialog: Window, minsize: Vector2i, fallbackRatio: Double = 0.75) {
        ObjectCalls.ptrcallWithObjectVector2iAndDoubleArg(popupDialogCenteredClampedBind, singleton, dialog.handle, minsize, fallbackRatio)
    }

    fun getCurrentFeatureProfile(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getCurrentFeatureProfileBind, singleton)
    }

    fun setCurrentFeatureProfile(profileName: String) {
        ObjectCalls.ptrcallWithStringArg(setCurrentFeatureProfileBind, singleton, profileName)
    }

    fun popupMethodSelector(objectValue: GodotObject, callback: GodotCallable, currentValue: String = "") {
        ObjectCalls.ptrcallWithObjectCallableStringArgs(popupMethodSelectorBind, singleton, objectValue.handle, callback.target.handle, callback.method, currentValue)
    }

    fun getFileSystemDock(): FileSystemDock? {
        return FileSystemDock.wrap(ObjectCalls.ptrcallNoArgsRetObject(getFileSystemDockBind, singleton))
    }

    fun selectFile(file: String) {
        ObjectCalls.ptrcallWithStringArg(selectFileBind, singleton, file)
    }

    fun getSelectedPaths(): List<String> {
        return ObjectCalls.ptrcallNoArgsRetPackedStringList(getSelectedPathsBind, singleton)
    }

    fun getCurrentPath(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getCurrentPathBind, singleton)
    }

    fun getCurrentDirectory(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getCurrentDirectoryBind, singleton)
    }

    fun getInspector(): EditorInspector? {
        return EditorInspector.wrap(ObjectCalls.ptrcallNoArgsRetObject(getInspectorBind, singleton))
    }

    fun inspectObject(objectValue: GodotObject, forProperty: String = "", inspectorOnly: Boolean = false) {
        ObjectCalls.ptrcallWithObjectStringBoolArgs(inspectObjectBind, singleton, objectValue.handle, forProperty, inspectorOnly)
    }

    fun editResource(resource: Resource?) {
        ObjectCalls.ptrcallWithObjectArgs(editResourceBind, singleton, listOf(resource?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    fun editNode(node: Node) {
        ObjectCalls.ptrcallWithObjectArgs(editNodeBind, singleton, listOf(node.handle))
    }

    fun editScript(script: Script?, line: Int = -1, column: Int = 0, grabFocus: Boolean = true) {
        ObjectCalls.ptrcallWithObjectTwoIntBoolArgs(editScriptBind, singleton, script?.requireOpenHandle() ?: MemorySegment.NULL, line, column, grabFocus)
    }

    fun openSceneFromPath(sceneFilepath: String, setInherited: Boolean = false) {
        ObjectCalls.ptrcallWithStringAndBoolArg(openSceneFromPathBind, singleton, sceneFilepath, setInherited)
    }

    fun reloadSceneFromPath(sceneFilepath: String) {
        ObjectCalls.ptrcallWithStringArg(reloadSceneFromPathBind, singleton, sceneFilepath)
    }

    fun setObjectEdited(objectValue: GodotObject, edited: Boolean) {
        ObjectCalls.ptrcallWithObjectAndBoolArg(setObjectEditedBind, singleton, objectValue.handle, edited)
    }

    fun isObjectEdited(objectValue: GodotObject): Boolean {
        return ObjectCalls.ptrcallWithObjectArgRetBool(isObjectEditedBind, singleton, objectValue.handle)
    }

    fun getOpenScenes(): List<String> {
        return ObjectCalls.ptrcallNoArgsRetPackedStringList(getOpenScenesBind, singleton)
    }

    fun getUnsavedScenes(): List<String> {
        return ObjectCalls.ptrcallNoArgsRetPackedStringList(getUnsavedScenesBind, singleton)
    }

    fun getOpenSceneRoots(): List<Node> {
        return ObjectCalls.ptrcallNoArgsRetTypedObjectList(getOpenSceneRootsBind, singleton, Node::fromHandle)
    }

    fun getEditedSceneRoot(): Node? {
        return Node.wrap(ObjectCalls.ptrcallNoArgsRetObject(getEditedSceneRootBind, singleton))
    }

    fun addRootNode(node: Node) {
        ObjectCalls.ptrcallWithObjectArgs(addRootNodeBind, singleton, listOf(node.handle))
    }

    fun saveScene(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(saveSceneBind, singleton)
    }

    fun saveSceneAs(path: String, withPreview: Boolean = true) {
        ObjectCalls.ptrcallWithStringAndBoolArg(saveSceneAsBind, singleton, path, withPreview)
    }

    fun saveAllScenes() {
        ObjectCalls.ptrcallNoArgs(saveAllScenesBind, singleton)
    }

    fun closeScene(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(closeSceneBind, singleton)
    }

    fun markSceneAsUnsaved() {
        ObjectCalls.ptrcallNoArgs(markSceneAsUnsavedBind, singleton)
    }

    fun playMainScene() {
        ObjectCalls.ptrcallNoArgs(playMainSceneBind, singleton)
    }

    fun playCurrentScene() {
        ObjectCalls.ptrcallNoArgs(playCurrentSceneBind, singleton)
    }

    fun playCustomScene(sceneFilepath: String) {
        ObjectCalls.ptrcallWithStringArg(playCustomSceneBind, singleton, sceneFilepath)
    }

    fun stopPlayingScene() {
        ObjectCalls.ptrcallNoArgs(stopPlayingSceneBind, singleton)
    }

    fun isPlayingScene(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isPlayingSceneBind, singleton)
    }

    fun getPlayingScene(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getPlayingSceneBind, singleton)
    }

    fun setMovieMakerEnabled(enabled: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setMovieMakerEnabledBind, singleton, enabled)
    }

    fun isMovieMakerEnabled(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isMovieMakerEnabledBind, singleton)
    }

    fun fromHandle(handle: MemorySegment): EditorInterface? =
        wrap(handle)

    internal fun wrap(handle: MemorySegment): EditorInterface? =
        if (handle.address() == 0L) null else this

    private const val RESTART_EDITOR_HASH = 3216645846L
    private val restartEditorBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "restart_editor", RESTART_EDITOR_HASH)
    }

    private const val GET_COMMAND_PALETTE_HASH = 2471163807L
    private val getCommandPaletteBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_command_palette", GET_COMMAND_PALETTE_HASH)
    }

    private const val GET_RESOURCE_FILESYSTEM_HASH = 780151678L
    private val getResourceFilesystemBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_resource_filesystem", GET_RESOURCE_FILESYSTEM_HASH)
    }

    private const val GET_EDITOR_PATHS_HASH = 1595760068L
    private val getEditorPathsBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_editor_paths", GET_EDITOR_PATHS_HASH)
    }

    private const val GET_RESOURCE_PREVIEWER_HASH = 943486957L
    private val getResourcePreviewerBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_resource_previewer", GET_RESOURCE_PREVIEWER_HASH)
    }

    private const val GET_SELECTION_HASH = 2690272531L
    private val getSelectionBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_selection", GET_SELECTION_HASH)
    }

    private const val GET_EDITOR_SETTINGS_HASH = 4086932459L
    private val getEditorSettingsBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_editor_settings", GET_EDITOR_SETTINGS_HASH)
    }

    private const val GET_EDITOR_TOASTER_HASH = 3612675797L
    private val getEditorToasterBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_editor_toaster", GET_EDITOR_TOASTER_HASH)
    }

    private const val GET_EDITOR_UNDO_REDO_HASH = 3819628421L
    private val getEditorUndoRedoBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_editor_undo_redo", GET_EDITOR_UNDO_REDO_HASH)
    }

    private const val SET_PLUGIN_ENABLED_HASH = 2678287736L
    private val setPluginEnabledBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "set_plugin_enabled", SET_PLUGIN_ENABLED_HASH)
    }

    private const val IS_PLUGIN_ENABLED_HASH = 3927539163L
    private val isPluginEnabledBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "is_plugin_enabled", IS_PLUGIN_ENABLED_HASH)
    }

    private const val GET_EDITOR_THEME_HASH = 3846893731L
    private val getEditorThemeBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_editor_theme", GET_EDITOR_THEME_HASH)
    }

    private const val GET_BASE_CONTROL_HASH = 2783021301L
    private val getBaseControlBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_base_control", GET_BASE_CONTROL_HASH)
    }

    private const val GET_EDITOR_MAIN_SCREEN_HASH = 1706218421L
    private val getEditorMainScreenBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_editor_main_screen", GET_EDITOR_MAIN_SCREEN_HASH)
    }

    private const val GET_SCRIPT_EDITOR_HASH = 90868003L
    private val getScriptEditorBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_script_editor", GET_SCRIPT_EDITOR_HASH)
    }

    private const val GET_EDITOR_VIEWPORT_2D_HASH = 3750751911L
    private val getEditorViewport2dBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_editor_viewport_2d", GET_EDITOR_VIEWPORT_2D_HASH)
    }

    private const val GET_EDITOR_VIEWPORT_3D_HASH = 1970834490L
    private val getEditorViewport3dBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_editor_viewport_3d", GET_EDITOR_VIEWPORT_3D_HASH)
    }

    private const val SET_MAIN_SCREEN_EDITOR_HASH = 83702148L
    private val setMainScreenEditorBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "set_main_screen_editor", SET_MAIN_SCREEN_EDITOR_HASH)
    }

    private const val SET_DISTRACTION_FREE_MODE_HASH = 2586408642L
    private val setDistractionFreeModeBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "set_distraction_free_mode", SET_DISTRACTION_FREE_MODE_HASH)
    }

    private const val IS_DISTRACTION_FREE_MODE_ENABLED_HASH = 36873697L
    private val isDistractionFreeModeEnabledBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "is_distraction_free_mode_enabled", IS_DISTRACTION_FREE_MODE_ENABLED_HASH)
    }

    private const val IS_MULTI_WINDOW_ENABLED_HASH = 36873697L
    private val isMultiWindowEnabledBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "is_multi_window_enabled", IS_MULTI_WINDOW_ENABLED_HASH)
    }

    private const val GET_EDITOR_SCALE_HASH = 1740695150L
    private val getEditorScaleBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_editor_scale", GET_EDITOR_SCALE_HASH)
    }

    private const val GET_EDITOR_LANGUAGE_HASH = 201670096L
    private val getEditorLanguageBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_editor_language", GET_EDITOR_LANGUAGE_HASH)
    }

    private const val IS_NODE_3D_SNAP_ENABLED_HASH = 36873697L
    private val isNode3dSnapEnabledBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "is_node_3d_snap_enabled", IS_NODE_3D_SNAP_ENABLED_HASH)
    }

    private const val GET_NODE_3D_TRANSLATE_SNAP_HASH = 1740695150L
    private val getNode3dTranslateSnapBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_node_3d_translate_snap", GET_NODE_3D_TRANSLATE_SNAP_HASH)
    }

    private const val GET_NODE_3D_ROTATE_SNAP_HASH = 1740695150L
    private val getNode3dRotateSnapBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_node_3d_rotate_snap", GET_NODE_3D_ROTATE_SNAP_HASH)
    }

    private const val GET_NODE_3D_SCALE_SNAP_HASH = 1740695150L
    private val getNode3dScaleSnapBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_node_3d_scale_snap", GET_NODE_3D_SCALE_SNAP_HASH)
    }

    private const val POPUP_DIALOG_CENTERED_HASH = 346557367L
    private val popupDialogCenteredBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "popup_dialog_centered", POPUP_DIALOG_CENTERED_HASH)
    }

    private const val POPUP_DIALOG_CENTERED_RATIO_HASH = 2093669136L
    private val popupDialogCenteredRatioBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "popup_dialog_centered_ratio", POPUP_DIALOG_CENTERED_RATIO_HASH)
    }

    private const val POPUP_DIALOG_CENTERED_CLAMPED_HASH = 3763385571L
    private val popupDialogCenteredClampedBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "popup_dialog_centered_clamped", POPUP_DIALOG_CENTERED_CLAMPED_HASH)
    }

    private const val GET_CURRENT_FEATURE_PROFILE_HASH = 201670096L
    private val getCurrentFeatureProfileBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_current_feature_profile", GET_CURRENT_FEATURE_PROFILE_HASH)
    }

    private const val SET_CURRENT_FEATURE_PROFILE_HASH = 83702148L
    private val setCurrentFeatureProfileBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "set_current_feature_profile", SET_CURRENT_FEATURE_PROFILE_HASH)
    }

    private const val POPUP_METHOD_SELECTOR_HASH = 3585505226L
    private val popupMethodSelectorBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "popup_method_selector", POPUP_METHOD_SELECTOR_HASH)
    }

    private const val GET_FILE_SYSTEM_DOCK_HASH = 3751012327L
    private val getFileSystemDockBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_file_system_dock", GET_FILE_SYSTEM_DOCK_HASH)
    }

    private const val SELECT_FILE_HASH = 83702148L
    private val selectFileBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "select_file", SELECT_FILE_HASH)
    }

    private const val GET_SELECTED_PATHS_HASH = 1139954409L
    private val getSelectedPathsBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_selected_paths", GET_SELECTED_PATHS_HASH)
    }

    private const val GET_CURRENT_PATH_HASH = 201670096L
    private val getCurrentPathBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_current_path", GET_CURRENT_PATH_HASH)
    }

    private const val GET_CURRENT_DIRECTORY_HASH = 201670096L
    private val getCurrentDirectoryBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_current_directory", GET_CURRENT_DIRECTORY_HASH)
    }

    private const val GET_INSPECTOR_HASH = 3517113938L
    private val getInspectorBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_inspector", GET_INSPECTOR_HASH)
    }

    private const val INSPECT_OBJECT_HASH = 127962172L
    private val inspectObjectBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "inspect_object", INSPECT_OBJECT_HASH)
    }

    private const val EDIT_RESOURCE_HASH = 968641751L
    private val editResourceBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "edit_resource", EDIT_RESOURCE_HASH)
    }

    private const val EDIT_NODE_HASH = 1078189570L
    private val editNodeBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "edit_node", EDIT_NODE_HASH)
    }

    private const val EDIT_SCRIPT_HASH = 219829402L
    private val editScriptBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "edit_script", EDIT_SCRIPT_HASH)
    }

    private const val OPEN_SCENE_FROM_PATH_HASH = 1168363258L
    private val openSceneFromPathBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "open_scene_from_path", OPEN_SCENE_FROM_PATH_HASH)
    }

    private const val RELOAD_SCENE_FROM_PATH_HASH = 83702148L
    private val reloadSceneFromPathBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "reload_scene_from_path", RELOAD_SCENE_FROM_PATH_HASH)
    }

    private const val SET_OBJECT_EDITED_HASH = 1462101905L
    private val setObjectEditedBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "set_object_edited", SET_OBJECT_EDITED_HASH)
    }

    private const val IS_OBJECT_EDITED_HASH = 397768994L
    private val isObjectEditedBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "is_object_edited", IS_OBJECT_EDITED_HASH)
    }

    private const val GET_OPEN_SCENES_HASH = 1139954409L
    private val getOpenScenesBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_open_scenes", GET_OPEN_SCENES_HASH)
    }

    private const val GET_UNSAVED_SCENES_HASH = 1139954409L
    private val getUnsavedScenesBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_unsaved_scenes", GET_UNSAVED_SCENES_HASH)
    }

    private const val GET_OPEN_SCENE_ROOTS_HASH = 3995934104L
    private val getOpenSceneRootsBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_open_scene_roots", GET_OPEN_SCENE_ROOTS_HASH)
    }

    private const val GET_EDITED_SCENE_ROOT_HASH = 3160264692L
    private val getEditedSceneRootBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_edited_scene_root", GET_EDITED_SCENE_ROOT_HASH)
    }

    private const val ADD_ROOT_NODE_HASH = 1078189570L
    private val addRootNodeBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "add_root_node", ADD_ROOT_NODE_HASH)
    }

    private const val SAVE_SCENE_HASH = 166280745L
    private val saveSceneBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "save_scene", SAVE_SCENE_HASH)
    }

    private const val SAVE_SCENE_AS_HASH = 3647332257L
    private val saveSceneAsBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "save_scene_as", SAVE_SCENE_AS_HASH)
    }

    private const val SAVE_ALL_SCENES_HASH = 3218959716L
    private val saveAllScenesBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "save_all_scenes", SAVE_ALL_SCENES_HASH)
    }

    private const val CLOSE_SCENE_HASH = 166280745L
    private val closeSceneBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "close_scene", CLOSE_SCENE_HASH)
    }

    private const val MARK_SCENE_AS_UNSAVED_HASH = 3218959716L
    private val markSceneAsUnsavedBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "mark_scene_as_unsaved", MARK_SCENE_AS_UNSAVED_HASH)
    }

    private const val PLAY_MAIN_SCENE_HASH = 3218959716L
    private val playMainSceneBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "play_main_scene", PLAY_MAIN_SCENE_HASH)
    }

    private const val PLAY_CURRENT_SCENE_HASH = 3218959716L
    private val playCurrentSceneBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "play_current_scene", PLAY_CURRENT_SCENE_HASH)
    }

    private const val PLAY_CUSTOM_SCENE_HASH = 83702148L
    private val playCustomSceneBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "play_custom_scene", PLAY_CUSTOM_SCENE_HASH)
    }

    private const val STOP_PLAYING_SCENE_HASH = 3218959716L
    private val stopPlayingSceneBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "stop_playing_scene", STOP_PLAYING_SCENE_HASH)
    }

    private const val IS_PLAYING_SCENE_HASH = 36873697L
    private val isPlayingSceneBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "is_playing_scene", IS_PLAYING_SCENE_HASH)
    }

    private const val GET_PLAYING_SCENE_HASH = 201670096L
    private val getPlayingSceneBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "get_playing_scene", GET_PLAYING_SCENE_HASH)
    }

    private const val SET_MOVIE_MAKER_ENABLED_HASH = 2586408642L
    private val setMovieMakerEnabledBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "set_movie_maker_enabled", SET_MOVIE_MAKER_ENABLED_HASH)
    }

    private const val IS_MOVIE_MAKER_ENABLED_HASH = 36873697L
    private val isMovieMakerEnabledBind by lazy {
        ObjectCalls.getMethodBind("EditorInterface", "is_movie_maker_enabled", IS_MOVIE_MAKER_ENABLED_HASH)
    }
}
