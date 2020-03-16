package ch.g_7.graphite.ui;//package ch.g_7.graphite.ui;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.joml.Vector2i;
//import org.joml.Vector2ic;
//
//import ch.g_7.graphite.ui.util.ScreenDimension;
//
//public abstract class UIContainer implements IUIContainer {
//
//	protected List<IUIPanel> childs;
//
//	protected final ScreenDimension width;
//	protected final ScreenDimension height;
//
//	protected final ScreenDimension x;
//	protected final ScreenDimension y;
//
//	protected final Transformation2d transformation;
//
//	protected boolean visible;
//
//	public UIContainer() {
//		this.transformation = new Transformation2d(-1);
//
//		this.width = new ScreenDimension(ScreenDimension.X_AXIS);
//		this.height = new ScreenDimension(ScreenDimension.Y_AXIS);
//
//		this.x = new ScreenDimension(ScreenDimension.X_AXIS);
//		this.y = new ScreenDimension(ScreenDimension.Y_AXIS);
//
//		this.visible = true;
//		this.childs = new ArrayList<>();
//	}
//
//	@Override
//	public List<IUIPanel> getChilds() {
//		return childs;
//	}
//
//	protected void add(IUIPanel panel) {
//		childs.add(panel);
//		panel.setFather(this);
//		panel.init();
//	}
//
//	protected void remove(IUIPanel panel) {
//		childs.remove(panel);
//		panel.setFather(null);
//	}
//
//	protected void clear() {
//		for (IUIPanel child : childs) {
//			child.setFather(null);
//		}
//		childs.clear();
//	}
//
//	@Override
//	public void recalculate(Vector2ic screenSize, Vector2ic fatherSize) {
//		recalculateDimension(width, screenSize);
//		recalculateDimension(height, screenSize);
//		transformation.setScale(width.getValue(), height.getValue());
//		recalculateDimension(x, screenSize);
//		recalculateDimension(y, screenSize);
//		transformation.setPosition(x.getValue(), y.getValue());
//		for (IUIPanel child : getChilds()) {
//			child.recalculate(screenSize, fatherSize);
//		}
//
//	}
//
//	protected abstract void recalculateDimension(ScreenDimension dimension, Vector2ic screenSize);
//
//
//	@Override
//	public boolean isVisible() {
//		return visible;
//	}
//
//	public void setVisible(boolean visible) {
//		this.visible = visible;
//	}
//
//	@Override
//	public Transformation2d getTransformation() {
//		return transformation;
//	}
//
//	@Override
//	public Vector2i getPosition() {
//		return transformation.getIntPosition2d();
//	}
//
//	@Override
//	public Vector2i getSize() {
//		return transformation.getIntScale2d();
//	}
//
//	@Override
//	public ScreenDimension getWidth() {
//		return width;
//	}
//
//	@Override
//	public ScreenDimension getHeight() {
//		return height;
//	}
//
//	@Override
//	public ScreenDimension getX() {
//		return x;
//	}
//
//	@Override
//	public ScreenDimension getY() {
//		return y;
//	}
//
//}
