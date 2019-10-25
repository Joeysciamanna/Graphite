package ch.g_7.graphite.entity.ui;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2fc;
import org.joml.Vector2ic;

import ch.g_7.graphite.entity.mesh.AbstractMesh;
import ch.g_7.graphite.entity.mesh.MeshBuilder;
import ch.g_7.graphite.entity.mesh.MeshFactory;
import ch.g_7.graphite.entity.texture.Texture;
import ch.g_7.graphite.util.Color;

public class UIPanel extends UIContainer implements IUIPanel{

	
	private static final AbstractMesh SQUARE_MESH = MeshFactory.getSquare(1).setCenter(MeshBuilder.CENTER_TOP_LEFT).build();
	
	protected IUIContainer father;
	
	protected Color color;
	protected Texture texture;

	
	public UIPanel() {
		this.color = new Color(255, 255, 255, 0);
	}
	
	@Override
	protected void recalculateDimension(ScreenDimension dimension, Vector2ic screenSize, byte axis) {
		dimension.recalculate(screenSize, getFather().getSize().toVector(), axis);
	}
	
	@Override
	public final void requestRecalculation(IUIContainer container) {
		if(getFather()!=null) {
			getFather().requestRecalculation(container);
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
	public Vector2fc getPosition() {
		return getFather() == null ? position : position.add(getFather().getPosition());
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

}
