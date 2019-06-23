package ch.g_7.java2dengine.process;

import java.util.ArrayList;
import java.util.List;

public class ProcessListIntervall<T> implements Process<T, Void>, Runnable{

	private ArrayList<ProcessIntervalBuffer<T>> intervalBuffers;
	private T input;
	
	private long minInterval;
	private boolean canceled;
	private boolean paused;
	
	public ProcessListIntervall(ArrayList<ProcessIntervalBuffer<T>> intervalBuffers) {
		this();
		intervalBuffers.forEach((c)->add(c));
	}
	
	public ProcessListIntervall() {
		this.intervalBuffers = new ArrayList<ProcessIntervalBuffer<T>>();
	}
	
	@Override
	public Void run(T t) {
		input = t;
		canceled = false;
		paused = false;
		Thread thread = new Thread(this);
		thread.start();
		return null;
	}

	@Override
	public void run() {
		while (!canceled) {
			if(!paused) {
				for (ProcessIntervalBuffer<T> intervalBuffer : intervalBuffers) {
					intervalBuffer.run(input);
				}
				try {
					Thread.sleep(minInterval);
				} catch (InterruptedException e) {}
			}
		}
	}
	
	public void add(ProcessIntervalBuffer<T> intervalBuffer) {
		intervalBuffers.add(intervalBuffer);
		if(minInterval>intervalBuffer.getIntervall()) {
			minInterval = intervalBuffer.getIntervall();
		}
	}
	
	public boolean isPaused() {
		return paused;
	}
	
	public boolean isCanceled() {
		return canceled;
	}
	
	public void setPaused(boolean paused) {
		this.paused = paused;
	}
	
	public void canceled() {
		this.canceled = true;
	}

}
