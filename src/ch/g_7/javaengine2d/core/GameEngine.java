package ch.g_7.javaengine2d.core;

public class GameEngine {
	
	private Dimension dimension;
	private GameLoop gameLoop;
	private Window window;
	private GameLogic gameLogic;
	
	public GameEngine(Window window,GameLogic gameLogic) {
		dimension = new Dimension();
		gameLoop = new GameLoop(this);
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
    	window.init();
		window.getCamera().getRenderer().init();
		
		gameLogic.init();
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
