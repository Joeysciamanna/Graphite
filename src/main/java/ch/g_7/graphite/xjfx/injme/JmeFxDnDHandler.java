package ch.g_7.graphite.xjfx.injme;

import static javafx.scene.image.PixelFormat.getByteBgraInstance;
import com.jme3.jfx.injme.input.JmeFXInputListener;
import com.jme3.jfx.util.JfxPlatform;
import com.ss.rlib.logger.api.Logger;
import com.ss.rlib.logger.api.LoggerManager;
import com.sun.javafx.embed.EmbeddedSceneDSInterface;
import com.sun.javafx.embed.EmbeddedSceneDTInterface;
import com.sun.javafx.embed.EmbeddedSceneInterface;
import com.sun.javafx.embed.HostDragStartListener;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.Clipboard;
import javafx.scene.input.TransferMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.ByteBuffer;

/**
 * A very hacky implementation of a DND system, similar to SwingDND but for jme context. <br> Allows
 * for inner application drag and drop support. <br> Cross GuiManager support is untested.
 *
 * @author empire, JavaSaBr
 */
public class JmeFxDnDHandler implements HostDragStartListener {

    @NotNull
    private static final Logger LOGGER = LoggerManager.getLogger(JfxPlatform.class);

    /**
     * The JavaFX container.
     */
    @NotNull
    private JmeFxContainerInternal container;

    /**
     * The drop target.
     */
    @Nullable
    private EmbeddedSceneDTInterface dropTarget;

    /**
     * The drag source.
     */
    @Nullable
    private EmbeddedSceneDSInterface dragSource;

    /**
     * The transfer mode.
     */
    @Nullable
    private TransferMode transferMode;

    /**
     * The drag image.
     */
    @Nullable
    private ImageView dragImage;

    public JmeFxDnDHandler(@NotNull final JmeFxContainerInternal container) {
        this.container = container;
    }

    /**
     * this is kinda ridiculous, but well at least it seems to work
     */
    private void createDragImageProxy(@NotNull final Object image, @NotNull final Object offset) {
        if (!(image instanceof ByteBuffer)) {
            return;
        }

        try {

            final ByteBuffer imageData = (ByteBuffer) image;
            imageData.position(0);

            final int width = imageData.getInt();
            final int height = imageData.getInt();

            final byte[] pixels = new byte[imageData.remaining()];
            imageData.get(pixels);

            final WritableImage resultImage = new WritableImage(width, height);
            final PixelWriter writer = resultImage.getPixelWriter();
            writer.setPixels(0, 0, width, height, getByteBgraInstance(), pixels, 0, width * 4);

            dragImage = new ImageView(resultImage);
            dragImage.setStyle("dragimage:true;");
            dragImage.setMouseTransparent(true);
            dragImage.setVisible(true);

            if (offset instanceof ByteBuffer) {

                final ByteBuffer offsetBuffer = (ByteBuffer) offset;
                offsetBuffer.position(0);

                LOGGER.debug(offsetBuffer, buff -> "Img offset " + buff.getInt() + ", " + buff.getInt());
            }

        } catch (final Exception e) {
            LOGGER.warning(e);
        }
    }

    @Override
    public void dragStarted(@NotNull final EmbeddedSceneDSInterface dragSource, @NotNull final TransferMode transferMode) {

        final JmeFxContainerInternal container = getContainer();
        final Group rootNode = container.getRootNode();
        final JmeFXInputListener inputListener = container.getInputListener();
        final EmbeddedSceneInterface sceneInterface = container.getSceneInterface();

        if (rootNode == null) {
            LOGGER.warning("The root node is null.");
            return;
        } else if (inputListener == null) {
            LOGGER.warning("The input listener is null.");
            return;
        } else if (sceneInterface == null) {
            LOGGER.warning("The scene interface is null.");
            return;
        }

        if (dragImage != null) {
            rootNode.getChildren().remove(dragImage);
            dragImage = null;
        }

        try {

            final Object dragImage = dragSource.getData("application/x-java-drag-image");
            final Object offset = dragSource.getData("application/x-java-drag-image-offset");

            if (dragImage != null) {
                createDragImageProxy(dragImage, offset);
            }

            inputListener.setMouseDNDListener(this);

            assert transferMode == TransferMode.COPY : "Only Copy is supported currently";

            LOGGER.debug(dragSource, transferMode, (source, mode) -> "Drag started of " + source + " in mode " + mode);

            final Clipboard clipboard = Clipboard.getSystemClipboard();

            LOGGER.debug(clipboard, clip -> "Clipboard : " + clip);

            this.dragSource = dragSource;
            this.dropTarget = sceneInterface.createDropTarget();
            // pseudo enter, we only support inner events, so it stays always entered
            this.dropTarget.handleDragEnter(0, 0, 0, 0, TransferMode.COPY, dragSource);

        } catch (final Exception e) {
            LOGGER.warning(e);
        }
    }

    /**
     * Gets the drag image.
     *
     * @return the drag image.
     */
    private @Nullable ImageView getDragImage() {
        return dragImage;
    }

    /**
     * Gets the JavaFX container.
     *
     * @return the JavaFX container.
     */
    private @NotNull JmeFxContainerInternal getContainer() {
        return container;
    }

    /**
     * Gets the drag source.
     *
     * @return the drag source.
     */
    private @Nullable EmbeddedSceneDSInterface getDragSource() {
        return dragSource;
    }

    /**
     * Gets the drop target.
     *
     * @return the drop target.
     */
    private @Nullable EmbeddedSceneDTInterface getDropTarget() {
        return dropTarget;
    }

    public void mouseUpdate(final int x, final int y, final boolean mousePressed) {

        final EmbeddedSceneDSInterface dragSource = getDragSource();
        final EmbeddedSceneDTInterface dropTarget = getDropTarget();

        if (dragSource == null) {
            LOGGER.warning("The drag source is null.");
            return;
        } else if (dropTarget == null) {
            LOGGER.warning("The drop target is null.");
            return;
        }

        final JmeFxContainerInternal container = getContainer();
        final Group rootNode = container.getRootNode();
        final JmeFXInputListener inputListener = container.getInputListener();
        final EmbeddedSceneInterface sceneInterface = container.getSceneInterface();

        if (rootNode == null) {
            LOGGER.warning("The root node is null.");
            return;
        } else if (inputListener == null) {
            LOGGER.warning("The input listener is null.");
            return;
        } else if (sceneInterface == null) {
            LOGGER.warning("The scene interface is null.");
            return;
        }

        final ObservableList<Node> children = rootNode.getChildren();
        final ImageView dragImage = getDragImage();
        try {

            if (mousePressed) {

                if (dragImage != null) {
                    dragImage.relocate(x, y);

                    // only add once it has a valid position
                    if (!children.contains(dragImage)) {
                        children.add(dragImage);
                    }
                }

                transferMode = dropTarget.handleDragOver(x, y, x, y, TransferMode.COPY);

            } else {

                if (dragImage != null) {
                    dragImage.setVisible(false);
                }

                LOGGER.debug("Drag released!");

                if (transferMode != null) {
                    // causes exceptions when done without a target
                    transferMode = dropTarget.handleDragOver(x, y, x, y, TransferMode.COPY);
                    final TransferMode acceptedMode = dropTarget.handleDragDrop(x, y, x, y, TransferMode.COPY);
                    // Necessary to reset final the internal states, and allow final another drag drop
                    dragSource.dragDropEnd(acceptedMode);
                } else {

                    LOGGER.debug("invalid drag target");

                    // seems to be necessary if no dragdrop attempt is being made
                    dropTarget.handleDragLeave();
                    dragSource.dragDropEnd(null);
                }

                inputListener.setMouseDNDListener(null);

                this.dragSource = null;
                this.dropTarget = null;
            }

        } catch (final Exception e) {
            LOGGER.warning(e);
        }
    }
}