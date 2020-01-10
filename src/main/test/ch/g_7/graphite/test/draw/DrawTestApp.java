package ch.g_7.graphite.test.draw;

import ch.g_7.graphite.core.Application;
import ch.g_7.graphite.core.RenderType;

public class DrawTestApp extends Application {

	public DrawTestApp() {
		super("Draw App Name");
	}
	
	public static void main(String[] args) {
		new DrawTestApp().start();
	}

	@Override
	protected void init() {
		
		SquareObject object1 = new SquareObject();
		
		getDimension().addObj(object1, RenderType.DRAWABLE);

		getWindow().setVisible(true);
		getWindow().setSize(500, 500);
	}

}
