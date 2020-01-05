package ch.g_7.graphite.rendering.shaderprogram;

import org.joml.Matrix4f;

public class EntityShaderProgram extends BasicShaderProgram{

	public EntityShaderProgram()  {
		super("shaders/entity_vertex.sp", "shaders/entity_fragment.sp");
	}

	@Override
	public void init() {
		super.init();
		createUniform("projectionMatrix");
	}
	
	public void setProjectionMatrix(Matrix4f matrix) {
		setUniform("projectionMatrix", matrix);
	}

}
