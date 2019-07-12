package ch.g_7.java2dengine.process;

import sun.launcher.resources.launcher_zh_TW;

public class ProcessIntervalBuffer<T> implements Process<T, Void>{

	private Process<T, Void> process;
	
	private long intervall;
	private long callBuffer;
	private long lastCall;
	
	
	public ProcessIntervalBuffer(Process<T, Void> process, long intervall, long callBuffer) {
		this(process, intervall);
		this.callBuffer = callBuffer;
	}
	
	public ProcessIntervalBuffer(Process<T, Void> process, long intervall) {
		this.process = process;
		this.intervall = intervall;
		this.callBuffer = 20;
		resetLasCall();
	}
	

	@Override
	public Void run(T t) {
		long actTime = System.currentTimeMillis();
		long div = actTime - lastCall;
		long missedCalls;
		if((missedCalls = div/intervall)>0) {
			for(int i = 0; i < (missedCalls+callBuffer); i++) {
				process.run(t);
			}
			lastCall = actTime - (div%intervall) + (callBuffer*intervall);
		}
		return null;
	}

	public long getIntervall() {
		return intervall;
	}
	
	public long getCallBuffer() {
		return callBuffer;
	}
	
	public long getLastCall() {
		return lastCall;
	}
	
	public void setIntervall(long intervall) {
		this.intervall = intervall;
	}
	
	public void setCallBuffer(long callBuffer) {
		this.callBuffer = callBuffer;
	}

	private void resetLasCall() {
		lastCall =  System.currentTimeMillis();
	}
}
