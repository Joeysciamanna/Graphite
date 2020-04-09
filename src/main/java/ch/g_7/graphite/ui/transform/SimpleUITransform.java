package ch.g_7.graphite.ui.transform;

import ch.g_7.graphite.ui.util.IScreenDimension;
import ch.g_7.graphite.ui.util.ScreenDimension;
import org.joml.Vector2ic;
import org.joml.Vector3fc;

public class SimpleUITransform extends BasicUITransform {

    private final ScreenDimension width;
    private final ScreenDimension height;


    public SimpleUITransform() {
        this.width = new ScreenDimension(ScreenDimension.X_AXIS);
        this.width.addPF(100);
        this.height = new ScreenDimension(ScreenDimension.Y_AXIS);
        this.height.addPF(100);
    }

    @Override
    public void recalculate(Vector2ic screenSize, Vector2ic fatherSize) {
        super.recalculate(screenSize, fatherSize);
        recalculateDimension(width, screenSize, fatherSize);
        recalculateDimension(height, screenSize, fatherSize);
        scale.set(width.getValue(), height.getValue(), 0);
    }



    public ScreenDimension getWidth() {
        return width;
    }

    public ScreenDimension getHeight() {
        return height;
    }

}
