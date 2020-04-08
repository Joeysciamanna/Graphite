package ch.g_7.graphite.ui;

import ch.g_7.graphite.base.transformation.IROTransform;
import ch.g_7.graphite.ui.scene.ISceneIdentifier;
import ch.g_7.graphite.ui.util.IScreenDimension;
import ch.g_7.graphite.ui.util.ScreenDimension;
import org.joml.Vector2ic;
import org.joml.Vector3f;
import org.joml.Vector3fc;

public class UITransform implements IUITransform {

    private final ScreenDimension width;
    private final ScreenDimension height;
    private final Vector3f scale;

    private final ScreenDimension x;
    private final ScreenDimension y;
    private final Vector3f translation;

    public UITransform() {
        this.width = new ScreenDimension(ScreenDimension.X_AXIS);
        this.height = new ScreenDimension(ScreenDimension.Y_AXIS);
        this.scale = new Vector3f();

        this.x = new ScreenDimension(ScreenDimension.X_AXIS);
        this.y = new ScreenDimension(ScreenDimension.Y_AXIS);
        this.translation = new Vector3f();
    }

    @Override
    public void recalculate(Vector2ic screenSize, Vector2ic fatherSize) {
        recalculateDimension(width, screenSize, fatherSize);
        recalculateDimension(height, screenSize, fatherSize);
        scale.set(width.getValue(), height.getValue(), 0);
        recalculateDimension(x, screenSize, fatherSize);
        recalculateDimension(y, screenSize, fatherSize);
        translation.set(x.getValue(), y.getValue(),0);
    }

    protected void recalculateDimension(IScreenDimension screenDimension, Vector2ic screenSize, Vector2ic fatherSize){
        screenDimension.recalculate(screenSize, fatherSize);
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
