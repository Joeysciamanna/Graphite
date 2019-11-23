package ch.g_7.graphite.core;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.Dimension;

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
	
	public void start() {
		setRunning(true);
	}
	
	public void stop() {
		setRunning(false);
	}

	@Override
	public final void run() {
		try {
			init();
			window.init();
			
			initGame();
			while (running && !window.windowShouldClose()) {
				
				dimension.render(window, camera);
				window.update();
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
