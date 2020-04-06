package ch.g_7.graphite.xjfx.injfx;

import ch.g_7.graphite.xjfx.injfx.processor.CanvasFrameTransferSceneProcessor;
import ch.g_7.graphite.xjfx.injfx.processor.FrameTransferSceneProcessor;
import ch.g_7.graphite.xjfx.injfx.processor.ImageViewFrameTransferSceneProcessor;
import com.jme3.renderer.ViewPort;
import com.jme3.system.AppSettings;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;

import java.util.function.Function;

/**
 * The type Jme to jfx integrator.
 *
 * @author JavaSaBr
 */
public class JmeToJfxIntegrator {

    private static final ApplicationThreadExecutor EXECUTOR = ApplicationThreadExecutor.getInstance();

    /**
     * Prepare settings.
     *
     * @param settings  the settings
     * @return the correct render settings applied to the settings
     */
    public static @NotNull AppSettings prepareSettings(@NotNull AppSettings settings) {
        settings.setFullscreen(false);
        settings.setCustomRenderer(JmeOffscreenSurfaceContext.class);
        return settings;
    }

    /**
     * Start and bind frame transfer scene processor.
     *
     * @param application  the application
     * @param imageView    the image view
     * @param factory      the factory
     * @param transferMode the transferMode
     * @return the frame transfer scene processor
     */
    public static @NotNull
    FrameTransferSceneProcessor startAndBind(
            @NotNull final JmeToJfxApplication application,
            @NotNull final ImageView imageView,
            @NotNull final Function<Runnable, Thread> factory,
            @NotNull final FrameTransferSceneProcessor.TransferMode transferMode
    ) {

        factory.apply(application::start).start();

        var processor = new ImageViewFrameTransferSceneProcessor();
        processor.setTransferMode(transferMode);

        Platform.runLater(() ->
                application.enqueue(() ->
                        processor.bind(imageView, application)));

        return processor;
    }

    /**
     * Start and bind frame transfer scene processor.
     *
     * @param application  the application
     * @param imageView    the image view
     * @param factory      the factory
     * @param transferMode the transferMode
     * @return the frame transfer scene processor
     */
    public static @NotNull FrameTransferSceneProcessor startAndBindMainViewPort(
            @NotNull final JmeToJfxApplication application,
            @NotNull final ImageView imageView,
            @NotNull final Function<Runnable, Thread> factory,
            @NotNull final FrameTransferSceneProcessor.TransferMode transferMode
    ) {

        factory.apply(application::start).start();

        var processor = new ImageViewFrameTransferSceneProcessor();
        processor.setTransferMode(transferMode);

        EXECUTOR.addToExecute(() ->
                processor.bind(imageView, application, application.getViewPort()));

        return processor;
    }

    /**
     * Start and bind frame transfer scene processor.
     *
     * @param application  the application
     * @param canvas       the canvas
     * @param factory      the factory
     * @param transferMode the transferMode
     * @return the frame transfer scene processor
     */
    public static @NotNull FrameTransferSceneProcessor startAndBind(
            @NotNull final JmeToJfxApplication application,
            @NotNull final Canvas canvas,
            @NotNull final Function<Runnable, Thread> factory,
            @NotNull final FrameTransferSceneProcessor.TransferMode transferMode
    ) {

        factory.apply(application::start).start();

        var processor = new CanvasFrameTransferSceneProcessor();
        processor.setTransferMode(transferMode);

        Platform.runLater(() ->
                application.enqueue(() ->
                        processor.bind(canvas, application)));

        return processor;
    }

    /**
     * Start and bind frame transfer scene processor.
     *
     * @param application  the application
     * @param canvas       the canvas.
     * @param factory      the factory
     * @param transferMode the transferMode
     * @return the frame transfer scene processor
     */
    public static @NotNull FrameTransferSceneProcessor startAndBindMainViewPort(
            @NotNull final JmeToJfxApplication application,
            @NotNull final Canvas canvas,
            @NotNull final Function<Runnable, Thread> factory,
            @NotNull final FrameTransferSceneProcessor.TransferMode transferMode
    ) {

        factory.apply(application::start).start();

        var processor = new CanvasFrameTransferSceneProcessor();
        processor.setTransferMode(transferMode);

        EXECUTOR.addToExecute(() ->
                processor.bind(canvas, application, application.getViewPort()));

        return processor;
    }

    /**
     * Bind frame transfer scene processor.
     *
     * @param application the application
     * @param imageView   the image view
     * @return the frame transfer scene processor
     */
    public static @NotNull FrameTransferSceneProcessor bind(
            @NotNull JmeToJfxApplication application,
            @NotNull ImageView imageView
    ) {

        var processor = new ImageViewFrameTransferSceneProcessor();
        processor.bind(imageView, application);

        return processor;
    }

    /**
     * Bind frame transfer scene processor.
     *
     * @param application the application
     * @param canvas      the canvas
     * @return the frame transfer scene processor
     */
    public static @NotNull FrameTransferSceneProcessor bind(
            @NotNull JmeToJfxApplication application,
            @NotNull Canvas canvas
    ) {

        var processor = new CanvasFrameTransferSceneProcessor();
        processor.bind(canvas, application);

        return processor;
    }

    /**
     * Bind frame transfer scene processor.
     *
     * @param application the application
     * @param imageView   the image view
     * @param viewPort    the view port
     * @return the frame transfer scene processor
     */
    public static @NotNull FrameTransferSceneProcessor bind(
            @NotNull JmeToJfxApplication application,
            @NotNull ImageView imageView,
            @NotNull ViewPort viewPort
    ) {

        var processor = new ImageViewFrameTransferSceneProcessor();
        processor.bind(imageView, application, viewPort);

        return processor;
    }

    /**
     * Bind frame transfer scene processor.
     *
     * @param application the application
     * @param canvas      the canvas
     * @param viewPort    the view port
     * @return the frame transfer scene processor
     */
    public static @NotNull FrameTransferSceneProcessor bind(
            @NotNull JmeToJfxApplication application,
            @NotNull Canvas canvas,
            @NotNull ViewPort viewPort
    ) {

        var processor = new CanvasFrameTransferSceneProcessor();
        processor.bind(canvas, application, viewPort);

        return processor;
    }

    /**
     * Bind frame transfer scene processor.
     *
     * @param application the application
     * @param imageView   the image view
     * @param inputNode   the input node
     * @return the frame transfer scene processor
     */
    public static @NotNull FrameTransferSceneProcessor bind(
            @NotNull JmeToJfxApplication application,
            @NotNull ImageView imageView,
            @NotNull Node inputNode
    ) {

        var processor = new ImageViewFrameTransferSceneProcessor();
        processor.bind(imageView, application, inputNode);

        return processor;
    }

    /**
     * Bind frame transfer scene processor.
     *
     * @param application the application
     * @param canvas      the canvas
     * @param inputNode   the input node
     * @return the frame transfer scene processor
     */
    public static @NotNull FrameTransferSceneProcessor bind(
            @NotNull JmeToJfxApplication application,
            @NotNull Canvas canvas,
            @NotNull Node inputNode
    ) {

        var processor = new CanvasFrameTransferSceneProcessor();
        processor.bind(canvas, application, inputNode);

        return processor;
    }

    /**
     * Bind frame transfer scene processor.
     *
     * @param application the application
     * @param imageView   the image view
     * @param inputNode   the input node
     * @param viewPort    the view port
     * @param main        the main
     * @return the frame transfer scene processor
     */
    public static @NotNull FrameTransferSceneProcessor bind(
            @NotNull JmeToJfxApplication application,
            @NotNull ImageView imageView,
            @NotNull Node inputNode,
            @NotNull ViewPort viewPort,
            boolean main
    ) {

        var processor = new ImageViewFrameTransferSceneProcessor();
        processor.bind(imageView, application, inputNode, viewPort, main);

        return processor;
    }

    /**
     * Bind frame transfer scene processor.
     *
     * @param application the application
     * @param canvas      the canvas
     * @param inputNode   the input node
     * @param viewPort    the view port
     * @param main        the main
     * @return the frame transfer scene processor
     */

    public static @NotNull FrameTransferSceneProcessor bind(
            @NotNull JmeToJfxApplication application,
            @NotNull Canvas canvas,
            @NotNull Node inputNode,
            @NotNull ViewPort viewPort,
            boolean main
    ) {

        var processor = new CanvasFrameTransferSceneProcessor();
        processor.bind(canvas, application, inputNode, viewPort, main);

        return processor;
    }
}
