package ch.g_7.graphite.entity.ui;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2ic;

public abstract class UIContainer implements IUIContainer{

	protected ScreenDimension2d maxSize;
	protected ScreenDimension2d minSize;
	protected ScreenDimension2d preferedSize;
	protected ScreenDimension2d size;
	
	protected ScreenDimension2d position;
	
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
		recalculateDimension(size, screenSize);

		for (IUIPanel child : getChilds()) {
			child.recalculate(screenSize);
		}
	}
	
	protected abstract void recalculateDimension(ScreenDimension dimension, Vector2ic screenSize, byte axis);
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
	public ScreenDimension2d getPosition() {
		return position;
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
	public ScreenDimension2d getSize() {
		return size;
	}
	
 
	

}
