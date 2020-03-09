package ch.g_7.graphite.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Objects;

import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

import ch.g_7.graphite.base.material.Material;
import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.entity.Entity;
import ch.g_7.graphite.entity.EntityKey;
import ch.g_7.graphite.rendering.RenderType;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.helper.AppInitializer;

public class Test extends Application {

    public Test(String name) {
        super(name);
    }

    public static void main(String[] args) {
        AppInitializer appInitializer = new AppInitializer(true,"RotateCube Test", new Object() {});
        appInitializer.addConsoleLoggers();

        new Test("test").start();
    }


    @Override
    public void init() {

      

        Entity entity = ResourceManager.getActive().allocateFromEngine(new EntityKey("untitled.obj"));

        getDimension().addObj(entity, RenderType.ENTITIES);

        getWindow().setVisible(true);
        getWindow().setSize(500, 500);


    }

	@Override
	@SuppressWarnings("deprecation")
    public void update(float deltaMillis) {
        if(getWindow().isKeyPressed(GLFW.GLFW_KEY_F)) {
            System.out.println("RENDER FPS:      " + getTimer().getLPS());
            System.out.println("UPDATE FPS:      " + updateLoop.getTimer().getLPS());
            System.out.println("Update Delta:    " + deltaMillis);
            System.out.println("Update FPS Calc: " + 1000/deltaMillis);
        }

    }



}
