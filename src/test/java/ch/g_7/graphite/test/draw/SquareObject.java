package ch.g_7.graphite.test.draw;

import org.joml.Vector2f;
import org.joml.Vector3f;

import ch.g_7.graphite.draw.DrawContext;
import ch.g_7.graphite.draw.drawable.BasicDrawable;
import ch.g_7.graphite.util.Color;

public class SquareObject extends BasicDrawable {

	
	@Override
	public void draw(DrawContext drawContext) {
		drawContext.setBrushColor(Color.getColor(255, 0, 0));
		drawContext.addRectangle(new Vector3f(0,0,0), new Vector2f(1,1));
		drawContext.addLine(new Vector3f(0, 0, 0), new Vector3f(-1,1,0));
	}
	

}
