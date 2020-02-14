package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.mesh.vao.VAO;
import ch.g_7.graphite.base.mesh.vao.VBO;
import ch.g_7.graphite.resource.IResource;

/**
 * textCoords starting at bottom left, clockwise
 *
 * @author Joey Sciamanna
 */
public interface IMesh {

    int getVerticesCount();

    VBO getPositionVBO();

}
