package ch.g_7.graphite.core.input;

import ch.g_7.util.listener.StoreEvent;

public class KeyEvent extends StoreEvent<IInputAction<?>> {

    private final KeyCode keyCode;
    private final KeyAction action;

    public KeyEvent(KeyCode keyCode, KeyAction action) {
        super(InputAction.KEYBOARD);
        this.keyCode = keyCode;
        this.action = action;
    }


    public KeyCode getKeyCode() {
        return keyCode;
    }

    public KeyAction getAction() {
        return action;
    }
}
