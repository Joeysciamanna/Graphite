package ch.g_7.graphite.rendering;

import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.node.INode;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.glEnable;

public class RenderManager implements Initializable, Closeable {

    private final List<IRenderer<?>> renderers;

    public RenderManager() {
        this.renderers = new ArrayList<>();
    }

    public void render(Window window, Camera camera){
        for (IRenderer<?> renderer : renderers) {
            if(renderer.isUsed()){
                renderer.bind();
                renderer.render(window, camera);
                renderer.unbind();
            }
        }
        glfwSwapBuffers(window.getId());
        glfwPollEvents();
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    }

    @SuppressWarnings("unchecked")
    public <T extends IViewModel> void add(INode<?, T> node){
        for (IRenderer<?> renderer : renderers) {
            if(renderer.getRenderType().equals(node.getViewModel().getRenderType())){
                ((IRenderer<T>)renderer).addRenderable(node);
                return;
            }
        }
        throw new IllegalArgumentException("Node cant be added, no renderer for ["+node+"] registered");
    }

    @SuppressWarnings("unchecked")
    public <T extends IViewModel> void remove(INode<?, T> node){
        for (IRenderer<?> renderer : renderers) {
            if(renderer.getRenderType().equals(node.getViewModel().getRenderType())){
                ((IRenderer<T>)renderer).removeRenderable(node);
                return;
            }
        }
        throw new IllegalArgumentException("Node cant be removed, no renderer for ["+node+"] registered");
    }

    public void register(IRenderer<?> renderer){
        if(renderers.contains(renderer)){
            throw new IllegalArgumentException("Renderer ["+renderer+"] already registered");
        }
        renderers.add(renderer);
        renderer.init();
    }

    @Override
    public void init() {
        glEnable(GL_DEPTH_TEST);

        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_BLEND);
    }

    @Override
    public void close() {
        renderers.forEach(IRenderer::close);
    }


}
