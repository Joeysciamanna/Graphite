package ch.g_7.graphite.draw.drawable;

import ch.g_7.graphite.draw.DrawContext;
import ch.g_7.util.resource.Resource;

public abstract class BasicDrawable extends Resource implements Drawable {

	private DrawContext drawContext;

	@Override
	public final DrawContext draw() {
		drawContext.clear();
		draw(drawContext);
		return drawContext;
	}

	@Override
	public final void initDrawContext(DrawContext drawContext) {
		this.drawContext = drawContext;
	}
	
	public abstract void draw(DrawContext drawContext);
	
	@Override
	public void update(float deltaMillis) {}


	@Override
	protected void doInit() {
		drawContext.bind(this);
	}
	
	@Override
	protected void doClose() {
		drawContext.unbind(this);
	}
	
	

}