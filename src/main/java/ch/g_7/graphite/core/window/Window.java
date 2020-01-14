package ch.g_7.graphite.core.window;

import static org.lwjgl.glfw.GLFW.GLFW_CONTEXT_VERSION_MAJOR;
import static org.lwjgl.glfw.GLFW.GLFW_CONTEXT_VERSION_MINOR;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_CORE_PROFILE;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_FORWARD_COMPAT;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_PROFILE;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwGetCursorPos;
import static org.lwjgl.glfw.GLFW.glfwGetKey;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwHideWindow;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwSetFramebufferSizeCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPosCallback;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import ch.g_7.graphite.node.Updatable;
import ch.g_7.graphite.util.Color;
import ch.g_7.util.common.Initializable;
import ch.g_7.util.task.TaskInputQueue;
import ch.g_7.util.task.ValueChangeNotifier;

public class Window implements Initializable, ResizeListner {

	private final String title;

	private List<KeyListner> keyListners;
	private TaskInputQueue<KeyEvent> keyPressBuffer;

	private List<MouseListner> mouseListners;
	private TaskInputQueue<MouseEvent> mouseClickBuffer;

	private long id;

	private int width;
	private int height;
	private ValueChangeNotifier<ResizeEvent> resizeNotifier;

	private int x;
	private int y;
	private boolean repositioned;
	
	private boolean shouldClose;

	public Window(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyListners = new ArrayList<>();
		keyPressBuffer = new TaskInputQueue<KeyEvent>((i) -> keyListners.forEach((l) -> l.onKeyPress(i)));
		mouseListners = new ArrayList<>();
		mouseClickBuffer = new TaskInputQueue<MouseEvent>((i) -> mouseListners.forEach((l) -> l.onMouseClick(i)));
		resizeNotifier = new ValueChangeNotifier<>();
		resizeNotifier.addListner(this);
	}

	static {
		GLFWErrorCallback.createPrint(System.err).set();
	
		if (!glfwInit()) {
			throw new IllegalStateException("Unable to initialize GLFW");
		}

		glfwDefaultWindowHints(); // optional, the current window hints are already the default
		glfwWindowHint(GLFW_VISIBLE, GL_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE); // the window will be resizable
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
	}

	@Override
	public void init() {
		id = glfwCreateWindow(width, height, title, NULL, NULL);
		if (id == NULL) {
			throw new RuntimeException("Failed to create the GLFW window");
		}

		glfwSetFramebufferSizeCallback(id,
				(window, width, height) -> resizeNotifier.valueChanged(new ResizeEvent(window, width, height)));

		glfwSetWindowPosCallback(id, (window, x, y) -> setPosition(x, y));

		glfwSetKeyCallback(id, (window, key, scancode, action, mods) -> keyPressBuffer
				.add(new KeyEvent(key, scancode, action, mods)));

		glfwSetMouseButtonCallback(id, (long window, int button, int action, int mods) -> {
			DoubleBuffer x = BufferUtils.createDoubleBuffer(1);
			DoubleBuffer y = BufferUtils.createDoubleBuffer(1);
			glfwGetCursorPos(id, x, y);
			mouseClickBuffer.add(new MouseEvent(button, action, mods, (int) x.get(), (int) y.get()));
		});

		glfwMakeContextCurrent(id);

		GL.createCapabilities();

		setSize(width, height);

		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		setPosition((vidmode.width() - width) / 2, (vidmode.height() - height) / 2);

		setBackgroundColor(Color.getColor(0, 0, 0, 0));
	}

	public void update() {
		resizeNotifier.run();
		reposition();
	}

	public void pullEvents() {
		keyPressBuffer.run();
		mouseClickBuffer.run();
		shouldClose = glfwWindowShouldClose(id);
	}

	@Override
	public void onResize(ResizeEvent action) {
		this.width = action.getWidth();
		this.height = action.getHeight();
		glViewport(0, 0, width, height);
		GLFW.glfwSetWindowSize(id, width, height);
	}

	public void setSize(int width, int height) {
		resizeNotifier.valueChanged(new ResizeEvent(id, width, height));
	}

	private void reposition() {
		if (repositioned) {
			glfwSetWindowPos(id, x, y);
		}
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		this.repositioned = true;
	}

	public void setVisible(boolean visible) {
		if (visible) {
			glfwShowWindow(id);
		} else {
			glfwHideWindow(id);
		}
	}

	public void setBackgroundColor(Color color) {
		glClearColor(color.getR(), color.getG(), color.getB(), color.getA());
	}

	public long getId() {
		return id;
	}

	public void addKeyListner(KeyListner keyListner) {
		keyListners.add(keyListner);
	}

	public void removeKeyListner(KeyListner keyListner) {
		keyListners.remove(keyListner);
	}
	
	public void addMouseListner(MouseListner mouseListner) {
		mouseListners.add(mouseListner);
	}

	public void removeMouseListner(MouseListner mouseListner) {
		mouseListners.remove(mouseListner);
	}

	public void addResizeListner(ResizeListner resizeListner) {
		resizeNotifier.addListner(resizeListner);
	}

	public void removeResizeListner(ResizeListner resizeListner) {
		resizeNotifier.removeListner(resizeListner);
	}

	public boolean windowShouldClose() {
		return shouldClose;
	}

	public String getTitle() {
		return title;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Vector2ic getSize() {
		return new Vector2i(width, height);
	}

}
