package ch.g_7.graphite.draw;

import ch.g_7.graphite.node.RenderCluster;
import ch.g_7.graphite.rendering.draw.DrawRenderer;

public class Canvas extends RenderCluster<Drawable, DrawRenderer> {

	
	public Canvas() {
		super(new DrawRenderer(), "DRAWABLES");
	}

	@Override
	public void init() {
	
	}

	@Override
	public void close() {
		
	}

	@Override
	public void update(double deltaMillis) {
		// TODO Auto-generated method stub
		
	}

} 
