package ch.g_7.graphite.ui.util;//package ch.g_7.graphite.ui.util;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2ic;

public class ScreenDimension implements IScreenDimension{

	public static final byte X_AXIS = 0;
	public static final byte Y_AXIS = 1;

	private List<IScreenDimension> adds;
	private List<IScreenDimension> rems;

	private float pf;
	private float pw;
	private int pixel;

	private int value;
	private byte axis;

	public ScreenDimension(byte axis, int value) {
		this.value = value;
		this.axis = axis;
		this.adds = new ArrayList<>();
		this.rems = new ArrayList<>();
	}

	public ScreenDimension(byte axis) {
		this(axis, 0);
	}


	@Override
	public ScreenDimension recalculate(Vector2ic screenSize, Vector2ic fatherSize) {
		if(axis == X_AXIS) {
			recalculate(screenSize.x(), fatherSize.x());
		}else {
			recalculate(screenSize.y(), fatherSize.y());
		}
		return this;
	}


	/**
	 * all in pixel
	 */
	@Override
	public ScreenDimension recalculate(int screenSize, int fatherSize) {
		int value = 0;
		value += pixel;
		value += (int) (pw / 100f * screenSize);
		value += (int) (pf / 100f * fatherSize);


		for (IScreenDimension screenDimension : getAdds()) {
			value += screenDimension.getValue();
		}
		for (IScreenDimension screenDimension : getRems()) {
			value -= screenDimension.getValue();
		}
		this.value = value;
		return this;
	}

	@Override
	public ScreenDimension clone() {
		ScreenDimension clone = new ScreenDimension(axis, value);
		clone.addPF(pf);
		clone.addPW(pw);
		clone.addPixel(pixel);
		adds.forEach(clone::add);
		rems.forEach(clone::remove);
		return clone;
	}

	public ScreenDimension reset() {
		pixel = 0;
		pw = 0;
		pf = 0;
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
		this.pf+=pf;
		return this;
	}


	public ScreenDimension removePF(float pf) {
		this.pf-=pf;
		return this;
	}


	public ScreenDimension addPW(float pw) {
		this.pw+=pw;
		return this;
	}


	public ScreenDimension removePW(float pw) {
		this.pw-=pw;
		return this;
	}


	public ScreenDimension addPixel(int pixel) {
		this.pixel+=pixel;
		return this;
	}


	public ScreenDimension removePixel(int pixel) {
		this.pixel-=pixel;
		return this;
	}

	@Override
	public String toString() {
		return "ScreenDimension[PW: " + pw + ", PF: " + pf + ", Pixel: " + pixel + "] " + getValue();
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

	@Override
	public int getValue() {
		return value;
	}
}
