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

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import ch.g_7.graphite.util.Color;
import ch.g_7.util.common.Initializable;
import ch.g_7.util.listner.Notifier;

public class Window implements Initializable, ResizeListner {

	private long id;
	private final String title;

	private Notifier<KeyEvent> keyNotifier;
	private Notifier<MouseEvent> mouseNotifier;
	private Notifier<ResizeEvent> resizeNotifier;

	private boolean repositioned;
	
	private int x;
	private int y;

	private int width = 500;
	private int height = 500;


	public Window(String title) {
		this.title = title;
		
		this.keyNotifier = new Notifier<KeyEvent>();
		this.mouseNotifier = new Notifier<MouseEvent>();
		this.resizeNotifier = new Notifier<ResizeEvent>();
		
		this.resizeNotifier.addListner(this);
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

		glfwSetFramebufferSizeCallback(id, (window, width, height) -> {
				resizeNotifier.putEvent(new ResizeEvent(window, width, height));
		});

		glfwSetWindowPosCallback(id, (window, x, y) -> setPosition(x, y));

		glfwSetKeyCallback(id, (window, key, scancode, action, mods) -> {
			keyNotifier.addEvent(new KeyEvent(key, scancode, action, mods));	
		});

		glfwSetMouseButtonCallback(id, (long window, int button, int action, int mods) -> {
			DoubleBuffer x = BufferUtils.createDoubleBuffer(1);
			DoubleBuffer y = BufferUtils.createDoubleBuffer(1);
			glfwGetCursorPos(id, x, y);
			mouseNotifier.addEvent(new MouseEvent(button, action, mods, (int) x.get(), (int) y.get()));
		});

		glfwMakeContextCurrent(id);

		GL.createCapabilities();

		setSize(width, height);

		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		setPosition((vidmode.width() - width) / 2, (vidmode.height() - height) / 2);

		setBackgroundColor(Color.getColor(0, 0, 0, 0));
	}

	public void pullEvents() {
		reposition();
		resizeNotifier.reportAll();
		keyNotifier.reportAll();
		mouseNotifier.reportAll();
	}

	@Override
	public void onAction(ResizeEvent action) {
		this.width = action.getWidth();
		this.height = action.getHeight();
		glViewport(0, 0, width, height);
		GLFW.glfwSetWindowSize(id, width, height);
	}

	public void setSize(int width, int height) {
		resizeNotifier.addEvent(new ResizeEvent(id, width, height));
	}

	private void reposition() {
		if (repositioned) {
			glfwSetWindowPos(id, x, y);
			repositioned = false;
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
		keyNotifier.addListner(keyListner);
	}

	public void removeKeyListner(KeyListner keyListner) {
		keyNotifier.removeListner(keyListner);
	}
	
	public void addMouseListner(MouseListner mouseListner) {
		mouseNotifier.addListner(mouseListner);
	}

	public void removeMouseListner(MouseListner mouseListner) {
		mouseNotifier.removeListner(mouseListner);
	}

	public void addResizeListner(ResizeListner resizeListner) {
		resizeNotifier.addListner(resizeListner);
	}

	public void removeResizeListner(ResizeListner resizeListner) {
		resizeNotifier.removeListner(resizeListner);
	}

	public boolean windowShouldClose() {
		return glfwWindowShouldClose(id);
	}

	@Deprecated
	public boolean isKeyPressed(int keyCode) {
		return glfwGetKey(id, keyCode) == GLFW_PRESS;
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
