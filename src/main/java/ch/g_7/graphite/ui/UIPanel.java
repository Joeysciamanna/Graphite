package ch.g_7.graphite.ui;

import org.joml.Vector2ic;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.mesh.MeshBuilder2d;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.base.view_model.IViewModel;
import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.ui.util.ScreenDimension;
import ch.g_7.graphite.util.Color;

public class UIPanel extends UIContainer implements IUIPanel {

	private static IMesh SQUARE_MESH = MeshFactory2d.getSquare(1).setCenter(MeshBuilder2d.CENTER_TOP_LEFT).build();
	
	private ViewModel viewModel;
	
	protected final ScreenDimension maxWidth;
	protected final ScreenDimension maxHeight;
	
	protected final ScreenDimension minWidth;
	protected final ScreenDimension minHeight;
	
	protected final ScreenDimension preferedWidth;
	protected final ScreenDimension preferedHeight;
	
	private boolean resized = true;
	
	protected IUIContainer father;
	
	public UIPanel() {
		this.maxWidth = new ScreenDimension(ScreenDimension.X_AXIS).addPF(100);
		this.maxHeight = new ScreenDimension(ScreenDimension.Y_AXIS).addPF(100);
		
		this.minWidth = new ScreenDimension(ScreenDimension.X_AXIS);
		this.minHeight = new ScreenDimension(ScreenDimension.Y_AXIS);
		
		this.preferedWidth = new ScreenDimension(ScreenDimension.X_AXIS).addPF(100);
		this.preferedHeight = new ScreenDimension(ScreenDimension.Y_AXIS).addPF(100);
		
		this.viewModel = new ViewModel(SQUARE_MESH, null, Color.getColor(0, 0, 0));
	}
	

	@Override
	public void recalculate(Vector2ic screenSize, Vector2ic fatherSize) {
		if(resized) {
			recalculateDimension(maxWidth, screenSize);
			recalculateDimension(maxHeight, screenSize);
			recalculateDimension(minWidth, screenSize);
			recalculateDimension(minHeight, screenSize);
			recalculateDimension(preferedWidth, screenSize);
			recalculateDimension(preferedHeight, screenSize);
			
			recalculatePreferedSize();
		}
		
		super.recalculate(screenSize, fatherSize);
		transformation.getPosition().add(father.getTransformation().getPosition());
	}
	
	
	@Override
	public void recalculatePreferedSize() {
		this.width.reset();
		this.height.reset();
		
		if(preferedWidth.getValue() > maxWidth.getValue() || preferedWidth.getValue() < minWidth.getValue()) {
			if(preferedWidth.getValue()-maxWidth.getValue()>preferedWidth.getValue()-minWidth.getValue()) {
				width.add(minWidth);
			}else {
				width.add(maxWidth);
			}
		}else {
			width.add(preferedWidth);
		}
		if(preferedHeight.getValue() > maxHeight.getValue() || preferedHeight.getValue() < minHeight.getValue()) {
			if(preferedHeight.getValue()-maxHeight.getValue()>preferedHeight.getValue()-minHeight.getValue()) {
				height.add(minHeight);
			}else {
				height.add(maxHeight);
			}
		}else {
			height.add(preferedHeight);
		}
	}
	
	@Override
	protected void doInit() {
		viewModel.init();
		super.doInit();
	}
	
	@Override
	protected void doClose() {
		viewModel.init();
		super.doClose();
	}
	
	@Override
	protected void recalculateDimension(ScreenDimension dimension, Vector2ic screenSize) {
		dimension.recalculate(screenSize, getFather().getTransformation().getIntScale2d());
	}
	

	
	@Override
	public final void requestRecalculation(IUIContainer container) {
		if(getFather()!=null) {
			getFather().requestRecalculation(container);
		}
	}
	
	
	@Override
	public void recalculate() {
		requestRecalculation(this);
	}
	
	@Override
	public IViewModel getViewModel() {
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
	public Window getWindow() {
		return getFather() == null ? null : father.getWindow();
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
	
	@Override
	public ScreenDimension getMaxWidth() {
		resized = true;
		return maxWidth;
	}


	@Override
	public ScreenDimension getMaxHeight() {
		resized = true;
		return maxHeight;
	}


	@Override
	public ScreenDimension getMinWidth() {
		resized = true;
		return minWidth;
	}


	@Override
	public ScreenDimension getMinHeight() {
		resized = true;
		return minHeight;
	}


	@Override
	public ScreenDimension getPreferedWidth() {
		resized = true;
		return preferedWidth;
	}


	@Override
	public ScreenDimension getPreferedHeight() {
		resized = true;
		return preferedHeight;
	}

}
