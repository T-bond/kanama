package net.multigesture.kanama.android;

import org.godotengine.godot.Godot;
import org.godotengine.godot.plugin.GodotPlugin;

import java.util.Collections;
import java.util.Set;

public final class KanamaAndroidPlugin extends GodotPlugin {
    private static final Set<String> GDEXTENSIONS =
            Collections.singleton("res://addons/kanama/kanama.gdextension");

    public KanamaAndroidPlugin(Godot godot) {
        super(godot);
        KanamaAndroidBootstrap.ensureLoaded();
    }

    @Override
    public String getPluginName() {
        return "KanamaAndroid";
    }

    @Override
    public Set<String> getPluginGDExtensionLibrariesPaths() {
        return GDEXTENSIONS;
    }
}
