package ch.g_7.javaengine2d.render;

import java.io.IOException;

import org.joml.Matrix4f;

public class BasicGridShaderProgram extends AbstractShaderProgram{


	public BasicGridShaderProgram() throws IOException  {
		super("C:/Users/Joey Sciamanna/git/Java2DEngine/res/shaders/vertex.vs", "C:/Users/Joey Sciamanna/git/Java2DEngine/res/shaders/fragment.fs");
	}

	@Override
	public void init() {
		super.init();
        createUniform("model_view_matrix");
        createUniform("texture_sampler");
	}

	
	public void setModelViewMatrix(Matrix4f matrix) {
		setUniform("model_view_matrix", matrix);
	}

	public void setTextureSampler(int value) {
		setUniform("texture_sampler", value);
	}
	

}
