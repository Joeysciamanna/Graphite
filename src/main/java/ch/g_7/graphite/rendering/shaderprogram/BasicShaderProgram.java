package ch.g_7.graphite.rendering.shaderprogram;

import org.joml.Matrix4f;

import ch.g_7.graphite.util.Color;

public class BasicShaderProgram extends AbstractShaderProgram{


	public BasicShaderProgram(String vertexCodePath, String fragmentCodePath) {
		super(vertexCodePath, fragmentCodePath);
	}

	@Override
	public void init() {
		super.init();
        createUniform("model_view_matrix");
        createUniform("texture_sampler");
        createUniform("color");
        createUniform("textureEnabled");
	}

	
	public void setModelViewMatrix(Matrix4f matrix) {
		setUniform("model_view_matrix", matrix);
	}

	public void setTextureSampler(int value) {
		setUniform("texture_sampler", value);
	}
	
	public void setColor(Color value) {
		setUniform("color", value.toVector());
	}
	
	public void setTextureEnabled(boolean value) {
		setUniform("textureEnabled", value);
	}

}
