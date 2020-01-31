package ch.g_7.graphite.util;

import ch.g_7.util.helper.IOUtil;

public class Resources {


	public static final String UI_FRAGMENT_SHADER = loadShader("ui_fragment");
	public static final String UI_VERTEX_SHADER = loadShader("entity_vertex");
	
	public static final String ENTITY_FRAGMENT_SHADER = loadShader("entity_fragment");
	public static final String ENTITY_VERTEX_SHADER = loadShader("entity_vertex");

	public static final String DRAW_FRAGMENT_SHADER = loadShader("draw_fragment");
	public static final String DRAW_VERTEX_SHADER = loadShader("draw_vertex");
	
	
	private static String loadShader(String name) {
		return IOUtil.readInternalString("shaders/" + name + ".sp", new Object() {});
	}
}
