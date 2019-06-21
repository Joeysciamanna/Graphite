package ch.g_7.javaengine2d.core;

import ch.g_7.javaengine2d.process.Process;
import ch.g_7.javaengine2d.process.ProcessIntervalBuffer;
import ch.g_7.javaengine2d.process.ProcessListIntervall;
import ch.g_7.javaengine2d.process.ProcessQueue;

public class GameLoop implements Runnable{

	private GameEngine engine;
	private ProcessQueue<GameEngine, Void> processQueue;
	private ProcessListIntervall<GameEngine> processIntervallList;
	private boolean running = true;
	
	public GameLoop(GameEngine engine) {
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
    

	public void addProcess(Process<GameEngine, Void> process) {
    	processQueue.add(process);
    }

    public void addProcessInterval(Process<GameEngine, Void> process, long interval) {
    	processIntervallList.add(new ProcessIntervalBuffer<>(process, interval));
    }
    
    public void addProcessInterval(Process<GameEngine, Void> process, long interval, long callBuffer) {
    	processIntervallList.add(new ProcessIntervalBuffer<>(process, interval, callBuffer));
    }
    
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public boolean isRunning() {
		return running;
	}


}
