package ch.g_7.graphite.core;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.Dimension;
import ch.g_7.util.task.TaskList;
import ch.g_7.util.task.TaskQueue;

public abstract class Application implements Runnable {

	private static boolean exists;
	
	private Dimension dimension;

	private final Window window;

	private Camera camera;

	private Thread thread;

	private boolean running;
	
	
	public Application(String name) {
		this.dimension = new Dimension();
		this.window = new Window(name, 200, 200);
		this.camera = new Camera();
	}

	public final void setRunning(boolean running) {
		if (running && !this.running) {
			this.running = true;
//			String osName = System.getProperty("os.name");
//			if (osName.contains("Mac")) {
//				run();
//			} else {
				thread = new Thread(this);
				thread.start();
//			}
		} else if (!running && this.running) {
			this.running = false;
			thread = null;
		}

	}
	
	@Override
	public final void run() {
		try {
			init();
			window.init();
			
			initGame();
			while (running && !window.windowShouldClose()) {
				window.update();
				dimension.render(window, camera);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dimension.close();
			close();
		}
	}
	
	protected void init() {
		if(exists) {
			throw new IllegalStateException("Only one Engine can exist at the same time");
		}
		exists = true;
	}
	
	
	public void start() {
		setRunning(true);
	}
	
	public void stop() {
		setRunning(false);
	}
	
	protected void close(){}

	protected abstract void initGame();
	
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
	
	
}
