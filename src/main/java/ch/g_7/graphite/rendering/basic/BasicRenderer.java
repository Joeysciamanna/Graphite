package ch.g_7.graphite.rendering.basic;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;

import java.util.List;

import ch.g_7.graphite.base.transformation.ITransformation;
import ch.g_7.graphite.base.transformation.Transformation;
import ch.g_7.graphite.base.vao.VAO;
import ch.g_7.graphite.base.view_model.IViewModel;
import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.rendering.IRenderer;
import ch.g_7.graphite.rendering.transformator.ITransformator;
import ch.g_7.graphite.util.Resource;

public abstract class BasicRenderer<T> extends Resource implements IRenderer<T> {

	private ITransformator<ITransformation> transformator;
	protected final BasicShaderProgram shaderProgram;

	public BasicRenderer(BasicShaderProgram shaderProgram, ITransformator<ITransformation> transformator) {
		this.shaderProgram = shaderProgram;
		this.transformator = transformator;
	}

	@Override
	public final void render(List<T> nodes, Window window, Camera camera) {
		shaderProgram.bind();
		shaderProgram.setTextureSampler(0);
		shaderProgram.setProjectionMatrix(transformator.getProjectionMatrix(window, camera));
		renderAll(nodes);
		shaderProgram.unbind();
	}

	protected abstract void renderAll(List<T> nodes);

	protected void render(IViewModel viewModel, ITransformation transformation) {

		shaderProgram.setModelViewMatrix(transformator.getModelViewMatrix(transformation));
		shaderProgram.setColor(viewModel.getColor());

		viewModel.bind();
		if (viewModel.getTexture() != null) {
			shaderProgram.setTextureEnabled(true);
		} else {
			shaderProgram.setTextureEnabled(false);
		}

		VAO vao = viewModel.getMesh().getVAO();

		vao.bind();
		draw(viewModel.getMesh().getVerticesCount());
		vao.unbind();

		viewModel.unbind();

	}

	protected void draw(int verticesCount) {
		glDrawElements(GL_TRIANGLES, verticesCount, GL_UNSIGNED_INT, 0);
	}

	public void setTransformator(ITransformator<ITransformation> transformator) {
		this.transformator = transformator;
	}

	@Override
	protected void doInit() {
		shaderProgram.init();
	}

	@Override
	protected void doClose() {
		shaderProgram.close();
	}
}
