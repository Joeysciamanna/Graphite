package ch.g_7.java2dengine.physics;

import ch.g_7.java2dengine.base.object.BasicGameEntity;
import ch.g_7.java2dengine.util.Pos2d;

public class PhysicsEntity extends BasicGameEntity{

	private Force force;
	
	public void onCollider(PhysicsEntity entity, Pos2d position) {}
}
