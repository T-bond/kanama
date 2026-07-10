extends Node

var _kanama_smoke_reload_requested := false

func _on_pinged(value: int) -> void:
	print("[kanama:gd] received pinged(", value, ")")

func _ready() -> void:
	if OS.get_environment("KANAMA_IN_PROCESS_HOT_RELOAD_SMOKE") == "1":
		_kanama_hot_reload_smoke_ready()

	$HelloKanama.pinged.connect(_on_pinged)

	var a = $HelloKanama.ping()
	var b = $HelloKanama.ping()
	var c = $HelloKanama/HelloKanama.ping()
	print("[kanama:gd] ping results: ", a, " ", b, " ", c)

	print("[kanama:gd] initial counter = ", $HelloKanama.counter)
	$HelloKanama.counter = 42
	print("[kanama:gd] after set, counter = ", $HelloKanama.counter)
	$HelloKanama.counter += 1
	print("[kanama:gd] after inc, counter = ", $HelloKanama.counter)

	# Bool
	print("[kanama:gd] isActive (counter>0) = ", $HelloKanama.is_active())

	# String property
	print("[kanama:gd] initial label = ", $HelloKanama.label)
	$HelloKanama.label = "kanama"
	print("[kanama:gd] after set, label = ", $HelloKanama.label)

	# String arg + return
	var greeting = $HelloKanama.greet("World")
	print("[kanama:gd] greet result = ", greeting)

	# Double / float
	print("[kanama:gd] initial scale = ", $HelloKanama.scale)
	$HelloKanama.scale = 3.14
	print("[kanama:gd] after set, scale = ", $HelloKanama.scale)

	var kt_script = $ScriptNode.get_script()
	if kt_script != null:
		var methods = kt_script.get_script_method_list()
		var properties = kt_script.get_script_property_list()
		var signals = kt_script.get_script_signal_list()
		print("[kanama:gd] kt script methods size = ", methods.size())
		print("[kanama:gd] kt script properties size = ", properties.size())
		print("[kanama:gd] kt script signals size = ", signals.size())
		if methods.size() > 0:
			print("[kanama:gd] kt script method[0] = ", methods[0])
		if properties.size() > 0:
			print("[kanama:gd] kt script property[0] = ", properties[0])
		var has_export_group := false
		var has_export_subgroup := false
		for property in properties:
			if property.get("name", "") == "Smoke Properties" and int(property.get("usage", 0)) & PROPERTY_USAGE_GROUP:
				has_export_group = true
			if property.get("name", "") == "Runtime" and int(property.get("usage", 0)) & PROPERTY_USAGE_SUBGROUP:
				has_export_subgroup = true
		print("[kanama:gd] kt script export groups group=", has_export_group, " subgroup=", has_export_subgroup)
		if not has_export_group or not has_export_subgroup:
			push_error("Kanama script export group/subgroup metadata missing")
		var replace_smoke_scene = $ScriptNode.replace_smoke_scene()
		print("[kanama:gd] kt script replace_smoke_scene = ", replace_smoke_scene)
		if not replace_smoke_scene:
			push_error("Kanama script smoke_scene replacement failed")
		var rpc_config = kt_script.get_rpc_config()
		var rpc_replace_config = rpc_config.get("replace_smoke_scene", {}) if rpc_config is Dictionary else {}
		var rpc_config_ok = (
			rpc_config is Dictionary
			and rpc_replace_config is Dictionary
			and int(rpc_replace_config.get("rpc_mode", -1)) == MultiplayerAPI.RPC_MODE_AUTHORITY
			and bool(rpc_replace_config.get("call_local", false))
			and int(rpc_replace_config.get("transfer_mode", -1)) == MultiplayerPeer.TRANSFER_MODE_RELIABLE
			and int(rpc_replace_config.get("channel", -1)) == 0
		)
		print("[kanama:gd] kt script rpc config ok = ", rpc_config_ok)
		if not rpc_config_ok:
			push_error("Kanama script RPC config metadata missing or malformed")
		multiplayer.multiplayer_peer = OfflineMultiplayerPeer.new()
		var rpc_error = $ScriptNode.rpc("replace_smoke_scene")
		print("[kanama:gd] kt script rpc replace_smoke_scene error = ", rpc_error)
		if rpc_error != OK:
			push_error("Kanama script local RPC smoke failed")

	_kanama_virtual_return_families_smoke()

	#get_tree().quit()

# task 29 — virtual-return families. Calling an @OverrideVirtual method by name on a
# script-attached host routes through the script instance dispatch (the same path the
# engine's virtual call uses) and hands the marshalled Variant back to GDScript, so
# typeof() + content checks validate each family's return marshalling end to end.
func _kanama_virtual_return_families_smoke() -> void:
	var mesh_host = ClassDB.instantiate("Mesh")
	mesh_host.set_script(load("res://MeshVirtualReturnProbe.kt"))
	var v_aabb = mesh_host._get_aabb()
	var v_arr = mesh_host._surface_get_arrays(3)
	var v_lods = mesh_host._surface_get_lods(2)
	print("[kanama:gd] vret mesh aabb_type=", typeof(v_aabb) == TYPE_AABB,
		" aabb_pos=", v_aabb.position == Vector3(1, 2, 3),
		" aabb_size=", v_aabb.size == Vector3(4, 5, 6),
		" array_type=", typeof(v_arr) == TYPE_ARRAY,
		" array_vals=", v_arr.size() == 3 and v_arr[0] == 3 and v_arr[1] == "kanama" and v_arr[2] == true,
		" dict_type=", typeof(v_lods) == TYPE_DICTIONARY,
		" dict_vals=", v_lods.get("lod") == 2 and v_lods.get("name") == "kanama")

	var ts_host = ClassDB.instantiate("TextServerExtension")
	ts_host.set_script(load("res://TextServerVirtualReturnProbe.kt"))
	var v_bytes = ts_host._get_support_data()
	var v_breaks = ts_host._string_get_word_breaks("kanama-example", "en", 80)
	print("[kanama:gd] vret textserver bytes_type=", typeof(v_bytes) == TYPE_PACKED_BYTE_ARRAY,
		" bytes_vals=", v_bytes.size() == 3 and v_bytes[0] == 127 and v_bytes[1] == 0 and v_bytes[2] == 128,
		" int32_type=", typeof(v_breaks) == TYPE_PACKED_INT32_ARRAY,
		" int32_vals=", v_breaks.size() == 3 and v_breaks[0] == 0 and v_breaks[1] == 14 and v_breaks[2] == 2147483647)

	var xr_host = ClassDB.instantiate("XRInterfaceExtension")
	xr_host.set_script(load("res://XrVirtualReturnProbe.kt"))
	var v_xform = xr_host._get_camera_transform()
	var v_area = xr_host._get_play_area()
	var v_proj_view = xr_host._get_projection_for_view(0, 1.5, 0.25, 4096.0)
	print("[kanama:gd] vret xr transform3d_type=", typeof(v_xform) == TYPE_TRANSFORM3D,
		" transform3d_origin=", v_xform.origin == Vector3(7, 8, 9),
		" vector3_array_type=", typeof(v_area) == TYPE_PACKED_VECTOR3_ARRAY,
		" vector3_array_vals=", v_area.size() == 2 and v_area[0] == Vector3(1, 0, 0) and v_area[1] == Vector3(0, 0, 1),
		" float64_array_type=", typeof(v_proj_view) == TYPE_PACKED_FLOAT64_ARRAY,
		" float64_array_vals=", v_proj_view.size() == 4 and v_proj_view[0] == 1.5 and v_proj_view[3] == 1.0e308)

	var graph_host = ClassDB.instantiate("GraphEdit")
	graph_host.set_script(load("res://GraphEditVirtualReturnProbe.kt"))
	var v_line = graph_host._get_connection_line(Vector2(1, 2), Vector2(3, 4))
	print("[kanama:gd] vret graphedit vector2_array_type=", typeof(v_line) == TYPE_PACKED_VECTOR2_ARRAY,
		" vector2_array_vals=", v_line.size() == 2 and v_line[0] == Vector2(1, 2) and v_line[1] == Vector2(3, 4))
	graph_host.free()

	var body_host = ClassDB.instantiate("PhysicsDirectBodyState2DExtension")
	body_host.set_script(load("res://Body2dVirtualReturnProbe.kt"))
	var v_t2d = body_host._get_transform()
	print("[kanama:gd] vret body2d transform2d_type=", typeof(v_t2d) == TYPE_TRANSFORM2D,
		" transform2d_vals=", v_t2d.x == Vector2(1, 2) and v_t2d.y == Vector2(3, 4) and v_t2d.origin == Vector2(5, 6))
	body_host.free()

	var rsd_host = ClassDB.instantiate("RenderSceneDataExtension")
	rsd_host.set_script(load("res://RenderSceneDataVirtualReturnProbe.kt"))
	var v_proj = rsd_host._get_cam_projection()
	print("[kanama:gd] vret rendersscenedata projection_type=", typeof(v_proj) == TYPE_PROJECTION,
		" projection_vals=", v_proj.x.x == 1.0 and v_proj.y.y == 2.0 and v_proj.z.z == 3.0 and v_proj.w.w == 4.0)
	rsd_host.free()

	var rid_host = ClassDB.instantiate("Control")
	rid_host.set_script(load("res://VirtualOverrideProbe.kt"))
	var v_rid = rid_host._get_focused_accessibility_element()
	print("[kanama:gd] vret control rid_type=", typeof(v_rid) == TYPE_RID)
	rid_host.free()

func _process(_delta: float) -> void:
	if OS.get_environment("KANAMA_IN_PROCESS_HOT_RELOAD_SMOKE") != "1":
		return
	if _kanama_smoke_reload_requested:
		return

	var signal_file := OS.get_environment("KANAMA_IN_PROCESS_HOT_RELOAD_SIGNAL")
	var stage_file := OS.get_environment("KANAMA_IN_PROCESS_HOT_RELOAD_STAGE")
	if signal_file == "" or stage_file == "":
		return
	if not FileAccess.file_exists(signal_file):
		return

	if FileAccess.file_exists(stage_file):
		_kanama_smoke_reload_requested = true
		call_deferred("_kanama_hot_reload_smoke_quit")
		return

	_kanama_smoke_reload_requested = true
	var stage := FileAccess.open(stage_file, FileAccess.WRITE)
	if stage != null:
		stage.store_string("reloaded\n")
	call_deferred("_kanama_hot_reload_smoke_reload_scene")

func _kanama_hot_reload_smoke_ready() -> void:
	print("[kanama:gd] in-process hot reload smoke ready")

func _kanama_hot_reload_smoke_reload_scene() -> void:
	await get_tree().create_timer(1.5).timeout
	print("[kanama:gd] in-process hot reload smoke reload_scene")
	get_tree().reload_current_scene()

func _kanama_hot_reload_smoke_quit() -> void:
	await get_tree().create_timer(1.0).timeout
	print("[kanama:gd] in-process hot reload smoke quit")
	get_tree().quit()
