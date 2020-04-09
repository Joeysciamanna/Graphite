package ch.g_7.graphite.ui.transform;

import ch.g_7.graphite.ui.util.ScreenDimension;
import org.joml.Vector2ic;

public class AdvancedUITransform extends BasicUITransform {

    protected final ScreenDimension maxWidth;
    protected final ScreenDimension maxHeight;

    protected final ScreenDimension minWidth;
    protected final ScreenDimension minHeight;

    private final ScreenDimension preferredWidth;
    private final ScreenDimension preferredHeight;

    protected final ScreenDimension actualWidth;
    protected final ScreenDimension actualHeight;

    public AdvancedUITransform() {
        this.maxWidth = new ScreenDimension(ScreenDimension.X_AXIS).addPF(100);
        this.maxHeight = new ScreenDimension(ScreenDimension.Y_AXIS).addPF(100);

        this.minWidth = new ScreenDimension(ScreenDimension.X_AXIS);
        this.minHeight = new ScreenDimension(ScreenDimension.Y_AXIS);

        this.preferredWidth = new ScreenDimension(ScreenDimension.X_AXIS).addPF(100);
        this.preferredHeight = new ScreenDimension(ScreenDimension.Y_AXIS).addPF(100);

        this.actualWidth = new ScreenDimension(ScreenDimension.X_AXIS).addPF(100);
        this.actualHeight = new ScreenDimension(ScreenDimension.Y_AXIS).addPF(100);
    }

    @Override
    public void recalculate(Vector2ic screenSize, Vector2ic fatherSize) {
        super.recalculate(screenSize, fatherSize);
        //if(recalculate) {
            recalculateDimension(maxWidth, screenSize, fatherSize);
            recalculateDimension(maxHeight, screenSize, fatherSize);
            recalculateDimension(minWidth, screenSize, fatherSize);
            recalculateDimension(minHeight, screenSize, fatherSize);
            recalculateDimension(preferredWidth, screenSize, fatherSize);
            recalculateDimension(preferredHeight, screenSize, fatherSize);

            recalculatePreferredSize();
        //}
        recalculateDimension(actualWidth, screenSize, fatherSize);
        recalculateDimension(actualHeight, screenSize, fatherSize);
        scale.set(actualWidth.getValue(), actualHeight.getValue(), 0);

        //
    }


    private void recalculatePreferredSize() {
        this.actualWidth.reset();
        this.actualHeight.reset();

        if(preferredWidth.getValue() > maxWidth.getValue() || preferredWidth.getValue() < minWidth.getValue()) {
            if(preferredWidth.getValue()-maxWidth.getValue()> preferredWidth.getValue()-minWidth.getValue()) {
                actualWidth.add(minWidth);
            }else {
                actualWidth.add(maxWidth);
            }
        }else {
            actualWidth.add(preferredWidth);
        }
        if(preferredHeight.getValue() > maxHeight.getValue() || preferredHeight.getValue() < minHeight.getValue()) {
            if(preferredHeight.getValue()-maxHeight.getValue() > preferredHeight.getValue()-minHeight.getValue()) {
                actualHeight.add(minHeight);
            }else {
                actualHeight.add(maxHeight);
            }
        }else {
            actualHeight.add(preferredHeight);
        }
    }

    public ScreenDimension getMaxWidth() {
        return maxWidth;
    }

    public ScreenDimension getMaxHeight() {
        return maxHeight;
    }

    public ScreenDimension getMinWidth() {
        return minWidth;
    }

    public ScreenDimension getMinHeight() {
        return minHeight;
    }

    public ScreenDimension getPreferredWidth() {
        return preferredWidth;
    }

    public ScreenDimension getPreferredHeight() {
        return preferredHeight;
    }

}
