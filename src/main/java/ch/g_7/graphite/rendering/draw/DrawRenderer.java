package ch.g_7.graphite.rendering.draw;


/*public class DrawRenderer extends BasicRenderer<Drawable>{


	public DrawRenderer() {
		super(new BasicShaderProgram(Resources.DRAW_VERTEX_SHADER, Resources.DRAW_FRAGMENT_SHADER), new PixelTransformator());
	}

	@Override
	protected void render(List<? extends Drawable> drawables) {
		float layer = 0.9f;
		for (Drawable drawable : drawables) {
			for(IDrawObject drawObject : drawable.draw().getDrawObjects()) {
				drawObject.setZ(layer);
				render(drawObject, drawObject.getGLDrawMethod());
				layer-=0.01;
			}
		}
	}
	
	

}*/
