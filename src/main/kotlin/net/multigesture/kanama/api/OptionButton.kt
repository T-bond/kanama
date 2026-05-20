package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * A button that brings up a dropdown with selectable options when pressed.
 *
 * Generated from Godot docs: OptionButton
 */
class OptionButton(handle: MemorySegment) : Button(handle) {
    var fitToLongestItem: Boolean
        @JvmName("fitToLongestItemProperty")
        get() = isFitToLongestItem()
        @JvmName("setFitToLongestItemProperty")
        set(value) = setFitToLongestItem(value)

    var allowReselect: Boolean
        @JvmName("allowReselectProperty")
        get() = getAllowReselect()
        @JvmName("setAllowReselectProperty")
        set(value) = setAllowReselect(value)

    var itemCount: Int
        @JvmName("itemCountProperty")
        get() = getItemCount()
        @JvmName("setItemCountProperty")
        set(value) = setItemCount(value)

    /**
     * Adds an item, with text `label` and (optionally) `id`. If no `id` is passed, the item index will
     * be used as the item's ID. New items are appended at the end. Note: The item will be selected if
     * there are no other items.
     *
     * Generated from Godot docs: OptionButton.add_item
     */
    fun addItem(label: String, id: Int = -1) {
        ObjectCalls.ptrcallWithStringAndIntArg(addItemBind, handle, label, id)
    }

    /**
     * Adds an item, with a `texture` icon, text `label` and (optionally) `id`. If no `id` is passed,
     * the item index will be used as the item's ID. New items are appended at the end. Note: The item
     * will be selected if there are no other items.
     *
     * Generated from Godot docs: OptionButton.add_icon_item
     */
    fun addIconItem(texture: Texture2D?, label: String, id: Int = -1) {
        ObjectCalls.ptrcallWithObjectStringAndIntArgs(
            addIconItemBind,
            handle,
            texture?.requireOpenHandle() ?: MemorySegment.NULL,
            label,
            id,
        )
    }

    /**
     * Sets the text of the item at index `idx`.
     *
     * Generated from Godot docs: OptionButton.set_item_text
     */
    fun setItemText(index: Int, text: String) {
        ObjectCalls.ptrcallWithIntAndStringArg(setItemTextBind, handle, index, text)
    }

    /**
     * Sets the icon of the item at index `idx`.
     *
     * Generated from Godot docs: OptionButton.set_item_icon
     */
    fun setItemIcon(index: Int, texture: Texture2D?) {
        ObjectCalls.ptrcallWithIntAndObjectArg(
            setItemIconBind,
            handle,
            index,
            texture?.requireOpenHandle() ?: MemorySegment.NULL,
        )
    }

    /**
     * Sets whether the item at index `idx` is disabled. Disabled items are drawn differently in the
     * dropdown and are not selectable by the user. If the current selected item is set as disabled, it
     * will remain selected.
     *
     * Generated from Godot docs: OptionButton.set_item_disabled
     */
    fun setItemDisabled(index: Int, disabled: Boolean) {
        ObjectCalls.ptrcallWithIntAndBoolArgs(setItemDisabledBind, handle, index, disabled)
    }

    /**
     * Sets the ID of the item at index `idx`.
     *
     * Generated from Godot docs: OptionButton.set_item_id
     */
    fun setItemId(index: Int, id: Int) {
        ObjectCalls.ptrcallWithTwoIntArgs(setItemIdBind, handle, index, id)
    }

    /**
     * Sets the metadata of an item. Metadata may be of any type and can be used to store extra
     * information about an item, such as an external string ID.
     *
     * Generated from Godot docs: OptionButton.set_item_metadata
     */
    fun setItemMetadata(index: Int, metadata: Any?) {
        ObjectCalls.ptrcallWithIntAndVariantArg(setItemMetadataBind, handle, index, metadata)
    }

    /**
     * Sets the tooltip of the item at index `idx`.
     *
     * Generated from Godot docs: OptionButton.set_item_tooltip
     */
    fun setItemTooltip(index: Int, tooltip: String) {
        ObjectCalls.ptrcallWithIntAndStringArg(setItemTooltipBind, handle, index, tooltip)
    }

    /**
     * Sets the auto translate mode of the item at index `idx`. Items use
     * `Node.AUTO_TRANSLATE_MODE_INHERIT` by default, which uses the same auto translate mode as the
     * `OptionButton` itself.
     *
     * Generated from Godot docs: OptionButton.set_item_auto_translate_mode
     */
    fun setItemAutoTranslateMode(index: Int, mode: Long) {
        ObjectCalls.ptrcallWithIntAndLongArgs(setItemAutoTranslateModeBind, handle, index, mode)
    }

    /**
     * Returns the text of the item at index `idx`.
     *
     * Generated from Godot docs: OptionButton.get_item_text
     */
    fun getItemText(index: Int): String =
        ObjectCalls.ptrcallWithIntArgRetString(getItemTextBind, handle, index)

    /**
     * Returns the icon of the item at index `idx`.
     *
     * Generated from Godot docs: OptionButton.get_item_icon
     */
    fun getItemIcon(index: Int): Texture2D? =
        Texture2D.wrap(ObjectCalls.ptrcallWithIntArgRetObject(getItemIconBind, handle, index))

    /**
     * Returns the ID of the item at index `idx`.
     *
     * Generated from Godot docs: OptionButton.get_item_id
     */
    fun getItemId(index: Int): Int =
        ObjectCalls.ptrcallWithIntArgRetInt(getItemIdBind, handle, index)

    /**
     * Returns the index of the item with the given `id`.
     *
     * Generated from Godot docs: OptionButton.get_item_index
     */
    fun getItemIndex(id: Int): Int =
        ObjectCalls.ptrcallWithIntArgRetInt(getItemIndexBind, handle, id)

    /**
     * Retrieves the metadata of an item. Metadata may be any type and can be used to store extra
     * information about an item, such as an external string ID.
     *
     * Generated from Godot docs: OptionButton.get_item_metadata
     */
    fun getItemMetadata(index: Int): Any? =
        ObjectCalls.ptrcallWithIntArgRetVariantScalar(getItemMetadataBind, handle, index)

    /**
     * Returns the tooltip of the item at index `idx`.
     *
     * Generated from Godot docs: OptionButton.get_item_tooltip
     */
    fun getItemTooltip(index: Int): String =
        ObjectCalls.ptrcallWithIntArgRetString(getItemTooltipBind, handle, index)

    /**
     * Returns the auto translate mode of the item at index `idx`.
     *
     * Generated from Godot docs: OptionButton.get_item_auto_translate_mode
     */
    fun getItemAutoTranslateMode(index: Int): Long =
        ObjectCalls.ptrcallWithIntArgRetLong(getItemAutoTranslateModeBind, handle, index)

    /**
     * Returns `true` if the item at index `idx` is disabled.
     *
     * Generated from Godot docs: OptionButton.is_item_disabled
     */
    fun isItemDisabled(index: Int): Boolean =
        ObjectCalls.ptrcallWithIntArgRetBool(isItemDisabledBind, handle, index)

    /**
     * Returns `true` if the item at index `idx` is marked as a separator.
     *
     * Generated from Godot docs: OptionButton.is_item_separator
     */
    fun isItemSeparator(index: Int): Boolean =
        ObjectCalls.ptrcallWithIntArgRetBool(isItemSeparatorBind, handle, index)

    /**
     * Adds a separator to the list of items. Separators help to group items, and can optionally be
     * given a `text` header. A separator also gets an index assigned, and is appended at the end of
     * the item list.
     *
     * Generated from Godot docs: OptionButton.add_separator
     */
    fun addSeparator(text: String = "") {
        ObjectCalls.ptrcallWithStringArg(addSeparatorBind, handle, text)
    }

    /**
     * Clears all the items in the `OptionButton`.
     *
     * Generated from Godot docs: OptionButton.clear
     */
    fun clear() {
        ObjectCalls.ptrcallNoArgs(clearBind, handle)
    }

    /**
     * Selects an item by index and makes it the current item. This will work even if the item is
     * disabled. Passing `-1` as the index deselects any currently selected item.
     *
     * Generated from Godot docs: OptionButton.select
     */
    fun select(index: Int) {
        ObjectCalls.ptrcallWithIntArg(selectBind, handle, index)
    }

    /**
     * The index of the currently selected item, or `-1` if no item is selected.
     *
     * Generated from Godot docs: OptionButton.get_selected
     */
    fun getSelected(): Int =
        ObjectCalls.ptrcallNoArgsRetInt(getSelectedBind, handle)

    /**
     * Returns the ID of the selected item, or `-1` if no item is selected.
     *
     * Generated from Godot docs: OptionButton.get_selected_id
     */
    fun getSelectedId(): Int =
        ObjectCalls.ptrcallNoArgsRetInt(getSelectedIdBind, handle)

    /**
     * Gets the metadata of the selected item. Metadata for items can be set using `set_item_metadata`.
     *
     * Generated from Godot docs: OptionButton.get_selected_metadata
     */
    fun getSelectedMetadata(): Any? =
        ObjectCalls.ptrcallNoArgsRetVariantScalar(getSelectedMetadataBind, handle)

    /**
     * Removes the item at index `idx`.
     *
     * Generated from Godot docs: OptionButton.remove_item
     */
    fun removeItem(index: Int) {
        ObjectCalls.ptrcallWithIntArg(removeItemBind, handle, index)
    }

    /**
     * Returns the `PopupMenu` contained in this button. Warning: This is a required internal node,
     * removing and freeing it may cause a crash. If you wish to hide it or any of its children, use
     * their `Window.visible` property.
     *
     * Generated from Godot docs: OptionButton.get_popup
     */
    fun getPopup(): PopupMenu =
        PopupMenu(ObjectCalls.ptrcallNoArgsRetObject(getPopupBind, handle))

    /**
     * Adjusts popup position and sizing for the `OptionButton`, then shows the `PopupMenu`. Prefer
     * this over using `get_popup().popup()`.
     *
     * Generated from Godot docs: OptionButton.show_popup
     */
    fun showPopup() {
        ObjectCalls.ptrcallNoArgs(showPopupBind, handle)
    }

    /**
     * The number of items to select from.
     *
     * Generated from Godot docs: OptionButton.set_item_count
     */
    fun setItemCount(count: Int) {
        ObjectCalls.ptrcallWithIntArg(setItemCountBind, handle, count)
    }

    /**
     * The number of items to select from.
     *
     * Generated from Godot docs: OptionButton.get_item_count
     */
    fun getItemCount(): Int =
        ObjectCalls.ptrcallNoArgsRetInt(getItemCountBind, handle)

    /**
     * Returns `true` if this button contains at least one item which is not disabled, or marked as a
     * separator.
     *
     * Generated from Godot docs: OptionButton.has_selectable_items
     */
    fun hasSelectableItems(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(hasSelectableItemsBind, handle)

    /**
     * Returns the index of the first item which is not disabled, or marked as a separator. If
     * `from_last` is `true`, the items will be searched in reverse order. Returns `-1` if no item is
     * found.
     *
     * Generated from Godot docs: OptionButton.get_selectable_item
     */
    fun getSelectableItem(fromLast: Boolean = false): Int =
        ObjectCalls.ptrcallWithBoolArgRetInt(getSelectableItemBind, handle, fromLast)

    /**
     * If `true`, minimum size will be determined by the longest item's text, instead of the currently
     * selected one's. Note: For performance reasons, the minimum size doesn't update immediately when
     * adding, removing or modifying items.
     *
     * Generated from Godot docs: OptionButton.set_fit_to_longest_item
     */
    fun setFitToLongestItem(fit: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setFitToLongestItemBind, handle, fit)
    }

    /**
     * If `true`, minimum size will be determined by the longest item's text, instead of the currently
     * selected one's. Note: For performance reasons, the minimum size doesn't update immediately when
     * adding, removing or modifying items.
     *
     * Generated from Godot docs: OptionButton.is_fit_to_longest_item
     */
    fun isFitToLongestItem(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(isFitToLongestItemBind, handle)

    /**
     * If `true`, the currently selected item can be selected again.
     *
     * Generated from Godot docs: OptionButton.set_allow_reselect
     */
    fun setAllowReselect(allow: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setAllowReselectBind, handle, allow)
    }

    /**
     * If `true`, the currently selected item can be selected again.
     *
     * Generated from Godot docs: OptionButton.get_allow_reselect
     */
    fun getAllowReselect(): Boolean =
        ObjectCalls.ptrcallNoArgsRetBool(getAllowReselectBind, handle)

    /**
     * If `true`, shortcuts are disabled and cannot be used to trigger the button.
     *
     * Generated from Godot docs: OptionButton.set_disable_shortcuts
     */
    fun setDisableShortcuts(disabled: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setDisableShortcutsBind, handle, disabled)
    }

    object Signals {
        const val itemSelected: String = "item_selected"
        const val itemFocused: String = "item_focused"
    }

    companion object {
        private const val STRING_INT_VOID_HASH = 2697778442L
        private const val INT_STRING_VOID_HASH = 501894301L
        private const val INT_OBJECT_VOID_HASH = 666127730L
        private const val INT_VARIANT_VOID_HASH = 2152698145L
        private const val INT_BOOL_VOID_HASH = 300928843L
        private const val TWO_INT_VOID_HASH = 3937882851L
        private const val INT_LONG_VOID_HASH = 287402019L
        private const val INT_RET_STRING_HASH = 844755477L
        private const val INT_RET_TEXTURE_HASH = 3536238170L
        private const val INT_RET_INT_HASH = 923996154L
        private const val INT_RET_VARIANT_HASH = 4227898402L
        private const val INT_RET_LONG_HASH = 906302372L
        private const val INT_RET_BOOL_HASH = 1116898809L
        private const val NOARGS_VARIANT_HASH = 1214101251L
        private const val ADD_SEPARATOR_HASH = 3005725572L
        private const val NOARGS_VOID_HASH = 3218959716L
        private const val INT_VOID_HASH = 1286410249L
        private const val NOARGS_INT_HASH = 3905245786L
        private const val NOARGS_POPUP_MENU_HASH = 229722558L
        private const val NOARGS_BOOL_HASH = 36873697L
        private const val BOOL_RET_INT_HASH = 894402480L
        private const val BOOL_VOID_HASH = 2586408642L
        private const val ADD_ICON_ITEM_HASH = 3781678508L

        private val addItemBind by lazy { ObjectCalls.getMethodBind("OptionButton", "add_item", STRING_INT_VOID_HASH) }
        private val addIconItemBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "add_icon_item", ADD_ICON_ITEM_HASH)
        }
        private val setItemTextBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "set_item_text", INT_STRING_VOID_HASH)
        }
        private val setItemIconBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "set_item_icon", INT_OBJECT_VOID_HASH)
        }
        private val setItemDisabledBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "set_item_disabled", INT_BOOL_VOID_HASH)
        }
        private val setItemIdBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "set_item_id", TWO_INT_VOID_HASH)
        }
        private val setItemMetadataBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "set_item_metadata", INT_VARIANT_VOID_HASH)
        }
        private val setItemTooltipBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "set_item_tooltip", INT_STRING_VOID_HASH)
        }
        private val setItemAutoTranslateModeBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "set_item_auto_translate_mode", INT_LONG_VOID_HASH)
        }
        private val getItemTextBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "get_item_text", INT_RET_STRING_HASH)
        }
        private val getItemIconBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "get_item_icon", INT_RET_TEXTURE_HASH)
        }
        private val getItemIdBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "get_item_id", INT_RET_INT_HASH)
        }
        private val getItemIndexBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "get_item_index", INT_RET_INT_HASH)
        }
        private val getItemMetadataBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "get_item_metadata", INT_RET_VARIANT_HASH)
        }
        private val getItemTooltipBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "get_item_tooltip", INT_RET_STRING_HASH)
        }
        private val getItemAutoTranslateModeBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "get_item_auto_translate_mode", INT_RET_LONG_HASH)
        }
        private val isItemDisabledBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "is_item_disabled", INT_RET_BOOL_HASH)
        }
        private val isItemSeparatorBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "is_item_separator", INT_RET_BOOL_HASH)
        }
        private val addSeparatorBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "add_separator", ADD_SEPARATOR_HASH)
        }
        private val clearBind by lazy { ObjectCalls.getMethodBind("OptionButton", "clear", NOARGS_VOID_HASH) }
        private val selectBind by lazy { ObjectCalls.getMethodBind("OptionButton", "select", INT_VOID_HASH) }
        private val getSelectedBind by lazy { ObjectCalls.getMethodBind("OptionButton", "get_selected", NOARGS_INT_HASH) }
        private val getSelectedIdBind by lazy { ObjectCalls.getMethodBind("OptionButton", "get_selected_id", NOARGS_INT_HASH) }
        private val getSelectedMetadataBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "get_selected_metadata", NOARGS_VARIANT_HASH)
        }
        private val removeItemBind by lazy { ObjectCalls.getMethodBind("OptionButton", "remove_item", INT_VOID_HASH) }
        private val getPopupBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "get_popup", NOARGS_POPUP_MENU_HASH)
        }
        private val showPopupBind by lazy { ObjectCalls.getMethodBind("OptionButton", "show_popup", NOARGS_VOID_HASH) }
        private val setItemCountBind by lazy { ObjectCalls.getMethodBind("OptionButton", "set_item_count", INT_VOID_HASH) }
        private val getItemCountBind by lazy { ObjectCalls.getMethodBind("OptionButton", "get_item_count", NOARGS_INT_HASH) }
        private val hasSelectableItemsBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "has_selectable_items", NOARGS_BOOL_HASH)
        }
        private val getSelectableItemBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "get_selectable_item", BOOL_RET_INT_HASH)
        }
        private val setFitToLongestItemBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "set_fit_to_longest_item", BOOL_VOID_HASH)
        }
        private val isFitToLongestItemBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "is_fit_to_longest_item", NOARGS_BOOL_HASH)
        }
        private val setAllowReselectBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "set_allow_reselect", BOOL_VOID_HASH)
        }
        private val getAllowReselectBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "get_allow_reselect", NOARGS_BOOL_HASH)
        }
        private val setDisableShortcutsBind by lazy {
            ObjectCalls.getMethodBind("OptionButton", "set_disable_shortcuts", BOOL_VOID_HASH)
        }
    }
}
