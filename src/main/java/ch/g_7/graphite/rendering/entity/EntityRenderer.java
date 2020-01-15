package ch.g_7.graphite.rendering.entity;

import java.util.List;

import org.lwjgl.opengl.GL11;

import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.rendering.basic.BasicRenderer;
import ch.g_7.graphite.rendering.basic.BasicShaderProgram;
import ch.g_7.graphite.rendering.transformator.PerspectiveTransformator;
import ch.g_7.graphite.util.Resources;

public class EntityRenderer extends BasicRenderer<IEntity> {


	public EntityRenderer() {
		super(new BasicShaderProgram(Resources.ENTITY_VERTEX_SHADER, Resources.ENTITY_FRAGMENT_SHADER), new PerspectiveTransformator());
	}


	@Override
	protected void render(List<IEntity> drawables) {
		for (IEntity node : drawables) {
			render(node, GL11.GL_TRIANGLES);
		}
	}

}
