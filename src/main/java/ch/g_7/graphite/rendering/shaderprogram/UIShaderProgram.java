package ch.g_7.graphite.rendering.shaderprogram;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector4f;

import ch.g_7.graphite.util.Color;

public class UIShaderProgram extends AbstractShaderProgram{

	public UIShaderProgram()  {
		super("shaders/ui_vertex.sp", "shaders/ui_fragment.sp");
	}

	@Override
	public void init() {
		super.init();
        createUniform("window_size");
        createUniform("texture_sampler");
        createUniform("color");
	}

	
	public void setWindowSize(Vector2i size) {
		setUniform("window_size", size);
	}

	public void setTextureSampler(int value) {
		setUniform("texture_sampler", value);
	}
	
	public void setColor(Color value) {
		setUniform("color", new Vector4f(value.getR(), value.getG(), value.getB(), value.getA()));
	}

}
