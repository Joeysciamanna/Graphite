package ch.g_7.graphite.ui;//package ch.g_7.graphite.ui;

import java.util.concurrent.CompletableFuture;

import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.rendering.IUIViewIdentifier;
import ch.g_7.graphite.ui.transform.IUITransform;
import ch.g_7.graphite.ui.transform.SimpleUITransform;
import org.joml.Vector2i;

import ch.g_7.graphite.core.window.ResizeEvent;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.ui.util.MouseManager;

public class UIRootContainer extends UIContainer implements IUIRootContainer {

	private final IUIViewIdentifier<?> id;
	private final Window window;
	private final MouseManager mouseManager;
	private final SimpleUITransform transform;

	public UIRootContainer(Window window, IUIViewIdentifier<?> id) {
		this.id = id;
		this.window = window;
		this.mouseManager = new MouseManager();
		this.window.addResizeListner(this);
		this.window.addMouseListner(mouseManager);
		this.transform = new SimpleUITransform();
		this.transform.getHeight().addPW(100);
		this.transform.getHeight().addPW(100);
	}

	@Override
	public void onAction(ResizeEvent action) {
		CompletableFuture.runAsync(() -> {
			Vector2i size = new Vector2i(action.getWidth(), action.getHeight());
			recalculate(size, size);
		});
	}

	@Override
	public void update(float deltaMillis) { }

	@Override
	public void recalculate() {
		recalculate(window.getSize(), window.getSize());
	}


	@Override
	public void requestRecalculation(IUIContainer container) {
		container.recalculate(window.getSize(), window.getSize());
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
	public void init() { }

	@Override
	public void close() {
		window.removeResizeListner(this);
	}

	@Override
	public IUITransform getTransform() {
		return transform;
	}

	@Override
	public IViewModel getViewModel() {
		return null;
	}

	@Override
	public IUIViewIdentifier<?> getId() {
		return id;
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

