package ch.g_7.graphite.draw.drawable;

import ch.g_7.graphite.draw.DrawContext;
import ch.g_7.util.resource.Resource;

public abstract class StaticDrawable extends Resource implements Drawable {

	private DrawContext drawContext;
	private boolean redraw = true;
	
	@Override
	public final DrawContext draw() {
		if(redraw) {
			drawContext.clear();
			draw(drawContext);
			redraw = false;
		}
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
	
	protected void requestRedraw() {
		this.redraw = true;
	}

}
