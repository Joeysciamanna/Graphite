package ch.g_7.java2dengine.process;

import java.util.ArrayList;
import java.util.List;

public class ProcessIntervallBufferList<T> implements Process<T, Void>{

	private List<ProcessIntervalBuffer<T>> intervalBuffers;
	
	private boolean paused;
	
	public ProcessIntervallBufferList(ArrayList<ProcessIntervalBuffer<T>> intervalBuffers) {
		this();
		this.intervalBuffers.addAll(intervalBuffers);
	}
	
	public ProcessIntervallBufferList() {
		this.intervalBuffers = new ArrayList<ProcessIntervalBuffer<T>>();
		this.paused = false;
	}
	
	
	public void runAsync(T t) {
		new AsyncProcess<T, Void>(new Process<T, Void>() {
			@Override
			public Void run(T t) {
				if(!paused) {
					for (ProcessIntervalBuffer<T> intervalBuffer : intervalBuffers) {
						intervalBuffer.run(t);
					}
				}
				return null;
			}
		}).run(t);
	}

	@Override
	public Void run(T t) {
		if(!paused) {
			for (ProcessIntervalBuffer<T> intervalBuffer : intervalBuffers) {
				intervalBuffer.run(t);
			}
		}
		return null;
	}
	
	public void add(ProcessIntervalBuffer<T> intervalBuffer) {
		intervalBuffers.add(intervalBuffer);
	}
	
	public boolean isPaused() {
		return paused;
	}
	
	public void setPaused(boolean paused) {
		this.paused = paused;
	}

}
