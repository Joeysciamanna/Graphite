package ch.g_7.graphite.physics2d;

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
			IBody body1 = bodies.get(i);
			Vector3fc max = body1.getMaxPoint();
			Vector3fc min = body1.getMinPoint();
			for (int j = i + 1; j < bodies.size(); j++) {
				IBody body2 = bodies.get(j);
				for (Vector3fc point :body2.getPoints()) {
					if(point.x() < max.x() && point.y() < max.y() && point.z() < max.z() &&
							point.x() > min.x() && point.y() > min.y() && point.z() > min.z()) {
						Vector3fc = body1.getForce().
					}
				}
				// compare list.get(i) and list.get(j)
			}
		}
		;
		return arg0;
	}
}
