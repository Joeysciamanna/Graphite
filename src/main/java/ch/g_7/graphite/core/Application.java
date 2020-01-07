package ch.g_7.graphite.core;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.MasterRenderer;

public abstract class Application implements Runnable {

	private static boolean exists;

	private Dimension dimension;

	private MasterRenderer masterRenderer;

	private final Window window;

	private Camera camera;

	private Thread thread;

	private boolean running;

	private Timer timer;

	public Application(String name) {
		if (exists) {
			throw new IllegalStateException("Only one Engine can exist at the same time");
		}
		this.dimension = new Dimension();
		this.window = new Window(name, 200, 200);
		this.camera = new Camera();
		this.timer = new Timer();
		this.masterRenderer = new MasterRenderer();
		exists = true;
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
			window.init();
			masterRenderer.init();
			initGame();
			timer.reset();
			while (running && !window.windowShouldClose()) {
				timer.recalculate();

				long time = System.currentTimeMillis();
				while (time + timer.getSleepTime() > System.currentTimeMillis()) {
					Thread.sleep(1);
				}

				for (int i = 0; i < timer.getUpdateCallCount() + 1; i++) {
					update();
					window.pullEvents();
				}
				window.render();
				masterRenderer.render(dimension, window, camera);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			masterRenderer.close();
			dimension.close();
			close();
		}
	}

	public void start() {
		setRunning(true);
	}

	public void stop() {
		setRunning(false);
	}

	protected void close() {
	}

	protected abstract void initGame();

	public void update() {
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

	public Timer getTimer() {
		return timer;
	}

	public MasterRenderer getMasterRenderer() {
		return masterRenderer;
	}
}
