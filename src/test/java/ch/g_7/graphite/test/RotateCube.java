package ch.g_7.graphite.test;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.entity.GameObject;
import ch.g_7.graphite.entity.EntityKey;
import ch.g_7.graphite.rendering.BasicViewModel;
import ch.g_7.graphite.rendering.entity.EntityRenderer;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.util.helper.AppInitializer;
import ch.g_7.util.io.LocalFileLoader;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

public class RotateCube extends Application {

    public RotateCube(String name) {
        super(name);
    }

    public static void main(String[] args) {
        AppInitializer appInitializer = new AppInitializer(true,"RotateCube Test", new LocalFileLoader() {});
        appInitializer.addConsoleLoggers();

        RotateCube rotateCube = new RotateCube("Rotate Cube Test");
        rotateCube.start();
    }

    GameObject<BasicViewModel> entity;

    @Override
    public void init() {
        entity = ResourceManager.getActive().allocateFromEngine(new EntityKey("obj/icosphere.obj"));
        entity.getTransform().setScale(new Vector3f(0.1f,0.1f,0.1f));
        entity.getTransform().setTranslation(new Vector3f(0, 0, -0.5f));
        getWorld().addNode(entity);

        getWindow().setVisible(true);
        getWindow().setSize(500, 500);

        getTimer().setLpsSmoothing(0);

    }

	@Override
	@SuppressWarnings("deprecation")
    public void update(float deltaMillis) {

		if (getWindow().isKeyPressed(GLFW.GLFW_KEY_W))
		    rotateByDegrees(new Vector3f(-0.05f * deltaMillis, 0, 0));

        if (getWindow().isKeyPressed(GLFW.GLFW_KEY_S))
            rotateByDegrees(new Vector3f(0.05f * deltaMillis, 0, 0));

        if (getWindow().isKeyPressed(GLFW.GLFW_KEY_A))
            rotateByDegrees(new Vector3f(0, -0.05f * deltaMillis, 0));

        if (getWindow().isKeyPressed(GLFW.GLFW_KEY_D))
            rotateByDegrees(new Vector3f(0, 0.05f * deltaMillis, 0));

        if (getWindow().isKeyPressed(GLFW.GLFW_KEY_Q))
            rotateByDegrees(new Vector3f(0, 0,-0.05f * deltaMillis));

        if (getWindow().isKeyPressed(GLFW.GLFW_KEY_E))
            rotateByDegrees(new Vector3f(0, 0,0.05f * deltaMillis));

        if (getWindow().isKeyPressed(GLFW.GLFW_KEY_I))
            entity.getTransform().getRotation().set(0,0,0);


        if(getWindow().isKeyPressed(GLFW.GLFW_KEY_F)) {
            System.out.println("RENDER FPS:      " + getTimer().getLPS());
            System.out.println("UPDATE FPS:      " + updateLoop.getTimer().getLPS());
            System.out.println("Update Delta:    " + deltaMillis);
            System.out.println("Update FPS Calc: " + 1000/deltaMillis);
        }

    }

    public void rotateByDegrees(Vector3f vector3f){
        Vector3f rotation = entity.getTransform().getRotation();
        rotation.set((float)Math.toRadians((Math.toDegrees(rotation.x) + vector3f.x) % 360),
                     (float)Math.toRadians((Math.toDegrees(rotation.y) + vector3f.y) % 360),
                     (float)Math.toRadians((Math.toDegrees(rotation.z) + vector3f.z) % 360));
    }


}
