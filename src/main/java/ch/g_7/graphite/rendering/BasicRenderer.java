package ch.g_7.graphite.rendering;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.IWindow;
import ch.g_7.graphite.node.IEntity;
import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.rendering.transformator.ITransformator;

import java.util.List;

public abstract class BasicRenderer<R extends IViewModel, T extends IEntity<?, R>> implements IRenderer<T> {

	protected final BasicShaderProgram shaderProgram;
	protected final NodeRenderList<T> renderableList;
	protected ITransformator transformator;


	public BasicRenderer(BasicShaderProgram shaderProgram, NodeRenderList<T> viewModelList, ITransformator transformator) {
		this.shaderProgram = shaderProgram;
		this.renderableList = viewModelList;
		this.transformator = transformator;
	}

	@Override
	public void render(IWindow window, Camera camera) {
		shaderProgram.setProjectionMatrix(transformator.getProjectionMatrix(window, camera));
		render(renderableList.getViewModels());
	}

	protected abstract void render(List<T> renderables);


	@Override
	public void addRenderable(T n) {
		renderableList.add(n);
	}

	@Override
	public void removeRenderable(T n) {
		renderableList.remove(n);
	}

	@Override
	public boolean isUsed() {
		return !renderableList.isEmpty();
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
