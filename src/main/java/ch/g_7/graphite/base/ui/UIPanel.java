package ch.g_7.graphite.base.ui;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2ic;

import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.mesh.MeshBuilder;
import ch.g_7.graphite.base.mesh.MeshFactory;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.util.Color;

public class UIPanel implements IUIPanel{

	
	private static final Mesh SQUARE_MESH = MeshFactory.getSquare(1).setCenter(MeshBuilder.CENTER_TOP_LEFT).build();
	

	protected ScrennDimension width;
	protected ScrennDimension height;
	protected Vector2f size;
	
	protected ScrennDimension x;
	protected ScrennDimension y;
	protected Vector2f position;
	
	protected IUIPanel father;
	
	protected Color color;
	protected Texture texture;
	
	
	public UIPanel() {
		this.width = new ScrennDimension();
		this.height = new ScrennDimension();
		this.x = new ScrennDimension();
		this.y = new ScrennDimension();
		this.size = new Vector2f(1, 1);
		this.position = new Vector2f(0, 0);
		this.color = new Color(255, 255, 255, 0);
	}
	
	


	
	
	@Override
	public void recalculate(Vector2ic screenSize) {
		recalculate(width, screenSize, ScrennDimension.X_AXIS);
		recalculate(height, screenSize, ScrennDimension.Y_AXIS);
		
		recalculate(x, screenSize, ScrennDimension.X_AXIS);
		recalculate(y, screenSize, ScrennDimension.Y_AXIS);
		
		this.size = new Vector2f(width.getValue(), height.getValue());
		this.position = new Vector2f(x.getValue(), y.getValue());
	}
	
	private void recalculate(ScrennDimension dimension, Vector2ic screenSize, byte axis) {
		dimension.recalculate(screenSize, father == null ? null : father.getSize(), axis);
	}
	
	@Override
	public Mesh getMesh() {
		return SQUARE_MESH;
	}

	@Override
	public final Vector2fc getSize() {
		return father == null ? size : size.add(father.getSize());
	}
	
	public ScrennDimension getWidth() {
		return width;
	}
	
	public void setWidth(ScrennDimension width) {
		this.width = width;
	}
	
	public ScrennDimension getHeight() {
		return height;
	}
	
	public void setHeight(ScrennDimension height) {
		this.height = height;
	}

	@Override
	public Vector2fc getPosition() {
		return father == null ? position : position.add(father.getPosition());
	}
	
	public ScrennDimension getX() {
		return x;
	}
	
	public void setX(ScrennDimension x) {
		this.x = x;
	}
	
	public ScrennDimension getY() {
		return y;
	}
	
	public void setY(ScrennDimension y) {
		this.y = y;
	}
	
	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public Texture getTexture() {
		return texture;
	}
	
	protected void setFather(IUIPanel father) {
		this.father = father;
	}
	
	public IUIPanel getFather() {
		return father;
	}

}
