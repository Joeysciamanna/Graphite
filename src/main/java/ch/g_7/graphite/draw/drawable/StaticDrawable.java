package ch.g_7.graphite.draw.drawable;

import ch.g_7.graphite.draw.DrawContext;

public abstract class StaticDrawable extends BasicDrawable {

	private DrawContext drawContext;

	@Override
	public final DrawContext draw() {
		return drawContext;
	}


}
