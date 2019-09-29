package ch.g_7.graphite.process;

public class ProcessIntervalBuffer<T> implements Process<T, Void>{

	private Process<T, Void> process;
	
	private long intervall;
	private long callBuffer;
	private long lastCall;
	private boolean enabled;
	
	public ProcessIntervalBuffer(Process<T, Void> process, long intervall, long callBuffer) {
		this(process, intervall);
		this.callBuffer = callBuffer;
	}
	
	public ProcessIntervalBuffer(Process<T, Void> process, long intervall) {
		this.process = process;
		this.intervall = intervall;
		enabled = true;
		resetLastCall();
	}
	

	@Override
	public Void run(T t) {
		if(enabled) {
			long actTime = System.currentTimeMillis();
			long div = actTime - lastCall;
			long missedCalls;
			if((missedCalls = div/intervall)>0) {
				for(int i = 0; i < (missedCalls+callBuffer); i++) {
					process.run(t);
				}
				lastCall = actTime - (div%intervall) + (callBuffer*intervall);
			}
		} else {
			resetLastCall();
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

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	private void resetLastCall() {
		lastCall =  System.currentTimeMillis();
	}
}
