package ch.g_7.graphite.draw;

import ch.g_7.util.resource.ResourceHandler;

public abstract class BasicDrawable implements Drawable {

	private DrawContext drawContext;

	@Override
	public DrawContext draw() {
		drawContext.clear();
		draw(drawContext);
		return drawContext;
	}

	@Override
	public final void initDrawContext(DrawContext drawContext) {
		this.drawContext = drawContext;
		draw(drawContext);
	}
	
	public abstract void draw(DrawContext drawContext);
	
	@Override
	public void update(float deltaMillis) {}

	@Override
	public final void init() {
		if(ResourceHandler.shallInitialize(this)) doInit();
	}

	protected void doInit() {}
	
	@Override
	public final void close() {
		if(ResourceHandler.shallInitialize(this)) doClose();
	}
	
	protected void doClose() {}
	
	

}
