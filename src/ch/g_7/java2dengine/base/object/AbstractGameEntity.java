package ch.g_7.java2dengine.base.object;

import ch.g_7.java2dengine.base.view.AbstractViewModel;
import ch.g_7.java2dengine.util.Light;
import ch.g_7.java2dengine.util.Pos3d;

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
