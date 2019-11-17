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
import ch.g_7.graphite.entity.ui.dimension.ScreenDimension;
import ch.g_7.graphite.util.Color;

public class UIPanel extends UIContainer implements IUIPanel{

	private static final AbstractMesh SQUARE_MESH = MeshFactory.getSquare(1).setCenter(MeshBuilder.CENTER_TOP_LEFT).build();
	
	protected final ScreenDimension maxWidth;
	protected final ScreenDimension maxHeight;
	
	protected final ScreenDimension minWidth;
	protected final ScreenDimension minHeight;
	
	protected final ScreenDimension preferedWidth;
	protected final ScreenDimension preferedHeight;
	
	private boolean resized;
	
	protected IUIContainer father;
	
	protected Color color;
	protected Texture texture;

	
	public UIPanel() {
		this.maxWidth = new ScreenDimension(ScreenDimension.X_AXIS).addPF(100);
		this.maxHeight = new ScreenDimension(ScreenDimension.Y_AXIS).addPF(100);
		
		this.minWidth = new ScreenDimension(ScreenDimension.X_AXIS);
		this.minHeight = new ScreenDimension(ScreenDimension.Y_AXIS);
		
		this.preferedWidth = new ScreenDimension(ScreenDimension.X_AXIS).addPF(100);
		this.preferedHeight = new ScreenDimension(ScreenDimension.Y_AXIS).addPF(100);
		
		this.color = new Color(255, 255, 255, 0);
	}
	

	@Override
	public void recalculate(Vector2ic screenSize) {
		System.out.println("recalculating:\t" + getClass().getSimpleName() + " " + (getClass().getSimpleName().equals("UIPanel") ? getColor() : ""));
		
		if(resized) {
			recalculateDimension(maxWidth, screenSize);
			recalculateDimension(maxHeight, screenSize);
			recalculateDimension(minWidth, screenSize);
			recalculateDimension(minHeight, screenSize);
			recalculateDimension(preferedWidth, screenSize);
			recalculateDimension(preferedHeight, screenSize);
			
			recalculateSize();
			resized = false;
		}
		
		System.out.println("\tsize:      " + preferedWidth + " / " + preferedHeight);
		
		super.recalculate(screenSize);

	}
	
	
	@Override
	public void recalculateSize() {
		this.width.reset();
		this.height.reset();
		
		if(preferedWidth.getValue() > maxWidth.getValue() || preferedWidth.getValue() < minWidth.getValue()) {
			if(preferedWidth.getValue()-maxWidth.getValue()>preferedWidth.getValue()-minWidth.getValue()) {
				width.add(minWidth);
			}else {
				width.add(maxWidth);
			}
		}else {
			width.add(preferedWidth);
		}
		if(preferedHeight.getValue() > maxHeight.getValue() || preferedHeight.getValue() < minHeight.getValue()) {
			if(preferedHeight.getValue()-maxHeight.getValue()>preferedHeight.getValue()-minHeight.getValue()) {
				height.add(minHeight);
			}else {
				height.add(maxHeight);
			}
		}else {
			height.add(preferedHeight);
		}
//		System.out.println("       resize:\t" + getClass().getSimpleName());
	}
	
	
	@Override
	protected void recalculateDimension(ScreenDimension dimension, Vector2ic screenSize) {
		dimension.recalculate(screenSize, getFather().getSize());
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
	public Vector2fc getPosition() {
		return getFather() == null ? position : position.add(getFather().getPosition());
	}

	@Override
	public Window getWindow() {
		return getFather() == null ? null : father.getWindow();
	}

	@Override
	public ScreenDimension getMaxWidth() {
		resized = true;
		return maxWidth;
	}


	@Override
	public ScreenDimension getMaxHeight() {
		resized = true;
		return maxHeight;
	}


	@Override
	public ScreenDimension getMinWidth() {
		resized = true;
		return minWidth;
	}


	@Override
	public ScreenDimension getMinHeight() {
		resized = true;
		return minHeight;
	}


	@Override
	public ScreenDimension getPreferedWidth() {
		resized = true;
		return preferedWidth;
	}


	@Override
	public ScreenDimension getPreferedHeight() {
		resized = true;
		return preferedHeight;
	}







}
