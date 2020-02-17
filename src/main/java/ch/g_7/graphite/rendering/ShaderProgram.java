package ch.g_7.graphite.rendering;

import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;
import org.joml.Matrix4f;
import org.joml.Vector2i;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL20;
import org.lwjgl.system.MemoryStack;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL20.*;

public abstract class ShaderProgram implements Initializable, Closeable {

	protected final Map<String, Integer> uniforms;

	private int programId;

	private int vertexShaderId;

	private int fragmentShaderId;

	private String vertexCode;

	private String fragmentCode;

	public ShaderProgram(String vertexCode, String fragmentCode) {
		this.vertexCode = vertexCode;
		this.fragmentCode = fragmentCode;
		uniforms = new HashMap<>();
	}

	public void init() {
		programId = glCreateProgram();
		if (programId == 0) {
			throw new RuntimeException("Could not create Shader");
		}
		vertexShaderId = createShader(vertexCode, GL_VERTEX_SHADER);
		fragmentShaderId = createShader(fragmentCode, GL_FRAGMENT_SHADER);
		link();
		vertexCode = null;
		fragmentCode = null;
	}


	public void close() {
		unbind();
		if (programId != 0) {
			glDeleteProgram(programId);
		}
	}

	protected final void setUniform(String uniformName, Matrix4f value) {
		try (MemoryStack stack = MemoryStack.stackPush()) {
			// Dump the matrix into a float buffer
			FloatBuffer fb = stack.mallocFloat(16);
			value.get(fb);
			glUniformMatrix4fv(uniforms.get(uniformName), false, fb);
		}
	}

	protected final void setUniform(String uniformName, Vector2i value) {
		try (MemoryStack stack = MemoryStack.stackPush()) {
			// Dump the matrix into a float buffer
			IntBuffer ib = stack.mallocInt(2);
			value.get(ib);
			glUniform2iv(uniforms.get(uniformName), ib);
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

	protected final void setUniform(String uniformName, boolean value) {
		try (MemoryStack stack = MemoryStack.stackPush()) {
			// Dump the matrix into a float buffer
			GL20.glUniform1i(uniforms.get(uniformName), value ? 1 : 0);
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

}
