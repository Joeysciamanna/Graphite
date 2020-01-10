package ch.g_7.graphite.draw;

import ch.g_7.graphite.rendering.RenderCluster;
import ch.g_7.graphite.rendering.draw.DrawRenderer;

public class Canvas extends RenderCluster<Drawable, DrawRenderer> {

	public Canvas() {
		super(new DrawRenderer(), "DRAWABLES");
	}

	
	@Override
	public void init() {
		foreach((d)->d.initDrawContext(new DrawContext()));
		super.init();
	}
	
	
	@Override
	public void addNode(Drawable node) {
		node.initDrawContext(new DrawContext());
		super.addNode(node);
	}
	


} 
