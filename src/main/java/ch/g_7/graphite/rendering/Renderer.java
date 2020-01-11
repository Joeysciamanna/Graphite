package ch.g_7.graphite.rendering;

import java.util.List;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.util.ResourceHandler;

public abstract class Renderer<T extends INode, S extends ShaderProgram> implements IRenderer<T>{

	protected final S shaderProgram;
	
	public Renderer(S shaderProgram) {
		this.shaderProgram = shaderProgram;
	}
	
	@Override
	public final void render(List<T> nodes, Window window, Camera camera) {
		shaderProgram.bind();
		doRender(nodes, window, camera);
		shaderProgram.unbind();
	}

	protected abstract void doRender(List<T> nodes, Window window, Camera camera);

	@Override
	public final void init() {
		if(ResourceHandler.shallInitialize(this)) doInit();
	}
	
	protected void doInit() {
		shaderProgram.init();
	}
	
	@Override
	public final void close() {
		if(ResourceHandler.shallInitialize(this)) doClose();
	}

	protected void doClose() {
		shaderProgram.close();
	}
	

	public ShaderProgram getShaderProgram() {
		return shaderProgram;
	}
	

}
