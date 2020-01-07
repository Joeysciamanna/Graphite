package ch.g_7.graphite.util;

import ch.g_7.util.helper.IOUtil;
import ch.g_7.util.task.SecureRunner;

public class Resources {

	private final static Resources instance = new Resources();
	private final static SecureRunner<String, String> FILE_READER = new SecureRunner<>((s) -> IOUtil.readInternalString(s, instance));
	
	
	public static final String UI_FRAGMENT_SHADER_PATH = FILE_READER.apply("shaders/ui_fragment.sp");
	public static final String UI_VERTEX_SHADER_PATH = FILE_READER.apply("shaders/entity_vertex.sp");
	
	public static final String ENTITY_FRAGMENT_SHADER_PATH = FILE_READER.apply("shaders/entity_fragment.sp");
	public static final String ENTITY_VERTEX_SHADER_PATH = FILE_READER.apply("shaders/entity_vertex.sp");


}
