package ch.g_7.graphite.ui.view_model;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.util.Color;

public interface IUIViewModel extends IViewModel {

    Color getColor();

    ITexture getTexture();

    IMesh getMesh();

    boolean isVisible();

}
