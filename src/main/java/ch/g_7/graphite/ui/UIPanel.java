package ch.g_7.graphite.ui;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2ic;

import ch.g_7.graphite.base.mesh.IMesh2d;
import ch.g_7.graphite.base.mesh.MeshBuilder2d;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.ui.util.ScreenDimension;
import ch.g_7.graphite.util.Color;

public class UIPanel extends UIContainer implements IUIPanel {

	private static IMesh2d SQUARE_MESH;
	
	protected final ScreenDimension maxWidth;
	protected final ScreenDimension maxHeight;
	
	protected final ScreenDimension minWidth;
	protected final ScreenDimension minHeight;
	
	protected final ScreenDimension preferedWidth;
	protected final ScreenDimension preferedHeight;
	

	private boolean resized = true;
	
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
		
		setColor(Color.getColor(255, 255, 255));
	}
	

	@Override
	public void recalculate(Vector2ic screenSize) {
		if(resized) {
			recalculateDimension(maxWidth, screenSize);
			recalculateDimension(maxHeight, screenSize);
			recalculateDimension(minWidth, screenSize);
			recalculateDimension(minHeight, screenSize);
			recalculateDimension(preferedWidth, screenSize);
			recalculateDimension(preferedHeight, screenSize);
			
			recalculateSize();
		}
	
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
	}
	
	@Override
	public void init() {
		if(SQUARE_MESH == null) {
			SQUARE_MESH = MeshFactory2d.getSquare(1).setCenter(MeshBuilder2d.CENTER_TOP_LEFT).build();
			SQUARE_MESH.init();
		}
		super.init();
	}
	
	@Override
	protected void recalculateDimension(ScreenDimension dimension, Vector2ic screenSize) {
		dimension.recalculate(screenSize, getFather().getSize());
	}
	

	
	@Override
	public final void requestRecalculation(IUIContainer container) {
		if(getFather()!=null) {
			getFather().requestRecalculation(container);
		}
	}
	
	
	@Override
	public void recalculate() {
		requestRecalculation(this);
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
	public void setResized(boolean resized) {
		this.resized = resized;
	}
	
	@Override
	public IMesh2d getMesh() {
		return SQUARE_MESH;
	}

	@Override
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		if(color.getA() != 0) {
			color.setA(255);
		}
		this.color = color;
	}
	
	@Override
	public Texture getTexture() {
		return texture;
	}
	
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	
	@Override
	public final void setFather(IUIContainer father) {
		this.father = father;
	}
	
	public IUIContainer getFather() {
		return father;
	}
	
	@Override
	public Vector2fc getPosition() {
		return getFather() == null ? position : new Vector2f(position).add(getFather().getPosition());
	}

	@Override
	public Window getWindow() {
		return getFather() == null ? null : father.getWindow();
	}

	@Override
	public IUIRootContainer getRootContainer() {
		return getFather() == null ? null : father.getRootContainer();
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
