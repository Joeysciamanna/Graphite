package ch.g_7.graphite.base.mesh.vao;

import ch.g_7.graphite.node.IRenderResource;
import ch.g_7.util.common.Closeable;
import org.lwjgl.opengl.GL20;

import java.util.*;

import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.*;

public class VAO implements Closeable, IRenderResource {

	private final int id;
	private final List<VBO> vbos;

	private final IVBOType[] vboOrder;

	private boolean adding;
	private Queue<VBO> addables;

	public VAO(IVBOType[] vboOrder) {
		this.vboOrder = vboOrder;
		this.vbos = new ArrayList<>(3);
		this.addables = new LinkedList<>();
		this.id = glGenVertexArrays();
	}

	public void add(VBO vbo) {
		if (adding) {
			addables.add(vbo);
			return;
		}
		adding = true;
		add(vbo, true);
		adding = false;
	}

	private void add(VBO vbo, boolean addAdables) {
		for (VBO v : vbos) {
			if (v.getName().equals(vbo.getName())) {
				throw new IllegalArgumentException(vbo.type + " Alredy exist on VAO");
			}
		}
		glBindVertexArray(id);
		vbo.init(this);
		glBindVertexArray(0);
		vbos.add(vbo);

		if (addAdables) {
			while (!addables.isEmpty()) {
				add(addables.poll(), false);
			}
		}
	}

	public void replace(VBO vbo) {
		int index = -1;
		for (int i = 0; i < vbos.size(); i++) {
			if (vbos.get(i).type.equals(vbo.type)) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			throw new IllegalArgumentException(vbo.type + " Cant be replaced, because it doesnt exist");
		}

		glBindVertexArray(id);
		vbo.init(this);
		glBindVertexArray(0);
		vbos.set(index, vbo);
	}

	public void put(VBO vbo) {
		if (contains(vbo.type)) {
			replace(vbo);
		} else {
			add(vbo);
		}
	}

	public boolean contains(IVBOType type) {
		for (int i = 0; i < vbos.size(); i++) {
			if (vbos.get(i).type.equals(type)) {
				return true;
			}
		}
		return false;
	}

	public int getPositionFor(IVBOType vboType) {
		for (int i = 0; i < vboOrder.length; i++) {
			if (vboType.getName().equals(vboOrder[i].getName())) {
				return i;
			}
		}
		throw new IllegalArgumentException("VBOType [" + vboType.getName() + "] is not supported");
	}

	public Optional<VBO> get(VBOType type) {
		for (VBO vbo : vbos) {
			if (vbo.type.equals(type))
				return Optional.of(vbo);
		}
		return Optional.empty();
	}

	@Override
	public void close() {
		glDisableVertexAttribArray(id);

		// Delete the VBOs
		GL20.glBindBuffer(GL20.GL_ARRAY_BUFFER, 0);
		vbos.forEach((vbo) -> vbo.close());

		// Delete the VAO
		glBindVertexArray(0);
		glDeleteVertexArrays(id);
	}

	public void bind() {
		glBindVertexArray(id);
		for (int i = 0; i < vbos.size(); i++) {
			glEnableVertexAttribArray(i);
		}
	}

	public void unbind() {
		glBindVertexArray(0);
		for (int i = 0; i < vbos.size(); i++) {
			glDisableVertexAttribArray(i);
		}
	}

}
