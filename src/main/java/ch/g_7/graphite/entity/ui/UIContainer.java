package ch.g_7.graphite.entity.ui;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2ic;

import ch.g_7.graphite.entity.ui.util.ScreenDimension;

public abstract class UIContainer implements IUIContainer {

	protected List<IUIPanel> childs;

	protected final ScreenDimension width;
	protected final ScreenDimension height;
	protected final Vector2f size;

	protected final ScreenDimension x;
	protected final ScreenDimension y;
	protected final Vector2f position;

	protected boolean visible;

	public UIContainer() {
		this.width = new ScreenDimension(ScreenDimension.X_AXIS);
		this.height = new ScreenDimension(ScreenDimension.Y_AXIS);
		this.size = new Vector2f();
		this.x = new ScreenDimension(ScreenDimension.X_AXIS);
		this.y = new ScreenDimension(ScreenDimension.Y_AXIS);
		this.position = new Vector2f();
		this.visible = true;
		this.childs = new ArrayList<>();
	}

	@Override
	public List<IUIPanel> getChilds() {
		return childs;
	}

	protected void add(IUIPanel panel) {
		childs.add(panel);
		panel.setFather(this);
		panel.init();
	}

	protected void remove(IUIPanel panel) {
		childs.remove(panel);
		panel.close();
		panel.setFather(null);
	}

	protected void clear() {
		for (IUIPanel child : childs) {
			child.close();
			child.setFather(null);
		}
		childs.clear();
	}

	@Override
	public void recalculate(Vector2ic screenSize) {

		recalculateDimension(width, screenSize);
		recalculateDimension(height, screenSize);
		size.set(width.getValue(), height.getValue());
		recalculateDimension(x, screenSize);
		recalculateDimension(y, screenSize);
		position.set(x.getValue(), y.getValue());
		for (IUIPanel child : getChilds()) {
			child.recalculate(screenSize);
		}

	}

	protected abstract void recalculateDimension(ScreenDimension dimension, Vector2ic screenSize);

	@Override
	public void close() {
		for (IUIPanel panel : getChilds()) {
			panel.close();
		}
	}


	@Override
	public void init() {
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public ScreenDimension getWidth() {
		return width;
	}

	@Override
	public ScreenDimension getHeight() {
		return height;
	}

	@Override
	public ScreenDimension getX() {
		return x;
	}

	@Override
	public ScreenDimension getY() {
		return y;
	}

	@Override
	public Vector2fc getSize() {
		return size;
	}

	@Override
	public Vector2fc getPosition() {
		return position;
	}

}
