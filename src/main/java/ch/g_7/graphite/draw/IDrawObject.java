package ch.g_7.graphite.draw;


import ch.g_7.graphite.base.transformation.ITransformation;
import ch.g_7.graphite.base.view_model.IViewModel;
import ch.g_7.graphite.util.Closeable;
import ch.g_7.util.able.Initializable;

public interface IDrawObject extends Initializable, Closeable {

	IViewModel getViewModel();
	
	ITransformation getTransformation();

	int getGLDrawMethod();
}
