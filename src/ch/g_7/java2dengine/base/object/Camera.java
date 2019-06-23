package ch.g_7.java2dengine.base.object;

import ch.g_7.java2dengine.render.AbstractRenderer;
import ch.g_7.java2dengine.util.Pos3d;

public class Camera {

	private AbstractRenderer renderer;
	
	private Pos3d position;
	
	public Camera(AbstractRenderer renderer) {
		this.renderer = renderer;
		this.position = new Pos3d();
	}
	
	public Camera() {}
	
	public Pos3d getPosition() {
		return position;
	}
	
	public AbstractRenderer getRenderer() {
		return renderer;
	}
	
	public void setRenderer(AbstractRenderer renderer) {
		this.renderer = renderer;
	}
}
