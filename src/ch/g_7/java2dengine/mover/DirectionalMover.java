package ch.g_7.java2dengine.mover;

import ch.g_7.java2dengine.base.object.BasicGameEntity;
import ch.g_7.java2dengine.process.Process;
import ch.g_7.java2dengine.util.Dimension2d;
import ch.g_7.java2dengine.util.Pos3d;

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
