package ch.g_7.graphite.physics;

import java.util.ArrayList;
import java.util.List;

public class PhysicsWorld {

	private List<ColissionClass> colissionClasses;
	
	public PhysicsWorld() {
		colissionClasses = new ArrayList<>();
	}
	
	public void add(ColissionClass colissionClass) {
		colissionClasses.add(colissionClass);
	}
	
	public void remove(ColissionClass colissionClass) {
		colissionClasses.remove(colissionClass);
	}
	
 	
}
