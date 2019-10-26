package ch.g_7.graphite.entity.ui.dimension;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

public class SimpleScreenDimension extends AbstractScreenDimension{
	
	public static final byte X_AXIS = 0;
	public static final byte Y_AXIS = 1;
	
	
	private List<SimpleScreenDimension> adds;
	private List<SimpleScreenDimension> removes;
	
	private float pf;
	private float pw;
	private int pixel;
	
	private float value;
	
	public SimpleScreenDimension(float value) {
		this.value = value;
		this.adds = new ArrayList<>();
		this.removes = new ArrayList<>();
	}
	
	public SimpleScreenDimension() {
		this(0);
	}

	@Override
	public float getValue() {
		return value;
	}

	@Override
	protected void setValue(int value) {
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
		return pw;
	}

	@Override
	protected float getPF() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected float setPF(float pf) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected List<IScreenDimension> getAdds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<IScreenDimension> getRems() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	
}
