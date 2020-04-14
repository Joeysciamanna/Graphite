package ch.g_7.graphite.input;

public enum KeyCode {
    KEY_Q('q'),
    KEY_W('w'),
    KEY_E('e'),
    KEY_R('r'),
    KEY_T('t'),
    KEY_Z('z'),
    KEY_U('u'),
    KEY_I('i'),
    KEY_O('o'),
    KEY_P('p'),
    KEY_A('a'),
    KEY_S('s'),
    KEY_D('d'),
    KEY_F('f'),
    KEY_G('g'),
    KEY_H('h'),
    KEY_J('j'),
    KEY_K('k'),
    KEY_L('l'),
    KEY_Y('y'),
    KEY_X('x'),
    KEY_C('c'),
    KEY_V('v'),
    KEY_B('b'),
    KEY_N('n'),
    KEY_M('m'),
    KEY_1('1'),
    KEY_2('2'),
    KEY_3('3'),
    KEY_4('4'),
    KEY_5('5'),
    KEY_6('6'),
    KEY_7('7'),
    KEY_8('8'),
    KEY_9('9'),
    KEY_0('0'),
    KEY_ESC((char)27),
    KEY_SPACE(' '),


    MOUSE_LEFT('\0'),
    MOUSE_RIGHT('\0'),
    MOUSE_MIDDLE('\0');

    private char c;

    KeyCode(char c) {
        this.c = c;
    }

    char getChar(){
        return c;
    }
}
