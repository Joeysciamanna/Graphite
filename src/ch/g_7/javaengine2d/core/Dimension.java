package ch.g_7.javaengine2d.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ch.g_7.javaengine2d.base.object.AbstractGameObject;
import ch.g_7.javaengine2d.util.Pos3d;

public class Dimension {

	protected Map<Pos3d, AbstractGameObject> gameObjects;
	
	public Dimension() {
		gameObjects = new HashMap<Pos3d, AbstractGameObject>();
	}
	
	public void add(AbstractGameObject gameObject) {
		gameObjects.put(gameObject.getPosition(), gameObject);
	}
	
	public Collection<AbstractGameObject> getGameObjects() {
		return gameObjects.values();
	}
}
