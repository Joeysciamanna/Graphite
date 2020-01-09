package ch.g_7.graphite.draw;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector3fc;

import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.draw.object.DrawObject;
import ch.g_7.graphite.draw.object.IDrawObject;
import ch.g_7.graphite.util.Color;

//TODO Shapes and text
public class DrawContext {

	private List<IDrawObject> drawObjects;
	private DrawObject drawObject;

	
	public DrawContext() {
		this.drawObjects = new ArrayList<>();
	}

	public void setBrushColor(Color color) {
		next(new DrawObject());
		drawObject.setColor(color);
	}
	
	public void setBrushTexture(Texture texture) {
		next(new DrawObject());
		drawObject.setTexture(texture);
	}
	
	public void addLine(Vector3fc from, Vector3fc to) {

	}
	
	public void addImage(Texture texture, Vector3fc at) {
		
	}
	
	public void addRectangle(Vector3fc position, Vector2fc size) {
		
	}

	private void next(DrawObject drawObject) {
		if(this.drawObject != null && !this.drawObject.isEmpty()) {
			add(this.drawObject);
		}
		this.drawObject = drawObject;
	}
	
	public void add(IDrawObject drawObject) {
		drawObjects.add(drawObject);
	}
	
	public List<IDrawObject> getDrawObjects() {
		return drawObjects;
	}
}
