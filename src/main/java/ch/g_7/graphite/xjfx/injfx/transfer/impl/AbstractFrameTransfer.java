package ch.g_7.graphite.xjfx.injfx.transfer.impl;


import ch.g_7.graphite.xjfx.injfx.processor.FrameTransferSceneProcessor;
import ch.g_7.graphite.xjfx.injfx.transfer.FrameTransfer;
import ch.g_7.graphite.xjfx.util.JfxPlatform;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.Renderer;
import com.jme3.texture.FrameBuffer;
import com.jme3.texture.Image;
import com.jme3.util.BufferUtils;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.PixelBuffer;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL21;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The base implementation of a frame transfer.
 *
 * @param <T> the destination's type.
 * @author JavaSaBr
 */
public abstract class AbstractFrameTransfer<T> implements FrameTransfer {

    protected static final int RUNNING_STATE = 1;
    protected static final int WAITING_STATE = 2;
    protected static final int DISPOSING_STATE = 3;
    protected static final int DISPOSED_STATE = 4;

    /**
     * The Frame state.
     */
    protected final AtomicInteger frameState;

    /**
     * The Image state.
     */
    protected final AtomicInteger imageState;

    /**
     * The Frame buffer.
     */
    protected final FrameBuffer frameBuffer;

    /**
     * The Frame byte buffer.
     */
    protected final ByteBuffer frameByteBuffer;

    /**
     * The pixel buffer.
     */
    protected final PixelBuffer<ByteBuffer> pixelBuffer;

    /**
     * The default pixel format.
     */
    protected final WritablePixelFormat<ByteBuffer> pixelFormat;

    /**
     * The update buffer.
     */
    protected final Rectangle2D updatedBuffer;

    /**
     * The writable image that holds the pixelbuffer.
     */
    protected final WritableImage img;

    /**
     * The transfer mode.
     */
    protected final FrameTransferSceneProcessor.TransferMode transferMode;

    /**
     * How many frames need to write else.
     */
    protected int frameCount;

    /**
     * The width.
     */
    protected final int width;

    /**
     * The height.
     */
    protected final int height;

    /**
     * OpenGL PBOs
     */
    private final IntBuffer[] pixelBufferObjects;

    /**
     * Index of active PBO
     */
    private int index;

    public AbstractFrameTransfer(T destination, int width, int height, FrameTransferSceneProcessor.TransferMode transferMode) {
        this(destination, transferMode, null, width, height);
    }

    public AbstractFrameTransfer(
            T destination,
            FrameTransferSceneProcessor.TransferMode transferMode,
            FrameBuffer frameBuffer,
            int width,
            int height
    ) {
        this.transferMode = transferMode;
        this.frameState = new AtomicInteger(WAITING_STATE);
        this.imageState = new AtomicInteger(WAITING_STATE);
        this.width = frameBuffer != null ? frameBuffer.getWidth() : width;
        this.height = frameBuffer != null ? frameBuffer.getHeight() : height;
        this.frameCount = 0;

        if (frameBuffer != null) {
            this.frameBuffer = frameBuffer;
        } else {
            this.frameBuffer = new FrameBuffer(width, height, 1);
            this.frameBuffer.setDepthBuffer(Image.Format.Depth);
            this.frameBuffer.setColorBuffer(Image.Format.BGRA8);
            this.frameBuffer.setSrgb(true);
        }

        frameByteBuffer = BufferUtils.createByteBuffer(getWidth() * getHeight() * 4);
        pixelFormat = PixelFormat.getByteBgraPreInstance();
        pixelBuffer = new PixelBuffer<>(width, height, frameByteBuffer, pixelFormat);
        img = new WritableImage(pixelBuffer);
        updatedBuffer = new Rectangle2D(0, 0, width, height);

        pixelBufferObjects = new IntBuffer[2];
        if (transferMode == FrameTransferSceneProcessor.TransferMode.DOUBLE_BUFFERED) {
            index = 0;
            
            final int dataSize = width * height * 4;
            pixelBufferObjects[0] = createPixelBuffer(dataSize);
            pixelBufferObjects[1] = createPixelBuffer(dataSize);
        }

        JfxPlatform.runInFxThread(() -> setImage());
    }

    private IntBuffer createPixelBuffer(int dataSize) {
        IntBuffer pixelBufferObject = BufferUtils.createIntBuffer(1);

        GL15.glGenBuffers(pixelBufferObject);
        GL15.glBindBuffer(GL21.GL_PIXEL_PACK_BUFFER, pixelBufferObject.get(0));
        GL15.glBufferData(GL21.GL_PIXEL_PACK_BUFFER, dataSize, GL15.GL_STREAM_READ);
        GL15.glBindBuffer(GL21.GL_PIXEL_PACK_BUFFER, 0);

        return pixelBufferObject;
    }

    protected void setImage() { }

    @Override
    public void initFor(Renderer renderer, boolean main) {
        if (main) {
            renderer.setMainFrameBufferOverride(frameBuffer);
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void copyFrameBufferToImage(RenderManager renderManager) {

        while (!frameState.compareAndSet(WAITING_STATE, RUNNING_STATE)) {
            if (frameState.get() == DISPOSED_STATE) {
                return;
            }
        }

        // Convert screenshot.
        try {
            if (transferMode == FrameTransferSceneProcessor.TransferMode.DOUBLE_BUFFERED) {
                index = (index + 1) % 2;
                final int nextIndex = (index + 1) % 2;

                GL15.glBindBuffer(GL21.GL_PIXEL_PACK_BUFFER, pixelBufferObjects[index].get(0));
                GL11.glReadPixels(0, 0, width, height, GL12.GL_BGRA, GL11.GL_UNSIGNED_BYTE, 0);

                GL15.glBindBuffer(GL21.GL_PIXEL_PACK_BUFFER, pixelBufferObjects[nextIndex].get(0));
                GL15.glGetBufferSubData(GL21.GL_PIXEL_PACK_BUFFER, 0, frameByteBuffer);

                GL15.glBindBuffer(GL21.GL_PIXEL_PACK_BUFFER, 0);
            } else {
                GL11.glReadPixels(0, 0, width, height, GL12.GL_BGRA, GL11.GL_UNSIGNED_BYTE, frameByteBuffer);
            }
        } finally {
            if (!frameState.compareAndSet(RUNNING_STATE, WAITING_STATE)) {
                throw new RuntimeException("unknown problem with the frame state");
            }
        }
        JfxPlatform.runInFxThread(this::writeFrame);
    }

    /**
     * Write content to image.
     */
    protected abstract void writeFrame();

    @Override
    public void dispose() {
        while (!frameState.compareAndSet(WAITING_STATE, DISPOSING_STATE)) ;
        while (!imageState.compareAndSet(WAITING_STATE, DISPOSING_STATE)) ;
        disposeImpl();
        frameState.compareAndSet(DISPOSING_STATE, DISPOSED_STATE);
        imageState.compareAndSet(DISPOSING_STATE, DISPOSED_STATE);
    }

    /**
     * Dispose.
     */
    protected void disposeImpl() {
        frameBuffer.dispose();
        BufferUtils.destroyDirectBuffer(frameByteBuffer);
    }
}
