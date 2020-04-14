package ch.g_7.graphite.core;

import ch.g_7.graphite.core.glfw.GLFWWindow;
import ch.g_7.graphite.input.InputManager;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.graphite.plugin.IPlugin;
import ch.g_7.graphite.plugin.PluginManager;
import ch.g_7.graphite.rendering.RenderManager;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;

import java.util.ArrayList;
import java.util.List;


public abstract class Application extends TaskLoop implements IApplication, Updatable, Initializable, Closeable, Runnable {

    private final InputManager inputManager;
    private final PluginManager pluginManager;
    private final World world;
    private final IWindow window;
    private final Camera camera;
    private final TaskLoop updateLoop;


    public Application(String name) {
        this.inputManager = new InputManager();
        this.pluginManager = new PluginManager(this);
        this.world = new World();
        this.window = new GLFWWindow(inputManager, name);
        this.camera = new Camera();
        this.updateLoop = new TaskLoop();
    }



    @Override
    protected void run(float deltaMillis) {
        super.run(deltaMillis);
        window.update(deltaMillis);
        world.getRenderManager().render(window, camera);
        if (window.shouldClose()) {
            stop();
        }
    }

    @Override
    protected final void onStart() {
        window.init();
        world.init();
        init();
        updateLoop.addUpdatable(this);
        updateLoop.addUpdatable((d)->world.forEachEntity((e)->e.update(d)));
        updateLoop.start();
    }

    @Override
    protected final void onStop() {
        world.close();
        updateLoop.stop();
        ResourceManager.closeAll();
        close();
    }

	@Override
	public void update(float deltaMillis) { }

    public void close() {
        terminate();
    }

    public void terminate() {
        System.exit(0);
    }

    public World getWorld() {
        return world;
    }

    public Camera getCamera() {
        return camera;
    }

    public IWindow getWindow() {
        return window;
    }

    @Override
    public InputManager getInputManager() {
        return inputManager;
    }

    @Override
    public RenderManager getRenderManager() {
        return getWorld().getRenderManager();
    }

    @Override
    public PluginManager getPluginManager() {
        return pluginManager;
    }
}
