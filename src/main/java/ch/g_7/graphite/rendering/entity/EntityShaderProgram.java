package ch.g_7.graphite.rendering.entity;

import org.joml.Matrix4f;

import ch.g_7.graphite.rendering.ShaderProgram;
import ch.g_7.graphite.util.Color;
import ch.g_7.graphite.util.Resources;

public class EntityShaderProgram extends ShaderProgram {


	public EntityShaderProgram()  {
		super(Resources.ENTITY_VERTEX_SHADER_PATH, Resources.ENTITY_FRAGMENT_SHADER_PATH);
	}


	@Override
	public void doInit() {
		super.doInit();
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
