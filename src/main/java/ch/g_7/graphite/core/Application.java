package ch.g_7.graphite.core;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;

import java.awt.*;

public abstract class Application extends TaskLoop implements Updatable, Initializable, Closeable, Runnable {

    protected final World world;
    protected final Window window;
    protected final Camera camera;

    protected final TaskLoop updateLoop;


    public Application(String name) {
        this.world = new World();
        this.window = new Window(name);
        this.camera = new Camera();

        this.updateLoop = new TaskLoop();
    }

    @Override
    protected void onStart() {
        window.init();
        world.init();
        initUpdateLoop();
        init();
        updateLoop.start();
    }

    private void initUpdateLoop() {
    	updateLoop.addUpdatable(this);
    }

    @Override
    protected void onStop() {
        world.close();
        close();
        updateLoop.stop();
    }

    @Override
    protected void run(float deltaMillis) {
        super.run(deltaMillis);
        window.pullEvents();
        world.getRenderManager().render(window, camera);
        if (window.windowShouldClose()) {
            stop();
        }
    }

	@Override
	public void update(float deltaMillis) { }

    public void close() {
    	ResourceManager.closeAll();
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

    public Window getWindow() {
        return window;
    }

}
