package ch.g_7.java2dengine.base.object;

import ch.g_7.java2dengine.base.view.AbstractViewModel;
import ch.g_7.java2dengine.util.Light;
import ch.g_7.java2dengine.util.Pos3d;

public class BasicGameEntity extends AbstractGameEntity{

	protected Pos3d position;
	protected float scale;
	protected boolean render = true;
	protected Light light;
	protected AbstractViewModel viewModel;
	protected float rotation;
	
	public BasicGameEntity() {
		this.light = new Light();
		this.position = new Pos3d();
		this.scale = 1;
	}
	
	public BasicGameEntity(Pos3d position, AbstractViewModel viewModel) {
		this.position = position;
		this.viewModel = viewModel;
		this.light = new Light();
		this.scale = 1;
	}

	@Override
	public Pos3d getPosition() {
		return position;
	}

	@Override
	public boolean render() {
		return render;
	}

	@Override
	public AbstractViewModel getViewModel() {
		return viewModel;
	}
	
	public void setPosition(Pos3d position) {
		this.position = position;
	}
	
	public void setRender(boolean render) {
		this.render = render;
	}
	
	public void setViewModel(AbstractViewModel viewModel) {
		this.viewModel = viewModel;
	}

	@Override
	public Light getLight() {
		return light;
	}

	public void setLight(Light light) {
		this.light = light;
	}

	@Override
	public float getScale() {
		return scale;
	}
	
	public void setScale(float scale) {
		this.scale = scale;
	}

	@Override
	public float getRotation() {
		return rotation;
	}
	
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
}
