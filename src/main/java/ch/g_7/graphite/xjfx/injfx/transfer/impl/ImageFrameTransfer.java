package ch.g_7.graphite.xjfx.injfx.transfer.impl;


import ch.g_7.graphite.xjfx.injfx.processor.FrameTransferSceneProcessor.TransferMode;
import com.jme3.texture.FrameBuffer;
import javafx.scene.image.ImageView;

/**
 * The class for transferring a frame from jME to {@link ImageView}.
 *
 * @author JavaSaBr
 */
public class ImageFrameTransfer extends AbstractFrameTransfer<ImageView> {

    private ImageView imageView;

    public ImageFrameTransfer(ImageView imageView, TransferMode transferMode, int width, int height) {
        this(imageView, transferMode, null, width, height);
    }

    public ImageFrameTransfer(
            ImageView imageView,
            TransferMode transferMode,
            FrameBuffer frameBuffer,
            int width,
            int height
    ) {
        super(imageView, transferMode, frameBuffer, width, height);
        this.imageView = imageView;
    }

    @Override
    protected void setImage() {
        imageView.setImage(img);
    }

    @Override
    protected void writeFrame() {
        pixelBuffer.updateBuffer(pixBuf -> updatedBuffer);
    }
}
