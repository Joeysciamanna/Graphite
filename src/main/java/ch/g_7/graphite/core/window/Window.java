package ch.g_7.graphite.core.window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.nio.DoubleBuffer;

import ch.g_7.util.logging.LogLevel;
import ch.g_7.util.logging.adapter.OutputSteamAdapter;
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
import org.lwjgl.opengl.GLUtil;

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

		//glfwWindowHint(GLFW_OPENGL_DEBUG_CONTEXT, GL_TRUE);
		id = glfwCreateWindow(width, height, title, NULL, NULL);
		if (id == NULL) {
			throw new RuntimeException("Failed to create the GLFW window");
		}

		glfwSetFramebufferSizeCallback(id, (window, width, height) -> {
				resizeNotifier.overrideQueue(new ResizeEvent(window, width, height));
		});

		glfwSetWindowPosCallback(id, (window, x, y) -> setPosition(x, y));

		glfwSetKeyCallback(id, (window, key, scancode, action, mods) -> {
			keyNotifier.addToQueue(new KeyEvent(key, scancode, action, mods));
		});

		glfwSetMouseButtonCallback(id, (long window, int button, int action, int mods) -> {
			DoubleBuffer x = BufferUtils.createDoubleBuffer(1);
			DoubleBuffer y = BufferUtils.createDoubleBuffer(1);
			glfwGetCursorPos(id, x, y);
			mouseNotifier.addToQueue(new MouseEvent(button, action, mods, (int) x.get(), (int) y.get()));
		});

		glfwMakeContextCurrent(id);

		GL.createCapabilities();
		//GLUtil.setupDebugMessageCallback();


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
		resizeNotifier.addToQueue(new ResizeEvent(id, width, height));
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
