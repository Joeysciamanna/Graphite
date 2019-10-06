package ch.g_7.graphite.rendering.shaderprogram;

import static org.lwjgl.opengl.GL20.GL_COMPILE_STATUS;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_LINK_STATUS;
import static org.lwjgl.opengl.GL20.GL_VALIDATE_STATUS;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glDeleteProgram;
import static org.lwjgl.opengl.GL20.glDetachShader;
import static org.lwjgl.opengl.GL20.glGetProgramInfoLog;
import static org.lwjgl.opengl.GL20.glGetProgrami;
import static org.lwjgl.opengl.GL20.glGetShaderInfoLog;
import static org.lwjgl.opengl.GL20.glGetShaderi;
import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glShaderSource;
import static org.lwjgl.opengl.GL20.glUniform1i;
import static org.lwjgl.opengl.GL20.glUniformMatrix4fv;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL20.glValidateProgram;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL20;
import org.lwjgl.system.MemoryStack;

import ch.g_7.util.stream.StreamUtil;
import ch.g_7.util.stuff.Initializable;
import ch.g_7.util.stuff.SecureRunner;


public abstract class AbstractShaderProgram implements Initializable, AutoCloseable{

	protected final Map<String, Integer> uniforms;
	
    private int programId;

    private int vertexShaderId;

    private int fragmentShaderId;
    
    private String vertexCodePath;
    
    private String fragmentCodePath;
    
    public AbstractShaderProgram(String vertexCodePath, String fragmentCodePath) {
    	this.vertexCodePath = vertexCodePath;
    	this.fragmentCodePath = fragmentCodePath;
    	uniforms = new HashMap<>();
	}
    
    public AbstractShaderProgram() {
    	uniforms = new HashMap<>();
    }

    @Override
    public void init() {
        programId = glCreateProgram();
        if (programId == 0) {
            throw new RuntimeException("Could not create Shader");
        }
        SecureRunner<String, String> codeLoader = new SecureRunner<>((s) -> StreamUtil.readString(s, this));
        vertexShaderId = createShader(codeLoader.run(vertexCodePath), GL_VERTEX_SHADER);
        fragmentShaderId = createShader(codeLoader.run(fragmentCodePath), GL_FRAGMENT_SHADER);
        link();
    }
    
    protected final void setUniform(String uniformName, Matrix4f value) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            // Dump the matrix into a float buffer
            FloatBuffer fb = stack.mallocFloat(16);
            value.get(fb);
            glUniformMatrix4fv(uniforms.get(uniformName), false, fb);
        }
    }
    
    protected final void setUniform(String uniformName, Vector4f value) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            // Dump the matrix into a float buffer
            FloatBuffer fb = stack.mallocFloat(4);
            value.get(fb);
            GL20.glUniform4fv(uniforms.get(uniformName), fb);
        }
    }
    
    protected final void setUniform(String uniformName, int value) {
        glUniform1i(uniforms.get(uniformName), value);
    }
    
    protected final void createUniform(String uniformName) {
        int uniformLocation = glGetUniformLocation(programId, uniformName);
        if (uniformLocation < 0) {
            throw new RuntimeException("Could not find uniform:" + uniformName);
        }
        uniforms.put(uniformName, uniformLocation);
    }

    
    private final int createShader(String shaderCode, int shaderType) {
        int shaderId = glCreateShader(shaderType);
        if (shaderId == 0) {
            throw new RuntimeException("Error creating shader. Type: " + shaderType);
        }

        glShaderSource(shaderId, shaderCode);
        glCompileShader(shaderId);

        if (glGetShaderi(shaderId, GL_COMPILE_STATUS) == 0) {
            throw new RuntimeException("Error compiling Shader code: " + glGetShaderInfoLog(shaderId, 1024));
        }

        glAttachShader(programId, shaderId);

        return shaderId;
    }

    private void link() {
        glLinkProgram(programId);
        if (glGetProgrami(programId, GL_LINK_STATUS) == 0) {
            throw new RuntimeException("Error linking Shader code: " + glGetProgramInfoLog(programId, 1024));
        }
        glDetachShader(programId, vertexShaderId);
        glDetachShader(programId, fragmentShaderId);
        glValidateProgram(programId);
        
        if (glGetProgrami(programId, GL_VALIDATE_STATUS) == 0) {
            System.err.println("Warning validating Shader code: " + glGetProgramInfoLog(programId, 1024));
        }
    }
    
    public void bind() {
        glUseProgram(programId);
    }

    public void unbind() {
        glUseProgram(0);
    }

    @Override
    public void close() {
        unbind();
        if (programId != 0) {
            glDeleteProgram(programId);
        }
    }
    
}
