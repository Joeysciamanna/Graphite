package ch.g_7.graphite.draw;

public abstract class StaticDrawable extends BasicDrawable {

	private DrawContext drawContext;

	@Override
	public final DrawContext draw() {
		return drawContext;
	}


}
