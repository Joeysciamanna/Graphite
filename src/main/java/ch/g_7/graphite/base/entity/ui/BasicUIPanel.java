package ch.g_7.graphite.base.entity.ui;

import org.joml.Vector2f;

import ch.g_7.graphite.base.viewmodel.IViewModel;

public class BasicUIPanel implements IUIPanel{

	private IViewModel viewModel;
	private Vector2f position;
	private double rotation;
	private double scale;
	
	
	public BasicUIPanel(IViewModel viewModel, Vector2f position, double rotation, double scale) {
		this.viewModel = viewModel;
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
	}

	public BasicUIPanel(IViewModel viewModel, Vector2f position) {
		this(viewModel, position, 0, 1);
	}
	
	@Override
	public IViewModel getViewModel() {
		return viewModel;
	}
	
	public void setViewModel(IViewModel viewModel) {
		this.viewModel = viewModel;
	}

	@Override
	public Vector2f getPosition() {
		return position;
	}
	
	public void setPosition(Vector2f position) {
		this.position = position;
	}

	@Override
	public double getRotation() {
		return rotation;
	}
	
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	@Override
	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}
}
