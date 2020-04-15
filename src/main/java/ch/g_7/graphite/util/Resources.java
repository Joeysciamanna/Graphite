package ch.g_7.graphite.util;


import ch.g_7.util.io.IOUtil;

public class Resources {


	public static final String UI_FRAGMENT_SHADER = loadShader("ui_fragment");
	public static final String UI_VERTEX_SHADER = loadShader("entity_vertex");
	
	public static final String ENTITY_FRAGMENT_SHADER = loadShader("entity_fragment");
	public static final String ENTITY_VERTEX_SHADER = loadShader("entity_vertex");

	public static final String JFXI_FRAGMENT_SHADER = loadShader("jfxi_fragment");
	public static final String JFXI_VERTEX_SHADER = loadShader("jfxi_vertex");

	private static String loadShader(String name) {
		return IOUtil.readInternalString("shaders/" + name + ".glsl", new Object() {});
	}
}
