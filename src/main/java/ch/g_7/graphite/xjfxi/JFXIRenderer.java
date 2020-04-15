package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.IWindow;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.rendering.*;

public class JFXIRenderer implements IRenderer<INode<?, ?>> {

    private final JFXIShaderProgram shaderProgram;
    private final IJFXImage ijfxImage;

    public JFXIRenderer(IJFXImage ijfxImage) {
        this.shaderProgram = new JFXIShaderProgram();
        this.ijfxImage = ijfxImage;
    }

    @Override
    public void render(IWindow window, Camera camera) {

    }


    @Override
    public void bind() {
        shaderProgram.bind();
        shaderProgram.setTextureSampler(0);
    }

    @Override
    public void unbind() {
        shaderProgram.unbind();
    }

    @Override
    public void init() {
        shaderProgram.init();
    }

    @Override
    public void close() {
        shaderProgram.close();
    }

    @Override
    public IRenderType<?> getRenderType() {
        return RenderType.JFXI;
    }

    @Override
    public void addRenderable(INode<?, ?> renderable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeRenderable(INode<?, ?> renderable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isUsed() {
        return true;
    }


}
