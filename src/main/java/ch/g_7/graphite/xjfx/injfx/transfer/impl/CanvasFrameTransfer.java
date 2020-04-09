package ch.g_7.graphite.xjfx.injfx.transfer.impl;


import ch.g_7.graphite.xjfx.injfx.processor.FrameTransferSceneProcessor;
import ch.g_7.graphite.xjfx.injfx.processor.FrameTransferSceneProcessor.TransferMode;
import com.jme3.texture.FrameBuffer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 * The class for transferring content from the jME to {@link Canvas}.
 *
 * @author JavaSaBr
 */
public class CanvasFrameTransfer extends AbstractFrameTransfer<Canvas> {


    private GraphicsContext g;

    public CanvasFrameTransfer(Canvas canvas, TransferMode transferMode, int width, int height) {
        this(canvas, transferMode, null, width, height);
    }

    public CanvasFrameTransfer(
            Canvas canvas,
            TransferMode transferMode,
            FrameBuffer frameBuffer,
            int width,
            int height
    ) {
        super(canvas, transferMode, frameBuffer, width, height);
        g = canvas.getGraphicsContext2D();
        g.setFill(new Color(1, 1, 1, 1));
    }

    @Override
    protected void writeFrame() {
        pixelBuffer.updateBuffer(pixBuf -> updatedBuffer);

        g.fillRect(0, 0, width, height);
        g.drawImage(img, 0, 0);
    }
}
