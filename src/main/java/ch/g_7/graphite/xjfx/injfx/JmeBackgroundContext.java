package ch.g_7.graphite.xjfx.injfx;

import com.jme3.system.AppSettings;
import com.jme3.system.lwjgl.LwjglOffscreenBuffer;
import com.jme3.system.lwjgl.LwjglWindow;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.lwjgl.glfw.GLFW.*;


/**
 * Overrides the runLoop {@link LwjglWindow} to fix the framerate limit
 */
public class JmeBackgroundContext extends LwjglOffscreenBuffer {

    private static final Logger LOGGER = Logger.getLogger(JmeBackgroundContext.class.getName());

    private double frameSleepTime;
    private int frameRateLimit = -1;

    public JmeBackgroundContext(AppSettings settings) {
        super();
        setSettings(settings);
    }

    /**
     * execute one iteration of the render loop in the OpenGL thread
     */
    @Override
    protected void runLoop() {
        // If a restart is required, lets recreate the context.
        if (needRestart.getAndSet(false)) {
            try {
                destroyContext();
                createContext(settings);
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "Failed to set display settings!", ex);
            }

            LOGGER.fine("Display restarted.");
        }

        if (!created.get()) {
            throw new IllegalStateException();
        }

        listener.update();

        // All this does is call swap buffers
        // If the canvas is not active, there's no need to waste time
        // doing that ..
        if (renderable.get()) {
            // calls swap buffers, etc.
            try {
                if (allowSwapBuffers && autoFlush) {
                    glfwSwapBuffers(getWindowHandle());
                }
            } catch (Throwable ex) {
                listener.handleError("Error while swapping buffers", ex);
            }
        }

        // Subclasses just call GLObjectManager clean up objects here
        // it is safe .. for now.
        if (renderer != null) {
            renderer.postFrame();
        }

        if (autoFlush) {
            if (frameRateLimit != getSettings().getFrameRate()) {
                setFrameRateLimit(getSettings().getFrameRate());
            }
        } else if (frameRateLimit != 20) {
            setFrameRateLimit(20);
        }

        if (frameRateLimit > 0) {
            while (frameSleepTime > timer.getTime()) {
                Thread.yield();
            }
            timer.reset();
        }

        glfwPollEvents();
    }

    private void setFrameRateLimit(int frameRateLimit) {
        this.frameRateLimit = frameRateLimit;
        frameSleepTime = 1000000000.0 / this.frameRateLimit;
    }
}