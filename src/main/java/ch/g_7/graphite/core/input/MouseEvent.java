package ch.g_7.graphite.core.input;

import ch.g_7.util.listener.StoreEvent;
import org.joml.Vector2ic;



public class MouseEvent extends StoreEvent<IInputAction<?>> {

    private final KeyCode keyCode;
    private final KeyAction action;

    private final Vector2ic position;

    public MouseEvent(KeyCode keyCode, KeyAction action, Vector2ic position) {
        super(InputAction.MOUSE);
        this.keyCode = keyCode;
        this.action = action;
        this.position = position;
    }

    public KeyCode getKeyCode() {
        return keyCode;
    }

    public KeyAction getAction() {
        return action;
    }

    public Vector2ic getPosition() {
        return position;
    }
}
