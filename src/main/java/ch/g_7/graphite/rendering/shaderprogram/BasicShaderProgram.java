package ch.g_7.graphite.rendering.shaderprogram;

import org.joml.Matrix4f;
import org.joml.Vector4f;

import ch.g_7.graphite.util.Color;

public class BasicShaderProgram extends AbstractShaderProgram{


	public BasicShaderProgram()  {
		super("shaders/basic_vertex.sp", "shaders/basic_fragment.sp");
	}

	@Override
	public void init() {
		super.init();
        createUniform("model_view_matrix");
        createUniform("texture_sampler");
        createUniform("color");
	}

	
	public void setModelViewMatrix(Matrix4f matrix) {
		setUniform("model_view_matrix", matrix);
	}

	public void setTextureSampler(int value) {
		setUniform("texture_sampler", value);
	}
	
	public void setColor(Color value) {
		setUniform("color", new Vector4f(value.getR(), value.getG(), value.getB(), value.getA()));
	}
	
	public void setTextureEnabled(boolean value) {
		setUniform("color", value);
	}

}
