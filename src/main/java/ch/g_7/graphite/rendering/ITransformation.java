package ch.g_7.graphite.rendering;

import org.joml.Matrix4f;

public interface ITransformation<R extends Renderable> {

	void setRenderable(R r);
	
	Matrix4f getViewMatrix(R r);

}
