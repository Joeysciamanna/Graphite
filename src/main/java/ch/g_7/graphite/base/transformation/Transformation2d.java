package ch.g_7.graphite.base.transformation;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2i;

public class Transformation2d extends Transformation implements ITransformation, ITransformation2d {

	public Transformation2d(float z) {
		getPosition().z = z;
	}
	
	public Transformation2d() {}

	public Vector2f getPosition2d() {
		return new Vector2f(getPosition().x, getPosition().y);
	}
	
	public Vector2i getIntPosition2d() {
		return new Vector2i((int) getPosition().x, (int) getPosition().y);
	}
	
	public void setPosition(Vector2fc location) {
		getPosition().set(location, getPosition().z);
	}

	public void setPosition(float x, float y) {
		getPosition().set(x, y, getPosition().z);
	}
	
	public Vector2f getScale2d() {
		return new Vector2f(getScale().x, getScale().y);
	}
	
	public Vector2i getIntScale2d() {
		return new Vector2i((int) getScale().x, (int) getScale().y);
	}
	
	public void setScale(Vector2fc scale) {
		getScale().set(scale, getScale().z);
	} 
	
	public void setScale(float x, float y) {
		getScale().set(x, y, getScale().z);
	}

}
