package ch.g_7.graphite.ui;

import ch.g_7.graphite.base.transformation.IROTransform;
import ch.g_7.graphite.base.transformation.ITransform;
import ch.g_7.graphite.ui.util.ScreenDimension;
import org.joml.Vector3f;
import org.joml.Vector3fc;

public class UITransform implements IROTransform {

    protected final ScreenDimension width;
    protected final ScreenDimension height;

    protected final ScreenDimension x;
    protected final ScreenDimension y;


    public UITransform() {
        this.width = new ScreenDimension(ScreenDimension.X_AXIS);
        this.height = new ScreenDimension(ScreenDimension.Y_AXIS);

        this.x = new ScreenDimension(ScreenDimension.X_AXIS);
        this.y = new ScreenDimension(ScreenDimension.Y_AXIS);
    }


    @Override
    public Vector3fc getTranslation() {
        return null;
    }

    @Override
    public Vector3fc getRotation() {
        return null;
    }

    @Override
    public Vector3fc getScale() {
        return null;
    }

    public ScreenDimension getWidth() {
        return width;
    }

    public ScreenDimension getHeight() {
        return height;
    }

    public ScreenDimension getX() {
        return x;
    }

    public ScreenDimension getY() {
        return y;
    }
}
