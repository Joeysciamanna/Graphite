package ch.g_7.java2dengine.core;

import java.util.LinkedList;
import java.util.Queue;

public class Engine {
	
	private Dimension dimension;
	private GameLoop gameLoop;
	private Window window;
	private Queue<Initializable> initializables;
	
	public Engine(Window window, Initializable gameLogic) {
		dimension = new Dimension();
		gameLoop = new GameLoop(this);
		initializables = new LinkedList<>();
		initializables.add(gameLogic);
		this.window = window;
	}
	
    public void start() {
        String osName = System.getProperty("os.name");
        if ( osName.contains("Mac") ) {
        	gameLoop.run();
        } else {
        	new Thread(gameLoop).start();
        }
    }
    
    public void init() {
    	window.init(this);
		window.getCamera().getRenderer().init(this);
		while (!initializables.isEmpty()) {
			initializables.poll().init(this);
		}
    }
    
    public void stop() {
    	gameLoop.setRunning(false);
    }
    
    public void close() {
    	
    }
    
    public Window getWindow() {
		return window;
	}
    
    public void setWindow(Window window) {
		this.window = window;
	}
	
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
	public Dimension getDimension() {
		return dimension;
	}
	
	public GameLoop getGameLoop() {
		return gameLoop;
	}
	
}
