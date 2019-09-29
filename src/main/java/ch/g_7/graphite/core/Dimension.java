package ch.g_7.graphite.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ch.g_7.graphite.base.object.AbstractGameEntity;
import ch.g_7.graphite.util.Pos3d;

public class Dimension {

	protected Map<Pos3d, AbstractGameEntity> gameObjects;
	
	public Dimension() {
		gameObjects = new HashMap<Pos3d, AbstractGameEntity>();
	}
	
	public void add(AbstractGameEntity gameObject) {
		gameObjects.put(gameObject.getPosition(), gameObject);
	}
	
	public Collection<AbstractGameEntity> getGameObjects() {
		return gameObjects.values();
	}
}
