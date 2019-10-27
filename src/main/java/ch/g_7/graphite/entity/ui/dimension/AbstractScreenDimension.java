package ch.g_7.graphite.entity.ui.dimension;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

public abstract class AbstractScreenDimension implements IROScreenDimension{

	public static final byte X_AXIS = 0;
	public static final byte Y_AXIS = 1;
	
	@Override
	public AbstractScreenDimension recalculate(Vector2ic screenSize, Vector2fc fatherSize, byte axis) {
		if(axis == X_AXIS) {
			recalculate(screenSize.x(), fatherSize.x());
		}else {
			recalculate(screenSize.y(), fatherSize.y());
		}
		return this;
	}
	
	@Override
	public AbstractScreenDimension recalculate(int screenSize, float fatherSize) {
		float value = 0;
		value += (float) getPixel() * 2 / screenSize;
		value += fatherSize * (getPF() == 0 ? 0 : (getPF()/100));
		value += getPW() * 2 / 100;
		
		for (IROScreenDimension screenDimension : getAdds()) {
			screenDimension.recalculate(screenSize, fatherSize);
			value += screenDimension.getValue();
		}
		for (IROScreenDimension screenDimension : getRems()) {
			screenDimension.recalculate(screenSize, fatherSize);
			value -= screenDimension.getValue();
		}
		setValue(value);
		return this;
	}
	
	
	public AbstractScreenDimension reset() {
		setPixel(0);
		setPW(0);
		setPF(0);
		setValue(0);
		getAdds().clear();
		getRems().clear();
		return this;
	}
	
	
	public AbstractScreenDimension add(IROScreenDimension dimension) {
		getAdds().add(dimension);
		return this;
	}
	
	
	public AbstractScreenDimension remove(IROScreenDimension dimension) {
		getRems().add(dimension);
		return this;
	}
	
	
	public AbstractScreenDimension addPF(float pf) {
		setPF(getPF()+pf);
		return this;
	}
	
	
	public AbstractScreenDimension removePF(float pf) {
		setPF(getPF()-pf);
		return this;
	}
	
	
	public AbstractScreenDimension addPW(float pw) {
		setPW(getPW()+pw);
		return this;
	}
	
	
	public AbstractScreenDimension removePW(float pw) {
		setPW(getPW()-pw);
		return this;
	}
	
	
	public AbstractScreenDimension addPixel(int pixel) {
		setPixel(getPixel()+pixel);
		return this;
	}
	
	
	public AbstractScreenDimension removePixel(int pixel) {
		setPixel(getPixel()-pixel);
		return this;
	}
	
	/**
	 * from 0 to 2
	 * @return
	 */
	@Override
	public abstract float getValue();
	protected abstract void setValue(float value);
	
	protected abstract int getPixel();
	protected abstract void setPixel(int pixel);
	
	protected abstract float getPW();
	protected abstract void setPW(float pw);
	
	protected abstract float getPF();
	protected abstract void setPF(float pf);
	
	protected abstract List<IROScreenDimension> getAdds();
	protected abstract List<IROScreenDimension> getRems();
}
