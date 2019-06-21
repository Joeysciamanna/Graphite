package ch.g_7.javaengine2d.render;

import java.io.IOException;

import org.joml.Matrix4f;

public class BasicGridShaderProgram extends AbstractShaderProgram{


	public BasicGridShaderProgram() throws IOException  {
		//PC super("C:/Users/Joey Sciamanna/git/GridEngine/res/shaders/vertex.vs", "C:/Users/Joey Sciamanna/git/GridEngine/res/shaders/fragment.fs");
		super("C:/workspace/java/Grid/GridEngine/res/shaders/vertex.vs", "C:/workspace/java/Grid/GridEngine/res/shaders/fragment.fs");
		//BBC: super("C:/Dev/Workspace/JavaLWJGL/GridEngine/res/shaders/vertex.vs", "C:/Dev/Workspace/JavaLWJGL/GridEngine/res/shaders/fragment.fs");
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
