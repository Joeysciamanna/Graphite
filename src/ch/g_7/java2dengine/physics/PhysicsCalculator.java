package ch.g_7.java2dengine.physics;


import java.util.ArrayList;

import ch.g_7.java2dengine.core.Engine;
import ch.g_7.java2dengine.process.Process;

public class PhysicsCalculator implements Process<Engine, Void>{

	@Override
	public Void run(Engine engine) {
		for(ArrayList<PhysicsEntity> colliderClasses: engine.getPhysics().getColliderClasses().getAll()) {
			for (PhysicsEntity physicsEntity : colliderClasses) {
				for (PhysicsEntity physicsEntity2 : colliderClasses) {
					if(!physicsEntity.equals(physicsEntity2)) {
						physicsEntity.oc
					}
				}
			}
		}
		return null;
	}

	
	
}
