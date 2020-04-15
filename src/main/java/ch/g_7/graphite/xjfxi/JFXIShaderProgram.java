package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.rendering.ShaderProgram;
import ch.g_7.graphite.util.Color;
import ch.g_7.graphite.util.Resources;
import org.joml.Matrix4f;

public class JFXIShaderProgram extends ShaderProgram {

    public JFXIShaderProgram() {
        super(Resources.JFXI_VERTEX_SHADER, Resources.JFXI_FRAGMENT_SHADER);
    }

    @Override
    public void init() {
        super.init();
        createUniform("img");
    }


    public void setTextureSampler(int value) {
        setUniform("img", value);
    }

}
