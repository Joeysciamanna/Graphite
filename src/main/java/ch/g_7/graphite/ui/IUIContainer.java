package ch.g_7.graphite.ui;

import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.ui.transform.IUITransform;
import ch.g_7.graphite.ui.util.ScreenDimension;
import ch.g_7.util.common.Initializable;
import org.joml.Vector2ic;

public interface IUIContainer extends INode<IUIPanel, IViewModel>, Initializable {

	void recalculate();

	void recalculate(Vector2ic screenSize, Vector2ic fatherSize);

	void requestRecalculation(IUIContainer container);

	IUITransform getTransform();

	IUIRootContainer getRootContainer();
}
