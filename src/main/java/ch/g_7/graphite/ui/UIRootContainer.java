package ch.g_7.graphite.ui;//package ch.g_7.graphite.ui;

import java.util.concurrent.CompletableFuture;

import ch.g_7.graphite.base.transformation.IROTransform;
import ch.g_7.graphite.base.transformation.ITransform;
import ch.g_7.graphite.node.IViewModel;
import org.joml.Vector2i;
import org.joml.Vector2ic;

import ch.g_7.graphite.core.window.ResizeEvent;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.ui.util.MouseManager;
import ch.g_7.graphite.ui.util.ScreenDimension;

public class UIRootContainer extends UIContainer implements IUIRootContainer {

	private final Window window;
	private final MouseManager mouseManager;
	private final UITransform transform;

	public UIRootContainer(Window window) {
		this.window = window;
		this.mouseManager = new MouseManager();
		this.window.addResizeListner(this);
		this.window.addMouseListner(mouseManager);
		this.transform = new UITransform();
		this.transform.getHeight().addPW(100);
		this.transform.getHeight().addPW(100);
	}

	@Override
	public void recalculate() {
		recalculate(window.getSize(), window.getSize());
	}

	@Override
	protected void recalculateDimension(ScreenDimension dimension, Vector2ic screenSize) {
		dimension.recalculate(screenSize, screenSize);
	}

	@Override
	public void requestRecalculation(IUIContainer container) {
		container.recalculate(window.getSize(), window.getSize());
	}

	@Override
	public void onAction(ResizeEvent action) {
		CompletableFuture.runAsync(() -> {
			Vector2i size = new Vector2i(action.getWidth(), action.getHeight());
			recalculate(size, size);
		});
	}

	@Override
	public ScreenDimension getWidth() {
		return transform.getWidth();
	}

	@Override
	public ScreenDimension getHeight() {
		return transform.getHeight();
	}

	@Override
	public ScreenDimension getX() {
		return transform.getX();
	}

	@Override
	public ScreenDimension getY() {
		return transform.getY();
	}

	@Override
	public IROTransform getTransform() {
		return transform;
	}


	@Override
	public IViewModel getViewModel() {
		return null;
	}

	@Override
	public void init() {

	}

	@Override
	public void close() {
		window.removeResizeListner(this);
	}

	@Override
	public void add(IUIPanel panel) {
		super.add(panel);
	}

	@Override
	public void remove(IUIPanel panel) {
		super.remove(panel);
	}

	@Override
	public void clear() {
		super.clear();
	}

	@Override
	public Window getWindow() {
		return window;
	}

	@Override
	public IUIRootContainer getRootContainer() {
		return this;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}



}

