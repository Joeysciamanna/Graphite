package ch.g_7.graphite.core;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.graphite.rendering.MasterRenderer;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;
import ch.g_7.util.logging.LogLevel;
import ch.g_7.util.logging.Logger;
import ch.g_7.util.resource.IDepender;
import ch.g_7.util.resource.ResourceManager;

public abstract class Application implements Updatable, Initializable, Closeable, Runnable, IDepender {

	private final static Logger LOGGER = Logger.getInstance();
	
	private static boolean exists;

	private MasterRenderer masterRenderer;
	private Dimension dimension;
	private final Window window;
	private Camera camera;

	private Thread thread;
	private boolean running;
	
	private UpdateLoop updateLoop;


	
	public Application(String name) {
		if (exists) {
			throw new IllegalStateException("Only one Engine can exist at the same time");
		}

		this.dimension = new Dimension();
		this.window = new Window(name);
		this.camera = new Camera();
		this.updateLoop = new UpdateLoop();
		this.masterRenderer = new MasterRenderer();
		
		updateLoop = new UpdateLoop();
		updateLoop.add(this);
		updateLoop.add(dimension);
		exists = true;
	}

	@Override
	public void run() {
		try {
			window.init(); //Could be changed to resource in future (bind)
			masterRenderer.bind(this);
			init();
			
			updateLoop.start();

			while (running && !window.windowShouldClose()) {

				window.pullEvents();
				masterRenderer.render(dimension, window, camera);
				Thread.sleep(1);
			}
		} catch (Exception e) {
			LOGGER.log(LogLevel.FATAL, "Engine Crashed", e);
		} finally {
			updateLoop.stop();
			masterRenderer.unbind(this);
			dimension.close(); //Could be changed to resource in future (unbind)
			close();
		}
	}
	
	private final void setRunning(boolean running) {
		if (running && !this.running) {
			this.running = true;
			thread = new Thread(this);
			thread.start();
		} else if (!running && this.running) {
			this.running = false;
			thread = null;
		}
	}
	
	
	public void start() {
		setRunning(true);
	}

	public void stop() {
		setRunning(false);
	}
	
	public void close() {
		if(ResourceManager.getInstance().hasUnclosedResources()) {
			LOGGER.log(LogLevel.WARNING, "Unclosed Resources\n:"+ ResourceManager.getInstance().getUnclosedResources());
		}
		terminate();
	}
	
	public void terminate() {
		System.exit(0);
	}

	@Override
	public void update(float deltaMillis) {}
	
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
	
	public UpdateLoop getUpdateLoop() {
		return updateLoop;
	}
	
	public MasterRenderer getMasterRenderer() {
		return masterRenderer;
	}
	

}
