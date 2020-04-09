package ch.g_7.graphite.ui.transform;

import ch.g_7.graphite.ui.util.IScreenDimension;
import ch.g_7.graphite.ui.util.ScreenDimension;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.joml.Vector3f;
import org.joml.Vector3fc;

public abstract class BasicUITransform implements IUITransform {

    protected final ScreenDimension x;
    protected final ScreenDimension y;
    protected final Vector3f translation;

    protected final Vector3f scale;

    public BasicUITransform() {
        this.x = new ScreenDimension(ScreenDimension.X_AXIS);
        this.y = new ScreenDimension(ScreenDimension.Y_AXIS);
        this.translation = new Vector3f();
        this.scale = new Vector3f();
    }

    @Override
    public void recalculate(Vector2ic screenSize, Vector2ic fatherSize) {
        recalculateDimension(x, screenSize, fatherSize);
        recalculateDimension(y, screenSize, fatherSize);
        translation.set(x.getValue(), y.getValue(),0);
    }

    protected void recalculateDimension(IScreenDimension screenDimension, Vector2ic screenSize, Vector2ic fatherSize){
        screenDimension.recalculate(screenSize, fatherSize);
    }

    @Override
    public Vector3fc getTranslation() {
        return translation;
    }

    @Override
    public Vector3fc getRotation() {
        return new Vector3f();
    }

    @Override
    public Vector3fc getScale() {
        return scale;
    }

    @Override
    public Vector2ic getSize() {
        return new Vector2i((int)scale.x, (int) scale.y);
    }

    @Override
    public Vector2ic getPosition() {
        return new Vector2i((int)translation.x, (int) translation.y);
    }

    public ScreenDimension getX() {
        return x;
    }

    public ScreenDimension getY() {
        return y;
    }


}
