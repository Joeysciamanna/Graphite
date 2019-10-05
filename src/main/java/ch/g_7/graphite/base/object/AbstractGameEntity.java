package ch.g_7.graphite.base.object;

import ch.g_7.graphite.base.view.AbstractViewModel;
import ch.g_7.graphite.util.Light;
import ch.g_7.graphite.util.Pos3d;

public abstract class AbstractGameEntity {

	public abstract Pos3d getPosition();
	
	public abstract boolean render();
	
	public abstract Light getLight();
	
	public abstract AbstractViewModel getViewModel();
	
	public abstract float getScale();
	
	public abstract float getRotation();
	
	public void close() {
		if(getViewModel()!=null) {
			getViewModel().close();
		}
	}
}
