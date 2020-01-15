package ch.g_7.graphite.draw;


import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Renderable;

public interface IDrawObject extends INode, Renderable {

	int getGLDrawMethod();
}
