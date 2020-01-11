package ch.g_7.graphite.ui;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2i;
import org.joml.Vector2ic;

import ch.g_7.graphite.ui.util.ScreenDimension;
import ch.g_7.graphite.util.ResourceHandler;

public abstract class UIContainer implements IUIContainer {

	protected List<IUIPanel> childs;

	protected final ScreenDimension width;
	protected final ScreenDimension height;
	protected final Vector2i size;

	protected final ScreenDimension x;
	protected final ScreenDimension y;
	protected final Vector2i position;

	protected boolean visible;

	public UIContainer() {
		this.width = new ScreenDimension(ScreenDimension.X_AXIS);
		this.height = new ScreenDimension(ScreenDimension.Y_AXIS);
		this.size = new Vector2i();
		this.x = new ScreenDimension(ScreenDimension.X_AXIS);
		this.y = new ScreenDimension(ScreenDimension.Y_AXIS);
		this.position = new Vector2i();
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
	public void recalculate(Vector2ic screenSize, Vector2ic fatherSize) {
		recalculateDimension(width, screenSize);
		recalculateDimension(height, screenSize);
		size.set(width.getValue(), height.getValue());
		recalculateDimension(x, screenSize);
		recalculateDimension(y, screenSize);
		position.set(x.getValue(), y.getValue());
		for (IUIPanel child : getChilds()) {
			child.recalculate(screenSize, fatherSize);
		}

	}

	protected abstract void recalculateDimension(ScreenDimension dimension, Vector2ic screenSize);

	@Override
	public final void init() {
		if(ResourceHandler.shallInitialize(this)) doInit();
	}
	
	protected void doInit() {}
	
	@Override
	public final void close() {
		if(ResourceHandler.shallInitialize(this)) doClose();
	}

	protected void doClose() {
		for (IUIPanel panel : getChilds()) {
			panel.close();
		}
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
	public Vector2ic getSize() {
		return size;
	}

	@Override
	public Vector2ic getPosition() {
		return position;
	}

}
