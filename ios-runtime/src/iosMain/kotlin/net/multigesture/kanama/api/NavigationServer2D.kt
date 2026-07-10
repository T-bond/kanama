package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*
import net.multigesture.kanama.types.RID
import net.multigesture.kanama.types.Rect2
import net.multigesture.kanama.types.Transform2D
import net.multigesture.kanama.types.Vector2

/**
 * Generated from Godot docs: NavigationServer2D
 */
object NavigationServer2D {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("NavigationServer2D")
    }

    const val INFO_ACTIVE_MAPS: Long = 0L
    const val INFO_REGION_COUNT: Long = 1L
    const val INFO_AGENT_COUNT: Long = 2L
    const val INFO_LINK_COUNT: Long = 3L
    const val INFO_POLYGON_COUNT: Long = 4L
    const val INFO_EDGE_COUNT: Long = 5L
    const val INFO_EDGE_MERGE_COUNT: Long = 6L
    const val INFO_EDGE_CONNECTION_COUNT: Long = 7L
    const val INFO_EDGE_FREE_COUNT: Long = 8L
    const val INFO_OBSTACLE_COUNT: Long = 9L

    fun mapCreate(): RID {
        return ObjectCalls.ptrcallNoArgsRetRID(mapCreateBind, singleton)
    }

    fun mapSetActive(map: RID, active: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(mapSetActiveBind, singleton, map, active)
    }

    fun mapIsActive(map: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(mapIsActiveBind, singleton, map)
    }

    fun mapSetCellSize(map: RID, cellSize: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(mapSetCellSizeBind, singleton, map, cellSize)
    }

    fun mapGetCellSize(map: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(mapGetCellSizeBind, singleton, map)
    }

    fun mapSetMergeRasterizerCellScale(map: RID, scale: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(mapSetMergeRasterizerCellScaleBind, singleton, map, scale)
    }

    fun mapGetMergeRasterizerCellScale(map: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(mapGetMergeRasterizerCellScaleBind, singleton, map)
    }

    fun mapSetUseEdgeConnections(map: RID, enabled: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(mapSetUseEdgeConnectionsBind, singleton, map, enabled)
    }

    fun mapGetUseEdgeConnections(map: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(mapGetUseEdgeConnectionsBind, singleton, map)
    }

    fun mapSetEdgeConnectionMargin(map: RID, margin: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(mapSetEdgeConnectionMarginBind, singleton, map, margin)
    }

    fun mapGetEdgeConnectionMargin(map: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(mapGetEdgeConnectionMarginBind, singleton, map)
    }

    fun mapSetLinkConnectionRadius(map: RID, radius: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(mapSetLinkConnectionRadiusBind, singleton, map, radius)
    }

    fun mapGetLinkConnectionRadius(map: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(mapGetLinkConnectionRadiusBind, singleton, map)
    }

    fun mapGetClosestPoint(map: RID, toPoint: Vector2): Vector2 {
        return ObjectCalls.ptrcallWithRIDAndVector2ArgRetVector2(mapGetClosestPointBind, singleton, map, toPoint)
    }

    fun mapGetClosestPointOwner(map: RID, toPoint: Vector2): RID {
        return ObjectCalls.ptrcallWithRIDAndVector2ArgRetRID(mapGetClosestPointOwnerBind, singleton, map, toPoint)
    }

    fun mapForceUpdate(map: RID) {
        ObjectCalls.ptrcallWithRIDArg(mapForceUpdateBind, singleton, map)
    }

    fun mapGetIterationId(map: RID): Long {
        return ObjectCalls.ptrcallWithRIDArgRetUInt32(mapGetIterationIdBind, singleton, map)
    }

    fun mapSetUseAsyncIterations(map: RID, enabled: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(mapSetUseAsyncIterationsBind, singleton, map, enabled)
    }

    fun mapGetUseAsyncIterations(map: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(mapGetUseAsyncIterationsBind, singleton, map)
    }

    fun mapGetRandomPoint(map: RID, navigationLayers: Long, uniformly: Boolean): Vector2 {
        return ObjectCalls.ptrcallWithRIDUInt32BoolArgsRetVector2(mapGetRandomPointBind, singleton, map, navigationLayers, uniformly)
    }

    fun queryPath(parameters: NavigationPathQueryParameters2D?, result: NavigationPathQueryResult2D?, callback: GodotCallable) {
        ObjectCalls.ptrcallWithTwoObjectCallableArgs(queryPathBind, singleton, parameters?.requireOpenHandle() ?: MemorySegment.NULL, result?.requireOpenHandle() ?: MemorySegment.NULL, callback.target.handle, callback.method)
    }

    fun regionCreate(): RID {
        return ObjectCalls.ptrcallNoArgsRetRID(regionCreateBind, singleton)
    }

    fun regionGetIterationId(region: RID): Long {
        return ObjectCalls.ptrcallWithRIDArgRetUInt32(regionGetIterationIdBind, singleton, region)
    }

    fun regionSetUseAsyncIterations(region: RID, enabled: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(regionSetUseAsyncIterationsBind, singleton, region, enabled)
    }

    fun regionGetUseAsyncIterations(region: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(regionGetUseAsyncIterationsBind, singleton, region)
    }

    fun regionSetEnabled(region: RID, enabled: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(regionSetEnabledBind, singleton, region, enabled)
    }

    fun regionGetEnabled(region: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(regionGetEnabledBind, singleton, region)
    }

    fun regionSetUseEdgeConnections(region: RID, enabled: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(regionSetUseEdgeConnectionsBind, singleton, region, enabled)
    }

    fun regionGetUseEdgeConnections(region: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(regionGetUseEdgeConnectionsBind, singleton, region)
    }

    fun regionSetEnterCost(region: RID, enterCost: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(regionSetEnterCostBind, singleton, region, enterCost)
    }

    fun regionGetEnterCost(region: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(regionGetEnterCostBind, singleton, region)
    }

    fun regionSetTravelCost(region: RID, travelCost: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(regionSetTravelCostBind, singleton, region, travelCost)
    }

    fun regionGetTravelCost(region: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(regionGetTravelCostBind, singleton, region)
    }

    fun regionSetOwnerId(region: RID, ownerId: Long) {
        ObjectCalls.ptrcallWithRIDAndLongArg(regionSetOwnerIdBind, singleton, region, ownerId)
    }

    fun regionGetOwnerId(region: RID): Long {
        return ObjectCalls.ptrcallWithRIDArgRetLong(regionGetOwnerIdBind, singleton, region)
    }

    fun regionOwnsPoint(region: RID, point: Vector2): Boolean {
        return ObjectCalls.ptrcallWithRIDAndVector2ArgRetBool(regionOwnsPointBind, singleton, region, point)
    }

    fun regionSetMap(region: RID, map: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(regionSetMapBind, singleton, region, map)
    }

    fun regionGetMap(region: RID): RID {
        return ObjectCalls.ptrcallWithRIDArgRetRID(regionGetMapBind, singleton, region)
    }

    fun regionSetNavigationLayers(region: RID, navigationLayers: Long) {
        ObjectCalls.ptrcallWithRIDAndUInt32Arg(regionSetNavigationLayersBind, singleton, region, navigationLayers)
    }

    fun regionGetNavigationLayers(region: RID): Long {
        return ObjectCalls.ptrcallWithRIDArgRetUInt32(regionGetNavigationLayersBind, singleton, region)
    }

    fun regionSetTransform(region: RID, transform: Transform2D) {
        ObjectCalls.ptrcallWithRIDAndTransform2DArg(regionSetTransformBind, singleton, region, transform)
    }

    fun regionGetTransform(region: RID): Transform2D {
        return ObjectCalls.ptrcallWithRIDArgRetTransform2D(regionGetTransformBind, singleton, region)
    }

    fun regionSetNavigationPolygon(region: RID, navigationPolygon: NavigationPolygon?) {
        ObjectCalls.ptrcallWithRIDAndObjectArg(regionSetNavigationPolygonBind, singleton, region, navigationPolygon?.requireOpenHandle() ?: MemorySegment.NULL)
    }

    fun regionGetConnectionsCount(region: RID): Int {
        return ObjectCalls.ptrcallWithRIDArgRetInt(regionGetConnectionsCountBind, singleton, region)
    }

    fun regionGetConnectionPathwayStart(region: RID, connection: Int): Vector2 {
        return ObjectCalls.ptrcallWithRIDAndIntArgRetVector2(regionGetConnectionPathwayStartBind, singleton, region, connection)
    }

    fun regionGetConnectionPathwayEnd(region: RID, connection: Int): Vector2 {
        return ObjectCalls.ptrcallWithRIDAndIntArgRetVector2(regionGetConnectionPathwayEndBind, singleton, region, connection)
    }

    fun regionGetClosestPoint(region: RID, toPoint: Vector2): Vector2 {
        return ObjectCalls.ptrcallWithRIDAndVector2ArgRetVector2(regionGetClosestPointBind, singleton, region, toPoint)
    }

    fun regionGetRandomPoint(region: RID, navigationLayers: Long, uniformly: Boolean): Vector2 {
        return ObjectCalls.ptrcallWithRIDUInt32BoolArgsRetVector2(regionGetRandomPointBind, singleton, region, navigationLayers, uniformly)
    }

    fun regionGetBounds(region: RID): Rect2 {
        return ObjectCalls.ptrcallWithRIDArgRetRect2(regionGetBoundsBind, singleton, region)
    }

    fun linkCreate(): RID {
        return ObjectCalls.ptrcallNoArgsRetRID(linkCreateBind, singleton)
    }

    fun linkGetIterationId(link: RID): Long {
        return ObjectCalls.ptrcallWithRIDArgRetUInt32(linkGetIterationIdBind, singleton, link)
    }

    fun linkSetMap(link: RID, map: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(linkSetMapBind, singleton, link, map)
    }

    fun linkGetMap(link: RID): RID {
        return ObjectCalls.ptrcallWithRIDArgRetRID(linkGetMapBind, singleton, link)
    }

    fun linkSetEnabled(link: RID, enabled: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(linkSetEnabledBind, singleton, link, enabled)
    }

    fun linkGetEnabled(link: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(linkGetEnabledBind, singleton, link)
    }

    fun linkSetBidirectional(link: RID, bidirectional: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(linkSetBidirectionalBind, singleton, link, bidirectional)
    }

    fun linkIsBidirectional(link: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(linkIsBidirectionalBind, singleton, link)
    }

    fun linkSetNavigationLayers(link: RID, navigationLayers: Long) {
        ObjectCalls.ptrcallWithRIDAndUInt32Arg(linkSetNavigationLayersBind, singleton, link, navigationLayers)
    }

    fun linkGetNavigationLayers(link: RID): Long {
        return ObjectCalls.ptrcallWithRIDArgRetUInt32(linkGetNavigationLayersBind, singleton, link)
    }

    fun linkSetStartPosition(link: RID, position: Vector2) {
        ObjectCalls.ptrcallWithRIDAndVector2Arg(linkSetStartPositionBind, singleton, link, position)
    }

    fun linkGetStartPosition(link: RID): Vector2 {
        return ObjectCalls.ptrcallWithRIDArgRetVector2(linkGetStartPositionBind, singleton, link)
    }

    fun linkSetEndPosition(link: RID, position: Vector2) {
        ObjectCalls.ptrcallWithRIDAndVector2Arg(linkSetEndPositionBind, singleton, link, position)
    }

    fun linkGetEndPosition(link: RID): Vector2 {
        return ObjectCalls.ptrcallWithRIDArgRetVector2(linkGetEndPositionBind, singleton, link)
    }

    fun linkSetEnterCost(link: RID, enterCost: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(linkSetEnterCostBind, singleton, link, enterCost)
    }

    fun linkGetEnterCost(link: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(linkGetEnterCostBind, singleton, link)
    }

    fun linkSetTravelCost(link: RID, travelCost: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(linkSetTravelCostBind, singleton, link, travelCost)
    }

    fun linkGetTravelCost(link: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(linkGetTravelCostBind, singleton, link)
    }

    fun linkSetOwnerId(link: RID, ownerId: Long) {
        ObjectCalls.ptrcallWithRIDAndLongArg(linkSetOwnerIdBind, singleton, link, ownerId)
    }

    fun linkGetOwnerId(link: RID): Long {
        return ObjectCalls.ptrcallWithRIDArgRetLong(linkGetOwnerIdBind, singleton, link)
    }

    fun agentCreate(): RID {
        return ObjectCalls.ptrcallNoArgsRetRID(agentCreateBind, singleton)
    }

    fun agentSetAvoidanceEnabled(agent: RID, enabled: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(agentSetAvoidanceEnabledBind, singleton, agent, enabled)
    }

    fun agentGetAvoidanceEnabled(agent: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(agentGetAvoidanceEnabledBind, singleton, agent)
    }

    fun agentSetMap(agent: RID, map: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(agentSetMapBind, singleton, agent, map)
    }

    fun agentGetMap(agent: RID): RID {
        return ObjectCalls.ptrcallWithRIDArgRetRID(agentGetMapBind, singleton, agent)
    }

    fun agentSetPaused(agent: RID, paused: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(agentSetPausedBind, singleton, agent, paused)
    }

    fun agentGetPaused(agent: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(agentGetPausedBind, singleton, agent)
    }

    fun agentSetNeighborDistance(agent: RID, distance: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(agentSetNeighborDistanceBind, singleton, agent, distance)
    }

    fun agentGetNeighborDistance(agent: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(agentGetNeighborDistanceBind, singleton, agent)
    }

    fun agentSetMaxNeighbors(agent: RID, count: Int) {
        ObjectCalls.ptrcallWithRIDAndIntArg(agentSetMaxNeighborsBind, singleton, agent, count)
    }

    fun agentGetMaxNeighbors(agent: RID): Int {
        return ObjectCalls.ptrcallWithRIDArgRetInt(agentGetMaxNeighborsBind, singleton, agent)
    }

    fun agentSetTimeHorizonAgents(agent: RID, timeHorizon: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(agentSetTimeHorizonAgentsBind, singleton, agent, timeHorizon)
    }

    fun agentGetTimeHorizonAgents(agent: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(agentGetTimeHorizonAgentsBind, singleton, agent)
    }

    fun agentSetTimeHorizonObstacles(agent: RID, timeHorizon: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(agentSetTimeHorizonObstaclesBind, singleton, agent, timeHorizon)
    }

    fun agentGetTimeHorizonObstacles(agent: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(agentGetTimeHorizonObstaclesBind, singleton, agent)
    }

    fun agentSetRadius(agent: RID, radius: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(agentSetRadiusBind, singleton, agent, radius)
    }

    fun agentGetRadius(agent: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(agentGetRadiusBind, singleton, agent)
    }

    fun agentSetMaxSpeed(agent: RID, maxSpeed: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(agentSetMaxSpeedBind, singleton, agent, maxSpeed)
    }

    fun agentGetMaxSpeed(agent: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(agentGetMaxSpeedBind, singleton, agent)
    }

    fun agentSetVelocityForced(agent: RID, velocity: Vector2) {
        ObjectCalls.ptrcallWithRIDAndVector2Arg(agentSetVelocityForcedBind, singleton, agent, velocity)
    }

    fun agentSetVelocity(agent: RID, velocity: Vector2) {
        ObjectCalls.ptrcallWithRIDAndVector2Arg(agentSetVelocityBind, singleton, agent, velocity)
    }

    fun agentGetVelocity(agent: RID): Vector2 {
        return ObjectCalls.ptrcallWithRIDArgRetVector2(agentGetVelocityBind, singleton, agent)
    }

    fun agentSetPosition(agent: RID, position: Vector2) {
        ObjectCalls.ptrcallWithRIDAndVector2Arg(agentSetPositionBind, singleton, agent, position)
    }

    fun agentGetPosition(agent: RID): Vector2 {
        return ObjectCalls.ptrcallWithRIDArgRetVector2(agentGetPositionBind, singleton, agent)
    }

    fun agentIsMapChanged(agent: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(agentIsMapChangedBind, singleton, agent)
    }

    fun agentSetAvoidanceCallback(agent: RID, callback: GodotCallable) {
        ObjectCalls.ptrcallWithRIDCallableArgs(agentSetAvoidanceCallbackBind, singleton, agent, callback.target.handle, callback.method)
    }

    fun agentHasAvoidanceCallback(agent: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(agentHasAvoidanceCallbackBind, singleton, agent)
    }

    fun agentSetAvoidanceLayers(agent: RID, layers: Long) {
        ObjectCalls.ptrcallWithRIDAndUInt32Arg(agentSetAvoidanceLayersBind, singleton, agent, layers)
    }

    fun agentGetAvoidanceLayers(agent: RID): Long {
        return ObjectCalls.ptrcallWithRIDArgRetUInt32(agentGetAvoidanceLayersBind, singleton, agent)
    }

    fun agentSetAvoidanceMask(agent: RID, mask: Long) {
        ObjectCalls.ptrcallWithRIDAndUInt32Arg(agentSetAvoidanceMaskBind, singleton, agent, mask)
    }

    fun agentGetAvoidanceMask(agent: RID): Long {
        return ObjectCalls.ptrcallWithRIDArgRetUInt32(agentGetAvoidanceMaskBind, singleton, agent)
    }

    fun agentSetAvoidancePriority(agent: RID, priority: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(agentSetAvoidancePriorityBind, singleton, agent, priority)
    }

    fun agentGetAvoidancePriority(agent: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(agentGetAvoidancePriorityBind, singleton, agent)
    }

    fun obstacleCreate(): RID {
        return ObjectCalls.ptrcallNoArgsRetRID(obstacleCreateBind, singleton)
    }

    fun obstacleSetAvoidanceEnabled(obstacle: RID, enabled: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(obstacleSetAvoidanceEnabledBind, singleton, obstacle, enabled)
    }

    fun obstacleGetAvoidanceEnabled(obstacle: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(obstacleGetAvoidanceEnabledBind, singleton, obstacle)
    }

    fun obstacleSetMap(obstacle: RID, map: RID) {
        ObjectCalls.ptrcallWithTwoRIDArgs(obstacleSetMapBind, singleton, obstacle, map)
    }

    fun obstacleGetMap(obstacle: RID): RID {
        return ObjectCalls.ptrcallWithRIDArgRetRID(obstacleGetMapBind, singleton, obstacle)
    }

    fun obstacleSetPaused(obstacle: RID, paused: Boolean) {
        ObjectCalls.ptrcallWithRIDAndBoolArg(obstacleSetPausedBind, singleton, obstacle, paused)
    }

    fun obstacleGetPaused(obstacle: RID): Boolean {
        return ObjectCalls.ptrcallWithRIDArgRetBool(obstacleGetPausedBind, singleton, obstacle)
    }

    fun obstacleSetRadius(obstacle: RID, radius: Double) {
        ObjectCalls.ptrcallWithRIDAndDoubleArg(obstacleSetRadiusBind, singleton, obstacle, radius)
    }

    fun obstacleGetRadius(obstacle: RID): Double {
        return ObjectCalls.ptrcallWithRIDArgRetDouble(obstacleGetRadiusBind, singleton, obstacle)
    }

    fun obstacleSetVelocity(obstacle: RID, velocity: Vector2) {
        ObjectCalls.ptrcallWithRIDAndVector2Arg(obstacleSetVelocityBind, singleton, obstacle, velocity)
    }

    fun obstacleGetVelocity(obstacle: RID): Vector2 {
        return ObjectCalls.ptrcallWithRIDArgRetVector2(obstacleGetVelocityBind, singleton, obstacle)
    }

    fun obstacleSetPosition(obstacle: RID, position: Vector2) {
        ObjectCalls.ptrcallWithRIDAndVector2Arg(obstacleSetPositionBind, singleton, obstacle, position)
    }

    fun obstacleGetPosition(obstacle: RID): Vector2 {
        return ObjectCalls.ptrcallWithRIDArgRetVector2(obstacleGetPositionBind, singleton, obstacle)
    }

    fun obstacleSetAvoidanceLayers(obstacle: RID, layers: Long) {
        ObjectCalls.ptrcallWithRIDAndUInt32Arg(obstacleSetAvoidanceLayersBind, singleton, obstacle, layers)
    }

    fun obstacleGetAvoidanceLayers(obstacle: RID): Long {
        return ObjectCalls.ptrcallWithRIDArgRetUInt32(obstacleGetAvoidanceLayersBind, singleton, obstacle)
    }

    fun parseSourceGeometryData(navigationPolygon: NavigationPolygon?, sourceGeometryData: NavigationMeshSourceGeometryData2D?, rootNode: Node, callback: GodotCallable) {
        ObjectCalls.ptrcallWithThreeObjectCallableArgs(parseSourceGeometryDataBind, singleton, navigationPolygon?.requireOpenHandle() ?: MemorySegment.NULL, sourceGeometryData?.requireOpenHandle() ?: MemorySegment.NULL, rootNode.handle, callback.target.handle, callback.method)
    }

    fun bakeFromSourceGeometryData(navigationPolygon: NavigationPolygon?, sourceGeometryData: NavigationMeshSourceGeometryData2D?, callback: GodotCallable) {
        ObjectCalls.ptrcallWithTwoObjectCallableArgs(bakeFromSourceGeometryDataBind, singleton, navigationPolygon?.requireOpenHandle() ?: MemorySegment.NULL, sourceGeometryData?.requireOpenHandle() ?: MemorySegment.NULL, callback.target.handle, callback.method)
    }

    fun bakeFromSourceGeometryDataAsync(navigationPolygon: NavigationPolygon?, sourceGeometryData: NavigationMeshSourceGeometryData2D?, callback: GodotCallable) {
        ObjectCalls.ptrcallWithTwoObjectCallableArgs(bakeFromSourceGeometryDataAsyncBind, singleton, navigationPolygon?.requireOpenHandle() ?: MemorySegment.NULL, sourceGeometryData?.requireOpenHandle() ?: MemorySegment.NULL, callback.target.handle, callback.method)
    }

    fun isBakingNavigationPolygon(navigationPolygon: NavigationPolygon?): Boolean {
        return ObjectCalls.ptrcallWithObjectArgRetBool(isBakingNavigationPolygonBind, singleton, navigationPolygon?.requireOpenHandle() ?: MemorySegment.NULL)
    }

    fun sourceGeometryParserCreate(): RID {
        return ObjectCalls.ptrcallNoArgsRetRID(sourceGeometryParserCreateBind, singleton)
    }

    fun sourceGeometryParserSetCallback(parser: RID, callback: GodotCallable) {
        ObjectCalls.ptrcallWithRIDCallableArgs(sourceGeometryParserSetCallbackBind, singleton, parser, callback.target.handle, callback.method)
    }

    fun freeRid(rid: RID) {
        ObjectCalls.ptrcallWithRIDArg(freeRidBind, singleton, rid)
    }

    fun setActive(active: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setActiveBind, singleton, active)
    }

    fun setDebugEnabled(enabled: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setDebugEnabledBind, singleton, enabled)
    }

    fun getDebugEnabled(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(getDebugEnabledBind, singleton)
    }

    fun getProcessInfo(processInfo: Long): Int {
        return ObjectCalls.ptrcallWithLongArgRetInt(getProcessInfoBind, singleton, processInfo)
    }

    object Signals {
        const val mapChanged: String = "map_changed"
        const val navigationDebugChanged: String = "navigation_debug_changed"
        const val avoidanceDebugChanged: String = "avoidance_debug_changed"
    }

    fun fromHandle(handle: MemorySegment): NavigationServer2D? =
        wrap(handle)

    internal fun wrap(handle: MemorySegment): NavigationServer2D? =
        if (handle.address() == 0L) null else this

    private const val MAP_CREATE_HASH = 529393457L
    private val mapCreateBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_create", MAP_CREATE_HASH)
    }

    private const val MAP_SET_ACTIVE_HASH = 1265174801L
    private val mapSetActiveBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_set_active", MAP_SET_ACTIVE_HASH)
    }

    private const val MAP_IS_ACTIVE_HASH = 4155700596L
    private val mapIsActiveBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_is_active", MAP_IS_ACTIVE_HASH)
    }

    private const val MAP_SET_CELL_SIZE_HASH = 1794382983L
    private val mapSetCellSizeBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_set_cell_size", MAP_SET_CELL_SIZE_HASH)
    }

    private const val MAP_GET_CELL_SIZE_HASH = 866169185L
    private val mapGetCellSizeBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_get_cell_size", MAP_GET_CELL_SIZE_HASH)
    }

    private const val MAP_SET_MERGE_RASTERIZER_CELL_SCALE_HASH = 1794382983L
    private val mapSetMergeRasterizerCellScaleBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_set_merge_rasterizer_cell_scale", MAP_SET_MERGE_RASTERIZER_CELL_SCALE_HASH)
    }

    private const val MAP_GET_MERGE_RASTERIZER_CELL_SCALE_HASH = 866169185L
    private val mapGetMergeRasterizerCellScaleBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_get_merge_rasterizer_cell_scale", MAP_GET_MERGE_RASTERIZER_CELL_SCALE_HASH)
    }

    private const val MAP_SET_USE_EDGE_CONNECTIONS_HASH = 1265174801L
    private val mapSetUseEdgeConnectionsBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_set_use_edge_connections", MAP_SET_USE_EDGE_CONNECTIONS_HASH)
    }

    private const val MAP_GET_USE_EDGE_CONNECTIONS_HASH = 4155700596L
    private val mapGetUseEdgeConnectionsBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_get_use_edge_connections", MAP_GET_USE_EDGE_CONNECTIONS_HASH)
    }

    private const val MAP_SET_EDGE_CONNECTION_MARGIN_HASH = 1794382983L
    private val mapSetEdgeConnectionMarginBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_set_edge_connection_margin", MAP_SET_EDGE_CONNECTION_MARGIN_HASH)
    }

    private const val MAP_GET_EDGE_CONNECTION_MARGIN_HASH = 866169185L
    private val mapGetEdgeConnectionMarginBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_get_edge_connection_margin", MAP_GET_EDGE_CONNECTION_MARGIN_HASH)
    }

    private const val MAP_SET_LINK_CONNECTION_RADIUS_HASH = 1794382983L
    private val mapSetLinkConnectionRadiusBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_set_link_connection_radius", MAP_SET_LINK_CONNECTION_RADIUS_HASH)
    }

    private const val MAP_GET_LINK_CONNECTION_RADIUS_HASH = 866169185L
    private val mapGetLinkConnectionRadiusBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_get_link_connection_radius", MAP_GET_LINK_CONNECTION_RADIUS_HASH)
    }

    private const val MAP_GET_CLOSEST_POINT_HASH = 1358334418L
    private val mapGetClosestPointBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_get_closest_point", MAP_GET_CLOSEST_POINT_HASH)
    }

    private const val MAP_GET_CLOSEST_POINT_OWNER_HASH = 1353467510L
    private val mapGetClosestPointOwnerBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_get_closest_point_owner", MAP_GET_CLOSEST_POINT_OWNER_HASH)
    }

    private const val MAP_FORCE_UPDATE_HASH = 2722037293L
    private val mapForceUpdateBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_force_update", MAP_FORCE_UPDATE_HASH)
    }

    private const val MAP_GET_ITERATION_ID_HASH = 2198884583L
    private val mapGetIterationIdBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_get_iteration_id", MAP_GET_ITERATION_ID_HASH)
    }

    private const val MAP_SET_USE_ASYNC_ITERATIONS_HASH = 1265174801L
    private val mapSetUseAsyncIterationsBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_set_use_async_iterations", MAP_SET_USE_ASYNC_ITERATIONS_HASH)
    }

    private const val MAP_GET_USE_ASYNC_ITERATIONS_HASH = 4155700596L
    private val mapGetUseAsyncIterationsBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_get_use_async_iterations", MAP_GET_USE_ASYNC_ITERATIONS_HASH)
    }

    private const val MAP_GET_RANDOM_POINT_HASH = 3271000763L
    private val mapGetRandomPointBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "map_get_random_point", MAP_GET_RANDOM_POINT_HASH)
    }

    private const val QUERY_PATH_HASH = 1254915886L
    private val queryPathBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "query_path", QUERY_PATH_HASH)
    }

    private const val REGION_CREATE_HASH = 529393457L
    private val regionCreateBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_create", REGION_CREATE_HASH)
    }

    private const val REGION_GET_ITERATION_ID_HASH = 2198884583L
    private val regionGetIterationIdBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_iteration_id", REGION_GET_ITERATION_ID_HASH)
    }

    private const val REGION_SET_USE_ASYNC_ITERATIONS_HASH = 1265174801L
    private val regionSetUseAsyncIterationsBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_set_use_async_iterations", REGION_SET_USE_ASYNC_ITERATIONS_HASH)
    }

    private const val REGION_GET_USE_ASYNC_ITERATIONS_HASH = 4155700596L
    private val regionGetUseAsyncIterationsBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_use_async_iterations", REGION_GET_USE_ASYNC_ITERATIONS_HASH)
    }

    private const val REGION_SET_ENABLED_HASH = 1265174801L
    private val regionSetEnabledBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_set_enabled", REGION_SET_ENABLED_HASH)
    }

    private const val REGION_GET_ENABLED_HASH = 4155700596L
    private val regionGetEnabledBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_enabled", REGION_GET_ENABLED_HASH)
    }

    private const val REGION_SET_USE_EDGE_CONNECTIONS_HASH = 1265174801L
    private val regionSetUseEdgeConnectionsBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_set_use_edge_connections", REGION_SET_USE_EDGE_CONNECTIONS_HASH)
    }

    private const val REGION_GET_USE_EDGE_CONNECTIONS_HASH = 4155700596L
    private val regionGetUseEdgeConnectionsBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_use_edge_connections", REGION_GET_USE_EDGE_CONNECTIONS_HASH)
    }

    private const val REGION_SET_ENTER_COST_HASH = 1794382983L
    private val regionSetEnterCostBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_set_enter_cost", REGION_SET_ENTER_COST_HASH)
    }

    private const val REGION_GET_ENTER_COST_HASH = 866169185L
    private val regionGetEnterCostBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_enter_cost", REGION_GET_ENTER_COST_HASH)
    }

    private const val REGION_SET_TRAVEL_COST_HASH = 1794382983L
    private val regionSetTravelCostBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_set_travel_cost", REGION_SET_TRAVEL_COST_HASH)
    }

    private const val REGION_GET_TRAVEL_COST_HASH = 866169185L
    private val regionGetTravelCostBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_travel_cost", REGION_GET_TRAVEL_COST_HASH)
    }

    private const val REGION_SET_OWNER_ID_HASH = 3411492887L
    private val regionSetOwnerIdBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_set_owner_id", REGION_SET_OWNER_ID_HASH)
    }

    private const val REGION_GET_OWNER_ID_HASH = 2198884583L
    private val regionGetOwnerIdBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_owner_id", REGION_GET_OWNER_ID_HASH)
    }

    private const val REGION_OWNS_POINT_HASH = 219849798L
    private val regionOwnsPointBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_owns_point", REGION_OWNS_POINT_HASH)
    }

    private const val REGION_SET_MAP_HASH = 395945892L
    private val regionSetMapBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_set_map", REGION_SET_MAP_HASH)
    }

    private const val REGION_GET_MAP_HASH = 3814569979L
    private val regionGetMapBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_map", REGION_GET_MAP_HASH)
    }

    private const val REGION_SET_NAVIGATION_LAYERS_HASH = 3411492887L
    private val regionSetNavigationLayersBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_set_navigation_layers", REGION_SET_NAVIGATION_LAYERS_HASH)
    }

    private const val REGION_GET_NAVIGATION_LAYERS_HASH = 2198884583L
    private val regionGetNavigationLayersBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_navigation_layers", REGION_GET_NAVIGATION_LAYERS_HASH)
    }

    private const val REGION_SET_TRANSFORM_HASH = 1246044741L
    private val regionSetTransformBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_set_transform", REGION_SET_TRANSFORM_HASH)
    }

    private const val REGION_GET_TRANSFORM_HASH = 213527486L
    private val regionGetTransformBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_transform", REGION_GET_TRANSFORM_HASH)
    }

    private const val REGION_SET_NAVIGATION_POLYGON_HASH = 3633623451L
    private val regionSetNavigationPolygonBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_set_navigation_polygon", REGION_SET_NAVIGATION_POLYGON_HASH)
    }

    private const val REGION_GET_CONNECTIONS_COUNT_HASH = 2198884583L
    private val regionGetConnectionsCountBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_connections_count", REGION_GET_CONNECTIONS_COUNT_HASH)
    }

    private const val REGION_GET_CONNECTION_PATHWAY_START_HASH = 2546185844L
    private val regionGetConnectionPathwayStartBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_connection_pathway_start", REGION_GET_CONNECTION_PATHWAY_START_HASH)
    }

    private const val REGION_GET_CONNECTION_PATHWAY_END_HASH = 2546185844L
    private val regionGetConnectionPathwayEndBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_connection_pathway_end", REGION_GET_CONNECTION_PATHWAY_END_HASH)
    }

    private const val REGION_GET_CLOSEST_POINT_HASH = 1358334418L
    private val regionGetClosestPointBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_closest_point", REGION_GET_CLOSEST_POINT_HASH)
    }

    private const val REGION_GET_RANDOM_POINT_HASH = 3271000763L
    private val regionGetRandomPointBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_random_point", REGION_GET_RANDOM_POINT_HASH)
    }

    private const val REGION_GET_BOUNDS_HASH = 1097232729L
    private val regionGetBoundsBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "region_get_bounds", REGION_GET_BOUNDS_HASH)
    }

    private const val LINK_CREATE_HASH = 529393457L
    private val linkCreateBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_create", LINK_CREATE_HASH)
    }

    private const val LINK_GET_ITERATION_ID_HASH = 2198884583L
    private val linkGetIterationIdBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_get_iteration_id", LINK_GET_ITERATION_ID_HASH)
    }

    private const val LINK_SET_MAP_HASH = 395945892L
    private val linkSetMapBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_set_map", LINK_SET_MAP_HASH)
    }

    private const val LINK_GET_MAP_HASH = 3814569979L
    private val linkGetMapBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_get_map", LINK_GET_MAP_HASH)
    }

    private const val LINK_SET_ENABLED_HASH = 1265174801L
    private val linkSetEnabledBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_set_enabled", LINK_SET_ENABLED_HASH)
    }

    private const val LINK_GET_ENABLED_HASH = 4155700596L
    private val linkGetEnabledBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_get_enabled", LINK_GET_ENABLED_HASH)
    }

    private const val LINK_SET_BIDIRECTIONAL_HASH = 1265174801L
    private val linkSetBidirectionalBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_set_bidirectional", LINK_SET_BIDIRECTIONAL_HASH)
    }

    private const val LINK_IS_BIDIRECTIONAL_HASH = 4155700596L
    private val linkIsBidirectionalBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_is_bidirectional", LINK_IS_BIDIRECTIONAL_HASH)
    }

    private const val LINK_SET_NAVIGATION_LAYERS_HASH = 3411492887L
    private val linkSetNavigationLayersBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_set_navigation_layers", LINK_SET_NAVIGATION_LAYERS_HASH)
    }

    private const val LINK_GET_NAVIGATION_LAYERS_HASH = 2198884583L
    private val linkGetNavigationLayersBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_get_navigation_layers", LINK_GET_NAVIGATION_LAYERS_HASH)
    }

    private const val LINK_SET_START_POSITION_HASH = 3201125042L
    private val linkSetStartPositionBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_set_start_position", LINK_SET_START_POSITION_HASH)
    }

    private const val LINK_GET_START_POSITION_HASH = 2440833711L
    private val linkGetStartPositionBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_get_start_position", LINK_GET_START_POSITION_HASH)
    }

    private const val LINK_SET_END_POSITION_HASH = 3201125042L
    private val linkSetEndPositionBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_set_end_position", LINK_SET_END_POSITION_HASH)
    }

    private const val LINK_GET_END_POSITION_HASH = 2440833711L
    private val linkGetEndPositionBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_get_end_position", LINK_GET_END_POSITION_HASH)
    }

    private const val LINK_SET_ENTER_COST_HASH = 1794382983L
    private val linkSetEnterCostBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_set_enter_cost", LINK_SET_ENTER_COST_HASH)
    }

    private const val LINK_GET_ENTER_COST_HASH = 866169185L
    private val linkGetEnterCostBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_get_enter_cost", LINK_GET_ENTER_COST_HASH)
    }

    private const val LINK_SET_TRAVEL_COST_HASH = 1794382983L
    private val linkSetTravelCostBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_set_travel_cost", LINK_SET_TRAVEL_COST_HASH)
    }

    private const val LINK_GET_TRAVEL_COST_HASH = 866169185L
    private val linkGetTravelCostBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_get_travel_cost", LINK_GET_TRAVEL_COST_HASH)
    }

    private const val LINK_SET_OWNER_ID_HASH = 3411492887L
    private val linkSetOwnerIdBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_set_owner_id", LINK_SET_OWNER_ID_HASH)
    }

    private const val LINK_GET_OWNER_ID_HASH = 2198884583L
    private val linkGetOwnerIdBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "link_get_owner_id", LINK_GET_OWNER_ID_HASH)
    }

    private const val AGENT_CREATE_HASH = 529393457L
    private val agentCreateBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_create", AGENT_CREATE_HASH)
    }

    private const val AGENT_SET_AVOIDANCE_ENABLED_HASH = 1265174801L
    private val agentSetAvoidanceEnabledBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_avoidance_enabled", AGENT_SET_AVOIDANCE_ENABLED_HASH)
    }

    private const val AGENT_GET_AVOIDANCE_ENABLED_HASH = 4155700596L
    private val agentGetAvoidanceEnabledBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_get_avoidance_enabled", AGENT_GET_AVOIDANCE_ENABLED_HASH)
    }

    private const val AGENT_SET_MAP_HASH = 395945892L
    private val agentSetMapBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_map", AGENT_SET_MAP_HASH)
    }

    private const val AGENT_GET_MAP_HASH = 3814569979L
    private val agentGetMapBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_get_map", AGENT_GET_MAP_HASH)
    }

    private const val AGENT_SET_PAUSED_HASH = 1265174801L
    private val agentSetPausedBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_paused", AGENT_SET_PAUSED_HASH)
    }

    private const val AGENT_GET_PAUSED_HASH = 4155700596L
    private val agentGetPausedBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_get_paused", AGENT_GET_PAUSED_HASH)
    }

    private const val AGENT_SET_NEIGHBOR_DISTANCE_HASH = 1794382983L
    private val agentSetNeighborDistanceBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_neighbor_distance", AGENT_SET_NEIGHBOR_DISTANCE_HASH)
    }

    private const val AGENT_GET_NEIGHBOR_DISTANCE_HASH = 866169185L
    private val agentGetNeighborDistanceBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_get_neighbor_distance", AGENT_GET_NEIGHBOR_DISTANCE_HASH)
    }

    private const val AGENT_SET_MAX_NEIGHBORS_HASH = 3411492887L
    private val agentSetMaxNeighborsBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_max_neighbors", AGENT_SET_MAX_NEIGHBORS_HASH)
    }

    private const val AGENT_GET_MAX_NEIGHBORS_HASH = 2198884583L
    private val agentGetMaxNeighborsBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_get_max_neighbors", AGENT_GET_MAX_NEIGHBORS_HASH)
    }

    private const val AGENT_SET_TIME_HORIZON_AGENTS_HASH = 1794382983L
    private val agentSetTimeHorizonAgentsBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_time_horizon_agents", AGENT_SET_TIME_HORIZON_AGENTS_HASH)
    }

    private const val AGENT_GET_TIME_HORIZON_AGENTS_HASH = 866169185L
    private val agentGetTimeHorizonAgentsBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_get_time_horizon_agents", AGENT_GET_TIME_HORIZON_AGENTS_HASH)
    }

    private const val AGENT_SET_TIME_HORIZON_OBSTACLES_HASH = 1794382983L
    private val agentSetTimeHorizonObstaclesBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_time_horizon_obstacles", AGENT_SET_TIME_HORIZON_OBSTACLES_HASH)
    }

    private const val AGENT_GET_TIME_HORIZON_OBSTACLES_HASH = 866169185L
    private val agentGetTimeHorizonObstaclesBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_get_time_horizon_obstacles", AGENT_GET_TIME_HORIZON_OBSTACLES_HASH)
    }

    private const val AGENT_SET_RADIUS_HASH = 1794382983L
    private val agentSetRadiusBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_radius", AGENT_SET_RADIUS_HASH)
    }

    private const val AGENT_GET_RADIUS_HASH = 866169185L
    private val agentGetRadiusBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_get_radius", AGENT_GET_RADIUS_HASH)
    }

    private const val AGENT_SET_MAX_SPEED_HASH = 1794382983L
    private val agentSetMaxSpeedBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_max_speed", AGENT_SET_MAX_SPEED_HASH)
    }

    private const val AGENT_GET_MAX_SPEED_HASH = 866169185L
    private val agentGetMaxSpeedBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_get_max_speed", AGENT_GET_MAX_SPEED_HASH)
    }

    private const val AGENT_SET_VELOCITY_FORCED_HASH = 3201125042L
    private val agentSetVelocityForcedBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_velocity_forced", AGENT_SET_VELOCITY_FORCED_HASH)
    }

    private const val AGENT_SET_VELOCITY_HASH = 3201125042L
    private val agentSetVelocityBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_velocity", AGENT_SET_VELOCITY_HASH)
    }

    private const val AGENT_GET_VELOCITY_HASH = 2440833711L
    private val agentGetVelocityBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_get_velocity", AGENT_GET_VELOCITY_HASH)
    }

    private const val AGENT_SET_POSITION_HASH = 3201125042L
    private val agentSetPositionBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_position", AGENT_SET_POSITION_HASH)
    }

    private const val AGENT_GET_POSITION_HASH = 2440833711L
    private val agentGetPositionBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_get_position", AGENT_GET_POSITION_HASH)
    }

    private const val AGENT_IS_MAP_CHANGED_HASH = 4155700596L
    private val agentIsMapChangedBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_is_map_changed", AGENT_IS_MAP_CHANGED_HASH)
    }

    private const val AGENT_SET_AVOIDANCE_CALLBACK_HASH = 3379118538L
    private val agentSetAvoidanceCallbackBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_avoidance_callback", AGENT_SET_AVOIDANCE_CALLBACK_HASH)
    }

    private const val AGENT_HAS_AVOIDANCE_CALLBACK_HASH = 4155700596L
    private val agentHasAvoidanceCallbackBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_has_avoidance_callback", AGENT_HAS_AVOIDANCE_CALLBACK_HASH)
    }

    private const val AGENT_SET_AVOIDANCE_LAYERS_HASH = 3411492887L
    private val agentSetAvoidanceLayersBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_avoidance_layers", AGENT_SET_AVOIDANCE_LAYERS_HASH)
    }

    private const val AGENT_GET_AVOIDANCE_LAYERS_HASH = 2198884583L
    private val agentGetAvoidanceLayersBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_get_avoidance_layers", AGENT_GET_AVOIDANCE_LAYERS_HASH)
    }

    private const val AGENT_SET_AVOIDANCE_MASK_HASH = 3411492887L
    private val agentSetAvoidanceMaskBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_avoidance_mask", AGENT_SET_AVOIDANCE_MASK_HASH)
    }

    private const val AGENT_GET_AVOIDANCE_MASK_HASH = 2198884583L
    private val agentGetAvoidanceMaskBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_get_avoidance_mask", AGENT_GET_AVOIDANCE_MASK_HASH)
    }

    private const val AGENT_SET_AVOIDANCE_PRIORITY_HASH = 1794382983L
    private val agentSetAvoidancePriorityBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_set_avoidance_priority", AGENT_SET_AVOIDANCE_PRIORITY_HASH)
    }

    private const val AGENT_GET_AVOIDANCE_PRIORITY_HASH = 866169185L
    private val agentGetAvoidancePriorityBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "agent_get_avoidance_priority", AGENT_GET_AVOIDANCE_PRIORITY_HASH)
    }

    private const val OBSTACLE_CREATE_HASH = 529393457L
    private val obstacleCreateBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_create", OBSTACLE_CREATE_HASH)
    }

    private const val OBSTACLE_SET_AVOIDANCE_ENABLED_HASH = 1265174801L
    private val obstacleSetAvoidanceEnabledBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_set_avoidance_enabled", OBSTACLE_SET_AVOIDANCE_ENABLED_HASH)
    }

    private const val OBSTACLE_GET_AVOIDANCE_ENABLED_HASH = 4155700596L
    private val obstacleGetAvoidanceEnabledBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_get_avoidance_enabled", OBSTACLE_GET_AVOIDANCE_ENABLED_HASH)
    }

    private const val OBSTACLE_SET_MAP_HASH = 395945892L
    private val obstacleSetMapBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_set_map", OBSTACLE_SET_MAP_HASH)
    }

    private const val OBSTACLE_GET_MAP_HASH = 3814569979L
    private val obstacleGetMapBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_get_map", OBSTACLE_GET_MAP_HASH)
    }

    private const val OBSTACLE_SET_PAUSED_HASH = 1265174801L
    private val obstacleSetPausedBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_set_paused", OBSTACLE_SET_PAUSED_HASH)
    }

    private const val OBSTACLE_GET_PAUSED_HASH = 4155700596L
    private val obstacleGetPausedBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_get_paused", OBSTACLE_GET_PAUSED_HASH)
    }

    private const val OBSTACLE_SET_RADIUS_HASH = 1794382983L
    private val obstacleSetRadiusBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_set_radius", OBSTACLE_SET_RADIUS_HASH)
    }

    private const val OBSTACLE_GET_RADIUS_HASH = 866169185L
    private val obstacleGetRadiusBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_get_radius", OBSTACLE_GET_RADIUS_HASH)
    }

    private const val OBSTACLE_SET_VELOCITY_HASH = 3201125042L
    private val obstacleSetVelocityBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_set_velocity", OBSTACLE_SET_VELOCITY_HASH)
    }

    private const val OBSTACLE_GET_VELOCITY_HASH = 2440833711L
    private val obstacleGetVelocityBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_get_velocity", OBSTACLE_GET_VELOCITY_HASH)
    }

    private const val OBSTACLE_SET_POSITION_HASH = 3201125042L
    private val obstacleSetPositionBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_set_position", OBSTACLE_SET_POSITION_HASH)
    }

    private const val OBSTACLE_GET_POSITION_HASH = 2440833711L
    private val obstacleGetPositionBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_get_position", OBSTACLE_GET_POSITION_HASH)
    }

    private const val OBSTACLE_SET_AVOIDANCE_LAYERS_HASH = 3411492887L
    private val obstacleSetAvoidanceLayersBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_set_avoidance_layers", OBSTACLE_SET_AVOIDANCE_LAYERS_HASH)
    }

    private const val OBSTACLE_GET_AVOIDANCE_LAYERS_HASH = 2198884583L
    private val obstacleGetAvoidanceLayersBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "obstacle_get_avoidance_layers", OBSTACLE_GET_AVOIDANCE_LAYERS_HASH)
    }

    private const val PARSE_SOURCE_GEOMETRY_DATA_HASH = 1766905497L
    private val parseSourceGeometryDataBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "parse_source_geometry_data", PARSE_SOURCE_GEOMETRY_DATA_HASH)
    }

    private const val BAKE_FROM_SOURCE_GEOMETRY_DATA_HASH = 2179660022L
    private val bakeFromSourceGeometryDataBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "bake_from_source_geometry_data", BAKE_FROM_SOURCE_GEOMETRY_DATA_HASH)
    }

    private const val BAKE_FROM_SOURCE_GEOMETRY_DATA_ASYNC_HASH = 2179660022L
    private val bakeFromSourceGeometryDataAsyncBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "bake_from_source_geometry_data_async", BAKE_FROM_SOURCE_GEOMETRY_DATA_ASYNC_HASH)
    }

    private const val IS_BAKING_NAVIGATION_POLYGON_HASH = 3729405808L
    private val isBakingNavigationPolygonBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "is_baking_navigation_polygon", IS_BAKING_NAVIGATION_POLYGON_HASH)
    }

    private const val SOURCE_GEOMETRY_PARSER_CREATE_HASH = 529393457L
    private val sourceGeometryParserCreateBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "source_geometry_parser_create", SOURCE_GEOMETRY_PARSER_CREATE_HASH)
    }

    private const val SOURCE_GEOMETRY_PARSER_SET_CALLBACK_HASH = 3379118538L
    private val sourceGeometryParserSetCallbackBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "source_geometry_parser_set_callback", SOURCE_GEOMETRY_PARSER_SET_CALLBACK_HASH)
    }

    private const val FREE_RID_HASH = 2722037293L
    private val freeRidBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "free_rid", FREE_RID_HASH)
    }

    private const val SET_ACTIVE_HASH = 2586408642L
    private val setActiveBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "set_active", SET_ACTIVE_HASH)
    }

    private const val SET_DEBUG_ENABLED_HASH = 2586408642L
    private val setDebugEnabledBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "set_debug_enabled", SET_DEBUG_ENABLED_HASH)
    }

    private const val GET_DEBUG_ENABLED_HASH = 36873697L
    private val getDebugEnabledBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "get_debug_enabled", GET_DEBUG_ENABLED_HASH)
    }

    private const val GET_PROCESS_INFO_HASH = 1640219858L
    private val getProcessInfoBind by lazy {
        ObjectCalls.getMethodBind("NavigationServer2D", "get_process_info", GET_PROCESS_INFO_HASH)
    }
}
