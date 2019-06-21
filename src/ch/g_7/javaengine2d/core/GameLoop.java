package ch.g_7.javaengine2d.core;

public class GameLoop implements Runnable{

	private GameEngine engine;
	private boolean running = true;
	
	public GameLoop(GameEngine engine) {
		this.engine = engine;
	}
	
    @Override
    public void run() {
        try {
        	engine.init();
        	

            while (running && !engine.getWindow().windowShouldClose()) {
            	
            	engine.getWindow().getCamera().getRenderer().render(engine.getWindow(), engine.getWindow().getCamera(), engine.getDimension());
            	engine.getWindow().update();
            }
        } catch (Exception excp) {
            excp.printStackTrace();
        } finally {
            engine.close();
        }
    }
    


	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public boolean isRunning() {
		return running;
	}


}
