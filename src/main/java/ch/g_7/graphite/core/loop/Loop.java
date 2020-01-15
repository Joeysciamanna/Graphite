package ch.g_7.graphite.core.loop;

import ch.g_7.graphite.core.Timer;

public abstract class Loop implements Runnable {

	private Thread thread;
	private Timer timer;
	private boolean running;

	public Loop() {
		this.timer = new Timer();
	}
	
	@Override
	public final void run() {
		onStart();
		timer.reset();
		float deltaMillis;
		while (running) {
			timer.calculate();
			deltaMillis = timer.getDeltaMillis();
			run(deltaMillis);
		}
		onClose();
	}
	
	public abstract void run(float deltaMillis);
	
	public void onStart() {}
	public void onClose() {}
	
	protected final void setRunning(boolean running) {
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

	public Timer getTimer() {
		return timer;
	}
	
	
}
