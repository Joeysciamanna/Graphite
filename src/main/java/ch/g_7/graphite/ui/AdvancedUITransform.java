package ch.g_7.graphite.ui;

import ch.g_7.graphite.ui.util.ScreenDimension;
import ch.g_7.graphite.util.Color;
import org.joml.Vector2ic;

public class AdvancedUITransform extends UITransform {

    protected final ScreenDimension maxWidth;
    protected final ScreenDimension maxHeight;

    protected final ScreenDimension minWidth;
    protected final ScreenDimension minHeight;

    protected final ScreenDimension preferedWidth;
    protected final ScreenDimension preferedHeight;

    private boolean recalculate;

    public AdvancedUITransform() {
        this.maxWidth = new ScreenDimension(ScreenDimension.X_AXIS).addPF(100);
        this.maxHeight = new ScreenDimension(ScreenDimension.Y_AXIS).addPF(100);

        this.minWidth = new ScreenDimension(ScreenDimension.X_AXIS);
        this.minHeight = new ScreenDimension(ScreenDimension.Y_AXIS);

        this.preferedWidth = new ScreenDimension(ScreenDimension.X_AXIS).addPF(100);
        this.preferedHeight = new ScreenDimension(ScreenDimension.Y_AXIS).addPF(100);
    }

    @Override
    public void recalculate(Vector2ic screenSize, Vector2ic fatherSize) {
        if(recalculate) {
            recalculateDimension(maxWidth, screenSize);
            recalculateDimension(maxHeight, screenSize);
            recalculateDimension(minWidth, screenSize);
            recalculateDimension(minHeight, screenSize);
            recalculateDimension(preferedWidth, screenSize);
            recalculateDimension(preferedHeight, screenSize);

            recalculatePreferedSize();
        }

        super.recalculate(screenSize, fatherSize);
        transformation.getPosition().add(father.getTransformation().getPosition());
    }
}
