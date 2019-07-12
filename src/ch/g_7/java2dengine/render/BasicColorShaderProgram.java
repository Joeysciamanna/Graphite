package ch.g_7.java2dengine.render;

import java.io.IOException;

import org.joml.Matrix4f;
import org.joml.Vector4f;

import ch.g_7.java2dengine.util.Color;

public class BasicColorShaderProgram extends AbstractShaderProgram{


	public BasicColorShaderProgram() throws IOException  {
//		super("C:/Users/Joey Sciamanna/git/Java2DEngine/res/shaders/color_vertex.sh", "C:/Users/Joey Sciamanna/git/Java2DEngine/res/shaders/color_fragment.sh");
		super("D:/Users/zsciaj/git/Java2DEngine/res/shaders/color_vertex.sh", "D:/Users/zsciaj/git/Java2DEngine/res/shaders/color_fragment.sh");
	}

	@Override
	public void init() {
		super.init();
        createUniform("model_view_matrix");
        createUniform("color");
	}

	
	public void setModelViewMatrix(Matrix4f matrix) {
		setUniform("model_view_matrix", matrix);
	}

	public void setColor(Color value) {
		setUniform("color", new Vector4f(value.getR(), value.getG(), value.getB(), value.getA()));
	}
	

}
