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
		timer.reset();
		float deltaMillis;
		while (running) {
			timer.calculateDelta();
			deltaMillis = timer.getDeltaMillis();
			run(deltaMillis);
		}
	}
	
	public abstract void run(float deltaMillis);
	
	public final void setRunning(boolean running) {
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
