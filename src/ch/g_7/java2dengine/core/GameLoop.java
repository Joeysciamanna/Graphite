package ch.g_7.java2dengine.core;

import ch.g_7.java2dengine.process.Process;
import ch.g_7.java2dengine.process.ProcessIntervalBuffer;
import ch.g_7.java2dengine.process.ProcessListIntervall;
import ch.g_7.java2dengine.process.ProcessQueue;

public class GameLoop implements Runnable{

	private Engine engine;
	private ProcessQueue<Engine, Void> processQueue;
	private ProcessListIntervall<Engine> processIntervallList;
	private boolean running = true;
	
	public GameLoop(Engine engine) {
		processQueue = new ProcessQueue<>();
		processIntervallList = new ProcessListIntervall<>();
		this.engine = engine;
	}
	
    @Override
    public void run() {
        try {
        	engine.init();
        	processIntervallList.run(engine);
            while (running && !engine.getWindow().windowShouldClose()) {
            	
            	engine.getWindow().getCamera().getRenderer().render(engine.getWindow(), engine.getWindow().getCamera(), engine.getDimension());
            	engine.getWindow().update();
                processQueue.runAsync(engine);
               
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
    	processIntervallList.add(process);
    }
    
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public boolean isRunning() {
		return running;
	}


}
