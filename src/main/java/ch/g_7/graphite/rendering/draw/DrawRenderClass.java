package ch.g_7.graphite.rendering.draw;

import ch.g_7.graphite.draw.DrawContext;
import ch.g_7.graphite.draw.drawable.Drawable;
import ch.g_7.graphite.rendering.RenderClass;

public class DrawRenderClass extends RenderClass<Drawable, DrawRenderer>{

	public DrawRenderClass() {
		super(new DrawRenderer(), "DRAW");
	}

	@Override
	public void update(float deltaMillis) {
		foreach((u)->u.update(deltaMillis));
	}
	
	@Override
	protected void doInit() {
		foreach((d)->d.initDrawContext(new DrawContext()));
		super.doInit();
	}
	
	@Override
	public void addNode(Drawable node) {
		node.initDrawContext(new DrawContext());
		super.addNode(node);
	}
}
