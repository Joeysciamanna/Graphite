package ch.g_7.graphite.physics;

import java.util.List;

import org.joml.Vector3fc;

import ch.g_7.util.task.Task;
import ch.g_7.util.task.TaskCallBuffer;

public class PhysicsCalculator implements Task<Void, Void> {

	private List<IBody> bodies;

	public PhysicsCalculator(ColissionClass colissionClass) {
		this.bodies = colissionClass.getBodies();
	}

	@Override
	public Void run(Void arg0) {
		for (int i = 0; i < bodies.size(); i++) {
			for (int j = i + 1; j < bodies.size(); j++) {
				for (Vector3fc point : bodies.get(i).getPoints()) {
					
				}
				// compare list.get(i) and list.get(j)
			}
		}
		;
		return arg0;
	}
}
