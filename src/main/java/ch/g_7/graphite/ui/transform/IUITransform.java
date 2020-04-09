package ch.g_7.graphite.ui.transform;

import ch.g_7.graphite.base.transform.IROTransform;
import org.joml.Vector2ic;

public interface IUITransform extends IROTransform {

    void recalculate(Vector2ic screenSize, Vector2ic fatherSize);

    Vector2ic getSize();

    Vector2ic getPosition();
}
