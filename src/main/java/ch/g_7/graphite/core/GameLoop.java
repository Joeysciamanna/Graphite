package ch.g_7.graphite.core;

import ch.g_7.graphite.process.Process;
import ch.g_7.graphite.process.ProcessIntervalBuffer;
import ch.g_7.graphite.process.ProcessIntervallBufferList;
import ch.g_7.graphite.process.ProcessQueue;

public class GameLoop implements Runnable{

	private Engine engine;
	private ProcessQueue<Engine, Void> processQueue;
	private ProcessIntervallBufferList<Engine> intervallBufferList;
	private boolean running = true;
	
	public GameLoop(Engine engine) {
		processQueue = new ProcessQueue<>();
		intervallBufferList = new ProcessIntervallBufferList<>();
		this.engine = engine;
	}
	
    @Override
    public void run() {
        try {
        	engine.init();
        	
            while (running && !engine.getWindow().windowShouldClose()) {
            	engine.getWindow().getCamera().getRenderer().render(engine.getWindow(), engine.getWindow().getCamera(), engine.getDimension());
            	engine.getWindow().update();
                processQueue.runAsync(engine);
                intervallBufferList.runAsync(engine);
            }

        } catch (Exception excp) {
            excp.printStackTrace();
        } finally {
            engine.close();
        }
    }
    

	public void addProcess(Process<Engine, Void> process) {
    	processQueue.add(process);
    }

    public void addProcessInterval(ProcessIntervalBuffer<Engine> process) {
    	intervallBufferList.add(process);
    }
    
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public boolean isRunning() {
		return running;
	}


}
