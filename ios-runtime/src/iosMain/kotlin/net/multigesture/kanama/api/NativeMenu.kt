package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*
import net.multigesture.kanama.types.RID
import net.multigesture.kanama.types.Vector2
import net.multigesture.kanama.types.Vector2i

/**
 * Generated from Godot docs: NativeMenu
 */
object NativeMenu {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("NativeMenu")
    }

    const val FEATURE_GLOBAL_MENU: Long = 0L
    const val FEATURE_POPUP_MENU: Long = 1L
    const val FEATURE_OPEN_CLOSE_CALLBACK: Long = 2L
    const val FEATURE_HOVER_CALLBACK: Long = 3L
    const val FEATURE_KEY_CALLBACK: Long = 4L
    const val INVALID_MENU_ID: Long = 0L
    const val MAIN_MENU_ID: Long = 1L
    const val APPLICATION_MENU_ID: Long = 2L
    const val WINDOW_MENU_ID: Long = 3L
    const val HELP_MENU_ID: Long = 4L
    const val DOCK_MENU_ID: Long = 5L

    fun hasFeature(feature: Long): Boolean {
        return ObjectCalls.ptrcallWithLongArgRetBool(hasFeatureBind, singleton, feature)
    }

    fun hasSystemMenu(menuId: Long): Boolean {
        return ObjectCalls.ptrcallWithLongArgRetBool(hasSystemMenuBind, singleton, menuId)
    }

    fun getSystemMenu(menuId: Long): RID {
        return ObjectCalls.ptrcallWithLongArgRetRID(getSystemMenuBind, singleton, menuId)
    }

    fun setSystemMenuText(menuId: Long, name: String) {
        ObjectCalls.ptrcallWithLongAndStringArg(setSystemMenuTextBind, singleton, menuId, name)
    }

    fun createMenu(): RID {
        return ObjectCalls.ptrcallNoArgsRetRID(createMenuBind, singleton)
    }

    fun hasMenu(rid: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(hasMenuBind, singleton, rid)
    }

    fun freeMenu(rid: RID) {
        ObjectCalls.ptrcallWithRIDArg(freeMenuBind, singleton, rid)
    }

    fun getSize(rid: RID): Vector2 {
        return ObjectCalls.ptrcallWithRIDArgRetVector2(getSizeBind, singleton, rid)
    }

    fun popup(rid: RID, position: Vector2i) {
        ObjectCalls.ptrcallWithRIDAndVector2iArg(popupBind, singleton, rid, position)
    }

    fun setInterfaceDirection(rid: RID, isRtl: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(setInterfaceDirectionBind, singleton, rid, isRtl)
    }

    fun setPopupOpenCallback(rid: RID, callback: GodotCallable) {
        ObjectCalls.ptrcallWithRIDCallableArgs(setPopupOpenCallbackBind, singleton, rid, callback.target.handle, callback.method)
    }

    fun setPopupCloseCallback(rid: RID, callback: GodotCallable) {
        ObjectCalls.ptrcallWithRIDCallableArgs(setPopupCloseCallbackBind, singleton, rid, callback.target.handle, callback.method)
    }

    fun setMinimumWidth(rid: RID, width: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(setMinimumWidthBind, singleton, rid, width)
    }

    fun getMinimumWidth(rid: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(getMinimumWidthBind, singleton, rid)
    }

    fun isOpened(rid: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(isOpenedBind, singleton, rid)
    }

    fun addSeparator(rid: RID, index: Int = -1): Int {
        return ObjectCalls.ptrcallWithRIDAndIntArgRetInt(addSeparatorBind, singleton, rid, index)
    }

    fun findItemIndexWithText(rid: RID, text: String): Int {
        return ObjectCalls.ptrcallWithRIDAndStringArgRetInt(findItemIndexWithTextBind, singleton, rid, text)
    }

    fun findItemIndexWithSubmenu(rid: RID, submenuRid: RID): Int {
        return ObjectCalls.ptrcallWithTwoRIDArgsRetInt(findItemIndexWithSubmenuBind, singleton, rid, submenuRid)
    }

    fun isItemChecked(rid: RID, idx: Int): Boolean {
        return ObjectCalls.ptrcallWithRIDAndIntArgRetBool(isItemCheckedBind, singleton, rid, idx)
    }

    fun isItemCheckable(rid: RID, idx: Int): Boolean {
        return ObjectCalls.ptrcallWithRIDAndIntArgRetBool(isItemCheckableBind, singleton, rid, idx)
    }

    fun isItemRadioCheckable(rid: RID, idx: Int): Boolean {
        return ObjectCalls.ptrcallWithRIDAndIntArgRetBool(isItemRadioCheckableBind, singleton, rid, idx)
    }

    fun getItemSubmenu(rid: RID, idx: Int): RID {
        return ObjectCalls.ptrcallWithRIDAndIntArgRetRID(getItemSubmenuBind, singleton, rid, idx)
    }

    fun getItemAccelerator(rid: RID, idx: Int): Long {
        return ObjectCalls.ptrcallWithRIDAndIntArgRetLong(getItemAcceleratorBind, singleton, rid, idx)
    }

    fun isItemDisabled(rid: RID, idx: Int): Boolean {
        return ObjectCalls.ptrcallWithRIDAndIntArgRetBool(isItemDisabledBind, singleton, rid, idx)
    }

    fun isItemHidden(rid: RID, idx: Int): Boolean {
        return ObjectCalls.ptrcallWithRIDAndIntArgRetBool(isItemHiddenBind, singleton, rid, idx)
    }

    fun getItemState(rid: RID, idx: Int): Int {
        return ObjectCalls.ptrcallWithRIDAndIntArgRetInt(getItemStateBind, singleton, rid, idx)
    }

    fun getItemMaxStates(rid: RID, idx: Int): Int {
        return ObjectCalls.ptrcallWithRIDAndIntArgRetInt(getItemMaxStatesBind, singleton, rid, idx)
    }

    fun getItemIcon(rid: RID, idx: Int): Texture2D? {
        return Texture2D.wrap(ObjectCalls.ptrcallWithRIDAndIntArgRetObject(getItemIconBind, singleton, rid, idx))
    }

    fun getItemIndentationLevel(rid: RID, idx: Int): Int {
        return ObjectCalls.ptrcallWithRIDAndIntArgRetInt(getItemIndentationLevelBind, singleton, rid, idx)
    }

    fun setItemChecked(rid: RID, idx: Int, checked: Boolean) {
        ObjectCalls.ptrcallWithRIDIntAndBoolArgs(setItemCheckedBind, singleton, rid, idx, checked)
    }

    fun setItemCheckable(rid: RID, idx: Int, checkable: Boolean) {
        ObjectCalls.ptrcallWithRIDIntAndBoolArgs(setItemCheckableBind, singleton, rid, idx, checkable)
    }

    fun setItemRadioCheckable(rid: RID, idx: Int, checkable: Boolean) {
        ObjectCalls.ptrcallWithRIDIntAndBoolArgs(setItemRadioCheckableBind, singleton, rid, idx, checkable)
    }

    fun setItemCallback(rid: RID, idx: Int, callback: GodotCallable) {
        ObjectCalls.ptrcallWithRIDIntCallableArgs(setItemCallbackBind, singleton, rid, idx, callback.target.handle, callback.method)
    }

    fun setItemHoverCallbacks(rid: RID, idx: Int, callback: GodotCallable) {
        ObjectCalls.ptrcallWithRIDIntCallableArgs(setItemHoverCallbacksBind, singleton, rid, idx, callback.target.handle, callback.method)
    }

    fun setItemKeyCallback(rid: RID, idx: Int, keyCallback: GodotCallable) {
        ObjectCalls.ptrcallWithRIDIntCallableArgs(setItemKeyCallbackBind, singleton, rid, idx, keyCallback.target.handle, keyCallback.method)
    }

    fun setItemText(rid: RID, idx: Int, text: String) {
        ObjectCalls.ptrcallWithRIDIntAndStringArgs(setItemTextBind, singleton, rid, idx, text)
    }

    fun setItemSubmenu(rid: RID, idx: Int, submenuRid: RID) {
        ObjectCalls.ptrcallWithRIDIntAndRIDArgs(setItemSubmenuBind, singleton, rid, idx, submenuRid)
    }

    fun setItemAccelerator(rid: RID, idx: Int, keycode: Long) {
        ObjectCalls.ptrcallWithRIDIntLongArgs(setItemAcceleratorBind, singleton, rid, idx, keycode)
    }

    fun setItemDisabled(rid: RID, idx: Int, disabled: Boolean) {
        ObjectCalls.ptrcallWithRIDIntAndBoolArgs(setItemDisabledBind, singleton, rid, idx, disabled)
    }

    fun setItemHidden(rid: RID, idx: Int, hidden: Boolean) {
        ObjectCalls.ptrcallWithRIDIntAndBoolArgs(setItemHiddenBind, singleton, rid, idx, hidden)
    }

    fun setItemTooltip(rid: RID, idx: Int, tooltip: String) {
        ObjectCalls.ptrcallWithRIDIntAndStringArgs(setItemTooltipBind, singleton, rid, idx, tooltip)
    }

    fun setItemState(rid: RID, idx: Int, state: Int) {
        ObjectCalls.ptrcallWithRIDAndTwoIntArgs(setItemStateBind, singleton, rid, idx, state)
    }

    fun setItemMaxStates(rid: RID, idx: Int, maxStates: Int) {
        ObjectCalls.ptrcallWithRIDAndTwoIntArgs(setItemMaxStatesBind, singleton, rid, idx, maxStates)
    }

    fun setItemIcon(rid: RID, idx: Int, icon: Texture2D?) {
        ObjectCalls.ptrcallWithRIDIntAndObjectArg(setItemIconBind, singleton, rid, idx, icon?.requireOpenHandle() ?: MemorySegment.NULL)
    }

    fun setItemIndentationLevel(rid: RID, idx: Int, level: Int) {
        ObjectCalls.ptrcallWithRIDAndTwoIntArgs(setItemIndentationLevelBind, singleton, rid, idx, level)
    }

    fun setItemIndex(rid: RID, idx: Int, targetIdx: Int): Int {
        return ObjectCalls.ptrcallWithRIDAndTwoIntArgsRetInt(setItemIndexBind, singleton, rid, idx, targetIdx)
    }

    fun getItemCount(rid: RID): Int {
        return ObjectCalls.ptrcallWithRIDArgRetInt(getItemCountBind, singleton, rid)
    }

    fun isSystemMenu(rid: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(isSystemMenuBind, singleton, rid)
    }

    fun removeItem(rid: RID, idx: Int) {
        ObjectCalls.ptrcallWithRIDAndIntArg(removeItemBind, singleton, rid, idx)
    }

    fun clear(rid: RID) {
        ObjectCalls.ptrcallWithRIDArg(clearBind, singleton, rid)
    }

    fun fromHandle(handle: MemorySegment): NativeMenu? =
        wrap(handle)

    internal fun wrap(handle: MemorySegment): NativeMenu? =
        if (handle.address() == 0L) null else this

    private const val HAS_FEATURE_HASH = 1708975490L
    private val hasFeatureBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "has_feature", HAS_FEATURE_HASH)
    }

    private const val HAS_SYSTEM_MENU_HASH = 718213027L
    private val hasSystemMenuBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "has_system_menu", HAS_SYSTEM_MENU_HASH)
    }

    private const val GET_SYSTEM_MENU_HASH = 469707506L
    private val getSystemMenuBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "get_system_menu", GET_SYSTEM_MENU_HASH)
    }

    private const val SET_SYSTEM_MENU_TEXT_HASH = 3925225603L
    private val setSystemMenuTextBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_system_menu_text", SET_SYSTEM_MENU_TEXT_HASH)
    }

    private const val CREATE_MENU_HASH = 529393457L
    private val createMenuBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "create_menu", CREATE_MENU_HASH)
    }

    private const val HAS_MENU_HASH = 4155700596L
    private val hasMenuBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "has_menu", HAS_MENU_HASH)
    }

    private const val FREE_MENU_HASH = 2722037293L
    private val freeMenuBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "free_menu", FREE_MENU_HASH)
    }

    private const val GET_SIZE_HASH = 2440833711L
    private val getSizeBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "get_size", GET_SIZE_HASH)
    }

    private const val POPUP_HASH = 2450610377L
    private val popupBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "popup", POPUP_HASH)
    }

    private const val SET_INTERFACE_DIRECTION_HASH = 1265174801L
    private val setInterfaceDirectionBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_interface_direction", SET_INTERFACE_DIRECTION_HASH)
    }

    private const val SET_POPUP_OPEN_CALLBACK_HASH = 3379118538L
    private val setPopupOpenCallbackBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_popup_open_callback", SET_POPUP_OPEN_CALLBACK_HASH)
    }

    private const val SET_POPUP_CLOSE_CALLBACK_HASH = 3379118538L
    private val setPopupCloseCallbackBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_popup_close_callback", SET_POPUP_CLOSE_CALLBACK_HASH)
    }

    private const val SET_MINIMUM_WIDTH_HASH = 1794382983L
    private val setMinimumWidthBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_minimum_width", SET_MINIMUM_WIDTH_HASH)
    }

    private const val GET_MINIMUM_WIDTH_HASH = 866169185L
    private val getMinimumWidthBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "get_minimum_width", GET_MINIMUM_WIDTH_HASH)
    }

    private const val IS_OPENED_HASH = 4155700596L
    private val isOpenedBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "is_opened", IS_OPENED_HASH)
    }

    private const val ADD_SEPARATOR_HASH = 448810126L
    private val addSeparatorBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "add_separator", ADD_SEPARATOR_HASH)
    }

    private const val FIND_ITEM_INDEX_WITH_TEXT_HASH = 1362438794L
    private val findItemIndexWithTextBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "find_item_index_with_text", FIND_ITEM_INDEX_WITH_TEXT_HASH)
    }

    private const val FIND_ITEM_INDEX_WITH_SUBMENU_HASH = 893635918L
    private val findItemIndexWithSubmenuBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "find_item_index_with_submenu", FIND_ITEM_INDEX_WITH_SUBMENU_HASH)
    }

    private const val IS_ITEM_CHECKED_HASH = 3120086654L
    private val isItemCheckedBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "is_item_checked", IS_ITEM_CHECKED_HASH)
    }

    private const val IS_ITEM_CHECKABLE_HASH = 3120086654L
    private val isItemCheckableBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "is_item_checkable", IS_ITEM_CHECKABLE_HASH)
    }

    private const val IS_ITEM_RADIO_CHECKABLE_HASH = 3120086654L
    private val isItemRadioCheckableBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "is_item_radio_checkable", IS_ITEM_RADIO_CHECKABLE_HASH)
    }

    private const val GET_ITEM_SUBMENU_HASH = 1066463050L
    private val getItemSubmenuBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "get_item_submenu", GET_ITEM_SUBMENU_HASH)
    }

    private const val GET_ITEM_ACCELERATOR_HASH = 316800700L
    private val getItemAcceleratorBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "get_item_accelerator", GET_ITEM_ACCELERATOR_HASH)
    }

    private const val IS_ITEM_DISABLED_HASH = 3120086654L
    private val isItemDisabledBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "is_item_disabled", IS_ITEM_DISABLED_HASH)
    }

    private const val IS_ITEM_HIDDEN_HASH = 3120086654L
    private val isItemHiddenBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "is_item_hidden", IS_ITEM_HIDDEN_HASH)
    }

    private const val GET_ITEM_STATE_HASH = 1120910005L
    private val getItemStateBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "get_item_state", GET_ITEM_STATE_HASH)
    }

    private const val GET_ITEM_MAX_STATES_HASH = 1120910005L
    private val getItemMaxStatesBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "get_item_max_states", GET_ITEM_MAX_STATES_HASH)
    }

    private const val GET_ITEM_ICON_HASH = 3391850701L
    private val getItemIconBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "get_item_icon", GET_ITEM_ICON_HASH)
    }

    private const val GET_ITEM_INDENTATION_LEVEL_HASH = 1120910005L
    private val getItemIndentationLevelBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "get_item_indentation_level", GET_ITEM_INDENTATION_LEVEL_HASH)
    }

    private const val SET_ITEM_CHECKED_HASH = 2658558584L
    private val setItemCheckedBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_checked", SET_ITEM_CHECKED_HASH)
    }

    private const val SET_ITEM_CHECKABLE_HASH = 2658558584L
    private val setItemCheckableBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_checkable", SET_ITEM_CHECKABLE_HASH)
    }

    private const val SET_ITEM_RADIO_CHECKABLE_HASH = 2658558584L
    private val setItemRadioCheckableBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_radio_checkable", SET_ITEM_RADIO_CHECKABLE_HASH)
    }

    private const val SET_ITEM_CALLBACK_HASH = 2779810226L
    private val setItemCallbackBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_callback", SET_ITEM_CALLBACK_HASH)
    }

    private const val SET_ITEM_HOVER_CALLBACKS_HASH = 2779810226L
    private val setItemHoverCallbacksBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_hover_callbacks", SET_ITEM_HOVER_CALLBACKS_HASH)
    }

    private const val SET_ITEM_KEY_CALLBACK_HASH = 2779810226L
    private val setItemKeyCallbackBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_key_callback", SET_ITEM_KEY_CALLBACK_HASH)
    }

    private const val SET_ITEM_TEXT_HASH = 4153150897L
    private val setItemTextBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_text", SET_ITEM_TEXT_HASH)
    }

    private const val SET_ITEM_SUBMENU_HASH = 2310537182L
    private val setItemSubmenuBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_submenu", SET_ITEM_SUBMENU_HASH)
    }

    private const val SET_ITEM_ACCELERATOR_HASH = 786300043L
    private val setItemAcceleratorBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_accelerator", SET_ITEM_ACCELERATOR_HASH)
    }

    private const val SET_ITEM_DISABLED_HASH = 2658558584L
    private val setItemDisabledBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_disabled", SET_ITEM_DISABLED_HASH)
    }

    private const val SET_ITEM_HIDDEN_HASH = 2658558584L
    private val setItemHiddenBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_hidden", SET_ITEM_HIDDEN_HASH)
    }

    private const val SET_ITEM_TOOLTIP_HASH = 4153150897L
    private val setItemTooltipBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_tooltip", SET_ITEM_TOOLTIP_HASH)
    }

    private const val SET_ITEM_STATE_HASH = 4288446313L
    private val setItemStateBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_state", SET_ITEM_STATE_HASH)
    }

    private const val SET_ITEM_MAX_STATES_HASH = 4288446313L
    private val setItemMaxStatesBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_max_states", SET_ITEM_MAX_STATES_HASH)
    }

    private const val SET_ITEM_ICON_HASH = 1388763257L
    private val setItemIconBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_icon", SET_ITEM_ICON_HASH)
    }

    private const val SET_ITEM_INDENTATION_LEVEL_HASH = 4288446313L
    private val setItemIndentationLevelBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_indentation_level", SET_ITEM_INDENTATION_LEVEL_HASH)
    }

    private const val SET_ITEM_INDEX_HASH = 23951185L
    private val setItemIndexBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "set_item_index", SET_ITEM_INDEX_HASH)
    }

    private const val GET_ITEM_COUNT_HASH = 2198884583L
    private val getItemCountBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "get_item_count", GET_ITEM_COUNT_HASH)
    }

    private const val IS_SYSTEM_MENU_HASH = 4155700596L
    private val isSystemMenuBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "is_system_menu", IS_SYSTEM_MENU_HASH)
    }

    private const val REMOVE_ITEM_HASH = 3411492887L
    private val removeItemBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "remove_item", REMOVE_ITEM_HASH)
    }

    private const val CLEAR_HASH = 2722037293L
    private val clearBind by lazy {
        ObjectCalls.getMethodBind("NativeMenu", "clear", CLEAR_HASH)
    }
}
