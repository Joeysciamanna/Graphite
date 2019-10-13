package ch.g_7.graphite.ingame.ui;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2ic;

public abstract class UIContainer implements IUIContainer{

	protected ScreenDimension width;
	protected ScreenDimension height;
	protected Vector2f size;
	
	protected ScreenDimension x;
	protected ScreenDimension y;
	protected Vector2f position;
	
	protected boolean visible;
	
	
	public UIContainer() {
		this.width = new ScreenDimension();
		this.height = new ScreenDimension();
		this.x = new ScreenDimension();
		this.y = new ScreenDimension();
		this.size = new Vector2f(1, 1);
		this.position = new Vector2f(0, 0);
		this.visible = true;
	}
	
	@Override
	public void recalculate(Vector2ic screenSize) {
		recalculateDimension(width, screenSize, ScreenDimension.X_AXIS);
		recalculateDimension(height, screenSize, ScreenDimension.Y_AXIS);
		
		recalculateDimension(x, screenSize, ScreenDimension.X_AXIS);
		recalculateDimension(y, screenSize, ScreenDimension.Y_AXIS);
		
		this.size = new Vector2f(width.getValue(), height.getValue());
		this.position = new Vector2f(x.getValue(), y.getValue());
		
		for (IUIPanel child : getChilds()) {
			child.recalculate(screenSize);
		}
	}
	
	protected abstract void recalculateDimension(ScreenDimension dimension, Vector2ic screenSize, byte axis);
	
	@Override
	public void close() {
		for (IUIPanel panel : getChilds()) {
			panel.close();
		}
	}

	@Override
	public void init() {
		for (IUIPanel panel : getChilds()) {
			panel.init();
		}
	}
	
	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public Vector2fc getSize() {
		return size;
	}

	public ScreenDimension getWidth() {
		return width;
	}
	
	public ScreenDimension getHeight() {
		return height;
	}
	
	@Override
	public Vector2fc getPosition() {
		return position;
	}

	public ScreenDimension getX() {
		return x;
	}
	
	public ScreenDimension getY() {
		return y;
	}
}
