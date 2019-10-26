package ch.g_7.graphite.entity.ui;

import java.util.List;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2ic;

import ch.g_7.graphite.entity.ui.dimension.SimpleScreenDimension;
import ch.g_7.graphite.entity.ui.dimension.IROScreenDimension2d;
import ch.g_7.graphite.entity.ui.dimension.ScreenDimension2d;

public abstract class UIContainer implements IUIContainer{

	protected final ScreenDimension2d maxSize;
	protected final ScreenDimension2d minSize;
	protected final ScreenDimension2d preferedSize;
	protected final ScreenDimension2d size;
	
	protected final ScreenDimension2d position;
	
	protected boolean visible;
	
	
	public UIContainer() {
		this.maxSize = new ScreenDimension2d().addPF(100);
		this.minSize = new ScreenDimension2d();
		this.preferedSize = new ScreenDimension2d().addPF(100);
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
	
		System.out.println(getClass().getSimpleName() + "  --------------------");
		
		System.out.println("position: " + position.toVector());
		System.out.println("maxSize: " + maxSize.toVector());
		System.out.println("minSize: " + minSize.toVector());
		System.out.println("preferedSize: " + preferedSize.toVector());
		System.out.println("size: " + size.toVector());
		
		
		
		if(preferedSize.getXValue() > maxSize.getXValue() || preferedSize.getXValue() < minSize.getXValue()) {
			if(preferedSize.getXValue()-maxSize.getXValue()>preferedSize.getXValue()-minSize.getXValue()) {
				System.out.println("X min");
				size.getXAxis().add(minSize.getXAxis());
			}else {
				System.out.println("X max");
				size.getXAxis().add(maxSize.getXAxis());
			}
		}else {
			size.getXAxis().add(preferedSize.getXAxis());
		}
		if(preferedSize.getYValue() > maxSize.getYValue() || preferedSize.getYValue() < minSize.getYValue()) {
			if(preferedSize.getYValue()-maxSize.getYValue()>preferedSize.getYValue()-minSize.getYValue()) {
				System.out.println("Y min");
				size.getYAxis().add(minSize.getYAxis());
			}else {
				System.out.println("Y max");
				size.getYAxis().add(maxSize.getYAxis());
			}
		}else {
			size.getYAxis().add(preferedSize.getYAxis());
		}
		
		recalculateDimension(size, screenSize);
		
		
		System.out.println();
		System.out.println("position: " + position.toVector());
		System.out.println("maxSize: " + maxSize.toVector());
		System.out.println("minSize: " + minSize.toVector());
		System.out.println("preferedSize: " + preferedSize.toVector());
		System.out.println("size: " + size.toVector());
		System.out.println();
		System.out.println();
		System.out.println();
		
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
	public IROScreenDimension2d getSize() {
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
