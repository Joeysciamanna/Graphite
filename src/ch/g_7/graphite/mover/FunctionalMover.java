package ch.g_7.graphite.mover;

import ch.g_7.graphite.base.object.BasicGameEntity;
import ch.g_7.graphite.process.Process;
import ch.g_7.graphite.util.Dimension2d;
import ch.g_7.graphite.util.Pos2d;
import ch.g_7.graphite.util.Pos3d;

public class FunctionalMover extends AbstractMover{

	Process<Pos2d, Pos2d> function;
	
	public FunctionalMover(Process<Pos2d, Pos2d> function, BasicGameEntity entity) {
		super(entity);
		this.function = function;
	}

	@Override
	public void move() {
		Pos3d oldPos = entity.getPosition();
		Pos2d newPos = function.run(new Pos2d(oldPos.getX(), oldPos.getY()));
		entity.setPosition(new Pos3d(newPos.getX(), newPos.getY(), oldPos.getZ()));
	}
}
