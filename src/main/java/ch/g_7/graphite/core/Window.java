package ch.g_7.graphite.core;

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
import static org.lwjgl.glfw.GLFW.glfwGetKey;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwHideWindow;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetFramebufferSizeCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import ch.g_7.graphite.util.Color;
import ch.g_7.util.stuff.Initializable;

public class Window implements KeyListner, Initializable{

	private final String title;

	private List<KeyListner> keyListners;

	private long windowId;

	private int width;
	private int height;
	
	public Window(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyListners = new ArrayList<KeyListner>();
	}
	
	public long getWindowId() {
		return windowId;
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
		windowId = glfwCreateWindow(width, height, title, NULL, NULL);
		if (windowId == NULL) {
			throw new RuntimeException("Failed to create the GLFW window");
		}
		// Setup resize callback
		glfwSetFramebufferSizeCallback(windowId, (window, width, height) -> {
			setSize(width, height);
		});
		
		// Setup a key callback. It will be called every time a key is pressed, repeated
		// or released.
		glfwSetKeyCallback(windowId, (window, key, scancode, action, mods) -> {
			onKeyPress(window, key, scancode, action, mods);
		});
		
		GLFW.glfwSetWindowSize(windowId, width, height);
		
		center();
	
		requestFocus();
		
		GL.createCapabilities();

		setSize(width, height);
		
//		glfwSwapInterval(0);
		
		setBackgroundColor(new Color(0, 0, 0, 0));
		glEnable(GL_DEPTH_TEST);
	}
	
	@Override
	public void onKeyPress(long window, int key, int scancode, int action, int mods) {
		for (KeyListner keyListner : keyListners) {
			keyListner.onKeyPress(window, key, scancode, action, mods);
		}
	}

	public void addKeyListner(KeyListner keyListner) {
		keyListners.add(keyListner);
	}

	public void removeKeyListner(KeyListner keyListner) {
		keyListners.remove(keyListner);
	}

	public void requestFocus() {
		glfwMakeContextCurrent(windowId);
	}

	public void setVisible(boolean visible) {
		if (visible) {
			glfwShowWindow(windowId);
		} else {
			glfwHideWindow(windowId);
		}
	}

	public void center() {
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(windowId, (vidmode.width() - width) / 2, (vidmode.height() - height) / 2);
	}

	public void setSize(int width, int height) {
		glViewport(0, 0, width, height);
		GLFW.glfwSetWindowSize(windowId, width, height);
		this.width = width;
		this.height = height;
	}

	public void setBackgroundColor(Color color) {
		glClearColor(color.getR(), color.getG(), color.getB(), color.getA());
	}

	public boolean isKeyPressed(int keyCode) {
		return glfwGetKey(windowId, keyCode) == GLFW_PRESS;
	}

	public boolean windowShouldClose() {
		return glfwWindowShouldClose(windowId);
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

	public void update() {
		glfwSwapBuffers(windowId);
		glfwPollEvents();
	}

}
