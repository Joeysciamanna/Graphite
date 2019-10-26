package ch.g_7.graphite.entity.ui;

import java.util.List;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2ic;

import ch.g_7.graphite.entity.ui.dimension.SimpleScreenDimension;
import ch.g_7.graphite.entity.ui.dimension.IROScreenDimension2d;
import ch.g_7.graphite.entity.ui.dimension.ScreenDimension2d;

public abstract class UIContainer implements IUIContainer{


	protected final ScreenDimension2d size;
	protected final ScreenDimension2d position;
	
	protected boolean visible;
	
	
	public UIContainer() {
		this.size = new ScreenDimension2d();
		this.position = new ScreenDimension2d();
		this.visible = true;
	}
	
	@Override
	public void recalculateDimensions(Vector2ic screenSize) {
		
		recalculateDimension(position, screenSize);
		recalculateDimension(size, screenSize);
		
		for (IUIPanel child : getChilds()) {
			child.recalculateDimensions(screenSize);
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
	public IROScreenDimension2d getSize() {
		return size;
	}
	
	@Override
	public ScreenDimension2d getPosition() {
		return position;
	}


}
