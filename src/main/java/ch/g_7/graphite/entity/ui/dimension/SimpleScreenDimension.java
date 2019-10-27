package ch.g_7.graphite.entity.ui.dimension;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

public class SimpleScreenDimension extends AbstractScreenDimension{
	
	public static final byte X_AXIS = 0;
	public static final byte Y_AXIS = 1;
	
	
	private List<IROScreenDimension> adds;
	private List<IROScreenDimension> rems;
	
	private float pf;
	private float pw;
	private int pixel;
	
	private float value;
	
	public SimpleScreenDimension(float value) {
		this.value = value;
		this.adds = new ArrayList<>();
		this.rems = new ArrayList<>();
	}
	
	public SimpleScreenDimension() {
		this(0);
	}

	@Override
	public float getValue() {
		return value;
	}

	@Override
	protected void setValue(float value) {
		this.value = value;
	}

	@Override
	protected int getPixel() {
		return pixel;
	}

	@Override
	protected void setPixel(int pixel) {
		this.pixel = pixel;
	}

	@Override
	protected float getPW() {
		return pw;
	}

	@Override
	protected void setPW(float pw) {
		this.pw = pw;
	}

	@Override
	protected float getPF() {
		return pf;
	}

	@Override
	protected void setPF(float pf) {
		this.pf = pf;
	}

	@Override
	protected List<IROScreenDimension> getAdds() {
		return adds;
	}

	@Override
	protected List<IROScreenDimension> getRems() {
		return rems;
	}

	

	
	
}
