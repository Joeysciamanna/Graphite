package ch.g_7.graphite.test.draw;

import ch.g_7.graphite.entity.Entity;
import ch.g_7.graphite.ui.scene.ISceneIdentifier;
import ch.g_7.graphite.ui.scene.Scene;
import ch.g_7.graphite.ui.scene.SceneNavigator;
import org.lwjgl.glfw.GLFW;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.rendering.RenderType;
import ch.g_7.util.helper.AppInitializer;
import ch.g_7.util.resource.ResourceManager;

public class DrawTestApp extends Application {

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
		
		SquareObject object1 = new SquareObject();
		getDimension().addObj(object1, RenderType.DRAWABLE);

		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public void update(float deltaMillis) {
	    if(getWindow().isKeyPressed(GLFW.GLFW_KEY_R)) {
        	System.out.println("Used resources:      " + ResourceManager.getInstance().getCurrentResourceCount());
        	System.out.println("Allocated resources: " + ResourceManager.getInstance().getCurrentResourceAllocations());
        }
	    if(getWindow().isKeyPressed(GLFW.GLFW_KEY_F)) {
        	System.out.println("FPS: " + getTimer().getLPS());
        }
	}


}
