package ch.g_7.graphite.core;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.node.Updatable;
import ch.g_7.util.common.Loop;

public class UpdateLoop extends Loop {

	private List<Updatable> updatables;
	
	public UpdateLoop() {
		this.updatables = new ArrayList<Updatable>();
	}

	@Override
	public void run(float deltaMillis) {
		for (Updatable updatable : updatables) {
			updatable.update(deltaMillis);
		}
	}
	
	public void add(Updatable updatable) {
		updatables.add(updatable);
	}
	
	public void remove(Updatable updatable) {
		updatables.remove(updatable);
	}
	

}
