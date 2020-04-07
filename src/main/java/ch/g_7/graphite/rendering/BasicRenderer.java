package ch.g_7.graphite.rendering;

import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

import java.util.List;

import ch.g_7.graphite.base.material.IMaterial;
import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Renderable;
import ch.g_7.graphite.rendering.transformator.ITransformator;
import org.lwjgl.opengl.GL11;

public abstract class BasicRenderer<T extends IBasicViewModel> implements IRenderer<T> {

	protected final BasicShaderProgram shaderProgram;
	protected final RenderableList<T> renderableList;
	private ITransformator transformator;


	public BasicRenderer(BasicShaderProgram shaderProgram, RenderableList<T> viewModelList, ITransformator transformator) {
		this.shaderProgram = shaderProgram;
		this.renderableList = viewModelList;
		this.transformator = transformator;
	}

	@Override
	public void render(Window window, Camera camera) {
		shaderProgram.setProjectionMatrix(transformator.getProjectionMatrix(window, camera));
		render(renderableList.getViewModels());
	}

	protected abstract void render(List<Renderable<T>> nodes);

	protected <R extends Renderable<T>> void render(R renderable) {

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
		material.bind();
		mesh.bind();
	}

	@Override
	public void addRenderable(Renderable<T> n) {
		renderableList.add(n);
	}

	@Override
	public void removeRenderable(Renderable<T> n) {
		renderableList.remove(n);
	}

	@Override
	public void clear() {
		renderableList.clear();
	}

	@Override
	public void bind() {
		shaderProgram.bind();
		shaderProgram.setTextureSampler(0);
	}

	@Override
	public void unbind() {
		shaderProgram.unbind();
	}

	@Override
	public void init() {
		shaderProgram.init();
	}

	@Override
	public void close() {
		shaderProgram.close();
	}

	public void setTransformator(ITransformator transformator) {
		this.transformator = transformator;
	}

}
