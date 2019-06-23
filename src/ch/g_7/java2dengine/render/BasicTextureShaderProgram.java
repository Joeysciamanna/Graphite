package ch.g_7.java2dengine.render;

import java.io.IOException;

import org.joml.Matrix4f;

public class BasicTextureShaderProgram extends AbstractShaderProgram{


	public BasicTextureShaderProgram() throws IOException  {
		super("C:/Users/Joey Sciamanna/git/Java2DEngine/res/shaders/texture_vertex.sh", "C:/Users/Joey Sciamanna/git/Java2DEngine/res/shaders/texture_fragment.sh");
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
