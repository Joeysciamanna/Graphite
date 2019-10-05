package ch.g_7.graphite.core;

import ch.g_7.graphite.base.object.Camera;
import ch.g_7.graphite.rendering.Dimension;

public abstract class Application implements Runnable {

	private final Dimension dimension;

	private final Window window;

	private Camera camera;

	private Thread thread;

	private boolean running;
	

	public Application(String name) {
		this.dimension = new Dimension();
		this.window = new Window(name, 200, 200);
	}

	public final void setRunning(boolean running) {
		if (running && !this.running) {
			String osName = System.getProperty("os.name");
			if (osName.contains("Mac")) {
				run();
			} else {
				thread = new Thread(this);
				thread.start();
			}
		} else if (!running && this.running) {
			running = false;
			thread = null;
		}

	}

	@Override
	public final void run() {
		try {
			window.init();
			init();
			while (running && !window.windowShouldClose()) {
				dimension.render(window, camera);
				window.update();
			}

		} catch (Exception excp) {
			excp.printStackTrace();
		} finally {
			close();
		}
	}
	
	protected void close(){}

	protected abstract void init();
}
