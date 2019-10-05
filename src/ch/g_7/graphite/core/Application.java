package ch.g_7.graphite.core;

import java.util.List;

import ch.g_7.graphite.base.object.Camera;
import ch.g_7.graphite.rendering.Dimension;
import ch.g_7.util.process.TaskQueue;

public abstract class Application implements Runnable {

	private final Dimension dimension;

	private final Window window;

	private Camera camera;

	private Thread thread;

	private TaskQueue<Application, Void> taskQueue;
	
	
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
			window.init(engine);
			init();
			while (running && !window.windowShouldClose()) {
				dimension.render(window, camera);
				window.update();
				taskQueue.run(this);
			}

		} catch (Exception excp) {
			excp.printStackTrace();
		} finally {
			close();
		}
	}
	
	public final void addSingleExecutionTask(Task<Application, Void> task) {
		taskQueue.add(task);
	}
	
	
	protected void close(){}

	protected abstract void init();
}
