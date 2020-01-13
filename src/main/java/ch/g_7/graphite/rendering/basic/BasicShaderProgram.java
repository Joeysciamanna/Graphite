package ch.g_7.graphite.rendering.basic;

import org.joml.Matrix4f;

import ch.g_7.graphite.rendering.ShaderProgram;
import ch.g_7.graphite.util.Color;

public class BasicShaderProgram extends ShaderProgram {


	public BasicShaderProgram(String vertexCode, String fragmentCode) {
		super(vertexCode, fragmentCode);
	}

	@Override
	public void doInit() {
		super.doInit();
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
	
	public void setColor(Color value) {
		setUniform("color", value.toVector());
	}
	
	public void setTextureEnabled(boolean value) {
		setUniform("textureEnabled", value);
	}

}
