package ch.g_7.java2dengine.core;

import java.util.LinkedList;
import java.util.Queue;

public class Engine {
	
	private static Engine instance;
	private Dimension dimension;
	private GameLoop gameLoop;
	private Window window;
	private GameLogic gameLogic;
	
	public Engine(Window window, GameLogic gameLogic) {
		dimension = new Dimension();
		gameLoop = new GameLoop(this);
		this.gameLogic = gameLogic;
		instance = this;
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
    	window.init();
		window.getCamera().getRenderer().init();
		gameLogic.init(this);
    }
    
    public void stop() {
    	gameLoop.setRunning(false);
    }
    
    public void close() {
    	gameLogic.close();
    	
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
	
	public static Engine getInstance() {
		return instance;
	}
	
}
