package ch.g_7.graphite.test;

import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.mesh.MeshKey;
import ch.g_7.graphite.base.mesh.MeshKeyBuilder2d;
import ch.g_7.graphite.base.mesh.MeshProvider;
import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.entity.Entity;
import ch.g_7.graphite.rendering.RenderType;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.graphite.util.Color;
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

    Entity entity1;
    Entity entity2;

    @Override
    public void init() {

        float[] positions = new float[]{
                // VO
                -0.5f, 0.5f, 0.5f,
                // V1
                -0.5f, -0.5f, 0.5f,
                // V2
                0.5f, -0.5f, 0.5f,
                // V3
                0.5f, 0.5f, 0.5f,
                // V4
                -0.5f, 0.5f, -0.5f,
                // V5
                0.5f, 0.5f, -0.5f,
                // V6
                -0.5f, -0.5f, -0.5f,
                // V7
                0.5f, -0.5f, -0.5f,};
        int[] indices = new int[]{
                // Front face
                0, 1, 3, 3, 1, 2,
                // Top Face
                4, 0, 3, 5, 4, 3,
                // Right face
                3, 2, 7, 5, 3, 7,
                // Left face
                6, 1, 0, 6, 0, 4,
                // Bottom face
                2, 1, 6, 2, 6, 7,
                // Back face
                7, 6, 4, 7, 4, 5
        };

        Mesh mesh = ResourceManager.getActive().getEngineResource(new MeshKey(positions, indices));

        ViewModel viewModel = new ViewModel(mesh, null, Color.PURPLE);

        entity1 = new Entity(viewModel);
        entity1.getTransformation().setPosition(new Vector3f(0, 0, -2 ));

        getDimension().addObj(entity1, RenderType.ENTITIES);

        getWindow().setVisible(true);
        getWindow().setSize(500, 500);



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
            entity1.getTransformation().getRotation().set(0,0,0);


        if(getWindow().isKeyPressed(GLFW.GLFW_KEY_F)) {
            System.out.println("FPS:      " + getTimer().getLPS());
            System.out.println("Delta:    " + deltaMillis);
            System.out.println("FPS Calc: " + 1000/deltaMillis);
        }
        if(getWindow().isKeyPressed(GLFW.GLFW_KEY_T)) {
            double time = System.nanoTime() / 1_000_000;
            System.out.println("Supplied millis: " + deltaMillis);
            System.out.println("Real millis    : " + (time - lastTime));
            lastTime = time;
        }

    }

    public void rotateByDegrees(Vector3f vector3f){
        Vector3f rotation = entity1.getTransformation().getRotation();
        rotation.set((float)Math.toRadians((Math.toDegrees(rotation.x) + vector3f.x) % 360),
                     (float)Math.toRadians((Math.toDegrees(rotation.y) + vector3f.y) % 360),
                     (float)Math.toRadians((Math.toDegrees(rotation.z) + vector3f.z) % 360));
    }


}
