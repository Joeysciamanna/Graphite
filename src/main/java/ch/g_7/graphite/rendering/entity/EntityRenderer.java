package ch.g_7.graphite.rendering.entity;

import java.util.List;

import ch.g_7.graphite.base.material.IMaterial;
import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.node.IEntity;
import ch.g_7.graphite.node.Renderable;
import ch.g_7.graphite.rendering.*;

import ch.g_7.graphite.rendering.transformator.PerspectiveTransformator;
import ch.g_7.graphite.util.Resources;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

public class EntityRenderer extends BasicRenderer<BasicViewModel, IEntity<?, BasicViewModel>> {


	public EntityRenderer() {
		super(new BasicShaderProgram(Resources.ENTITY_VERTEX_SHADER,Resources.ENTITY_FRAGMENT_SHADER), new NodeRenderList<>(), new PerspectiveTransformator());
	}

	@Override
	protected void render(List<IEntity<?, BasicViewModel>> nodes) {
		for (IEntity<?, BasicViewModel> node : nodes) {
			render(node);
		}
	}


	private void render(IEntity<?, BasicViewModel> renderable) {
		IMaterial material = renderable.getViewModel().getMaterial();
		IMesh mesh = renderable.getViewModel().getMesh();
		shaderProgram.setModelViewMatrix(transformator.getModelViewMatrix(renderable.getTransform()));
		shaderProgram.setColor(material.getAmbient());


		if (material.getTexture() != null) {
			glActiveTexture(GL_TEXTURE0);
			shaderProgram.setTextureEnabled(true);
		} else {
			shaderProgram.setTextureEnabled(false);
		}

		material.bind();
		mesh.bind();
		glDrawElements(GL11.GL_TRIANGLES, mesh.getVerticesCount(), GL_UNSIGNED_INT, 0);
		material.unbind();
		mesh.unbind();
	}

	@Override
	public IRenderType<?> getRenderType() {
		return RenderType.ENTITY;
	}

}
