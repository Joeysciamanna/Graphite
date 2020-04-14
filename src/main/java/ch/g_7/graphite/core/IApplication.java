package ch.g_7.graphite.core;

import ch.g_7.graphite.input.InputManager;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.graphite.plugin.IPlugin;
import ch.g_7.graphite.plugin.PluginManager;
import ch.g_7.graphite.rendering.RenderManager;

public interface IApplication {

    IWindow getWindow();

    World getWorld();

    Camera getCamera();

    InputManager getInputManager();

    PluginManager getPluginManager();

    RenderManager getRenderManager();

}
