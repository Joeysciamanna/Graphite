package ch.g_7.graphite.xjfx.injfx.transfer.impl;

import com.jme3.jfx.injfx.processor.FrameTransferSceneProcessor.TransferMode;
import com.jme3.texture.FrameBuffer;
import javafx.scene.image.ImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The class for transferring a frame from jME to {@link ImageView}.
 *
 * @author JavaSaBr
 */
public class ImageFrameTransfer extends AbstractFrameTransfer<ImageView> {

    @NotNull
    private ImageView imageView;

    public ImageFrameTransfer(@NotNull ImageView imageView, @NotNull TransferMode transferMode, int width, int height) {
        this(imageView, transferMode, null, width, height);
    }

    public ImageFrameTransfer(
            @NotNull ImageView imageView,
            @NotNull TransferMode transferMode,
            @Nullable FrameBuffer frameBuffer,
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
