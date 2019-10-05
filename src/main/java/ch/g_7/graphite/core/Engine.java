package ch.g_7.graphite.core;

import java.util.LinkedList;
import java.util.Queue;

import ch.g_7.graphite.rendering.Dimension;

public class Engine {
	
	private static Engine instance;
	private Dimension dimension;
	private GameLoop gameLoop;
	private Window window;
	private Queue<Initializable> initializables;
	
	public Engine(Window window, Initializable gameLogic) {
		dimension = new Dimension();
		gameLoop = new GameLoop(this);
		initializables = new LinkedList<>();
		initializables.add(gameLogic);
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
