package ch.g_7.graphite.ui;//package ch.g_7.graphite.ui;

import java.util.ArrayList;
import java.util.List;

import ch.g_7.graphite.base.transformation.Transform;
import org.joml.Vector2i;
import org.joml.Vector2ic;

import ch.g_7.graphite.ui.util.ScreenDimension;

public abstract class UIContainer implements IUIContainer {

	protected final List<IUIPanel> children;

	protected final Transform transformation;

	protected final ScreenDimension width;
	protected final ScreenDimension height;

	protected final ScreenDimension x;
	protected final ScreenDimension y;



	protected boolean visible;

	public UIContainer() {
		this.children = new ArrayList<>();
		this.transformation = new Transform();

		this.width = new ScreenDimension(ScreenDimension.X_AXIS);
		this.height = new ScreenDimension(ScreenDimension.Y_AXIS);

		this.x = new ScreenDimension(ScreenDimension.X_AXIS);
		this.y = new ScreenDimension(ScreenDimension.Y_AXIS);

		this.visible = true;

	}

	@Override
	public List<IUIPanel> getChildren() {
		return children;
	}

	protected void add(IUIPanel panel) {
		children.add(panel);
		panel.setFather(this);
		panel.init();
	}

	protected void remove(IUIPanel panel) {
		children.remove(panel);
		panel.setFather(null);
	}

	protected void clear() {
		for (IUIPanel child : children) {
			child.setFather(null);
		}
		children.clear();
	}

	@Override
	public void recalculate(Vector2ic screenSize, Vector2ic fatherSize) {
		recalculateDimension(width, screenSize);
		recalculateDimension(height, screenSize);
		transformation.setScale(width.getValue(), height.getValue());
		recalculateDimension(x, screenSize);
		recalculateDimension(y, screenSize);
		transformation.setPosition(x.getValue(), y.getValue());
		for (IUIPanel child : getChilds()) {
			child.recalculate(screenSize, fatherSize);
		}

	}

	protected abstract void recalculateDimension(ScreenDimension dimension, Vector2ic screenSize);


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

}
