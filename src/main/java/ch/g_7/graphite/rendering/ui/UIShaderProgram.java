package ch.g_7.graphite.rendering.ui;

import org.joml.Matrix4f;

import ch.g_7.graphite.rendering.ShaderProgram;
import ch.g_7.graphite.util.Color;
import ch.g_7.graphite.util.Resources;

public class UIShaderProgram extends ShaderProgram{

	public UIShaderProgram() {
		super(Resources.UI_VERTEX_SHADER_PATH, Resources.UI_FRAGMENT_SHADER_PATH);
	}

	@Override
	public void init() {
		super.init();
        createUniform("modelViewMatrix");
        createUniform("projectionMatrix");
        createUniform("texture");
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
		setUniform("texture", value);
	}
	
	public void setColor(Color value) {
		setUniform("color", value.toVector());
	}
	
	public void setTextureEnabled(boolean value) {
		setUniform("textureEnabled", value);
	}

}
