package ch.g_7.graphite.core.glfw;

import ch.g_7.graphite.core.IWindow;
import ch.g_7.graphite.input.InputManager;
import ch.g_7.graphite.input.KeyEvent;
import ch.g_7.graphite.input.MouseEvent;
import ch.g_7.graphite.util.Color;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import java.nio.DoubleBuffer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class GLFWWindow implements IWindow {

    static {
        //TODO refactor ugly static stuff
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

    private long id;
    private final String title;

    private final InputManager inputManager;

    private int x;
    private int y;
    private int width = 500;
    private int height = 500;
    private boolean visible;

    public GLFWWindow(InputManager inputManager, String title) {
        this.inputManager = inputManager;
        this.title = title;
    }

    @Override
    public void init() {

        id = glfwCreateWindow(width, height, title, NULL, NULL);
        if (id == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        glfwSetFramebufferSizeCallback(id, (window, width, height) -> setSize(width, height));

        glfwSetWindowPosCallback(id, (window, x, y) -> setPosition(x, y));

        glfwSetKeyCallback(id, (window, key, scancode, action, mods) -> {
            inputManager.register(new KeyEvent(GLFWUtil.mapKeyCode(key), GLFWUtil.mapKeyAction(action)));
       });

        glfwSetMouseButtonCallback(id, (long window, int button, int action, int mods) -> {
            DoubleBuffer x = BufferUtils.createDoubleBuffer(1);
            DoubleBuffer y = BufferUtils.createDoubleBuffer(1);
            glfwGetCursorPos(id, x, y);
            inputManager.register(new MouseEvent(GLFWUtil.mapMouseKey(button), GLFWUtil.mapKeyAction(action), new Vector2i((int) x.get(),(int) y.get())));
        });

        glfwMakeContextCurrent(id);

        GL.createCapabilities();
        glfwSwapInterval(0);

        setSize(width, height);

        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        setPosition((vidmode.width() - width) / 2, (vidmode.height() - height) / 2);

        setClearColor(Color.TRANSPARENT);
    }

    @Override
    public void close() {
        glfwDestroyWindow(id);
    }

    @Override
    public void update(float deltaMillis) {
        glfwPollEvents();
        inputManager.reportAll();
    }

    @Override
    public void bind() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    }

    @Override
    public void unbind() {
        glfwSwapBuffers(id);
    }


    @Override
    public Vector2ic getSize() {
        return new Vector2i(width, height);
    }

    @Override
    public void setSize(int width, int height) {
        glfwSetWindowSize(id, width, height);
        glViewport(0, 0, width, height);
        this.width = width;
        this.height = height;
    }

    @Override
    public Vector2ic getPosition() {
        return new Vector2i(x, y);
    }

    @Override
    public void setPosition(int x, int y) {
        glfwSetWindowPos(id, x, y);
        this.x = x;
        this.y = y;
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            glfwShowWindow(id);
        } else {
            glfwHideWindow(id);
        }
        this.visible = visible;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }


    @Override
    public void requestFocus() {
        glfwRequestWindowAttention(id);
    }

    @Override
    public void setClearColor(Color color) {
        glClearColor(color.getR(), color.getG(), color.getB(), color.getA());
    }

    @Override
    public boolean shouldClose() {
        return glfwWindowShouldClose(id);
    }

    @Override
    public boolean setTitle(String title) {
        glfwSetWindowTitle(id, title);
        return true;
    }

    @Deprecated
    public boolean isKeyPressed(int keyCode) {
        return glfwGetKey(id, keyCode) == GLFW_PRESS;
    }
}
