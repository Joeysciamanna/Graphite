package ch.g_7.graphite.draw;


/*class DrawObject extends Resource implements IDrawObject {

	private ViewModel viewModel;
	private Transformation transformation;
	private int glDrawMethod = -1;

	public DrawObject() {
		this(new ViewModel(), new Transformation());
	}

	protected DrawObject(DrawObject drawObject) {
		this(drawObject.getViewModel().clone(), new Transformation());
	}

	protected DrawObject(ViewModel viewModel, Transformation transformation) {
		this.viewModel = viewModel;
		this.viewModel.setMesh(null);
		this.transformation = transformation;
	}
	

	public boolean isEmpty() {
		return viewModel.getMesh() == null || glDrawMethod == -1;
	}

	public void clean(){
		unbindFrom(viewModel);
		viewModel = new ViewModel();
		bindTo(viewModel);
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
	public void setZ(float z) {
		transformation.getPosition().z = z;
	}

	@Override
	protected void doInit() {
		bindTo(viewModel);
	}

	@Override
	protected void doClose() {
		unbindFrom(viewModel);
	}

}*/
