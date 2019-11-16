package ch.g_7.graphite.entity.ui.dimension;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

public class ScreenDimension implements IScreenDimension{

	public static final byte X_AXIS = 0;
	public static final byte Y_AXIS = 1;
	
	private List<IScreenDimension> adds;
	private List<IScreenDimension> rems;
	
	private float pf;
	private float pw;
	private int pixel;
	
	private float value;
	private byte axis;
	
	public ScreenDimension(float value, byte axis) {
		this.value = value;
		this.axis = axis;
		this.adds = new ArrayList<>();
		this.rems = new ArrayList<>();
	}
	
	public ScreenDimension(byte axis) {
		this(0, axis);
	}

	
	@Override
	public ScreenDimension recalculate(Vector2ic screenSize, Vector2fc fatherSize) {
		if(axis == X_AXIS) {
			recalculate(screenSize.x(), fatherSize.x());
		}else {
			recalculate(screenSize.y(), fatherSize.y());
		}
		return this;
	}
	
	@Override
	public ScreenDimension recalculate(int screenSize, float fatherSize) {
		float value = 0;
		value += (float) getPixel() * 2 / screenSize;
		value += fatherSize * (getPF() == 0 ? 0 : (getPF()/100));
		value += getPW() * 2 / 100;
		
		for (IScreenDimension screenDimension : getAdds()) {
			screenDimension.recalculate(screenSize, fatherSize);
			value += screenDimension.getValue();
		}
		for (IScreenDimension screenDimension : getRems()) {
			screenDimension.recalculate(screenSize, fatherSize);
			value -= screenDimension.getValue();
		}
		this.value = value;
		return this;
	}
	
	
	public ScreenDimension reset() {
		setPixel(0);
		setPW(0);
		setPF(0);
		value = 0;
		getAdds().clear();
		getRems().clear();
		return this;
	}
	
	
	public ScreenDimension add(IScreenDimension dimension) {
		getAdds().add(dimension);
		return this;
	}
	
	
	public ScreenDimension remove(IScreenDimension dimension) {
		getRems().add(dimension);
		return this;
	}
	
	
	public ScreenDimension addPF(float pf) {
		setPF(getPF()+pf);
		return this;
	}
	
	
	public ScreenDimension removePF(float pf) {
		setPF(getPF()-pf);
		return this;
	}
	
	
	public ScreenDimension addPW(float pw) {
		setPW(getPW()+pw);
		return this;
	}
	
	
	public ScreenDimension removePW(float pw) {
		setPW(getPW()-pw);
		return this;
	}
	
	
	public ScreenDimension addPixel(int pixel) {
		setPixel(getPixel()+pixel);
		return this;
	}
	
	
	public ScreenDimension removePixel(int pixel) {
		setPixel(getPixel()-pixel);
		return this;
	}
	
	@Override
	public float getValue() {
		return value;
	}
	
	protected int getPixel() {
		return pixel;
	}
	
	protected void setPixel(int pixel) {
		this.pixel = pixel;
	}
	
	protected float getPW() {
		return pw;
	}
	
	protected void setPW(float pw) {
		this.pw = pw;
	}

	protected float getPF() {
		return pf;
	}

	protected void setPF(float pf) {
		this.pf = pf;
	}
	
	protected List<IScreenDimension> getAdds() {
		return adds;
	}
	
	protected List<IScreenDimension> getRems() {
		return rems;
	}

	public byte getAxis() {
		return axis;
	}
}
