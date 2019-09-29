package ch.g_7.graphite.mover;

import ch.g_7.graphite.base.object.BasicGameEntity;
import ch.g_7.graphite.core.Engine;
import ch.g_7.graphite.process.Process;
import ch.g_7.graphite.util.Dimension2d;
import ch.g_7.graphite.util.Pos3d;

public abstract class AbstractMover implements Process<Engine, Void>{

	protected BasicGameEntity entity;
	
	public AbstractMover(BasicGameEntity entity) {
		this.entity = entity;
	}
	
	protected void translate(Dimension2d dimension) {
		Pos3d oldPos = entity.getPosition();
		entity.setPosition(new Pos3d(oldPos.getX() + dimension.getWidth(), oldPos.getY() + dimension.getHeight(), oldPos.getZ()));
	}
	
	protected abstract void move();
	
	@Override
	public final Void run(Engine t) {
		move();
		return null;
	}
}
