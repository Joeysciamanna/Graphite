package ch.g_7.graphite.rendering.draw;

import java.util.List;

import ch.g_7.graphite.draw.Drawable;
import ch.g_7.graphite.draw.IDrawObject;
import ch.g_7.graphite.rendering.basic.BasicRenderer;
import ch.g_7.graphite.rendering.basic.BasicShaderProgram;
import ch.g_7.graphite.rendering.transformator.OrthographicTransformator;
import ch.g_7.graphite.util.Resources;

public class DrawRenderer extends BasicRenderer<Drawable>{


	public DrawRenderer() {
		super(new BasicShaderProgram(Resources.DRAW_VERTEX_SHADER, Resources.DRAW_FRAGMENT_SHADER), new OrthographicTransformator());
	}

	@Override
	protected void render(List<Drawable> drawables) {
		for (Drawable drawable : drawables) {
			for(IDrawObject drawObject : drawable.draw().getDrawObjects()) {
				render(drawObject.getViewModel(), drawObject.getTransformation());	
			}
		}
	}

}
