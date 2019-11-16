package ch.g_7.graphite.entity.ui;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2f;
import org.joml.Vector2ic;

import ch.g_7.graphite.core.window.ResizeAction;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.ui.dimension.SimpleScreenDimension;
import ch.g_7.graphite.entity.ui.dimension.ScreenDimension2d;

public class UIRootContainer extends UIContainer implements IUIRootContainer{

	private List<IUIPanel> childs;
	
	private Window window;
	
	public UIRootContainer(Window window) {
		this.window = window;
		this.window.addResizeListner(this);
		this.size.addPW(100);
		this.childs = new ArrayList<>();
	}
	
	@Override
	public void recalculate() {
		recalculateDimensions(window.getSize());
	}
	
	@Override
	protected void recalculateDimension(SimpleScreenDimension dimension, Vector2ic screenSize, byte axis) {
		dimension.recalculate(screenSize, new Vector2f(2, 2), axis);
	}
	
	@Override
	protected void recalculateDimension(ScreenDimension2d dimension, Vector2ic screenSize) {
		dimension.recalculate(screenSize, new Vector2f(2, 2));
	}
	
	@Override
	public void requestDimensionRecalculation(IUIContainer container) {
		container.recalculateDimensions(window.getSize());
	}
	
	@Override
	public void onResize(ResizeAction action) {
		recalculate();
	}
	
	@Override
	public List<IUIPanel> getChilds() {
		return childs;
	}
	
	@Override
	public void add(IUIPanel panel) {
		childs.add(panel);
		panel.setFather(this);
	}
	
	@Override
	public void remove(IUIPanel panel) {
		childs.remove(panel);
	}
	
	@Override
	public void close() {
		window.removeResizeListner(this);
		super.close();
	}

	@Override
	public Window getWindow() {
		return window;
	}


}
