package ch.g_7.graphite.ui;

import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.ui.transform.AdvancedUITransform;
import ch.g_7.graphite.ui.transform.IUITransform;
import ch.g_7.graphite.ui.util.ScreenDimension;
import ch.g_7.graphite.ui.view_model.UIViewModel;
import ch.g_7.graphite.util.Color;

public class UIPanel extends UIContainer implements IUIPanel {

	private final AdvancedUITransform transform;

	private UIViewModel viewModel;

	protected IUIContainer father;

	public UIPanel() {
		this.transform = new AdvancedUITransform();
		this.viewModel = new UIViewModel(Color.TRANSPARENT);
	}


	@Override
	public void recalculate() {
		requestRecalculation(this);
	}

	@Override
	public final void requestRecalculation(IUIContainer container) {
		if(getFather()!=null) {
			getFather().requestRecalculation(container);
		}
	}

	@Override
	public void init() { }

	@Override
	public void close() { }

	@Override
	public final void setFather(IUIContainer father) {
		this.father = father;
	}

	public IUIContainer getFather() {
		return father;
	}

	@Override
	public UIViewModel getViewModel() {
		return viewModel;
	}

	@Override
	public void setColor(Color color) {
		viewModel.setColor(color);
	}

	@Override
	public void setTexture(ITexture texture) {
		viewModel.setTexture(texture);
	}

	@Override
	public boolean isVisible() {
		return false;
	}

	@Override
	public void setVisible(boolean visible) {
		viewModel.setVisible(visible);
	}

	@Override
	public IUITransform getTransform() {
		return transform;
	}

	@Override
	public IUIRootContainer getRootContainer() {
		return getFather() == null ? null : father.getRootContainer();
	}


	@Override
	public ScreenDimension getWidth() {
		return transform.getPreferredWidth();
	}

	@Override
	public ScreenDimension getHeight() {
		return transform.getPreferredHeight();
	}

	@Override
	public ScreenDimension getMinWidth() {
		return transform.getMinWidth();
	}

	@Override
	public ScreenDimension getMinHeight() {
		return transform.getMinHeight();
	}

	@Override
	public ScreenDimension getMaxWidth() {
		return transform.getMaxWidth();
	}

	@Override
	public ScreenDimension getMaxHeight() {
		return transform.getMaxHeight();
	}

	@Override
	public ScreenDimension getX() {
		return transform.getX();
	}

	@Override
	public ScreenDimension getY() {
		return transform.getY();
	}
}
