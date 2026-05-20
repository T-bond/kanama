package org.godotengine.godot.plugin;

import org.godotengine.godot.Godot;

import java.util.Collections;
import java.util.Set;

public abstract class GodotPlugin {
    protected GodotPlugin(Godot godot) {
    }

    public abstract String getPluginName();

    public Set<String> getPluginGDExtensionLibrariesPaths() {
        return Collections.emptySet();
    }
}

