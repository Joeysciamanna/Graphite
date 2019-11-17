package ch.g_7.graphite.entity.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector2ic;

import ch.g_7.graphite.core.window.ResizeAction;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.ui.dimension.ScreenDimension;

public class UIRootContainer extends UIContainer implements IUIRootContainer{

	private List<IUIPanel> childs;
	
	private Window window;
	
	public UIRootContainer(Window window) {
		this.window = window;
		this.window.addResizeListner(this);
		this.width.addPW(100);
		this.height.addPW(100);
		this.childs = new ArrayList<>();
	}
	
	@Override
	public void recalculate() {
		recalculate(window.getSize());
	}
	
	@Override
	protected void recalculateDimension(ScreenDimension dimension, Vector2ic screenSize) {
		dimension.recalculate(screenSize, new Vector2f(2, 2));
	}
	
	@Override
	public void requestDimensionRecalculation(IUIContainer container) {
		container.recalculate(window.getSize());
	}
	

	@Override
	public void onResize(ResizeAction action) {
		CompletableFuture.runAsync(() -> {
			recalculate(new Vector2i(action.getWidth(), action.getHeight()));
		});
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
