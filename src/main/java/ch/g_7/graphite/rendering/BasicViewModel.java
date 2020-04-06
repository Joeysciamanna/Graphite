package ch.g_7.graphite.rendering;

import ch.g_7.graphite.base.material.IMaterial;
import ch.g_7.graphite.base.mesh.IMesh;

public class BasicViewModel implements IBasicViewModel {

    private IMaterial material;
    private IMesh mesh;

    public BasicViewModel(IMaterial material, IMesh mesh) {
        this.material = material;
        this.mesh = mesh;
    }

    @Override
    public IMaterial getMaterial() {
        return material;
    }

    @Override
    public IMesh getMesh() {
        return mesh;
    }

    @Override
    public IRenderType<?> getRenderType() {
        return RenderType.ENTITY;
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
}
