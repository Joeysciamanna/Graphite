package ch.g_7.graphite.rendering.ui;//package ch.g_7.graphite.rendering.ui;

import java.util.List;

import ch.g_7.graphite.base.material.IMaterial;
import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.node.Renderable;
import ch.g_7.graphite.rendering.*;
import ch.g_7.graphite.ui.IUIContainer;
import ch.g_7.graphite.ui.IUIRootContainer;
import ch.g_7.graphite.ui.view_model.IUIViewModel;

import ch.g_7.graphite.rendering.transformator.PixelTransformator;
import ch.g_7.graphite.ui.IUIPanel;
import ch.g_7.graphite.util.Resources;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

/**
 * TODO refactor ui rendering put all in shader programm -> performance
 * @author Joey Sciamanna
 *
 */
public class UIRenderer extends BasicRenderer<IUIViewModel, IUIRootContainer> {

    public UIRenderer() {
        super(new BasicShaderProgram(Resources.UI_VERTEX_SHADER, Resources.UI_FRAGMENT_SHADER), new NodeRenderList<>(), new PixelTransformator());
    }


    @Override
    protected void render(List<IUIRootContainer> renderables) {
        for (IUIRootContainer rootContainer : renderables) {
            if(rootContainer.getViewModel().isVisible()){
                renderPanel(rootContainer);
            }

        }
    }

    private void renderPanel(IUIContainer container) {
        for (IUIPanel child : container.getChildren()) {
			if (child.isVisible()) {
                renderPanel(child);
			}
		}
		render(container);
    }

    private void render(IUIContainer container){
        IUIViewModel viewModel = container.getViewModel();
        IMesh mesh = viewModel.getMesh();

        shaderProgram.setModelViewMatrix(transformator.getModelViewMatrix(container.getTransform()));
        shaderProgram.setColor(viewModel.getColor());

        if (viewModel.getTexture() != null) {
            glActiveTexture(GL_TEXTURE0);
            shaderProgram.setTextureEnabled(true);
        } else {
            shaderProgram.setTextureEnabled(false);
        }
        viewModel.bind();
        glDrawElements(GL11.GL_TRIANGLES, mesh.getVerticesCount(), GL_UNSIGNED_INT, 0);
        viewModel.unbind();
    }

    @Override
    public IRenderType<?> getRenderType() {
        return RenderType.UI;
    }



}
