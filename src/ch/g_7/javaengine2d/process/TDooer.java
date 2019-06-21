package ch.g_7.javaengine2d.process;

public class TDooer<T> implements Runnable{

	protected T obj;
	protected Processor<T> processor;
	protected boolean running = false;
	protected long sleepTime;
	
	public TDooer(T obj, Processor<T> processor, long sleepTime) {
		this.obj = obj;
		this.processor = processor;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		
		while (running) {
			processor.process(obj);
			Thread.sleep(sleepTime);
		}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		running = true;
		Thread t = new Thread(this);
		t.start();
	}
	
	
	public void stop() {
		running = false;
	}
	
}
