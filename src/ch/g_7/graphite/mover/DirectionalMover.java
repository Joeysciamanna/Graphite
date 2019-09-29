package ch.g_7.graphite.mover;

import ch.g_7.graphite.base.object.BasicGameEntity;
import ch.g_7.graphite.process.Process;
import ch.g_7.graphite.util.Dimension2d;
import ch.g_7.graphite.util.Pos3d;

public class DirectionalMover extends AbstractMover{

	private Dimension2d dimension;
	
	public DirectionalMover(Dimension2d dimension, BasicGameEntity entity) {
		super(entity);
		this.dimension = dimension;
	}

	@Override
	public void move() {
		translate(dimension);
	}

}
