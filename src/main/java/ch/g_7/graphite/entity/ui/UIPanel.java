package ch.g_7.graphite.entity.ui;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.entity.mesh.AbstractMesh;
import ch.g_7.graphite.entity.mesh.MeshBuilder;
import ch.g_7.graphite.entity.mesh.MeshFactory;
import ch.g_7.graphite.entity.texture.Texture;
import ch.g_7.graphite.entity.ui.dimension.SimpleScreenDimension;
import ch.g_7.graphite.entity.ui.dimension.ScreenDimension2d;
import ch.g_7.graphite.util.Color;

public class UIPanel extends UIContainer implements IUIPanel{

	private static final AbstractMesh SQUARE_MESH = MeshFactory.getSquare(1).setCenter(MeshBuilder.CENTER_TOP_LEFT).build();
	
	protected final ScreenDimension2d maxSize;
	protected final ScreenDimension2d minSize;
	protected final ScreenDimension2d preferedSize;
	private boolean resized;
	
	
	protected IUIContainer father;
	
	protected Color color;
	protected Texture texture;

	
	public UIPanel() {
		this.maxSize = new ScreenDimension2d().addPF(100);
		this.minSize = new ScreenDimension2d();
		this.preferedSize = new ScreenDimension2d().addPF(100);
		this.color = new Color(255, 255, 255, 0);
	}
	
	
	
	private int count = 0;
	@Override
	public void recalculateDimensions(Vector2ic screenSize) {
		
		System.out.println(getClass().getSimpleName() + " -------------------------- " + count++);
		System.out.println("maxSize: " + maxSize.toVector());
		System.out.println("minSize: " + minSize.toVector());
		System.out.println("preferedSize: " + preferedSize.toVector());
		System.out.println("size: " + size.toVector());
		System.out.println();
		
		if(resized) {
			recalculateSize();
			resized = false;
		}
		
		recalculateDimension(maxSize, screenSize);
		recalculateDimension(minSize, screenSize);
		recalculateDimension(preferedSize, screenSize);
		
	
		System.out.println("maxSize: " + maxSize.toVector());
		System.out.println("minSize: " + minSize.toVector());
		System.out.println("preferedSize: " + preferedSize.toVector());
		System.out.println("size: " + size.toVector());
		System.out.println();
		System.out.println();
		System.out.println();
	

		super.recalculateDimensions(screenSize);

	}
	
	
	@Override
	public void recalculateSize() {
		this.size.reset();
		
		if(preferedSize.getXValue() > maxSize.getXValue() || preferedSize.getXValue() < minSize.getXValue()) {
			if(preferedSize.getXValue()-maxSize.getXValue()>preferedSize.getXValue()-minSize.getXValue()) {
				size.getXAxis().add(minSize.getXAxis());
			}else {
				size.getXAxis().add(maxSize.getXAxis());
			}
		}else {
			size.getXAxis().add(preferedSize.getXAxis());
		}
		if(preferedSize.getYValue() > maxSize.getYValue() || preferedSize.getYValue() < minSize.getYValue()) {
			if(preferedSize.getYValue()-maxSize.getYValue()>preferedSize.getYValue()-minSize.getYValue()) {
				size.getYAxis().add(minSize.getYAxis());
			}else {
				size.getYAxis().add(maxSize.getYAxis());
			}
		}else {
			size.getYAxis().add(preferedSize.getYAxis());
		}
	}
	
	
	@Override
	protected void recalculateDimension(SimpleScreenDimension dimension, Vector2ic screenSize, byte axis) {
		dimension.recalculate(screenSize, getFather().getSize().toVector(), axis);
	}
	
	@Override
	protected void recalculateDimension(ScreenDimension2d dimension, Vector2ic screenSize) {
		dimension.recalculate(screenSize, getFather().getSize().toVector());
	}
	
	@Override
	public final void requestDimensionRecalculation(IUIContainer container) {
		if(getFather()!=null) {
			getFather().requestDimensionRecalculation(container);
		}
	}
	
	@Override
	public void close() {
		if(getTexture()!=null) {
			getTexture().close();
		}
		if(getMesh()!=null) {
			getMesh().close();
		}
		super.close();
	}
	
	@Override
	public AbstractMesh getMesh() {
		return SQUARE_MESH;
	}

	@Override
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public Texture getTexture() {
		return texture;
	}
	
	@Override
	public final void setFather(IUIContainer father) {
		this.father = father;
	}
	
	public IUIContainer getFather() {
		return father;
	}
	
	@Override
	public List<IUIPanel> getChilds() {
		return new ArrayList<>();
	}
	
	@Override
	public ScreenDimension2d getPosition() {
		return getFather() == null ? position : position.add(getFather().getPosition());
	}

	@Override
	public Window getWindow() {
		return  getFather() == null ? null : father.getWindow();
	}

	@Override
	public ScreenDimension2d getMaxSize() {
		resized = true;
		return maxSize;
	}
	
	@Override
	public ScreenDimension2d getMinSize() {
		resized = true;
		return minSize;
	}
	
	@Override
	public ScreenDimension2d getPreferedSize() {
		resized = true;
		return preferedSize;
	}



}
