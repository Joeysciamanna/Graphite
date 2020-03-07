package ch.g_7.graphite.base.view_model;

import ch.g_7.graphite.base.material.IMaterial;
import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.node.IRenderResource;


public class ViewModel implements IViewModel, IRenderResource {

	private IMesh mesh;
	private IMaterial material;

	
	public ViewModel(IMesh mesh, IMaterial material) {
		this.mesh = mesh;
		this.material = material;
	}

	@Override
	public void bind() {
		material.bind();
		mesh.bind();
	}

	@Override
	public void unbind() {
		material.unbind();
		mesh.unbind();
	}

	@Override
	public IMaterial getMaterial() {
		return material;
	}
	
	public void setMaterial(IMaterial material) {
		this.material = material;
	}

	@Override
	public IMesh getMesh() {
		return mesh;
	}

	public void setMesh(IMesh mesh) {
		this.mesh = mesh;
	}
	
}
