package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*
import net.multigesture.kanama.types.Color
import net.multigesture.kanama.types.RID
import net.multigesture.kanama.types.Rect2
import net.multigesture.kanama.types.Transform2D

/**
 * Generated from Godot docs: AccessibilityServer
 */
object AccessibilityServer {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("AccessibilityServer")
    }

    const val ROLE_UNKNOWN: Long = 0L
    const val ROLE_DEFAULT_BUTTON: Long = 1L
    const val ROLE_AUDIO: Long = 2L
    const val ROLE_VIDEO: Long = 3L
    const val ROLE_STATIC_TEXT: Long = 4L
    const val ROLE_CONTAINER: Long = 5L
    const val ROLE_PANEL: Long = 6L
    const val ROLE_BUTTON: Long = 7L
    const val ROLE_LINK: Long = 8L
    const val ROLE_CHECK_BOX: Long = 9L
    const val ROLE_RADIO_BUTTON: Long = 10L
    const val ROLE_CHECK_BUTTON: Long = 11L
    const val ROLE_SCROLL_BAR: Long = 12L
    const val ROLE_SCROLL_VIEW: Long = 13L
    const val ROLE_SPLITTER: Long = 14L
    const val ROLE_SLIDER: Long = 15L
    const val ROLE_SPIN_BUTTON: Long = 16L
    const val ROLE_PROGRESS_INDICATOR: Long = 17L
    const val ROLE_TEXT_FIELD: Long = 18L
    const val ROLE_MULTILINE_TEXT_FIELD: Long = 19L
    const val ROLE_COLOR_PICKER: Long = 20L
    const val ROLE_TABLE: Long = 21L
    const val ROLE_CELL: Long = 22L
    const val ROLE_ROW: Long = 23L
    const val ROLE_ROW_GROUP: Long = 24L
    const val ROLE_ROW_HEADER: Long = 25L
    const val ROLE_COLUMN_HEADER: Long = 26L
    const val ROLE_TREE: Long = 27L
    const val ROLE_TREE_ITEM: Long = 28L
    const val ROLE_LIST: Long = 29L
    const val ROLE_LIST_ITEM: Long = 30L
    const val ROLE_LIST_BOX: Long = 31L
    const val ROLE_LIST_BOX_OPTION: Long = 32L
    const val ROLE_TAB_BAR: Long = 33L
    const val ROLE_TAB: Long = 34L
    const val ROLE_TAB_PANEL: Long = 35L
    const val ROLE_MENU_BAR: Long = 36L
    const val ROLE_MENU: Long = 37L
    const val ROLE_MENU_ITEM: Long = 38L
    const val ROLE_MENU_ITEM_CHECK_BOX: Long = 39L
    const val ROLE_MENU_ITEM_RADIO: Long = 40L
    const val ROLE_IMAGE: Long = 41L
    const val ROLE_WINDOW: Long = 42L
    const val ROLE_TITLE_BAR: Long = 43L
    const val ROLE_DIALOG: Long = 44L
    const val ROLE_TOOLTIP: Long = 45L
    const val ROLE_REGION: Long = 46L
    const val ROLE_TEXT_RUN: Long = 47L
    const val POPUP_MENU: Long = 0L
    const val POPUP_LIST: Long = 1L
    const val POPUP_TREE: Long = 2L
    const val POPUP_DIALOG: Long = 3L
    const val FLAG_HIDDEN: Long = 0L
    const val FLAG_MULTISELECTABLE: Long = 1L
    const val FLAG_REQUIRED: Long = 2L
    const val FLAG_VISITED: Long = 3L
    const val FLAG_BUSY: Long = 4L
    const val FLAG_MODAL: Long = 5L
    const val FLAG_TOUCH_PASSTHROUGH: Long = 6L
    const val FLAG_READONLY: Long = 7L
    const val FLAG_DISABLED: Long = 8L
    const val FLAG_CLIPS_CHILDREN: Long = 9L
    const val ACTION_CLICK: Long = 0L
    const val ACTION_FOCUS: Long = 1L
    const val ACTION_BLUR: Long = 2L
    const val ACTION_COLLAPSE: Long = 3L
    const val ACTION_EXPAND: Long = 4L
    const val ACTION_DECREMENT: Long = 5L
    const val ACTION_INCREMENT: Long = 6L
    const val ACTION_HIDE_TOOLTIP: Long = 7L
    const val ACTION_SHOW_TOOLTIP: Long = 8L
    const val ACTION_SET_TEXT_SELECTION: Long = 9L
    const val ACTION_REPLACE_SELECTED_TEXT: Long = 10L
    const val ACTION_SCROLL_BACKWARD: Long = 11L
    const val ACTION_SCROLL_DOWN: Long = 12L
    const val ACTION_SCROLL_FORWARD: Long = 13L
    const val ACTION_SCROLL_LEFT: Long = 14L
    const val ACTION_SCROLL_RIGHT: Long = 15L
    const val ACTION_SCROLL_UP: Long = 16L
    const val ACTION_SCROLL_INTO_VIEW: Long = 17L
    const val ACTION_SCROLL_TO_POINT: Long = 18L
    const val ACTION_SET_SCROLL_OFFSET: Long = 19L
    const val ACTION_SET_VALUE: Long = 20L
    const val ACTION_SHOW_CONTEXT_MENU: Long = 21L
    const val ACTION_CUSTOM: Long = 22L
    const val LIVE_OFF: Long = 0L
    const val LIVE_POLITE: Long = 1L
    const val LIVE_ASSERTIVE: Long = 2L
    const val SCROLL_UNIT_ITEM: Long = 0L
    const val SCROLL_UNIT_PAGE: Long = 1L
    const val SCROLL_HINT_TOP_LEFT: Long = 0L
    const val SCROLL_HINT_BOTTOM_RIGHT: Long = 1L
    const val SCROLL_HINT_TOP_EDGE: Long = 2L
    const val SCROLL_HINT_BOTTOM_EDGE: Long = 3L
    const val SCROLL_HINT_LEFT_EDGE: Long = 4L
    const val SCROLL_HINT_RIGHT_EDGE: Long = 5L

    fun isSupported(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isSupportedBind, singleton)
    }

    fun createElement(windowId: Int, role: Long): RID {
        return ObjectCalls.ptrcallWithIntAndLongArgsRetRID(createElementBind, singleton, windowId, role)
    }

    fun createSubElement(parentRid: RID, role: Long, insertPos: Int = -1): RID {
        return ObjectCalls.ptrcallWithRIDLongIntArgsRetRID(createSubElementBind, singleton, parentRid, role, insertPos)
    }

    fun createSubTextEditElements(parentRid: RID, shapedText: RID, minHeight: Double, insertPos: Int = -1, isLastLine: Boolean = false): RID {
        return ObjectCalls.ptrcallWithTwoRIDDoubleIntBoolArgsRetRID(createSubTextEditElementsBind, singleton, parentRid, shapedText, minHeight, insertPos, isLastLine)
    }

    fun hasElement(id: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(hasElementBind, singleton, id)
    }

    fun freeElement(id: RID) {
        ObjectCalls.ptrcallWithRIDArg(freeElementBind, singleton, id)
    }

    fun setWindowRect(windowId: Int, rectOut: Rect2, rectIn: Rect2) {
        ObjectCalls.ptrcallWithIntRect2Rect2Args(setWindowRectBind, singleton, windowId, rectOut, rectIn)
    }

    fun setWindowFocused(windowId: Int, focused: Boolean) {
        ObjectCalls.ptrcallWithIntAndBoolArgs(setWindowFocusedBind, singleton, windowId, focused)
    }

    fun updateSetFocus(id: RID) {
        ObjectCalls.ptrcallWithRIDArg(updateSetFocusBind, singleton, id)
    }

    fun getWindowRoot(windowId: Int): RID {
        return ObjectCalls.ptrcallWithIntArgRetRID(getWindowRootBind, singleton, windowId)
    }

    fun updateSetRole(id: RID, role: Long) {
        ObjectCalls.ptrcallWithRIDAndLongArg(updateSetRoleBind, singleton, id, role)
    }

    fun updateSetName(id: RID, name: String) {
        ObjectCalls.ptrcallWithRIDAndStringArg(updateSetNameBind, singleton, id, name)
    }

    fun updateSetBrailleLabel(id: RID, name: String) {
        ObjectCalls.ptrcallWithRIDAndStringArg(updateSetBrailleLabelBind, singleton, id, name)
    }

    fun updateSetBrailleRoleDescription(id: RID, description: String) {
        ObjectCalls.ptrcallWithRIDAndStringArg(updateSetBrailleRoleDescriptionBind, singleton, id, description)
    }

    fun updateSetExtraInfo(id: RID, name: String) {
        ObjectCalls.ptrcallWithRIDAndStringArg(updateSetExtraInfoBind, singleton, id, name)
    }

    fun updateSetDescription(id: RID, description: String) {
        ObjectCalls.ptrcallWithRIDAndStringArg(updateSetDescriptionBind, singleton, id, description)
    }

    fun updateSetValue(id: RID, value: String) {
        ObjectCalls.ptrcallWithRIDAndStringArg(updateSetValueBind, singleton, id, value)
    }

    fun updateSetTooltip(id: RID, tooltip: String) {
        ObjectCalls.ptrcallWithRIDAndStringArg(updateSetTooltipBind, singleton, id, tooltip)
    }

    fun updateSetBounds(id: RID, rect: Rect2) {
        ObjectCalls.ptrcallWithRIDAndRect2Arg(updateSetBoundsBind, singleton, id, rect)
    }

    fun updateSetTransform(id: RID, transform: Transform2D) {
        ObjectCalls.ptrcallWithRIDAndTransform2DArg(updateSetTransformBind, singleton, id, transform)
    }

    fun updateAddChild(id: RID, childId: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(updateAddChildBind, singleton, id, childId)
    }

    fun updateAddRelatedControls(id: RID, relatedId: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(updateAddRelatedControlsBind, singleton, id, relatedId)
    }

    fun updateAddRelatedDetails(id: RID, relatedId: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(updateAddRelatedDetailsBind, singleton, id, relatedId)
    }

    fun updateAddRelatedDescribedBy(id: RID, relatedId: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(updateAddRelatedDescribedByBind, singleton, id, relatedId)
    }

    fun updateAddRelatedFlowTo(id: RID, relatedId: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(updateAddRelatedFlowToBind, singleton, id, relatedId)
    }

    fun updateAddRelatedLabeledBy(id: RID, relatedId: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(updateAddRelatedLabeledByBind, singleton, id, relatedId)
    }

    fun updateAddRelatedRadioGroup(id: RID, relatedId: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(updateAddRelatedRadioGroupBind, singleton, id, relatedId)
    }

    fun updateSetActiveDescendant(id: RID, otherId: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(updateSetActiveDescendantBind, singleton, id, otherId)
    }

    fun updateSetNextOnLine(id: RID, otherId: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(updateSetNextOnLineBind, singleton, id, otherId)
    }

    fun updateSetPreviousOnLine(id: RID, otherId: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(updateSetPreviousOnLineBind, singleton, id, otherId)
    }

    fun updateSetMemberOf(id: RID, groupId: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(updateSetMemberOfBind, singleton, id, groupId)
    }

    fun updateSetInPageLinkTarget(id: RID, otherId: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(updateSetInPageLinkTargetBind, singleton, id, otherId)
    }

    fun updateSetErrorMessage(id: RID, otherId: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(updateSetErrorMessageBind, singleton, id, otherId)
    }

    fun updateSetLive(id: RID, live: Long) {
        ObjectCalls.ptrcallWithRIDAndLongArg(updateSetLiveBind, singleton, id, live)
    }

    fun updateAddAction(id: RID, action: Long, callable: GodotCallable) {
        ObjectCalls.ptrcallWithRIDLongCallableArgs(updateAddActionBind, singleton, id, action, callable.target.handle, callable.method)
    }

    fun updateAddCustomAction(id: RID, actionId: Int, actionDescription: String) {
        ObjectCalls.ptrcallWithRIDIntAndStringArgs(updateAddCustomActionBind, singleton, id, actionId, actionDescription)
    }

    fun updateSetTableRowCount(id: RID, count: Int) {
        ObjectCalls.ptrcallWithRIDAndIntArg(updateSetTableRowCountBind, singleton, id, count)
    }

    fun updateSetTableColumnCount(id: RID, count: Int) {
        ObjectCalls.ptrcallWithRIDAndIntArg(updateSetTableColumnCountBind, singleton, id, count)
    }

    fun updateSetTableRowIndex(id: RID, index: Int) {
        ObjectCalls.ptrcallWithRIDAndIntArg(updateSetTableRowIndexBind, singleton, id, index)
    }

    fun updateSetTableColumnIndex(id: RID, index: Int) {
        ObjectCalls.ptrcallWithRIDAndIntArg(updateSetTableColumnIndexBind, singleton, id, index)
    }

    fun updateSetTableCellPosition(id: RID, rowIndex: Int, columnIndex: Int) {
        ObjectCalls.ptrcallWithRIDAndTwoIntArgs(updateSetTableCellPositionBind, singleton, id, rowIndex, columnIndex)
    }

    fun updateSetTableCellSpan(id: RID, rowSpan: Int, columnSpan: Int) {
        ObjectCalls.ptrcallWithRIDAndTwoIntArgs(updateSetTableCellSpanBind, singleton, id, rowSpan, columnSpan)
    }

    fun updateSetListItemCount(id: RID, size: Int) {
        ObjectCalls.ptrcallWithRIDAndIntArg(updateSetListItemCountBind, singleton, id, size)
    }

    fun updateSetListItemIndex(id: RID, index: Int) {
        ObjectCalls.ptrcallWithRIDAndIntArg(updateSetListItemIndexBind, singleton, id, index)
    }

    fun updateSetListItemLevel(id: RID, level: Int) {
        ObjectCalls.ptrcallWithRIDAndIntArg(updateSetListItemLevelBind, singleton, id, level)
    }

    fun updateSetListItemSelected(id: RID, selected: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(updateSetListItemSelectedBind, singleton, id, selected)
    }

    fun updateSetListItemExpanded(id: RID, expanded: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(updateSetListItemExpandedBind, singleton, id, expanded)
    }

    fun updateSetPopupType(id: RID, popup: Long) {
        ObjectCalls.ptrcallWithRIDAndLongArg(updateSetPopupTypeBind, singleton, id, popup)
    }

    fun updateSetChecked(id: RID, checekd: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(updateSetCheckedBind, singleton, id, checekd)
    }

    fun updateSetNumValue(id: RID, position: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(updateSetNumValueBind, singleton, id, position)
    }

    fun updateSetNumRange(id: RID, min: Double, max: Double) {
        ObjectCalls.ptrcallWithRIDAndTwoDoubleArgs(updateSetNumRangeBind, singleton, id, min, max)
    }

    fun updateSetNumStep(id: RID, step: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(updateSetNumStepBind, singleton, id, step)
    }

    fun updateSetNumJump(id: RID, jump: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(updateSetNumJumpBind, singleton, id, jump)
    }

    fun updateSetScrollX(id: RID, position: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(updateSetScrollXBind, singleton, id, position)
    }

    fun updateSetScrollXRange(id: RID, min: Double, max: Double) {
        ObjectCalls.ptrcallWithRIDAndTwoDoubleArgs(updateSetScrollXRangeBind, singleton, id, min, max)
    }

    fun updateSetScrollY(id: RID, position: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(updateSetScrollYBind, singleton, id, position)
    }

    fun updateSetScrollYRange(id: RID, min: Double, max: Double) {
        ObjectCalls.ptrcallWithRIDAndTwoDoubleArgs(updateSetScrollYRangeBind, singleton, id, min, max)
    }

    fun updateSetTextDecorations(id: RID, underline: Boolean, strikethrough: Boolean, overline: Boolean, color: Color) {
        ObjectCalls.ptrcallWithRIDThreeBoolAndColorArgs(updateSetTextDecorationsBind, singleton, id, underline, strikethrough, overline, color)
    }

    fun updateSetTextAlign(id: RID, align: Long) {
        ObjectCalls.ptrcallWithRIDAndLongArg(updateSetTextAlignBind, singleton, id, align)
    }

    fun updateSetTextSelection(id: RID, textStartId: RID, startChar: Int, textEndId: RID, endChar: Int) {
        ObjectCalls.ptrcallWithTwoRIDIntRIDIntArgs(updateSetTextSelectionBind, singleton, id, textStartId, startChar, textEndId, endChar)
    }

    fun updateSetFlag(id: RID, flag: Long, value: Boolean) {
        ObjectCalls.ptrcallWithRIDLongAndBoolArgs(updateSetFlagBind, singleton, id, flag, value)
    }

    fun updateSetClassname(id: RID, classname: String) {
        ObjectCalls.ptrcallWithRIDAndStringArg(updateSetClassnameBind, singleton, id, classname)
    }

    fun updateSetPlaceholder(id: RID, placeholder: String) {
        ObjectCalls.ptrcallWithRIDAndStringArg(updateSetPlaceholderBind, singleton, id, placeholder)
    }

    fun updateSetLanguage(id: RID, language: String) {
        ObjectCalls.ptrcallWithRIDAndStringArg(updateSetLanguageBind, singleton, id, language)
    }

    fun updateSetTextOrientation(id: RID, vertical: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(updateSetTextOrientationBind, singleton, id, vertical)
    }

    fun updateSetListOrientation(id: RID, vertical: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(updateSetListOrientationBind, singleton, id, vertical)
    }

    fun updateSetShortcut(id: RID, shortcut: String) {
        ObjectCalls.ptrcallWithRIDAndStringArg(updateSetShortcutBind, singleton, id, shortcut)
    }

    fun updateSetUrl(id: RID, url: String) {
        ObjectCalls.ptrcallWithRIDAndStringArg(updateSetUrlBind, singleton, id, url)
    }

    fun updateSetRoleDescription(id: RID, description: String) {
        ObjectCalls.ptrcallWithRIDAndStringArg(updateSetRoleDescriptionBind, singleton, id, description)
    }

    fun updateSetStateDescription(id: RID, description: String) {
        ObjectCalls.ptrcallWithRIDAndStringArg(updateSetStateDescriptionBind, singleton, id, description)
    }

    fun updateSetColorValue(id: RID, color: Color) {
        ObjectCalls.ptrcallWithRIDAndColorArg(updateSetColorValueBind, singleton, id, color)
    }

    fun updateSetBackgroundColor(id: RID, color: Color) {
        ObjectCalls.ptrcallWithRIDAndColorArg(updateSetBackgroundColorBind, singleton, id, color)
    }

    fun updateSetForegroundColor(id: RID, color: Color) {
        ObjectCalls.ptrcallWithRIDAndColorArg(updateSetForegroundColorBind, singleton, id, color)
    }

    fun fromHandle(handle: MemorySegment): AccessibilityServer? =
        wrap(handle)

    internal fun wrap(handle: MemorySegment): AccessibilityServer? =
        if (handle.address() == 0L) null else this

    private const val IS_SUPPORTED_HASH = 36873697L
    private val isSupportedBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "is_supported", IS_SUPPORTED_HASH)
    }

    private const val CREATE_ELEMENT_HASH = 3846965249L
    private val createElementBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "create_element", CREATE_ELEMENT_HASH)
    }

    private const val CREATE_SUB_ELEMENT_HASH = 1151690429L
    private val createSubElementBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "create_sub_element", CREATE_SUB_ELEMENT_HASH)
    }

    private const val CREATE_SUB_TEXT_EDIT_ELEMENTS_HASH = 2702009895L
    private val createSubTextEditElementsBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "create_sub_text_edit_elements", CREATE_SUB_TEXT_EDIT_ELEMENTS_HASH)
    }

    private const val HAS_ELEMENT_HASH = 4155700596L
    private val hasElementBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "has_element", HAS_ELEMENT_HASH)
    }

    private const val FREE_ELEMENT_HASH = 2722037293L
    private val freeElementBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "free_element", FREE_ELEMENT_HASH)
    }

    private const val SET_WINDOW_RECT_HASH = 2386961724L
    private val setWindowRectBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "set_window_rect", SET_WINDOW_RECT_HASH)
    }

    private const val SET_WINDOW_FOCUSED_HASH = 300928843L
    private val setWindowFocusedBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "set_window_focused", SET_WINDOW_FOCUSED_HASH)
    }

    private const val UPDATE_SET_FOCUS_HASH = 2722037293L
    private val updateSetFocusBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_focus", UPDATE_SET_FOCUS_HASH)
    }

    private const val GET_WINDOW_ROOT_HASH = 495598643L
    private val getWindowRootBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "get_window_root", GET_WINDOW_ROOT_HASH)
    }

    private const val UPDATE_SET_ROLE_HASH = 3747886520L
    private val updateSetRoleBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_role", UPDATE_SET_ROLE_HASH)
    }

    private const val UPDATE_SET_NAME_HASH = 2726140452L
    private val updateSetNameBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_name", UPDATE_SET_NAME_HASH)
    }

    private const val UPDATE_SET_BRAILLE_LABEL_HASH = 2726140452L
    private val updateSetBrailleLabelBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_braille_label", UPDATE_SET_BRAILLE_LABEL_HASH)
    }

    private const val UPDATE_SET_BRAILLE_ROLE_DESCRIPTION_HASH = 2726140452L
    private val updateSetBrailleRoleDescriptionBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_braille_role_description", UPDATE_SET_BRAILLE_ROLE_DESCRIPTION_HASH)
    }

    private const val UPDATE_SET_EXTRA_INFO_HASH = 2726140452L
    private val updateSetExtraInfoBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_extra_info", UPDATE_SET_EXTRA_INFO_HASH)
    }

    private const val UPDATE_SET_DESCRIPTION_HASH = 2726140452L
    private val updateSetDescriptionBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_description", UPDATE_SET_DESCRIPTION_HASH)
    }

    private const val UPDATE_SET_VALUE_HASH = 2726140452L
    private val updateSetValueBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_value", UPDATE_SET_VALUE_HASH)
    }

    private const val UPDATE_SET_TOOLTIP_HASH = 2726140452L
    private val updateSetTooltipBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_tooltip", UPDATE_SET_TOOLTIP_HASH)
    }

    private const val UPDATE_SET_BOUNDS_HASH = 1378122625L
    private val updateSetBoundsBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_bounds", UPDATE_SET_BOUNDS_HASH)
    }

    private const val UPDATE_SET_TRANSFORM_HASH = 1246044741L
    private val updateSetTransformBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_transform", UPDATE_SET_TRANSFORM_HASH)
    }

    private const val UPDATE_ADD_CHILD_HASH = 395945892L
    private val updateAddChildBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_add_child", UPDATE_ADD_CHILD_HASH)
    }

    private const val UPDATE_ADD_RELATED_CONTROLS_HASH = 395945892L
    private val updateAddRelatedControlsBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_add_related_controls", UPDATE_ADD_RELATED_CONTROLS_HASH)
    }

    private const val UPDATE_ADD_RELATED_DETAILS_HASH = 395945892L
    private val updateAddRelatedDetailsBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_add_related_details", UPDATE_ADD_RELATED_DETAILS_HASH)
    }

    private const val UPDATE_ADD_RELATED_DESCRIBED_BY_HASH = 395945892L
    private val updateAddRelatedDescribedByBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_add_related_described_by", UPDATE_ADD_RELATED_DESCRIBED_BY_HASH)
    }

    private const val UPDATE_ADD_RELATED_FLOW_TO_HASH = 395945892L
    private val updateAddRelatedFlowToBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_add_related_flow_to", UPDATE_ADD_RELATED_FLOW_TO_HASH)
    }

    private const val UPDATE_ADD_RELATED_LABELED_BY_HASH = 395945892L
    private val updateAddRelatedLabeledByBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_add_related_labeled_by", UPDATE_ADD_RELATED_LABELED_BY_HASH)
    }

    private const val UPDATE_ADD_RELATED_RADIO_GROUP_HASH = 395945892L
    private val updateAddRelatedRadioGroupBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_add_related_radio_group", UPDATE_ADD_RELATED_RADIO_GROUP_HASH)
    }

    private const val UPDATE_SET_ACTIVE_DESCENDANT_HASH = 395945892L
    private val updateSetActiveDescendantBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_active_descendant", UPDATE_SET_ACTIVE_DESCENDANT_HASH)
    }

    private const val UPDATE_SET_NEXT_ON_LINE_HASH = 395945892L
    private val updateSetNextOnLineBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_next_on_line", UPDATE_SET_NEXT_ON_LINE_HASH)
    }

    private const val UPDATE_SET_PREVIOUS_ON_LINE_HASH = 395945892L
    private val updateSetPreviousOnLineBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_previous_on_line", UPDATE_SET_PREVIOUS_ON_LINE_HASH)
    }

    private const val UPDATE_SET_MEMBER_OF_HASH = 395945892L
    private val updateSetMemberOfBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_member_of", UPDATE_SET_MEMBER_OF_HASH)
    }

    private const val UPDATE_SET_IN_PAGE_LINK_TARGET_HASH = 395945892L
    private val updateSetInPageLinkTargetBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_in_page_link_target", UPDATE_SET_IN_PAGE_LINK_TARGET_HASH)
    }

    private const val UPDATE_SET_ERROR_MESSAGE_HASH = 395945892L
    private val updateSetErrorMessageBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_error_message", UPDATE_SET_ERROR_MESSAGE_HASH)
    }

    private const val UPDATE_SET_LIVE_HASH = 2993365237L
    private val updateSetLiveBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_live", UPDATE_SET_LIVE_HASH)
    }

    private const val UPDATE_ADD_ACTION_HASH = 3960092835L
    private val updateAddActionBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_add_action", UPDATE_ADD_ACTION_HASH)
    }

    private const val UPDATE_ADD_CUSTOM_ACTION_HASH = 4153150897L
    private val updateAddCustomActionBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_add_custom_action", UPDATE_ADD_CUSTOM_ACTION_HASH)
    }

    private const val UPDATE_SET_TABLE_ROW_COUNT_HASH = 3411492887L
    private val updateSetTableRowCountBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_table_row_count", UPDATE_SET_TABLE_ROW_COUNT_HASH)
    }

    private const val UPDATE_SET_TABLE_COLUMN_COUNT_HASH = 3411492887L
    private val updateSetTableColumnCountBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_table_column_count", UPDATE_SET_TABLE_COLUMN_COUNT_HASH)
    }

    private const val UPDATE_SET_TABLE_ROW_INDEX_HASH = 3411492887L
    private val updateSetTableRowIndexBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_table_row_index", UPDATE_SET_TABLE_ROW_INDEX_HASH)
    }

    private const val UPDATE_SET_TABLE_COLUMN_INDEX_HASH = 3411492887L
    private val updateSetTableColumnIndexBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_table_column_index", UPDATE_SET_TABLE_COLUMN_INDEX_HASH)
    }

    private const val UPDATE_SET_TABLE_CELL_POSITION_HASH = 4288446313L
    private val updateSetTableCellPositionBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_table_cell_position", UPDATE_SET_TABLE_CELL_POSITION_HASH)
    }

    private const val UPDATE_SET_TABLE_CELL_SPAN_HASH = 4288446313L
    private val updateSetTableCellSpanBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_table_cell_span", UPDATE_SET_TABLE_CELL_SPAN_HASH)
    }

    private const val UPDATE_SET_LIST_ITEM_COUNT_HASH = 3411492887L
    private val updateSetListItemCountBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_list_item_count", UPDATE_SET_LIST_ITEM_COUNT_HASH)
    }

    private const val UPDATE_SET_LIST_ITEM_INDEX_HASH = 3411492887L
    private val updateSetListItemIndexBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_list_item_index", UPDATE_SET_LIST_ITEM_INDEX_HASH)
    }

    private const val UPDATE_SET_LIST_ITEM_LEVEL_HASH = 3411492887L
    private val updateSetListItemLevelBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_list_item_level", UPDATE_SET_LIST_ITEM_LEVEL_HASH)
    }

    private const val UPDATE_SET_LIST_ITEM_SELECTED_HASH = 1265174801L
    private val updateSetListItemSelectedBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_list_item_selected", UPDATE_SET_LIST_ITEM_SELECTED_HASH)
    }

    private const val UPDATE_SET_LIST_ITEM_EXPANDED_HASH = 1265174801L
    private val updateSetListItemExpandedBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_list_item_expanded", UPDATE_SET_LIST_ITEM_EXPANDED_HASH)
    }

    private const val UPDATE_SET_POPUP_TYPE_HASH = 690307634L
    private val updateSetPopupTypeBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_popup_type", UPDATE_SET_POPUP_TYPE_HASH)
    }

    private const val UPDATE_SET_CHECKED_HASH = 1265174801L
    private val updateSetCheckedBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_checked", UPDATE_SET_CHECKED_HASH)
    }

    private const val UPDATE_SET_NUM_VALUE_HASH = 1794382983L
    private val updateSetNumValueBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_num_value", UPDATE_SET_NUM_VALUE_HASH)
    }

    private const val UPDATE_SET_NUM_RANGE_HASH = 2513314492L
    private val updateSetNumRangeBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_num_range", UPDATE_SET_NUM_RANGE_HASH)
    }

    private const val UPDATE_SET_NUM_STEP_HASH = 1794382983L
    private val updateSetNumStepBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_num_step", UPDATE_SET_NUM_STEP_HASH)
    }

    private const val UPDATE_SET_NUM_JUMP_HASH = 1794382983L
    private val updateSetNumJumpBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_num_jump", UPDATE_SET_NUM_JUMP_HASH)
    }

    private const val UPDATE_SET_SCROLL_X_HASH = 1794382983L
    private val updateSetScrollXBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_scroll_x", UPDATE_SET_SCROLL_X_HASH)
    }

    private const val UPDATE_SET_SCROLL_X_RANGE_HASH = 2513314492L
    private val updateSetScrollXRangeBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_scroll_x_range", UPDATE_SET_SCROLL_X_RANGE_HASH)
    }

    private const val UPDATE_SET_SCROLL_Y_HASH = 1794382983L
    private val updateSetScrollYBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_scroll_y", UPDATE_SET_SCROLL_Y_HASH)
    }

    private const val UPDATE_SET_SCROLL_Y_RANGE_HASH = 2513314492L
    private val updateSetScrollYRangeBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_scroll_y_range", UPDATE_SET_SCROLL_Y_RANGE_HASH)
    }

    private const val UPDATE_SET_TEXT_DECORATIONS_HASH = 457503484L
    private val updateSetTextDecorationsBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_text_decorations", UPDATE_SET_TEXT_DECORATIONS_HASH)
    }

    private const val UPDATE_SET_TEXT_ALIGN_HASH = 3725995085L
    private val updateSetTextAlignBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_text_align", UPDATE_SET_TEXT_ALIGN_HASH)
    }

    private const val UPDATE_SET_TEXT_SELECTION_HASH = 3119144029L
    private val updateSetTextSelectionBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_text_selection", UPDATE_SET_TEXT_SELECTION_HASH)
    }

    private const val UPDATE_SET_FLAG_HASH = 1473043386L
    private val updateSetFlagBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_flag", UPDATE_SET_FLAG_HASH)
    }

    private const val UPDATE_SET_CLASSNAME_HASH = 2726140452L
    private val updateSetClassnameBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_classname", UPDATE_SET_CLASSNAME_HASH)
    }

    private const val UPDATE_SET_PLACEHOLDER_HASH = 2726140452L
    private val updateSetPlaceholderBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_placeholder", UPDATE_SET_PLACEHOLDER_HASH)
    }

    private const val UPDATE_SET_LANGUAGE_HASH = 2726140452L
    private val updateSetLanguageBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_language", UPDATE_SET_LANGUAGE_HASH)
    }

    private const val UPDATE_SET_TEXT_ORIENTATION_HASH = 1265174801L
    private val updateSetTextOrientationBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_text_orientation", UPDATE_SET_TEXT_ORIENTATION_HASH)
    }

    private const val UPDATE_SET_LIST_ORIENTATION_HASH = 1265174801L
    private val updateSetListOrientationBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_list_orientation", UPDATE_SET_LIST_ORIENTATION_HASH)
    }

    private const val UPDATE_SET_SHORTCUT_HASH = 2726140452L
    private val updateSetShortcutBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_shortcut", UPDATE_SET_SHORTCUT_HASH)
    }

    private const val UPDATE_SET_URL_HASH = 2726140452L
    private val updateSetUrlBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_url", UPDATE_SET_URL_HASH)
    }

    private const val UPDATE_SET_ROLE_DESCRIPTION_HASH = 2726140452L
    private val updateSetRoleDescriptionBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_role_description", UPDATE_SET_ROLE_DESCRIPTION_HASH)
    }

    private const val UPDATE_SET_STATE_DESCRIPTION_HASH = 2726140452L
    private val updateSetStateDescriptionBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_state_description", UPDATE_SET_STATE_DESCRIPTION_HASH)
    }

    private const val UPDATE_SET_COLOR_VALUE_HASH = 2948539648L
    private val updateSetColorValueBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_color_value", UPDATE_SET_COLOR_VALUE_HASH)
    }

    private const val UPDATE_SET_BACKGROUND_COLOR_HASH = 2948539648L
    private val updateSetBackgroundColorBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_background_color", UPDATE_SET_BACKGROUND_COLOR_HASH)
    }

    private const val UPDATE_SET_FOREGROUND_COLOR_HASH = 2948539648L
    private val updateSetForegroundColorBind by lazy {
        ObjectCalls.getMethodBind("AccessibilityServer", "update_set_foreground_color", UPDATE_SET_FOREGROUND_COLOR_HASH)
    }
}
