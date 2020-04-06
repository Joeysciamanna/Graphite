package ch.g_7.graphite.rendering;

import ch.g_7.graphite.base.material.IMaterial;
import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.node.IViewModel;

public interface IBasicViewModel extends IViewModel {


    IMaterial getMaterial();

    IMesh getMesh();

}
