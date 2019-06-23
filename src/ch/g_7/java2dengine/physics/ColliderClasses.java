package ch.g_7.java2dengine.physics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ColliderClasses {

	private Map<Character, ArrayList<PhysicsEntity>> colliderClasses;
	
	public ColliderClasses() {
		colliderClasses = new HashMap<>();
	}
	
	public void add(PhysicsEntity entity, char colliderClass) {
		if(colliderClasses.containsKey(colliderClass)) {
			colliderClasses.get(colliderClass).add(entity);
		}else {
			colliderClasses.put(colliderClass, new ArrayList<>());
			add(entity, colliderClass);
		}
	}
	
	public void remove(PhysicsEntity entity, char colliderClass) {
		colliderClasses.get(colliderClass).remove(entity);
	}
	
	public void removeAll(char colliderClass) {
		colliderClasses.remove(colliderClass);
	}
	
	protected Collection<ArrayList<PhysicsEntity>> getAll(){
		return colliderClasses.values();
	}
}
