package ch.g_7.graphite.test;

import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

import ch.g_7.graphite.base.mesh.BasicMesh3d;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.node.RenderCluster;
import ch.g_7.graphite.node.entity.BasicEntity;
import ch.g_7.graphite.node.entity.ViewModel;
import ch.g_7.graphite.rendering.entity.EntityTransformation3d;
import ch.g_7.graphite.ui.UIButton;
import ch.g_7.graphite.ui.UIPanel;
import ch.g_7.graphite.ui.UIRootContainer;
import ch.g_7.graphite.ui.layout.DontCareLayoutPanel;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.task.SecureRunner;

public class RotateCube extends Application {

	public RotateCube(String name) {
		super(name);
	}

	public static void main(String[] args) {
		new RotateCube("Rotate Cube Test").setRunning(true);
	}

	BasicEntity entity1;
	BasicEntity entity2;

	@Override
	protected void init() {

		RenderCluster.ENTITIES.getRenderer().setTransformation(new EntityTransformation3d());

		float[] positions = new float[] {
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
				0.5f, -0.5f, -0.5f, };
		int[] indices = new int[] {
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
		
		ViewModel viewModel = new ViewModel();
		viewModel.setMesh(new BasicMesh3d(positions, indices));
		viewModel.setColor(Color.getColor(255, 255, 0));

		entity1 = new BasicEntity();
		entity1.setViewModel(viewModel);
		entity1.setPosition(new Vector3f(0, 0, -2));
		
		getDimension().addObj(entity1, RenderCluster.ENTITIES);

		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}

	@Override
	public void update(double deltaMillis) {

		if (getWindow().isKeyPressed(GLFW.GLFW_KEY_W)) {
			entity1.getRotation().add((float) Math.toRadians(deltaMillis * -0.05), 0, 0);
		}
		if (getWindow().isKeyPressed(GLFW.GLFW_KEY_S)) {
			entity1.getRotation().add((float) Math.toRadians(deltaMillis * 0.05), 0, 0);
		}
		if (getWindow().isKeyPressed(GLFW.GLFW_KEY_A)) {
			entity1.getRotation().add(0, (float) Math.toRadians(deltaMillis * -0.05), 0);
		}
		if (getWindow().isKeyPressed(GLFW.GLFW_KEY_D)) {
			entity1.getRotation().add(0, (float) Math.toRadians(deltaMillis * 0.05), 0);
		}
		if (getWindow().isKeyPressed(GLFW.GLFW_KEY_Q)) {
			entity1.getRotation().add(0, 0, (float) Math.toRadians(deltaMillis * -0.05));
		}
		if (getWindow().isKeyPressed(GLFW.GLFW_KEY_E)) {
			entity1.getRotation().add(0, 0, (float) Math.toRadians(deltaMillis * 0.05));
		}


	}

}
