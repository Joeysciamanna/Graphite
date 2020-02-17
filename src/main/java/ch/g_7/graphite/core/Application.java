package ch.g_7.graphite.core;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.graphite.rendering.MasterRenderer;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;
import ch.g_7.util.logging.Logger;
import ch.g_7.util.loop.Loop;

public abstract class Application extends Loop implements Updatable, Initializable, Closeable, Runnable {

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
        window.init();
        masterRenderer.init();
        init();
    }


    @Override
    protected void onStop() {
        masterRenderer.close();
        dimension.close();
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

}
