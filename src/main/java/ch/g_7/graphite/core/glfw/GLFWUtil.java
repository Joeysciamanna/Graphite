package ch.g_7.graphite.core.glfw;

import ch.g_7.graphite.input.KeyAction;
import ch.g_7.graphite.input.KeyCode;
import ch.g_7.util.logging.Logging;
import org.lwjgl.glfw.GLFW;

public class GLFWUtil {


    public static KeyCode mapKeyCode(int glfwKeyCode) {
        switch (glfwKeyCode) {
            case GLFW.GLFW_KEY_Q:
                return KeyCode.KEY_Q;
            case GLFW.GLFW_KEY_W:
                return KeyCode.KEY_W;
            case GLFW.GLFW_KEY_E:
                return KeyCode.KEY_E;
            case GLFW.GLFW_KEY_R:
                return KeyCode.KEY_R;
            case GLFW.GLFW_KEY_T:
                return KeyCode.KEY_T;
            case GLFW.GLFW_KEY_Z:
                return KeyCode.KEY_Z;
            case GLFW.GLFW_KEY_U:
                return KeyCode.KEY_U;
            case GLFW.GLFW_KEY_I:
                return KeyCode.KEY_I;
            case GLFW.GLFW_KEY_O:
                return KeyCode.KEY_O;
            case GLFW.GLFW_KEY_P:
                return KeyCode.KEY_P;
            case GLFW.GLFW_KEY_A:
                return KeyCode.KEY_A;
            case GLFW.GLFW_KEY_S:
                return KeyCode.KEY_S;
            case GLFW.GLFW_KEY_D:
                return KeyCode.KEY_D;
            case GLFW.GLFW_KEY_F:
                return KeyCode.KEY_F;
            case GLFW.GLFW_KEY_G:
                return KeyCode.KEY_G;
            case GLFW.GLFW_KEY_H:
                return KeyCode.KEY_H;
            case GLFW.GLFW_KEY_J:
                return KeyCode.KEY_J;
            case GLFW.GLFW_KEY_K:
                return KeyCode.KEY_K;
            case GLFW.GLFW_KEY_L:
                return KeyCode.KEY_L;
            case GLFW.GLFW_KEY_Y:
                return KeyCode.KEY_Y;
            case GLFW.GLFW_KEY_X:
                return KeyCode.KEY_X;
            case GLFW.GLFW_KEY_C:
                return KeyCode.KEY_C;
            case GLFW.GLFW_KEY_V:
                return KeyCode.KEY_V;
            case GLFW.GLFW_KEY_B:
                return KeyCode.KEY_B;
            case GLFW.GLFW_KEY_N:
                return KeyCode.KEY_N;
            case GLFW.GLFW_KEY_M:
                return KeyCode.KEY_M;
            case GLFW.GLFW_KEY_1:
                return KeyCode.KEY_1;
            case GLFW.GLFW_KEY_2:
                return KeyCode.KEY_2;
            case GLFW.GLFW_KEY_3:
                return KeyCode.KEY_3;
            case GLFW.GLFW_KEY_4:
                return KeyCode.KEY_4;
            case GLFW.GLFW_KEY_5:
                return KeyCode.KEY_5;
            case GLFW.GLFW_KEY_6:
                return KeyCode.KEY_6;
            case GLFW.GLFW_KEY_7:
                return KeyCode.KEY_7;
            case GLFW.GLFW_KEY_8:
                return KeyCode.KEY_8;
            case GLFW.GLFW_KEY_9:
                return KeyCode.KEY_9;
            case GLFW.GLFW_KEY_0:
                return KeyCode.KEY_0;
            case GLFW.GLFW_KEY_ESCAPE:
                return KeyCode.KEY_ESC;
            case GLFW.GLFW_KEY_SPACE:
                return KeyCode.KEY_SPACE;
        }
        Logging.warning("Unregistered key pressed: " + glfwKeyCode);
        return null;
    }

    public static KeyAction mapKeyAction(int glfwKeyAction) {
        switch (glfwKeyAction){
            case GLFW.GLFW_PRESS:
                return KeyAction.PRESSED;
            case GLFW.GLFW_RELEASE:
                return KeyAction.RELEASED;
            case GLFW.GLFW_REPEAT:
                return KeyAction.TYPED;
        }
        Logging.warning("Unregistered key action: " + glfwKeyAction);
        return null;
    }

    public static KeyCode mapMouseKey(int button) {
        switch (button){
            case GLFW.GLFW_MOUSE_BUTTON_LEFT:
                return KeyCode.MOUSE_LEFT;
            case GLFW.GLFW_MOUSE_BUTTON_RIGHT:
                return KeyCode.MOUSE_RIGHT;
            case GLFW.GLFW_MOUSE_BUTTON_MIDDLE:
                return KeyCode.MOUSE_MIDDLE;
        }
        Logging.warning("Unregistered key pressed: " + button);
        return null;
    }
}
