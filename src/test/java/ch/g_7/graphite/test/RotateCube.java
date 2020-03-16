package ch.g_7.graphite.test;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.entity.Entity;
import ch.g_7.graphite.entity.EntityKey;
import ch.g_7.graphite.rendering.RenderType;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.util.helper.AppInitializer;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

public class RotateCube extends Application {

    private static RotateCube rotateCube;

    public RotateCube(String name) {
        super(name);
    }

    public static void main(String[] args) {
        AppInitializer appInitializer = new AppInitializer(true,"RotateCube Test", new Object() {});
        appInitializer.addConsoleLoggers();

        rotateCube = new RotateCube("Rotate Cube Test");
        rotateCube.start();
    }

    Entity entity;

    @Override
    public void init() {

        entity = ResourceManager.getActive().allocateFromEngine(new EntityKey("obj/cube.obj"));
        entity.getTransformation().setScale(new Vector3f(0.1f,0.1f,0.1f));
        entity.getTransformation().setPosition(new Vector3f(0, 0, -0.5f));
        getDimension().addObj(entity, RenderType.ENTITIES);

        getWindow().setVisible(true);
        getWindow().setSize(500, 500);

        getTimer().setLpsSmoothing(0);

    }

    double lastTime;
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
            entity.getTransformation().getRotation().set(0,0,0);


        if(getWindow().isKeyPressed(GLFW.GLFW_KEY_F)) {
            System.out.println("RENDER FPS:      " + getTimer().getLPS());
            System.out.println("UPDATE FPS:      " + updateLoop.getTimer().getLPS());
            System.out.println("Update Delta:    " + deltaMillis);
            System.out.println("Update FPS Calc: " + 1000/deltaMillis);
        }

    }

    public void rotateByDegrees(Vector3f vector3f){
        Vector3f rotation = entity.getTransformation().getRotation();
        rotation.set((float)Math.toRadians((Math.toDegrees(rotation.x) + vector3f.x) % 360),
                     (float)Math.toRadians((Math.toDegrees(rotation.y) + vector3f.y) % 360),
                     (float)Math.toRadians((Math.toDegrees(rotation.z) + vector3f.z) % 360));
    }


}
