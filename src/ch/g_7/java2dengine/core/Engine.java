package ch.g_7.java2dengine.core;

import ch.g_7.java2dengine.physics.Physics;

public class Engine {
	
	private Dimension dimension;
	private GameLoop gameLoop;
	private Window window;
	private Physics physics;
	private GameLogic gameLogic;
	
	public Engine(Window window,GameLogic gameLogic) {
		dimension = new Dimension();
		gameLoop = new GameLoop(this);
		physics = new Physics();
		this.window = window;
		this.gameLogic = gameLogic;
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
		gameLogic.init(this);
		physics.init(this);
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
	
	public Physics getPhysics() {
		return physics;
	}
	
}
