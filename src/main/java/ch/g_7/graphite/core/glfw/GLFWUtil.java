package ch.g_7.graphite.core.glfw;

import ch.g_7.graphite.core.input.KeyAction;
import ch.g_7.graphite.core.input.KeyCode;

public class GLFWUtil {


    public static KeyCode mapKeyCode(int glfwKeyCode){
        return KeyCode.KEY_0;
    }

    public static KeyAction mapKeyAction(int glfwKeyAction){
        return KeyAction.PRESSED;
    }

    public static KeyCode mapMouseKey(int button) {
        return null;
    }
}
