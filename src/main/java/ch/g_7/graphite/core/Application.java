package ch.g_7.graphite.core;

import ch.g_7.graphite.base.text.GlyphFactoryProducer;
import ch.g_7.graphite.core.loop.UpdateLoop;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.Updatable;
import ch.g_7.graphite.rendering.MasterRenderer;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;
import ch.g_7.util.logging.LogLevel;
import ch.g_7.util.logging.Logger;
import ch.g_7.util.resource.ResourceHandler;

public abstract class Application implements Updatable, Initializable, Closeable, Runnable {

	private final static Logger LOGGER = Logger.getInstance();
	
	private static boolean exists;

	private MasterRenderer masterRenderer;
	private Dimension dimension;
	private final Window window;
	private Camera camera;

	private Timer timer;
	private Thread thread;
	private boolean running;
	
	private UpdateLoop updateLoop;


	
	public Application(String name) {
		if (exists) {
			throw new IllegalStateException("Only one Engine can exist at the same time");
		}

		this.dimension = new Dimension();
		this.window = new Window(name, 200, 200);
		this.camera = new Camera();
		this.updateLoop = new UpdateLoop();
		this.masterRenderer = new MasterRenderer();
		this.timer = new Timer();
		
		updateLoop = new UpdateLoop();
		updateLoop.add(this);
		
		exists = true;
	}

	@Override
	public void run() {
		try {
			window.init();
			masterRenderer.init();
			init();
			updateLoop.start();
			timer.reset();
			while (running && !window.windowShouldClose()) {
				timer.calculate();
				window.update();
				window.pullEvents();
				
				update(timer.getDeltaMillis());
				
				

				masterRenderer.render(dimension, window, camera);
			}
		} catch (Exception e) {
			LOGGER.log(LogLevel.FATAL, "Engine Crashed", e);
		} finally {
			updateLoop.stop();
			masterRenderer.close();
			dimension.close();
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
		if(ResourceHandler.hasUnclosedResources()) {
			LOGGER.log(LogLevel.WARNING, ResourceHandler.getUnclosedResourcesTable());
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
	
	public Timer getTimer() {
		return timer;
	}
	
}
