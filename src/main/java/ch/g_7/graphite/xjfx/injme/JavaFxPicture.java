package ch.g_7.graphite.xjfx.injme;

import ch.g_7.graphite.xjfx.injme.util.JmeWindowUtils;
import com.jme3.system.JmeContext;
import com.jme3.ui.Picture;
import com.sun.javafx.embed.EmbeddedStageInterface;

/**
 * The implementation of the {@link Picture} to represent javaFX UI Scene.
 *
 * @author JavaSaBr
 */
public class JavaFxPicture extends Picture {



    /**
     * The JavaFX container.
     */
    private final JmeFxContainerInternal container;

    public JavaFxPicture(final JmeFxContainerInternal container) {
        super("JavaFxContainer", true);
        this.container = container;
    }

    /**
     * Gets the JavaFX container.
     *
     * @return the JavaFX container.
     */
    private JmeFxContainerInternal getContainer() {
        return container;
    }

    @Override
    public void updateLogicalState(final float tpf) {

        final JmeFxContainerInternal container = getContainer();
        final JmeContext jmeContext = container.getJmeContext();
        try {

            final EmbeddedStageInterface stageInterface = container.getStageInterface();
            if (stageInterface == null) {
                return;
            }

            final int windowWidth = JmeWindowUtils.getWidth(jmeContext);
            final int windowHeight = JmeWindowUtils.getHeight(jmeContext);

            if (windowWidth != container.getSceneWidth() || windowHeight != container.getSceneHeight()) {
                container.fitSceneToWindowSize();
            }

            final int currentX = JmeWindowUtils.getX(jmeContext);
            final int currentY = JmeWindowUtils.getY(jmeContext);

            if (container.getPositionX() != currentX || container.getPositionY() != currentY) {
                container.move(currentX, currentY);
            }

        } finally {
            super.updateLogicalState(tpf);
        }
    }
}
