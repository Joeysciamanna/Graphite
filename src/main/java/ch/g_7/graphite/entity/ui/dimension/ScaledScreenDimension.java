package ch.g_7.graphite.entity.ui.dimension;

import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

public class ScaledScreenDimension extends AbstractScreenDimension{

	
	private AbstractScreenDimension dimension;
	private float factor;

	public ScaledScreenDimension(AbstractScreenDimension dimension, float factor) {
		this.dimension = dimension;
		this.factor = factor;
	}
	
	
	public void setFactor(float factor) {
		this.factor = factor;
	}

	@Override
	public float getValue() {
		return dimension.getValue() * factor;
	}

	@Override
	protected void setValue(int value) {
		dimension.setValue(value);
	}

	@Override
	protected int getPixel() {
		return dimension.getPixel();
	}

	@Override
	protected void setPixel(int pixel) {
		dimension.setPixel(pixel);
	}

	@Override
	protected float getPW() {
		return dimension.getPW();
	}

	@Override
	protected void setPW(float pw) {
		dimension.setPW(pw);
	}

	@Override
	protected float getPF() {
		return dimension.getPF();
	}

	@Override
	protected void setPF(float pf) {
		dimension.setPF(pf);
	}

	@Override
	protected List<IROScreenDimension> getAdds() {
		return dimension.getAdds();
	}

	@Override
	protected List<IROScreenDimension> getRems() {
		return dimension.getRems();
	}

	
	
}
