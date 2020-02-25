package ch.g_7.graphite.core;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.graphite.rendering.MasterRenderer;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;

public abstract class Application extends TaskLoop implements Updatable, Initializable, Closeable, Runnable {

    protected final MasterRenderer masterRenderer;
    protected final Dimension dimension;
    protected final Window window;
    protected final Camera camera;

    protected final TaskLoop updateLoop;

    
    public Application(String name) {
        this.dimension = new Dimension();
        this.window = new Window(name);
        this.camera = new Camera();
        this.masterRenderer = new MasterRenderer();
        
        this.updateLoop = new TaskLoop();
    }

    @Override
    protected void onStart() {
        window.init();
        masterRenderer.init();
        initUpdateLoop();
        init();
        updateLoop.start();
    }

    private void initUpdateLoop() {
    	updateLoop.addUpdatable(this::update);
    	updateLoop.addUpdatable(dimension::update);
    }
    
    @Override
    protected void onStop() {
        masterRenderer.close();
        dimension.close();
        close();
        updateLoop.stop();
    }

    @Override
    protected void run(float deltaMillis) {
        super.run(deltaMillis);
        window.pullEvents();
        masterRenderer.render(dimension, window, camera);

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

    public Dimension getDimension() {
        return dimension;
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
