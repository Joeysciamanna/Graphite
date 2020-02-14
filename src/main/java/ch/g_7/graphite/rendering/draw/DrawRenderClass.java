package ch.g_7.graphite.rendering.draw;

import ch.g_7.graphite.draw.DrawContext2d;
import ch.g_7.graphite.draw.drawable.Drawable;
import ch.g_7.graphite.rendering.RenderClass;

public class DrawRenderClass<T extends Drawable> extends RenderClass<T, DrawRenderer>{

	public DrawRenderClass(String name) {
		super(new DrawRenderer(), name);
	}

	@Override
	public void update(float deltaMillis) {
		nodes.forEach((u)->u.update(deltaMillis));
	}
	
	@Override
	protected void doInit() {
		nodes.forEach((d)->d.initDrawContext(new DrawContext2d()));
		super.doInit();
	}
	
	@Override
	public void addNode(T node) {
		node.initDrawContext(new DrawContext2d());
		super.addNode(node);
	}
}
