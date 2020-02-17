package ch.g_7.graphite.rendering.basic;

import ch.g_7.graphite.util.IColor;
import org.joml.Matrix4f;

import ch.g_7.graphite.rendering.ShaderProgram;
import ch.g_7.graphite.util.Color;

public class BasicShaderProgram extends ShaderProgram {


	public BasicShaderProgram(String vertexCode, String fragmentCode) {
		super(vertexCode, fragmentCode);
	}

	@Override
	public void init() {
		super.init();
        createUniform("modelViewMatrix");
        createUniform("projectionMatrix");
        createUniform("textureSample");
        createUniform("color");
        createUniform("textureEnabled");
	}

	
	public void setModelViewMatrix(Matrix4f matrix) {
		setUniform("modelViewMatrix", matrix);
	}

	public void setProjectionMatrix(Matrix4f matrix) {
		setUniform("projectionMatrix", matrix);
	}
	
	public void setTextureSampler(int value) {
		setUniform("textureSample", value);
	}
	
	public void setColor(IColor value) {
		setUniform("color", value.toVector());
	}
	
	public void setTextureEnabled(boolean value) {
		setUniform("textureEnabled", value);
	}

}
