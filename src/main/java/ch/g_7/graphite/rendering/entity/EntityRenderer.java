package ch.g_7.graphite.rendering.entity;

import java.util.List;

import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.rendering.basic.BasicRenderer;
import ch.g_7.graphite.rendering.basic.BasicShaderProgram;
import ch.g_7.graphite.rendering.transformator.OrthographicTransformator;
import ch.g_7.graphite.util.Resources;

public class EntityRenderer extends BasicRenderer<IEntity> {


	public EntityRenderer() {
		super(new BasicShaderProgram(Resources.ENTITY_VERTEX_SHADER, Resources.ENTITY_FRAGMENT_SHADER), new OrthographicTransformator());
	}


	@Override
	protected void renderAll(List<IEntity> drawables) {
		for (IEntity node : drawables) {
			render(node.getViewModel(), node.getTransformation());
		}
	}

}
