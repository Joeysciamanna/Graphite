package ch.g_7.graphite.ui.view_model;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.mesh.Mesh;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.base.texture.Texture;
import ch.g_7.graphite.rendering.IRenderResource;
import ch.g_7.graphite.rendering.IRenderType;
import ch.g_7.graphite.rendering.RenderType;
import ch.g_7.graphite.resource.ResourceManager;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.helper.Util;

import java.util.Objects;

public class UIViewModel implements IUIViewModel {

    private static final IMesh SQUARE_MESH = ResourceManager.addGlobalResource(MeshFactory2d.getSquare(1).build());

    private boolean visible;
    private IMesh mesh;
    private Color color;
    private ITexture texture;

    public UIViewModel(IMesh mesh, Color color, ITexture texture) {
        this.mesh = mesh;
        this.color = color;
        this.texture = texture;
    }

    public UIViewModel(IMesh mesh, Color color) {
        this(mesh, color, null);
   }

    public UIViewModel(Color color) {
        this(SQUARE_MESH, color);
    }

    @Override
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public ITexture getTexture() {
        return texture;
    }

    public void setTexture(ITexture texture) {
        this.texture = texture;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public IMesh getMesh() {
        return mesh;
    }

    public void setMesh(IMesh mesh) {
        this.mesh = mesh;
    }

    @Override
    public IRenderType<?> getRenderType() {
        return RenderType.UI;
    }

    @Override
    public void bind() {
        Util.ifNotNull(texture, IRenderResource::bind);
        mesh.bind();
    }

    @Override
    public void unbind() {
        Util.ifNotNull(texture, IRenderResource::unbind);
        mesh.unbind();
    }
}
