package ch.g_7.graphite.base.mesh;

import ch.g_7.graphite.base.mesh.vao.VAO;

/**
 * textCoords starting at bottom left, clockwise
 *
 * @author Joey Sciamanna
 */
public interface IMesh {

    int getVerticesCount();

    void allocate(VAO vao);

}
