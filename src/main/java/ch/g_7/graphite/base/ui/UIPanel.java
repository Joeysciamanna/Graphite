package ch.g_7.graphite.base.ui;

import java.util.List;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.mesh.MeshFactory;
import ch.g_7.graphite.base.viewmodel.IViewModel;

public class UIPanel implements IUIPanel{

	
	private static final Mesh SQUARE_MESH = MeshFactory.getSquare(1).build();
	
	private IViewModel viewModel;
	private Vector2f position;
	private float rotation;

	private List<UIPanel> childPanels;
	
	
	public UIPanel(Vector2f position, float rotation) {
		this.position = position;
		this.rotation = rotation;
	}

	public UIPanel(Vector2f position) {
		this(viewModel, position, 0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
