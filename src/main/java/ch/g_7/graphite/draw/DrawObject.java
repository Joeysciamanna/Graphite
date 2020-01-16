package ch.g_7.graphite.draw;

import ch.g_7.graphite.base.transformation.Transformation;
import ch.g_7.graphite.base.view_model.ViewModel;
import ch.g_7.util.resource.IDepender;
import ch.g_7.util.resource.Resource;

class DrawObject extends Resource implements IDrawObject, IDepender {

	private ViewModel viewModel;
	private Transformation transformation;
	private int glDrawMethod = -1;

	protected DrawObject(DrawObject drawObject) {
		this(drawObject.getViewModel(), new Transformation());
	}

	protected DrawObject(ViewModel viewModel, Transformation transformation) {
		this.viewModel = viewModel.clone();
		this.viewModel.setMesh(null);
		this.transformation = transformation;
	}
	
	public DrawObject() {
		this(new ViewModel(), new Transformation());
	}

	public boolean isEmpty() {
		return viewModel.getMesh() == null || glDrawMethod == -1;
	}

	@Override
	public int getGLDrawMethod() {
		return glDrawMethod;
	}

	public void setGLDrawMethod(int glDrawMethod) {
		this.glDrawMethod = glDrawMethod;
	}

	@Override
	public ViewModel getViewModel() {
		return viewModel;
	}

	@Override
	public Transformation getTransformation() {
		return transformation;
	}

	@Override
	protected void doInit() {
		if(viewModel!=null) viewModel.bind(this);
	}

	@Override
	protected void doClose() {
		if(viewModel!=null) viewModel.unbind(this);
	}

}
