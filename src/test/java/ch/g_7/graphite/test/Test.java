package ch.g_7.graphite.test;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.core.glfw.GLFWWindow;
import ch.g_7.graphite.entity.GameObject;
import ch.g_7.graphite.entity.EntityKey;
import ch.g_7.graphite.rendering.BasicViewModel;
import ch.g_7.graphite.rendering.entity.EntityRenderer;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.util.helper.AppInitializer;
import ch.g_7.util.io.LocalFileLoader;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

public class Test extends Application {

    public Test(String name) {
        super(name);
    }

    public static void main(String[] args) {
        AppInitializer appInitializer = new AppInitializer(true,"RotateCube Test", new LocalFileLoader() {});
        appInitializer.addConsoleLoggers();

        new Test("test").start();
    }


    @Override
    public void init() {
        getWorld().getRenderManager().register(new EntityRenderer());
      

        GameObject<BasicViewModel> entity = ResourceManager.getActive().allocateFromEngine(new EntityKey("obj/cube.obj"));
		entity.getTransform().setScale(new Vector3f(0.1f,0.1f,0.1f));
		entity.getTransform().setTranslation(new Vector3f(0, 0, -0.5f));
        getWorld().addEntity(entity);

        getWindow().setVisible(true);
        getWindow().setSize(500, 500);


    }

	@Override
	@SuppressWarnings("deprecation")
    public void update(float deltaMillis) {
        if(((GLFWWindow)getWindow()).isKeyPressed(GLFW.GLFW_KEY_F)) {
            System.out.println("RENDER FPS:      " + getTimer().getLPS());
            System.out.println("UPDATE FPS:      " + updateLoop.getTimer().getLPS());
            System.out.println("Update Delta:    " + deltaMillis);
            System.out.println("Update FPS Calc: " + 1000/deltaMillis);
        }

    }



}
