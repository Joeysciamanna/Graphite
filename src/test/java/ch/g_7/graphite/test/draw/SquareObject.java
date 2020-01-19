package ch.g_7.graphite.test.draw;

import org.joml.Vector2f;
import org.joml.Vector3f;

import ch.g_7.graphite.draw.DrawContext;
import ch.g_7.graphite.draw.drawable.BasicDrawable;
import ch.g_7.graphite.util.Color;

public class SquareObject extends BasicDrawable {

	private float lineX;
	private Color lineColor;
	
	@Override
	public void draw(DrawContext drawContext) {
		drawContext.setBrushColor(Color.getColor(255, 0, 0));
		drawContext.addRectangle(new Vector3f(0,0,0), new Vector2f(1,1));
		drawContext.setBrushColor(lineColor);
		drawContext.addLine(new Vector3f(0, 0, 0), new Vector3f(lineX,1,0));
	}
	
	
	private int lineDirection = 1;
	
	@Override
	public void update(float deltaMillis) {
		if(lineX > 1) {
			lineDirection = -1;
			
		} else if(lineX < -1){
			lineDirection = 1;
		}
		lineColor = Color.getColor((int) ((lineX + 1) / 2 * 255),(int)  (255 - (lineX + 1) / 2 * 255), 0);
		lineX += 0.001f * lineDirection * deltaMillis;
	}
	
	

}
