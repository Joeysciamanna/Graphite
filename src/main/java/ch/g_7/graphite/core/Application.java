package ch.g_7.graphite.core;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.graphite.rendering.MasterRenderer;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;
import ch.g_7.util.logging.LogLevel;
import ch.g_7.util.logging.Logger;
import ch.g_7.util.loop.Loop;
import ch.g_7.util.loop.Timer;
import ch.g_7.util.resource.IDepender;
import ch.g_7.util.resource.ResourceManager;

import java.util.ArrayList;
import java.util.List;

public abstract class Application extends Loop implements Updatable, Initializable, Closeable, Runnable {

    private final static Logger LOGGER = Logger.getInstance();

    private static boolean exists;

    private MasterRenderer masterRenderer;
    private Dimension dimension;
    private final Window window;
    private Camera camera;


    public Application(String name) {
        if (exists) {
            throw new IllegalStateException("Only one Engine can exist at the same time");
        }

        this.dimension = new Dimension();
        this.window = new Window(name);
        this.camera = new Camera();
        this.masterRenderer = new MasterRenderer();
        exists = true;
    }


    @Override
    protected void onStart() {
        window.init(); //Could be changed to resource in future (bind)
        masterRenderer.bind(this);
        init();
    }


    @Override
    protected void onStop() {
        masterRenderer.unbind(this);
        dimension.close(); // Could be changed to resource in future (unbind)
        close();
    }

    @Override
    protected void run(float deltaMillis) {
        window.pullEvents();
        masterRenderer.render(dimension, window, camera);

        update(deltaMillis);
        dimension.update(deltaMillis);

        if (window.windowShouldClose()) {
            stop();
        }
    }

	@Override
	public void update(float deltaMillis) { }

    public void close() {
        if (ResourceManager.getInstance().hasUnclosedResources()) {
            LOGGER.log(LogLevel.WARNING, "Unclosed Resources\n:" + ResourceManager.getInstance().getUnclosedResources());
        }
        terminate();
    }

    public void terminate() {
        System.exit(0);
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Camera getCamera() {
        return camera;
    }

    public Window getWindow() {
        return window;
    }

    public MasterRenderer getMasterRenderer() {
        return masterRenderer;
    }

    @Override
    public int getResourceId() {
        return resourceId;
    }
}
