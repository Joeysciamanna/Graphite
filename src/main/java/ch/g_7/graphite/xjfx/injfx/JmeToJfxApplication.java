package ch.g_7.graphite.xjfx.injfx;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.post.FilterPostProcessor;

/**
 * The base implementation of {@link Application} for using in the JavaFX.
 *
 * @author JavaSaBr.
 */
public class JmeToJfxApplication extends SimpleApplication {

    private static final ApplicationThreadExecutor EXECUTOR = ApplicationThreadExecutor.getInstance();

    /**
     * The post filter processor.
     */
    protected FilterPostProcessor postProcessor;

    public JmeToJfxApplication() {
    }

    @Override
    public void update() {
        EXECUTOR.execute();
        super.update();
    }

    @Override
    public void simpleInitApp() {
        postProcessor = new FilterPostProcessor(assetManager);
        postProcessor.initialize(renderManager, viewPort);
        viewPort.addProcessor(postProcessor);
    }

    /**
     * Get the post filter processor.
     *
     * @return the post filter processor.
     */
    protected @NotNull FilterPostProcessor getPostProcessor() {
        return notNull(postProcessor);
    }
}
