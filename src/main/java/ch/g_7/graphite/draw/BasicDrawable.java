package ch.g_7.graphite.draw;

public abstract class BasicDrawable implements Drawable {

	private DrawContext drawContext;

	@Override
	public DrawContext draw() {
		return drawContext;
	}

	@Override
	public final void initDrawContext(DrawContext drawContext) {
		this.drawContext = drawContext;
		draw(drawContext);
	}
	
	public abstract void draw(DrawContext drawContext);
	
	@Override
	public void update(double deltaMillis) {}
	
	@Override
	public void init() {}

	@Override
	public void close() {}

}
