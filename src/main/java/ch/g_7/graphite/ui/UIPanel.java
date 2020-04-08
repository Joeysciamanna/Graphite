package ch.g_7.graphite.ui;//package ch.g_7.graphite.ui;

import ch.g_7.graphite.ui.transform.AdvancedUITransform;
import org.joml.Vector2ic;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.mesh.MeshBuilder2d;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.graphite.ui.util.ScreenDimension;
import ch.g_7.graphite.util.Color;

public class UIPanel extends UIContainer implements IUIPanel {

	private static IMesh SQUARE_MESH = ResourceManager.getActive().allocateFromEngine(MeshFactory2d.getSquare(1).setCenter(MeshBuilder2d.CENTER_TOP_LEFT).build());

	private final AdvancedUITransform transform;

	private ViewModel viewModel;


	private boolean resized = true;

	protected IUIContainer father;

	public UIPanel() {
		this.transform = new AdvancedUITransform();
		this.viewModel = new ViewModel(SQUARE_MESH, null, Color.TRANSPARENT);
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
	public void close() {
	}




	@Override
	public ViewModel getViewModel() {
		return viewModel;
	}

	@Override
	public final void setFather(IUIContainer father) {
		this.father = father;
	}

	public IUIContainer getFather() {
		return father;
	}

	@Override
	public IUIRootContainer getRootContainer() {
		return getFather() == null ? null : father.getRootContainer();
	}

	@Override
	public void setColor(Color color) {
		viewModel.setColor(color);
	}

	@Override
	public void setTexture(ITexture texture) {
		viewModel.setTexture(texture);
	}

}
