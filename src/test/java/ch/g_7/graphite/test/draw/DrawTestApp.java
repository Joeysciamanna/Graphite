package ch.g_7.graphite.test.draw;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.rendering.RenderType;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.util.helper.AppInitializer;
import org.lwjgl.glfw.GLFW;

/*public class DrawTestApp extends Application {

	public DrawTestApp() {
		super("Draw App Name");
	}
	
	public static void main(String[] args) {
		new DrawTestApp().start();
	}

	@Override
	public void init() {
		AppInitializer appInitializer = new AppInitializer(true, "Draw Test", new Object() {});
		appInitializer.addConsoleLoggers();


		int maxX = 16;
		int tileSize = 32;
		for (int i = 0; i < 100; i++) {
			SquareObject object1 = new SquareObject((i % maxX)*32,(i / maxX)*32);
			getDimension().addObj(object1, RenderType.DRAWABLE);
		}


		getWindow().setVisible(true);
		getWindow().setSize(500, 500);

		getTimer().setLpsSmoothing(0);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public void update(float deltaMillis) {
	    if(getWindow().isKeyPressed(GLFW.GLFW_KEY_R)) {
        	System.out.println("Used resources:      " + ResourceManager.getInstance().getCurrentResourceCount());
        	System.out.println("Allocated resources: " + ResourceManager.getInstance().getCurrentResourceAllocations());
        }
		if(getWindow().isKeyPressed(GLFW.GLFW_KEY_F)) {
			System.out.println("FPS:      " + getTimer().getLPS());
			System.out.println("Delta:    " + deltaMillis);
			System.out.println("FPS Calc: " + 1000/deltaMillis);
		}
		if(getWindow().isKeyPressed(GLFW.GLFW_KEY_A)) {
			getCamera().getPosition().x++;
		}
		if(getWindow().isKeyPressed(GLFW.GLFW_KEY_D)) {
			getCamera().getPosition().x--;
		}

	}


}*/
