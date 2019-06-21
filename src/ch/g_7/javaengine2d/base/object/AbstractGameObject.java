package ch.g_7.javaengine2d.base.object;

import ch.g_7.javaengine2d.base.view.AbstractViewModel;
import ch.g_7.javaengine2d.util.Light;
import ch.g_7.javaengine2d.util.Pos3d;

public abstract class AbstractGameObject {

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
