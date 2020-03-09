package ch.g_7.graphite.rendering.basic;

import ch.g_7.graphite.base.material.IMaterial;
import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.transformation.ITransform;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Renderable;
import ch.g_7.graphite.rendering.IRenderer;
import ch.g_7.graphite.rendering.transformator.ITransformator;

import java.util.List;

import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

public abstract class BasicRenderer<T extends INode<T>> implements IRenderer<T> {

	private ITransformator<ITransform> transformator;
	protected final BasicShaderProgram shaderProgram;

	public BasicRenderer(BasicShaderProgram shaderProgram, ITransformator<ITransform> transformator) {
		this.shaderProgram = shaderProgram;
		this.transformator = transformator;
	}

	@Override
	public final void render(List<? extends T> nodes, Window window, Camera camera) {
		shaderProgram.bind();
		shaderProgram.setTextureSampler(0);
		shaderProgram.setProjectionMatrix(transformator.getProjectionMatrix(window, camera));
		render(nodes);
		shaderProgram.unbind();
	}

	protected abstract void render(List<? extends T> nodes);

	protected <R extends Renderable> void render(R renderable, int glDrawMethod) {

		IMaterial material = renderable.getViewModel().getMaterial();
		IMesh mesh = renderable.getViewModel().getMesh();
		shaderProgram.setModelViewMatrix(transformator.getModelViewMatrix(renderable.getTransformation()));
		shaderProgram.setColor(material.getAmbient());


		if (material.getTexture() != null) {
			glActiveTexture(GL_TEXTURE0);
			shaderProgram.setTextureEnabled(true);
		} else {
			shaderProgram.setTextureEnabled(false);
		}

		material.bind();
		mesh.bind();
		glDrawElements(glDrawMethod, mesh.getVerticesCount(), GL_UNSIGNED_INT, 0);
		material.bind();
		mesh.bind();
	}


	public void setTransformator(ITransformator<ITransform> transformator) {
		this.transformator = transformator;
	}

	@Override
	public void init() {
		shaderProgram.init();
	}

	@Override
	public void close() {
		shaderProgram.close();
	}
}
