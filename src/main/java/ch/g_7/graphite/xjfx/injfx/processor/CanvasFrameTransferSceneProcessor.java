package ch.g_7.graphite.xjfx.injfx.processor;

import ch.g_7.graphite.xjfx.injfx.JmeToJfxApplication;
import ch.g_7.graphite.xjfx.injfx.transfer.FrameTransfer;
import ch.g_7.graphite.xjfx.injfx.transfer.impl.CanvasFrameTransfer;
import com.jme3.post.SceneProcessor;
import com.jme3.texture.FrameBuffer;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;

/**
 * The implementation of the {@link SceneProcessor} for transferring content between jME and Canvas.
 *
 * @author JavaSaBr
 */
public class CanvasFrameTransferSceneProcessor extends AbstractFrameTransferSceneProcessor<Canvas> {

    @Override
    protected int getDestinationWidth() {
        return (int) getDestination().getWidth();
    }

    @Override
    protected int getDestinationHeight() {
        return (int) getDestination().getHeight();
    }

    @Override
    protected boolean isPreserveRatio() {
        return false;
    }

    @Override
    protected void bindDestination(
            JmeToJfxApplication application,
            Canvas destination,
            Node inputNode
    ) {
        super.bindDestination(application, destination, inputNode);
        destination.setScaleY(-1.0);
    }

    @Override
    protected void bindListeners() {
        Canvas destination = getDestination();
        destination.widthProperty().addListener(widthListener);
        destination.heightProperty().addListener(heightListener);
        super.bindListeners();
    }

    @Override
    protected void unbindListeners() {
        Canvas destination = getDestination();
        destination.widthProperty().removeListener(widthListener);
        destination.heightProperty().removeListener(heightListener);
        super.unbindListeners();
    }

    @Override
    protected FrameTransfer createFrameTransfer(FrameBuffer frameBuffer, int width, int height) {
        return new CanvasFrameTransfer(getDestination(), getTransferMode(), isMain() ? null : frameBuffer, width, height);
    }
}