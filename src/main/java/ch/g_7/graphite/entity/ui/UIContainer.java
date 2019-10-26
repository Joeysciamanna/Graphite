package ch.g_7.graphite.entity.ui;

import java.util.List;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2ic;

import ch.g_7.graphite.entity.ui.dimension.SimpleScreenDimension;
import ch.g_7.graphite.entity.ui.dimension.ScreenDimension2d;

public abstract class UIContainer implements IUIContainer{

	protected final ScreenDimension2d maxSize;
	protected final ScreenDimension2d minSize;
	protected final ScreenDimension2d preferedSize;
	protected final ScreenDimension2d size;
	
	protected final ScreenDimension2d position;
	
	protected boolean visible;
	
	
	public UIContainer() {
		this.maxSize = new ScreenDimension2d();
		this.minSize = new ScreenDimension2d();
		this.preferedSize = new ScreenDimension2d();
		this.size = new ScreenDimension2d();
		
		this.position = new ScreenDimension2d();
		this.visible = true;
	}
	
	@Override
	public void recalculate(Vector2ic screenSize) {
		recalculateDimension(position, screenSize);
		
		recalculateDimension(maxSize, screenSize);
		recalculateDimension(minSize, screenSize);
		recalculateDimension(preferedSize, screenSize);
		
		
		this.size.reset();
	
		if(preferedSize.getXValue() < minSize.getXValue() || preferedSize.getXValue() > maxSize.getXValue()) {
			if(Math.abs(preferedSize.getXValue()-maxSize.getXValue()) < Math.abs(minSize.getXValue()-preferedSize.getXValue())){
				size.getXAxis().add(maxSize.getXAxis());
			}else {
				size.getXAxis().add(minSize.getXAxis());
			}
		}
		if(preferedSize.getYValue() < minSize.getYValue() || preferedSize.getYValue() > maxSize.getYValue()) {
			if(Math.abs(preferedSize.getYValue()-maxSize.getYValue()) < Math.abs(minSize.getYValue()-preferedSize.getYValue())){
				size.getYAxis().add(maxSize.getYAxis());
			}else {
				size.getYAxis().add(minSize.getYAxis());
			}
		}
		recalculateDimension(size, screenSize);
		
		for (IUIPanel child : getChilds()) {
			child.recalculate(screenSize);
		}
	}
	
	protected abstract void recalculateDimension(SimpleScreenDimension dimension, Vector2ic screenSize, byte axis);
	protected abstract void recalculateDimension(ScreenDimension2d dimension, Vector2ic screenSize);
	
	@Override
	public void close() {
		for (IUIPanel panel : getChilds()) {
			panel.close();
		}
	}

	@Override
	public void init() {
		for (IUIPanel panel : getChilds()) {
			panel.init();
		}
	}
	
	@Override
	public boolean isVisible() {
		return visible;
	}
	
	
	@Override
	public ScreenDimension2d getSize() {
		return size;
	}
	
	@Override
	public ScreenDimension2d getMaxSize() {
		return maxSize;
	}
	
	@Override
	public ScreenDimension2d getMinSize() {
		return minSize;
	}
	
	@Override
	public ScreenDimension2d getPreferedSize() {
		return preferedSize;
	}

	@Override
	public ScreenDimension2d getPosition() {
		return position;
	}


}
