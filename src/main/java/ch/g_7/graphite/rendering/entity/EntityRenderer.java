package ch.g_7.graphite.rendering.entity;

import java.util.List;

import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.rendering.*;
import ch.g_7.graphite.rendering.transformator.ITransformator;
import ch.g_7.util.fdt.data.Response;
import org.lwjgl.opengl.GL11;

import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.rendering.transformator.PerspectiveTransformator;
import ch.g_7.graphite.util.Resources;

public class EntityRenderer extends BasicRenderer<BasicViewModel> {


	public EntityRenderer() {
		super(new BasicShaderProgram(Resources.ENTITY_VERTEX_SHADER,Resources.ENTITY_FRAGMENT_SHADER), new RenderableList<>(), new PerspectiveTransformator());
	}

	@Override
	protected void render(List<INode<?, BasicViewModel>> nodes) {
		for (INode<?, BasicViewModel> node : nodes) {
			render(node);
		}
	}

	@Override
	public IRenderType<?> getRenderType() {
		return RenderType.ENTITY;
	}

	@Override
	public boolean isUsed() {
		return true;
	}


}
