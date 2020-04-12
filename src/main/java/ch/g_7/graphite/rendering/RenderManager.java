package ch.g_7.graphite.rendering;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.IWindow;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.rendering.entity.EntityRenderer;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.glEnable;

public class RenderManager implements Initializable, Closeable {

    private final List<IRenderer<?>> renderers;

    public RenderManager() {
        this.renderers = new ArrayList<>();
    }

    public void render(IWindow window, Camera camera){
        window.bind();
        for (IRenderer<?> renderer : renderers) {
            if(renderer.isUsed()){
                renderer.bind();
                renderer.render(window, camera);
                renderer.unbind();
            }
        }
        window.unbind();
    }

    @SuppressWarnings("unchecked")
    public <T extends INode<?,?>> void add(T node){
        for (IRenderer<?> renderer : renderers) {
            if(renderer.getRenderType().equals(node.getViewModel().getRenderType())){
                ((IRenderer<T>)renderer).addRenderable(node);
                return;
            }
        }
        throw new IllegalArgumentException("Node cant be added, no renderer for ["+node+"] registered");
    }

    @SuppressWarnings("unchecked")
    public  <T extends INode<?,?>> void remove(T node){
        for (IRenderer<?> renderer : renderers) {
            if(renderer.getRenderType().equals(node.getViewModel().getRenderType())){
                ((IRenderer<T>)renderer).removeRenderable(node);
                return;
            }
        }
        throw new IllegalArgumentException("Node cant be removed, no renderer for ["+node+"] registered");
    }

    public <T extends IViewModel> void clear(IRenderType<?> renderType){
        for (IRenderer<?> renderer : renderers) {
            if(renderer.getRenderType().equals(renderType)){
                renderer.clear();
                return;
            }
        }
        throw new IllegalArgumentException("Renderer cant be cleared, no renderer ["+renderType+"] registered");
    }

    public <T extends IViewModel> void clear(){
        for (IRenderer<?> renderer : renderers) {
            renderer.clear();
        }
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
        register(new EntityRenderer());

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
